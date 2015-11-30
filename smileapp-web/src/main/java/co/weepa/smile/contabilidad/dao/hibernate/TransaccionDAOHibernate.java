package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.zkoss.bind.sys.SaveBinding;

import co.weepa.smile.contabilidad.dao.TransaccionDAO;
import co.weepa.smile.contabilidad.dto.ContDetalleTransaccion;
import co.weepa.smile.contabilidad.dto.ContTransaccionContable;
import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoCartera;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class TransaccionDAOHibernate extends HibernateDaoSupport implements TransaccionDAO {

	ExcepcionesDAO expDao = null;
	


	@Override
	public void guardarCartera(ObjetoCartera cartera, ContTransaccionContable transaccion,
			List<ContDetalleTransaccion> listaDetalleTransaccion) throws ExcepcionesDAO {
		
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			
			session.save(cartera);
			
			session.save(transaccion);
			
			for(ContDetalleTransaccion detalle : listaDetalleTransaccion){
				session.save(detalle);
			}		
			
			tx.commit();
			expDao.setMensajeUsuario("Registro Guardado Satisfactoriamente.");
			throw expDao;
			
		}catch(HibernateException e){
			tx.rollback();
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas para guardar los registros de Cartera y la transaccion Contable.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		
	}


	@Override
	public int consecutivoTransaccionxTipo(ContTransaccionTipo tipo) throws ExcepcionesDAO {
		int consecutivo = 0;
		Session session = null;
		
		
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ContTransaccionContable.class).add(Restrictions.eq("contTransaccionTipo", tipo));
			consecutivo = criteria.list().size();
			consecutivo++;
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas para generar el Consecutivo del Documento.");
			expDao.setOrigen(e);
			throw expDao;
		}finally {
			session.close();
		}		
		return consecutivo;
	}
	
	
	public ContTransaccionTipo obtenerTipoTransaccion(int idTipoTx) throws ExcepcionesDAO {
		Session session = null;
		ContTransaccionTipo tipoTx = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ContTransaccionTipo.class).add(Restrictions.eq("idtransaccionTipo", idTipoTx));		
			tipoTx = (ContTransaccionTipo)criteria.uniqueResult();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas para obtener el Tipo de Transaccion.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}		
		return tipoTx;
	}

	
	@SuppressWarnings("unchecked")
	public List<ContTransaccionTipo> listarTipoTransacciones() throws ExcepcionesDAO {
		Session session = null;
		List<ContTransaccionTipo> lista = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ContTransaccionTipo.class);
			lista = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas para obtener el Listado de Tipo de Transacciones.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}		
		return lista;
	}
}
