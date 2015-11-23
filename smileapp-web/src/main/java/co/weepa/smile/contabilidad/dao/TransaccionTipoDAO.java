package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface TransaccionTipoDAO {

	public ContTransaccionTipo obtenerTipoTransaccion(int idTipoTx) throws ExcepcionesDAO;
	
	public List<ContTransaccionTipo> listarTipoTransacciones() throws ExcepcionesDAO;
	
}
