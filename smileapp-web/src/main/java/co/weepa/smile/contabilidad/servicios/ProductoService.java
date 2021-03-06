package co.weepa.smile.contabilidad.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.weepa.smile.contabilidad.dto.ProdCategoria;
import co.weepa.smile.contabilidad.dto.ProdProducto;
import co.weepa.smile.contabilidad.dto.ProdProductoCategoria;
import co.weepa.smile.contabilidad.dto.ProdProductoTipo;
import co.weepa.smile.contabilidad.dto.capsulas.Producto;
import co.weepa.smile.contabilidad.ngc.ProductoCategoriaNGC;
import co.weepa.smile.contabilidad.ngc.ProductoNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

@RestController
@RequestMapping("/producto")
public class ProductoService {

	@Autowired
	ProductoNGC productoNgc;
	
	@Autowired
	ProductoCategoriaNGC productoCategoriaNgc;
	
	public void setProductoNgc(ProductoNGC productoNgc) {
		this.productoNgc = productoNgc;
	}
	
	public void setProductoCategoriaNgc(ProductoCategoriaNGC productoCategoriaNgc) {
		this.productoCategoriaNgc = productoCategoriaNgc;
	}


	@Transactional
	@RequestMapping(value="/listarProductos", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody List<ProdProducto> listarProductos() throws Exception{
		
		return productoNgc.listarProductos();		
	}
	
	@Transactional
	@RequestMapping(value="/obtenerProducto", method=RequestMethod.GET)
	public @ResponseBody ProdProducto obtenerProducto(@RequestParam(value="id") String idProducto) throws Exception{
		if (idProducto.length() > 0){
			return productoNgc.obtenerProducto(idProducto);
		}
		return null;
	}
	
	@Transactional
	@RequestMapping(value="/listarTipoProductos", method=RequestMethod.GET)
	public @ResponseBody List<ProdProductoTipo> listarTipoProductos() throws Exception{
		return productoCategoriaNgc.listarTipoProductos();
	}
	
	@Transactional
	@RequestMapping(value="/listarCategoriasProducto", method=RequestMethod.GET)
	public @ResponseBody List<ProdCategoria> listarCategoriasProducto() throws Exception{
		return productoCategoriaNgc.listarCategorias();
	}
	
}
