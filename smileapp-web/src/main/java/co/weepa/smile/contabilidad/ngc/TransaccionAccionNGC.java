package co.weepa.smile.contabilidad.ngc;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContOrganizacionInterna;
import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.dto.DefiTransaccionAccion;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface TransaccionAccionNGC {

	public List<DefiTransaccionAccion> listaCuentasxTransaccion(ContOrganizacionInterna organizacion, ContTransaccionTipo tipoTx) throws ExcepcionesNGC;
	
}
