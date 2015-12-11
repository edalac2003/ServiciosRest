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
import co.weepa.smile.contabilidad.dto.ContOrganizacionInterna;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.DefiCiudad;
import co.weepa.smile.contabilidad.dto.DefiDepartamento;
import co.weepa.smile.contabilidad.dto.DefiPais;
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.ProdProducto;
import co.weepa.smile.contabilidad.dto.TercDireccion;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoCotizacion;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoFactura;
import co.weepa.smile.contabilidad.dto.capsulas.Retenciones;
import co.weepa.smile.contabilidad.ngc.FacturaNGC;
import co.weepa.smile.contabilidad.ngc.FacturaVentaNGC;

@RestController
@RequestMapping("/factura")
public class FacturacionService {
	
	@Autowired
	FacturaNGC facturaNgc;
	
	@Autowired
	FacturaVentaNGC facturaVentaNgc;
	
	
	String numeroFactura = "";
	
	
	@Transactional
	@RequestMapping(value="/numeroDocumento", method=RequestMethod.GET)
	public String numeroDocumento() throws Exception{
		return numeroFactura;
	}
	
	@Transactional
	@RequestMapping(value="/guardarFacturaVenta", method=RequestMethod.POST)
	public void guardarFacturaVenta(@RequestBody ObjetoFactura facturaVenta) throws Exception{
		numeroFactura = facturaVentaNgc.convertirObjetoFactura(facturaVenta);
	}
	
	
	
	
	@Transactional
	@RequestMapping(value="/guardarCotizacion", method=RequestMethod.POST)
	public void guardarCotizacion(@RequestBody ObjetoFactura cotizacion) throws Exception{
		numeroFactura = facturaVentaNgc.convertirObjetoFactura(cotizacion);
	}
	
	@Transactional
	@RequestMapping(value="/verOrganizacion", method=RequestMethod.GET)
	public @ResponseBody ContOrganizacionInterna verOrganizacion()throws Exception{
		ContOrganizacionInterna organizcion = new ContOrganizacionInterna();
		organizcion.setIdorganizacionInterna(1);
		organizcion.setDsnombreOrganizacion("Nombre de la Organizacion");
		return organizcion;
	}
	
	@Transactional
	@RequestMapping(value="/verObjetoFactura")
	public @ResponseBody ObjetoFactura verObjetoFactura() throws Exception{
		ObjetoFactura esquemaFactura = new ObjetoFactura();
		ContOrganizacionInterna organizacionInterna = new ContOrganizacionInterna();;
		String tipoTransaccion = "";
		ContTercero tercero = new ContTercero();
		TercDireccion direccionTercero = new TercDireccion();
		DefiCiudad ciudadTercero = new DefiCiudad();
		DefiDepartamento departamentoTercero = new DefiDepartamento();
		DefiPais paisTercero = new DefiPais();
		String formaPago = "";
		FactFactura maestroFactura= new FactFactura();;	
		List<FactDetalleFactura> listaDetalles;
		Retenciones retenciones = new Retenciones();
		CartCartera maestroCartera = new CartCartera();
		CartPago pagoCartera = new CartPago();;
		String mensaje = "";
		
		direccionTercero.setDefiCiudad(ciudadTercero);
		direccionTercero.setDefiDepartamento(departamentoTercero);
		direccionTercero.setDefiPais(paisTercero);
		maestroFactura.setContOrganizacionInterna(organizacionInterna);
		maestroFactura.setContTercero(tercero);
		maestroFactura.setDsvendedor("");
		listaDetalles = new ArrayList<FactDetalleFactura>();
		FactDetalleFactura detalleFactura;
		for(int i=1;i<=5;i++){
			ProdProducto producto = new ProdProducto();
			detalleFactura = new FactDetalleFactura();
			detalleFactura.setIddetalleFactura(i);
			detalleFactura.setProdProducto(producto);
			listaDetalles.add(detalleFactura);
		}
		
		retenciones = new Retenciones();
		maestroCartera = new CartCartera();
		
		esquemaFactura.setTipoTransaccion(tipoTransaccion);
		esquemaFactura.setTercero(tercero);
		esquemaFactura.setDireccionTercero(direccionTercero);
		esquemaFactura.setFormaPago(formaPago);
		esquemaFactura.setMaestroFactura(maestroFactura);
		esquemaFactura.setListaDetalles(listaDetalles);
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
	@RequestMapping(value="/listarFacturasVenta", method=RequestMethod.GET)
	public @ResponseBody List<ObjetoFactura> listarFacturasVenta() throws Exception{
		return facturaNgc.listarFacturasVentas();
	}
	
	@Transactional
	@RequestMapping(value="/listarDetallesDocumento", method=RequestMethod.GET)
	public @ResponseBody List<FactDetalleFactura> listarDetallesDocumento(@RequestParam(value="id") String idCotizacion) throws Exception{
		if(!idCotizacion.isEmpty()){
			return facturaNgc.listarDetallesxDocumento(idCotizacion);
		}
		return null;
	}
	
	@Transactional
	@RequestMapping(value="/consecutivoDocumento", method=RequestMethod.GET)
	public String numeroDocumento(@RequestParam(value="nombre") String nombreDocumento) throws Exception{
		return facturaNgc.consecutivoFactura(nombreDocumento);		
	}
}
