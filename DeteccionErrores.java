/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

/**
 *
 * <pre>
 * Clase Detección de errores:
 * 
 * Esta clase almacena los métodos necesarios para evitar errores en la entrada de
 * datos por parte del usuario para que a su vez estos puedan ser usados en la clase MetodosCalc
 * 
 * </pre>
 * @author Aylin Ocampo
 */
public class DeteccionErrores {
    
    /**
     * <pre>
     * Método revisaParentesis:
     * 
     * Este método recibe una cadena la cual mediante un ciclo compara la posición de sus elementos para comprobar
     * si estan en un órden congruente para realizar alguna operacion, en este caso se busca examinar si hay un correcto uso de paréntesis.
     * 
     * </pre>
     * 
     * @param str Cadena que contiene una o varias operaciones
     * @return <ul>
     * <li>true: Hay el mismo numero de paréntesis</li>
     * <li>false:Los paréntesis no tienen congruencia pues no hay el mismo número de paréntesis que abran y cierren</li>
     * </ul>
     * 
     */
    private static boolean revisaParentesis(String str) {
        boolean res;
        int tam, i, contIzq=0, contDer=0;
        PilaA p = new PilaA();
        
        tam= str.length();
        for(int j=0; j<tam; j++) 
            p.push(str.charAt(j));  //Se insertan los elementos de la operacion en la pila P
        i=0;
        while(i<tam && contDer>=contIzq) { 
            if(p.peek().equals(')')) { 
                contDer++; //Se cuentan los parentesis de la derecha
            }
            else {
                if(p.peek().equals('('))
                    contIzq++; //Se cuentan los parentesis de la izquierda
            }
            p.pop();
            i++;
        }
        if(contIzq==contDer) { //Si hay el mismo numero de parentesis el orden es correcto
            res=true;
        }
        else
            res=false;
        return res;
    }
    
    /**
     * <pre>
     * Método revisaOperadores:
     * 
     * Este método recibe una cadena la cual compara la posición de sus elementos para comprobar
     * si estan en un órden congruente, en este caso se busca examinar si hay un correcto uso de operadores.
     * 
     * </pre>
     * 
     * @param str Cadena que contiene una o varias operaciones
     * @return <ul>
     * <li>true: Los operadores son congruentes porque no estan juntos</li>
     * <li>false: Hay dos o más operadores juntos, esto implica incongruencia en el orden de la operación</li>
     * </ul> 
     * 
     */
    private static boolean revisaOperadores(String str) {
        boolean res=true;
        int i=1;
        
        while(i<str.length() && res) { 
            if(!MetodosCalc.esNumero(String.valueOf(str.charAt(i)))&& !MetodosCalc.esNumero(String.valueOf(str.charAt(i-1)))) 
                res=false; //Si hay operadores juntos, no son congruentes por lo tanto regresa false
            i++;
        }
        return res;
    }
    
    /**
     * <pre>
     * Método revisaExtremos:
     * 
     * Este método recibe una cadena la cual compara la posición de sus elementos para comprobar
     * si estan en un órden congruente al principio y al final de la misma.
     * </pre>
     * 
     * @param str Cadena que contiene una o varias operaciones
     * @return <ul>
     * <li>true: si los extremos de la operación son congruentes porque el final de la operacion es un numero o
     * un parentesis</li>
     * <li>false:si los extremos de la operación no son congruentes porque el final de la operacion es un operador</li>
     * </ul> 
     * 
     */
    private static boolean revisaExtremos(String str) {
        boolean res=true;
        
        if(!MetodosCalc.esNumero(String.valueOf(str.charAt(0))) || !MetodosCalc.esNumero(String.valueOf(str.charAt(str.length()-1))))
            if(str.charAt(0)!='(' || str.charAt(str.length()-1)!=')') {
                res=false;
            }
        return res;
    }
    
    /**
     * <pre>
     * Método detectaErrores:
     * 
     * Este método une los métodos revisaParentesis, revisaOperadores y revisaExtremos 
     * para verificar que no se encuentren errores en una cadena y pueda ser usada para la calculadora.
     * </pre>
     * 
     * @see revisaParentesis
     * @see revisaOperadores
     * @see revisaExtremos 
     * @param str Cadena que contiene una o varias operaciones.
     * @return <ul>
     * <li>true: La cadena String esta ordenada.</li>
     * <li>false: La cadena String no tiene la congruencia necesaria para resolver una operación. </li>
     * </ul> 
     
     */
    public static boolean detectaErrores(String str) {
        boolean res=true;
        
        if(str.length()==0 || !revisaParentesis(str) || !revisaOperadores(str) || !revisaExtremos(str))
            res=false;
        return res;
    }
    
}

