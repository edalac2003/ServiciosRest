package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

/**
 * ProdTalla generated by hbm2java
 */
public class ProdTalla implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idtalla;
	private String dsdescripcion;
//	private Set prodProductos = new HashSet(0);

	public ProdTalla() {
	}

	public ProdTalla(int idtalla) {
		this.idtalla = idtalla;
	}

	public ProdTalla(int idtalla, String dsdescripcion) {
		this.idtalla = idtalla;
		this.dsdescripcion = dsdescripcion;
	}

	public int getIdtalla() {
		return this.idtalla;
	}

	public void setIdtalla(int idtalla) {
		this.idtalla = idtalla;
	}

	public String getDsdescripcion() {
		return this.dsdescripcion;
	}

	public void setDsdescripcion(String dsdescripcion) {
		this.dsdescripcion = dsdescripcion;
	}
}
