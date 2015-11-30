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
	
	ExcepcionesNGC expNgc = null;
	

	public ContMoneda obtenerMoneda(int idMoneda) throws ExcepcionesNGC {
		ContMoneda moneda = null;
		
		if(idMoneda > 0){
			try {
				moneda = monedaDao.obtenerMoneda(idMoneda);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la Busqueda.  Seleccione un ID de Moneda valido.");
			throw expNgc;
		}
		return moneda;
	}

	
	public List<ContMoneda> listarMonedas() throws ExcepcionesNGC {
		List<ContMoneda> listaMoneda = null;
		
		try {
			listaMoneda = monedaDao.listarMonedas();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaMoneda;
	}

}
