package co.weepa.smile.contabilidad.dao.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.TerceroDAO;
import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.ContTipoTercero;
import co.weepa.smile.contabilidad.dto.TercOrganizacion;
import co.weepa.smile.contabilidad.dto.TercPersona;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoTercero;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class TerceroDAOHibernate extends HibernateDaoSupport implements TerceroDAO {

	final static Logger logger = Logger.getLogger(TerceroDAOHibernate.class);
	ExcepcionesDAO expDao = null;
	
	
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
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico("Errores al intentar consultar registro de Terceros. DAO : "+e.getMessage());
			expDao.setMensajeUsuario("Se presentaron errores al intentar consultar registro de Tercero.");
			expDao.setOrigen(e);
			throw expDao;
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
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico("Errores al Listar Todos los Terceros. DAO : "+e.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas al intentar Listar Todos los Terceros.");
			expDao.setOrigen(e);
			throw expDao;
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
			session = getSession();
			Criteria criteria = session.createCriteria(ContTercero.class).add(Restrictions.eq("contTipoTercero", tipoTercero));
			listaTercero = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico("Errores al obtener listado de Terceros por Tipo. DAO : "+e.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas al obtener listado de Terceros por Tipo.");
			expDao.setOrigen(e);
			throw expDao;
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
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico("Errores al obtener Persona Natural. DAO : "+e.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas al obtener Registro de Persona Natural.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}		
		return persona;
	}


	@Override
	public TercPersona obtenerPersonaNatural(ContTercero tercero) throws ExcepcionesDAO {
		Session session = null;
		TercPersona persona = null;
		
		try{
			session=getSession();
			Criteria criteria = session.createCriteria(TercPersona.class).add(Restrictions.eq("contTercero", tercero));
			persona = (TercPersona)criteria.uniqueResult();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico("Errores al obtener Persona Natural. DAO : "+e.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas al obtener Registro de Persona Natural.");
			expDao.setOrigen(e);
			throw expDao;
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
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico("Errores al obtener Persona Juridica. DAO : "+e.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas al obtener Registro de Persona Juridica.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return organizacion;
	}

	@Override
	public TercOrganizacion obtenerPersonaJuridica(ContTercero tercero) throws ExcepcionesDAO {
		Session session = null;
		TercOrganizacion organizacion = null;
		
		try{
			session=getSession();
			Criteria criteria = session.createCriteria(TercOrganizacion.class).add(Restrictions.eq("contTercero", tercero));
			organizacion = (TercOrganizacion)criteria.uniqueResult();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico("Errores al obtener Persona Juridica. DAO : "+e.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas al obtener Registro de Persona Juridica.");
			expDao.setOrigen(e);
			throw expDao;
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
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico("Errores al Listar Personas Naturales. DAO : "+e.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas al obtener listado de Personas Naturales.");
			expDao.setOrigen(e);
			throw expDao;
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
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico("Errores al Listar Organizaciones. DAO : "+e.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas al obtener listado de Organizaciones.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return lista;
	}


	@Override
	public List<TercPersona> listarVendedores() throws ExcepcionesDAO {
		List<TercPersona> lista = null;
		Session session = null;
		String sql = "SELECT terc_persona.* FROM terc_persona inner join cont_tercero ON (terc_persona.IDPERSONA = cont_tercero.IDTERCERO) "+
					"INNER JOIN terc_tercero_rol ON (terc_tercero_rol.IDTERCERO = cont_tercero.IDTERCERO) WHERE terc_tercero_rol.IDROL_TIPO = 4;";
//		String hql = "from terc_persona tp inner join fetch tp.terc_tercero";
//				+ "ON terc_persona.IDPERSONA = cont_tercero.IDTERCERO "+
//				"INNER JOIN terc_tercero_rol ON terc_tercero_rol.IDTERCERO = cont_tercero.IDTERCERO WHERE terc_tercero_rol.IDROL_TIPO = 4";
		try{
			session = getSession();
			Query query = session.createSQLQuery(sql);
//			Query query = session.createQuery(hql);
			lista = query.list();
			
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico("Errores al Listar Vendedores. DAO : "+e.getMessage());
			expDao.setMensajeUsuario("Se presentaron problemas al obtener listado de Vendedores.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return lista;
	}


	@Override
	public List<ObjetoTercero> listarCarteraTercero(String tipoTercero, String tipoDocumento) throws ExcepcionesDAO {
		List<ObjetoTercero> listaDeudores = null;
		List<BigDecimal> listaTercero = null;
		ObjetoTercero deudor = null;		
		Session session = null;
		String sql = "";
		/**
		 * Se buscan los terceros con cartera y de acuerdo por tipo de Factura
		 */
		if (tipoTercero.toUpperCase().contains("DEUDORES")){				//Las Facturas de Venta
			sql = "select distinct cont_tercero.IDTERCERO from cont_tercero inner join cart_cartera on (cart_cartera.IDTERCERO = cont_tercero.IDTERCERO) inner join fact_factura "
					+ "on (fact_factura.IDCONSECUTIVO_FACTURA = cart_cartera.IDCONS_FACTURA) where fact_factura.IDFACTURA_TIPO = 2;";
		}else if (tipoTercero.toUpperCase().contains("ACREEDORES")){		// Las Facturas de Compra
			sql = "select distinct cont_tercero.IDTERCERO from cont_tercero inner join cart_cartera on (cart_cartera.IDTERCERO = cont_tercero.IDTERCERO) inner join fact_factura "
					+ "on (fact_factura.IDCONSECUTIVO_FACTURA = cart_cartera.IDCONS_FACTURA) where fact_factura.IDFACTURA_TIPO = 1;";
		}
		
		if(!sql.isEmpty()){
			try{
				session = getSession();
				Query query = session.createSQLQuery(sql);
				listaTercero = query.list();
				
			}catch(HibernateException e){
				expDao = new ExcepcionesDAO();
				expDao.setMensajeTecnico("Errores al Listar Deudores. DAO : "+e.getMessage());
				expDao.setMensajeUsuario("Se presentaron problemas al obtener listado de Deudores.");
				expDao.setOrigen(e);
				throw expDao;
			}finally{
				session.close();
			}
		}		
		
		if((listaTercero != null) && (!listaTercero.isEmpty())){
			listaDeudores = new ArrayList<ObjetoTercero>();
			
			for(BigDecimal idTercero : listaTercero) {
				deudor = new ObjetoTercero();
				ContTercero tercero = obtenerTercero(Long.parseLong(idTercero.toString()));
				deudor.setContTercero(tercero);
				deudor.setListaCartera(listaCarteraxDeudor(tercero));
				TercPersona persona = obtenerPersonaNatural(tercero);
				if (persona != null){
					String nombre = persona.getDsprimerNombre()+" "+persona.getDssegundoNombre()+" "+persona.getDsprimerApellido()+" "+persona.getDssegundoApellido();
					deudor.setNombreTercero(nombre);
				}else{
					TercOrganizacion organizacion = obtenerPersonaJuridica(tercero);
					if(organizacion != null){
						deudor.setNombreTercero(organizacion.getDsrazonSocial());
					}
				}
				deudor.setSaldoDeuda(obtenerDeudaxTercero(tercero, tipoDocumento));
				listaDeudores.add(deudor);
			}			
		}			
		return listaDeudores;
	}
	


	private List<CartCartera> listaCarteraxDeudor(ContTercero deudor) throws ExcepcionesDAO{
		List<CartCartera> listaCartera = null;
		Session session = getSession();
		Criteria criteria = session.createCriteria(CartCartera.class).add(Restrictions.eq("contTercero", deudor)); 
		listaCartera = criteria.list();
		
		return listaCartera;
	}
	
	private double obtenerDeudaxTercero(ContTercero tercero, String tipoDocumento) throws ExcepcionesDAO{
		double deuda = 0;
		Session session = getSession();
		String sql = "";
		Long idTercero = tercero.getIdtercero();
		/**
		 * Para buscar la Deuda, se debe definir sobre que tipo de Documento se va a realizar. (FV o FC ya que el mismo tercero puede llegar a ser Cliente y Proveedor)
		 */
		if((tipoDocumento.contains("RECIBO")) && (tipoDocumento.contains("CAJA"))){
			sql = "SELECT sum(cart_cartera.NMSALDO) from cart_cartera inner join fact_factura on (cart_cartera.IDCONS_FACTURA = fact_factura.IDCONSECUTIVO_FACTURA) "
					+ "where (cart_cartera.IDTERCERO = "+idTercero+ " AND fact_factura.IDFACTURA_TIPO = 2);";
		}else if((tipoDocumento.contains("COMPROBANTE")) && (tipoDocumento.contains("EGRESO"))){
			sql = "SELECT sum(cart_cartera.NMSALDO) from cart_cartera inner join fact_factura on (cart_cartera.IDCONS_FACTURA = fact_factura.IDCONSECUTIVO_FACTURA) "
					+ "where (cart_cartera.IDTERCERO = "+idTercero+" AND fact_factura.IDFACTURA_TIPO = 1);";
		}		
		
		Query query = session.createSQLQuery(sql);
		deuda = Double.parseDouble(query.uniqueResult().toString());
		
		return deuda;
	}
	
}
