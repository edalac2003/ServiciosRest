package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.NormaTipoDAO;
import co.weepa.smile.contabilidad.dto.ContNormaTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class NormaTipoDAOHibernate extends HibernateDaoSupport implements NormaTipoDAO {

	public ContNormaTipo obtenerTipoNorma(int idTipo) throws ExcepcionesDAO {
		ContNormaTipo tipoNorma = null;
		Session session = null;
		
		try{
//			session = FactoriaSession.getSessionFactory().openSession();
			session = getSession();
			Query query = session.createQuery("from ContNormaTipo where idnormaTipo = idTipo");
			query.setParameter("idTipo", idTipo);
			tipoNorma = (ContNormaTipo) query.uniqueResult();
				
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return tipoNorma;
	}

	@SuppressWarnings("unchecked")
	public List<ContNormaTipo> listarTodo() throws ExcepcionesDAO {
		List<ContNormaTipo> listaTipoNorma = null;
		Session session = null;
		
		try{
//			session = FactoriaSession.getSessionFactory().openSession();
			session = getSession();
			Criteria criteria = session.createCriteria(ContNormaTipo.class);
			listaTipoNorma = criteria.list();			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally {
			session.close();
		}
		
		return listaTipoNorma;
	}

}
