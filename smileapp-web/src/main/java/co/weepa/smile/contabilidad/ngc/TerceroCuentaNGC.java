package co.weepa.smile.contabilidad.ngc;

import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.TercTerceroCuenta;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface TerceroCuentaNGC {

	public TercTerceroCuenta obtenerTransaccionxTercero(ContTercero tercero) throws ExcepcionesNGC;
	
}
