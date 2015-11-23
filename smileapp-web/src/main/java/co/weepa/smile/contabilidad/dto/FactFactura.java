package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;

/**
 * FactFactura generated by hbm2java
 */
public class FactFactura implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idconsecutivoFactura;
	private ContOrganizacionInterna contOrganizacionInterna;
	private ContTercero contTercero;
	private FactFacturaTipo factFacturaTipo;
	private String dsnumeroFactura;
	private Date fefactura;
	private String dsdescripcion;
	private BigDecimal nmvalorTotal;
	private Integer idorganizacionPuntoventa;
	private Integer idorganizacionCaja;
	private Integer idorganizacionEmpleado;
	private String dsvendedor;
//	private Set cartCarteras = new HashSet(0);
//	private Set factDetalleFacturas = new HashSet(0);

	public FactFactura() {
	}

	public FactFactura(ContOrganizacionInterna contOrganizacionInterna, ContTercero contTercero,
			FactFacturaTipo factFacturaTipo, String dsnumeroFactura, Date fefactura, String dsdescripcion,
			BigDecimal nmvalorTotal, Integer idorganizacionPuntoventa, Integer idorganizacionCaja,
			Integer idorganizacionEmpleado, String dsvendedor) {
		this.contOrganizacionInterna = contOrganizacionInterna;
		this.contTercero = contTercero;
		this.factFacturaTipo = factFacturaTipo;
		this.dsnumeroFactura = dsnumeroFactura;
		this.fefactura = fefactura;
		this.dsdescripcion = dsdescripcion;
		this.nmvalorTotal = nmvalorTotal;
		this.idorganizacionPuntoventa = idorganizacionPuntoventa;
		this.idorganizacionCaja = idorganizacionCaja;
		this.idorganizacionEmpleado = idorganizacionEmpleado;
		this.dsvendedor = dsvendedor;
	}

	public Integer getIdconsecutivoFactura() {
		return this.idconsecutivoFactura;
	}

	public void setIdconsecutivoFactura(Integer idconsecutivoFactura) {
		this.idconsecutivoFactura = idconsecutivoFactura;
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

	public FactFacturaTipo getFactFacturaTipo() {
		return this.factFacturaTipo;
	}

	public void setFactFacturaTipo(FactFacturaTipo factFacturaTipo) {
		this.factFacturaTipo = factFacturaTipo;
	}

	public String getDsnumeroFactura() {
		return this.dsnumeroFactura;
	}

	public void setDsnumeroFactura(String dsnumeroFactura) {
		this.dsnumeroFactura = dsnumeroFactura;
	}

	public Date getFefactura() {
		return this.fefactura;
	}

	public void setFefactura(Date fefactura) {
		this.fefactura = fefactura;
	}

	public String getDsdescripcion() {
		return this.dsdescripcion;
	}

	public void setDsdescripcion(String dsdescripcion) {
		this.dsdescripcion = dsdescripcion;
	}

	public BigDecimal getNmvalorTotal() {
		return this.nmvalorTotal;
	}

	public void setNmvalorTotal(BigDecimal nmvalorTotal) {
		this.nmvalorTotal = nmvalorTotal;
	}

	public Integer getIdorganizacionPuntoventa() {
		return this.idorganizacionPuntoventa;
	}

	public void setIdorganizacionPuntoventa(Integer idorganizacionPuntoventa) {
		this.idorganizacionPuntoventa = idorganizacionPuntoventa;
	}

	public Integer getIdorganizacionCaja() {
		return this.idorganizacionCaja;
	}

	public void setIdorganizacionCaja(Integer idorganizacionCaja) {
		this.idorganizacionCaja = idorganizacionCaja;
	}

	public Integer getIdorganizacionEmpleado() {
		return this.idorganizacionEmpleado;
	}

	public void setIdorganizacionEmpleado(Integer idorganizacionEmpleado) {
		this.idorganizacionEmpleado = idorganizacionEmpleado;
	}

	public String getDsvendedor() {
		return this.dsvendedor;
	}

	public void setDsvendedor(String dsvendedor) {
		this.dsvendedor = dsvendedor;
	}
}
