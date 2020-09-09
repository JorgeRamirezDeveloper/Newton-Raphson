package método.newton.raphson;

import java.util.Scanner;

public class MétodoNewtonRaphson {

    public static void main(String[] args) {
        
        Scanner vlscnTeclado = new Scanner(System.in);
        String vlstrFormula;
        Integer vlintNivel;
        
        System.out.println("Introduce la formula a calcular: ");
        vlstrFormula = vlscnTeclado.nextLine();
        System.out.println("Introduce el nivel de aproximación: ");
        vlintNivel = vlscnTeclado.nextInt();
        
        int vlintNumTerminos = numTerminos(vlstrFormula);
        
        String[] vlastrTerminos = new String[vlintNumTerminos];
        for(int j = 0; j < vlintNumTerminos; j++){
            vlastrTerminos[j] = "";
        }
        
        int vlintConteo = 0;
        int vlintSelector = 0;
        boolean vlblnPotencia = false;
        int vlintPosicion = 0;
        for(int i = 0; i < vlintNumTerminos; i++){
            for (vlintConteo = vlintSelector; vlintConteo < vlstrFormula.length(); vlintConteo++) { 
                char vlchrCaracter = vlstrFormula.charAt (vlintConteo); 
                if(vlchrCaracter == '^'){
                    vlblnPotencia = true;
                    vlintPosicion = vlintConteo;
                }
                if(vlintConteo == vlintSelector && (vlchrCaracter == '-' || vlchrCaracter == '+')){
                     vlastrTerminos[i] = vlastrTerminos[i]+vlchrCaracter;
                }
                else if (vlchrCaracter != '-' && vlchrCaracter != '+'){
                    vlastrTerminos[i] = vlastrTerminos[i]+vlchrCaracter;
                }
                else if (vlchrCaracter == '-' || vlchrCaracter == '+'){
                    if(vlblnPotencia && vlintPosicion == (vlintConteo-1)){
                        vlastrTerminos[i] = vlastrTerminos[i]+vlchrCaracter;
                        vlblnPotencia = false;
                        
                    } else {
                    
                        vlintSelector = vlintConteo;
                        break;
                    }
                }
               
            }
        }
        vlintConteo = 0;
        while(vlintConteo < vlintNumTerminos){
            System.out.println(vlastrTerminos[vlintConteo]);
            vlintConteo++;
        }
        
    }
    
    //Se utiliza para revisar la cantidad de terminos en la formula brindada
    //basandose en la cantidad de simbolos + y -
    public static int numTerminos(String vlstrFormula){
        int vlintNumeroDeTerminos = 0;
        boolean vlblnPrimerTerminoContado = false;
        //Se considera el primer termino-
        if(vlstrFormula.startsWith("+") || vlstrFormula.startsWith("-")){
            vlintNumeroDeTerminos = 1;
            vlblnPrimerTerminoContado = true;
        }
        boolean vlblnTerminoEncontrado = false;
        for (int n = vlstrFormula.length()-1; n >= 0; n--) { 
            char vlchrCaracter = vlstrFormula.charAt (n); 
            if( vlchrCaracter == '-' || vlchrCaracter == '+'){
                vlintNumeroDeTerminos++;
                vlblnTerminoEncontrado = true;
            }
            //Se revisa que el signo - o + no pertenezca a una potencia 
            else if(vlchrCaracter == '^' && vlblnTerminoEncontrado){
                vlintNumeroDeTerminos--;
                vlblnTerminoEncontrado = false;
            }
            else {
                vlblnTerminoEncontrado = false;
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
