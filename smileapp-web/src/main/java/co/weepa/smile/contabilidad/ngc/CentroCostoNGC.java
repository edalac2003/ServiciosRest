package co.weepa.smile.contabilidad.ngc;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContCentroCosto;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface CentroCostoNGC {
	
	public ContCentroCosto obtenerCentroCosto(int idCentroCosto) throws ExcepcionesNGC;
	
	public List<ContCentroCosto> listarCentroCosto() throws ExcepcionesNGC;

}
