package co.weepa.smile.contabilidad.ctrl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Vbox;

import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartEstado;
import co.weepa.smile.contabilidad.dto.CartFormaPago;
import co.weepa.smile.contabilidad.dto.CartPago;
import co.weepa.smile.contabilidad.dto.CartTipoPago;
import co.weepa.smile.contabilidad.dto.ContMoneda;
import co.weepa.smile.contabilidad.dto.ContOrganizacionInterna;
import co.weepa.smile.contabilidad.dto.ContPlanCuenta;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactDetalleFacturaTipo;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.FactFacturaTipo;
import co.weepa.smile.contabilidad.dto.ProdProducto;
import co.weepa.smile.contabilidad.dto.capsulas.Retenciones;
import co.weepa.smile.contabilidad.ngc.CarteraNGC;
import co.weepa.smile.contabilidad.ngc.FacturaNGC;
import co.weepa.smile.contabilidad.ngc.FacturaTipoNGC;
import co.weepa.smile.contabilidad.ngc.FacturaVentaNGC;
import co.weepa.smile.contabilidad.ngc.MonedaNGC;
import co.weepa.smile.contabilidad.ngc.OrganizacionInternaNGC;
import co.weepa.smile.contabilidad.ngc.PlanCuentaNGC;
import co.weepa.smile.contabilidad.ngc.ProductoNGC;
import co.weepa.smile.contabilidad.ngc.TerceroNGC;
import co.weepa.smile.contabilidad.ngc.TransaccionTipoNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

@SuppressWarnings("rawtypes")
public class FacturaCompraCtrl extends GenericForwardComposer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(FacturaCompraCtrl.class);
	
	TerceroNGC terceroNgc;
	ProductoNGC productoNgc;
	FacturaVentaNGC facturaVentaNgc;
	TransaccionTipoNGC transaccionTipoNgc;
	OrganizacionInternaNGC organizacionInternaNgc;
	FacturaTipoNGC facturaTipoNgc;
	CarteraNGC carteraNgc;
	FacturaNGC facturaNgc;
	MonedaNGC monedaNgc;
	PlanCuentaNGC planCuentaNgc;

	
	public void setTerceroNgc(TerceroNGC terceroNgc) {
		this.terceroNgc = terceroNgc;
	}
	
	public void setProductoNgc(ProductoNGC productoNgc) {
		this.productoNgc = productoNgc;
	}
	
	public void setFacturaVentaNgc(FacturaVentaNGC facturaVentaNgc) {
		this.facturaVentaNgc = facturaVentaNgc;
	}

	public void setTransaccionTipoNgc(TransaccionTipoNGC transaccionTipoNgc) {
		this.transaccionTipoNgc = transaccionTipoNgc;
	}

	public void setOrganizacionInternaNgc(OrganizacionInternaNGC organizacionInternaNgc) {
		this.organizacionInternaNgc = organizacionInternaNgc;
	}

	public void setFacturaTipoNgc(FacturaTipoNGC facturaTipoNgc) {
		this.facturaTipoNgc = facturaTipoNgc;
	}

	public void setCarteraNgc(CarteraNGC carteraNgc) {
		this.carteraNgc = carteraNgc;
	}
	
	public void setFacturaNgc(FacturaNGC facturaNgc) {
		this.facturaNgc = facturaNgc;
	}

	public void setMonedaNgc(MonedaNGC monedaNgc) {
		this.monedaNgc = monedaNgc;
	}

	//Aqui se definen los Objetos de la Vista
	
	public PlanCuentaNGC getPlanCuentaNgc() {
		return planCuentaNgc;
	}

	public void setPlanCuentaNgc(PlanCuentaNGC planCuentaNgc) {
		this.planCuentaNgc = planCuentaNgc;
	}

	Datebox dtFechaFactura;
	
	Label lblTipoFactura;
	
	Row rwNumeroProveedor;
	
	Textbox txtNumeroFactura;
	Textbox txtNumeroFacturaProveedor;
	Textbox txtDireccion;
	Textbox txtDescripcion;
	Textbox txtCantidad;
	Textbox txtValorUnitario;
	Textbox txtValorTotal;
	Textbox txtSubtotal;
	Textbox txtIVA;
	Textbox txtDescuento;
	Textbox txtGranTotal;
	Textbox txtAbono;
	Textbox txtNumeroCuotas;
	Textbox txtSaldoDeuda;
	Textbox txtValorIva;
	Textbox txtValorDescuento;
	Textbox txtValorRetencion;
	Textbox txtValorReteFuente;
	Textbox txtValorReteIva;
	Textbox txtValorReteICA;
	
	
	Combobox cmbTipoTransaccion;
	Combobox cmbTipoDocumento;
	Combobox cmbOrganizacion;
	Combobox cmbIdCliente;
	Combobox cmbNombres;
