package método.newton.raphson;

import org.apache.commons.math3.*;
import java.util.Scanner;

public class MétodoNewtonRaphson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner t = new Scanner(System.in);
        
        System.out.println("Introduce la formula a calcular: ");
        String vlstrFormula = t.nextLine();
        System.out.println("Introduce el nivel de aproximación: ");
        Integer vlintNivel = t.nextInt();
        
        System.out.println(numTerminos(vlstrFormula));
        
        
    }
    
    //Se utiliza para revisar la cantidad de terminos en la formula brindada
    //basandose en la cantidad de simbolos + y -
    public static int numTerminos(String formula){
        int vlintNumeroDeTerminos = 0;
        boolean vlblnPrimerTerminoContado = false;
        //Se considera el primer termino-
        if(formula.startsWith("+") || formula.startsWith("-")){
            vlintNumeroDeTerminos = 1;
            vlblnPrimerTerminoContado = true;
        }
        boolean vlblnTerminoEncontrado = false;
        for (int n = formula.length()-1; n >= 0; n--) { 
            char c = formula.charAt (n); 
            if( c == '-' || c == '+'){
                vlintNumeroDeTerminos++;
                vlblnTerminoEncontrado = true;
            }
        }
        if(vlblnPrimerTerminoContado){
            return vlintNumeroDeTerminos-1;
        } else {
        //Se le suma uno para evitar que se ignore el primer termino
        return vlintNumeroDeTerminos+1;
        }
    }
    
    
}
