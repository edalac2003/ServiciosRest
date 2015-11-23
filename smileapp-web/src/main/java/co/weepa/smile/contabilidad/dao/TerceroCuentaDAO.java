package co.weepa.smile.contabilidad.dao;

import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.TercTerceroCuenta;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface TerceroCuentaDAO {

	public TercTerceroCuenta obtenerTransaccionxTercero(ContTercero tercero) throws ExcepcionesDAO;
	
}
