package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContCuentaGrupo;
import co.weepa.smile.contabilidad.dto.ContPlanCuenta;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface PlanCuentaDAO {
	
	public void guardarCuentaPUC(List<ContPlanCuenta> listaCuentas) throws ExcepcionesDAO;
	
	public void guardarGrupoCuenta(List<ContCuentaGrupo> listaGrupos) throws ExcepcionesDAO;
	
	public ContPlanCuenta obtenerCuentaPUC(int idCuenta) throws ExcepcionesDAO;
	
	public List<ContPlanCuenta> listarTodoPUC() throws ExcepcionesDAO;
	
	public List<ContPlanCuenta> listarCuentasxGrupo(int grupo) throws ExcepcionesDAO;

}
