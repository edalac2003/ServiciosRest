package co.weepa.smile.contabilidad.ngc.impl;

import java.util.Date;
import java.util.List;

import co.weepa.smile.contabilidad.dao.FacturaDAO;
import co.weepa.smile.contabilidad.dao.TerceroDAO;
import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartPago;
import co.weepa.smile.contabilidad.dto.ContOrganizacionInterna;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.FactFacturaTipo;
import co.weepa.smile.contabilidad.dto.TercOrganizacion;
import co.weepa.smile.contabilidad.dto.TercPersona;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoCotizacion;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoFactura;
import co.weepa.smile.contabilidad.ngc.CarteraNGC;
import co.weepa.smile.contabilidad.ngc.FacturaNGC;
import co.weepa.smile.contabilidad.ngc.FacturaTipoNGC;
import co.weepa.smile.contabilidad.ngc.TerceroNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class FacturaNGCImpl implements FacturaNGC {

	ExcepcionesNGC expNgc = null;
	
	FacturaDAO facturaDao;
	FacturaTipoNGC facturaTipoNgc;
	TerceroNGC terceroNgc;
	CarteraNGC carteraNgc;
		
	public void setFacturaDao(FacturaDAO facturaDao) {
		this.facturaDao = facturaDao;
	}

	public void setFacturaTipoNgc(FacturaTipoNGC facturaTipoNgc) {
		this.facturaTipoNgc = facturaTipoNgc;
	}	

	public void setTerceroNgc(TerceroNGC terceroNgc) {
		this.terceroNgc = terceroNgc;
	}

	public void setCarteraNgc(CarteraNGC carteraNgc) {
		this.carteraNgc = carteraNgc;
	}

	public String consecutivoFactura(String nombreFactura) throws ExcepcionesNGC {
		int consecutivo = 0;
		int idTipoFactura = 0;
		FactFacturaTipo tipoFactura = null;
		String prefijo = "";
		StringBuilder cadena = new StringBuilder();
		
		/**
		 * Se identifica el tipo de Factura al cual se le signará el Consecutivo
		 */
		
		if((nombreFactura.toUpperCase().contains("FACTURA")) && (nombreFactura.toUpperCase().contains("COMPRA"))){
			idTipoFactura = 1;
		}else if((nombreFactura.toUpperCase().contains("FACTURA")) && (nombreFactura.toUpperCase().contains("VENTA"))){
			idTipoFactura = 2;
		}else if(nombreFactura.toUpperCase().contains("COTIZACION")){
			idTipoFactura = 3;
		}
			
		/**
		 * Se extrae el objeto con la información desde la Base de Datos 
		 */
		
		if (idTipoFactura != 0){
			tipoFactura = facturaTipoNgc.obtenerTipoFactura(idTipoFactura);
			prefijo = tipoFactura.getDsprefijo();				//Se obtiene el Prefijo del tipo de Documento
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No fue posible resolver el tipo de Factura.");
			throw expNgc;
		}
		
		/**
		 * Se consulta la numeración neta por tipo de Documento.
		 */
	
		try {
			consecutivo = facturaDao.consecutivoFactura(tipoFactura);
			
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
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
		FactFactura factura = null;
		
		if(!numeroFactura.isEmpty()){
			try {
				factura = facturaDao.obtenerMaestroDocumento(numeroFactura);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}
		
		return factura;
	}	
	
	@Override
	public ObjetoFactura obtenerObjetoFactura(String numeroFactura) throws ExcepcionesNGC {
		ObjetoFactura objetoFactura = null;
		List<FactDetalleFactura> listaDetalleFactura = null;
		
		
		FactFactura maestroFactura = obtenerFactura(numeroFactura);
		ContOrganizacionInterna organizacionInterna = maestroFactura.getContOrganizacionInterna();
		ContTercero tercero = maestroFactura.getContTercero();
		CartCartera maestroCartera = null;
		
		if(maestroFactura != null){
			objetoFactura = new ObjetoFactura();
			objetoFactura.setTercero(tercero);
			objetoFactura.setMaestroFactura(maestroFactura);
			listaDetalleFactura = listarDetallesxDocumento(numeroFactura);
			objetoFactura.setListaDetalles(listaDetalleFactura);
			
			maestroCartera = carteraNgc.obtenerMaestroCartera(maestroFactura);
			objetoFactura.setMaestroCartera(maestroCartera);
			
			
		}
		
		return objetoFactura;
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
			expNgc = new ExcepcionesNGC();
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

	@Override
	public ObjetoCotizacion obtenerCotizacion(String numeroCotizacion) throws ExcepcionesNGC {
		return null;
	}
	

	@Override
	public List<ObjetoCotizacion> listarCotizaciones() throws ExcepcionesNGC {
		List<ObjetoCotizacion> listaCotizacion = null;
		FactFacturaTipo tipoFactura = null;
		TercOrganizacion organizacion = null;
		TercPersona personaNatural = null;
		
		tipoFactura = facturaTipoNgc.obtenerTipoFactura(3);
		
		try {
			listaCotizacion = facturaDao.listarCotizaciones(tipoFactura);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
				
		if(listaCotizacion != null){			
			for(ObjetoCotizacion cotizacion : listaCotizacion){
//				int idTercero = Integer.parseInt(String.valueOf(cotizacion.getMaestroCotizacion().getContTercero().getIdtercero()));
				ContTercero tercero = cotizacion.getMaestroCotizacion().getContTercero();
				String numeroDoc = cotizacion.getMaestroCotizacion().getDsnumeroFactura();
				
				organizacion = terceroNgc.obtenerPersonaJuridica(tercero);
				personaNatural = terceroNgc.obtenerPersonaNatural(tercero);
				
				List<FactDetalleFactura> detalle = listarDetallesxDocumento(numeroDoc);
				if (organizacion != null)
					cotizacion.setNombreTercero(organizacion.getDsrazonSocial());
				else
					cotizacion.setNombreTercero(personaNatural.getDsprimerNombre()+" "+personaNatural.getDsprimerApellido());				
				cotizacion.setDetalleCotizacion(detalle);
				cotizacion.setCantidadItem(detalle.size());				
			}
		}
		
		return listaCotizacion;
	}
	

	@Override
	public List<ObjetoFactura> listarFacturasVentas() throws ExcepcionesNGC {
		List<ObjetoFactura> listaFacturas = null;
		List<FactDetalleFactura> listaDetalleFactura = null;
		FactFacturaTipo tipoFactura = facturaTipoNgc.obtenerTipoFactura(2);
		TercPersona persona = null;
		TercOrganizacion organizacion = null;
		
		
		try {
			listaFacturas = facturaDao.listarFacturas(tipoFactura);
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		for(ObjetoFactura objeto : listaFacturas){
			FactFactura factura = objeto.getMaestroFactura();
			int idFactura = factura.getIdconsecutivoFactura();
			try {
				listaDetalleFactura = facturaDao.listarDetallesDocumento(factura);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}			
			if(listaDetalleFactura != null){
				objeto.setListaDetalles(listaDetalleFactura);
			}
			ContTercero tercero = factura.getContTercero();
			organizacion = terceroNgc.obtenerPersonaJuridica(tercero);
			if(organizacion != null){
				objeto.setNombreTercero(organizacion.getDsrazonSocial());
			}else{
				persona = terceroNgc.obtenerPersonaNatural(tercero);
				if(persona != null){
					String nombre = persona.getDsprimerNombre()+" "+persona.getDssegundoNombre()+" "+persona.getDsprimerApellido()+" "+persona.getDssegundoApellido();
					objeto.setNombreTercero(nombre);
				}
			}
			
			
		}
		
		return listaFacturas;
	}
	
	

	@Override
	public List<FactDetalleFactura> listarDetallesxDocumento(String idDocumento) throws ExcepcionesNGC {
		List<FactDetalleFactura> listaDetalles = null;
		FactFactura maestroCotizacion = null;
				
		if (!idDocumento.isEmpty()){
			
			try {
				maestroCotizacion = facturaDao.obtenerMaestroDocumento(idDocumento);
			} catch (ExcepcionesDAO e1) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e1.getMensajeTecnico());
				expNgc.setMensajeUsuario(e1.getMensajeUsuario());
				expNgc.setOrigen(e1.getOrigen());
				throw expNgc;
			}
			
			if (maestroCotizacion != null){
				try {
					listaDetalles = facturaDao.listarDetallesDocumento(maestroCotizacion);
				} catch (ExcepcionesDAO e) {
					expNgc = new ExcepcionesNGC();
					expNgc.setMensajeTecnico(e.getMensajeTecnico());
					expNgc.setMensajeUsuario(e.getMensajeUsuario());
					expNgc.setOrigen(e.getOrigen());
					throw expNgc;
				}	
			}				
		}		
		
		return listaDetalles;
	}

	
}
