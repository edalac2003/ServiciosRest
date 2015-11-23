package co.weepa.smile.contabilidad.util;

public class LeerArchivoTexto {	

	public LeerArchivoTexto() {		
	}

	public static void main(String[] args) {
		
//		File archivo = null;
//	      FileReader fr = null;
//	      BufferedReader br = null;	            
//	        
//			String tmpClase = "0";
////			String tmpGrupo = "00";
////			String tmpCuenta = "0000";
////			String tmpSubCuenta = "000000";			
//			
//			List<ContPlanCuenta> listaCuenta = null;
//			List<ContCuentaGrupo> listaGrupo = null;
//			
//	 
//	      try {
//	         // Apertura del fichero y creacion de BufferedReader para poder
//	         // hacer una lectura comoda (disponer del metodo readLine()).
//	         archivo = new File ("C:\\puc.csv");
//	         fr = new FileReader (archivo);
//	         br = new BufferedReader(fr);
//	 
//	         // Lectura del fichero
//	         String linea;
//	         ContPlanCuenta cuenta = new ContPlanCuenta();
//	 		 ContCuentaGrupo grupo = null;
//	         listaGrupo = new ArrayList<ContCuentaGrupo>();
//	         listaCuenta = new ArrayList<ContPlanCuenta>();
//	         ContNormaTipo tipoNorma = new ContNormaTipo("1","COLGAAP");
//	         while((linea=br.readLine())!=null){
//	        	 if(!linea.isEmpty()){	        		 
//	        		 cuenta = new ContPlanCuenta();
//	        		 String[] vector = linea.split(";");
//		        	 String descripcion = vector[1].trim().toUpperCase();
//		        	 String descripcionCuenta = vector[1].trim().toUpperCase();
////		        	 System.out.println(vector[0] + " - " +descripcion);
//		        	 tmpClase = vector[0];
//		        	 
//	     			 if(tmpClase.length() == 1){
//	     				 if (grupo == null)
//	     					 grupo = new ContCuentaGrupo(Integer.parseInt(tmpClase), tipoNorma);
//	     				 else 
//	     					 if (grupo.getIdcuentaGrupo()== Integer.parseInt(tmpClase))
//	     						 grupo = new ContCuentaGrupo(Integer.parseInt(tmpClase), tipoNorma);
//	     			 }else if (tmpClase.trim().length() == 2){
//	     				if (grupo.getIdcuentaGrupo()!= Integer.parseInt(tmpClase)){
//	     					String idGrupo = (String.valueOf(vector[0].charAt(0)));
//	     					grupo = new ContCuentaGrupo(Integer.parseInt(idGrupo), tipoNorma);
//	     				}
//	     						     				
//	     			 }else if(tmpClase.length() == 4){
//	     				if (grupo.getIdcuentaGrupo()!= Integer.parseInt(tmpClase)){
//	     					String idGrupo = vector[0].substring(0, 2);
//	     					grupo = new ContCuentaGrupo(Integer.parseInt(idGrupo), tipoNorma);
//	     				}
//	     					
//	     			 }else if (tmpClase.length() == 6){
//	     				if (grupo.getIdcuentaGrupo()!= Integer.parseInt(tmpClase)){
//	     					String idGrupo = vector[0].substring(0, 4);
//	     					grupo = new ContCuentaGrupo(Integer.parseInt(idGrupo), tipoNorma);
//	     				}    					
//	     				
//	     			 }
//	     			cuenta.setIdcuenta(Integer.parseInt(tmpClase));
//     				cuenta.setDsnombre(descripcionCuenta);
//     				cuenta.setContCuentaGrupo(grupo);
////		        	 listaGrupo.add(grupo);
//		        	 listaCuenta.add(cuenta);
//	        	 }	        	 
//	         }
//	      }
//	      catch(Exception e){
//	    	  System.out.println(e.getMessage());
//	         e.printStackTrace();
//	      }finally{
//	         // En el finally cerramos el fichero, para asegurarnos
//	         // que se cierra tanto si todo va bien como si salta 
//	         // una excepcion.
//	         try{                    
//	            if( null != fr ){   
//	               fr.close();     
//	            }                  
//	         }catch (Exception e2){ 
//	            e2.printStackTrace();
//	         }
//	      }
//	      
//	      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");	      
//	      PlanCuentaDAO contPlanCuentaDao = (PlanCuentaDAO)context.getBean("contPlanCuentaDao");
//	     
//	      System.out.println("LEYENDO LISTA DE GRUPOS");
//			for(ContPlanCuenta cuenta : listaCuenta){
//					System.out.println(cuenta.getIdcuenta()+" - "+cuenta.getDsnombre()+" - "+cuenta.getContCuentaGrupo().getIdcuentaGrupo()+" - ");
//			}
//	      
//	      
////	      try {
////			contPlanCuentaDao.guardarGrupoCuenta(listaGrupo);
////		} catch (ExcepcionesDAO e) {
////			System.out.println("Errores al Guardar Listado de Grupos. Error : "+e.getMessage());
////		}
//	      
//	      try {
//			contPlanCuentaDao.guardarCuentaPUC(listaCuenta);
//		} catch (ExcepcionesDAO e) {
//			System.out.println("Errores al Guardar Listado de Cuentas. Error : "+e.getMessage());
//		}
//
	}
	
}
