package co.weepa.smile.contabilidad.ngc.impl;

import java.util.Date;
import java.util.List;

import co.weepa.smile.contabilidad.dao.FacturaDAO;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.FactFacturaTipo;
import co.weepa.smile.contabilidad.ngc.FacturaNGC;
import co.weepa.smile.contabilidad.ngc.FacturaTipoNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class FacturaNGCImpl implements FacturaNGC {

	FacturaDAO facturaDao;
	FacturaTipoNGC facturaTipoNgc;
		
	public void setFacturaDao(FacturaDAO facturaDao) {
		this.facturaDao = facturaDao;
	}

	public void setFacturaTipoNgc(FacturaTipoNGC facturaTipoNgc) {
		this.facturaTipoNgc = facturaTipoNgc;
	}


	public String consecutivoFactura(FactFacturaTipo tipoFactura) throws ExcepcionesNGC {
		int consecutivo = 0;
		StringBuilder cadena = new StringBuilder();
		
		String prefijo = tipoFactura.getDsprefijo();
		
		try {
			consecutivo = facturaDao.consecutivoFactura(tipoFactura);
			
		} catch (ExcepcionesDAO e) {
			ExcepcionesNGC expNGC = new ExcepcionesNGC();
			expNGC.setMensajeTecnico(e.getMensajeTecnico());
			expNGC.setMensajeUsuario(e.getMensajeUsuario());
		}
		consecutivo++;
		if(consecutivo < 10){			
			cadena.append(prefijo).append("0000").append(consecutivo);			
		}else if((consecutivo >= 10) && (consecutivo < 100)){
			cadena.append(prefijo).append("000").append(consecutivo);
		}else if((consecutivo >= 100) && (consecutivo < 1000)){
			cadena.append(prefijo).append("00").append(consecutivo);
		}else if((consecutivo >= 1000) && (consecutivo <=10000)){
			cadena.append(prefijo).append("0").append(consecutivo);
		}else if((consecutivo >= 10000) && (consecutivo <=100000)){
			cadena.append(prefijo).append(consecutivo);
		}
		return cadena.toString().toUpperCase();
	}

	
	public FactFactura obtenerFactura(String numeroFactura) throws ExcepcionesNGC {
		
		return null;
	}

	
	public List<FactFactura> listarTodasFacturas() throws ExcepcionesNGC {
		
		return null;
	}

	
	public List<FactFactura> listarFacturasxFecha(Date fechaInicio, Date fechaFin) throws ExcepcionesNGC {
		
		return null;
	}

	
	public List<FactFactura> listarFacturasxTipo(int tipo) throws ExcepcionesNGC {
		List<FactFactura> listaFacturas = null;
		FactFacturaTipo tipoFactura = null;		
				
		try {
			tipoFactura = facturaTipoNgc.obtenerTipoFactura(tipo);
			listaFacturas = facturaDao.listarFacturasxTipo(tipoFactura);
		} catch (ExcepcionesDAO e) {
			ExcepcionesNGC expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaFacturas;
	}

	
	public List<FactFactura> listarFacturasxTercero(ContTercero tercero) throws ExcepcionesNGC {
		
		return null;
	}

}
