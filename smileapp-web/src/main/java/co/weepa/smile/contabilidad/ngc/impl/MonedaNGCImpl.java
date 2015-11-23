package co.weepa.smile.contabilidad.ngc.impl;

import java.util.List;

import co.weepa.smile.contabilidad.dao.MonedaDAO;
import co.weepa.smile.contabilidad.dto.ContMoneda;
import co.weepa.smile.contabilidad.ngc.MonedaNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class MonedaNGCImpl implements MonedaNGC {

	MonedaDAO monedaDao;
	
	public void setMonedaDao(MonedaDAO monedaDao) {
		this.monedaDao = monedaDao;
	}

	public ContMoneda obtenerMoneda(int idMoneda) throws ExcepcionesNGC {
		ContMoneda moneda = null;
		
		if(idMoneda > 0){
			try {
				moneda = monedaDao.obtenerMoneda(idMoneda);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesNGC(e);
			}
		}else{
			throw new ExcepcionesNGC("No es posible realizar la Busqueda.  Seleccione un ID de Moneda válido.");
		}
		return moneda;
	}

	
	public List<ContMoneda> listarMonedas() throws ExcepcionesNGC {
		List<ContMoneda> listaMoneda = null;
		
		try {
			listaMoneda = monedaDao.listarMonedas();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesNGC(e);
		}
		
		return listaMoneda;
	}

}
