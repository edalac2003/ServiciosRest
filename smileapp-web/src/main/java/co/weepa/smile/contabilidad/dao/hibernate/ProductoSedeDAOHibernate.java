package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.ProductoSedeDao;
import co.weepa.smile.contabilidad.dto.DefiSede;
import co.weepa.smile.contabilidad.dto.ProdProductoSede;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class ProductoSedeDAOHibernate extends HibernateDaoSupport implements ProductoSedeDao {

	public void guardarProducto(List<ProdProductoSede> listaProducto) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			if(!listaProducto.isEmpty()){
				for(ProdProductoSede producto : listaProducto){
					session.save(producto);
				}
			}
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}		
	}

	public void modificarProdcuto(ProdProductoSede producto) throws ExcepcionesDAO {
		

	}

	public ProdProductoSede obtenerProducto(String idProducto) throws ExcepcionesDAO {
		Session session = null;
		ProdProductoSede productoSede = null;
		
		try{
			session = getSession();		
			Criteria criteria = session.createCriteria(ProdProductoSede.class).add(Restrictions.eq("idproducto", idProducto));
			productoSede = (ProdProductoSede)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}	
		
		return productoSede;
	}

	@SuppressWarnings("unchecked")
	public List<ProdProductoSede> listarProductosxSede(DefiSede sede) throws ExcepcionesDAO {
		Session session = null;
		List<ProdProductoSede> listaProductos = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(ProdProductoSede.class).add(Restrictions.ilike("idsede", sede));
			listaProductos = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}finally{
			session.close();
		}
		
		
		return listaProductos;
	}

}
