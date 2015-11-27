package co.weepa.smile.contabilidad.ngc.impl;

import java.util.List;

import co.weepa.smile.contabilidad.dao.TerceroDAO;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.ContTipoTercero;
import co.weepa.smile.contabilidad.dto.TercOrganizacion;
import co.weepa.smile.contabilidad.dto.TercPersona;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoDeudor;
import co.weepa.smile.contabilidad.ngc.TerceroNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class TerceroNGCImpl implements TerceroNGC {

	ExcepcionesNGC expNgc = null;
	
	TerceroDAO terceroDao;

	public void setTerceroDao(TerceroDAO terceroDao) {
		this.terceroDao = terceroDao;
	}

	
	public void guardarTercero(ContTercero tercero) throws ExcepcionesNGC {
		if(tercero != null){
			try {
				terceroDao.guardarTercero(tercero);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setMensajeTecnico(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());			
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No se realizaron cambios debido a que no existen registros para Guardar.");	
			throw expNgc;
		}
	}

	public void modificarTercero(ContTercero tercero) throws ExcepcionesNGC {
		if(tercero != null){
			try {
				terceroDao.modificarTercero(tercero);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setMensajeTecnico(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());			
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No se realizaron cambios debido a que no existen registros para Actualizar.");		
			throw expNgc;
		}
	}

	public ContTercero obtenerTercero(String idTercero) throws ExcepcionesNGC {
		ContTercero tercero = null;
		
		if(!idTercero.isEmpty()){
			try {
				tercero = terceroDao.obtenerTercero(Long.valueOf(idTercero));
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setMensajeTecnico(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());			
				throw expNgc;
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
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta. Ingrese un criterio de busqueda valido.");		
			throw expNgc;
		}

		return tercero;
	}

	public List<ContTercero> listarTodos() throws ExcepcionesNGC {
		List<ContTercero> listaTerceros = null;
		
		try {
			listaTerceros = terceroDao.listarTodos();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setMensajeTecnico(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());			
			throw expNgc;
		}
		
		return listaTerceros;
	}

	public List<ContTercero> listarTerceroxTipo(ContTipoTercero tipoTercero) throws ExcepcionesNGC {
		List<ContTercero> listaTerceros = null;
		
		if (tipoTercero != null){
			try {
				listaTerceros = terceroDao.listarTodos();
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setMensajeTecnico(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());			
				throw expNgc;
			}
		}else{
			throw new ExcepcionesNGC("No es posible realizar la consulta. Ingrese un criterio de busqueda válido.");
		}		
		
		return listaTerceros;
	}


	/**
	 * Metodos para los detalles de los Terceros tanto Natural como Juridico.
	 */
	
	@Override
	public TercPersona obtenerPersonaNatural(int idPersona) throws ExcepcionesNGC {
		
		return null;
	}

	@Override
	public TercOrganizacion obtenerPersonaJuridica(int idOrganizacion) throws ExcepcionesNGC {
		TercOrganizacion organizacion = null;
		
		if(idOrganizacion > 0){
			try {
				organizacion = terceroDao.obtenerPersonaJuridica(idOrganizacion);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setMensajeTecnico(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());			
				throw expNgc;
			}
		}
		return organizacion;
	}

	

	@Override
	public List<TercPersona> listarPersonasNaturales() throws ExcepcionesNGC {
		
		return null;
	}

	@Override
	public List<TercOrganizacion> listarOrganizaciones() throws ExcepcionesNGC {
		List<TercOrganizacion> listaOrganizaciones = null;
		
		try {
			listaOrganizaciones = terceroDao.listarOrganizaciones();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setMensajeTecnico(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());			
			throw expNgc;
		}
		
		return listaOrganizaciones;
	}

	
	@Override
	public List<TercPersona> listarVendedores() throws ExcepcionesNGC {
		List<TercPersona> listaPersona = null;
		
		try {
			listaPersona = terceroDao.listarVendedores();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setMensajeTecnico(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());			
			throw expNgc;
		}
		
		return listaPersona;
	}

	@Override
	public List<ObjetoDeudor> listarDeudores() throws ExcepcionesNGC {
		List<ObjetoDeudor> listaDeudores = null;
		
		try {
			listaDeudores = terceroDao.listarDeudores();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setMensajeTecnico(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());			
			throw expNgc;
		}		
		return listaDeudores;
	}

	
	
}
