package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContNormaTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface NormaTipoDAO {
	
	public ContNormaTipo obtenerTipoNorma(int idTipo) throws ExcepcionesDAO;
	
	public List<ContNormaTipo> listarTodo() throws ExcepcionesDAO;	

}
