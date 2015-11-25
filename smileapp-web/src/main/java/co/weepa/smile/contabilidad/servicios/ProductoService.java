package co.weepa.smile.contabilidad.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.weepa.smile.contabilidad.dto.ProdProducto;
import co.weepa.smile.contabilidad.dto.capsulas.Producto;
import co.weepa.smile.contabilidad.ngc.ProductoNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

@RestController
@RequestMapping("/producto")
public class ProductoService {

	@Autowired
	ProductoNGC productoNgc;
	
	public void setProductoNgc(ProductoNGC productoNgc) {
		this.productoNgc = productoNgc;
	}
	
	@Transactional
	@RequestMapping(value="/listarProductos", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody Producto listarProductos() throws Exception{
		Producto producto = null;
		
		List<ProdProducto> lista = productoNgc.listarProductos();
		producto = new Producto();
		producto.setListaProductos(lista);
				
		return producto;		
	}
	
	@Transactional
	@RequestMapping(value="/obtenerProducto", method=RequestMethod.GET)
	public @ResponseBody ProdProducto obtenerProducto(@RequestParam(value="id") String idProducto) throws Exception{
		if (idProducto.length() > 0){
			return productoNgc.obtenerProducto(idProducto);
		}
		return null;
	}
}
