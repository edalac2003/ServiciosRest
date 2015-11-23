package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

/**
 * FactDetalleFactura generated by hbm2java
 */
public class FactDetalleFactura implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer iddetalleFactura;
	private FactDetalleFacturaTipo factDetalleFacturaTipo;
	private FactFactura factFactura;
	private ProdProducto prodProducto;
	private Integer nmcantidad;
	private Integer nmprecio;
	private Integer nmimpuesto;
	private Integer nmdescuento;
	private String sngravado;
	private Integer nmsubtotal;

	public FactDetalleFactura() {
	}

	public FactDetalleFactura(FactDetalleFacturaTipo factDetalleFacturaTipo, FactFactura factFactura,
			ProdProducto prodProducto, Integer nmcantidad, Integer nmprecio, Integer nmimpuesto, Integer nmdescuento,
			String sngravado, Integer nmsubtotal) {
		this.factDetalleFacturaTipo = factDetalleFacturaTipo;
		this.factFactura = factFactura;
		this.prodProducto = prodProducto;
		this.nmcantidad = nmcantidad;
		this.nmprecio = nmprecio;
		this.nmimpuesto = nmimpuesto;
		this.nmdescuento = nmdescuento;
		this.sngravado = sngravado;
		this.nmsubtotal = nmsubtotal;
	}

	public Integer getIddetalleFactura() {
		return this.iddetalleFactura;
	}

	public void setIddetalleFactura(Integer iddetalleFactura) {
		this.iddetalleFactura = iddetalleFactura;
	}

	public FactDetalleFacturaTipo getFactDetalleFacturaTipo() {
		return this.factDetalleFacturaTipo;
	}

	public void setFactDetalleFacturaTipo(FactDetalleFacturaTipo factDetalleFacturaTipo) {
		this.factDetalleFacturaTipo = factDetalleFacturaTipo;
	}

	public FactFactura getFactFactura() {
		return this.factFactura;
	}

	public void setFactFactura(FactFactura factFactura) {
		this.factFactura = factFactura;
	}

	public ProdProducto getProdProducto() {
		return this.prodProducto;
	}

	public void setProdProducto(ProdProducto prodProducto) {
		this.prodProducto = prodProducto;
	}

	public Integer getNmcantidad() {
		return this.nmcantidad;
	}

	public void setNmcantidad(Integer nmcantidad) {
		this.nmcantidad = nmcantidad;
	}

	public Integer getNmprecio() {
		return this.nmprecio;
	}

	public void setNmprecio(Integer nmprecio) {
		this.nmprecio = nmprecio;
	}

	public Integer getNmimpuesto() {
		return this.nmimpuesto;
	}

	public void setNmimpuesto(Integer nmimpuesto) {
		this.nmimpuesto = nmimpuesto;
	}

	public Integer getNmdescuento() {
		return this.nmdescuento;
	}

	public void setNmdescuento(Integer nmdescuento) {
		this.nmdescuento = nmdescuento;
	}

	public String getSngravado() {
		return this.sngravado;
	}

	public void setSngravado(String sngravado) {
		this.sngravado = sngravado;
	}

	public Integer getNmsubtotal() {
		return this.nmsubtotal;
	}

	public void setNmsubtotal(Integer nmsubtotal) {
		this.nmsubtotal = nmsubtotal;
	}

}