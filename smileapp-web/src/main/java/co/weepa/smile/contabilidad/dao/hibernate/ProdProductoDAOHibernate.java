package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.ProductoDAO;
import co.weepa.smile.contabilidad.dto.ProdCategoria;
import co.weepa.smile.contabilidad.dto.ProdColor;
import co.weepa.smile.contabilidad.dto.ProdProducto;
import co.weepa.smile.contabilidad.dto.ProdProductoTipo;
import co.weepa.smile.contabilidad.dto.ProdTalla;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class ProdProductoDAOHibernate extends HibernateDaoSupport implements ProductoDAO {

	public ProdProductoDAOHibernate() {
		
	}

	public void guardarProducto(List<ProdProducto> producto) throws ExcepcionesDAO {
		

	}

	public void modificarProducto(List<ProdProducto> producto) throws ExcepcionesDAO {
		

	}
	
	

	public ProdProducto obtenerProducto(String idProducto){
		ProdProducto producto = null;
		Session session = null;
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ProdProducto.class).add(Restrictions.eq("idproducto", idProducto));
			producto = (ProdProducto)criteria.uniqueResult();
		}catch(HibernateException e){
//			throw new ExcepcionesDAO("Se presentaron problemas al intenta obtener registro de Productos. Error : "+e.toString());
			System.out.println("Se presentaron problemas al intenta obtener registro de Productos. Error : "+e.toString());
		}finally{
			session.close();
		}
		
		return producto;
	}


//	public List<ProdProducto> listarProductos(){
//		List<ProdProducto> listaProductos = null;
//		Session session = null;
//		
//		try{
//			session = getSession();
//			Criteria criteria = session.createCriteria(ProdProducto.class);
//			listaProductos = criteria.list();
//		}catch(HibernateException e){
//			System.out.println("Se presentaron problemas al intenta obtener listado de Productos. Error : "+e.toString());
////			throw new ExcepcionesDAO("Se presentaron problemas al intenta obtener listado de Productos. Error : "+e.toString());
//		}finally{
//			session.close();
//		}
//		return listaProductos;
//	}



	@SuppressWarnings("unchecked")
	public List<ProdProducto> listarProductos() {
		List<ProdProducto> listaProductos = null;
		Session session = null;
		
		session = getSession();
		Criteria criteria = session.createCriteria(ProdProducto.class);
		listaProductos = criteria.list();
		
		
		return listaProductos;
	}

	public List<ProdProducto> listarProductosxTipo(ProdProductoTipo tipoProducto) throws ExcepcionesDAO {
		
		return null;
	}

	public List<ProdProducto> listarProductosxCategoria(ProdCategoria categoria) throws ExcepcionesDAO {
		
		return null;
	}

	public List<ProdProducto> listarProductosxTipoxColor(ProdProductoTipo tipoProducto, ProdColor colorProducto)
			throws ExcepcionesDAO {
		
		return null;
	}

	public List<ProdProducto> listarProductosxTipoxTalla(ProdProductoTipo tipoProducto, ProdTalla tallaProducto)
			throws ExcepcionesDAO {
		
		return null;
	}

}
