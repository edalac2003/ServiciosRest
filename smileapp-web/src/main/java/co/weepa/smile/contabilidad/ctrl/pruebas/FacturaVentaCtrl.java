package co.weepa.smile.contabilidad.ctrl.pruebas;

import java.text.DecimalFormat;
import java.util.List;

import co.weepa.smile.contabilidad.dto.ContTercero;
import co.weepa.smile.contabilidad.dto.FactDetalleFactura;

public class FacturaVentaCtrl {

	double subtotal = 0.0;
	double vrTotal = 0.0;
	double vrBruto = 0.0;
	double vrIVA = 0;
	double vrDescuento = 0.0;
	float porcentaje = 0;
	float totalxProducto = 0;
	
	double cuenta110505 = 0; //Variable para la cuenta de Caja General (Efectivo)
	double cuenta135515 = 0; //Variable para la cuenta de Retencion x Renta.  En caso que el comprador haga retencion (Autoretenedor)
	double cuenta135517 = 0; //Variable para la cuenta de Retencion x Ventas.  En caso que el comprador haga retencion (Autoretenedor)
	double cuenta240805 = 0; //Variable para la cuenta IVA generado x Pagar -- En caso que el producto sea gravado
	double cuenta130505 = 0; //Si la FV es a Credito esta cuenta tiene movimiento en lugar de afectar la cuenta110505.
	double cuenta415555 = 0; //Representa el Ingreso x venta.
	double cuenta135519 = 0; //AUTOCREE. Se practica si y solo si, la persona es Regimen Comun (Debito)
	double cuenta236570 = 0; //AUTOCREE. Se practica si y solo si, la persona es Regimen Comun (Credito)
	double cuenta1410 = 0; //Inventario de Producto Terminado, Aplica para productos, no servicios. Es un promedio ponderado del valor de compra del producto.
	double cuenta6195 = 0; //Costo de Venta. Lo mismo que la cuenta1410 pero un debito.
	double tarifaRetencion = 0.025; //A modo de ejemplo se trabaja con el 2.5%
	
	DecimalFormat format = new DecimalFormat("#######.##");

	
	public FacturaVentaCtrl() {		
	}
	
	
	//ESTA ES LA LOGICA DE PROCESAMIENTO DE UNA FACTURA SIMPLE
//	public void procesarFactura(int cantidad, int vrUnitario, double iva, int descuento){
//		double subtotal = 0;
//		double vrBruto = 0.0;
//		double vrIVA = 0.0;
//		DecimalFormat format = new DecimalFormat("#######.##");
//		
//		if (iva <= 0){
//			vrBruto = (vrUnitario / 1.16);
//			vrIVA = (vrBruto - descuento) *0.16;
//			subtotal = (vrBruto + vrIVA) - descuento;
//		}
//		
//		System.out.println("Vr Bruto \t vr IVA \t Descuento \t Subtotal");
//		System.out.println(format.format(vrBruto)+"\t"+format.format(vrIVA)+"\t"+format.format(descuento)+"\t"+format.format(subtotal));
//	}
	
	//AQUI SE PROCESARÁ LA LOGICA PARA UNA FACTURA CON MOVIMIENTO CONTABLE
	public void procesarFactura(ContTercero tercero, List<FactDetalleFactura> listaDetalle, int tieneRetencion, int formaPago, int abono){		
		subtotal = 0.0;
		vrTotal = 0.0;
		vrBruto = 0.0;
		vrIVA = 0;
		vrDescuento = 0.0;
		porcentaje = 0;
		totalxProducto = 0;
		tarifaRetencion = 0;
		
		for(FactDetalleFactura detalle : listaDetalle){
			totalxProducto = (detalle.getNmcantidad() * detalle.getProdProducto().getNmprecioVenta());
			subtotal = subtotal + totalxProducto;
			porcentaje = (float)detalle.getProdProducto().getNmimpuesto()/100;
			vrIVA = vrIVA + (totalxProducto * porcentaje);
			vrDescuento = vrDescuento + (detalle.getNmdescuento());
			System.out.println(format.format(subtotal)+"\t\t"+format.format(vrIVA)+"\t"+format.format(vrDescuento)+"\t"+format.format(vrTotal)+"\t");
		}
		
		vrTotal = (subtotal + vrIVA) - vrDescuento;  
				
		System.out.println("Vr Bruto \t vr IVA \t Descuento \t Subtotal");
		System.out.println(format.format(subtotal)+"\t"+format.format(vrIVA)+"\t"+format.format(vrDescuento)+"\t"+format.format(vrTotal)+"\t");
		
		//HASTA AQUI VA EL DESGLOCE NORMAL DE LA FACTURA.
		//AHORA SIGUE EL DESGLOCE CONTABLE TENIENDO EN CUENTA TODOS LOS CONDICIONALES
		//SE INICIA CON LA PREMISA QUE LA VENTA ES DE CONTADO
		
//			if(formaPago == 1){ //El pago es de Contado
//				cuenta415555 = subtotal; //Es el valor de la Venta Bruta (Sin IVA o discriminado)
//				cuenta135515 = cuenta415555 * tarifaRetencion;
//				cuenta110505 = vrTotal - cuenta135515;
//				cuenta240805 = vrIVA; //Es el Iva Neto Generado por la venta.
//			} else if (formaPago == 2){		//El pago es a Credito
//				cuenta415555 = subtotal; //Es el valor de la Venta Bruta (Sin IVA o discriminado)
//				cuenta135515 = cuenta415555 * tarifaRetencion;
//				cuenta130505 = vrTotal - cuenta135515;
//				cuenta240805 = vrIVA; //Es el Iva Neto Generado por la venta.
//			} else if (formaPago == 3){ 	//El pago se realizó parte de contado y parte a Crédito
//				cuenta415555 = subtotal; //Es el valor de la Venta Bruta (Sin IVA o discriminado)
//				cuenta135515 = cuenta415555 * tarifaRetencion;
//				cuenta110505 = abono;
//				cuenta130505 = (vrTotal - abono) - cuenta135515;
//				cuenta240805 = vrIVA; //Es el Iva Neto Generado por la venta.
//			}
		
		
		
		System.out.println("Cuenta 415555 \t"+cuenta415555);
		System.out.println("Cuenta 135515 \t"+cuenta135515);
		System.out.println("Cuenta 110505 \t"+cuenta110505);
		System.out.println("Cuenta 240805 \t"+ cuenta240805);
		
		//PARA LOS CONDICIONALES SE DEBEN REALIZAR LAS VALIDACIONES DE LAS TABLAS CORRESPONDIENTES. POR EJEMPLO, PARA LAS RETENCIONES DEBO VERIFICAR QUE ES 
		//MI CLIENTE RESPECTO A MI; VERIFICAR EL TIPO DE REGMIEN, SI ES AUTORETENEDOR, ENTRE OTRAS.
		
		
	}

}
