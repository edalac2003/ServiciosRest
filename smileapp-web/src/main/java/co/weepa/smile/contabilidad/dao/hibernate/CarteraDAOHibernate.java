package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.CarteraDAO;
import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartEstado;
import co.weepa.smile.contabilidad.dto.CartFormaPago;
import co.weepa.smile.contabilidad.dto.CartTipoPago;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class CarteraDAOHibernate extends HibernateDaoSupport implements CarteraDAO {
	
	final static Logger logger = Logger.getLogger(CarteraDAOHibernate.class);
	ExcepcionesDAO expDao = null;
	
	
	@SuppressWarnings("deprecation")
	@Override
	public CartCartera obtenerMaestroCartera(int idCartera) throws ExcepcionesDAO {
		Session session = null;
		CartCartera cartera = null;
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(CartCartera.class).add(Restrictions.eq("idcartera", idCartera));
			cartera = (CartCartera)criteria.uniqueResult();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener el Registro de Cartera.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return cartera;
	}
	

	@Override
	public CartCartera obtenerMaestroCarteraxFactura(FactFactura factura) throws ExcepcionesDAO {
		CartCartera cartera = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(CartCartera.class).add(Restrictions.eq("factFactura", factura));
			cartera = (CartCartera)criteria.uniqueResult();
			
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener el Registro de Cartera.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return cartera;
	}



	public CartTipoPago obtenerTipoPago(int idTipoPago) throws ExcepcionesDAO {
		CartTipoPago tipoPago = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(CartTipoPago.class).add(Restrictions.eq("idtipoPago", idTipoPago));
			tipoPago = (CartTipoPago)criteria.uniqueResult();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener el Registro de Tipo Pago.");
			expDao.setOrigen(e);
			throw expDao;
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
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener el Registro de Forma Pago.");
			expDao.setOrigen(e);
			throw expDao;
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
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener el Registro de Estado Cartera.");
			expDao.setOrigen(e);
			throw expDao;
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
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener el listado de Tipo de Pago.");
			expDao.setOrigen(e);
			throw expDao;
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
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener el Listado de Forma de Pago.");
			expDao.setOrigen(e);
			throw expDao;
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
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al intentar obtener el listado de estado de Cartera.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return listaEstadoCartera;
	}

}
