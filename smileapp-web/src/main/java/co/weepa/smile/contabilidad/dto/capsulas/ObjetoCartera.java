package co.weepa.smile.contabilidad.dto.capsulas;

import java.util.List;

import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartPago;

public class ObjetoCartera {

	CartCartera maestroCartera = null;
	List<CartPago> detallePago = null;
	String mensaje = "";
	
	public CartCartera getMaestroCartera() {
		return maestroCartera;
	}
	
	public void setMaestroCartera(CartCartera maestroCartera) {
		this.maestroCartera = maestroCartera;
	}
	
	public List<CartPago> getDetallePago() {
		return detallePago;
	}
	
	public void setDetallePago(List<CartPago> detallePago) {
		this.detallePago = detallePago;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
