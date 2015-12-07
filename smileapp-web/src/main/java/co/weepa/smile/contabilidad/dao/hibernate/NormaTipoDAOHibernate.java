package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.NormaTipoDAO;
import co.weepa.smile.contabilidad.dto.ContNormaTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class NormaTipoDAOHibernate extends HibernateDaoSupport implements NormaTipoDAO {
	
	ExcepcionesDAO expDao;

	public ContNormaTipo obtenerTipoNorma(String idTipo) throws ExcepcionesDAO {
		ContNormaTipo tipoNorma = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ContNormaTipo.class).add(Restrictions.eq("idnormaTipo", idTipo));
			tipoNorma = (ContNormaTipo)criteria.uniqueResult();
				
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas al Obtener el Registro de Tipo Norma Contable.");
			expDao.setOrigen(e);
			throw expDao;
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
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas al Obtener el Listado de Tipo Norma Contable.");
			expDao.setOrigen(e);
		}finally {
			session.close();
		}
		
		return listaTipoNorma;
	}

}
