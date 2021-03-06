package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * RrhhUsuarioRoles generated by hbm2java
 */
public class RrhhUsuarioRoles implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idusuarioRol;
	private RrhhRolTipo rrhhRolTipo;
	private RrhhRoles rrhhRoles;
	private RrhhUsuario rrhhUsuario;
	private Date feactivacion;
//	private Set rrhhRolesAplicativos = new HashSet(0);
//	private Set rrhhRolesOrganizacioneses = new HashSet(0);

	public RrhhUsuarioRoles() {
	}

	public RrhhUsuarioRoles(int idusuarioRol) {
		this.idusuarioRol = idusuarioRol;
	}

	public RrhhUsuarioRoles(int idusuarioRol, RrhhRolTipo rrhhRolTipo, RrhhRoles rrhhRoles, RrhhUsuario rrhhUsuario,
			Date feactivacion) {
		this.idusuarioRol = idusuarioRol;
		this.rrhhRolTipo = rrhhRolTipo;
		this.rrhhRoles = rrhhRoles;
		this.rrhhUsuario = rrhhUsuario;
		this.feactivacion = feactivacion;
	}

	public int getIdusuarioRol() {
		return this.idusuarioRol;
	}

	public void setIdusuarioRol(int idusuarioRol) {
		this.idusuarioRol = idusuarioRol;
	}

	public RrhhRolTipo getRrhhRolTipo() {
		return this.rrhhRolTipo;
	}

	public void setRrhhRolTipo(RrhhRolTipo rrhhRolTipo) {
		this.rrhhRolTipo = rrhhRolTipo;
	}

	public RrhhRoles getRrhhRoles() {
		return this.rrhhRoles;
	}

	public void setRrhhRoles(RrhhRoles rrhhRoles) {
		this.rrhhRoles = rrhhRoles;
	}

	public RrhhUsuario getRrhhUsuario() {
		return this.rrhhUsuario;
	}

	public void setRrhhUsuario(RrhhUsuario rrhhUsuario) {
		this.rrhhUsuario = rrhhUsuario;
	}

	public Date getFeactivacion() {
		return this.feactivacion;
	}

	public void setFeactivacion(Date feactivacion) {
		this.feactivacion = feactivacion;
	}
}
