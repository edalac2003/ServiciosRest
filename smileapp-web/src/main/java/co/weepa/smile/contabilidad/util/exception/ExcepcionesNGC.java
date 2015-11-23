package co.weepa.smile.contabilidad.util.exception;

public class ExcepcionesNGC extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensajeTecnico;
	private String mensajeUsuario;
	private Exception origen;
	
	public ExcepcionesNGC() {
	}

	public ExcepcionesNGC(String message) {
		super(message);
	}

	public ExcepcionesNGC(Throwable cause) {
		super(cause);
	}

	public ExcepcionesNGC(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionesNGC(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public String getMensajeTecnico() {
		return mensajeTecnico;
	}

	public void setMensajeTecnico(String mensajeTecnico) {
		this.mensajeTecnico = mensajeTecnico;
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}

	public Exception getOrigen() {
		return origen;
	}

	public void setOrigen(Exception origen) {
		this.origen = origen;
	}

	
}
