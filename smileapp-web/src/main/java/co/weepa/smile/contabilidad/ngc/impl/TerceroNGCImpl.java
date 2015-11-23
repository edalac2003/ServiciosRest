package co.weepa.smile.contabilidad.ngc.impl;

import java.util.List;

import co.weepa.smile.contabilidad.dao.TerceroDAO;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.ContTipoTercero;
import co.weepa.smile.contabilidad.dto.TercOrganizacion;
import co.weepa.smile.contabilidad.dto.TercPersona;
import co.weepa.smile.contabilidad.ngc.TerceroNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class TerceroNGCImpl implements TerceroNGC {

	TerceroDAO terceroDao;

	public void setTerceroDao(TerceroDAO terceroDao) {
		this.terceroDao = terceroDao;
	}

	public void guardarTercero(ContTercero tercero) throws ExcepcionesNGC {
		if(tercero != null){
			try {
				terceroDao.guardarTercero(tercero);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesNGC(e);
			}
		}else{
			throw new ExcepcionesNGC("No se realizaron cambios debido a que no existen registros para Guardar.");
		}
	}

	public void modificarTercero(ContTercero tercero) throws ExcepcionesNGC {
		if(tercero != null){
			try {
				terceroDao.modificarTercero(tercero);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesNGC(e);
			}
		}else{
			throw new ExcepcionesNGC("No se realizaron cambios debido a que no existen registros para Actualizar.");
		}
	}

	public ContTercero obtenerTercero(String idTercero) throws ExcepcionesNGC {
		ContTercero tercero = null;
		
		if(!idTercero.isEmpty()){
			try {
				tercero = terceroDao.obtenerTercero(Long.valueOf(idTercero));
			} catch (ExcepcionesDAO e) {
				ExcepcionesNGC expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw new ExcepcionesNGC(e);
			}
		}else {
			ExcepcionesNGC expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta. Ingrese un criterio de busqueda válido.");
			throw expNgc;
		}

		return tercero;
	}
	

	public ContTercero obtenerTercero(String idTercero, ContTipoTercero tipoTercero) throws ExcepcionesNGC {
		ContTercero tercero = null;
		
		if((!idTercero.isEmpty()) && (tipoTercero != null)){
//			try {
//				tercero = terceroDao.obtenerTercero(idTercero);
//			} catch (ExcepcionesDAO e) {
//				throw new ExcepcionesNGC(e);
//			}
		}else {
			throw new ExcepcionesNGC("No es posible realizar la consulta. Ingrese un criterio de busqueda válido.");
		}

		return tercero;
	}

	public List<ContTercero> listarTodos() throws ExcepcionesNGC {
		List<ContTercero> listaTerceros = null;
		
		try {
			listaTerceros = terceroDao.listarTodos();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesNGC(e);
		}
		
		return listaTerceros;
	}

	public List<ContTercero> listarTerceroxTipo(ContTipoTercero tipoTercero) throws ExcepcionesNGC {
		List<ContTercero> listaTerceros = null;
		
		if (tipoTercero != null){
			try {
				listaTerceros = terceroDao.listarTodos();
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesNGC(e);
			}
		}else{
			throw new ExcepcionesNGC("No es posible realizar la consulta. Ingrese un criterio de busqueda válido.");
		}		
		
		return listaTerceros;
	}


	/**
	 * Metodos para los detalles de los Terceros tanto Natural como Juridico.
	 */
	
	public TercPersona obtenerPersonaNatural(int idPersona) throws ExcepcionesDAO {
		TercPersona persona = null;
		
		if(idPersona > 0){
			persona = terceroDao.obtenerPersonaNatural(idPersona);
			
		}
		
		return persona;
	}

	public TercOrganizacion obtenerPersonaJuridica(int idOrganizacion) throws ExcepcionesDAO {
		TercOrganizacion organizacion = null;
		
		if(idOrganizacion > 0){
			organizacion = terceroDao.obtenerPersonaJuridica(idOrganizacion);
		}
		
		return organizacion;
	}

	public List<TercPersona> listarPersonasNaturales() throws ExcepcionesDAO {
		List<TercPersona> listaPersona = null;
		listaPersona = terceroDao.listarPersonasNaturales();
		
		return listaPersona;
	}

	public List<TercOrganizacion> listarOrganizaciones() throws ExcepcionesDAO {
		List<TercOrganizacion> listaOrganizacion = null;
		listaOrganizacion = terceroDao.listarOrganizaciones();
		
		return listaOrganizacion;
	}	
}
