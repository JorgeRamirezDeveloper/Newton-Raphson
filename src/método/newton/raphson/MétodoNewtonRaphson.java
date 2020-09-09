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
        String formula = t.nextLine();
        System.out.println("Introduce el nivel de aproximación: ");
        Integer nivel = t.nextInt();
        
        System.out.println(numTerminos(formula));
        
        
    }
    
    public static int numTerminos(String formula){
        int numeroDeTerminos = 0;
        if(formula.startsWith("+") || formula.startsWith("-")){
            numeroDeTerminos = 1;
        }
        
        
        for (int n = formula.length()-1; n >= 0; n--) { 
            char c = formula.charAt (n); 
            if( c == '-' || c == '+'){
                numeroDeTerminos++;
            }
        }
        
        return numeroDeTerminos+1;
        
    }
    
    
}
