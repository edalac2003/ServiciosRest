package co.weepa.smile.contabilidad.dto.capsulas;

import java.util.List;

import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.TercOrganizacion;
import co.weepa.smile.contabilidad.dto.TercPersona;

public class ObjetoDeudor {
	ContTercero contTercero;
	List<CartCartera> listaCartera;
	TercPersona tercPersona;
	TercOrganizacion tercOrganizacion;
	double saldoDeuda;
	
	public ObjetoDeudor() {
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

	public TercPersona getTercPersona() {
		return tercPersona;
	}
	
	public void setTercPersona(TercPersona tercPersona) {
		this.tercPersona = tercPersona;
	}
	
	public TercOrganizacion getTercOrganizacion() {
		return tercOrganizacion;
	}
	
	public void setTercOrganizacion(TercOrganizacion tercOrganizacion) {
		this.tercOrganizacion = tercOrganizacion;
	}

	public double getSaldoDeuda() {
		return saldoDeuda;
	}

	public void setSaldoDeuda(double saldoDeuda) {
		this.saldoDeuda = saldoDeuda;
	}
}
