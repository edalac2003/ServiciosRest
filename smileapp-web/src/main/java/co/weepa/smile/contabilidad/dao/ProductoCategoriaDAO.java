package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ProdCategoria;
import co.weepa.smile.contabilidad.dto.ProdProducto;
import co.weepa.smile.contabilidad.dto.ProdProductoCategoria;
import co.weepa.smile.contabilidad.dto.ProdProductoTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;


/**
 * Esta Interface agrupa las acciones de varias tablas para evitar usar diferentes interfaces con pocos métodos.
 * @author Usuario
 *
 */
public interface ProductoCategoriaDAO {
	
	//Metodos referentes al tipo de los Productos
	
	public void guardarTipoProducto(ProdProductoTipo tipoProducto) throws ExcepcionesDAO;
	
	public ProdProductoTipo obtenerTipoProducto(int idTipoProducto) throws ExcepcionesDAO;
	
	public List<ProdProductoTipo> listarTipoProductos() throws ExcepcionesDAO;
	
	
	//Metodos referentes a las Categorias de los Productos
	
	public void guardarProductoxCategoria(ProdProductoCategoria productoxCategoria) throws ExcepcionesDAO;
	
	public ProdCategoria obtenerCategoria(int idCategoria) throws ExcepcionesDAO;
	
	public List<ProdCategoria> listarCategorias() throws ExcepcionesDAO;
	
	public List<ProdProductoCategoria> listarCategoriasxProducto(ProdProducto producto) throws ExcepcionesDAO;
	
	public List<ProdProductoCategoria> listarCategoriasxProductoTodos() throws ExcepcionesDAO;

}
