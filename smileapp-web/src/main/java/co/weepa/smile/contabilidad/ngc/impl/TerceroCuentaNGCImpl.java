package co.weepa.smile.contabilidad.ngc.impl;

import co.weepa.smile.contabilidad.dao.TerceroCuentaDAO;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.TercTerceroCuenta;
import co.weepa.smile.contabilidad.ngc.TerceroCuentaNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class TerceroCuentaNGCImpl implements TerceroCuentaNGC {

	TerceroCuentaDAO terceroCuentaDao;
	
	public void setTerceroCuentaDao(TerceroCuentaDAO terceroCuentaDao) {
		this.terceroCuentaDao = terceroCuentaDao;
	}

	
	public TercTerceroCuenta obtenerTransaccionxTercero(ContTercero tercero) throws ExcepcionesNGC {
		TercTerceroCuenta terceroCuenta = null;
		
		if (tercero != null){
			try {
				terceroCuenta = terceroCuentaDao.obtenerTransaccionxTercero(tercero);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesNGC(e);
			}
		}else {
			throw new ExcepcionesNGC("No se puede realizar la Consulta. Ingrese un Tipo de Tercero válido.");
		}
		
		return terceroCuenta;
	}

}
