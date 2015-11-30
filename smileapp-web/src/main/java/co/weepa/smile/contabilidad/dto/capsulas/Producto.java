package co.weepa.smile.contabilidad.dto.capsulas;

import java.io.Serializable;
import java.util.List;

import co.weepa.smile.contabilidad.dto.ProdProducto;

public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<ProdProducto> listaProductos;
	ProdProducto producto;
	String mensaje;
	
	public List<ProdProducto> getListaProductos() {
		return listaProductos;
	}
	public void setListaProductos(List<ProdProducto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	public ProdProducto getProducto() {
		return producto;
	}
	public void setProducto(ProdProducto producto) {
		this.producto = producto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
