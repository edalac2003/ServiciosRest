package co.weepa.smile.contabilidad.ngc;

import java.math.BigDecimal;
import java.util.List;

import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartPago;
import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface TransaccionNGC {
	
	public void guardarTransaccion(String idTercero, BigDecimal valorTransaccion, Double valorDescuento, String nombreTransaccion, 
			List<CartCartera> listaCartera, List<CartPago> listaDetallePago) throws ExcepcionesNGC;
	
	public String consecutivoTransaccionxTipo(String nombreTransaccion) throws ExcepcionesNGC;
	
	public ContTransaccionTipo obtenerTipoTransaccion(int idTipoTransaccion) throws ExcepcionesNGC;
	
	public ContTransaccionTipo obtenerTipoTransaccionxNombre(String nombreTransaccion) throws ExcepcionesNGC;
	
	public List<ContTransaccionTipo> listarTipoTransacciones() throws ExcepcionesNGC;

}
