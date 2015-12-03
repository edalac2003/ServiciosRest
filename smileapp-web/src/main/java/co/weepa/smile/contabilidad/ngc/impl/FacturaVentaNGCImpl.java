package co.weepa.smile.contabilidad.ngc.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import co.weepa.smile.contabilidad.dao.FacturaVentaDAO;
import co.weepa.smile.contabilidad.dto.CartCartera;
import co.weepa.smile.contabilidad.dto.CartFormaPago;
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
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;
import co.weepa.smile.contabilidad.dto.FactFactura;
import co.weepa.smile.contabilidad.dto.capsulas.ObjetoFactura;
import co.weepa.smile.contabilidad.dto.capsulas.Retenciones;
import co.weepa.smile.contabilidad.ngc.CarteraNGC;
import co.weepa.smile.contabilidad.ngc.CentroCostoNGC;
import co.weepa.smile.contabilidad.ngc.FacturaNGC;
import co.weepa.smile.contabilidad.ngc.FacturaVentaNGC;
import co.weepa.smile.contabilidad.ngc.MonedaNGC;
import co.weepa.smile.contabilidad.ngc.OrganizacionInternaNGC;
import co.weepa.smile.contabilidad.ngc.PlanCuentaNGC;
import co.weepa.smile.contabilidad.ngc.TerceroNGC;
import co.weepa.smile.contabilidad.ngc.TransaccionAccionNGC;
import co.weepa.smile.contabilidad.ngc.TransaccionNGC;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesDAO;
import co.weepa.smile.contabilidad.util.exception.ExcepcionesNGC;

public class FacturaVentaNGCImpl implements FacturaVentaNGC {
	final static Logger logger = Logger.getLogger(FacturaVentaNGCImpl.class);
	
	double subtotal = 0.0;
	double vrTotal = 0.0;
	double vrBruto = 0.0;
	double vrIVA = 0.0;
	double subTotalIVA = 0.0;
	double subTotalDescuento = 0.0;
	
	int totalxProducto = 0;
	double costoVenta = 0;
	
	DecimalFormat format = new DecimalFormat("#######.##");
	double asientoContable = 0;
	ContDetalleTransaccion detalleTransaccion = null;
	ContTransaccionContable transaccionContable = null;
	ContPlanCuenta cuentaPUC = null;
	ContMoneda moneda = null;
	ContCentroCosto centroCosto = null;
	ContTercero tercero = null;
	ContOrganizacionInterna organizacion = null;
	ContTransaccionTipo tipoTransaccion = null;
	CartFormaPago formaPago = null;
	
	
	List<ContDetalleTransaccion> listaDetalleTransaccion = null;
	List<DefiTransaccionAccion> listaCuentasxTransaccion = null;
	
	TerceroNGC terceroNgc;
	OrganizacionInternaNGC organizacionNgc;
	TransaccionNGC transaccionNgc;
	FacturaVentaDAO facturaVentaDao;
	FacturaNGC facturaNgc;
	TransaccionAccionNGC transaccionAccionNgc;
	PlanCuentaNGC planCuentaNgc;
	MonedaNGC monedaNgc;
	CentroCostoNGC centroCostoNgc;
	CarteraNGC carteraNgc;
	
	public void setFacturaVentaDao(FacturaVentaDAO facturaVentaDao) {
		this.facturaVentaDao = facturaVentaDao;
	}	
	
	public void setFacturaNgc(FacturaNGC facturaNgc) {
		this.facturaNgc = facturaNgc;
	}

	public void setTransaccionAccionNgc(TransaccionAccionNGC transaccionAccionNgc) {
		this.transaccionAccionNgc = transaccionAccionNgc;
	}
	
	public void setPlanCuentaNgc(PlanCuentaNGC planCuentaNgc) {
		this.planCuentaNgc = planCuentaNgc;
	}
	
	public void setMonedaNgc(MonedaNGC monedaNgc) {
		this.monedaNgc = monedaNgc;
	}

	public void setCentroCostoNgc(CentroCostoNGC centroCostoNgc) {
		this.centroCostoNgc = centroCostoNgc;
	}

	public void setTerceroNgc(TerceroNGC terceroNgc) {
		this.terceroNgc = terceroNgc;
	}

	public void setOrganizacionNgc(OrganizacionInternaNGC organizacionNgc) {
		this.organizacionNgc = organizacionNgc;
	}

