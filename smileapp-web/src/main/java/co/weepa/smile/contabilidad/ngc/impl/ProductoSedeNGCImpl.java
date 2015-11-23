package co.weepa.smile.contabilidad.ngc.impl;

import java.util.List;

import co.weepa.smile.contabilidad.dao.ProductoSedeDao;
import co.weepa.smile.contabilidad.dto.DefiSede;
import co.weepa.smile.contabilidad.dto.ProdProductoSede;
import co.weepa.smile.contabilidad.ngc.ProductoSedeNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class ProductoSedeNGCImpl implements ProductoSedeNGC {

	ProductoSedeDao productoSedeDao;
	
	public void setProductoSedeDao(ProductoSedeDao productoSedeDao) {
		this.productoSedeDao = productoSedeDao;
	}

	public void guardarProducto(List<ProdProductoSede> producto) throws ExcepcionesNGC {
		

	}

	public void modificarProdcuto(ProdProductoSede producto) throws ExcepcionesNGC {
		

	}

	public ProdProductoSede obtenerProducto(String idProducto) throws ExcepcionesNGC {
		
		return null;
	}

	public List<ProdProductoSede> listarProductosxSede(DefiSede sede) throws ExcepcionesNGC {
		
		return null;
	}

}
