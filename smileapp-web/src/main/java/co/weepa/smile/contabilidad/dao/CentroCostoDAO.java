package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContCentroCosto;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface CentroCostoDAO {
	
	public ContCentroCosto obtenerCentroCosto(int idCentroCosto) throws ExcepcionesDAO;
	
	public List<ContCentroCosto> listarCentroCosto() throws ExcepcionesDAO;

}
