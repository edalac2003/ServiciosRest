package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartPago;
import co.weepa.smile.contabilidad.dto.ContDetalleTransaccion;
import co.weepa.smile.contabilidad.dto.ContTransaccionContable;
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface FacturaVentaDAO {
	
	public void guardarFactura(FactFactura maestroFactura, List<FactDetalleFactura> listaDetalleFactura, ContTransaccionContable maestroTransaccion, 
			List<ContDetalleTransaccion> listaDetalleTransaccion, CartCartera maestroCartera, CartPago pagoCartera) throws ExcepcionesDAO;
	
	public void guardarFacturaCompra(FactFactura maestroFactura, List<FactDetalleFactura> listaDetalleFactura, ContTransaccionContable maestroTransaccion, 
			List<ContDetalleTransaccion> listaDetalleTransaccion, CartCartera maestroCartera, CartPago pagoCartera) throws ExcepcionesDAO;
	
	public void guardarCotizacion(FactFactura maestroFactura, List<FactDetalleFactura> listaDetalleFactura) throws ExcepcionesDAO;
}
