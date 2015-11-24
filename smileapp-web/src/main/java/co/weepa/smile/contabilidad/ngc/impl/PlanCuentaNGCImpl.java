package co.weepa.smile.contabilidad.ngc.impl;

import java.util.List;

import co.weepa.smile.contabilidad.dao.PlanCuentaDAO;
import co.weepa.smile.contabilidad.dto.ContCuentaGrupo;
import co.weepa.smile.contabilidad.dto.ContPlanCuenta;
import co.weepa.smile.contabilidad.ngc.PlanCuentaNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class PlanCuentaNGCImpl implements PlanCuentaNGC {

	PlanCuentaDAO planCuentaDao;

	public void setPlanCuentaDao(PlanCuentaDAO planCuentaDao) {
		this.planCuentaDao = planCuentaDao;
	}

	public void guardarCuentaPUC(List<ContPlanCuenta> listaCuentas) throws ExcepcionesNGC {
		if(!listaCuentas.isEmpty()){
			try {
				planCuentaDao.guardarCuentaPUC(listaCuentas);
				throw new ExcepcionesNGC("Registros Guardados Satisfactoriamente.");
			} catch (ExcepcionesDAO e1) {
				throw new ExcepcionesNGC(e1);
			}
		}else{
			throw new ExcepcionesNGC("No se realizaron cambios debido a que no existen registros para Guardar.");
		}
	}

	public void guardarGrupoCuenta(List<ContCuentaGrupo> listaGrupos) throws ExcepcionesNGC {
		if(!listaGrupos.isEmpty()){
			try {
				planCuentaDao.guardarGrupoCuenta(listaGrupos);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesNGC(e);
			}
			throw new ExcepcionesNGC("Registros Guardados Satisfactoriamente.");			
		}else{
			throw new ExcepcionesNGC("No se realizaron cambios debido a que no existen registros para Guardar.");
		}
	}

	public ContPlanCuenta obtenerCuentaPUC(int idCuenta) throws ExcepcionesNGC {
		ContPlanCuenta cuenta = null;
		if(idCuenta > 0){
			try {
				cuenta = planCuentaDao.obtenerCuentaPUC(idCuenta);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesNGC(e);
			}
		} else {
			throw new ExcepcionesNGC("No es posible realizar la consulta. Ingrese un ID válido.");
		}		
		
		return cuenta;
	}


	public List<ContPlanCuenta> listarTodoPUC() throws ExcepcionesNGC {
		List<ContPlanCuenta> listaCuentas = null;
		
		try {
			listaCuentas = planCuentaDao.listarTodoPUC();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesNGC(e);
		}
		
		return listaCuentas;
	}

	
	public List<ContPlanCuenta> listarCuentasxGrupo(int idGrupoCuenta) throws ExcepcionesNGC {
		List<ContPlanCuenta> listaCuentas = null;
		
		if(idGrupoCuenta > 0){
			try {
				listaCuentas = planCuentaDao.listarCuentasxGrupo(idGrupoCuenta);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesNGC(e);
			}
		}else{
			throw new ExcepcionesNGC("No es posible realizar la consulta. Ingrese un Grupo valido.");
		}
		
		return listaCuentas;
	}

}
