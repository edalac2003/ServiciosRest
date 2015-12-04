package co.weepa.smile.contabilidad.ngc.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.weepa.smile.contabilidad.dao.TransaccionDAO;
import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartPago;
import co.weepa.smile.contabilidad.dto.ContCentroCosto;
import co.weepa.smile.contabilidad.dto.ContDetalleTransaccion;
import co.weepa.smile.contabilidad.dto.ContMoneda;
import co.weepa.smile.contabilidad.dto.ContNormaTipo;
import co.weepa.smile.contabilidad.dto.ContOrganizacionInterna;
import co.weepa.smile.contabilidad.dto.ContPlanCuenta;
import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.ContTransaccionContable;
import co.weepa.smile.contabilidad.dto.ContTransaccionTipo;
import co.weepa.smile.contabilidad.dto.DefiTransaccionAccion;
import co.weepa.smile.contabilidad.ngc.CarteraNGC;
import co.weepa.smile.contabilidad.ngc.CentroCostoNGC;
import co.weepa.smile.contabilidad.ngc.MonedaNGC;
import co.weepa.smile.contabilidad.ngc.NormaTipoNGC;
import co.weepa.smile.contabilidad.ngc.OrganizacionInternaNGC;
import co.weepa.smile.contabilidad.ngc.PlanCuentaNGC;
import co.weepa.smile.contabilidad.ngc.TerceroNGC;
import co.weepa.smile.contabilidad.ngc.TransaccionAccionNGC;
import co.weepa.smile.contabilidad.ngc.TransaccionNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class TransaccionNGCImpl implements TransaccionNGC {

	TransaccionDAO transaccionDao;
	TerceroNGC terceroNgc;
	CarteraNGC carteraNgc;
	TransaccionAccionNGC transaccionAccionNgc;
	OrganizacionInternaNGC organizacionInternaNgc;
	MonedaNGC monedaNgc;
	CentroCostoNGC centroCostoNgc;
	NormaTipoNGC normaTipoNgc;
	PlanCuentaNGC planCuentaNgc;
	
	public void setTransaccionDao(TransaccionDAO transaccionDao) {
		this.transaccionDao = transaccionDao;
	}
	public void setTerceroNgc(TerceroNGC terceroNgc) {
		this.terceroNgc = terceroNgc;
	}
	
	public void setCarteraNgc(CarteraNGC carteraNgc) {
		this.carteraNgc = carteraNgc;
	}

	public void setTransaccionAccionNgc(TransaccionAccionNGC transaccionAccionNgc) {
		this.transaccionAccionNgc = transaccionAccionNgc;
	}

	public void setOrganizacionInternaNgc(OrganizacionInternaNGC organizacionInternaNgc) {
		this.organizacionInternaNgc = organizacionInternaNgc;
	}
	
	public void setMonedaNgc(MonedaNGC monedaNgc) {
		this.monedaNgc = monedaNgc;
	}

	public void setCentroCostoNgc(CentroCostoNGC centroCostoNgc) {
		this.centroCostoNgc = centroCostoNgc;
	}

	public void setNormaTipoNgc(NormaTipoNGC normaTipoNgc) {
		this.normaTipoNgc = normaTipoNgc;
	}

	public void setPlanCuentaNgc(PlanCuentaNGC planCuentaNgc) {
		this.planCuentaNgc = planCuentaNgc;
	}


	ExcepcionesNGC expNgc = null;
	ContTercero tercero = null;
	CartCartera cartera = null;
	ContMoneda moneda = null;
	ContTransaccionTipo tipoTransaccion = null;
	List<DefiTransaccionAccion> listaTransaccionAccion = null;
	ContOrganizacionInterna organizacionInterna = null;
	ContTransaccionContable transaccionContable = null;
	ContDetalleTransaccion detalleTransaccion = null;
	List<ContDetalleTransaccion> listaDetalleTransaccion = new ArrayList<ContDetalleTransaccion>();
	
	
	@Override
	public void guardarTransaccion(String idTercero, BigDecimal valorTransaccion, Double valorDescuento, String nombreTransaccion, List<CartCartera> listaCartera, 
			List<CartPago> listaDetallePago) throws ExcepcionesNGC {		
		/**
		 * Se inician los procedimientos para realizar la transaccion Contable.
		 */
		String desripcionTransaccion = listaDetallePago.get(0).getDsdetalle();
		ContTercero tercero = listaCartera.get(0).getContTercero();
		moneda = monedaNgc.obtenerMoneda(1);
		Date fechaTransaccion = listaDetallePago.get(0).getFepago();	
		BigDecimal valorCuenta;
		BigDecimal valorTransaccionTercero;
		BigDecimal valorTransaccionDescuento;
		BigDecimal valorTransaccionFinal; 
		organizacionInterna = organizacionInternaNgc.obtenerOrganizacion(1);
		
		tipoTransaccion = obtenerTipoTransaccionxNombre(nombreTransaccion);
		listaTransaccionAccion = transaccionAccionNgc.listaCuentasxTransaccion(organizacionInterna, tipoTransaccion);
		
		/**
		 * Se crea Objeto CONT_TRANSACCION_CONTABLE
		 */
		transaccionContable = new ContTransaccionContable();
		transaccionContable.setContOrganizacionInterna(organizacionInterna);
		transaccionContable.setContTercero(tercero);
		transaccionContable.setContTransaccionTipo(tipoTransaccion);
		transaccionContable.setFetransaccion(fechaTransaccion);
		transaccionContable.setNmvalorMoneda(valorTransaccion);
		transaccionContable.setDsdescripcionTransaccion(desripcionTransaccion);
		transaccionContable.setDsnumeroDocumento("");
		transaccionContable.setContMoneda(moneda);
		
		/**
		 * Se realizan los calculos basado en que pueden existir Descuentos
		 */
		valorTransaccionTercero = valorTransaccion;
		valorTransaccionDescuento = BigDecimal.valueOf(valorDescuento);
		valorTransaccionFinal = valorTransaccionTercero.subtract(valorTransaccionDescuento);
		
		
		if((nombreTransaccion.toUpperCase().contains("RECIBO")) && (nombreTransaccion.toUpperCase().contains("CAJA")) && (nombreTransaccion.toUpperCase().contains("NO EFECTIVO"))){			
			if((listaTransaccionAccion != null) && (!listaTransaccionAccion.isEmpty())){				
				ContCentroCosto centroCosto = centroCostoNgc.obtenerCentroCosto(1);
				ContNormaTipo normaTipo = normaTipoNgc.obtenerTipoNorma(1);
				ContPlanCuenta planCuenta = null;
				
				/**
				 * Se crea Objeto y Lista del tipo CONT_DETALLE_TRANSACCION 
				 */
				
				for(DefiTransaccionAccion accion : listaTransaccionAccion){
					String cuenta = String.valueOf(accion.getContPlanCuenta().getIdcuenta());
					valorCuenta = BigDecimal.ZERO;
					if(cuenta.startsWith("1110")){							//La Cuenta de Banco Aumtenta (Suma)
						valorCuenta = valorTransaccionFinal;
					}else if(cuenta.startsWith("1305")){					//La cuenta CxC disminuye (resta)
						valorCuenta = valorTransaccionTercero.negate();
					}else if(cuenta.startsWith("530535")){					//En caso de Presentarse Descuentos tambien aumenta para compensar la diferencia.
						valorCuenta = valorTransaccionDescuento;
					}
					planCuenta = planCuentaNgc.obtenerCuentaPUC(accion.getContPlanCuenta().getIdcuenta());
					normaTipo = planCuenta.getContCuentaGrupo().getContNormaTipo();
					detalleTransaccion = new ContDetalleTransaccion();
					detalleTransaccion.setContCentroCosto(centroCosto);
					detalleTransaccion.setContNormaTipo(normaTipo);
					detalleTransaccion.setContPlanCuenta(null);
					detalleTransaccion.setContTransaccionContable(transaccionContable);
					detalleTransaccion.setNmvalor(valorCuenta);
					listaDetalleTransaccion.add(detalleTransaccion);
				}				
			}			
		}else if((nombreTransaccion.toUpperCase().contains("RECIBO")) && (nombreTransaccion.toUpperCase().contains("CAJA")) && (nombreTransaccion.toUpperCase().contains("EFECTIVO"))){
			if((listaTransaccionAccion != null) && (!listaTransaccionAccion.isEmpty())){								
				
				/**
				 * Se crea Objeto y Lista del tipo CONT_DETALLE_TRANSACCION 
				 */
				
				for(DefiTransaccionAccion accion : listaTransaccionAccion){
					String cuenta = String.valueOf(accion.getContPlanCuenta().getIdcuenta());
					valorCuenta = BigDecimal.ZERO;
					if(cuenta.startsWith("1105")){							//La Cuenta de Caja Aumtenta (Suma)
						valorCuenta = valorTransaccionFinal;
					}else if(cuenta.startsWith("1305")){					//La cuenta CxC disminuye (resta)
						valorCuenta = valorTransaccionTercero.negate();
					}else if(cuenta.startsWith("530535")){					//En caso de Presentarse Descuentos tambien aumenta para compensar la diferencia.
						valorCuenta = valorTransaccionDescuento;
					}
					detalleTransaccion = new ContDetalleTransaccion();
					detalleTransaccion.setContCentroCosto(null);
					detalleTransaccion.setContNormaTipo(null);
					detalleTransaccion.setContPlanCuenta(null);
					detalleTransaccion.setContTransaccionContable(transaccionContable);
					detalleTransaccion.setNmvalor(valorCuenta);
					listaDetalleTransaccion.add(detalleTransaccion);
				}			
			}			
		}else if((nombreTransaccion.toUpperCase().contains("COMPROBANTE")) && (nombreTransaccion.toUpperCase().contains("EGRESO")) && (nombreTransaccion.toUpperCase().contains("EFECTIVO"))){
			if((listaTransaccionAccion != null) && (!listaTransaccionAccion.isEmpty())){
				/**
				 * Se crea Objeto y Lista del tipo CONT_DETALLE_TRANSACCION 
				 */
				
				for(DefiTransaccionAccion accion : listaTransaccionAccion){
					String cuenta = String.valueOf(accion.getContPlanCuenta().getIdcuenta());
					valorCuenta = BigDecimal.ZERO;
					if(cuenta.startsWith("1105")){							//La Cuenta de Caja Disminuye (Resta)
						valorCuenta = valorTransaccion;
					}else if(cuenta.startsWith("2205")){					//La cuenta Proveedores Aumenta (Valor Positivo)
						valorCuenta = valorTransaccion.negate();
					}
					detalleTransaccion = new ContDetalleTransaccion();
					detalleTransaccion.setContCentroCosto(null);
					detalleTransaccion.setContNormaTipo(null);
					detalleTransaccion.setContPlanCuenta(null);
					detalleTransaccion.setContTransaccionContable(transaccionContable);
					detalleTransaccion.setNmvalor(valorCuenta);	
					listaDetalleTransaccion.add(detalleTransaccion);
				}				
			}			
		}else if((nombreTransaccion.toUpperCase().contains("COMPROBANTE")) && (nombreTransaccion.toUpperCase().contains("EGRESO")) && (nombreTransaccion.toUpperCase().contains("NO EFECTIVO"))){
			if((listaTransaccionAccion != null) && (!listaTransaccionAccion.isEmpty())){								
				/**
				 * Se crea Objeto y Lista del tipo CONT_DETALLE_TRANSACCION 
				 */
				
				for(DefiTransaccionAccion accion : listaTransaccionAccion){
					String cuenta = String.valueOf(accion.getContPlanCuenta().getIdcuenta());
					valorCuenta = BigDecimal.ZERO;
					if(cuenta.startsWith("1110")){							//La Cuenta de Banco Disminuye (Resta)
						valorCuenta = valorTransaccion.negate();
					}else if(cuenta.startsWith("2205")){					//La cuenta Proveedores Aumenta (Valor Positivo)
						valorCuenta = valorTransaccion;
					}
					detalleTransaccion = new ContDetalleTransaccion();
					detalleTransaccion.setContCentroCosto(null);
					detalleTransaccion.setContNormaTipo(null);
					detalleTransaccion.setContPlanCuenta(null);
					detalleTransaccion.setContTransaccionContable(transaccionContable);
					detalleTransaccion.setNmvalor(valorCuenta);
					listaDetalleTransaccion.add(detalleTransaccion);
				}			
			}			
		}
		
		if((!listaCartera.isEmpty()) && (!listaDetallePago.isEmpty()) && (transaccionContable != null) && (!listaDetalleTransaccion.isEmpty())){
			try {
				transaccionDao.guardarTransaccion(listaCartera, listaDetallePago, transaccionContable, listaDetalleTransaccion);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}		
	}

	
	@Override
	public String consecutivoTransaccionxTipo(String nombreTransaccion) throws ExcepcionesNGC {
		int consecutivo = 0;
		ContTransaccionTipo tipoTransaccion;
		String cadena = "";
	
		if (!nombreTransaccion.isEmpty()){
			try {
				tipoTransaccion = transaccionDao.obtenerTipoTransaccionxNombre(nombreTransaccion.toUpperCase());
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
			
			if(tipoTransaccion != null){
				String prefijo = tipoTransaccion.getDsprefijo();
				
				try {
					consecutivo = transaccionDao.consecutivoTransaccionxTipo(tipoTransaccion);
				} catch (ExcepcionesDAO e) {
					expNgc = new ExcepcionesNGC();
					expNgc.setMensajeTecnico(e.getMensajeTecnico());
					expNgc.setMensajeUsuario(e.getMensajeUsuario());
					expNgc.setOrigen(e.getOrigen());
					throw expNgc;
				}
				
				if((consecutivo >=1) && (consecutivo < 10)){
					cadena = prefijo+"0000"+String.valueOf(consecutivo); 
				}else if((consecutivo >= 10) && (consecutivo < 100)){
					cadena = prefijo+"000"+String.valueOf(consecutivo);
				}else if((consecutivo >= 100) && (consecutivo < 1000)){
					cadena = prefijo+"00"+String.valueOf(consecutivo);
				}else if((consecutivo >= 1000) && (consecutivo < 10000)){
					cadena = prefijo+"0"+String.valueOf(consecutivo);
				}else {
					cadena = prefijo+String.valueOf(consecutivo);
				}
			}else{
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeUsuario("No es posible generar el Consecutivo del Documento porque no se ha especificado el Tipo de Documento");
				throw expNgc;
			}		
		}		
		return cadena;
	}
	
	

	public ContTransaccionTipo obtenerTipoTransaccion(int idTipoTransaccion) throws ExcepcionesNGC {
		ContTransaccionTipo tipoTx = null;
		
		if(idTipoTransaccion >= 1){
			try {
				tipoTx = transaccionDao.obtenerTipoTransaccion(idTipoTransaccion);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta. Digite un ID de Tipo Transaccion valido.");
			throw expNgc;
		}	
		
		return tipoTx;
	}


	@Override
	public ContTransaccionTipo obtenerTipoTransaccionxNombre(String nombreTransaccion) throws ExcepcionesNGC {
		ContTransaccionTipo tipoTx = null;
		
		if(!nombreTransaccion.isEmpty()){
			try {
				tipoTx = transaccionDao.obtenerTipoTransaccionxNombre(nombreTransaccion);
			} catch (ExcepcionesDAO e) {
				expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e.getMensajeTecnico());
				expNgc.setMensajeUsuario(e.getMensajeUsuario());
				expNgc.setOrigen(e.getOrigen());
				throw expNgc;
			}
		}else{
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeUsuario("No es posible realizar la consulta. Digite un ID de Tipo Transaccion valido.");
			throw expNgc;
		}		
		return tipoTx;
	}
	
	
	public List<ContTransaccionTipo> listarTipoTransacciones() throws ExcepcionesNGC {
		List<ContTransaccionTipo> listaTipoTransaccion = null;
		
		try {
			listaTipoTransaccion = transaccionDao.listarTipoTransacciones();
		} catch (ExcepcionesDAO e) {
			expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}
		
		return listaTipoTransaccion;
	}

}
