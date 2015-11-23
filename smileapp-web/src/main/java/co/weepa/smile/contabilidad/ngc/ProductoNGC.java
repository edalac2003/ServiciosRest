package co.weepa.smile.contabilidad.ngc;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ProdCategoria;
import co.weepa.smile.contabilidad.dto.ProdColor;
import co.weepa.smile.contabilidad.dto.ProdProducto;
import co.weepa.smile.contabilidad.dto.ProdProductoTipo;
import co.weepa.smile.contabilidad.dto.ProdTalla;
import co.weepa.smile.contabilidad.dto.TercPersona;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface ProductoNGC {

	public void guardarProducto(List<ProdProducto> producto) throws ExcepcionesNGC;
	
	public void modificarProducto(List<ProdProducto> producto) throws ExcepcionesNGC;
	
	public ProdProducto obtenerProducto(String idProducto) throws ExcepcionesNGC;
	
	public List<ProdProducto> listarProductos() throws ExcepcionesNGC;
	
	public List<ProdProducto> listarProductosxTipo(ProdProductoTipo tipoProducto) throws ExcepcionesNGC;
	
	public List<ProdProducto> listarProductosxCategoria(ProdCategoria categoria) throws ExcepcionesNGC;
	
	public List<ProdProducto> listarProductosxTipoxColor(ProdProductoTipo tipoProducto, ProdColor colorProducto) throws ExcepcionesNGC;
	
	public List<ProdProducto> listarProductosxTipoxTalla(ProdProductoTipo tipoProducto, ProdTalla tallaProducto) throws ExcepcionesNGC;
	
	
}
