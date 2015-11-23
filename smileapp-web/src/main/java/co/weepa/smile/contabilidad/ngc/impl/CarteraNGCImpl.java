package co.weepa.smile.contabilidad.ngc.impl;

import java.util.List;

import co.weepa.smile.contabilidad.dao.CarteraDAO;
import co.weepa.smile.contabilidad.dto.CartEstado;
import co.weepa.smile.contabilidad.dto.CartFormaPago;
import co.weepa.smile.contabilidad.dto.CartTipoPago;
import co.weepa.smile.contabilidad.ngc.CarteraNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class CarteraNGCImpl implements CarteraNGC {

	CarteraDAO carteraDao;
	
	public void setCarteraDao(CarteraDAO carteraDao) {
		this.carteraDao = carteraDao;
	}

	
	public CartTipoPago obtenerTipoPago(int idTipoPago) throws ExcepcionesNGC {
		CartTipoPago tipoPago = null;
		
		if(idTipoPago > 0){
			try {
				tipoPago = carteraDao.obtenerTipoPago(idTipoPago);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesNGC(e);
			}
		}else{
			throw new ExcepcionesNGC("No es posible realizar la Busqueda. Digite un ID de Tipo Pago válido.");
		}			
		
		return tipoPago;
	}




	public CartFormaPago obtenerFormaPago(int idFormaPago) throws ExcepcionesNGC {
		CartFormaPago formaPago = null;
		
		if(idFormaPago > 0){
			try {
				formaPago = carteraDao.obtenerFormaPago(idFormaPago);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesNGC(e);
			}
		}else{
			throw new ExcepcionesNGC("No es posible realizar la Busqueda. Digite un ID de Forma de Pago válido.");
		}
		return formaPago;
	}


	public CartEstado obtenerEstadoCartera(int idEstadoCartera) throws ExcepcionesNGC {
		CartEstado estadoCartera = null;
		if(idEstadoCartera > 0){
			try {
				estadoCartera = carteraDao.obtenerEstadoCartera(idEstadoCartera);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesNGC(e);
			}
		}else{
			throw new ExcepcionesNGC("No es posible realizar la Busqueda. Digite un ID de Estado Cartera válido.");
		}
		return estadoCartera;
	}



	public List<CartTipoPago> listarTipoPago() throws ExcepcionesNGC {
		List<CartTipoPago> listaTipoPago = null;
		
		try {
			listaTipoPago = carteraDao.listarTipoPago();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesNGC(e);
		}
		
		return listaTipoPago;
	}

	public List<CartFormaPago> listarFormaPago() throws ExcepcionesNGC {
		List<CartFormaPago> listaFormaPago = null;
		
		try {
			listaFormaPago = carteraDao.listarFormaPago();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesNGC(e);
		}
		
		return listaFormaPago;
	}

	public List<CartEstado> listarEstadoCartera() throws ExcepcionesNGC {
		List<CartEstado> listaEstadoCartera = null;
		
		try {
			listaEstadoCartera = carteraDao.listarEstadoCartera();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesNGC(e);
		}
		
		return listaEstadoCartera;
	}
}
