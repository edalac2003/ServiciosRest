package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.CartEstado;
import co.weepa.smile.contabilidad.dto.CartFormaPago;
import co.weepa.smile.contabilidad.dto.CartTipoPago;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface CarteraDAO {

	public CartTipoPago obtenerTipoPago(int idTipoPago)throws ExcepcionesDAO;
	
	public CartFormaPago obtenerFormaPago(int idFormaPago) throws ExcepcionesDAO;
	
	public CartEstado obtenerEstadoCartera(int idEstadoCartera) throws ExcepcionesDAO;
	
	public List<CartTipoPago> listarTipoPago()throws ExcepcionesDAO;
	
	public List<CartFormaPago> listarFormaPago() throws ExcepcionesDAO;
	
	public List<CartEstado> listarEstadoCartera() throws ExcepcionesDAO;

}
