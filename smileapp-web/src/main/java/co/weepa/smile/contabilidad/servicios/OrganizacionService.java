package co.weepa.smile.contabilidad.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.weepa.smile.contabilidad.dto.ContOrganizacionInterna;
import co.weepa.smile.contabilidad.ngc.OrganizacionInternaNGC;

@RestController
@RequestMapping("/organizacion")
public class OrganizacionService {

	@Autowired
	OrganizacionInternaNGC organizacionNgc;
	
	@Transactional
	@RequestMapping(value="/obtenerOrganizacion", method=RequestMethod.GET)
	public @ResponseBody ContOrganizacionInterna obtenerOrganizacion(@RequestParam(value="id") int idOrganizacion) throws Exception{
		return organizacionNgc.obtenerOrganizacion(idOrganizacion); 
	}
}
