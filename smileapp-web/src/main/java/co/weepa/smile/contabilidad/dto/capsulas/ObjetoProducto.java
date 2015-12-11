package co.weepa.smile.contabilidad.dto.capsulas;

import java.io.Serializable;
import java.util.List;

import co.weepa.smile.contabilidad.dto.ProdProducto;
import co.weepa.smile.contabilidad.dto.ProdProductoCategoria;
import co.weepa.smile.contabilidad.dto.ProdProductoSede;
import co.weepa.smile.contabilidad.dto.ProdProductoTipo;

public class ObjetoProducto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ProdProductoSede productoSede;
	ProdProducto producto;
	ProdProductoTipo tipoProducto;
	ProdProductoCategoria categoriaProducto;
	List<ProdProductoCategoria> listaCategoriaProducto;
	
	public ObjetoProducto() {
		super();
	}

	public ProdProductoSede getProductoSede() {
		return productoSede;
	}

	public void setProductoSede(ProdProductoSede productoSede) {
		this.productoSede = productoSede;
	}

	public ProdProducto getProducto() {
		return producto;
	}

	public void setProducto(ProdProducto producto) {
		this.producto = producto;
	}

	public ProdProductoTipo getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(ProdProductoTipo tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public ProdProductoCategoria getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(ProdProductoCategoria categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	public List<ProdProductoCategoria> getListaCategoriaProducto() {
		return listaCategoriaProducto;
	}

	public void setListaCategoriaProducto(List<ProdProductoCategoria> listaCategoriaProducto) {
		this.listaCategoriaProducto = listaCategoriaProducto;
	}
	
	
		
}