	public void setTransaccionNgc(TransaccionNGC transaccionNgc) {
		this.transaccionNgc = transaccionNgc;
	}

	public void setCarteraNgc(CarteraNGC carteraNgc) {
		this.carteraNgc = carteraNgc;
	}

		
	/*
	 * Metodo Guardar Factura
	 * Se reciben los parámetros enviados desde la vista para ser procesados.
	 */
	@Override
	public void convertirObjetoFactura(ObjetoFactura objetoFactura) throws ExcepcionesNGC {
		String idTercero = objetoFactura.getIdTercero().toUpperCase();
		String nombreTransaccion = objetoFactura.getTipoTransaccion().toUpperCase();
		String formaPago = objetoFactura.getFormaPago().toUpperCase();
		
		int idOrganizacion = objetoFactura.getIdOrganizacion();
		int idMedioPago = objetoFactura.getIdMedioPago();
		FactFactura maestroFactura = objetoFactura.getMaestroFactura();		
		List<FactDetalleFactura> listaDetalles = objetoFactura.getListaDetalles();
		Retenciones retenciones = objetoFactura.getRetenciones();
		CartCartera maestroCartera = objetoFactura.getMaestroCartera();
		CartPago pagoCartera = objetoFactura.getPagoCartera();
		
		tipoTransaccion = transaccionNgc.obtenerTipoTransaccionxNombre(nombreTransaccion);		
		guardarFactura(idTercero, idOrganizacion, nombreTransaccion, tipoTransaccion, maestroFactura, formaPago, 
				idMedioPago, listaDetalles, retenciones, maestroCartera, pagoCartera);
		
	}
	
	
	
