package co.weepa.smile.contabilidad.ngc;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.ContTipoTercero;
import co.weepa.smile.contabilidad.dto.TercOrganizacion;
import co.weepa.smile.contabilidad.dto.TercPersona;
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
	
	public TercPersona obtenerPersonaNatural(int idPersona) throws ExcepcionesDAO;
	
	public TercOrganizacion obtenerPersonaJuridica(int idOrganizacion) throws ExcepcionesDAO;
	
	public List<TercPersona> listarPersonasNaturales() throws ExcepcionesDAO;
	
	public List<TercOrganizacion> listarOrganizaciones() throws ExcepcionesDAO;
}
