package co.weepa.smile.contabilidad.ctrl;

import java.util.List;

import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Textbox;

import co.weepa.smile.contabilidad.dto.ProdCategoria;
import co.weepa.smile.contabilidad.dto.ProdProductoCategoria;
import co.weepa.smile.contabilidad.dto.ProdProductoTipo;
import co.weepa.smile.contabilidad.ngc.ProductoCategoriaNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

@SuppressWarnings("rawtypes")
public class InventarioCtrl extends GenericForwardComposer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Radio opMateriaPrima;
	Radio opProductoProceso;
	Radio opProductoTerminado;
	
	Textbox txtNombreProducto;
	Textbox txtReferencia;	
	Textbox txtIdProducto;
	Textbox txtTags;
	Textbox txtCodigoBarras;
	Textbox txtExistencias;
	Textbox txtStockMinimo;
	Textbox txtStockMaximo;
	
	Combobox cmbTipoProducto;
	Combobox cmbSubcategoria1;
	Combobox cmbSubcategoria2;
	Combobox cmbTipoUnidades;
	Combobox cmbListaPrecios;
	Combobox cmbIVA;
	
	Listbox listaTags;
	
	Button btnGuardar;

	
	ProductoCategoriaNGC productoCategoriaNgc;
	
	public void setProductoCategoriaNgc(ProductoCategoriaNGC productoCategoriaNgc) {
		this.productoCategoriaNgc = productoCategoriaNgc;
	}


	List<ProdProductoTipo> listadoTipoProductos = null;
	List<ProdCategoria> listadoCategoriaProducto = null;
	

	private void cargarTipoProducto(){
		try {
			listadoTipoProductos = productoCategoriaNgc.listarTipoProductos();
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMensajeUsuario());
		}
		
		if((listadoTipoProductos != null) && (!listadoTipoProductos.isEmpty())){
			for(ProdProductoTipo tipoProducto : listadoTipoProductos){
				Comboitem item = new Comboitem(tipoProducto.getDsnombre());
				cmbTipoProducto.appendChild(item);
			}
		}
	}
	
	private void cargarCategorias(){
		try {
			listadoCategoriaProducto = productoCategoriaNgc.listarCategorias();
		} catch (ExcepcionesNGC e) {
			Messagebox.show(e.getMensajeUsuario());
		}
		
		if((listadoCategoriaProducto != null) && (!listadoCategoriaProducto.isEmpty())){
			Comboitem item = null;
			for(ProdCategoria categoria : listadoCategoriaProducto){
				item = new Comboitem(categoria.getDsnombre());
				cmbSubcategoria1.appendChild(item);
				item = new Comboitem(categoria.getDsnombre());
				cmbSubcategoria2.appendChild(item);
			}
		}
	}
	
	
	
	public void onOK$txtNombreProducto(){
		if(!txtNombreProducto.getText().isEmpty()){
			txtReferencia.setFocus(true);			
		}
	}
	
	public void onOK$txtReferencia(){
		if(!txtReferencia.getText().isEmpty()){
			cmbTipoProducto.setFocus(true);
		}
	}
	
	public void onOK$cmbTipoProducto(){
		if(!cmbTipoProducto.getText().isEmpty()){
			txtIdProducto.setFocus(true);
		}
	}

	public void onOK$txtIdProducto(){
		if(!txtIdProducto.getText().isEmpty()){
			cmbSubcategoria1.setFocus(true);
		}
	}
	
	public void onOK$cmbSubcategoria1(){
		cmbSubcategoria2.setFocus(true);
	}
	
	public void onOK$cmbSubcategoria2(){
		txtTags.setFocus(true);
	}
	
	public void onOK$txtTags(){
		cmbTipoUnidades.setFocus(true);
	}
	
	public void onOK$cmbTipoUnidades(){
		txtCodigoBarras.setFocus(true);
	}
	
	public void onOK$txtCodigoBarras(){
		txtExistencias.setFocus(true);
	}
	
	public void onOK$txtExistencias(){
		
	}
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		cargarTipoProducto();
		cargarCategorias();
	}
}
