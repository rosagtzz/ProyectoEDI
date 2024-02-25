/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import java.util.ArrayList;
import java.util.Stack;

/**
 * <pre>
 * Clase MetodosCalc
 * 
 * Metodos para el correcto funcionamiento de la calculadora 
 * </pre>
 * @author María Regina Ramos Nava
 * @author Emiliano Cervantes Diaz Barriga
 * @author Rosa Itzel Gutiérrez Barrera
 * @author Aylin Ximena Ocampo Vera
 * @author Ferando López Garza
 * @version 1.4
 * 
 */


public class MetodosCalc{
    
    
    /**
     * <pre>
     * Método jerarquia 
     * 
     * Este es un método estático que otorga jerarquía operacional a los símmbolos que usaremos 
     * en la calculadora, esta jerarquía depende de prioridades del 0 al 3, siendo el 3 el valor prioritario.
     * </pre>
     * @param operador
     * @return int 
    */
    public static int jerarquia(String operador){
        int res;
                
        switch(operador.charAt(0)){
           
            case '+':
                res=1;
                break;
            case '-':
                res=1;
                break;
            case '*':
                res=2;
                break;
            case '/':
                res=2;
                break;
            case '?'://Se usa el signo de interrogacion para la potencia, se conecta con el boton de ^ con que escribe
                res=3;
                break;
            default:
                res=0;
        }
        
        return res;
    }
    
    /**
     * <pre>
     * Método esNumero
     * 
     * Es un método estático que devuelve una respuesta booleana que funciona con una excepcion 
     * al intentar converitr un string a un Double, por lo que si no logra convertir el string a Double 
     * arrojara una excepción de NumberFormatException 
     * 
     * 
     * </pre>
     * @param dato
     * @return <ul>
     * <li>true:Es un numero
     * <li>false:Es un operador
     * </ul>
     */
    public static boolean esNumero(String dato){
        boolean flag=false;
        
        try{
            if(dato instanceof String){
               //Intentar convertir la cadena a un double
               Double.parseDouble((String)dato);
               flag= true;
            }
            
        }catch(NumberFormatException ex){
            //Si ocurre una excepcion al intentar castear a int es porque no es un int
            return false;
        }
        return flag;
    }
    /**
     *
     * <pre>
     * Método convertirStringArr
     * 
     * Es un método estático el cual recibe una cadena String, en el método 
     * se evaluan todos los elementos del arreglo como tipo char incluidos los puntos decimales, mediante este se
     * evalua si es numero o no por medio de un ciclo que los distingue entre operadores, números o números decimales 
     * y los añade a un nuevo arreglo uno por uno.
     * </pre>
     * @see esNumero
     * @param str
     * @return String[]
     */
    
     public static String[] convertirStringArr(String str) {
        String[] arr= new String[0];
        ArrayList<String> lista = new ArrayList<String>();
        StringBuilder cad= new StringBuilder();
        int i, j;
        
        i=0;
        j=0;
        while(j<str.length()) {
            while(j<str.length() && (esNumero(String.valueOf(str.charAt(j))) || str.charAt(j)=='.')) {
                cad.append(str.charAt(j));
                j++; 
            }
            lista.add(cad.toString());
            cad.setLength(0);
            i++;
            if(j<str.length()) {
                lista.add(String.valueOf(str.charAt(j)));
                i++;  
            }
            j++;
        }
        arr= new String[lista.size()];
        for(int p=0; p<lista.size(); p++) {
            arr[p]=lista.get(p);
        }
        return arr;
    }
    
    /**
     *
     * <pre>
     *  Metodo cambioPosfija
     * 
     * Este metodo recibe un arreglo de String que es Infija y lo transforma a Posfija con tres condiciones esenciales,
     * ewte método convierte los elementos de un arreglo en un ArrayList para poder ordenarlos según estas tres condiciones junto
     * con el método jerarquia; este métod inserta y elimina operadores de la pila hasta poder llegar a una organización posfija
     * de una operación en orden tradicional.
     * 
     * 
     * </pre>
     * 
     * @param arr
     * @see esNumero
     * @see jerarquia
     * 
     * @return ArrayList&lt;String&gt;
     */
    public static ArrayList<String> cambioPosfija(String[] arr){
        PilaA pila = new PilaA();
        ArrayList<String> postfija = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++){
            if(esNumero(arr[i])){
                postfija.add(arr[i]);
            }
            else if(arr[i].equals("(")){
                pila.push(arr[i]);
            }
            else if(arr[i].equals(")")){
                // Desapilar elementos hasta encontrar el paréntesis izquierdo
                while (!pila.isEmpty() && !pila.peek().equals("(")){
                    postfija.add(pila.pop().toString());
                }
                // Si la pila no está vacía, retirar el paréntesis izquierdo de la pila
                if (!pila.isEmpty() && pila.peek().equals("(")){
                    pila.pop();
                }
            }
            else {
                // Manejar operadores y paréntesis izquierdos
                while (!pila.isEmpty() && jerarquia(arr[i]) <= jerarquia(pila.peek().toString())){
                    postfija.add(pila.pop().toString());
                }
                pila.push(arr[i]);
            }
        }
        
