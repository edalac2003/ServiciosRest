package co.weepa.smile.contabilidad.ngc.impl;

import java.util.List;

import co.weepa.smile.contabilidad.dao.ProductoCategoriaDAO;
import co.weepa.smile.contabilidad.dto.ProdCategoria;
import co.weepa.smile.contabilidad.dto.ProdProducto;
import co.weepa.smile.contabilidad.dto.ProdProductoCategoria;
import co.weepa.smile.contabilidad.dto.ProdProductoTipo;
import co.weepa.smile.contabilidad.ngc.ProductoCategoriaNGC;
import co.weepa.smile.contabilidad.ngc.ProductoNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class ProductoCategoriaNGCImpl implements ProductoCategoriaNGC {
	
	ExcepcionesNGC expNgc = null;
	
	ProductoCategoriaDAO productoCategoriaDao;
	ProductoNGC productoNGC;

	public void setProductoCategoriaDao(ProductoCategoriaDAO productoCategoriaDao) {
		this.productoCategoriaDao = productoCategoriaDao;
	}	
	
	public void setProductoNGC(ProductoNGC productoNGC) {
		this.productoNGC = productoNGC;
	}



	@Override
	public void guardarTipoProducto(ProdProductoTipo tipoProducto) throws ExcepcionesNGC {
		// TODO Auto-generated method stub

	}

	@Override
	public ProdProductoTipo obtenerTipoProducto(int idTipoProducto) throws ExcepcionesNGC {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdProductoTipo> listarTipoProductos() throws ExcepcionesNGC {
		List<ProdProductoTipo> listaTipoProducto = null;
		
		try {
			listaTipoProducto = productoCategoriaDao.listarTipoProductos();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaTipoProducto;
	}

	@Override
	public void guardarProductoxCategoria(ProdProductoCategoria productoxCategoria) throws ExcepcionesNGC {
		// TODO Auto-generated method stub

	}

	@Override
	public ProdCategoria obtenerCategoria(int idCategoria) throws ExcepcionesNGC {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdCategoria> listarCategorias() throws ExcepcionesNGC {
		List<ProdCategoria> listaCategorias = null;
		
		try {
			listaCategorias = productoCategoriaDao.listarCategorias();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}		
		return listaCategorias;
	}



	@Override
	public List<ProdProductoCategoria> listarCategoriasxProducto(String idProducto) throws ExcepcionesNGC {
		List<ProdProductoCategoria> listaCategorias = null;		
		ProdProducto producto = productoNGC.obtenerProducto(idProducto);
		
		if(producto != null){
			try {
				listaCategorias = productoCategoriaDao.listarCategoriasxProducto(producto);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("El Objeto solicitado no Existe.");
			throw expNgc;
		}
		
		return listaCategorias;
	}

	@Override
	public List<ProdProductoCategoria> listarCategoriasxProductoTodos() throws ExcepcionesNGC {
		List<ProdProductoCategoria> listaCategorias = null;
		
		try {
			listaCategorias = productoCategoriaDao.listarCategoriasxProductoTodos();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaCategorias;
	}
	
	
}
