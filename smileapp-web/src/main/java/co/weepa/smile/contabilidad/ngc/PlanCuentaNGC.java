package co.weepa.smile.contabilidad.ngc;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContCuentaGrupo;
import co.weepa.smile.contabilidad.dto.ContPlanCuenta;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface PlanCuentaNGC {	

	public void guardarCuentaPUC(List<ContPlanCuenta> listaCuentas) throws ExcepcionesNGC;
	
	public void guardarGrupoCuenta(List<ContCuentaGrupo> listaGrupos) throws ExcepcionesNGC;
	
	public ContPlanCuenta obtenerCuentaPUC(int idCuenta) throws ExcepcionesNGC;
	
	public ContCuentaGrupo obtenerGrupoCuenta(int idGrupo) throws ExcepcionesNGC;
	
	public List<ContCuentaGrupo> listarTodosGruposCuenta() throws ExcepcionesNGC;
	
	public List<ContPlanCuenta> listarTodoPUC() throws ExcepcionesNGC;
	
	public List<ContPlanCuenta> listarCuentasxGrupo(ContCuentaGrupo grupoCuenta) throws ExcepcionesNGC;

}
