package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;

/**
 * ContTransaccionContable generated by hbm2java
 */
public class ContTransaccionContable implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idtransaccion;
	private ContMoneda contMoneda;
	private ContOrganizacionInterna contOrganizacionInterna;
	private ContTercero contTercero;
	private ContTransaccionTipo contTransaccionTipo;
	private Date fetransaccion;
	private BigDecimal nmvalorTransaccion;
	private BigDecimal nmvalorMoneda;
	private String dsdescripcionTransaccion;
	private String dsnumeroDocumento;
	private String dsnumeroTransaccion;

	public ContTransaccionContable() {
	}

	public ContTransaccionContable(ContMoneda contMoneda, ContOrganizacionInterna contOrganizacionInterna,
			ContTercero contTercero, ContTransaccionTipo contTransaccionTipo) {
		this.contMoneda = contMoneda;
		this.contOrganizacionInterna = contOrganizacionInterna;
		this.contTercero = contTercero;
		this.contTransaccionTipo = contTransaccionTipo;
	}

	public ContTransaccionContable(ContMoneda contMoneda, ContOrganizacionInterna contOrganizacionInterna,
			ContTercero contTercero, ContTransaccionTipo contTransaccionTipo, Date fetransaccion,
			BigDecimal nmvalorTransaccion, BigDecimal nmvalorMoneda, String dsdescripcionTransaccion,
			String dsnumeroDocumento) {
		this.contMoneda = contMoneda;
		this.contOrganizacionInterna = contOrganizacionInterna;
		this.contTercero = contTercero;
		this.contTransaccionTipo = contTransaccionTipo;
		this.fetransaccion = fetransaccion;
		this.nmvalorTransaccion = nmvalorTransaccion;
		this.nmvalorMoneda = nmvalorMoneda;
		this.dsdescripcionTransaccion = dsdescripcionTransaccion;
		this.dsnumeroDocumento = dsnumeroDocumento;
	}

	public Integer getIdtransaccion() {
		return this.idtransaccion;
	}

	public void setIdtransaccion(Integer idtransaccion) {
		this.idtransaccion = idtransaccion;
	}

	public ContMoneda getContMoneda() {
		return this.contMoneda;
	}

	public void setContMoneda(ContMoneda contMoneda) {
		this.contMoneda = contMoneda;
	}

	public ContOrganizacionInterna getContOrganizacionInterna() {
		return this.contOrganizacionInterna;
	}

	public void setContOrganizacionInterna(ContOrganizacionInterna contOrganizacionInterna) {
		this.contOrganizacionInterna = contOrganizacionInterna;
	}

	public ContTercero getContTercero() {
		return this.contTercero;
	}

	public void setContTercero(ContTercero contTercero) {
		this.contTercero = contTercero;
	}

	public ContTransaccionTipo getContTransaccionTipo() {
		return this.contTransaccionTipo;
	}

	public void setContTransaccionTipo(ContTransaccionTipo contTransaccionTipo) {
		this.contTransaccionTipo = contTransaccionTipo;
	}

	public Date getFetransaccion() {
		return this.fetransaccion;
	}

	public void setFetransaccion(Date fetransaccion) {
		this.fetransaccion = fetransaccion;
	}

	public BigDecimal getNmvalorTransaccion() {
		return this.nmvalorTransaccion;
	}

	public void setNmvalorTransaccion(BigDecimal nmvalorTransaccion) {
		this.nmvalorTransaccion = nmvalorTransaccion;
	}

	public BigDecimal getNmvalorMoneda() {
		return this.nmvalorMoneda;
	}

	public void setNmvalorMoneda(BigDecimal nmvalorMoneda) {
		this.nmvalorMoneda = nmvalorMoneda;
	}

	public String getDsdescripcionTransaccion() {
		return this.dsdescripcionTransaccion;
	}

	public void setDsdescripcionTransaccion(String dsdescripcionTransaccion) {
		this.dsdescripcionTransaccion = dsdescripcionTransaccion;
	}

	public String getDsnumeroDocumento() {
		return this.dsnumeroDocumento;
	}

	public void setDsnumeroDocumento(String dsnumeroDocumento) {
		this.dsnumeroDocumento = dsnumeroDocumento;
	}

	public String getDsnumeroTransaccion() {
		return dsnumeroTransaccion;
	}

	public void setDsnumeroTransaccion(String dsnumeroTransaccion) {
		this.dsnumeroTransaccion = dsnumeroTransaccion;
	}
	
	
}
