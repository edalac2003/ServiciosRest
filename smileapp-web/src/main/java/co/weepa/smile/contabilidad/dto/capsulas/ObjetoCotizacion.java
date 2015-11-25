package co.weepa.smile.contabilidad.dto.capsulas;

import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;

public class ObjetoCotizacion {
	
	int idOrganizacion;
	int idTipoTransaccion;
	int idMedioPago;
	String  idTercero;
	FactFactura maestroCotizacion;
	FactDetalleFactura detalleCotizacion;
	public int getIdOrganizacion() {
		return idOrganizacion;
	}
	public void setIdOrganizacion(int idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}
	public int getIdTipoTransaccion() {
		return idTipoTransaccion;
	}
	public void setIdTipoTransaccion(int idTipoTransaccion) {
		this.idTipoTransaccion = idTipoTransaccion;
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
	public FactFactura getMaestroCotizacion() {
		return maestroCotizacion;
	}
	public void setMaestroCotizacion(FactFactura maestroCotizacion) {
		this.maestroCotizacion = maestroCotizacion;
	}
	public FactDetalleFactura getDetalleCotizacion() {
		return detalleCotizacion;
	}
	public void setDetalleCotizacion(FactDetalleFactura detalleCotizacion) {
		this.detalleCotizacion = detalleCotizacion;
	}	
}
