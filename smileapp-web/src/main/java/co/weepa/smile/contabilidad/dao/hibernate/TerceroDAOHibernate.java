package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.TerceroDAO;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.ContTipoTercero;
import co.weepa.smile.contabilidad.dto.TercOrganizacion;
import co.weepa.smile.contabilidad.dto.TercPersona;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class TerceroDAOHibernate extends HibernateDaoSupport implements TerceroDAO {

	final static Logger logger = Logger.getLogger(TerceroDAOHibernate.class);
	
	public void guardarTercero(ContTercero tercero) throws ExcepcionesDAO {
		Session session = null;
		
		try{
//			session = FactoriaSession.getSessionFactory().openSession();
			session = getSession();
			session.beginTransaction();
			session.save(tercero);
			
			session.getTransaction().commit();
			
		}catch(HibernateException e){
			session.getTransaction().rollback();
			throw new ExcepcionesDAO("Se presentaron errores al intentar guardar registro de Cuentas. Error : "+e.toString());
		}finally{
			session.close();
		}		
	}


	public void modificarTercero(ContTercero tercero) throws ExcepcionesDAO {
		Session session = null;
		
		try{
//			session = FactoriaSession.getSessionFactory().openSession();
			session = getSession();
			session.beginTransaction();
			session.update(tercero);			
			session.getTransaction().commit();
			
		}catch(HibernateException e){
			logger.error(e);
			session.getTransaction().rollback();
			throw new ExcepcionesDAO("Se presentaron errores al intentar guardar registro de Cuentas. Error : "+e.toString());
		}finally{
			session.close();
		}		
	}


	public ContTercero obtenerTercero(long idTercero) throws ExcepcionesDAO {
		ContTercero tercero = null;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ContTercero.class).add(Restrictions.eq("idtercero", idTercero));
			tercero = (ContTercero) criteria.uniqueResult();
		}catch(HibernateException e){
			ExcepcionesDAO expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico("Error en Dao : " + e.getMessage().toString());
			expDao.setMensajeUsuario("Se presentaron errores al intentar consultar registro de Tercero.");
			expDao.setOrigen(e);
			logger.error(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return tercero;
	}

	public ContTercero obtenerTercero(String idTercero, ContTipoTercero tipoTercero) throws ExcepcionesDAO {
		ContTercero tercero = null;
		Session session = null;
		
		try{
//			session = FactoriaSession.getSessionFactory().openSession();
			session = getSession();
			Criteria criteria = session.createCriteria(ContTercero.class).add(Restrictions.eq("dsidentificacion", idTercero))
					.add(Restrictions.eq("contTipoTercero", tipoTercero));
			tercero = (ContTercero) criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionesDAO("Se presentaron errores al intentar consultar registro de Tercero. Error : "+e.toString());
		}finally{
			session.close();
		}
		
		return tercero;
	}

	@SuppressWarnings("unchecked")
	public List<ContTercero> listarTodos() throws ExcepcionesDAO {
		List<ContTercero> listaTercero = null;
		Session session = null;
		
		try{
//			session = FactoriaSession.getSessionFactory().openSession();
			session = getSession();
			Criteria criteria = session.createCriteria(ContTercero.class);
			listaTercero = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}finally{
			session.close();
		}
		
		return listaTercero;
	}

	@SuppressWarnings("unchecked")
	public List<ContTercero> listarTerceroxTipo(ContTipoTercero tipoTercero) throws ExcepcionesDAO {
		List<ContTercero> listaTercero = null;
		Session session = null;
		
		try{
//			session = FactoriaSession.getSessionFactory().openSession();
			session = getSession();
			Criteria criteria = session.createCriteria(ContTercero.class).add(Restrictions.eq("contTipoTercero", tipoTercero));
			listaTercero = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}finally{
			session.close();
		}
		
		return listaTercero;
	}

	
	
	/**
	 * Metodos para los detalles de los Terceros tanto Natural como Juridico.
	 */
	

	public TercPersona obtenerPersonaNatural(int idPersona) throws ExcepcionesDAO {
		Session session = null;
		TercPersona persona = null;
		
		try{
			session=getSession();
			Criteria criteria = session.createCriteria(TercPersona.class).add(Restrictions.eq("idpersona", idPersona));
			persona = (TercPersona)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return persona;
	}


	public TercOrganizacion obtenerPersonaJuridica(int idOrganizacion) throws ExcepcionesDAO {
		Session session = null;
		TercOrganizacion organizacion = null;
		
		try{
			session=getSession();
			Criteria criteria = session.createCriteria(TercOrganizacion.class).add(Restrictions.eq("idorganizacion", idOrganizacion));
			organizacion = (TercOrganizacion)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return organizacion;
	}


	@SuppressWarnings("unchecked")
	public List<TercPersona> listarPersonasNaturales() throws ExcepcionesDAO {
		Session session = null;
		List<TercPersona> lista = null;
		
		try{
			session=getSession();
			Criteria criteria = session.createCriteria(TercPersona.class);
			lista = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return lista;
	}


	@SuppressWarnings("unchecked")
	public List<TercOrganizacion> listarOrganizaciones() throws ExcepcionesDAO {
		Session session = null;
		List<TercOrganizacion> lista = null;
		
		try{
			session=getSession();
			Criteria criteria = session.createCriteria(TercOrganizacion.class);
			lista = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		return lista;
	}


	@Override
	public List<TercPersona> listarVendedores() throws ExcepcionesDAO {
		List<TercPersona> lista = null;
		Session session = null;
		String sql = "SELECT * FROM terc_persona INNER JOIN cont_tercero ON (terc_persona.IDPERSONA = cont_tercero.IDTERCERO) "+
					"INNER JOIN terc_tercero_rol ON (terc_tercero_rol.IDTERCERO = cont_tercero.IDTERCERO) WHERE terc_tercero_rol.IDROL_TIPO = 4;";
		
		try{
			session = getSession();
			Query query = session.createSQLQuery(sql);
			lista = query.list();
			
		}catch(HibernateException e){
			ExcepcionesDAO expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico("Errores al Listar Empleados. DAO : "+e.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas al obtener listado de Vendedores.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return lista;
	}
	
}
