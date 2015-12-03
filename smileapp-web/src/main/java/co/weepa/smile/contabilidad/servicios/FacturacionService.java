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
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.ProdProducto;
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
//		int idOrganizacion = facturaVenta.getIdOrganizacion();
//		String idTipoTransaccion = facturaVenta.getTipoTransaccion();
//		int idMedioPago = facturaVenta.getIdMedioPago();
//		String  idTercero = facturaVenta.getIdTercero();
//		String formaPago = facturaVenta.getFormaPago();
//		FactFactura maestroFactura = facturaVenta.getMaestroFactura();	
//		List<FactDetalleFactura> listaDetalles = facturaVenta.getListaDetalles();
//		Retenciones retenciones = facturaVenta.getRetenciones();
//		CartCartera maestroCartera = facturaVenta.getMaestroCartera();
//		CartPago pagoCartera = facturaVenta.getPagoCartera();
//		
//		System.out.println("Id Organizacion : "+ idOrganizacion);
//		System.out.println("El ID del Tercero es : "+idTercero);
//		System.out.println("idMedioPago : " + idMedioPago);
//		System.out.println("id Tipo Transaccion : "+idTipoTransaccion);
//		System.out.println("Forma de Pago : "+formaPago);
//		System.out.println("Maestro Factura Id Tercero : "+maestroFactura.getContTercero().getIdtercero());
//		System.out.println("Maestro Factura Nombre Tercero : "+maestroFactura.getFefactura());
//		System.out.println("Objeto Maestro Factura : "+maestroFactura.getDsnumeroFactura());
//		
//		System.out.println("**************************************************************************************************************");
//		for(FactDetalleFactura detalle : listaDetalles){
//			System.out.println(detalle.getProdProducto().getDsdescripcion()+" - "+ detalle.getNmcantidad()+" - "+detalle.getNmprecio() +" - "+detalle.getNmdescuento()+" - "+detalle.getNmimpuesto()+" - "+detalle.getNmsubtotal());
//		}
//		System.out.println("**************************************************************************************************************");
//		
//		System.out.println("Objeto Retenciones ICA : "+retenciones.getReteICA());
//		System.out.println("Objeto Retenciones en la Fuente : "+retenciones.getReteFuente());
//		System.out.println("Objeto Retenciones IVA : "+retenciones.getReteIva());
//		
//		System.out.println("Objeto Maestro cartera : "+maestroCartera);
//		System.out.println("Objeto Pago Cartera : "+pagoCartera);
//		
//		numeroFactura = "Prueba";
		facturaVentaNgc.convertirObjetoFactura(facturaVenta);
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
		int idOrganizacion = 0;
		String tipoTransaccion = "";
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
		ContTercero tercero = new ContTercero();
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
		pagoCartera = new CartPago();
		
		esquemaFactura.setIdOrganizacion(idOrganizacion);
		esquemaFactura.setTipoTransaccion(tipoTransaccion);
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
