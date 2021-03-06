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

import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.TercOrganizacion;
import co.weepa.smile.contabilidad.dto.TercPersona;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoTercero;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoFactura;
import co.weepa.smile.contabilidad.ngc.TerceroNGC;

@RestController
@RequestMapping("/tercero")
public class TerceroService {

	@Autowired
	TerceroNGC terceroNgc;
	
	@Transactional
	@RequestMapping(value="/guardarTercero", method=RequestMethod.POST)
	public void guardarTercero(@RequestBody ContTercero tercero) throws Exception{
		System.out.println("Servicio Consumido");
	}
	
	@Transactional
	@RequestMapping(value="/verObjetoTercero", method=RequestMethod.GET)
	public ContTercero verObjetoTercero()throws Exception{
		ContTercero tercero = new ContTercero();
		tercero.setIdtercero(1008100400);
		return tercero;
	}
	
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
	
	
	@Transactional
	@RequestMapping(value="/listarCarteraTerceros", method=RequestMethod.GET)
	public @ResponseBody List<ObjetoTercero> listarCarteraTerceros(
			@RequestParam(value="tercero")String tipoTercero, 
			@RequestParam(value="documento")String tipoDocumento) throws Exception{
		
		return terceroNgc.listarCarteraTercero(tipoTercero, tipoDocumento);
	}
	
	
	@Transactional
	@RequestMapping(value="/listarPersonasJuridicas", method=RequestMethod.GET)
	public @ResponseBody List<TercOrganizacion> listarPersonasJuridicas()throws Exception{
		return terceroNgc.listarOrganizaciones();
	}
	
	
	@Transactional
	@RequestMapping(value="/obtenerPersonaJuridica", method=RequestMethod.GET)
	public @ResponseBody TercOrganizacion obtenerPersonaJuridica(@RequestParam(value="id") int idOrganizacion)throws Exception{
		if(idOrganizacion >0){
			return terceroNgc.obtenerPersonaJuridica(idOrganizacion);
		}
		
		return null;
	}
	
	@Transactional
	@RequestMapping(value="/obtenerPersonaNatural", method=RequestMethod.GET)
	public @ResponseBody TercPersona obtenerPersonaNatural(@RequestParam(value="id") int idPersona)throws Exception{
		if(idPersona >0){
			return terceroNgc.obtenerPersonaNatural(idPersona);
		}
		
		return null;
	}
}
