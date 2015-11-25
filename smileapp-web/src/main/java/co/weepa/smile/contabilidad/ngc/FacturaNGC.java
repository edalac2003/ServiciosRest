package co.weepa.smile.contabilidad.ngc;

import java.util.Date;
import java.util.List;

import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.FactFacturaTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface FacturaNGC {
	
	public String consecutivoFactura(FactFacturaTipo tipoFactura) throws ExcepcionesNGC; 
	
	public FactFactura obtenerFactura(String numeroFactura) throws ExcepcionesNGC;
	
	public List<FactFactura> listarTodasFacturas() throws ExcepcionesNGC;
	
	public List<FactFactura> listarFacturasxFecha(Date fechaInicio, Date fechaFin) throws ExcepcionesNGC;
	
	public List<FactFactura> listarFacturasxTipo(int tipo) throws ExcepcionesNGC;
	
	public List<FactFactura> listarFacturasxTercero(ContTercero tercero) throws ExcepcionesNGC;
}
