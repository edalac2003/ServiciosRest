package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

/**
 * TercTerceroCuenta generated by hbm2java
 */
public class TercTerceroCuenta implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3281467441883180379L;
	private int idterceroCuenta;
	private ContTercero contTercero;
	private DefiTransaccionAccion defiTransaccionAccion;

	public TercTerceroCuenta() {
	}

	public TercTerceroCuenta(int idterceroCuenta) {
		this.idterceroCuenta = idterceroCuenta;
	}

	public TercTerceroCuenta(int idterceroCuenta, ContTercero contTercero,
			DefiTransaccionAccion defiTransaccionAccion) {
		super();
		this.idterceroCuenta = idterceroCuenta;
		this.contTercero = contTercero;
		this.defiTransaccionAccion = defiTransaccionAccion;
	}

	public int getIdterceroCuenta() {
		return this.idterceroCuenta;
	}

	public void setIdterceroCuenta(int idterceroCuenta) {
		this.idterceroCuenta = idterceroCuenta;
	}

	public DefiTransaccionAccion getDefiTransaccionAccion() {
		return this.defiTransaccionAccion;
	}

	public void setDefiTransaccionAccion(DefiTransaccionAccion defiTransaccionAccion) {
		this.defiTransaccionAccion = defiTransaccionAccion;
	}

	public ContTercero getContTercero() {
		return contTercero;
	}

	public void setContTercero(ContTercero contTercero) {
		this.contTercero = contTercero;
	}
}
