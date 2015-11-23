package co.weepa.smile.contabilidad.ngc;

import co.weepa.smile.contabilidad.dto.ContOrganizacionInterna;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface OrganizacionInternaNGC {

	public ContOrganizacionInterna obtenerOrganizacion(int idOrganizacion) throws ExcepcionesNGC;
	
}
