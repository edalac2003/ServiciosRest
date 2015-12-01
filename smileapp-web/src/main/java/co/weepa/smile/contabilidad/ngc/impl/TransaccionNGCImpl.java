package co.weepa.smile.contabilidad.ngc.impl;

import java.util.List;

import co.weepa.smile.contabilidad.dao.TransaccionDAO;
import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartPago;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.ngc.CarteraNGC;
import co.weepa.smile.contabilidad.ngc.TerceroNGC;
import co.weepa.smile.contabilidad.ngc.TransaccionNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class TransaccionNGCImpl implements TransaccionNGC {

	TransaccionDAO transaccionDao;
	TerceroNGC terceroNgc;
	CarteraNGC carteraNgc;
	
	public void setTransaccionDao(TransaccionDAO transaccionDao) {
		this.transaccionDao = transaccionDao;
	}
	public void setTerceroNgc(TerceroNGC terceroNgc) {
		this.terceroNgc = terceroNgc;
	}
	
	public void setCarteraNgc(CarteraNGC carteraNgc) {
		this.carteraNgc = carteraNgc;
	}

	ExcepcionesNGC expNgc = null;
	ContTercero tercero = null;
	CartCartera cartera = null;
	
	
	
	@Override
	public void guardarTransaccion(String idTercero, int idCartera, List<CartPago> listaDetallePago) throws ExcepcionesNGC {
		tercero = terceroNgc.obtenerTercero(idTercero);
		cartera = carteraNgc.obtenerMaestroCartera(idCartera); 
		for (int i=0;i<listaDetallePago.size();i++){
//			lis
		}
		
	}

	
	@Override
	public String consecutivoTransaccionxTipo(String nombreTransaccion) throws ExcepcionesNGC {
		int consecutivo = 0;
		ContTransaccionTipo tipoTransaccion;
		String cadena = "";
	
		if (!nombreTransaccion.isEmpty()){
			try {
				tipoTransaccion = transaccionDao.obtenerTipoTransaccion(nombreTransaccion.toUpperCase());
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
			
			if(tipoTransaccion != null){
				String prefijo = tipoTransaccion.getDsprefijo();
				
				try {
					consecutivo = transaccionDao.consecutivoTransaccionxTipo(tipoTransaccion);
				} catch (ExcepcionesDAO e) {
					expNgc = new ExcepcionesNGC();
					expNgc.setMensajeTecnico(e.getMensajeTecnico());
					expNgc.setMensajeUsuario(e.getMensajeUsuario());
					expNgc.setOrigen(e.getOrigen());
					throw expNgc;
				}
				
				if((consecutivo >=1) && (consecutivo < 10)){
					cadena = prefijo+"0000"+String.valueOf(consecutivo); 
				}else if((consecutivo >= 10) && (consecutivo < 100)){
					cadena = prefijo+"000"+String.valueOf(consecutivo);
				}else if((consecutivo >= 100) && (consecutivo < 1000)){
					cadena = prefijo+"00"+String.valueOf(consecutivo);
				}else if((consecutivo >= 1000) && (consecutivo < 10000)){
					cadena = prefijo+"0"+String.valueOf(consecutivo);
				}else {
					cadena = prefijo+String.valueOf(consecutivo);
				}
			}else{
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario("No es posible generar el Consecutivo del Documento porque no se ha especificado el Tipo de Documento");
				throw expNgc;
			}		
		}		
		return cadena;
	}
	
	

	public ContTransaccionTipo obtenerTipoTransaccion(int idTipoTransaccion) throws ExcepcionesNGC {
		ContTransaccionTipo tipoTx = null;
		
		if(idTipoTransaccion >= 1){
			try {
				tipoTx = transaccionDao.obtenerTipoTransaccion(idTipoTransaccion);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta. Digite un ID de Tipo Transaccion valido.");
			throw expNgc;
		}	
		
		return tipoTx;
	}


	@Override
	public ContTransaccionTipo obtenerTipoTransaccion(String nombreTransaccion) throws ExcepcionesNGC {
		ContTransaccionTipo tipoTx = null;
		
		if(!nombreTransaccion.isEmpty()){
			try {
				tipoTx = transaccionDao.obtenerTipoTransaccion(nombreTransaccion);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta. Digite un ID de Tipo Transaccion valido.");
			throw expNgc;
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
