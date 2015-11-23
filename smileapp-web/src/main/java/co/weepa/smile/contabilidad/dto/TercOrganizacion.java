package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

/**
 * TercOrganizacion generated by hbm2java
 */
public class TercOrganizacion implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idorganizacion;
	private ContTercero contTercero;
	private Integer idtipoOrganizacion;
	private Boolean nmdigitoChequeo;
	private String dsrazonSocial;
	private String dssigla;
	private String dsdescripcion;
	private String dscontacto;
	private String dsrepresentante;

	public TercOrganizacion() {
	}

	public TercOrganizacion(int idorganizacion, ContTercero contTercero) {
		this.idorganizacion = idorganizacion;
		this.contTercero = contTercero;
	}

	public TercOrganizacion(int idorganizacion, ContTercero contTercero, Integer idtipoOrganizacion,
			Boolean nmdigitoChequeo, String dsrazonSocial, String dssigla, String dsdescripcion, String dscontacto,
			String dsrepresentante) {
		this.idorganizacion = idorganizacion;
		this.contTercero = contTercero;
		this.idtipoOrganizacion = idtipoOrganizacion;
		this.nmdigitoChequeo = nmdigitoChequeo;
		this.dsrazonSocial = dsrazonSocial;
		this.dssigla = dssigla;
		this.dsdescripcion = dsdescripcion;
		this.dscontacto = dscontacto;
		this.dsrepresentante = dsrepresentante;
	}

	public int getIdorganizacion() {
		return this.idorganizacion;
	}

	public void setIdorganizacion(int idorganizacion) {
		this.idorganizacion = idorganizacion;
	}

	public ContTercero getContTercero() {
		return this.contTercero;
	}

	public void setContTercero(ContTercero contTercero) {
		this.contTercero = contTercero;
	}

	public Integer getIdtipoOrganizacion() {
		return this.idtipoOrganizacion;
	}

	public void setIdtipoOrganizacion(Integer idtipoOrganizacion) {
		this.idtipoOrganizacion = idtipoOrganizacion;
	}

	public Boolean getNmdigitoChequeo() {
		return this.nmdigitoChequeo;
	}

	public void setNmdigitoChequeo(Boolean nmdigitoChequeo) {
		this.nmdigitoChequeo = nmdigitoChequeo;
	}

	public String getDsrazonSocial() {
		return this.dsrazonSocial;
	}

	public void setDsrazonSocial(String dsrazonSocial) {
		this.dsrazonSocial = dsrazonSocial;
	}

	public String getDssigla() {
		return this.dssigla;
	}

	public void setDssigla(String dssigla) {
		this.dssigla = dssigla;
	}

	public String getDsdescripcion() {
		return this.dsdescripcion;
	}

	public void setDsdescripcion(String dsdescripcion) {
		this.dsdescripcion = dsdescripcion;
	}

	public String getDscontacto() {
		return this.dscontacto;
	}

	public void setDscontacto(String dscontacto) {
		this.dscontacto = dscontacto;
	}

	public String getDsrepresentante() {
		return this.dsrepresentante;
	}

	public void setDsrepresentante(String dsrepresentante) {
		this.dsrepresentante = dsrepresentante;
	}

}
