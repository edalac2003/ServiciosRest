package co.weepa.smile.contabilidad.ngc;

import java.util.List;

import co.weepa.smile.contabilidad.dto.FactDetalleFacturaTipo;
import co.weepa.smile.contabilidad.dto.FactFacturaTipo;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface FacturaTipoNGC {

	public FactFacturaTipo obtenerTipoFactura(int idTipoFactura) throws ExcepcionesNGC;
	
	public FactFacturaTipo obtenerTipoFacturaxNombre(String nombreFactura) throws ExcepcionesNGC;
	
	public List<FactFacturaTipo> listarTipoFactura() throws ExcepcionesNGC;
	
	public FactDetalleFacturaTipo obtenerTipoDetalleFactura(int idTipoDetalle) throws ExcepcionesNGC;
	
}
