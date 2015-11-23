package co.weepa.smile.contabilidad.ctrl.pruebas;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.weepa.smile.contabilidad.dto.ProdProducto;
import co.weepa.smile.contabilidad.ngc.ProductoNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

@Controller
public class ProductoCtrl {
	
	ProductoNGC prodProductoNgc;
	
	
	public void setProdProductoNgc(ProductoNGC prodProductoNgc) {
		this.prodProductoNgc = prodProductoNgc;
	}


	@RequestMapping(value="/producto", method=RequestMethod.GET)
	public List<ProdProducto> listadoProductos(){
		List<ProdProducto> listaProd = null;
		
		try {
			listaProd = prodProductoNgc.listarProductos();
		} catch (ExcepcionesNGC e) {
			e.printStackTrace();
		}
		
		return listaProd;
	}

}
