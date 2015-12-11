package co.weepa.smile.contabilidad.ngc;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ProdCategoria;
import co.weepa.smile.contabilidad.dto.ProdProducto;
import co.weepa.smile.contabilidad.dto.ProdProductoCategoria;
import co.weepa.smile.contabilidad.dto.ProdProductoTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface ProductoCategoriaNGC {

	//Metodos referentes al tipo de los Productos
	
		public void guardarTipoProducto(ProdProductoTipo tipoProducto) throws ExcepcionesNGC;
		
		public ProdProductoTipo obtenerTipoProducto(int idTipoProducto) throws ExcepcionesNGC;
		
		public List<ProdProductoTipo> listarTipoProductos() throws ExcepcionesNGC;
		
		
		//Metodos referentes a las Categorias de los Productos
		
		public void guardarProductoxCategoria(ProdProductoCategoria productoxCategoria) throws ExcepcionesNGC;
		
		public ProdCategoria obtenerCategoria(int idCategoria) throws ExcepcionesNGC;
		
		public List<ProdCategoria> listarCategorias() throws ExcepcionesNGC;
		
		public List<ProdProductoCategoria> listarCategoriasxProducto(String idProducto) throws ExcepcionesNGC;
		
		public List<ProdProductoCategoria> listarCategoriasxProductoTodos() throws ExcepcionesNGC;
}
