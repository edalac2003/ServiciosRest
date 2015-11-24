package co.weepa.smile.contabilidad.ngc.impl;

import java.util.ArrayList;
import java.util.List;

import co.weepa.smile.contabilidad.dao.ProductoDAO;
import co.weepa.smile.contabilidad.dto.ProdCategoria;
import co.weepa.smile.contabilidad.dto.ProdColor;
import co.weepa.smile.contabilidad.dto.ProdProducto;
import co.weepa.smile.contabilidad.dto.ProdProductoTipo;
import co.weepa.smile.contabilidad.dto.ProdTalla;
import co.weepa.smile.contabilidad.ngc.ProductoNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;


public class ProductoNGCImpl implements ProductoNGC {

	ProductoDAO productoDao;
	
	public void setProductoDao(ProductoDAO productoDao) {
		this.productoDao = productoDao;
	}

	public void guardarProducto(List<ProdProducto> producto) throws ExcepcionesNGC {
		

	}

	public void modificarProducto(List<ProdProducto> producto) throws ExcepcionesNGC {
		

	}

	public ProdProducto obtenerProducto(String idProducto) throws ExcepcionesNGC {
		ProdProducto producto = null;
		
		if(!idProducto.isEmpty()){
			try {
				producto = productoDao.obtenerProducto(idProducto.toUpperCase());
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesNGC(e);
			}
		}else{
			throw new ExcepcionesNGC("No es posible realizar la busqueda. El ID del producto no puede ser vacio.");
		}
		
		return producto;
	}
	

	public List<ProdProducto> listarProductos() throws ExcepcionesNGC {
		List<ProdProducto> listaProductos = null;
		
		try {
			listaProductos = productoDao.listarProductos();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesNGC(e);
		}
		
		return listaProductos;
	}
	

	public List<ProdProducto> listarProductosxTipo(ProdProductoTipo tipoProducto) throws ExcepcionesNGC {
		
		return null;
	}

	public List<ProdProducto> listarProductosxCategoria(ProdCategoria categoria) throws ExcepcionesNGC {
		
		return null;
	}

	public List<ProdProducto> listarProductosxTipoxColor(ProdProductoTipo tipoProducto, ProdColor colorProducto)
			throws ExcepcionesNGC {
		
		return null;
	}

	public List<ProdProducto> listarProductosxTipoxTalla(ProdProductoTipo tipoProducto, ProdTalla tallaProducto)
			throws ExcepcionesNGC {
		
		return null;
	}
	
	

}
