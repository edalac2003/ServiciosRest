package co.weepa.smile.contabilidad.dto.capsulas;

public class Retenciones {
	double reteIva = 0;
	double reteFuente = 0;
	double reteICA = 0;
	
	public Retenciones() {
		super();
	}
	
	public Retenciones(double reteIva, double reteFuente) {
		super();
		this.reteIva = reteIva;
		this.reteFuente = reteFuente;
	}

	public Retenciones(double reteIva, double reteFuente, double reteICA) {
		super();
		this.reteIva = reteIva;
		this.reteFuente = reteFuente;
		this.reteICA = reteICA;
	}



	public double getReteIva() {
		return reteIva;
	}

	public void setReteIva(double reteIva) {
		this.reteIva = reteIva;
	}

	public double getReteFuente() {
		return reteFuente;
	}

	public void setReteFuente(double reteFuente) {
		this.reteFuente = reteFuente;
	}

	public double getReteICA() {
		return reteICA;
	}

	public void setReteICA(double reteICA) {
		this.reteICA = reteICA;
	}	
}
