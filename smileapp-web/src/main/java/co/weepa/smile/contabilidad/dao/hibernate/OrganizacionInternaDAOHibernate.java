package co.weepa.smile.contabilidad.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.OrganizacionInternaDAO;
import co.weepa.smile.contabilidad.dto.ContOrganizacionInterna;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class OrganizacionInternaDAOHibernate extends HibernateDaoSupport implements OrganizacionInternaDAO {

	public ContOrganizacionInterna obtenerOrganizacion(int idOrganizacion) throws ExcepcionesDAO {
		ContOrganizacionInterna organizacion = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ContOrganizacionInterna.class).add(Restrictions.eq("idorganizacionInterna", idOrganizacion));
			organizacion = (ContOrganizacionInterna)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return organizacion;
	}

}
