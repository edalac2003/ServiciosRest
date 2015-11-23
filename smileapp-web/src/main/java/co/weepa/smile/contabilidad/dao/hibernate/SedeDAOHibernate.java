package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.SedeDAO;
import co.weepa.smile.contabilidad.dto.ContOrganizacionInterna;
import co.weepa.smile.contabilidad.dto.DefiSede;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class SedeDAOHibernate extends HibernateDaoSupport implements SedeDAO {

	public DefiSede obtenerSede(int idSede) throws ExcepcionesDAO {
		Session session = null;
		DefiSede sede = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(DefiSede.class).add(Restrictions.eq("idsede", idSede));
			sede = (DefiSede)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		return sede;
	}

	public List<DefiSede> listarSedexOrganizacion(ContOrganizacionInterna organizacion) throws ExcepcionesDAO {
		return null;
	}

}
