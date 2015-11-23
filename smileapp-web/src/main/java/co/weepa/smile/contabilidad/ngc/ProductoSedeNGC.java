package co.weepa.smile.contabilidad.ngc;

import java.util.List;

import co.weepa.smile.contabilidad.dto.DefiSede;
import co.weepa.smile.contabilidad.dto.ProdProductoSede;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface ProductoSedeNGC {

	public void guardarProducto(List<ProdProductoSede> producto) throws ExcepcionesNGC;
	
	public void modificarProdcuto(ProdProductoSede producto) throws ExcepcionesNGC;
	
	public ProdProductoSede obtenerProducto(String idProducto) throws ExcepcionesNGC;
	
	public List<ProdProductoSede> listarProductosxSede(DefiSede sede) throws ExcepcionesNGC;
}
