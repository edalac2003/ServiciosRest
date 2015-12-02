package co.weepa.smile.contabilidad.ngc.impl;

import java.util.List;

import co.weepa.smile.contabilidad.dao.TransaccionAccionDAO;
import co.weepa.smile.contabilidad.dto.ContOrganizacionInterna;
import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.dto.DefiTransaccionAccion;
import co.weepa.smile.contabilidad.ngc.TransaccionAccionNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class TransaccionAccionNGCImpl implements TransaccionAccionNGC {

	TransaccionAccionDAO transaccionAccionDao;
	
	public void setTransaccionAccionDao(TransaccionAccionDAO transaccionAccionDao) {
		this.transaccionAccionDao = transaccionAccionDao;
	}

	ExcepcionesNGC expNgc;

	public List<DefiTransaccionAccion> listaCuentasxTransaccion(ContOrganizacionInterna organizacion,
			ContTransaccionTipo tipoTx) throws ExcepcionesNGC {
		List<DefiTransaccionAccion> listaCuentas = null;
		
		if (organizacion != null){
			if (tipoTx != null){
				try {
					listaCuentas = transaccionAccionDao.listaCuentasxTransaccion(organizacion, tipoTx);
				} catch (ExcepcionesDAO e) {
					throw new ExcepcionesNGC(e);
				}
			}else{
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario("No se puede realizar la Consulta. Ingrese un Tipo de Transaccion valida.");
				throw expNgc;
			}
		} else {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No se puede realizar la Consulta. Ingrese un Tipo de Transaccion valida.");
			throw expNgc;
		}		
		
		return listaCuentas;
	}

}
