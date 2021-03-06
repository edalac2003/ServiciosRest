package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

/**
 * ContNormaTipo generated by hbm2java
 */
public class ContNormaTipo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -638230249941053139L;
	private String idnormaTipo;
	private String dsnombre;
	private String dsdescripcion;

	public ContNormaTipo() {
	}

	public ContNormaTipo(String idnormaTipo, String dsnombre) {
		this.idnormaTipo = idnormaTipo;
		this.dsnombre = dsnombre;
	}

	public ContNormaTipo(String idnormaTipo, String dsnombre, String dsdescripcion) {
		this.idnormaTipo = idnormaTipo;
		this.dsnombre = dsnombre;
		this.dsdescripcion = dsdescripcion;
	}

	public String getIdnormaTipo() {
		return this.idnormaTipo;
	}

	public void setIdnormaTipo(String idnormaTipo) {
		this.idnormaTipo = idnormaTipo;
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
