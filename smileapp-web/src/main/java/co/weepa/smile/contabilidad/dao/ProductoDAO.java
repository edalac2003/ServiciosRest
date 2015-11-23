package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ProdCategoria;
import co.weepa.smile.contabilidad.dto.ProdColor;
import co.weepa.smile.contabilidad.dto.ProdProducto;
import co.weepa.smile.contabilidad.dto.ProdProductoTipo;
import co.weepa.smile.contabilidad.dto.ProdTalla;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface ProductoDAO {

	public void guardarProducto(List<ProdProducto> producto) throws ExcepcionesDAO;
	
	public void modificarProducto(List<ProdProducto> producto) throws ExcepcionesDAO;
	
	public ProdProducto obtenerProducto(String idProducto) throws ExcepcionesDAO;
	
	public List<ProdProducto> listarProductos() throws ExcepcionesDAO;
	
	public List<ProdProducto> listarProductosxTipo(ProdProductoTipo tipoProducto) throws ExcepcionesDAO;
	
	public List<ProdProducto> listarProductosxCategoria(ProdCategoria categoria) throws ExcepcionesDAO;
	
	public List<ProdProducto> listarProductosxTipoxColor(ProdProductoTipo tipoProducto, ProdColor colorProducto) throws ExcepcionesDAO;
	
	public List<ProdProducto> listarProductosxTipoxTalla(ProdProductoTipo tipoProducto, ProdTalla tallaProducto) throws ExcepcionesDAO;
	
	
}
