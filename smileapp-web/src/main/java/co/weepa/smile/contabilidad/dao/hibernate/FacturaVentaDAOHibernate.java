package co.weepa.smile.contabilidad.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.weepa.smile.contabilidad.dao.FacturaVentaDAO;
import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartPago;
import co.weepa.smile.contabilidad.dto.ContDetalleTransaccion;
import co.weepa.smile.contabilidad.dto.ContTransaccionContable;
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.ProdProducto;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public class FacturaVentaDAOHibernate extends HibernateDaoSupport implements FacturaVentaDAO {

	ExcepcionesDAO expDao = null;
	
	public void guardarFactura(FactFactura maestroFactura, List<FactDetalleFactura>  listaDetalleFactura, ContTransaccionContable maestroTransaccion, 
			List<ContDetalleTransaccion> listaDetalleTransaccion, CartCartera cartera, CartPago pagoCartera) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			
			session.save(maestroFactura);
			
			for(FactDetalleFactura detalleFactura : listaDetalleFactura){
				ProdProducto producto = detalleFactura.getProdProducto();
				int cantidad = detalleFactura.getNmcantidad();
				int saldo = producto.getNmsaldo() - cantidad;
				producto.setNmsaldo(saldo);
				session.update(producto);
				session.save(detalleFactura);
			}
			
			session.save(maestroTransaccion);
			
			for(ContDetalleTransaccion detalleTx : listaDetalleTransaccion){							
				session.save(detalleTx);
			}
			
			if (cartera != null)
				session.save(cartera);
			
			if (pagoCartera != null)
				session.save(pagoCartera);
			
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al Intentar Guardar el Registo de Factura de Venta.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}		
	}

	
	@Override
	public void guardarFacturaCompra(FactFactura maestroFactura, List<FactDetalleFactura>  listaDetalleFactura, ContTransaccionContable maestroTransaccion, 
			List<ContDetalleTransaccion> listaDetalleTransaccion, CartCartera cartera, CartPago pagoCartera) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			
			session.save(maestroFactura);
			
			for(FactDetalleFactura detalleFactura : listaDetalleFactura){
				ProdProducto producto = detalleFactura.getProdProducto();
				int cantidad = detalleFactura.getNmcantidad();
				int saldo = producto.getNmsaldo() + cantidad;
				producto.setNmsaldo(saldo);
				session.update(producto);
				session.save(detalleFactura);
			}
			
			session.save(maestroTransaccion);
			
			for(ContDetalleTransaccion detalleTx : listaDetalleTransaccion){							
				session.save(detalleTx);
			}
			
			if (cartera != null)
				session.save(cartera);
			
			if (pagoCartera != null)
				session.save(pagoCartera);
			
//			ExcepcionesDAO expDao = new ExcepcionesDAO();
//			expDao.setMensajeUsuario("Llego hasta El Dao para Guardar, pero aun no guardar..... JEJEJEJEJEJJE");
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al Intentar Guardar el Registo de Factura de Venta.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}		
		
	}



	public void guardarCotizacion(FactFactura maestroFactura, List<FactDetalleFactura> listaDetalleFactura)	throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			
			session.save(maestroFactura);
			
			for(FactDetalleFactura detalleFactura : listaDetalleFactura){
				session.save(detalleFactura);
			}
			
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			expDao.setMensajeTecnico(e.getMessage());
			expDao.setMensajeUsuario("Se presentaron Errores al Intentar Guardar el Registo de Cotización.");
			expDao.setOrigen(e);
			throw expDao;
		}finally{
			session.close();
		}		
		
	}

	
}
