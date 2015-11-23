package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

/**
 * TercTerceroClasificacion generated by hbm2java
 */
public class TercTerceroClasificacion implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idclasificacion;
	private ContTercero contTercero;
	private TercClasificacionTipo tercClasificacionTipo;
	private String dsdescripccion;

	public TercTerceroClasificacion() {
	}

	public TercTerceroClasificacion(int idclasificacion, TercClasificacionTipo tercClasificacionTipo) {
		this.idclasificacion = idclasificacion;
		this.tercClasificacionTipo = tercClasificacionTipo;
	}

	public TercTerceroClasificacion(int idclasificacion, ContTercero contTercero,
			TercClasificacionTipo tercClasificacionTipo, String dsdescripccion) {
		this.idclasificacion = idclasificacion;
		this.contTercero = contTercero;
		this.tercClasificacionTipo = tercClasificacionTipo;
		this.dsdescripccion = dsdescripccion;
	}

	public int getIdclasificacion() {
		return this.idclasificacion;
	}

	public void setIdclasificacion(int idclasificacion) {
		this.idclasificacion = idclasificacion;
	}

	public ContTercero getContTercero() {
		return this.contTercero;
	}

	public void setContTercero(ContTercero contTercero) {
		this.contTercero = contTercero;
	}

	public TercClasificacionTipo getTercClasificacionTipo() {
		return this.tercClasificacionTipo;
	}

	public void setTercClasificacionTipo(TercClasificacionTipo tercClasificacionTipo) {
		this.tercClasificacionTipo = tercClasificacionTipo;
	}

	public String getDsdescripccion() {
		return this.dsdescripccion;
	}

	public void setDsdescripccion(String dsdescripccion) {
		this.dsdescripccion = dsdescripccion;
	}

}
