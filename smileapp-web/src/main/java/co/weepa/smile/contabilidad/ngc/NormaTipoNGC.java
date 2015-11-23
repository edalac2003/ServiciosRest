package co.weepa.smile.contabilidad.ngc;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContNormaTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface NormaTipoNGC {
	
	public ContNormaTipo obtenerTipoNorma(int idTipo) throws ExcepcionesNGC;
	
	public List<ContNormaTipo> listarTodo() throws ExcepcionesNGC;

}
