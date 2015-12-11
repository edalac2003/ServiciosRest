package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.ProductoCategoriaDAO;
import co.weepa.smile.contabilidad.dto.ProdCategoria;
import co.weepa.smile.contabilidad.dto.ProdProducto;
import co.weepa.smile.contabilidad.dto.ProdProductoCategoria;
import co.weepa.smile.contabilidad.dto.ProdProductoTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class ProductoCategoriaDAOHibernate extends HibernateDaoSupport implements ProductoCategoriaDAO {
	
	ExcepcionesDAO expDao = null;

	@Override
	public void guardarTipoProducto(ProdProductoTipo tipoProducto) throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public ProdProductoTipo obtenerTipoProducto(int idTipoProducto) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdProductoTipo> listarTipoProductos() throws ExcepcionesDAO {
		Session session = null;
		List<ProdProductoTipo> listaTipoProducto = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ProdProductoTipo.class);
			listaTipoProducto = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeTecnico("Se presentaron Errores al Intentar obtener el listado de Tipo Producto.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		
		return listaTipoProducto;
	}

	@Override
	public void guardarProductoxCategoria(ProdProductoCategoria productoxCategoria) throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public ProdCategoria obtenerCategoria(int idCategoria) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdCategoria> listarCategorias() throws ExcepcionesDAO {
		Session session = null;
		List<ProdCategoria> listaCategorias = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ProdCategoria.class);
			listaCategorias = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeTecnico("Se presentaron Errores al Intentar obtener el listado de Categorias de Producto.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		return listaCategorias;
	}

	@Override
	public List<ProdProductoCategoria> listarCategoriasxProducto(ProdProducto producto) throws ExcepcionesDAO {
		Session session = null;
		List<ProdProductoCategoria> lista = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ProdProductoCategoria.class).add(Restrictions.eq("prodProducto", producto));
			lista = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron inconvenientes al momento de intentar obtener Listado de Categorias x Producto.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return lista;
	}

	@Override
	public List<ProdProductoCategoria> listarCategoriasxProductoTodos() throws ExcepcionesDAO {
		Session session = null;
		List<ProdProductoCategoria> lista = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ProdProductoCategoria.class);
			lista = criteria.list();
		}catch(HibernateException e){
			expDao = new ExcepcionesDAO();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron inconvenientes al momento de intentar obtener Listado de Categorias x Producto Todos.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}
		
		return lista;
	}

}
