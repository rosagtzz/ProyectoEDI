/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package calculadora;

/**
 * <pre>
 * Clase PilaADT
 * Define los métodos abstractos necesarios para una pila
 * </pre>
 @author María Regina Ramos Nava
 * @author Emiliano Cervantes Diaz Barriga
 */

/**
 * <pre>
 * Interfaz abstracta de Pila, aquí se asignan los métodos esenciales para el correcto funcionamiento de una pila genérica
 * </pre>
 * 
 * @param <T> 
 */
public interface PilaADT <T>{
    /**
     * <pre>
     * Void push
     * 
     * Con este método la pila es capaz de ingresar cualquier dato que se ingrese como parámetro a la pila
     * </pre>
     * 
     * @param dato
     */
    public void push(T dato);
    /**
    * <pre>
    * Método pop
    * 
    * Con este método se elimina de la pila el elemento que se encuentre al tope de la pila, 
    * esto tomando en cuenta que la pila no este vacía.
    * </pre>
    * @return T
    */
    public T pop();
    /**
     *<pre>
     * Método isEmpty
     * 
     * Este método booleano regresa true o false dependeiento de si la pila que se quiere usar esta vacía o no
     * 
     * </pre>
     * @return <ul>
     * <li>true:Esta vacía </li>
     * <li>false:No está vacía</li>
     * </ul>
     */
    public boolean isEmpty();
    /**
     *<pre>
     * Método peek
     * 
     * Con este método somos capaces de saber el tope de la pila
     * </pre>
     * 
     * @return &lt;T&lt;
     */
    public T peek();
    /**
     * <pre>
     * Método tamaño
     * 
     * Este método nos permite conocer el tamaño de la pila 
     * </pre>
     * @return 
     */
    public int tamaño();

}
