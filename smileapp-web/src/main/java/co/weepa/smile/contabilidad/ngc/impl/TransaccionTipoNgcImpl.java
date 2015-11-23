package co.weepa.smile.contabilidad.ngc.impl;

import java.util.List;

import co.weepa.smile.contabilidad.dao.TransaccionTipoDAO;
import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.ngc.TransaccionTipoNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class TransaccionTipoNgcImpl implements TransaccionTipoNGC {

	TransaccionTipoDAO transaccionTipoDao;	
	
	public void setTransaccionTipoDao(TransaccionTipoDAO transaccionTipoDao) {
		this.transaccionTipoDao = transaccionTipoDao;
	}

	
	public ContTransaccionTipo obtenerTipoTransaccion(int idTipoTx) throws ExcepcionesNGC {
		ContTransaccionTipo tipoTx = null;
		
		if(idTipoTx >= 1){
			try {
				tipoTx = transaccionTipoDao.obtenerTipoTransaccion(idTipoTx);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesNGC(e);
			}
		}else{
			throw new ExcepcionesNGC("No es posible realizar la consulta. Digite un ID de Tipo Transacción válido.");
		}	
		
		return tipoTx;
	}


	public List<ContTransaccionTipo> listarTipoTransacciones() throws ExcepcionesNGC {
		List<ContTransaccionTipo> listaTipoTransaccion = null;
		
		try {
			listaTipoTransaccion = transaccionTipoDao.listarTipoTransacciones();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesNGC(e);
		}
		
		return listaTipoTransaccion;
	}

}
