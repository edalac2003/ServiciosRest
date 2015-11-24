package co.weepa.smile.contabilidad.ngc;

import java.util.List;

import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartPago;
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.capsulas.Retenciones;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface FacturaVentaNGC {

	public void guardarFactura(String idTercero, int idOrganizacion, int idTipoTransaccion, FactFactura maestroFactura, int formaPago, int medioPago,
			List<FactDetalleFactura> listaDetalles, Retenciones retenciones, CartCartera maestroCartera, CartPago pagoCartera) throws ExcepcionesNGC;	
	
	public void guardarCotizacion(String idTercero, int idOrganizacion, FactFactura maestroFactura, List<FactDetalleFactura> listaDetalles) throws ExcepcionesNGC;
	
	public void guardarFacturaCompra(String idTercero, int idOrganizacion, int idTipoTransaccion, FactFactura maestroFactura, int formaPago, int medioPago,
			List<FactDetalleFactura> listaDetalles, Retenciones retenciones, CartCartera maestroCartera, CartPago pagoCartera) throws ExcepcionesNGC;
}
