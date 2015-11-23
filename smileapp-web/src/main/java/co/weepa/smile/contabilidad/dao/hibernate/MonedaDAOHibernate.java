package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.MonedaDAO;
import co.weepa.smile.contabilidad.dto.ContMoneda;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class MonedaDAOHibernate extends HibernateDaoSupport implements MonedaDAO {

	public ContMoneda obtenerMoneda(int idMoneda) throws ExcepcionesDAO {
		Session session = null;
		ContMoneda moneda = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ContMoneda.class).add(Restrictions.eq("idmoneda", idMoneda));
			moneda = (ContMoneda)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return moneda;
	}

	
	@SuppressWarnings("unchecked")
	public List<ContMoneda> listarMonedas() throws ExcepcionesDAO {
		Session session = null;
		List<ContMoneda> listaMonedas = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ContMoneda.class);
			listaMonedas = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally {
			session.close();
		}
		
		return listaMonedas;
	}

}
