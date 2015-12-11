package co.weepa.smile.contabilidad.dto.capsulas;

import java.math.BigDecimal;

public class Retenciones {
	BigDecimal reteIva;
	BigDecimal reteFuente;
	BigDecimal reteICA;
	
	public Retenciones() {
		super();
	}

	public Retenciones(BigDecimal reteIva, BigDecimal reteFuente, BigDecimal reteICA) {
		super();
		this.reteIva = reteIva;
		this.reteFuente = reteFuente;
		this.reteICA = reteICA;
	}

	public BigDecimal getReteIva() {
		return reteIva;
	}

	public void setReteIva(BigDecimal reteIva) {
		this.reteIva = reteIva;
	}

	public BigDecimal getReteFuente() {
		return reteFuente;
	}

	public void setReteFuente(BigDecimal reteFuente) {
		this.reteFuente = reteFuente;
	}

	public BigDecimal getReteICA() {
		return reteICA;
	}

	public void setReteICA(BigDecimal reteICA) {
		this.reteICA = reteICA;
	}
	
	
}