//	Combobox cmbApellidos;
	Combobox cmbDepartamento;
	Combobox cmbCiudad;
	Combobox cmbTelefono;
	Combobox cmbEmail;
	Combobox cmbIdArticulo;
	Combobox cmbFormaPago;
	Combobox cmbTipoPago;
	Combobox cmbMedioPago;
	Combobox cmbEstadoCartera;
	Combobox cmbFiltroPUC;
	
	Checkbox chkReteFuente;
	Checkbox chkReteIva;
	Checkbox chkReteIca;
	Radio op1AgregarInventario;
	Radio op2AgregarInventario;
	Radio op1Categoria;
	Radio op2Categoria;
	Radio op3Categoria;
	
	Button btnGuardar;
	Button btnLimpiar;
	Button btnCerrar;
	
	Datebox dtFechaVencimiento;
	Listbox listaDetalles;
	
	Groupbox cajaCredito;
	Groupbox cajaNaturaleza;
	
	ProdProducto producto = null;
	ContTercero tercero = null;
	ContOrganizacionInterna organizacion = null;
	FactFactura maestroFactura = null;
	FactDetalleFactura detalleFactura = null;
	FactFacturaTipo tipoFactura = null;
	FactDetalleFacturaTipo tipoDetalleFactura = null;
	ContTransaccionTipo tipoTransaccion = null;
	Retenciones retenciones = null;
	CartCartera maestroCartera = null;
	CartPago pagoCartera = null;
	ContPlanCuenta planCuenta = null;
	
	List<ContTercero> listaTercero = null;
	List<ProdProducto> listaProducto = null;
	List<ContTransaccionTipo> listaTipoTransaccion = null;
	List<ContOrganizacionInterna> listaOrganizacion = null;
	List<FactDetalleFactura> listaDetalleFactura =  new ArrayList<FactDetalleFactura>();
	List<CartTipoPago> listaTipoPago = null;
	List<CartFormaPago> listaFormaPago = null;
	List<CartFormaPago> listaMedioPago = null;
	List<CartEstado> listaEstadoCartera = null;
	List<FactFacturaTipo> listaTipoFactura = null;
	List<ContPlanCuenta> listaCuentasGastos = null;
	
	Date fechaActual = null;
	DateFormat formatoFecha = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	int subTotal  = 0;
	double subTotalIVA = 0.0;
	double granTotal = 0.0;
	double subTotalDescuento = 0.0;
	
	
	private void mostrarInfoTercero(ContTercero cliente){		
	}
	
	private void mostrarInfoProducto(ProdProducto articulo){
		txtDescripcion.setText(articulo.getDsnombre());
		txtValorUnitario.setText(String.valueOf(articulo.getNmprecioVenta()));
		double porcentaje = (Double.parseDouble(articulo.getNmimpuesto().toString())/100);
		double vrIva = (articulo.getNmprecioVenta() * porcentaje);
		txtValorIva.setText(String.valueOf((int)vrIva));
		txtDescuento.setText("0");
	}
	
	private void cargarTerceros(){
		try {
			listaTercero = terceroNgc.listarTodos();
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMessage());
		}
		
		if((listaTercero != null) && (!listaTercero.isEmpty())){
			for(ContTercero tercero : listaTercero){
				Comboitem item = new Comboitem(String.valueOf(tercero.getIdtercero()));
				cmbIdCliente.appendChild(item);
			}
		}
	}
	
	private void cargarProductos(){
		try {
			listaProducto = productoNgc.listarProductos();
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMessage());
		}
		
		if((listaProducto != null) && (!listaProducto.isEmpty())){
			for(ProdProducto producto : listaProducto){
				Comboitem item = new Comboitem(producto.getIdproducto());
				cmbIdArticulo.appendChild(item);
			}
		}				
	}
	
	private void cargarTipoTransaccion(){	
		
		/*
		 * Se busca el Tipo de Detalle Factura. Por Ejemplo: Articulos. Servicos, etc.
		 */
		try {
			tipoDetalleFactura = facturaTipoNgc.obtenerTipoDetalleFactura(1);
		} catch (ExcepcionesNGC e1) {
			Messagebox.show(e1.getMessage());
		}
		
		/*
		 * Se carga el listado de Tipo Transaccion para seleccionar cual se va a ejecutar.
		 */
		try {
			listaTipoTransaccion = transaccionTipoNgc.listarTipoTransacciones();
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMessage());
		}
		
		if((listaTipoTransaccion != null) && (!listaTipoTransaccion.isEmpty())){
			for(ContTransaccionTipo tipoTx : listaTipoTransaccion){
				Comboitem item = new Comboitem(tipoTx.getDsdescripcionTransaccionTipo());
				cmbTipoTransaccion.appendChild(item);
			}
		}		
	}
	
	private void cargarOrganizacionInterna(){
		try {
			organizacion = organizacionInternaNgc.obtenerOrganizacion(1);
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMessage());
		}
	}
	
	private void cargarTipoDocumento(){
		try {
			listaTipoFactura = facturaTipoNgc.listarTipoFactura();
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMensajeUsuario());
			logger.error(e.getMensajeTecnico()+" Originado por : "+e.getMessage());
		}
		
		if(listaTipoFactura != null){
			for(FactFacturaTipo tipo : listaTipoFactura){
				Comboitem item = new Comboitem(tipo.getDsnombre());
				cmbTipoDocumento.appendChild(item);
			}
		}		
	}
	
	
	/*
	 * Se asigna el Consecutivo de la Factura, pero debe hacerlo al final de la Factura cuando esta se haya guardado.
	 */
	private void asignarConsecutivo(FactFacturaTipo tipoFactura){
		String consecutivo = "";
		/*
		 * Este fragmento de codigo se reemplaza para obtenerlo directamente desde la Lista de Tipo Factura, la cual est√° ligada al objeto cmbTipoFactura.
		 */
//		try {
//			tipoFactura = facturaTipoNgc.obtenerTipoFactura(2);
//		} catch (ExcepcionesNGC e1) {
//			Messagebox.show(e1.getMensajeUsuario());
//		}
		
		/*
		 * Se busca y asigna el Consecutivo correspondiente a la Factura de Venta.
		 */
		if (tipoFactura != null){
			try {
				consecutivo = facturaNgc.consecutivoFactura(tipoFactura);
			} catch (ExcepcionesNGC e) {
				Messagebox.show(e.getMensajeTecnico());
				logger.error(e.getMensajeTecnico()+" Originado por : "+e.getMessage());
			}
			txtNumeroFactura.setText(consecutivo);
		}
		
	}
	
	
	private void cargarElementosCredito(){
		try {
			listaEstadoCartera = carteraNgc.listarEstadoCartera();
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMessage());
		}
		
		try {
			listaFormaPago = carteraNgc.listarFormaPago();
			listaMedioPago = carteraNgc.listarFormaPago();
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMessage());
		}
		
		try {
			listaTipoPago = carteraNgc.listarTipoPago();			
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMessage());
		}
		
		if(!listaEstadoCartera.isEmpty()){
			for(CartEstado estadoCartera : listaEstadoCartera){
				Comboitem item = new Comboitem(estadoCartera.getDsnombre());
				cmbEstadoCartera.appendChild(item);
			}
		}
		
		if(!listaFormaPago.isEmpty()){
			for(CartFormaPago formaPago : listaFormaPago){
				Comboitem item = new Comboitem(formaPago.getDsnombre());
				cmbFormaPago.appendChild(item);
			}
		}
		if (listaTipoPago != null){
			for(CartTipoPago tipoPago : listaTipoPago){
				Comboitem item = new Comboitem(tipoPago.getDsnombre());
				cmbTipoPago.appendChild(item);
			}
		}		
	}
	
	private void eliminaListItem(Listitem listItem){
		Listcell celdaIVA = (Listcell)listItem.getChildren().get(4);
		Listcell celdaDescuento = (Listcell)listItem.getChildren().get(5);
		Listcell celdaSubtotal = (Listcell)listItem.getChildren().get(6);
		subTotalIVA = subTotalIVA - Integer.parseInt(celdaIVA.getLabel());
		subTotalDescuento = subTotalDescuento - Integer.parseInt(celdaDescuento.getLabel());
		subTotal = subTotal - Integer.parseInt(celdaSubtotal.getLabel());
		listItem.detach();
		if (listaDetalleFactura.isEmpty()){
			granTotal = 0;
			subTotalIVA = 0;
			subTotalDescuento = 0;
		}else{
			txtSubtotal.setText(String.valueOf(subTotal));
			granTotal = (subTotal + subTotalIVA) - subTotalDescuento;
			txtGranTotal.setText(String.valueOf(granTotal));
		}
		
	}
	
	private void ingresarArticuloFactura(){		
		final Listitem listaItem = new Listitem();
		listaItem.addEventListener(Events.ON_DOUBLE_CLICK, new EventListener<Event>() {
			public void onEvent(Event arg0) throws Exception {
				eliminaListItem(listaItem);
			}
		});
		Listcell celdaArticulo = new Listcell(cmbIdArticulo.getText());
		Listcell celdaDescripcion = new Listcell(txtDescripcion.getText());
		Listcell celdaCantidad = new Listcell(txtCantidad.getText());
		Listcell celdaValorUnitario = new Listcell(txtValorUnitario.getText());
		Listcell celdaValorIVA = new Listcell(txtValorIva.getText());
		Listcell celdaValorDescuento = new Listcell(txtValorDescuento.getText());
		Listcell celdaRetencion = new Listcell(txtValorRetencion.getText());
		Listcell celdaCuentaPUC = new Listcell(cmbFiltroPUC.getText());
		Listcell celdaValorTotal = new Listcell(txtValorTotal.getText());
		
		double descuento = 0.0;
		if (!txtValorDescuento.getText().isEmpty()){
			if(txtValorDescuento.getText().contains("%")){
				String[] dato = txtValorDescuento.getText().split("%");
				descuento = Double.parseDouble(dato[0])/100.0;
			}else if (Integer.parseInt(txtValorDescuento.getText()) >= 0){
				descuento = Integer.parseInt(txtValorDescuento.getText());
			}else{
				descuento = 0;
			}			
			subTotalDescuento = subTotalDescuento + descuento;
		}
		
		int totalProducto = Integer.parseInt(txtCantidad.getText())*Integer.parseInt(txtValorUnitario.getText());
		subTotal = subTotal + totalProducto; 
		double iva = 0.0;
//		double porcentaje = 0.0;
//		if(producto.getNmimpuesto()>0){
//			int impuestoProducto = producto.getNmimpuesto();
//			porcentaje =  impuestoProducto/100.0;
//			iva = Integer.parseInt(txtValorTotal.getValue())*porcentaje;
//		}
		if(txtValorIva.getText().isEmpty()){
			txtValorIva.setText("0");
			iva = 0;
		}else{
			if (txtValorIva.getText().contains("%")){
				String[] dato = txtValorIva.getText().split("%");
				iva = Double.parseDouble(dato[0])/100.0;				
			}else if (Double.parseDouble(txtValorIva.getText()) > 0){
				iva = Double.parseDouble(txtValorIva.getText());
			}else{
				iva = 0;
			}
			subTotalIVA = subTotalIVA + iva;
			txtIVA.setText(String.valueOf((int)subTotalIVA));
			granTotal = (subTotal + subTotalIVA) - subTotalDescuento;
			txtGranTotal.setText(String.valueOf(granTotal));
		}
		
//		subTotalIVA = subTotalIVA + iva;
//		granTotal = (subTotal + subTotalIVA) - subTotalDescuento;
		
		listaItem.appendChild(celdaArticulo);
		listaItem.appendChild(celdaDescripcion);
		listaItem.appendChild(celdaCantidad);
		listaItem.appendChild(celdaValorUnitario);
		listaItem.appendChild(celdaValorIVA);
		listaItem.appendChild(celdaRetencion);
		listaItem.appendChild(celdaCuentaPUC);
		listaItem.appendChild(celdaValorDescuento);
		listaItem.appendChild(celdaValorTotal);
		
		listaDetalles.appendChild(listaItem);
		txtIVA.setText(String.valueOf((int)subTotalIVA));
		txtDescuento.setText(String.valueOf((int)subTotalDescuento));
		txtSubtotal.setText(String.valueOf(subTotal));
		txtGranTotal.setText(String.valueOf(granTotal));
		
		detalleFactura = new FactDetalleFactura();
		detalleFactura.setFactDetalleFacturaTipo(tipoDetalleFactura);
		detalleFactura.setFactFactura(null);
		detalleFactura.setProdProducto(producto);
		detalleFactura.setNmcantidad(Integer.parseInt(txtCantidad.getText()));
		detalleFactura.setNmprecio(Integer.parseInt(txtValorUnitario.getText()));
		detalleFactura.setNmimpuesto((int)iva);
		detalleFactura.setNmdescuento(Integer.parseInt(txtValorDescuento.getText()));
		detalleFactura.setNmsubtotal(totalProducto);
		
		listaDetalleFactura.add(detalleFactura);
		
		cmbIdArticulo.setText("");
		txtDescripcion.setText("");
		txtCantidad.setText("");
		txtValorUnitario.setText("");
		txtValorTotal.setText("");
		txtValorIva.setText("");
		txtValorDescuento.setText("");
		cmbIdArticulo.focus();
	}
	
	public void onSelect$cmbIdCliente(){
		tercero = listaTercero.get(cmbIdCliente.getSelectedIndex());
		mostrarInfoTercero(tercero);
	}
	
	public void onSelect$cmbIdArticulo(){
		producto = listaProducto.get(cmbIdArticulo.getSelectedIndex());
		mostrarInfoProducto(producto);
	}
	
	public void onOK$txtCantidad(){
		if (!txtCantidad.equals(""))
			txtValorUnitario.focus();
	}
	
	
	public void onOK$txtValorUnitario(){
		if((!txtValorUnitario.equals("")) && (Integer.parseInt(txtValorUnitario.getValue()) > 0)){
			int totalxProducto = Integer.parseInt(txtCantidad.getText()) * Integer.parseInt(txtValorUnitario.getText());
			txtValorTotal.setText(String.valueOf(totalxProducto));
			txtValorIva.focus();
		}		
	}
	
	/*
	 * Es el calculo del valor de IVA producto a producto
	 */
	public void onOK$txtValorIva(){
		if(txtValorIva.getText().isEmpty()){
			txtValorIva.setText("0");
		}
//		txtIVA.setText(String.valueOf(subTotalIVA));
//		txtValorTotal.setText(String.valueOf(totalxProducto));
		txtValorDescuento.focus();			
	}
	
	/*
	 * Se calcula el descuento producto a producto
	 */
	public void onOK$txtValorDescuento(){
		if (txtValorDescuento.getText().isEmpty())
			txtValorDescuento.setText("0");		
		txtValorRetencion.focus();
	}
	
	public void onOK$txtValorRetencion(){
		if (!txtValorRetencion.getText().isEmpty()){
			cmbFiltroPUC.focus();
		}
	}
	
	public void onOK$cmbFiltroPUC() {
		if (!cmbFiltroPUC.getText().isEmpty()){
			ingresarArticuloFactura();
		}
	}
	
	
	public void onOK$txtIVA(){
		/*
		 * Comprueba si el IVA fue ingresado manualmente
		 */
		if (!txtIVA.getText().isEmpty()){
			subTotalIVA = subTotalIVA + Double.parseDouble(txtIVA.getText());
			granTotal = (subTotal + subTotalIVA) - subTotalDescuento;
			txtGranTotal.setText(String.valueOf(granTotal));
		}	
	}
	
	public void onOK$txtDescuento(){
		subTotalDescuento = Integer.parseInt(txtDescuento.getText());
		granTotal = (subTotal + subTotalIVA) - subTotalDescuento;
		txtGranTotal.setText(String.valueOf(granTotal));
	}
	
	public void onSelect$cmbTipoTransaccion(){
		tipoTransaccion = listaTipoTransaccion.get(cmbTipoTransaccion.getSelectedIndex());
	}
	
	public void onSelect$cmbFormaPago(){
		if(cmbFormaPago.getSelectedIndex() > 0){
			if (cmbFormaPago.getText().contains("CREDITO")){
				cajaCredito.setVisible(true);
			}else{
				cajaCredito.setVisible(false);
			}
		}		
	}
	
	public void onSelect$cmbTipoDocumento(){
		if(cmbTipoDocumento.getSelectedIndex() >= 0){
			String mensaje = "";
			asignarConsecutivo(listaTipoFactura.get(cmbTipoDocumento.getSelectedIndex()));
			if(cmbTipoDocumento.getText().contains("COMPRA")){
				cajaNaturaleza.setVisible(true);
				rwNumeroProveedor.setVisible(true);
				mensaje="Factura de Compra No.";
			}else if(cmbTipoDocumento.getText().contains("VENTA")){
				cajaNaturaleza.setVisible(false);
				rwNumeroProveedor.setVisible(false);
				mensaje="Factura de Venta No.";
			}if(cmbTipoDocumento.getText().contains("COTIZACION")){
				cajaCredito.setVisible(false);
				cajaNaturaleza.setVisible(false);
				rwNumeroProveedor.setVisible(false);
				mensaje="CotizaciÛn No.";
			}
			
			lblTipoFactura.setValue(mensaje);
		}
	}
	
	public void onClick$btnGuardar(){
		/*
		 * Se busca el Tipo de Factura a Generar. Por Ejemplo Factura de Venta
		 */
		tipoFactura = listaTipoFactura.get(cmbTipoDocumento.getSelectedIndex());
		
		if(listaDetalles.getItems().size() > 0){
			maestroFactura = new FactFactura();
			maestroFactura.setDsnumeroFactura(txtNumeroFactura.getText());
			maestroFactura.setFactFacturaTipo(tipoFactura);
			maestroFactura.setFefactura(fechaActual);
			maestroFactura.setDsdescripcion("Descripcion de la Factura "+txtNumeroFactura.getText());
			maestroFactura.setNmvalorTotal(BigDecimal.valueOf(Double.parseDouble(txtGranTotal.getText())));
			maestroFactura.setContOrganizacionInterna(organizacion);
			maestroFactura.setContTercero(tercero);
			
			for(int i = 0; i<listaDetalleFactura.size(); i++){
				listaDetalleFactura.get(i).setFactFactura(maestroFactura);
			}			
			
			if((cmbTipoDocumento.getText().contains("FACTURA") && (cmbTipoDocumento.getText().contains("VENTA")))){
				if(cajaCredito.isVisible()){
//					if((Integer.parseInt(txtValorReteFuente.getValue())>= 0) || (Integer.parseInt(txtValorReteIva.getValue())>= 0) || 
//							(Integer.parseInt(txtValorReteICA.getValue())>= 0)){
						retenciones = new Retenciones();
						retenciones.setReteFuente((txtValorReteFuente.getText().length() > 0)?Double.parseDouble(txtValorReteFuente.getText()):0);
						retenciones.setReteIva((txtValorReteIva.getText().length() > 0)?Double.parseDouble(txtValorReteIva.getText()):0);
						retenciones.setReteICA((txtValorReteICA.getText().length() > 0)?Double.parseDouble(txtValorReteICA.getText()):0);
//					}
				}
				
				/*
				 * Informacion Adicional en caso que la factura sea a Credito y se genere un movimiento de Cartera.
				 */
				if (cmbFormaPago.getText().contains("CREDITO")){
					ContMoneda moneda = null;
					CartEstado estadoCartera = null;
					CartFormaPago formaPago = null;
					
					if(cmbEstadoCartera.getSelectedIndex() >=0){
						estadoCartera = listaEstadoCartera.get(cmbEstadoCartera.getSelectedIndex());
					}
					if(cmbMedioPago.getSelectedIndex() >= 0){
						formaPago = listaMedioPago.get(cmbMedioPago.getSelectedIndex());
					}				
					
					try {
						moneda = monedaNgc.obtenerMoneda(1);
					} catch (ExcepcionesNGC e) {
						Messagebox.show(e.getMensajeUsuario());
					}
					
					maestroCartera = new CartCartera();
					maestroCartera.setFactFactura(maestroFactura);
					maestroCartera.setContTercero(tercero);
					maestroCartera.setContPlanCuenta(null);
					maestroCartera.setCartEstado(estadoCartera);
					maestroCartera.setFevencimiento(dtFechaVencimiento.getValue());
					maestroCartera.setNmcuotas(Integer.parseInt(txtNumeroCuotas.getText()));
					maestroCartera.setNmsaldo(BigDecimal.valueOf(Double.parseDouble(txtSaldoDeuda.getText())));
					if((cmbTipoPago.getSelectedIndex() >= 0) && (Double.parseDouble(txtAbono.getText()) > 0)){
						pagoCartera = new CartPago();
						pagoCartera.setCartCartera(maestroCartera);
						pagoCartera.setContMoneda(moneda);
						pagoCartera.setFepago(fechaActual);
						pagoCartera.setNmvalor(BigDecimal.valueOf(Double.parseDouble(txtAbono.getText())));
						pagoCartera.setDsdetalle("DETALLE DEL PAGO");
						pagoCartera.setCartFormaPago(formaPago);
					}
				}
				
				
			
			}
			
//			if(cmbTipoDocumento.getText().contains("FACTURA DE VENTA")){
//				/*
//				 * Una vez comprobados los datos requeridos, se procede a guardar la factura.
//				 */
//				try {
//					facturaVentaNgc.guardarFactura(cmbIdCliente.getText(), organizacion.getIdorganizacionInterna(), tipoTransaccion.getIdtransaccionTipo(), 
//							maestroFactura, cmbFormaPago.getSelectedIndex(), cmbMedioPago.getSelectedIndex(), listaDetalleFactura, retenciones, maestroCartera, pagoCartera);
//					Messagebox.show("Factura de Venta Guardada Satisfactoriamente");
//				} catch (ExcepcionesNGC e) {
//					Messagebox.show(e.getMensajeUsuario());
//					logger.error("Error : "+e.getMensajeTecnico());
//				}
//			}else if (cmbTipoDocumento.getText().contains("COTIZACION")){
//				
//				try {
//					facturaVentaNgc.guardarCotizacion(cmbIdArticulo.getText(), 1, maestroFactura, listaDetalleFactura);
//					Messagebox.show("Cotizacion Guardada Satisfactoriamente");
//				} catch (ExcepcionesNGC e) {
//					Messagebox.show(e.getMensajeUsuario());
//				}
//			}else if (cmbTipoDocumento.getText().contains("COMPRA")){
//				
//			}
				
			try {
				facturaVentaNgc.guardarFacturaCompra(cmbIdCliente.getText(), organizacion.getIdorganizacionInterna(), tipoTransaccion.getIdtransaccionTipo(), 
						maestroFactura, cmbFormaPago.getSelectedIndex(), cmbMedioPago.getSelectedIndex(), listaDetalleFactura, retenciones, maestroCartera, pagoCartera);
			} catch (WrongValueException e) {
				
				e.printStackTrace();
			} catch (ExcepcionesNGC e) {
				
				e.printStackTrace();
			}
		}else{
			Messagebox.show("No hay nada para guardar");
		}		
	}
	
	private void cargarCuentasGastos(){
		List<ContPlanCuenta> lista = null;
		try {
			lista = planCuentaNgc.listarCuentasxGrupo(51);				
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMensajeUsuario());
		}
		
		if ((lista != null) && (!lista.isEmpty())){
			for(ContPlanCuenta cuenta : lista){
				Comboitem item = new Comboitem(cuenta.getIdcuenta()+" - "+cuenta.getDsnombre());
				cmbFiltroPUC.appendChild(item);
			}
		}else{
			logger.info("No hay cuentas de Gastos para mostrar");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		cargarTipoTransaccion();
		cargarTipoDocumento();
		cargarTerceros();
		cargarProductos();
		cargarOrganizacionInterna();
		cargarElementosCredito();
		cargarCuentasGastos();
		
	}
}
