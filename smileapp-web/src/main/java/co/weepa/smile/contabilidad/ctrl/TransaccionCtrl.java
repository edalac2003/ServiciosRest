package co.weepa.smile.contabilidad.ctrl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.zkoss.zhtml.Li;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import co.weepa.smile.contabilidad.dao.MonedaDAO;
import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartFormaPago;
import co.weepa.smile.contabilidad.dto.CartPago;
import co.weepa.smile.contabilidad.dto.CartTipoPago;
import co.weepa.smile.contabilidad.dto.ContMoneda;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoTercero;
import co.weepa.smile.contabilidad.ngc.CarteraNGC;
import co.weepa.smile.contabilidad.ngc.FacturaNGC;
import co.weepa.smile.contabilidad.ngc.MonedaNGC;
import co.weepa.smile.contabilidad.ngc.TerceroNGC;
import co.weepa.smile.contabilidad.ngc.TransaccionNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

@SuppressWarnings("rawtypes")
public class TransaccionCtrl extends GenericForwardComposer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	TransaccionNGC transaccionNgc;
	TerceroNGC terceroNgc;
	CarteraNGC carteraNgc;
	MonedaNGC monedaNgc;
	FacturaNGC facturaNgc;
	
	public void setTransaccionNgc(TransaccionNGC transaccionNgc) {
		this.transaccionNgc = transaccionNgc;
	}

	public void setTerceroNgc(TerceroNGC terceroNgc) {
		this.terceroNgc = terceroNgc;
	}

	public void setCarteraNgc(CarteraNGC carteraNgc) {
		this.carteraNgc = carteraNgc;
	}

	public void setMonedaNgc(MonedaNGC monedaNgc) {
		this.monedaNgc = monedaNgc;
	}	

	public void setFacturaNgc(FacturaNGC facturaNgc) {
		this.facturaNgc = facturaNgc;
	}



	Combobox cmbTipoComprobante;
	Combobox cmbIdTercero;
	Combobox cmbMedioPago;
	Combobox cmbTipoPago;
	Combobox cmbBuscarFactura;
	
	Label lblSaldoTotal;
	
	Datebox dtFechaActual;
	
	Textbox txtNumeroComprobante;
	Textbox txtValorPago;
	Textbox txtDetalles;
	
	Button btnGuardar;
	
	Listbox listaDeudores;
	Listbox listaFacturas;
	
	double valorPago = 0;
	
	ContTercero tercero = null;
	CartCartera maestroCartera = null;
	ContMoneda moneda = null;
	FactFactura maestroFactura = null;	
	
	List<ContTransaccionTipo> listaTipoTransaccion = null;
	List<ContTercero> listadoDeudores = null;
	List<ObjetoTercero> deudores = null;
	List<CartFormaPago> listaFormaPago = null;
	List<CartTipoPago> listaTipoPago = null;
	List<CartPago> listaDetallePago = null;
	
	
	private void cargarCarteraTercero(String tipoTercero){
		try {
			deudores = terceroNgc.listarCarteraTercero(tipoTercero, cmbTipoComprobante.getText().toUpperCase());
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMensajeUsuario());
		}
		listaDeudores.getItems().clear();
		
		if(deudores != null){			
			for(ObjetoTercero deudor : deudores){
				Listitem item = new Listitem();
				Listcell celdaID = new Listcell(String.valueOf(deudor.getContTercero().getIdtercero()));
				item.appendChild(celdaID);
				Listcell celdaNombre = new Listcell(deudor.getNombreTercero());
				item.appendChild(celdaNombre);
				Listcell celdaSaldo = new Listcell(String.valueOf(deudor.getSaldoDeuda()));							
				item.appendChild(celdaSaldo);
				listaDeudores.appendChild(item);
			}
		}
	}
	
	private void cargarMedioPago(){
		try {
			listaFormaPago = carteraNgc.listarFormaPago();
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMensajeUsuario());
		}
		
		if((listaFormaPago != null) && (!listaFormaPago.isEmpty())){
			for(CartFormaPago formaPago : listaFormaPago){
				Comboitem item = new Comboitem(formaPago.getDsnombre());
				cmbMedioPago.appendChild(item);
			}
		}
	}
	
	private void cargarTipoPago(){
		try {
			listaTipoPago = carteraNgc.listarTipoPago();
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMensajeUsuario());
		}
		
		if(listaTipoPago != null){
			for(CartTipoPago pago : listaTipoPago){
				Comboitem item = new Comboitem(pago.getDsnombre());
				cmbTipoPago.appendChild(item);
			}
		}
		
	}
	
	private void cargarTipoTransacciones(){
		try {
			listaTipoTransaccion = transaccionNgc.listarTipoTransacciones();
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMensajeUsuario());
		}
		
		if(listaTipoTransaccion != null){
			for(ContTransaccionTipo tipo : listaTipoTransaccion){
				Comboitem item = new Comboitem(tipo.getDsdescripcionTransaccionTipo());
				cmbTipoComprobante.appendChild(item);			
			}
		}
	}
	
	
	private void asignarConsecutivo(){
		String consecutivo = "";	
		txtNumeroComprobante.setText("");
		if (cmbTipoComprobante.getSelectedIndex() >= 0){
			try {
				consecutivo = transaccionNgc.consecutivoTransaccionxTipo(cmbTipoComprobante.getText());
			} catch (ExcepcionesNGC e) {
				Messagebox.show(e.getMensajeUsuario());
			}
			txtNumeroComprobante.setText(consecutivo);
		}		
	}
	
		
	public void onSelect$cmbTipoComprobante(){
		if (cmbTipoComprobante.getSelectedIndex() >= 0){
			asignarConsecutivo();
		}
		
		if((cmbTipoComprobante.getText().contains("RECIBO")) && (cmbTipoComprobante.getText().contains("CAJA"))){
			cargarCarteraTercero("DEUDORES");
		}else if((cmbTipoComprobante.getText().contains("COMPROBANTE")) && (cmbTipoComprobante.getText().contains("EGRESO"))){
			cargarCarteraTercero("ACREEDORES");
		}
	}
	
	
	public void onSelect$listaDeudores(){
		if (listaDeudores.getSelectedIndex() >= 0){
			ObjetoTercero deudor = deudores.get(listaDeudores.getSelectedIndex());
			lblSaldoTotal.setValue(String.valueOf(deudor.getSaldoDeuda()));
			if (deudor.getListaCartera() != null){
				listaFacturas.getItems().clear();
				for(CartCartera cartera : deudor.getListaCartera()){
					Listitem item = new Listitem();
					Listcell celdaID = new Listcell(String.valueOf(cartera.getContTercero().getIdtercero())); 
					Listcell celdaNumeroFactura = new Listcell(cartera.getFactFactura().getDsnumeroFactura());
					Listcell celdaFecha = new Listcell(String.valueOf(cartera.getFactFactura().getFefactura()));
					Listcell celdaSaldo = new Listcell(String.valueOf(cartera.getNmsaldo()));
					item.appendChild(celdaID);
					item.appendChild(celdaNumeroFactura);
					item.appendChild(celdaFecha);
					item.appendChild(celdaSaldo);
					
					
					if((cmbTipoComprobante.getText().contains("RECIBO")) && (cmbTipoComprobante.getText().contains("CAJA"))){
						if(cartera.getFactFactura().getFactFacturaTipo().getIdfacturaTipo() == 2){			//Factura de Ventas
							listaFacturas.appendChild(item);
						}
					}else if((cmbTipoComprobante.getText().contains("COMPROBANTE")) && (cmbTipoComprobante.getText().contains("EGRESO"))){
						if(cartera.getFactFactura().getFactFacturaTipo().getIdfacturaTipo() == 1){			//Factura de Compras
							listaFacturas.appendChild(item);
						}
					}					
				}
			}
		}
	}
	
	public void onSelect$listaFacturas(){
		BigDecimal valorPago = BigDecimal.valueOf(Double.parseDouble(txtValorPago.getText()));
		BigDecimal saldoDeuda;
		Set<Listitem> listaSeleccionados = listaFacturas.getSelectedItems();
		Iterator iter = listaSeleccionados.iterator();
		if(!txtValorPago.getText().isEmpty()){
			while(iter.hasNext()){
				Listitem item = (Listitem)iter.next();
				Listcell celdaSaldo = (Listcell)item.getChildren().get(3);
				saldoDeuda = BigDecimal.valueOf(Double.parseDouble(celdaSaldo.getLabel()));
				int resultado = valorPago.compareTo(saldoDeuda);
				if ((resultado == 0) || (resultado == 1)){			//Valor Pago es Mayor o igual al Saldo de la Deuda
					valorPago = valorPago.subtract(saldoDeuda);
				}else if (resultado == -1){							//Valor Pago es Menor que Saldo Deuda
					Messagebox.show("El valor no alcanza a cubrir la Deuda.");
					valorPago = BigDecimal.ZERO;						
				}				
			}	
		}else{
			Messagebox.show("No ha definido el Valor a Pagar");
		}
	}
	
	
	public void onClick$btnGuardar(){
		/**
		 * Se leen los Registros Seleccionados de la Lista de Facturas y se arma nueva lista.
		 */
		Set<Listitem> listaSeleccionados = listaFacturas.getSelectedItems();
		Iterator iter = listaSeleccionados.iterator();
		FactFactura factura = null;
		CartCartera cartera = null;
		CartPago pagoCartera = null;
		List<CartCartera> listaCarteraAfectado = new ArrayList<CartCartera>();
		List<CartPago> listaPagoCartera = new ArrayList<CartPago>();
		BigDecimal valorPago = BigDecimal.valueOf(Double.valueOf(txtValorPago.getText()));
		
		String idTercero = "";
		
		while (iter.hasNext()){
			Listitem item = (Listitem)iter.next();
			Listcell celdaID = (Listcell)item.getChildren().get(0);
			Listcell celdaFactura = (Listcell)item.getChildren().get(1);
//			Listcell celdaSaldo = (Listcell)item.getChildren().get(3);
			idTercero = celdaID.getLabel();
			/**
			 * Armar la estructura de CART_PAGO y Actualizar los objetos de la estructura CART_CARTERA para disminuir el saldo.
			 * 1. Obtener el objeto CART_CARTERA existente
			 */
			
			try {
				factura = facturaNgc.obtenerFactura(celdaFactura.getLabel());
			} catch (ExcepcionesNGC e) {
				Messagebox.show(e.getMensajeUsuario());
			}
			
			if(factura != null){
				try {
					cartera = carteraNgc.obtenerMaestroCartera(factura);
				} catch (ExcepcionesNGC e) {
					Messagebox.show(e.getMensajeUsuario());
				}
			}
			
			if(cartera != null){
				BigDecimal saldoDeuda = cartera.getNmsaldo();
				int resultado = valorPago.compareTo(saldoDeuda);
				
				if((resultado == 1) || (resultado == 0)){		//El Valor Pago es Mayor o Igual que el saldo de la Deuda.
					valorPago = valorPago.subtract(saldoDeuda);
					saldoDeuda = BigDecimal.ZERO;
					cartera.setNmsaldo(saldoDeuda);
				}else if (resultado == -1){						//El Valor Pago es Menor que el Saldo de la Deuda.
					saldoDeuda = saldoDeuda.subtract(valorPago);
					cartera.setNmsaldo(saldoDeuda);
					valorPago = BigDecimal.ZERO;
				}				
				listaCarteraAfectado.add(cartera);
				
				/**
				 * Se Crea Objeto de Pago Cartera
				 */
				pagoCartera = new CartPago();
				pagoCartera.setCartCartera(cartera);
				pagoCartera.setCartFormaPago(listaFormaPago.get(cmbMedioPago.getSelectedIndex()));
				pagoCartera.setCartTipoPago(listaTipoPago.get(cmbTipoPago.getSelectedIndex()));
				pagoCartera.setContMoneda(moneda);
				pagoCartera.setDsdetalle(txtDetalles.getText());
				pagoCartera.setFepago(dtFechaActual.getValue());
				pagoCartera.setIdpago(0);
				pagoCartera.setNmvalor(BigDecimal.valueOf(Double.valueOf(txtValorPago.getText())));				
				listaPagoCartera.add(pagoCartera);
			}			
		}
		
		if((!idTercero.isEmpty()) && (!listaCarteraAfectado.isEmpty()) && (!listaPagoCartera.isEmpty())){
			String nombreDocumento = cmbTipoComprobante.getText();
			Double valorDescuento = 0.0;
			
			try {
				transaccionNgc.guardarTransaccion(idTercero, BigDecimal.valueOf(Double.parseDouble(txtValorPago.getText())), valorDescuento, nombreDocumento, listaCarteraAfectado, listaPagoCartera);
				Messagebox.show("Registro Guardado Satisfactoriamente.!!!");
			} catch (ExcepcionesNGC e) {
				Messagebox.show(e.getMensajeUsuario());
			}
		}else{
			Messagebox.show("La información no está Completa. Por favor Revise.!!!");
		}		
	}
	

	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		cargarTipoTransacciones();		
		cargarMedioPago();
		cargarTipoPago();
	}	
}
