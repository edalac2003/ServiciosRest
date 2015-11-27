package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.FacturaDAO;
import co.weepa.smile.contabilidad.dao.TerceroDAO;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.FactFacturaTipo;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoCotizacion;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoFactura;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class FacturaDAOHibernate extends HibernateDaoSupport implements FacturaDAO{

	public int consecutivoFactura(FactFacturaTipo tipoFactura) throws ExcepcionesDAO {
		int registros = 0;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(FactFactura.class).add(Restrictions.like("factFacturaTipo", tipoFactura));
			registros = criteria.list().size();
		}catch(HibernateException e){
			ExcepcionesDAO expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico("Error : "+e.getMessage());
			expDao.setMensajeUsuario("Se presentaron errores al intentar asignar un Consecutivo al Documento.");
			expDao.setOrigen(e);
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		return registros;
	}

	
	@SuppressWarnings("unchecked")
	public ObjetoFactura obtenerFactura(String numeroFactura) throws ExcepcionesDAO {
		Session session = null;
		ObjetoFactura factura = null;
		FactFactura maestroFactura = null;
		List<FactDetalleFactura> listaDetalles = null;
		
		try{
			session = getSession();
			Criteria criteria1 = session.createCriteria(FactFactura.class).add(Restrictions.eq("dsnumeroFactura", numeroFactura));
			maestroFactura = (FactFactura)criteria1.uniqueResult();
			if (maestroFactura != null){
				Criteria criteria2 = session.createCriteria(FactDetalleFactura.class).add(Restrictions.eq("factFactura", maestroFactura));
				listaDetalles = criteria2.list();
//				factura = new ObjetoFactura(maestroFactura, listaDetalles);
			}
		}catch(HibernateException e){
			ExcepcionesDAO expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico("Error : "+e.getMessage());
			expDao.setMensajeUsuario("Se presentaron errores al intentar obtener la información de Factura.");
			expDao.setOrigen(e);
			throw new ExcepcionesDAO(e);
		}finally{
			
			session.close();
		}		
		return factura;
	}
	
	
	@Override
	public FactFactura obtenerMaestroDocumento(String numeroFactura) throws ExcepcionesDAO {
		Session session = null;
		FactFactura maestroFactura = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(FactFactura.class).add(Restrictions.eq("dsnumeroFactura", numeroFactura));
			maestroFactura = (FactFactura)criteria.uniqueResult();
		}catch(HibernateException e){
			ExcepcionesDAO expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico("Error : "+e.getMessage());
			expDao.setMensajeUsuario("Se presentaron errores al intentar obtener el Maestro del Documento.");
			expDao.setOrigen(e);
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return maestroFactura;
	}


	public List<FactFactura> listarTodasFacturas() throws ExcepcionesDAO {		
		return null;
	}

	
	public List<FactFactura> listarFacturasxFecha(Date fechaInicio, Date fechaFin) throws ExcepcionesDAO {
		
		return null;
	}

	
	public List<FactFactura> listarFacturasxTipo(FactFacturaTipo tipo) throws ExcepcionesDAO {
		/**
		 * Se hace este metodo de forma "coquito" para no perder el enfoque; lo mas optimo serÃ­a hacer una consultas con subconsultas anidadas o en su
		 * defecto proceder a realizar una consulta usando INNER JOIN.
		 */
		Session session = null;
		List<FactFactura> listaFacturas = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(FactFactura.class).add(Restrictions.eq("factFacturaTipo", tipo));
			listaFacturas = criteria.list();
		}catch(HibernateException e){
			ExcepcionesDAO expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron errores al Momento de intentar Obtener el Listado de Factura por Tipo");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}		
		return listaFacturas;
	}

	
	public List<FactFactura> listarFacturasxTercero(ContTercero tercero) throws ExcepcionesDAO {		
		return null;
	}


	@Override
	public ObjetoCotizacion obtenerCotizacion(String numeroCotizacion) throws ExcepcionesDAO {
		return null;
	}


//	@Override
//	public List<ObjetoCotizacion> listarCotizaciones(FactFacturaTipo tipoFactura) throws ExcepcionesDAO {

//	}
	
	@Override
	public List<ObjetoCotizacion> listarCotizaciones(FactFacturaTipo tipoDocumento) throws ExcepcionesDAO {
		List<ObjetoCotizacion> listaCotizacion = null;
		List<FactFactura> listaMaestroDocumento = null;		
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(FactFactura.class).add(Restrictions.eq("factFacturaTipo", tipoDocumento));
			listaMaestroDocumento = criteria.list();
		}catch(HibernateException e){
			ExcepcionesDAO expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron errores al Momento de intentar Obtener el Listado de Factura por Tipo");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		if(listaMaestroDocumento != null){
			listaCotizacion = new ArrayList<ObjetoCotizacion>();
			ContTercero tercero = null;
			for(FactFactura maestro : listaMaestroDocumento){
				ObjetoCotizacion cotizacion = new ObjetoCotizacion();
				cotizacion.setMaestroCotizacion(maestro);
				listaCotizacion.add(cotizacion);
			}
		}
		
		return listaCotizacion;
	}


	
	@Override
	public List<FactDetalleFactura> listarDetallesDocumento(FactFactura documento) throws ExcepcionesDAO {
		List<FactDetalleFactura> listadetalles = null;
		Session session = null;
		String sql="from FactDetalleFactura where factFactura = :documento";
		
		try{
			session = getSession();
//			Criteria criteria = session.createCriteria(FactDetalleFactura.class);
//			listadetalles = criteria.list();
			Query query = session.createQuery("from FactDetalleFactura where factFactura = :documento");
			query.setEntity("documento", documento);
			listadetalles = query.list();
			
		}catch(HibernateException e){
			ExcepcionesDAO expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron errores al intentar Obtener el Listado de Detalle Factura.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return listadetalles;
	}	
	
}
