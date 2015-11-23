package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContOrganizacionInterna;
import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.dto.DefiTransaccionAccion;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface TransaccionAccionDAO {

	public List<DefiTransaccionAccion> listaCuentasxTransaccion(ContOrganizacionInterna organizacion, ContTransaccionTipo tipoTx) throws ExcepcionesDAO;
}
