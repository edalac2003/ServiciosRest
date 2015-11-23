package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

/**
 * FactFacturaTipo generated by hbm2java
 */
public class FactFacturaTipo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idfacturaTipo;
	private String dsnombre;
	private String dsdescripcion;
	private String dsprefijo;
//	private Set factFacturas = new HashSet(0);

	public FactFacturaTipo() {
	}

	public FactFacturaTipo(String dsnombre, String dsdescripcion) {
		this.dsnombre = dsnombre;
		this.dsdescripcion = dsdescripcion;
	}

	public Integer getIdfacturaTipo() {
		return this.idfacturaTipo;
	}

	public void setIdfacturaTipo(Integer idfacturaTipo) {
		this.idfacturaTipo = idfacturaTipo;
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

	public String getDsprefijo() {
		return dsprefijo;
	}

	public void setDsprefijo(String dsprefijo) {
		this.dsprefijo = dsprefijo;
	}
	
}