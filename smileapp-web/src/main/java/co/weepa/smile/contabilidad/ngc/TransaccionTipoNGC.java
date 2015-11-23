package co.weepa.smile.contabilidad.ngc;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface TransaccionTipoNGC {

	public ContTransaccionTipo obtenerTipoTransaccion(int idTipoTx) throws ExcepcionesNGC;
	
	public List<ContTransaccionTipo> listarTipoTransacciones() throws ExcepcionesNGC;
}
