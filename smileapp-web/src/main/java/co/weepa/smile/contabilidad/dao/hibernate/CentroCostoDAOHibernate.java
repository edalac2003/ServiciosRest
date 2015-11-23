package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.CentroCostoDAO;
import co.weepa.smile.contabilidad.dto.ContCentroCosto;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class CentroCostoDAOHibernate extends HibernateDaoSupport implements CentroCostoDAO {

	public ContCentroCosto obtenerCentroCosto(int idCentroCosto) throws ExcepcionesDAO {
		ContCentroCosto centroCosto = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ContCentroCosto.class).add(Restrictions.eq("idcentroCosto", idCentroCosto));
			centroCosto = (ContCentroCosto)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally {
			session.close();
		}
		
		return centroCosto;
	}

	
	@SuppressWarnings("unchecked")
	public List<ContCentroCosto> listarCentroCosto() throws ExcepcionesDAO {
		Session session = null;
		List<ContCentroCosto> lista = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ContCentroCosto.class);
			lista = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		return lista;
	}	
}
