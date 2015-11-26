package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface TransaccionDAO {
	
	public int consecutivoTransaccionxTipo(ContTransaccionTipo tipo) throws ExcepcionesDAO;
	
	public ContTransaccionTipo obtenerTipoTransaccion(int idTipoTx) throws ExcepcionesDAO;
	
	public List<ContTransaccionTipo> listarTipoTransacciones() throws ExcepcionesDAO;

}
