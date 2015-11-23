package co.weepa.smile.contabilidad.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.TercPersona;
import co.weepa.smile.contabilidad.ngc.TerceroNGC;

@RestController
@RequestMapping("/tercero")
public class TerceroService {

	@Autowired
	TerceroNGC terceroNgc;
	
	@Transactional
	@RequestMapping(value="/listarTerceros", method=RequestMethod.GET)
	public @ResponseBody List<ContTercero> listarTerceros() throws Exception{
				
		return terceroNgc.listarTodos();
	}
	
	@Transactional
	@RequestMapping(value="/obtenerTercero", method=RequestMethod.GET)
	public @ResponseBody ContTercero obtenerTercero(@RequestParam(value="id") String idTercero) throws Exception{
		
		if(idTercero.length() > 0){
			return terceroNgc.obtenerTercero(idTercero);
		}
		
		return null;
	}
	
	@Transactional
	@RequestMapping(value="/listarVendedores", method=RequestMethod.GET)
	public @ResponseBody List<TercPersona> listarVendedores() throws Exception{
		
		return terceroNgc.listarVendedores();
		
	}
}
