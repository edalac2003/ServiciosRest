package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

/**
 * ContTipoTercero generated by hbm2java
 */
public class ContTipoTercero implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idtipoTercero;
	private String dsnombreTipoTercero;
//	private Set contTerceros = new HashSet(0);

	public ContTipoTercero() {
	}

	public ContTipoTercero(Integer idtipoTercero) {
		super();
		this.idtipoTercero = idtipoTercero;
	}

	public Integer getIdtipoTercero() {
		return this.idtipoTercero;
	}

	public void setIdtipoTercero(Integer idtipoTercero) {
		this.idtipoTercero = idtipoTercero;
	}

	public String getDsnombreTipoTercero() {
		return this.dsnombreTipoTercero;
	}

	public void setDsnombreTipoTercero(String dsnombreTipoTercero) {
		this.dsnombreTipoTercero = dsnombreTipoTercero;
	}
}
