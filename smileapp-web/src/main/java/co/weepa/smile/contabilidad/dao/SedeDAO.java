package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContOrganizacionInterna;
import co.weepa.smile.contabilidad.dto.DefiSede;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface SedeDAO {

	public DefiSede obtenerSede(int idSede) throws ExcepcionesDAO;
	
	public List<DefiSede> listarSedexOrganizacion(ContOrganizacionInterna organizacion) throws ExcepcionesDAO;
}
