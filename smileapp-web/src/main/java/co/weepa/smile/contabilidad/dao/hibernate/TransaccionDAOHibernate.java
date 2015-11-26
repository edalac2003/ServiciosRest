package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.TransaccionDAO;
import co.weepa.smile.contabilidad.dto.ContTransaccionContable;
import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class TransaccionDAOHibernate extends HibernateDaoSupport implements TransaccionDAO {

	ExcepcionesDAO expDao = null;
	
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
