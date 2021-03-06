package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartPago;
import co.weepa.smile.contabilidad.dto.ContDetalleTransaccion;
import co.weepa.smile.contabilidad.dto.ContTransaccionContable;
import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoCartera;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface TransaccionDAO {
	
	public void guardarCartera(ObjetoCartera cartera, ContTransaccionContable transaccion, List<ContDetalleTransaccion> listaDetalleTransaccion ) throws ExcepcionesDAO;
	
	public void guardarTransaccion(List<CartCartera> listaCartera, List<CartPago> listaPagos, ContTransaccionContable transaccionContable, 
			List<ContDetalleTransaccion> listaDetalleTransaccion) throws ExcepcionesDAO;
	
	public int consecutivoTransaccionxTipo(ContTransaccionTipo tipo) throws ExcepcionesDAO;
	
	public ContTransaccionTipo obtenerTipoTransaccion(int idTipoTransaccion) throws ExcepcionesDAO;
	
	public ContTransaccionTipo obtenerTipoTransaccionxNombre(String nombreTransaccion) throws ExcepcionesDAO;
	
	public List<ContTransaccionTipo> listarTipoTransacciones() throws ExcepcionesDAO;

}
