package co.weepa.smile.contabilidad.dto.capsulas;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.TercOrganizacion;
import co.weepa.smile.contabilidad.dto.TercPersona;

public class ObjetoCotizacion {
	
	private String nombreTercero;
	private FactFactura maestroCotizacion;
	private List<FactDetalleFactura> detalleCotizacion;
	private int cantidadItem;
	private String mensaje = "";
		
	
	public String getNombreTercero() {
		return nombreTercero;
	}

	public void setNombreTercero(String nombreTercero) {
		this.nombreTercero = nombreTercero;
	}

	public FactFactura getMaestroCotizacion() {
		return maestroCotizacion;
	}
	
	public void setMaestroCotizacion(FactFactura maestroCotizacion) {
		this.maestroCotizacion = maestroCotizacion;
	}
	
	public List<FactDetalleFactura> getDetalleCotizacion() {
		return detalleCotizacion;
	}
	
	public void setDetalleCotizacion(List<FactDetalleFactura> detalleCotizacion) {
		this.detalleCotizacion = detalleCotizacion;
	}

	public int getCantidadItem() {
		return cantidadItem;
	}

	public void setCantidadItem(int cantidadItem) {
		this.cantidadItem = cantidadItem;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
