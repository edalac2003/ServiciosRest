package co.weepa.smile.contabilidad.dao;

import java.util.List;

import co.weepa.smile.contabilidad.dto.DefiCiudad;
import co.weepa.smile.contabilidad.dto.DefiDepartamento;
import co.weepa.smile.contabilidad.dto.DefiPais;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;

public interface CiudadDAO {
	
	public DefiPais obtenerPais(int idPais) throws ExcepcionesDAO;
	
	public DefiDepartamento obtenerDepartamento(int idDepartamento) throws ExcepcionesDAO;
	
	public DefiCiudad obtenerCiudad(int idCiudad) throws ExcepcionesDAO;
	
	public List<DefiPais> listarPaises() throws ExcepcionesDAO;
	
	public List<DefiDepartamento> listarDepartamentos() throws ExcepcionesDAO;
	
	public List<DefiCiudad> listarCiudades() throws ExcepcionesDAO;
	
	public List<DefiCiudad> listarCiudades(DefiDepartamento departamento) throws ExcepcionesDAO;

}
