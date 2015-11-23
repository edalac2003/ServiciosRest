package co.weepa.smile.contabilidad.ngc.impl;

import java.util.List;

import co.weepa.smile.contabilidad.dao.NormaTipoDAO;
import co.weepa.smile.contabilidad.dto.ContNormaTipo;
import co.weepa.smile.contabilidad.ngc.NormaTipoNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class NormaTipoNGCImpl implements NormaTipoNGC {

	NormaTipoDAO normaTipoDao;
	
	public void setNormaTipoDao(NormaTipoDAO normaTipoDao) {
		this.normaTipoDao = normaTipoDao;
	}

	public ContNormaTipo obtenerTipoNorma(int idTipo) throws ExcepcionesNGC {
		ContNormaTipo tipoNorma = null;
		
		try {
			tipoNorma = normaTipoDao.obtenerTipoNorma(idTipo);
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesNGC(e);
		}
		
		return tipoNorma;
	}

	public List<ContNormaTipo> listarTodo() throws ExcepcionesNGC {
		List<ContNormaTipo> listaTipoNorma = null;
		
		try {
			listaTipoNorma = normaTipoDao.listarTodo();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesNGC(e);
		}
		
		return listaTipoNorma;
	}

}
