package proyectoFinal;

import java.util.Scanner;
public class App {
	
	public static String numeroAleatorio() {
 	   int tokenRandom = (int)(Math.random()*1000000);
 	   String tokenGenerado = String.valueOf(tokenRandom);
 	   while(tokenGenerado.length() < 6) {
			tokenGenerado = "0" + tokenGenerado;
 	   }
			return tokenGenerado;
    }
    
    public static boolean existeToken (String[] historial, String tokenGenerado) {
 	   boolean tokenYaGenerado = false;
 	   for (int i = 0; i < historial.length; i++) {
 		   if (tokenGenerado.equals(historial[i])) {
 			   tokenYaGenerado = true;
 			   break;
 		   }
 	   }
 	   return tokenYaGenerado;
    }
    
    public static void tokenHistorial(String[] historial, String token) {
 	   for (int i = 0; i < historial.length; i++) {
 		   if (historial[i] == null) {
 			   historial[i] = token;
 			   break;
 		 }
 	 }
 }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final String usuario_correcto = "administrador";
        final String clave_correcta = "administrador.1234";
        double numRandom = Math.random();
        int tokenRandom = (int)(numRandom * 1000000);
        String opcion = null, numAlea = null, letra = "s", tkn ,token = String.valueOf(tokenRandom);
        String[] historialDeToken = new String[3];
        	
       	
        System.out.println("Bienvenido a Online Banking, por favor ingrese las credenciales solicitadas: ");


        for (int i = 2; i >= 0; i--) {
        	for (int o = 0; o < 3; o++) {
        		numAlea = numeroAleatorio();
        		if (!existeToken(historialDeToken, numAlea)) {
        			tokenHistorial(historialDeToken, numAlea);
     }
  }
           System.out.println("Su Token generado es: " + numAlea);
           System.out.println("Usuario: ");
           String usuario_ingresado = sc.nextLine().toLowerCase();
           System.out.println("Contraseña: ");
           String clave_ingresada = sc.nextLine();
           System.out.println("Clave token: ");
           tkn = sc.nextLine();
            
            boolean usuarioCorrecto = usuario_ingresado.equals(usuario_correcto);
            boolean claveCorrecta = clave_ingresada.equals(clave_correcta);
            boolean tknCorrecto = numAlea.equals(tkn);
 

            if(usuarioCorrecto && claveCorrecta && tknCorrecto){
                System.out.println("Credenciales correctas, Bienvenido a su Online Banking");
                break;

            } else if(!usuarioCorrecto && !claveCorrecta && !tknCorrecto){
                System.out.println("Error en credenciales, le queda "+i+" intentos, desea intentarlo de nuevo? (S/N)");
                opcion = sc.nextLine();
                
            } if(!opcion.equals(letra)) {
            	break; 
            } 
            
            if (i == 0) {
            	System.out.println("Errores en credenciales, Usuario bloqueado, por favor dirijase a la sucursal mas cercana.");
            }

      }
               System.out.println("Gracias por utilizar Home Banking");
   }     
}
