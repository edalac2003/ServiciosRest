package co.weepa.smile.contabilidad.dao;

import java.util.Date;
import java.util.List;

import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.FactFacturaTipo;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoCotizacion;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoFactura;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface FacturaDAO {

	public int consecutivoFactura(FactFacturaTipo tipoFactura) throws ExcepcionesDAO; 
	
	public ObjetoFactura obtenerFactura(String numeroFactura) throws ExcepcionesDAO;
	
	public FactFactura obtenerMaestroDocumento(String numeroFactura) throws ExcepcionesDAO;
	
	public List<FactFactura> listarTodasFacturas() throws ExcepcionesDAO;
	
	public List<FactFactura> listarFacturasxFecha(Date fechaInicio, Date fechaFin) throws ExcepcionesDAO;
	
	public List<FactFactura> listarFacturasxTipo(FactFacturaTipo tipo) throws ExcepcionesDAO;
	
	public List<FactFactura> listarFacturasxTercero(ContTercero tercero) throws ExcepcionesDAO;
	
	public ObjetoCotizacion obtenerCotizacion(String numeroCotizacion) throws ExcepcionesDAO;
	
	public List<ObjetoCotizacion> listarCotizaciones(FactFacturaTipo tipoDocumento) throws ExcepcionesDAO;
	
	public List<ObjetoFactura> listarFacturas(FactFacturaTipo tipoDocumento) throws ExcepcionesDAO;
	
	public List<FactDetalleFactura> listarDetallesDocumento(FactFactura documento) throws ExcepcionesDAO;
}
