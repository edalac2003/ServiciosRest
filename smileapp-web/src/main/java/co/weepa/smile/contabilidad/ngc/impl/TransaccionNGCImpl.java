package co.weepa.smile.contabilidad.ngc.impl;

import java.util.List;

import co.weepa.smile.contabilidad.dao.TransaccionDAO;
import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.ngc.TransaccionNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class TransaccionNGCImpl implements TransaccionNGC {

	TransaccionDAO transaccionDao;
	
	public void setTransaccionDao(TransaccionDAO transaccionDao) {
		this.transaccionDao = transaccionDao;
	}

	ExcepcionesNGC expNgc = null;

	@Override
	public String consecutivoTransaccionxTipo(ContTransaccionTipo tipo) throws ExcepcionesNGC {
		int consecutivo = 0;
		String cadena = "";
	
		
		if(tipo != null){
			String prefijo = tipo.getDsprefijo();
			
			try {
				consecutivo = transaccionDao.consecutivoTransaccionxTipo(tipo);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
			
			if((consecutivo >=1) && (consecutivo < 10)){
				cadena = prefijo+"0000"+String.valueOf(consecutivo); 
			}else if((consecutivo >=10) && (consecutivo < 100)){
				cadena = prefijo+"000"+String.valueOf(consecutivo);
			}else if((consecutivo >=100) && (consecutivo < 1000)){
				cadena = prefijo+"00"+String.valueOf(consecutivo);
			}else if((consecutivo >=1000) && (consecutivo < 10000)){
				cadena = prefijo+"0"+String.valueOf(consecutivo);
			}else {
				cadena = prefijo+String.valueOf(consecutivo);
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible generar el Consecutivo del Documento porque no se ha especificado el Tipo de Documento");
			throw expNgc;
		}
		
		
		
		return cadena;
	}

	public ContTransaccionTipo obtenerTipoTransaccion(int idTipoTx) throws ExcepcionesNGC {
		ContTransaccionTipo tipoTx = null;
		
		if(idTipoTx >= 1){
			try {
				tipoTx = transaccionDao.obtenerTipoTransaccion(idTipoTx);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}else{
			throw new ExcepcionesNGC("No es posible realizar la consulta. Digite un ID de Tipo Transacción válido.");
		}	
		
		return tipoTx;
	}


	public List<ContTransaccionTipo> listarTipoTransacciones() throws ExcepcionesNGC {
		List<ContTransaccionTipo> listaTipoTransaccion = null;
		
		try {
			listaTipoTransaccion = transaccionDao.listarTipoTransacciones();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaTipoTransaccion;
	}

}
