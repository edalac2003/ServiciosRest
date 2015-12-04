package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.FactDetalleFacturaTipo;
import co.weepa.smile.contabilidad.dto.FactFacturaTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface FacturaTipoDAO {

	public FactFacturaTipo obtenerTipoFactura(int idTipoFactura) throws ExcepcionesDAO;
	
	public FactFacturaTipo obtenerTipoFacturaxNombre(String nombreFactura) throws ExcepcionesDAO;
	
	public List<FactFacturaTipo> listarTipoFactura() throws ExcepcionesDAO;
	
	public FactDetalleFacturaTipo obtenerTipoDetalleFactura(int idTipoDetalle) throws ExcepcionesDAO;
	
}
