package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.PlanCuentaDAO;
import co.weepa.smile.contabilidad.dto.ContCuentaGrupo;
import co.weepa.smile.contabilidad.dto.ContPlanCuenta;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class PlanCuentaDAOHibernate extends HibernateDaoSupport implements PlanCuentaDAO {

	public void guardarCuentaPUC(List<ContPlanCuenta> listaCuentas) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		try{
			session = getSession();
			tx = session.beginTransaction();
			for(ContPlanCuenta cuenta : listaCuentas){
				session.save(cuenta);
			}
			
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			throw new ExcepcionesDAO("Se presentaron errores al intentar guardar registro de Cuentas. Error : "+e.toString());
		}finally{
			session.close();
		}		
	}

	
	public void guardarGrupoCuenta(List<ContCuentaGrupo> listaGrupos) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			for(ContCuentaGrupo grupo : listaGrupos){
				session.save(grupo);
			}
			
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			throw new ExcepcionesDAO("Se presentaron errores al intentar guardar registro de Grupo de Cuentas. Error : "+e.toString());
		}finally{
			session.close();
		}		
	}
	

	public ContPlanCuenta obtenerCuentaPUC(int idCuenta) throws ExcepcionesDAO {
		ContPlanCuenta cuenta = null;
//		Session session = null;
//		try{
//			session = getSession();
//			Criteria criteria = session.createCriteria(ContPlanCuenta.class).add(Restrictions.eq("idcuenta", idCuenta));
//			cuenta = (ContPlanCuenta)criteria.uniqueResult();
//		}catch(HibernateException e){
//			throw new ExcepcionesDAO(e);
//		}finally{
//			session.close();
//		}
		
		return cuenta;
	}

	public ContCuentaGrupo obtenerGrupoCuenta(int idGrupo) throws ExcepcionesDAO {
		ContCuentaGrupo grupoCuenta = null;
//		Session session = null;
		
//		try{
//			session = getSession();
//			Criteria criteria = session.createCriteria(ContCuentaGrupo.class).add(Restrictions.eq("idcuentaGrupo", idGrupo));
//			grupoCuenta = (ContCuentaGrupo)criteria.uniqueResult();
//		}catch(HibernateException e){
//			throw new ExcepcionesDAO("Se presentaron errores al intentar obtener registro de Cuenta. Error : "+e.toString());
//		}finally{
//			session.close();
//		}
		
		
		return grupoCuenta;
	}

	public List<ContCuentaGrupo> listarTodosGruposCuenta() throws ExcepcionesDAO {
		List<ContCuentaGrupo> listaGruposCuenta = null;
//		Session session = null;
//		
//		try{
//			session = getSession();
//			Criteria criteria = session.createCriteria(ContCuentaGrupo.class);
//			listaGruposCuenta = criteria.list();
//		}catch(HibernateException e){
//			throw new ExcepcionesDAO(e);
//		}finally{
//			session.close();
//		}
		
		return listaGruposCuenta;
	}

	public List<ContPlanCuenta> listarTodoPUC() throws ExcepcionesDAO {
		List<ContPlanCuenta> listaPUC = null;
//		Session session = null;
//		
//		try{
//			session = getSession();
//			Criteria criteria = session.createCriteria(ContPlanCuenta.class);
//			listaPUC = criteria.list();
//		}catch(HibernateException e){
//			throw new ExcepcionesDAO(e);
//		}finally{
//			session.close();
//		}
		
		return listaPUC;
	}

	public List<ContPlanCuenta> listarCuentasxGrupo(ContCuentaGrupo grupoCuenta) throws ExcepcionesDAO {
		List<ContPlanCuenta> listaCuentas = null;
//		Session session = null;
//		
//		try{
//			session = getSession();
//			Criteria criteria = session.createCriteria(ContPlanCuenta.class).add(Restrictions.like("contCuentaGrupo", grupoCuenta));
//			listaCuentas = criteria.list();
//		}catch(HibernateException e){
//			throw new ExcepcionesDAO(e);
//		}finally{
//			session.close();
//		}
		
		return listaCuentas;
	}

}