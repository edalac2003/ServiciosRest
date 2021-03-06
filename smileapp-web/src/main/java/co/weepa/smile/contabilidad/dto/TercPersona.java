package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * TercPersona generated by hbm2java
 */
public class TercPersona implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idpersona;
	private ContTercero contTercero;
	private String dsprimerNombre;
	private String dssegundoNombre;
	private String dsprimerApellido;
	private String dssegundoApellido;
	private Date fenacimiento;
	private String idgenero;
	private String dsestadoCivil;
	private String dscomentario;

	public TercPersona() {
	}

	public TercPersona(int idpersona, String dsprimerNombre, String dsprimerApellido) {
		this.idpersona = idpersona;
		this.dsprimerNombre = dsprimerNombre;
		this.dsprimerApellido = dsprimerApellido;
	}

	public TercPersona(int idpersona, ContTercero contTercero, String dsprimerNombre, String dssegundoNombre,
			String dsprimerApellido, String dssegundoApellido, Date fenacimiento, String idgenero, String dsestadoCivil,
			String dscomentario) {
		this.idpersona = idpersona;
		this.contTercero = contTercero;
		this.dsprimerNombre = dsprimerNombre;
		this.dssegundoNombre = dssegundoNombre;
		this.dsprimerApellido = dsprimerApellido;
		this.dssegundoApellido = dssegundoApellido;
		this.fenacimiento = fenacimiento;
		this.idgenero = idgenero;
		this.dsestadoCivil = dsestadoCivil;
		this.dscomentario = dscomentario;
	}

	public int getIdpersona() {
		return this.idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public ContTercero getContTercero() {
		return this.contTercero;
	}

	public void setContTercero(ContTercero contTercero) {
		this.contTercero = contTercero;
	}

	public String getDsprimerNombre() {
		return this.dsprimerNombre;
	}

	public void setDsprimerNombre(String dsprimerNombre) {
		this.dsprimerNombre = dsprimerNombre;
	}

	public String getDssegundoNombre() {
		return this.dssegundoNombre;
	}

	public void setDssegundoNombre(String dssegundoNombre) {
		this.dssegundoNombre = dssegundoNombre;
	}

	public String getDsprimerApellido() {
		return this.dsprimerApellido;
	}

	public void setDsprimerApellido(String dsprimerApellido) {
		this.dsprimerApellido = dsprimerApellido;
	}

	public String getDssegundoApellido() {
		return this.dssegundoApellido;
	}

	public void setDssegundoApellido(String dssegundoApellido) {
		this.dssegundoApellido = dssegundoApellido;
	}

	public Date getFenacimiento() {
		return this.fenacimiento;
	}

	public void setFenacimiento(Date fenacimiento) {
		this.fenacimiento = fenacimiento;
	}

	public String getIdgenero() {
		return this.idgenero;
	}

	public void setIdgenero(String idgenero) {
		this.idgenero = idgenero;
	}

	public String getDsestadoCivil() {
		return this.dsestadoCivil;
	}

	public void setDsestadoCivil(String dsestadoCivil) {
		this.dsestadoCivil = dsestadoCivil;
	}

	public String getDscomentario() {
		return this.dscomentario;
	}

	public void setDscomentario(String dscomentario) {
		this.dscomentario = dscomentario;
	}

}
