package co.weepa.smile.contabilidad.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.TerceroCuentaDAO;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.TercTerceroCuenta;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class TerceroCuentaDAOHibernate extends HibernateDaoSupport implements TerceroCuentaDAO {

	public TercTerceroCuenta obtenerTransaccionxTercero(ContTercero tercero) throws ExcepcionesDAO {
		TercTerceroCuenta terceroCuenta = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TercTerceroCuenta.class).add(Restrictions.eq("contTercero", tercero));
			terceroCuenta = (TercTerceroCuenta)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		return terceroCuenta;
	}

}
