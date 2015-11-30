package co.weepa.smile.contabilidad.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.ngc.CarteraNGC;

@RestController
@RequestMapping("/cartera")
public class CarteraService {
	
	@Autowired
	CarteraNGC carteraNgc;
	
	@RequestMapping(value="/obtenerCartera", method=RequestMethod.GET)
	public @ResponseBody CartCartera obtenerCartera(@RequestParam(value="id") int idCartera)throws Exception{
		
		if (idCartera > 0){
			return carteraNgc.obtenerMaestroCartera(idCartera);
		}
		
		return null;
	}

}
