package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

/**
 * TercTerceroRol generated by hbm2java
 */
public class TercTerceroRol implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idterceroRol;
	private ContTercero contTercero;
	private TercRolTipo tercRolTipo;
	private String dsdescripcion;

	public TercTerceroRol() {
	}

	public TercTerceroRol(int idterceroRol, ContTercero contTercero) {
		this.idterceroRol = idterceroRol;
		this.contTercero = contTercero;
	}

	public TercTerceroRol(int idterceroRol, ContTercero contTercero, TercRolTipo tercRolTipo, String dsdescripcion) {
		this.idterceroRol = idterceroRol;
		this.contTercero = contTercero;
		this.tercRolTipo = tercRolTipo;
		this.dsdescripcion = dsdescripcion;
	}

	public int getIdterceroRol() {
		return this.idterceroRol;
	}

	public void setIdterceroRol(int idterceroRol) {
		this.idterceroRol = idterceroRol;
	}

	public ContTercero getContTercero() {
		return this.contTercero;
	}

	public void setContTercero(ContTercero contTercero) {
		this.contTercero = contTercero;
	}

	public TercRolTipo getTercRolTipo() {
		return this.tercRolTipo;
	}

	public void setTercRolTipo(TercRolTipo tercRolTipo) {
		this.tercRolTipo = tercRolTipo;
	}

	public String getDsdescripcion() {
		return this.dsdescripcion;
	}

	public void setDsdescripcion(String dsdescripcion) {
		this.dsdescripcion = dsdescripcion;
	}

}
