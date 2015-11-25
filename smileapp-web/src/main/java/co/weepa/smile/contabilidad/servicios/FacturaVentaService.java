package co.weepa.smile.contabilidad.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoFactura;
import co.weepa.smile.contabilidad.ngc.FacturaNGC;

@RestController
@RequestMapping("/factura")
public class FacturaVentaService {
	
	@Autowired
	FacturaNGC facturaNgc;
	
	
	public @ResponseBody String guardarFacturaVenta(@RequestBody ObjetoFactura facturaVenta){
		String numeroFactura = "";
		
		return numeroFactura;		
	}
	
	@Transactional
	@RequestMapping(value="/listarCotizaciones", method=RequestMethod.GET)
	public @ResponseBody List<FactFactura> listarCotizaciones(@RequestParam(value="id")int idTipo) throws Exception{
		if (idTipo > 0){
			return facturaNgc.listarFacturasxTipo(idTipo);
		}
		return null;
	}
}
