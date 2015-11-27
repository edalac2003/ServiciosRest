package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.FacturaTipoDAO;
import co.weepa.smile.contabilidad.dto.FactDetalleFacturaTipo;
import co.weepa.smile.contabilidad.dto.FactFacturaTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class FacturaTipoDAOHibernate extends HibernateDaoSupport implements FacturaTipoDAO {
	
	private static Logger logger = Logger.getLogger(FacturaTipoDAOHibernate.class);
		
	
	public FactFacturaTipo obtenerTipoFactura(int idTipoFactura) throws ExcepcionesDAO {
		FactFacturaTipo tipoFactura = null;
		Session session = null;
		String sql = "SELECT * FROM fact_factura_tipo where IDFACTURA_TIPO = "+ idTipoFactura+";";
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(FactFacturaTipo.class).add(Restrictions.eq("idfacturaTipo", idTipoFactura));
			tipoFactura = (FactFacturaTipo)criteria.uniqueResult();
//			Query query = session.createSQLQuery(sql);
//			tipoFactura = (FactFacturaTipo)query.uniqueResult();
		}catch(HibernateException e){
			logger.error("Se presentaron Errores la intentar obtener el Tipo de Factura. ");
			ExcepcionesDAO expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores la intentar obtener el Tipo de Factura. ");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return tipoFactura;
	}

	
	@SuppressWarnings("unchecked")
	public List<FactFacturaTipo> listarTipoFactura() throws ExcepcionesDAO {
		List<FactFacturaTipo> lista = null;
		Session session = null;
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(FactFacturaTipo.class);
			lista = criteria.list();
		}catch(HibernateException e){
			logger.error("Se presentaron errores al intentar generar la lista de Tipos de Factura."+e.getMessage());
			ExcepcionesDAO expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico("Error listado Tipo Factura : "+ e.getMessage());
			expDao.setMensajeUsuario("Se presentaron errores al intentar generar la lista de Tipos de Factura.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return lista;
	}


	public FactDetalleFacturaTipo obtenerTipoDetalleFactura(int idTipoDetalle) throws ExcepcionesDAO {
		FactDetalleFacturaTipo tipoDetalleFactura = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(FactDetalleFacturaTipo.class).add(Restrictions.eq("iddetalleFacturaTipo", idTipoDetalle));
			tipoDetalleFactura = (FactDetalleFacturaTipo)criteria.uniqueResult();
		}catch(HibernateException e){
			logger.info("Se presentaron Errores la intentar obtener el Tipo de Detalle Factura. ");
			ExcepcionesDAO expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores la intentar obtener el Tipo de Detalle Factura.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		
		return tipoDetalleFactura;
	}
}
