package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

/**
 * TercDireccion generated by hbm2java
 */
public class TercDireccion implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int iddireccion;
	private ContTercero contTercero;
	private DefiCiudad defiCiudad;
	private DefiDepartamento defiDepartamento;
	private DefiPais defiPais;
	private Integer idtipoDireccion;
	private String dsdireccion;
	private String dsbarrio;
	private String dstelefonoFijo;

	public TercDireccion() {
	}

	public TercDireccion(int iddireccion) {
		this.iddireccion = iddireccion;
	}

	public TercDireccion(int iddireccion, ContTercero contTercero, DefiCiudad defiCiudad,
			DefiDepartamento defiDepartamento, DefiPais defiPais, Integer idtipoDireccion, String dsdireccion,
			String dsbarrio, String dstelefonoFijo) {
		this.iddireccion = iddireccion;
		this.contTercero = contTercero;
		this.defiCiudad = defiCiudad;
		this.defiDepartamento = defiDepartamento;
		this.defiPais = defiPais;
		this.idtipoDireccion = idtipoDireccion;
		this.dsdireccion = dsdireccion;
		this.dsbarrio = dsbarrio;
		this.dstelefonoFijo = dstelefonoFijo;
	}

	public int getIddireccion() {
		return this.iddireccion;
	}

	public void setIddireccion(int iddireccion) {
		this.iddireccion = iddireccion;
	}

	public ContTercero getContTercero() {
		return this.contTercero;
	}

	public void setContTercero(ContTercero contTercero) {
		this.contTercero = contTercero;
	}

	public DefiCiudad getDefiCiudad() {
		return this.defiCiudad;
	}

	public void setDefiCiudad(DefiCiudad defiCiudad) {
		this.defiCiudad = defiCiudad;
	}

	public DefiDepartamento getDefiDepartamento() {
		return this.defiDepartamento;
	}

	public void setDefiDepartamento(DefiDepartamento defiDepartamento) {
		this.defiDepartamento = defiDepartamento;
	}

	public DefiPais getDefiPais() {
		return this.defiPais;
	}

	public void setDefiPais(DefiPais defiPais) {
		this.defiPais = defiPais;
	}

	public Integer getIdtipoDireccion() {
		return this.idtipoDireccion;
	}

	public void setIdtipoDireccion(Integer idtipoDireccion) {
		this.idtipoDireccion = idtipoDireccion;
	}

	public String getDsdireccion() {
		return this.dsdireccion;
	}

	public void setDsdireccion(String dsdireccion) {
		this.dsdireccion = dsdireccion;
	}

	public String getDsbarrio() {
		return this.dsbarrio;
	}

	public void setDsbarrio(String dsbarrio) {
		this.dsbarrio = dsbarrio;
	}

	public String getDstelefonoFijo() {
		return this.dstelefonoFijo;
	}

	public void setDstelefonoFijo(String dstelefonoFijo) {
		this.dstelefonoFijo = dstelefonoFijo;
	}

}
