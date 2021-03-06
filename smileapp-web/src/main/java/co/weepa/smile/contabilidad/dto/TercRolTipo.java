package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

/**
 * TercRolTipo generated by hbm2java
 */
public class TercRolTipo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idrolTipo;
	private String dsnombre;
	private String dsdescripcion;
//	private Set tercTerceroRols = new HashSet(0);

	public TercRolTipo() {
	}

	public TercRolTipo(int idrolTipo) {
		this.idrolTipo = idrolTipo;
	}

	public TercRolTipo(int idrolTipo, String dsnombre, String dsdescripcion) {
		this.idrolTipo = idrolTipo;
		this.dsnombre = dsnombre;
		this.dsdescripcion = dsdescripcion;
	}

	public int getIdrolTipo() {
		return this.idrolTipo;
	}

	public void setIdrolTipo(int idrolTipo) {
		this.idrolTipo = idrolTipo;
	}

	public String getDsnombre() {
		return this.dsnombre;
	}

	public void setDsnombre(String dsnombre) {
		this.dsnombre = dsnombre;
	}

	public String getDsdescripcion() {
		return this.dsdescripcion;
	}

	public void setDsdescripcion(String dsdescripcion) {
		this.dsdescripcion = dsdescripcion;
	}
}
