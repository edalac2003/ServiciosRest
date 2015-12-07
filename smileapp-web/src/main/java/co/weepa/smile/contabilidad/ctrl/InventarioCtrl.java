package co.weepa.smile.contabilidad.ctrl;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Textbox;

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
	
	Combobox cmbTipoCategoria;
	Combobox cmbSubcategoria1;
	Combobox cmbSubcategoria2;
	Combobox cmbTipoUnidades;
	Combobox cmbListaPrecios;
	Combobox cmbIVA;
	
	Listbox listaTags;
	
	Button btnGuardar;

	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
	}
}
