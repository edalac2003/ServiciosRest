package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

/**
 * DefiTipoIdentificacion generated by hbm2java
 */
public class DefiTipoIdentificacion implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dstipoIdentificacion;
	private String dsnombre;
	private String dsdescripcion;
//	private Set contTerceros = new HashSet(0);

	public DefiTipoIdentificacion() {
	}

	public DefiTipoIdentificacion(String dstipoIdentificacion) {
		this.dstipoIdentificacion = dstipoIdentificacion;
	}

	public DefiTipoIdentificacion(String dstipoIdentificacion, String dsnombre, String dsdescripcion) {
		this.dstipoIdentificacion = dstipoIdentificacion;
		this.dsnombre = dsnombre;
		this.dsdescripcion = dsdescripcion;
	}

	public String getDstipoIdentificacion() {
		return this.dstipoIdentificacion;
	}

	public void setDstipoIdentificacion(String dstipoIdentificacion) {
		this.dstipoIdentificacion = dstipoIdentificacion;
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
