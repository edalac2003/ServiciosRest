package co.weepa.smile.contabilidad.dto;
// default package
// Generated 31-oct-2015 11:05:46 by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * DefiParametro generated by hbm2java
 */
public class DefiParametro implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idparametro;
	private DefiAccion defiAccion;
	private DefiTipoDato defiTipoDato;
	private long dsnombre;
	private String dsvalor;
	private Double nmvalor;
	private Date fevalor;
	private Integer nmorden;

	public DefiParametro() {
	}

	public DefiParametro(int idparametro, long dsnombre) {
		this.idparametro = idparametro;
		this.dsnombre = dsnombre;
	}

	public DefiParametro(int idparametro, DefiAccion defiAccion, DefiTipoDato defiTipoDato, long dsnombre,
			String dsvalor, Double nmvalor, Date fevalor, Integer nmorden) {
		this.idparametro = idparametro;
		this.defiAccion = defiAccion;
		this.defiTipoDato = defiTipoDato;
		this.dsnombre = dsnombre;
		this.dsvalor = dsvalor;
		this.nmvalor = nmvalor;
		this.fevalor = fevalor;
		this.nmorden = nmorden;
	}

	public int getIdparametro() {
		return this.idparametro;
	}

	public void setIdparametro(int idparametro) {
		this.idparametro = idparametro;
	}

	public DefiAccion getDefiAccion() {
		return this.defiAccion;
	}

	public void setDefiAccion(DefiAccion defiAccion) {
		this.defiAccion = defiAccion;
	}

	public DefiTipoDato getDefiTipoDato() {
		return this.defiTipoDato;
	}

	public void setDefiTipoDato(DefiTipoDato defiTipoDato) {
		this.defiTipoDato = defiTipoDato;
	}

	public long getDsnombre() {
		return this.dsnombre;
	}

	public void setDsnombre(long dsnombre) {
		this.dsnombre = dsnombre;
	}

	public String getDsvalor() {
		return this.dsvalor;
	}

	public void setDsvalor(String dsvalor) {
		this.dsvalor = dsvalor;
	}

	public Double getNmvalor() {
		return this.nmvalor;
	}

	public void setNmvalor(Double nmvalor) {
		this.nmvalor = nmvalor;
	}

	public Date getFevalor() {
		return this.fevalor;
	}

	public void setFevalor(Date fevalor) {
		this.fevalor = fevalor;
	}

	public Integer getNmorden() {
		return this.nmorden;
	}

	public void setNmorden(Integer nmorden) {
		this.nmorden = nmorden;
	}

}