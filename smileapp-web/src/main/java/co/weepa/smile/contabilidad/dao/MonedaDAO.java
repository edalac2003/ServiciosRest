package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContMoneda;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface MonedaDAO {

	public ContMoneda obtenerMoneda(int idMoneda) throws ExcepcionesDAO;
	
	public List<ContMoneda> listarMonedas() throws ExcepcionesDAO;
	
}
