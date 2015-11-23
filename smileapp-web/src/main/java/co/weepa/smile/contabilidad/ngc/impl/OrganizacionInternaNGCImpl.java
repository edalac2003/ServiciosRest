package co.weepa.smile.contabilidad.ngc.impl;

import co.weepa.smile.contabilidad.dao.OrganizacionInternaDAO;
import co.weepa.smile.contabilidad.dto.ContOrganizacionInterna;
import co.weepa.smile.contabilidad.ngc.OrganizacionInternaNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class OrganizacionInternaNGCImpl implements OrganizacionInternaNGC {

	OrganizacionInternaDAO organizacionInternaDao;

	public void setOrganizacionInternaDao(OrganizacionInternaDAO organizacionInternaDao) {
		this.organizacionInternaDao = organizacionInternaDao;
	}


	public ContOrganizacionInterna obtenerOrganizacion(int idOrganizacion) throws ExcepcionesNGC {
		ContOrganizacionInterna organizacion = null;
		
		if(idOrganizacion >= 1){
			try {
				organizacion = organizacionInternaDao.obtenerOrganizacion(idOrganizacion);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesNGC(e);
			}
		} else {
			throw new ExcepcionesNGC("No se puede realizar la Consulta. Ingrese un ID de Organizacion válido.");
		}
		return organizacion;
	}

}
