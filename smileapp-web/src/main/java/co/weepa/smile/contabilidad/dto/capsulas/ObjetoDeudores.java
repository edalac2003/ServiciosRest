package co.weepa.smile.contabilidad.dto.capsulas;

import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.TercOrganizacion;
import co.weepa.smile.contabilidad.dto.TercPersona;

public class ObjetoDeudores {
	ContTercero contTercero;
	CartCartera cartCartera;
	TercPersona tercPersona;
	TercOrganizacion tercOrganizacion;
	
	public ObjetoDeudores() {
		super();
	}
	
	
	public ObjetoDeudores(ContTercero contTercero, CartCartera cartCartera, TercPersona tercPersona) {
		super();
		this.contTercero = contTercero;
		this.cartCartera = cartCartera;
		this.tercPersona = tercPersona;
	}

	public ObjetoDeudores(ContTercero contTercero, CartCartera cartCartera, TercOrganizacion tercOrganizacion) {
		super();
		this.contTercero = contTercero;
		this.cartCartera = cartCartera;
		this.tercOrganizacion = tercOrganizacion;
	}


	public ContTercero getContTercero() {
		return contTercero;
	}
	public void setContTercero(ContTercero contTercero) {
		this.contTercero = contTercero;
	}
	public CartCartera getCartCartera() {
		return cartCartera;
	}
	public void setCartCartera(CartCartera cartCartera) {
		this.cartCartera = cartCartera;
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
	
	
	

}
