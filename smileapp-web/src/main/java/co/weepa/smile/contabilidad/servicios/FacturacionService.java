package co.weepa.smile.contabilidad.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartPago;
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoCotizacion;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoFactura;
import co.weepa.smile.contabilidad.dto.capsulas.Retenciones;
import co.weepa.smile.contabilidad.ngc.FacturaNGC;

@RestController
@RequestMapping("/factura")
public class FacturacionService {
	
	@Autowired
	FacturaNGC facturaNgc;
	
	@Transactional
	@RequestMapping(value="/guardarFacturaVenta", method=RequestMethod.POST, produces="application/json")
	public void guardarFacturaVenta(@RequestBody ObjetoFactura facturaVenta) throws Exception{
		int idOrganizacion = facturaVenta.getIdOrganizacion();
		int idTipoTransaccion = facturaVenta.getIdTipoTransaccion();
		int idMedioPago = facturaVenta.getIdMedioPago();
		String  idTercero = facturaVenta.getIdTercero();
		String formaPago = facturaVenta.getFormaPago();
		FactFactura maestroFactura = facturaVenta.getMaestroFactura();	
		List<FactDetalleFactura> listaDetalles = facturaVenta.getListaDetalles();
		Retenciones retenciones = facturaVenta.getRetenciones();
		CartCartera maestroCartera = facturaVenta.getMaestroCartera();
		CartPago pagoCartera = facturaVenta.getPagoCartera();
		
		System.out.println("Servicio Consumido");
		System.out.println("El ID del Tercero es : "+idTercero);
		
	}
	
	@Transactional
	@RequestMapping(value="/verObjetoFactura")
	public @ResponseBody ObjetoFactura verObjetoFactura() throws Exception{
		ObjetoFactura esquemaFactura = new ObjetoFactura();
		int idOrganizacion = 0;
		int idTipoTransaccion = 0;
		int idMedioPago = 0;
		String  idTercero = "";
		String formaPago = "";
		FactFactura maestroFactura;	
		List<FactDetalleFactura> listaDetalles;
		Retenciones retenciones;
		CartCartera maestroCartera;
		CartPago pagoCartera;
		String mensaje = "";
		
		maestroFactura = new FactFactura();
		listaDetalles = new ArrayList<FactDetalleFactura>();
		FactDetalleFactura detalleFactura;
		for(int i=1;i<=5;i++){
			detalleFactura = new FactDetalleFactura();
			detalleFactura.setIddetalleFactura(i);
			listaDetalles.add(detalleFactura);
		}
		
		retenciones = new Retenciones();
		maestroCartera = new CartCartera();
		pagoCartera = new CartPago();
		
		esquemaFactura.setIdOrganizacion(idOrganizacion);
		esquemaFactura.setIdTipoTransaccion(idTipoTransaccion);
		esquemaFactura.setIdMedioPago(idMedioPago);
		esquemaFactura.setIdTercero(idTercero);
		esquemaFactura.setFormaPago(formaPago);
		esquemaFactura.setMaestroFactura(maestroFactura);
		esquemaFactura.setListaDetalles(listaDetalles);
		esquemaFactura.setRetenciones(retenciones);
		esquemaFactura.setMaestroCartera(maestroCartera);
		esquemaFactura.setPagoCartera(pagoCartera);
		
		return esquemaFactura;
	}
	
	
	@Transactional
	@RequestMapping(value="/listarCotizaciones", method=RequestMethod.GET)
	public @ResponseBody List<ObjetoCotizacion> listarCotizaciones() throws Exception{
		return facturaNgc.listarCotizaciones();
	}
	
	
	@Transactional
	@RequestMapping(value="/listarDetallesDocumento", method=RequestMethod.GET)
	public @ResponseBody List<FactDetalleFactura> listarDetallesDocumento(@RequestParam(value="id") String idCotizacion) throws Exception{
		if(!idCotizacion.isEmpty()){
			return facturaNgc.listarDetalles(idCotizacion);
		}
		return null;
	}
	
	@Transactional
	@RequestMapping(value="/consecutivoDocumento", method=RequestMethod.GET)
	public String numeroDocumento(@RequestParam(value="nombre") String nombreDocumento) throws Exception{
		return facturaNgc.consecutivoFactura(nombreDocumento);		
	}
}
