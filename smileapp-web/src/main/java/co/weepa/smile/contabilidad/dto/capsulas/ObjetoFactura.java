package co.weepa.smile.contabilidad.dto.capsulas;

import java.util.List;

import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartPago;
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;

public class ObjetoFactura {

	int idOrganizacion;
	int idMedioPago;
	String TipoTransaccion;	
	String  idTercero;
	String nombreTercero;
	String formaPago;
	FactFactura maestroFactura;	
	List<FactDetalleFactura> listaDetalles;
	Retenciones retenciones;
	CartCartera maestroCartera;
	CartPago pagoCartera;
	String mensaje = "";
	
	public ObjetoFactura() {
		super();
	}

	public int getIdOrganizacion() {
		return idOrganizacion;
	}

	public void setIdOrganizacion(int idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public String getTipoTransaccion() {
		return TipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		TipoTransaccion = tipoTransaccion;
	}

	public int getIdMedioPago() {
		return idMedioPago;
	}

	public void setIdMedioPago(int idMedioPago) {
		this.idMedioPago = idMedioPago;
	}

	public String getIdTercero() {
		return idTercero;
	}

	public void setIdTercero(String idTercero) {
		this.idTercero = idTercero;
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

	public Retenciones getRetenciones() {
		return retenciones;
	}

	public void setRetenciones(Retenciones retenciones) {
		this.retenciones = retenciones;
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