        // Desapilar el resto de elementos de la pila
        while (!pila.isEmpty()){
            postfija.add(pila.pop().toString());
        }
        
        return postfija;
    }
    /**
     * 
     * <pre>
     * Método realizarOperaciones
     * 
     * Método estático que recibe 2 números y un símbolo este método identifica el operador que se ingrese 
     * y resuelve los dos números anteriores tomando en consideración los operadores de suma, resta, multiplicación, división y exponentes.
     * condiciones que 
     *  
     * </pre>
     * 
     * @param num1 Es el primer operando antes del signo
     * @param num2 Es el 2 operando para resolver
     * @param operador
     * 
     * @return double
     */
    public static double realizarOperaciones(String num1, String num2, String operador){
        double numero1=Double.parseDouble(num1);
        double numero2=Double.parseDouble(num2);
        
        switch (operador) {
            case "+":
                return numero1 + numero2;
            case "-":
                return numero1 - numero2;
            case "*":
                return numero1 * numero2;
            case "/":
                if (numero2 != 0) {
                    return numero1 / numero2;
                } else {
                    throw new ArithmeticException("Error: División por cero");
                }
                case "?":
                return  Math.pow(numero1, numero2);
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }
        
        
    }
    
    /**
     * 
     * <pre>
     * Método resuelve
     * 
     * Método estático que da orden a las operaciones en posfija, este método usa tokens y pila
     * De esta manera guarda los signos como tokens y los números en la pila según el orden en el que esten distribuidos en el arreglo 
     * En cuanto el método reconoce un signo como token se poppean los últimos dos números de la pila y se resuelven con el signo del token
     * usando el método estatico realizarOperacione y el resultado se regresa a la pila, así sucesivamente hasta que en la pila se encuentre 
     * un solo elemento el cual sería el resultado final.
     * 
     * 
     * </pre>
     * @param arr
     * @return double
     * @see esNumero
     * @see realizarOperaciones
     */
    public static double resuelve(ArrayList<String> arr) {
        PilaA<Double> pila = new PilaA<>();

        for (String token : arr) {
            if (esNumero(token)) {
                // Si el token es un número, lo agregamos a la pila como un double
                pila.push(Double.parseDouble(token));
             } else {
                // Si el token es un operador, sacamos los dos últimos números de la pila
                // y aplicamos la operación correspondiente, luego colocamos el resultado en la pila
                double numero2 = pila.pop();
                double numero1 = pila.pop();
                double resultado = realizarOperaciones(String.valueOf(numero1), String.valueOf(numero2), token);
                pila.push(resultado);
            }
    }

        // Al final, el stack debería contener solo un elemento, que es el resultado final
        if (pila.tamaño()!= 1) {
            throw new IllegalArgumentException("Expresión inválida");
        }
        return pila.pop();
    }
    /**
     *
     * <pre>
     *  Método calculadora
     * 
     * El metodo calculadora llama a los métodos cambioPosfija y resuelve pues el correcto funcionamiento de la calculadora depende de ellos, 
     * estos métodos le dan la estructura correcta a un String para evaluarse y la posibilidad de resolverse; la utilidad del método estático calculadora
     * es el poder unir estos dos métodos en uno para llegar a un resultado.
     * 
     * </pre>
     * @param arr
     * @return double
     * @see cambioPosfija
     * @see resuelve
     */
    public static double calculadora(String[] arr){
        ArrayList<String> arrPostfija;
        double respuesta;
        arrPostfija=cambioPosfija(arr);
        
        return respuesta=resuelve(arrPostfija);
    }
   
}



    

