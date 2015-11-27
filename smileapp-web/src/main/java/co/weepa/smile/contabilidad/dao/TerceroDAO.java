package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.ContTipoTercero;
import co.weepa.smile.contabilidad.dto.TercOrganizacion;
import co.weepa.smile.contabilidad.dto.TercPersona;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoDeudor;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface TerceroDAO {
	
	public void guardarTercero(ContTercero tercero) throws ExcepcionesDAO;
	
	public void modificarTercero(ContTercero tercero) throws ExcepcionesDAO;
	
	public ContTercero obtenerTercero(long idTercero) throws ExcepcionesDAO;
	
	public ContTercero obtenerTercero(String idTercero, ContTipoTercero tipoTercero) throws ExcepcionesDAO;
	
	public List<ContTercero> listarTodos() throws ExcepcionesDAO;
	
	public List<ContTercero> listarTerceroxTipo(ContTipoTercero tipoTercero) throws ExcepcionesDAO;
	
	/**
	 * Metodos para los detalles de los Terceros tanto Natural como Juridico.
	 */
	
	public TercPersona obtenerPersonaNatural(int idPersona) throws ExcepcionesDAO;
	
	public TercPersona obtenerPersonaNatural(ContTercero tercero) throws ExcepcionesDAO;
	
	public TercOrganizacion obtenerPersonaJuridica(int idOrganizacion) throws ExcepcionesDAO;
	
	public TercOrganizacion obtenerPersonaJuridica(ContTercero tercero) throws ExcepcionesDAO;
	
	public List<TercPersona> listarPersonasNaturales() throws ExcepcionesDAO;
	
	public List<TercOrganizacion> listarOrganizaciones() throws ExcepcionesDAO;
	
	public List<TercPersona> listarVendedores() throws ExcepcionesDAO;
	
	public List<ObjetoDeudor> listarDeudores() throws ExcepcionesDAO;
	
}
