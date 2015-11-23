package co.weepa.smile.contabilidad.ngc.impl;

import java.util.List;

import co.weepa.smile.contabilidad.dao.CentroCostoDAO;
import co.weepa.smile.contabilidad.dto.ContCentroCosto;
import co.weepa.smile.contabilidad.ngc.CentroCostoNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class CentroCostoNGCImpl implements CentroCostoNGC {

	CentroCostoDAO centroCostoDao;
	
	public void setCentroCostoDao(CentroCostoDAO centroCostoDao) {
		this.centroCostoDao = centroCostoDao;
	}

	
	public ContCentroCosto obtenerCentroCosto(int idCentroCosto) throws ExcepcionesNGC {
		ContCentroCosto centroCosto = null;
		
		if(idCentroCosto > 0){
			try {
				centroCosto = centroCostoDao.obtenerCentroCosto(idCentroCosto);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesNGC(e);
			}
		}else{
			throw new ExcepcionesNGC("No es posible realizar la busqueda. Digite un Id de Centro de Costo válido.");
		}
		
		return centroCosto;
	}

	
	public List<ContCentroCosto> listarCentroCosto() throws ExcepcionesNGC {
		List<ContCentroCosto> listaCentroCosto = null;
		
		try {
			listaCentroCosto = centroCostoDao.listarCentroCosto();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesNGC(e);
		}
		
		return listaCentroCosto;
	}
}
