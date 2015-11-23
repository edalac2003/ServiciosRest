package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.FacturaDAO;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.FactFacturaTipo;
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
				factura = new ObjetoFactura(maestroFactura, listaDetalles);
			}
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			
			session.close();
		}		
		return factura;
	}

	public List<FactFactura> listarTodasFacturas() throws ExcepcionesDAO {
		
		return null;
	}

	
	public List<FactFactura> listarFacturasxFecha(Date fechaInicio, Date fechaFin) throws ExcepcionesDAO {
		
		return null;
	}

	
	public List<ObjetoFactura> listarFacturasxTipo(FactFacturaTipo tipo) throws ExcepcionesDAO {
		/**
		 * Se hace este metodo de forma "coquito" para no perder el enfoque; lo mas optimo sería hacer una consultas con subconsultas anidadas o en su
		 * defecto proceder a realizar una consulta usando INNER JOIN.
		 */
		Session session = null;
		List<ObjetoFactura> listaFacturas = null;
		ObjetoFactura factura = null;
//		ObjetoFactura factura = null;
		
		try{
			session = getSession();
			Criteria criteria1 = session.createCriteria(FactFactura.class).add(Restrictions.eq("factFacturaTipo", tipo));
			/*
			 * Inicialmente se identifican los Maestros de Factura que coinciden con el criterio de busqueda.
			 */
			@SuppressWarnings("unchecked")
			List<FactFactura> listaMaestroFacturas = criteria1.list();
			listaFacturas = new ArrayList<ObjetoFactura>();
			if (listaMaestroFacturas != null){
				/*
				 * Si se encuentran registros, se procede a recorrer el Listado con los maestros hallados.
				 */
				for(FactFactura maestroFactura : listaMaestroFacturas){
					Criteria criteria2 = session.createCriteria(FactDetalleFactura.class).add(Restrictions.eq("factFactura", maestroFactura));
					/*
					 * Se buscan los detalles de factura por cada maestroFactura hallado.
					 */
					@SuppressWarnings("unchecked")
					List<FactDetalleFactura> listaDetallesMaestro = criteria2.list();
					factura = new ObjetoFactura(maestroFactura, listaDetallesMaestro);
				}
				listaFacturas.add(factura);
			}			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally {
			session.close();
		}		
		
		return listaFacturas;
	}

	
	public List<FactFactura> listarFacturasxTercero(ContTercero tercero) throws ExcepcionesDAO {
		
		return null;
	}
}
