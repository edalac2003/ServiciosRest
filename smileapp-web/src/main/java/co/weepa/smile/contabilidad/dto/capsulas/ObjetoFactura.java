package co.weepa.smile.contabilidad.dto.capsulas;

import java.util.List;

import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;

public class ObjetoFactura {

	FactFactura maestroFactura;
	List<FactDetalleFactura> listaDetalles;

	
	public ObjetoFactura() {
		super();
	}

	public ObjetoFactura(FactFactura maestroFactura, List<FactDetalleFactura> listaDetalles) {
		super();
		this.maestroFactura = maestroFactura;
		this.listaDetalles = listaDetalles;
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
}
