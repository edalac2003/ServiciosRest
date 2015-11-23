package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.CarteraDAO;
import co.weepa.smile.contabilidad.dto.CartEstado;
import co.weepa.smile.contabilidad.dto.CartFormaPago;
import co.weepa.smile.contabilidad.dto.CartTipoPago;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class CarteraDAOHibernate extends HibernateDaoSupport implements CarteraDAO {
	
	final static Logger logger = Logger.getLogger(CarteraDAOHibernate.class);

	
	public CartTipoPago obtenerTipoPago(int idTipoPago) throws ExcepcionesDAO {
		CartTipoPago tipoPago = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(CartTipoPago.class).add(Restrictions.eq("idtipoPago", idTipoPago));
			tipoPago = (CartTipoPago)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
				
		return tipoPago;
	}

	public CartFormaPago obtenerFormaPago(int idFormaPago) throws ExcepcionesDAO {
		CartFormaPago formaPago = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(CartFormaPago.class).add(Restrictions.eq("idformaPago", idFormaPago));
			formaPago = (CartFormaPago)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}	
		
		return formaPago;
	}

	public CartEstado obtenerEstadoCartera(int idEstadoCartera) throws ExcepcionesDAO {
		CartEstado estadoCartera = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(CartEstado.class).add(Restrictions.eq("idestado", idEstadoCartera));
			estadoCartera = (CartEstado)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return estadoCartera;
	}

	
	@SuppressWarnings("unchecked")
	public List<CartTipoPago> listarTipoPago() throws ExcepcionesDAO {
		List<CartTipoPago> listaTipoPago = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(CartTipoPago.class);
			listaTipoPago = criteria.list();
			logger.info("La lista de Tipo de Pago Cartera se Generó correctamente.");
		}catch(HibernateException e){
			logger.error("Ocurrió un Error al generar Lista de Tipo de Pago Cartera. Error : "+e.getMessage());
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return listaTipoPago;
	}

	
	@SuppressWarnings("unchecked")
	public List<CartFormaPago> listarFormaPago() throws ExcepcionesDAO {
		List<CartFormaPago> listaFormaPago = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(CartFormaPago.class);
			listaFormaPago = criteria.list();
			logger.info("La lista de Forma de Pago Cartera se Generó correctamente.");
		}catch(HibernateException e){
			logger.error("Ocurrió un Error al generar Lista de Forma de Pago Cartera. Error : "+e.getMessage());
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return listaFormaPago;
	}

	
	@SuppressWarnings("unchecked")
	public List<CartEstado> listarEstadoCartera() throws ExcepcionesDAO {
		List<CartEstado> listaEstadoCartera = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(CartEstado.class);
			listaEstadoCartera = criteria.list();
			logger.info("La lista Estado Cartera se Generó correctamente.");
		}catch(HibernateException e){
			logger.error("Ocurrió un Error al generar Lista Estado Cartera. Error : "+e.getMessage());
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return listaEstadoCartera;
	}

}
