package co.weepa.smile.contabilidad.ngc.impl;

import java.util.List;

import co.weepa.smile.contabilidad.dao.CarteraDAO;
import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartEstado;
import co.weepa.smile.contabilidad.dto.CartFormaPago;
import co.weepa.smile.contabilidad.dto.CartTipoPago;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.ngc.CarteraNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class CarteraNGCImpl implements CarteraNGC {

	CarteraDAO carteraDao;
	
	public void setCarteraDao(CarteraDAO carteraDao) {
		this.carteraDao = carteraDao;
	}

	ExcepcionesNGC expNgc = null;
	
	
	
	@Override
	public CartCartera obtenerMaestroCartera(int idCartera) throws ExcepcionesNGC {
		CartCartera cartera = null;
		
		if(idCartera > 0){
			try {
				cartera = carteraDao.obtenerMaestroCartera(idCartera);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consultar. Ingrese un Id valido.");
			throw expNgc;
		}
		
		return cartera;
	}





	public CartTipoPago obtenerTipoPago(int idTipoPago) throws ExcepcionesNGC {
		CartTipoPago tipoPago = null;
		
		if(idTipoPago > 0){
			try {
				tipoPago = carteraDao.obtenerTipoPago(idTipoPago);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consultar. Ingrese un Id valido.");
			throw expNgc;
		}			
		
		return tipoPago;
	}
	

	@Override
	public CartCartera obtenerMaestroCartera(FactFactura factura) throws ExcepcionesNGC {
		CartCartera cartera = null;
		if (factura != null){
			try {
				cartera = carteraDao.obtenerMaestroCarteraxFactura(factura);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}
		
		return cartera;
	}


	public CartFormaPago obtenerFormaPago(int idFormaPago) throws ExcepcionesNGC {
		CartFormaPago formaPago = null;
		
		if(idFormaPago > 0){
			try {
				formaPago = carteraDao.obtenerFormaPago(idFormaPago);
			} catch (ExcepcionesDAO e) {
				ExcepcionesNGC expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}else{
			ExcepcionesNGC expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la Busqueda. Digite un ID de Forma de Pago valido.");
			throw expNgc;
		}
		return formaPago;
	}


	public CartEstado obtenerEstadoCartera(int idEstadoCartera) throws ExcepcionesNGC {
		CartEstado estadoCartera = null;
		if(idEstadoCartera > 0){
			try {
				estadoCartera = carteraDao.obtenerEstadoCartera(idEstadoCartera);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();			
			expNgc.setMensajeUsuario("No es posible realizar la Busqueda. Digite un ID de Estado Cartera valido.");			
			throw expNgc;
		}
		return estadoCartera;
	}



	public List<CartTipoPago> listarTipoPago() throws ExcepcionesNGC {
		List<CartTipoPago> listaTipoPago = null;
		
		try {
			listaTipoPago = carteraDao.listarTipoPago();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaTipoPago;
	}

	public List<CartFormaPago> listarFormaPago() throws ExcepcionesNGC {
		List<CartFormaPago> listaFormaPago = null;
		
		try {
			listaFormaPago = carteraDao.listarFormaPago();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaFormaPago;
	}

	public List<CartEstado> listarEstadoCartera() throws ExcepcionesNGC {
		List<CartEstado> listaEstadoCartera = null;
		
		try {
			listaEstadoCartera = carteraDao.listarEstadoCartera();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaEstadoCartera;
	}
}
