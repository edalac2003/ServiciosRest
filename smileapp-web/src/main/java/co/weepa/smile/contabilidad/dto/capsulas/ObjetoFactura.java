package co.weepa.smile.contabilidad.dto.capsulas;

import java.util.List;

import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartPago;
import co.weepa.smile.contabilidad.dto.ContOrganizacionInterna;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.DefiCiudad;
import co.weepa.smile.contabilidad.dto.DefiDepartamento;
import co.weepa.smile.contabilidad.dto.DefiPais;
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.TercDireccion;

public class ObjetoFactura {

	String TipoTransaccion;		
	ContTercero tercero;
	TercDireccion direccionTercero;
	String nombreTercero;
	String formaPago;
	FactFactura maestroFactura;	
	List<FactDetalleFactura> listaDetalles;
	CartCartera maestroCartera;
	CartPago pagoCartera;
	String mensaje = "";
	
	public ObjetoFactura() {
		super();
	}

	public String getTipoTransaccion() {
		return TipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		TipoTransaccion = tipoTransaccion;
	}
	
	public ContTercero getTercero() {
		return tercero;
	}


	public void setTercero(ContTercero tercero) {
		this.tercero = tercero;
	}

	public TercDireccion getDireccionTercero() {
		return direccionTercero;
	}

	public void setDireccionTercero(TercDireccion direccionTercero) {
		this.direccionTercero = direccionTercero;
	}
	
	public String getNombreTercero() {
		return nombreTercero;
	}

	public void setNombreTercero(String nombreTercero) {
		this.nombreTercero = nombreTercero;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	public FactFactura getMaestroFactura() {
		return maestroFactura;
	}

	public void setMaestroFactura(FactFactura maestroFactura) {
		this.maestroFactura = maestroFactura;
	}

	public List<FactDetalleFactura> getListaDetalles() {
		return listaDetalles;
	}

	public void setListaDetalles(List<FactDetalleFactura> listaDetalles) {
		this.listaDetalles = listaDetalles;
	}

	public CartCartera getMaestroCartera() {
		return maestroCartera;
	}

	public void setMaestroCartera(CartCartera maestroCartera) {
		this.maestroCartera = maestroCartera;
	}

	public CartPago getPagoCartera() {
		return pagoCartera;
	}

	public void setPagoCartera(CartPago pagoCartera) {
		this.pagoCartera = pagoCartera;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
