/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

import java.util.ArrayList;

/**
 *<pre>
 * Main Calculadora
 * </pre>>
 * @author María Regina Ramos Nava
 * @author Emiliano Cervantes Diaz Barriga
 * @author Rosa Itzel Gutiérrez Barrera
 * @author Ailyn Ximena Ocampo Vera
 * @author Fernando López Garza
 * 
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        //Cambio infija a posfija
        String[] arr = {"(","3","*","(","6","+","2",")","?","2","-","1",")","*","3"};
        ArrayList<String> resultado = MetodosCalc.cambioPosfija(arr);
        System.out.println(MetodosCalc.calculadora(arr));
        System.out.println(resultado);
        
       
        
    }
    
}
