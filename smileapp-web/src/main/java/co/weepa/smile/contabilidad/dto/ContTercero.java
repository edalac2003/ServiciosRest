package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

/**
 * ContTercero generated by hbm2java
 */
public class ContTercero implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idtercero;
	private ContClasificacionIva contClasificacionIva;
	private ContMoneda contMoneda;
	private ContTipoTercero contTipoTercero;
	private DefiActividadIca defiActividadIca;
	private DefiConceptoRf defiConceptoRf;
	private DefiTipoContribuyente defiTipoContribuyente;
	private DefiTipoIdentificacion defiTipoIdentificacion;
	private String dsidentificacion;
	private Integer nmdescuento;
	private String dstelefono;
	private String dscelular;
	private String dscorreoElectronico;
//	private Set tercTerceroRols = new HashSet(0);
//	private Set contTransaccionContables = new HashSet(0);
//	private Set tercDireccions = new HashSet(0);
//	private Set factFacturas = new HashSet(0);
//	private Set tercPersonas = new HashSet(0);
//	private Set tercTerceroClasificacions = new HashSet(0);
//	private Set cartCarteras = new HashSet(0);
//	private Set tercOrganizacions = new HashSet(0);

	public ContTercero() {
	}

	public ContTercero(long idtercero, ContTipoTercero contTipoTercero) {
		this.idtercero = idtercero;
		this.contTipoTercero = contTipoTercero;
	}

	public ContTercero(long idtercero, ContClasificacionIva contClasificacionIva, ContMoneda contMoneda,
			ContTipoTercero contTipoTercero, DefiActividadIca defiActividadIca, DefiConceptoRf defiConceptoRf,
			DefiTipoContribuyente defiTipoContribuyente, DefiTipoIdentificacion defiTipoIdentificacion,
			String dsidentificacion, Integer nmdescuento, String dstelefono, String dscelular,
			String dscorreoElectronico) {
		super();
		this.idtercero = idtercero;
		this.contClasificacionIva = contClasificacionIva;
		this.contMoneda = contMoneda;
		this.contTipoTercero = contTipoTercero;
		this.defiActividadIca = defiActividadIca;
		this.defiConceptoRf = defiConceptoRf;
		this.defiTipoContribuyente = defiTipoContribuyente;
		this.defiTipoIdentificacion = defiTipoIdentificacion;
		this.dsidentificacion = dsidentificacion;
		this.nmdescuento = nmdescuento;
		this.dstelefono = dstelefono;
		this.dscelular = dscelular;
		this.dscorreoElectronico = dscorreoElectronico;
	}

	public long getIdtercero() {
		return this.idtercero;
	}

	public void setIdtercero(long idtercero) {
		this.idtercero = idtercero;
	}

	public ContClasificacionIva getContClasificacionIva() {
		return this.contClasificacionIva;
	}

	public void setContClasificacionIva(ContClasificacionIva contClasificacionIva) {
		this.contClasificacionIva = contClasificacionIva;
	}

	public ContMoneda getContMoneda() {
		return this.contMoneda;
	}

	public void setContMoneda(ContMoneda contMoneda) {
		this.contMoneda = contMoneda;
	}

	public ContTipoTercero getContTipoTercero() {
		return this.contTipoTercero;
	}

	public void setContTipoTercero(ContTipoTercero contTipoTercero) {
		this.contTipoTercero = contTipoTercero;
	}

	public DefiActividadIca getDefiActividadIca() {
		return this.defiActividadIca;
	}

	public void setDefiActividadIca(DefiActividadIca defiActividadIca) {
		this.defiActividadIca = defiActividadIca;
	}

	public DefiConceptoRf getDefiConceptoRf() {
		return this.defiConceptoRf;
	}

	public void setDefiConceptoRf(DefiConceptoRf defiConceptoRf) {
		this.defiConceptoRf = defiConceptoRf;
	}

	public DefiTipoIdentificacion getDefiTipoIdentificacion() {
		return this.defiTipoIdentificacion;
	}

	public void setDefiTipoIdentificacion(DefiTipoIdentificacion defiTipoIdentificacion) {
		this.defiTipoIdentificacion = defiTipoIdentificacion;
	}

	public String getDsidentificacion() {
		return this.dsidentificacion;
	}

	public void setDsidentificacion(String dsidentificacion) {
		this.dsidentificacion = dsidentificacion;
	}

	public Integer getNmdescuento() {
		return this.nmdescuento;
	}

	public void setNmdescuento(Integer nmdescuento) {
		this.nmdescuento = nmdescuento;
	}

	public DefiTipoContribuyente getDefiTipoContribuyente() {
		return defiTipoContribuyente;
	}

	public void setDefiTipoContribuyente(DefiTipoContribuyente defiTipoContribuyente) {
		this.defiTipoContribuyente = defiTipoContribuyente;
	}

	public String getDstelefono() {
		return this.dstelefono;
	}

	public void setDstelefono(String dstelefono) {
		this.dstelefono = dstelefono;
	}

	public String getDscelular() {
		return this.dscelular;
	}

	public void setDscelular(String dscelular) {
		this.dscelular = dscelular;
	}

	public String getDscorreoElectronico() {
		return this.dscorreoElectronico;
	}

	public void setDscorreoElectronico(String dscorreoElectronico) {
		this.dscorreoElectronico = dscorreoElectronico;
	}
}
