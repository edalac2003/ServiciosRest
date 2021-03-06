package co.weepa.smile.contabilidad.ngc;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.ContTipoTercero;
import co.weepa.smile.contabilidad.dto.TercOrganizacion;
import co.weepa.smile.contabilidad.dto.TercPersona;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoTercero;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public interface TerceroNGC {

	public void guardarTercero(ContTercero tercero) throws ExcepcionesNGC;
	
	public void modificarTercero(ContTercero tercero) throws ExcepcionesNGC;
	
	public ContTercero obtenerTercero(String idTercero) throws ExcepcionesNGC;
	
	public ContTercero obtenerTercero(String idTercero, ContTipoTercero tipoTercero) throws ExcepcionesNGC;
	
	public List<ContTercero> listarTodos() throws ExcepcionesNGC;
	
	public List<ContTercero> listarTerceroxTipo(ContTipoTercero tipoTercero) throws ExcepcionesNGC;
	
	/**
	 * Metodos para los detalles de los Terceros tanto Natural como Juridico.
	 */
	
	public TercPersona obtenerPersonaNatural(int idPersona) throws ExcepcionesNGC;
	
	public TercPersona obtenerPersonaNatural(ContTercero tercero) throws ExcepcionesNGC;
	
	public TercOrganizacion obtenerPersonaJuridica(int idOrganizacion) throws ExcepcionesNGC;
	
	public TercOrganizacion obtenerPersonaJuridica(ContTercero tercero) throws ExcepcionesNGC;
	
	public List<TercPersona> listarPersonasNaturales() throws ExcepcionesNGC;
	
	public List<TercOrganizacion> listarOrganizaciones() throws ExcepcionesNGC;
	
	public List<TercPersona> listarVendedores() throws ExcepcionesNGC;
	
	public List<ObjetoTercero> listarCarteraTercero(String tipoTercero, String tipoDocumento) throws ExcepcionesNGC;
}
