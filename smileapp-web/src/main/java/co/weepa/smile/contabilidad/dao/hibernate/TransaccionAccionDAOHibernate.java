package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.TransaccionAccionDAO;
import co.weepa.smile.contabilidad.dto.ContOrganizacionInterna;
import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.dto.DefiTransaccionAccion;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class TransaccionAccionDAOHibernate extends HibernateDaoSupport implements TransaccionAccionDAO {

	@SuppressWarnings("unchecked")
	public List<DefiTransaccionAccion> listaCuentasxTransaccion(ContOrganizacionInterna organizacion,
			ContTransaccionTipo tipoTx) throws ExcepcionesDAO {
		List<DefiTransaccionAccion> listaCuentas = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(DefiTransaccionAccion.class).add(Restrictions.eq("contOrganizacionInterna", organizacion))
					.add(Restrictions.eq("contTransaccionTipo", tipoTx));
			listaCuentas = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		return listaCuentas;
	}

}
