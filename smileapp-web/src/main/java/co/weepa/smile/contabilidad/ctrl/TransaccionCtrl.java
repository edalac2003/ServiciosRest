package co.weepa.smile.contabilidad.ctrl;

import java.math.BigDecimal;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
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
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoDeudor;
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
	
	
	ContTercero tercero = null;
	CartCartera maestroCartera = null;
	ContMoneda moneda = null;
	FactFactura maestroFactura = null;
	List<CartPago> listaDetallePago = null;
	
	
	List<ContTransaccionTipo> listaTipoTransaccion = null;
	List<ContTercero> listadoDeudores = null;
	List<ObjetoDeudor> deudores = null;
	List<CartFormaPago> listaFormaPago = null;
	List<CartTipoPago> listaTipoPago = null;
	
	
	private void cargarDeudores(){
		try {
			deudores = terceroNgc.listarDeudores();
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMensajeUsuario());
		}
		
		if(deudores != null){			
			for(ObjetoDeudor deudor : deudores){
				Listitem item = new Listitem();
				Listcell celdaID = new Listcell(String.valueOf(deudor.getContTercero().getIdtercero()));
				item.appendChild(celdaID);	
				if(deudor.getTercOrganizacion() != null){
					Listcell celdaNombre = new Listcell(deudor.getTercOrganizacion().getDsrazonSocial());
					item.appendChild(celdaNombre);
				}else if (deudor.getTercPersona() != null){
					String nombreTercero = deudor.getTercPersona().getDsprimerNombre()+ " " +deudor.getTercPersona().getDsprimerApellido();
					Listcell celdaNombre = new Listcell(nombreTercero);
					item.appendChild(celdaNombre);
				}
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
		
		if (cmbTipoComprobante.getSelectedIndex() >= 0){
			ContTransaccionTipo tipoTransaccion = listaTipoTransaccion.get(cmbTipoComprobante.getSelectedIndex());
			try {
				consecutivo = transaccionNgc.consecutivoTransaccionxTipo(tipoTransaccion);
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
	}
	
	public void onSelect$listaDeudores(){
		if (listaDeudores.getSelectedIndex() >= 0){
			ObjetoDeudor deudor = deudores.get(listaDeudores.getSelectedIndex());
			lblSaldoTotal.setValue(String.valueOf(deudor.getSaldoDeuda()));
			if (deudor.getListaCartera() != null){
				listaFacturas.getItems().clear();
				for(CartCartera cartera : deudor.getListaCartera()){
					Listitem item = new Listitem();
					item.setCheckable(true);
					Listcell celdaID = new Listcell(String.valueOf(cartera.getContTercero().getIdtercero())); 
					Listcell celdaNumeroFactura = new Listcell(cartera.getFactFactura().getDsnumeroFactura());
					Listcell celdaFecha = new Listcell(String.valueOf(cartera.getFactFactura().getFefactura()));
					Listcell celdaSaldo = new Listcell(String.valueOf(cartera.getNmsaldo()));
					item.appendChild(celdaID);
					item.appendChild(celdaNumeroFactura);
					item.appendChild(celdaFecha);
					item.appendChild(celdaSaldo);
					listaFacturas.appendChild(item);
				}
			}
		}
	}
	
	
	
	public void onClick$btnGuardar(){		
		try {
			moneda = monedaNgc.obtenerMoneda(1);
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMensajeUsuario());
		}
		Listitem item = (Listitem)listaFacturas.getChildren();
		Listcell celda = (Listcell)item.getChildren().get(0);
		String numeroFactura = celda.getValue();
		
		if (!numeroFactura.isEmpty()){
			try {
				maestroFactura = facturaNgc.obtenerFactura(numeroFactura);
			} catch (ExcepcionesNGC e) {
				Messagebox.show(e.getMensajeUsuario());
			}
		}	
		
		if (maestroCartera != null){
			try {
				maestroCartera = carteraNgc.obtenerMaestroCartera(maestroFactura);
			} catch (ExcepcionesNGC e) {
				Messagebox.show(e.getMensajeUsuario());
			}
		}
		
		if((maestroFactura != null) && (maestroCartera != null) && (moneda != null) && (cmbTipoPago.getSelectedIndex() >= 0) && (cmbMedioPago.getSelectedIndex() >= 0) && (!txtValorPago.getText().isEmpty())){
			CartPago detallePago = new CartPago();
			detallePago.setCartCartera(maestroCartera);
			detallePago.setContMoneda(moneda);
			detallePago.setCartTipoPago(listaTipoPago.get(cmbTipoPago.getSelectedIndex()));
			detallePago.setCartFormaPago(listaFormaPago.get(cmbMedioPago.getSelectedIndex()));
			detallePago.setFepago(dtFechaActual.getValue());
			detallePago.setNmvalor(BigDecimal.valueOf(Long.parseLong(txtValorPago.getText())));
			detallePago.setDsdetalle(txtDetalles.getText());
			
			try {
				transaccionNgc.guardarTransaccion(null, 0, null);
			} catch (ExcepcionesNGC e) {
				Messagebox.show(e.getMensajeUsuario());
			}
		}
		
	}
	

	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		cargarTipoTransacciones();
		cargarDeudores();
		cargarMedioPago();
		cargarTipoPago();
	}	
}