	public String guardarFactura(String  idTercero, int idOrganizacion, String nombreTransaccion, ContTransaccionTipo tipoTransaccion, FactFactura maestroFactura, String formaPago, int idMedioPago, 
			List<FactDetalleFactura> listaDetalles, Retenciones retenciones, CartCartera maestroCartera, CartPago pagoCartera) throws ExcepcionesNGC {
		
		tercero = terceroNgc.obtenerTercero(idTercero);
		organizacion = organizacionNgc.obtenerOrganizacion(idOrganizacion);
		moneda = monedaNgc.obtenerMoneda(1);
		centroCosto = centroCostoNgc.obtenerCentroCosto(1);
		String numeroFactura = "";
//		tipoTransaccion = transaccionNgc.obtenerTipoTransaccion(idTipoTransaccion);
		
		if((organizacion != null) && (tercero != null) && (tipoTransaccion != null) && (maestroFactura != null) && (!listaDetalles.isEmpty())){	
			if((nombreTransaccion.contains("FACTURA")) && (nombreTransaccion.contains("VENTA"))){
				double porcentaje = 0;
				/**
				 * Se analiza la lista Detalle Factura para calcular los valores que se necesitaran mas adelante cuando se desee realizar el detalle
				 * de la transaccion donde se asigna el valor a cada cuenta.			
				 */
				for(FactDetalleFactura detalle : listaDetalles){
					totalxProducto = (detalle.getNmcantidad() * detalle.getProdProducto().getNmprecioVenta());
					subtotal = subtotal + totalxProducto;
					
					int vrImpuesto = detalle.getProdProducto().getNmimpuesto();
					if ((vrImpuesto >= 0) && (vrImpuesto <= 1)){
						porcentaje = vrImpuesto;
					}else if ((vrImpuesto >= 1) && (vrImpuesto <= 100)){
						porcentaje = detalle.getProdProducto().getNmimpuesto()/100.0;
					}else{
						porcentaje = 0;
					}			
					costoVenta = costoVenta + (detalle.getProdProducto().getNmprecioCompra()*detalle.getNmcantidad());
					vrIVA = vrIVA + (totalxProducto * porcentaje);
					subTotalDescuento = subTotalDescuento + (detalle.getNmdescuento());
				}		
				vrTotal = (subtotal + vrIVA) - subTotalDescuento;
				
				/*
				 *  Quiere decir que se aplicaran retenciones, por lo tanto se recalcula el subtotal ya que hay que restarle las retenciones.	
				 */
				if(retenciones != null){
					if((retenciones.getReteFuente()>0) || (retenciones.getReteICA()>0) || (retenciones.getReteIva() > 0)){
						vrTotal = vrTotal - (retenciones.getReteFuente()+retenciones.getReteICA()+retenciones.getReteIva());
					}				
				}
				
				//Se actualiza el valor Total en el Maestro Factura
				maestroFactura.setNmvalorTotal(BigDecimal.valueOf(vrTotal));
				
				
				
				/*
				 * Se crea nuevo objeto de tipo Transaccion Contable
				 */
				transaccionContable = new ContTransaccionContable();
				transaccionContable.setIdtransaccion(0);
				transaccionContable.setContTransaccionTipo(tipoTransaccion);
				transaccionContable.setFetransaccion(maestroFactura.getFefactura());
				transaccionContable.setNmvalorTransaccion(maestroFactura.getNmvalorTotal());
				transaccionContable.setDsdescripcionTransaccion("transaccion del documento : "+nombreTransaccion);
//				transaccionContable.setDsnumeroDocumento(maestroFactura.getDsnumeroFactura());
				transaccionContable.setContOrganizacionInterna(organizacion);
				transaccionContable.setContMoneda(moneda);
				transaccionContable.setContTercero(tercero);
				
				/**
				 * Se Buscan las cuentas que se encuentran asociadas al tipo de Transaccion
				 */
				try {
					listaCuentasxTransaccion = transaccionAccionNgc.listaCuentasxTransaccion(organizacion, tipoTransaccion);
				} catch (ExcepcionesNGC e) {
					e.printStackTrace();
				}
				
				
				/**
				 * Se Asignaran valores a cada una de las cuentas halladas para esa transaccion
				 */
				if(!listaCuentasxTransaccion.isEmpty()){
					listaDetalleTransaccion = new ArrayList<ContDetalleTransaccion>();
					String cuenta = "";				
					double valorCuenta = 0;					//Esta variable tomará el valor que afectará la cuenta.			
									
					for(DefiTransaccionAccion cuentaxTX : listaCuentasxTransaccion){
						cuentaPUC = cuentaxTX.getContPlanCuenta();
						ContNormaTipo tipoNorma = cuentaPUC.getContCuentaGrupo().getContNormaTipo();
						detalleTransaccion = new ContDetalleTransaccion(0, tipoNorma, cuentaPUC, transaccionContable);
						cuenta = String.valueOf(cuentaxTX.getContPlanCuenta().getIdcuenta());
						
						if (cuenta.startsWith("2408")){					//Busca la cuenta relacionada con Impuestos (-)
							valorCuenta = vrIVA * -1;					
						}else if(cuenta.startsWith("6135")){			//Busca la cuenta relacionada con Costos de Mercancias (+)
							valorCuenta = costoVenta;
						}else if ((cuenta.startsWith("1435")) || (cuenta.startsWith("6135"))){		//Busca la Cuenta relacionada con Inventarios (Costo de Mercancia) (-)
							valorCuenta = subtotal * -1;
						}else if (cuenta.startsWith("1305")){			//Busca la Cuenta Relacionada con Clientes x Cobrar (+)
							valorCuenta = vrTotal;
						}else if (cuenta.startsWith("530535")){			//Cuentas Relacionadas con los Descuentos (+)
							valorCuenta = subTotalDescuento;
						}else if (cuenta.startsWith("135517")){			//Cuentas Relacionadas para la Retencion de IVA (+)
							valorCuenta = ((retenciones != null)?retenciones.getReteIva():0); 
						}else if (cuenta.startsWith("135510")){			//Cuentas Relacionadas para la Retencion de ICA (+)
							valorCuenta = ((retenciones != null)?retenciones.getReteICA():0); 
						}else if (cuenta.startsWith("135515")){			//Cuentas Relacionadas para la Retencion en la Fuente (+)
							valorCuenta = ((retenciones != null)?retenciones.getReteFuente():0); 
						}else if (cuenta.startsWith("135519")){			//En caso que se genere Autocree (Debito)
							valorCuenta = 0;
						}else if (cuenta.startsWith("236570")){			//En Caso que se genere Autocree (Credito)
							valorCuenta = 0;
						}
						asientoContable = asientoContable + valorCuenta;		
						
						detalleTransaccion.setNmvalor(BigDecimal.valueOf(valorCuenta));
						detalleTransaccion.setContCentroCosto(centroCosto);
						listaDetalleTransaccion.add(detalleTransaccion);
						
						/*
						 * DEBIDO A QUE ESTA CUENTA REALIZA DOBLE DETALLE, SE CREA UN NUEVO CONDICIONAL PARA GENERAR EL REGISTRO DE LA
						 * TRANSACCION AFECTADO POR EL COSTO DE VENTA DEL PRODUCTO VENDIDO. ESTA CUENTA HACE PARTIDA CON LA 6135.
						 */
						if (cuenta.startsWith("1435")){			//Busca la Cuenta relacionada con Inventarios (Costo de Mercancia) (-)
							detalleTransaccion = new ContDetalleTransaccion(0, tipoNorma, cuentaPUC, transaccionContable);
							cuenta = String.valueOf(cuentaxTX.getContPlanCuenta().getIdcuenta());
							valorCuenta = costoVenta * -1;
							detalleTransaccion.setNmvalor(BigDecimal.valueOf(valorCuenta));
							detalleTransaccion.setContCentroCosto(centroCosto);
							listaDetalleTransaccion.add(detalleTransaccion);
							asientoContable = asientoContable + valorCuenta;
						}
						
						/*
						 * En caso de ser a Credito
						 */
						if(formaPago.contains("CREDITO")){
//							if(cuenta.startsWith("1305")){
//								maestroCartera.setContPlanCuenta(cuentaPUC);
//							}
						}else if (formaPago.contains("CONTADO")){
							// Se genera recibo de caja por ser de contado
							// Ahora se valida a donde se llevará el valor pagado, si es en Caja (efectivo) o a un Banco (otro Medio)
//							SI(MedioPago de pago == efectivo) entonces
//								llevar valor a la cuenta de Caja
//							sino
//								llevar valor a la cuenta de Banco
						}
						
					} //Fin Para (DefiTransaccionAccion cuentaxTX : listaCuentasxTransaccion)
					

					// Se debe validar que el asiento esté cuadrado, de lo contrario no permitir hacer la Tx.
					if (asientoContable != 0){
						logger.info("El asiento Contable no da.  Revise!!!. Hay una Diferencia de "+ String.valueOf(asientoContable));
						ExcepcionesNGC expNgc = new ExcepcionesNGC();
						expNgc.setMensajeUsuario("El asiento Contable no da.  Revise!!!. Hay una Diferencia de "+ String.valueOf(asientoContable));
						throw expNgc;					
					}
					
					numeroFactura = facturaNgc.consecutivoFactura(nombreTransaccion);
					transaccionContable.setDsnumeroDocumento(maestroFactura.getDsnumeroFactura());
					try {						
						facturaVentaDao.guardarFactura(maestroFactura, listaDetalles, transaccionContable, listaDetalleTransaccion, maestroCartera, pagoCartera);
					} catch (ExcepcionesDAO e) {
						logger.error("NGC: Se presentaron errores al guardar el Registro de la Factura.  Error : "+e.getMessage());
						ExcepcionesNGC expNgc = new ExcepcionesNGC();
						expNgc.setMensajeTecnico(e.getMensajeTecnico());
						expNgc.setMensajeUsuario(e.getMensajeUsuario());
						expNgc.setOrigen(e.getOrigen());
						throw expNgc;
					}
					
					/**
					 * En caso que se haya realizado algun tipo de Abono o Cuota Inicial, se debe dejar registro del dinero recibido por medio de una 
					 * transaccion de tipo Recibo de Caja 
					 * 
					 * El codigo Muerto se coloc� en otro archivo
					 */

				
				}else{
					logger.error("No es posible Continuar. Los Campos obligatorios estan incompletos.");
					throw new ExcepcionesNGC("No es posible Continuar. Los Campos obligatorios estan incompletos.");
				}				
			}		//Fin Si, validacion tipo de Factura... En este caso, factura de Venta.
		} 			//Fin Si, validacion de Organizacion, Tercero, tipoTransaccion, maestro factura y Lista Detalle Facturas
		
		return numeroFactura;
	}		
			

	
	
	

