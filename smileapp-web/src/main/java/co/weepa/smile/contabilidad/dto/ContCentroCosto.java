package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

/**
 * ContCentroCosto generated by hbm2java
 */
public class ContCentroCosto implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idcentroCosto;
	private String dsnombre;
	private String dsdescripcion;
//	private Set contDetalleTransaccions = new HashSet(0);

	public ContCentroCosto() {
	}

	public ContCentroCosto(String dsnombre, String dsdescripcion) {
		this.dsnombre = dsnombre;
		this.dsdescripcion = dsdescripcion;
	}

	public Integer getIdcentroCosto() {
		return this.idcentroCosto;
	}

	public void setIdcentroCosto(Integer idcentroCosto) {
		this.idcentroCosto = idcentroCosto;
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
