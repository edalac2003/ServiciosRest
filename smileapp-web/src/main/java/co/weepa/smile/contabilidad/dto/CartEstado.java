package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

/**
 * CartEstado generated by hbm2java
 */
public class CartEstado implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idestado;
	private String dsnombre;

	public CartEstado() {
	}

	public CartEstado(int idestado) {
		this.idestado = idestado;
	}

	public CartEstado(int idestado, String dsnombre) {
		this.idestado = idestado;
		this.dsnombre = dsnombre;
	}

	public int getIdestado() {
		return this.idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	public String getDsnombre() {
		return this.dsnombre;
	}

	public void setDsnombre(String dsnombre) {
		this.dsnombre = dsnombre;
	}
}
