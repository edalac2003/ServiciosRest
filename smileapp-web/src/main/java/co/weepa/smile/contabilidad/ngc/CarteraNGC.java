package co.weepa.smile.contabilidad.ngc;

import java.util.List;

import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartEstado;
import co.weepa.smile.contabilidad.dto.CartFormaPago;
import co.weepa.smile.contabilidad.dto.CartTipoPago;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface CarteraNGC {
	
	public CartCartera obtenerMaestroCartera(int idCartera) throws ExcepcionesNGC;
	
	public CartCartera obtenerMaestroCartera(FactFactura factura) throws ExcepcionesNGC;

	public CartTipoPago obtenerTipoPago(int idTipoPago)throws ExcepcionesNGC;
	
	public CartFormaPago obtenerFormaPago(int idFormaPago) throws ExcepcionesNGC;
	
	public CartEstado obtenerEstadoCartera(int idEstadoCartera) throws ExcepcionesNGC;
	
	public List<CartTipoPago> listarTipoPago()throws ExcepcionesNGC;
	
	public List<CartFormaPago> listarFormaPago() throws ExcepcionesNGC;
	
	public List<CartEstado> listarEstadoCartera() throws ExcepcionesNGC;
}
