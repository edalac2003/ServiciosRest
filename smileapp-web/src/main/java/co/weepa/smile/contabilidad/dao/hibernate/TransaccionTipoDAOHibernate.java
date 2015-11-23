package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.TransaccionTipoDAO;
import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class TransaccionTipoDAOHibernate extends HibernateDaoSupport implements TransaccionTipoDAO {

	public ContTransaccionTipo obtenerTipoTransaccion(int idTipoTx) throws ExcepcionesDAO {
		Session session = null;
		ContTransaccionTipo tipoTx = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ContTransaccionTipo.class).add(Restrictions.eq("idtransaccionTipo", idTipoTx));		
			tipoTx = (ContTransaccionTipo)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
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
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return lista;
	}

	
}
