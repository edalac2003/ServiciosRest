package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

/**
 * ContTransaccionTipo generated by hbm2java
 */
public class ContTransaccionTipo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idtransaccionTipo;
	private String dsdescripcionTransaccionTipo;
	private String dsprefijo;

	public ContTransaccionTipo() {
	}

	public ContTransaccionTipo(Integer idtransaccionTipo, String dsdescripcionTransaccionTipo) {
		super();
		this.idtransaccionTipo = idtransaccionTipo;
		this.dsdescripcionTransaccionTipo = dsdescripcionTransaccionTipo;
	}

	public ContTransaccionTipo(Integer idtransaccionTipo, String dsdescripcionTransaccionTipo, String dsprefijo) {
		super();
		this.idtransaccionTipo = idtransaccionTipo;
		this.dsdescripcionTransaccionTipo = dsdescripcionTransaccionTipo;
		this.dsprefijo = dsprefijo;
	}

	public Integer getIdtransaccionTipo() {
		return this.idtransaccionTipo;
	}

	public void setIdtransaccionTipo(Integer idtransaccionTipo) {
		this.idtransaccionTipo = idtransaccionTipo;
	}

	public String getDsdescripcionTransaccionTipo() {
		return this.dsdescripcionTransaccionTipo;
	}

	public void setDsdescripcionTransaccionTipo(String dsdescripcionTransaccionTipo) {
		this.dsdescripcionTransaccionTipo = dsdescripcionTransaccionTipo;
	}

	public String getDsprefijo() {
		return dsprefijo;
	}

	public void setDsprefijo(String dsprefijo) {
		this.dsprefijo = dsprefijo;
	}	
}
