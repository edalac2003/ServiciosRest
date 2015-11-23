package co.weepa.smile.contabilidad.dao;

import co.weepa.smile.contabilidad.dto.ContOrganizacionInterna;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface OrganizacionInternaDAO {
	
	public ContOrganizacionInterna obtenerOrganizacion(int idOrganizacion) throws ExcepcionesDAO;
	
}
