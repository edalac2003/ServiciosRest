package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.CiudadDAO;
import co.weepa.smile.contabilidad.dto.DefiCiudad;
import co.weepa.smile.contabilidad.dto.DefiDepartamento;
import co.weepa.smile.contabilidad.dto.DefiPais;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class CiudadDAOHibernate extends HibernateDaoSupport implements CiudadDAO {

	public DefiPais obtenerPais(int idPais) throws ExcepcionesDAO {
		DefiPais pais = null;
		Session session = null;
		
		try{
//			session = FactoriaSession.getSessionFactory().openSession();
			session = getSession();
			Criteria criteria = session.createCriteria(DefiPais.class).add(Restrictions.eq("idPais", idPais));
			pais = (DefiPais) criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return pais;
	}

	public DefiDepartamento obtenerDepartamento(int idDepartamento) throws ExcepcionesDAO {
		DefiDepartamento departamento = null;
		Session session = null;
		try{
//			session = FactoriaSession.getSessionFactory().openSession();
			session = getSession();
			Criteria criteria = session.createCriteria(DefiDepartamento.class).add(Restrictions.eq("idDepartamento", idDepartamento));
			departamento = (DefiDepartamento)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return departamento;
	}

	public DefiCiudad obtenerCiudad(int idCiudad) throws ExcepcionesDAO {
		DefiCiudad ciudad = null;
		Session session = null;
		
		try{
//			session = FactoriaSession.getSessionFactory().openSession();
			session = getSession();
			Criteria criteria = session.createCriteria(DefiCiudad.class).add(Restrictions.eq("idciudad", idCiudad));
			ciudad = (DefiCiudad)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		return ciudad;
	}
	

	@SuppressWarnings("unchecked")
	public List<DefiPais> listarPaises() throws ExcepcionesDAO {
		List<DefiPais> listaPaises = null;
		Session session = null;
		try{
//			session = FactoriaSession.getSessionFactory().openSession();
			session = getSession();
			Criteria criteria = session.createCriteria(DefiPais.class);
			listaPaises = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		
		return listaPaises;
	}

	@SuppressWarnings("unchecked")
	public List<DefiDepartamento> listarDepartamentos() throws ExcepcionesDAO {
		List<DefiDepartamento> listaDepartamentos = null;
		Session session = null;
		
		try{
//			session = FactoriaSession.getSessionFactory().openSession();
			session = getSession();
			Criteria criteria = session.createCriteria(DefiDepartamento.class);
			listaDepartamentos = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return listaDepartamentos;
	}

	@SuppressWarnings("unchecked")
	public List<DefiCiudad> listarCiudades() throws ExcepcionesDAO {
		List<DefiCiudad> listaCiudades = null;
		Session session = null;
		
		try{
//			session = FactoriaSession.getSessionFactory().openSession();
			session = getSession();
			Criteria criteria = session.createCriteria(DefiCiudad.class);
			listaCiudades = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return listaCiudades;
	}

	@SuppressWarnings("unchecked")
	public List<DefiCiudad> listarCiudades(DefiDepartamento departamento) throws ExcepcionesDAO {
		List<DefiCiudad> listaCiudad = null;
		Session session = null;
		
		try{
//			session = FactoriaSession.getSessionFactory().openSession();
			session = getSession();
			Query query = session.createQuery("from DefiCiudad where defiDepartamento = :departamento");
			query.setEntity("departamento", departamento);
			listaCiudad = query.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
				
		return listaCiudad;
	}

}
