package co.weepa.smile.contabilidad.ctrl;

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

import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
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
	
	public void setTransaccionNgc(TransaccionNGC transaccionNgc) {
		this.transaccionNgc = transaccionNgc;
	}

	public void setTerceroNgc(TerceroNGC terceroNgc) {
		this.terceroNgc = terceroNgc;
	}



	Combobox cmbTipoComprobante;
	Combobox cmbIdTercero;
	Combobox cmbMedioPago;
	Combobox cmbBuscarFactura;
	
	Label lblSaldoTotal;
	
	Datebox dtFechaActual;
	
	Textbox txtNumeroComprobante;
	Textbox txtValorPago;
	
	Button btnGuardar;
	
	Listbox listaDeudores;
	Listbox mlistaFacturas;
	
	List<ContTransaccionTipo> listaTipoTransaccion = null;
	List<ContTercero> listadoDeudores = null;
	
	
	private void cargarDeudores(){
		
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
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		cargarTipoTransacciones();
		cargarDeudores();
	}	
}
