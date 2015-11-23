package co.weepa.smile.contabilidad.dto.capsulas;

import java.io.Serializable;

public class ObjetoProducto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idproducto;
	private int prodColor;
	private int prodProductoTipo;
	private int prodTalla;
	private String dscodigo;
	private Long nmcodigoEan13;
	private String dsnombre;
	private String dsnombreCorto;
	private String dsdescripcion;
	private Integer nmprecioVenta;
	private Integer nmprecioCompra;
	private Integer nmsaldo;
	private String dsimagenProducto;
	private String dsimagenFichatec;
	private Integer nmimpuesto;
	private Integer mncantidadMin;
	private String mncantidadMax;
	
	
	public ObjetoProducto() {
		super();
	}
	public String getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}
	public int getProdColor() {
		return prodColor;
	}
	public void setProdColor(int prodColor) {
		this.prodColor = prodColor;
	}
	public int getProdProductoTipo() {
		return prodProductoTipo;
	}
	public void setProdProductoTipo(int prodProductoTipo) {
		this.prodProductoTipo = prodProductoTipo;
	}
	public int getProdTalla() {
		return prodTalla;
	}
	public void setProdTalla(int prodTalla) {
		this.prodTalla = prodTalla;
	}
	public String getDscodigo() {
		return dscodigo;
	}
	public void setDscodigo(String dscodigo) {
		this.dscodigo = dscodigo;
	}
	public Long getNmcodigoEan13() {
		return nmcodigoEan13;
	}
	public void setNmcodigoEan13(Long nmcodigoEan13) {
		this.nmcodigoEan13 = nmcodigoEan13;
	}
	public String getDsnombre() {
		return dsnombre;
	}
	public void setDsnombre(String dsnombre) {
		this.dsnombre = dsnombre;
	}
	public String getDsnombreCorto() {
		return dsnombreCorto;
	}
	public void setDsnombreCorto(String dsnombreCorto) {
		this.dsnombreCorto = dsnombreCorto;
	}
	public String getDsdescripcion() {
		return dsdescripcion;
	}
	public void setDsdescripcion(String dsdescripcion) {
		this.dsdescripcion = dsdescripcion;
	}
	public Integer getNmprecioVenta() {
		return nmprecioVenta;
	}
	public void setNmprecioVenta(Integer nmprecioVenta) {
		this.nmprecioVenta = nmprecioVenta;
	}
	public Integer getNmprecioCompra() {
		return nmprecioCompra;
	}
	public void setNmprecioCompra(Integer nmprecioCompra) {
		this.nmprecioCompra = nmprecioCompra;
	}
	public Integer getNmsaldo() {
		return nmsaldo;
	}
	public void setNmsaldo(Integer nmsaldo) {
		this.nmsaldo = nmsaldo;
	}
	public String getDsimagenProducto() {
		return dsimagenProducto;
	}
	public void setDsimagenProducto(String dsimagenProducto) {
		this.dsimagenProducto = dsimagenProducto;
	}
	public String getDsimagenFichatec() {
		return dsimagenFichatec;
	}
	public void setDsimagenFichatec(String dsimagenFichatec) {
		this.dsimagenFichatec = dsimagenFichatec;
	}
	public Integer getNmimpuesto() {
		return nmimpuesto;
	}
	public void setNmimpuesto(Integer nmimpuesto) {
		this.nmimpuesto = nmimpuesto;
	}
	public Integer getMncantidadMin() {
		return mncantidadMin;
	}
	public void setMncantidadMin(Integer mncantidadMin) {
		this.mncantidadMin = mncantidadMin;
	}
	public String getMncantidadMax() {
		return mncantidadMax;
	}
	public void setMncantidadMax(String mncantidadMax) {
		this.mncantidadMax = mncantidadMax;
	}
	
}
