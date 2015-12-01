package co.weepa.smile.contabilidad.ngc.impl;

import java.util.List;

import co.weepa.smile.contabilidad.dao.FacturaTipoDAO;
import co.weepa.smile.contabilidad.dto.FactDetalleFacturaTipo;
import co.weepa.smile.contabilidad.dto.FactFacturaTipo;
import co.weepa.smile.contabilidad.ngc.FacturaTipoNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class FacturaTipoNGCImpl implements FacturaTipoNGC {

	ExcepcionesNGC expNgc = null;
	
	FacturaTipoDAO facturaTipoDao;
	
	public void setFacturaTipoDao(FacturaTipoDAO facturaTipoDao) {
		this.facturaTipoDao = facturaTipoDao;
	}

	
	public FactFacturaTipo obtenerTipoFactura(int idTipoFactura) throws ExcepcionesNGC {
		FactFacturaTipo tipoFactura = null;
		if (idTipoFactura >= 1){
			try {
				tipoFactura = facturaTipoDao.obtenerTipoFactura(idTipoFactura);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es Posible realiza la consulta. Digite de ID de Tipo Factura válido.");
			throw expNgc;
		}	
		
		return tipoFactura;
	}
	
	
	public List<FactFacturaTipo> listarTipoFactura() throws ExcepcionesNGC {
		List<FactFacturaTipo> listaTipo = null;
		try {
			listaTipo = facturaTipoDao.listarTipoFactura();
		} catch (ExcepcionesDAO e) {
			ExcepcionesNGC expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaTipo;
	}

	public FactDetalleFacturaTipo obtenerTipoDetalleFactura(int idTipoDetalle) throws ExcepcionesNGC {
		FactDetalleFacturaTipo tipoDetalleFactura = null;
		
		if(idTipoDetalle >= 1){
			try {
				tipoDetalleFactura = facturaTipoDao.obtenerTipoDetalleFactura(idTipoDetalle);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesNGC(e);
			}
		}else{
			throw new ExcepcionesNGC("No es Posible realiza la consulta. Digite de ID de Tipo Detalle Factura válido.");
		}
		
		return tipoDetalleFactura;
	}

}
