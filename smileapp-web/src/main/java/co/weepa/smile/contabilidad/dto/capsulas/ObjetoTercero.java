package co.weepa.smile.contabilidad.dto.capsulas;

import java.util.List;

import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.TercOrganizacion;
import co.weepa.smile.contabilidad.dto.TercPersona;

public class ObjetoTercero {
	ContTercero contTercero;
	List<CartCartera> listaCartera;
	String nombreTercero;
	double saldoDeuda;
	String mensaje;
	
	public ObjetoTercero() {
		super();
	}	

	public ContTercero getContTercero() {
		return contTercero;
	}
	
	public void setContTercero(ContTercero contTercero) {
		this.contTercero = contTercero;
	}
	
	
	public List<CartCartera> getListaCartera() {
		return listaCartera;
	}

	public void setListaCartera(List<CartCartera> listaCartera) {
		this.listaCartera = listaCartera;
	}

	public String getNombreTercero() {
		return nombreTercero;
	}

	public void setNombreTercero(String nombreTercero) {
		this.nombreTercero = nombreTercero;
	}

	public double getSaldoDeuda() {
		return saldoDeuda;
	}

	public void setSaldoDeuda(double saldoDeuda) {
		this.saldoDeuda = saldoDeuda;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
