package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

public class ContPlanCuenta implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idcuenta;
	private ContCuentaGrupo contCuentaGrupo;
	private String dsnombre;
	private String dsdescripccion;
//	private Set cartCarteras = new HashSet(0);
//	private Set defiTransaccionAccions = new HashSet(0);
//	private Set contDetalleTransaccions = new HashSet(0);
	
	public ContPlanCuenta() {
	}

	public ContPlanCuenta(int idcuenta, ContCuentaGrupo contCuentaGrupo, String dsnombre) {
		this.idcuenta = idcuenta;
		this.contCuentaGrupo = contCuentaGrupo;
		this.dsnombre = dsnombre;
	}

	public ContPlanCuenta(int idcuenta, ContCuentaGrupo contCuentaGrupo, String dsnombre, String dsdescripccion) {
		this.idcuenta = idcuenta;
		this.contCuentaGrupo = contCuentaGrupo;
		this.dsnombre = dsnombre;
		this.dsdescripccion = dsdescripccion;
	}

	public int getIdcuenta() {
		return this.idcuenta;
	}

	public void setIdcuenta(int idcuenta) {
		this.idcuenta = idcuenta;
	}

	public ContCuentaGrupo getContCuentaGrupo() {
		return this.contCuentaGrupo;
	}

	public void setContCuentaGrupo(ContCuentaGrupo contCuentaGrupo) {
		this.contCuentaGrupo = contCuentaGrupo;
	}

	public String getDsnombre() {
		return this.dsnombre;
	}

	public void setDsnombre(String dsnombre) {
		this.dsnombre = dsnombre;
	}

	public String getDsdescripccion() {
		return this.dsdescripccion;
	}

	public void setDsdescripccion(String dsdescripccion) {
		this.dsdescripccion = dsdescripccion;
	}

}
