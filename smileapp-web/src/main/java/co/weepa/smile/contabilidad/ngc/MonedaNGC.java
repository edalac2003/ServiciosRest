package co.weepa.smile.contabilidad.ngc;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContMoneda;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface MonedaNGC {

	public ContMoneda obtenerMoneda(int idMoneda) throws ExcepcionesNGC;
	
	public List<ContMoneda> listarMonedas() throws ExcepcionesNGC;
}
