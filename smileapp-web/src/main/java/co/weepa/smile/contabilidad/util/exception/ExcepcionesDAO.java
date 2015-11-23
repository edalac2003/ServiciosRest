package co.weepa.smile.contabilidad.util.exception;

public class ExcepcionesDAO extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensajeTecnico;
	private String mensajeUsuario;
	private Exception origen;
	

	public ExcepcionesDAO() {

	}

	public ExcepcionesDAO(String arg0) {
		super(arg0);
		
	}

	public ExcepcionesDAO(Throwable arg0) {
		super(arg0);
		
	}

	public ExcepcionesDAO(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public ExcepcionesDAO(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
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
