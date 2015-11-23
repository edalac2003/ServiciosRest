package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.DefiSede;
import co.weepa.smile.contabilidad.dto.ProdProductoSede;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface ProductoSedeDao {
	
	public void guardarProducto(List<ProdProductoSede> producto) throws ExcepcionesDAO;
	
	public void modificarProdcuto(ProdProductoSede producto) throws ExcepcionesDAO;
	
	public ProdProductoSede obtenerProducto(String idProducto) throws ExcepcionesDAO;
	
	public List<ProdProductoSede> listarProductosxSede(DefiSede sede) throws ExcepcionesDAO;

}