	public void guardarCotizacion(String idTercero, int idOrganizacion, FactFactura maestroFactura, List<FactDetalleFactura> listaDetalles) throws ExcepcionesNGC {
		tercero = maestroFactura.getContTercero();
		organizacion = organizacionNgc.obtenerOrganizacion(idOrganizacion);
		
		if((organizacion != null) && (tercero != null) && (maestroFactura != null) && (!listaDetalles.isEmpty())){					
			double porcentaje = 0;
			/**
			 * Se analiza la lista Detalle Factura para calcular los valores que se necesitaran mas adelante cuando se desee realizar el detalle
			 * de la transaccion donde se asigna el valor a cada cuenta.			
			 */
			for(FactDetalleFactura detalle : listaDetalles){
				totalxProducto = (detalle.getNmcantidad() * detalle.getProdProducto().getNmprecioVenta());
				subtotal = subtotal + totalxProducto;				
				vrIVA = ((porcentaje > 0)?(totalxProducto * porcentaje):0);
				subTotalIVA = subTotalIVA + vrIVA;
				subTotalDescuento = subTotalDescuento + (detalle.getNmdescuento());
				detalle.setNmsubtotal(totalxProducto);
//				detalle.setNmimpuesto(Integer.parseInt(String.valueOf(vrIVA)));				
			}		
			vrTotal = (subtotal + subTotalIVA) - subTotalDescuento;
			
			
			//Se actualiza el valor Total en el Maestro Factura
			maestroFactura.setNmvalorTotal(BigDecimal.valueOf(vrTotal));
			
			try {
				moneda = monedaNgc.obtenerMoneda(1);
			}catch (ExcepcionesNGC e1) {
				ExcepcionesNGC expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e1.getMensajeTecnico());
				expNgc.setMensajeUsuario(e1.getMensajeUsuario());
				expNgc.setOrigen(e1.getOrigen());
				throw expNgc;
			}
			
			try {
				centroCosto = centroCostoNgc.obtenerCentroCosto(1);
			} catch (ExcepcionesNGC e1) {
				ExcepcionesNGC expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e1.getMensajeTecnico());
				expNgc.setMensajeUsuario(e1.getMensajeUsuario());
				expNgc.setOrigen(e1.getOrigen());
				throw expNgc;
			}
		
		}
		
		try {
			facturaVentaDao.guardarCotizacion(maestroFactura, listaDetalles);
		} catch (ExcepcionesDAO e) {
			logger.error("NGC: Se presentaron errores al guardar el Registro de la Factura.  Error : "+e.getMessage());
			ExcepcionesNGC expNgc = new ExcepcionesNGC();
			expNgc.setMensajeTecnico(e.getMensajeTecnico());
			expNgc.setMensajeUsuario(e.getMensajeUsuario());
			expNgc.setOrigen(e.getOrigen());
			throw expNgc;
		}		
	}

	
	
	
	@Override
	public void guardarFacturaCompra(String idTercero, int idOrganizacion, int idTipoTransaccion,
			FactFactura maestroFactura, int formaPago, int medioPago, List<FactDetalleFactura> listaDetalles,
			Retenciones retenciones, CartCartera maestroCartera, CartPago pagoCartera) throws ExcepcionesNGC {
		
		tercero = terceroNgc.obtenerTercero(idTercero);
		organizacion = organizacionNgc.obtenerOrganizacion(idOrganizacion);
		tipoTransaccion = transaccionNgc.obtenerTipoTransaccion(idTipoTransaccion);
		
		if((organizacion != null) && (tercero != null) && (tipoTransaccion != null) && (maestroFactura != null) && (!listaDetalles.isEmpty())){					
						
			
			double porcentaje = 0;
			/**
			 * Se analiza la lista Detalle Factura para calcular los valores que se necesitaran mas adelante cuando se desee realizar el detalle
			 * de la transaccion donde se asigna el valor a cada cuenta.			
			 */
			for(FactDetalleFactura detalle : listaDetalles){
				totalxProducto = (detalle.getNmcantidad() * detalle.getProdProducto().getNmprecioVenta());
				subtotal = subtotal + totalxProducto;
				
				int vrImpuesto = detalle.getProdProducto().getNmimpuesto();
				if ((vrImpuesto >0) && (vrImpuesto <1)){
					porcentaje = vrImpuesto;
				}else if ((vrImpuesto >=1) && (vrImpuesto <=100)){
					porcentaje = detalle.getProdProducto().getNmimpuesto()/100.0;
				}else{
					porcentaje = 0;
				}			
				costoVenta = costoVenta + (detalle.getProdProducto().getNmprecioCompra()*detalle.getNmcantidad());
				vrIVA = vrIVA + (totalxProducto * porcentaje);
				subTotalDescuento = subTotalDescuento + (detalle.getNmdescuento());
			}		
			vrTotal = (subtotal + vrIVA); //Temporalmente excluido para que sea calculado al momento en que se realice el pago - subTotalDescuento;
			
			/*
			 *  Quiere decir que se aplicaran retenciones, por lo tanto se recalcula el subtotal ya que hay que restarle las retenciones.	
			 */
			if(retenciones != null){
				if((retenciones.getReteFuente()>0) || (retenciones.getReteICA()>0) || (retenciones.getReteIva() > 0)){
					vrTotal = vrTotal - (retenciones.getReteFuente()+retenciones.getReteICA()+retenciones.getReteIva());
				}				
			}
			
			//Se actualiza el valor Total en el Maestro Factura
			maestroFactura.setNmvalorTotal(BigDecimal.valueOf(vrTotal));
			
			try {
				moneda = monedaNgc.obtenerMoneda(1);
			} catch (ExcepcionesNGC e1) {
				ExcepcionesNGC expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e1.getMensajeTecnico());
				expNgc.setMensajeUsuario(e1.getMensajeUsuario());
				expNgc.setOrigen(e1.getOrigen());
				throw expNgc;
			}
			
			try {
				centroCosto = centroCostoNgc.obtenerCentroCosto(1);
			} catch (ExcepcionesNGC e1) {
				ExcepcionesNGC expNgc = new ExcepcionesNGC();
				expNgc.setMensajeTecnico(e1.getMensajeTecnico());
				expNgc.setMensajeUsuario(e1.getMensajeUsuario());
				expNgc.setOrigen(e1.getOrigen());
				throw expNgc;
			}
			
			/*
			 * Se crea nuevo objeto de tipo Transaccion Contable
			 */
			transaccionContable = new ContTransaccionContable();
			transaccionContable.setIdtransaccion(0);
			transaccionContable.setContTransaccionTipo(tipoTransaccion);
			transaccionContable.setFetransaccion(maestroFactura.getFefactura());
			transaccionContable.setNmvalorTransaccion(maestroFactura.getNmvalorTotal());
			transaccionContable.setDsdescripcionTransaccion("");
			transaccionContable.setDsnumeroDocumento(maestroFactura.getDsnumeroFactura());
			transaccionContable.setContOrganizacionInterna(organizacion);
			transaccionContable.setContMoneda(moneda);
			transaccionContable.setContTercero(tercero);
			
			/**
			 * Se Buscan las cuentas que se encuentran asociadas al tipo de Transaccion
			 */
			try {
				listaCuentasxTransaccion = transaccionAccionNgc.listaCuentasxTransaccion(organizacion, tipoTransaccion);
			} catch (ExcepcionesNGC e) {
				e.printStackTrace();
			}
			
			
			/**
			 * Se Asignaran valores a cada una de las cuentas halladas para esa transaccion
			 */
			if(!listaCuentasxTransaccion.isEmpty()){
				listaDetalleTransaccion = new ArrayList<ContDetalleTransaccion>();
				String cuenta = "";				
				double valorCuenta = 0;					//Esta variable tomará el valor que afectará la cuenta.			
								
				for(DefiTransaccionAccion cuentaxTX : listaCuentasxTransaccion){
					cuentaPUC = cuentaxTX.getContPlanCuenta();
					ContNormaTipo tipoNorma = cuentaPUC.getContCuentaGrupo().getContNormaTipo();
					detalleTransaccion = new ContDetalleTransaccion(0, tipoNorma, cuentaPUC, transaccionContable);
					cuenta = String.valueOf(cuentaxTX.getContPlanCuenta().getIdcuenta());
					
					if (cuenta.startsWith("2408")){					//Busca la cuenta relacionada con Impuestos (-)
						valorCuenta = vrIVA;					
					}else if(cuenta.startsWith("6135")){			//Busca la cuenta relacionada con Costos de Mercancias (+)
						valorCuenta = costoVenta;
					}else if ((cuenta.startsWith("1435"))){		//Busca la Cuenta relacionada con Inventarios (Costo de Mercancia) (-)
						valorCuenta = subtotal;
					}else if (cuenta.startsWith("2205")){			//Busca la Cuenta Relacionada con Clientes x Cobrar (+)
						valorCuenta = vrTotal * -1;
					}else if (cuenta.startsWith("421040")){			//Cuentas Relacionadas con los Descuentos (+)
						valorCuenta = subTotalDescuento;
					}else if (cuenta.startsWith("2367")){			//Cuentas Relacionadas para la Retencion de IVA (+)
						valorCuenta = ((retenciones != null)?retenciones.getReteIva()*-1:0); 
					}else if (cuenta.startsWith("2368")){			//Cuentas Relacionadas para la Retencion de ICA (+)
						valorCuenta = ((retenciones != null)?retenciones.getReteICA()*-1:0); 
					}else if (cuenta.startsWith("2365")){			//Cuentas Relacionadas para la Retencion en la Fuente (+)
						valorCuenta = ((retenciones != null)?retenciones.getReteFuente()*-1:0); 
					}
//					else if (cuenta.startsWith("135519")){			//En caso que se genere Autocree (Debito)
//						valorCuenta = 0;
//					}else if (cuenta.startsWith("236570")){			//En Caso que se genere Autocree (Credito)
//						valorCuenta = 0;
//					}
					asientoContable = asientoContable + valorCuenta;		
					
					detalleTransaccion.setNmvalor(BigDecimal.valueOf(valorCuenta));
					detalleTransaccion.setContCentroCosto(centroCosto);
					listaDetalleTransaccion.add(detalleTransaccion);
					
					/*
					 * DEBIDO A QUE ESTA CUENTA REALIZA DOBLE DETALLE, SE CREA UN NUEVO CONDICIONAL PARA GENERAR EL REGISTRO DE LA
					 * TRANSACCION AFECTADO POR EL COSTO DE VENTA DEL PRODUCTO VENDIDO. ESTA CUENTA HACE PARTIDA CON LA 6135.
					 */
//					if (cuenta.startsWith("1435")){			//Busca la Cuenta relacionada con Inventarios (Costo de Mercancia) (-)
//						detalleTransaccion = new ContDetalleTransaccion(0, tipoNorma, cuentaPUC, transaccionContable);
//						cuenta = String.valueOf(cuentaxTX.getContPlanCuenta().getIdcuenta());
//						valorCuenta = costoVenta;
//						detalleTransaccion.setNmvalor(BigDecimal.valueOf(valorCuenta));
//						detalleTransaccion.setContCentroCosto(centroCosto);
//						listaDetalleTransaccion.add(detalleTransaccion);
//						asientoContable = asientoContable + valorCuenta;
//					}
					
					/*
					 * En caso de ser a Credito
					 */
//					if(formaPago.contains("CREDITO")){
//						if(cuenta.startsWith("1305")){
//							maestroCartera.setContPlanCuenta(cuentaPUC);
//						}
//					}else if (formaPago.contains("CONTADO")){
						// Se genera recibo de caja por ser de contado
						// Ahora se valida a donde se llevará el valor pagado, si es en Caja (efectivo) o a un Banco (otro Medio)
//						SI(MedioPago de pago == efectivo) entonces
//							llevar valor a la cuenta de Caja
//						sino
//							llevar valor a la cuenta de Banco
//					}
					
				} //Fin Para (DefiTransaccionAccion cuentaxTX : listaCuentasxTransaccion)
				

				// Se debe validar que el asiento esté cuadrado, de lo contrario no permitir hacer la Tx.
				if (asientoContable != 0){
					logger.info("El asiento Contable no da.  Revise!!!. Hay una Diferencia de "+ String.valueOf(asientoContable));
					ExcepcionesNGC expNgc = new ExcepcionesNGC();
					expNgc.setMensajeUsuario("El asiento Contable no da.  Revise!!!. Hay una Diferencia de "+ String.valueOf(asientoContable));
					throw expNgc;					
				}else{
					try {
						facturaVentaDao.guardarFacturaCompra(maestroFactura, listaDetalles, transaccionContable, listaDetalleTransaccion, maestroCartera, pagoCartera);
						ExcepcionesNGC expNgc = new ExcepcionesNGC();						
						expNgc.setMensajeUsuario("REGISTRO GUARDADO SATISFACTORIAMENTE.");						
						throw expNgc;
					} catch (ExcepcionesDAO e) {
						logger.error("NGC: Se presentaron errores al guardar el Registro de la Factura.  Error : "+e.getMessage());
						ExcepcionesNGC expNgc = new ExcepcionesNGC();
						expNgc.setMensajeTecnico(e.getMensajeTecnico());
						expNgc.setMensajeUsuario(e.getMensajeUsuario());
						expNgc.setOrigen(e.getOrigen());
						throw expNgc;
					}
				}
				
				
				
				
				/**
				 * En caso que se haya realizado algun tipo de Abono o Cuota Inicial, se debe dejar registro del dinero recibido por medio de una 
				 * transaccion de tipo Recibo de Caja 
				 */
//				if(pagoCartera != null){
//					double valorSaldoCaja = 0.0; 	
////					double valorSaldoClientes =0.0; 				
//					int medioPago = 1;
//					/**
//					 * 
//					 */
//				
//					if (pagoCartera != null){			//Fue a crédito pero dio una cuota inicial o un abono.
//						valorSaldoCaja = Double.parseDouble(pagoCartera.getNmvalor().toString());
////						valorSaldoClientes = vrTotal - valorSaldoCaja;
//						
//						if(medioPago == 1){				//supongamos que pagaron en Efectivo
//							tipoTransaccion = transaccionTipoNgc.obtenerTipoTransaccion(5);		//Tipo de Tx: Recibo de Caja Efectivo
//						}else if (medioPago == 2){		//Supongamos que fue en Consignacion, Cheques, TD, TC....
//							tipoTransaccion = transaccionTipoNgc.obtenerTipoTransaccion(6);		//Tipo de tx: Recibo de Caja no Efectivo.
//						}
//						
//						transaccionContable = new ContTransaccionContable();
//						transaccionContable.setIdtransaccion(0);
//						transaccionContable.setContTransaccionTipo(tipoTransaccion);
//						transaccionContable.setFetransaccion(maestroFactura.getFefactura());
//						transaccionContable.setNmvalorTransaccion(maestroFactura.getNmvalorTotal());
//						transaccionContable.setDsdescripcionTransaccion("Recibo de Caja");
//						transaccionContable.setDsnumeroDocumento(maestroFactura.getDsnumeroFactura());
//						transaccionContable.setContOrganizacionInterna(organizacion);
//						transaccionContable.setContMoneda(moneda);
//						transaccionContable.setContTercero(tercero);
//						
//						/**
//						 * Se Buscan las cuentas que se encuentran asociadas al tipo de Transaccion
//						 */
//						try {
//							listaCuentasxTransaccion = transaccionAccionNgc.listaCuentasxTransaccion(organizacion, tipoTransaccion);
//						} catch (ExcepcionesNGC e) {
//							e.printStackTrace();
//						}						
//						
//						/**
//						 * Se Asignaran valores a cada una de las cuentas halladas para esa transaccion
//						 */
//						if(!listaCuentasxTransaccion.isEmpty()){
//							listaDetalleTransaccion = new ArrayList<ContDetalleTransaccion>();
//							valorCuenta = 0;
//							
//							for(DefiTransaccionAccion cuentaxTX : listaCuentasxTransaccion){
//								cuentaPUC = cuentaxTX.getContPlanCuenta();
//								ContNormaTipo tipoNorma = cuentaPUC.getContCuentaGrupo().getContNormaTipo();
//								detalleTransaccion = new ContDetalleTransaccion(0, tipoNorma, cuentaPUC, transaccionContable);
//								cuenta = String.valueOf(cuentaxTX.getContPlanCuenta().getIdcuenta());
//								
//								if (cuenta.startsWith("1105")){					//Busca la cuenta relacionada con Caja (+)
//									valorCuenta = valorSaldoCaja;
//								}else if (cuenta.startsWith("1305")){			//Busca la Cuenta Relacionada con Clientes x Cobrar (-)
//									valorCuenta = valorSaldoCaja * -1;
//								}
//								asientoContable = asientoContable + valorCuenta;								
//								detalleTransaccion.setNmvalor(BigDecimal.valueOf(valorCuenta));
//								detalleTransaccion.setContCentroCosto(centroCosto);
//								listaDetalleTransaccion.add(detalleTransaccion);
//							}
//						}
//						
//						/**
//						 * Se guarda la nueva transaccion
//						 */
//						try {
//							facturaVentaDao.guardarFactura(maestroFactura, listaDetalles, transaccionContable, listaDetalleTransaccion, maestroCartera, pagoCartera);
//						} catch (ExcepcionesDAO e) {
//							logger.error("NGC: Se presentaron errores al guardar el Registro de la Factura.  Error : "+e.getMessage());
//							System.out.println("Error Guardar. "+e.getMessage());
//						}
//					} // Fin_si (pagoCartera != null)
//				}
			
			}else{
				logger.error("No es posible Continuar. Los Campos obligatorios estan incompletos.");
				throw new ExcepcionesNGC("No es posible Continuar. Los Campos obligatorios estan incompletos.");
			}		
		}
		
	}
	
	
}
