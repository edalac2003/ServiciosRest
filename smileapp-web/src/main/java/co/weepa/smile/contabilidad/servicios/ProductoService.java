package co.weepa.smile.contabilidad.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.weepa.smile.contabilidad.dto.ProdProducto;
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
	@RequestMapping(value="/listaProducto", method=RequestMethod.GET)
	public @ResponseBody List<ProdProducto> listaProducto(){
		List<ProdProducto> lista = null;
		
		try {
			lista = productoNgc.listarProductos();
		} catch (ExcepcionesNGC e) {
			e.printStackTrace();
		}
		
		return lista;		
	}
	
	@Transactional
	@RequestMapping(value="/obtenerProducto/{idProducto}", method=RequestMethod.GET)
	public @ResponseBody ProdProducto obtenerProducto(@PathVariable("idProducto") String id){
		ProdProducto producto = null;
		if (id.length() > 0){
			try {
				producto = productoNgc.obtenerProducto(id);
			} catch (ExcepcionesNGC e) {
				
			}
		}		
		
		return producto;
	}
}
