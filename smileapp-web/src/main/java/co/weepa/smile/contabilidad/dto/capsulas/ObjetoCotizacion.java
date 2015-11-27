package co.weepa.smile.contabilidad.dto.capsulas;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.TercOrganizacion;

public class ObjetoCotizacion {
	
	TercOrganizacion terceroJuridico;
	FactFactura maestroCotizacion;
	List<FactDetalleFactura> detalleCotizacion;
	int cantidadItem;
	
		
	public TercOrganizacion getTerceroJuridico() {
		return terceroJuridico;
	}

	public void setTerceroJuridico(TercOrganizacion terceroJuridico) {
		this.terceroJuridico = terceroJuridico;
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
	
}
