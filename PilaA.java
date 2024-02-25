/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

/**
 * <pre>
 * Clase Pila A
 * Da funcionalidad a todos los métodos necesarios para una pila genérica
 * </pre>
  * @author María Regina Ramos Nava
  * @author Emiliano Cervantes Diaz Barriga
  * @author Rosa Itzel Gutiérrez Barrera
  * @author Aylin Ximena Ocampo Vera
  * @author Fernando López Garza
 */
public class PilaA <T> implements PilaADT <T> {
    private T[] pila;
    private int tope;
    private final int MAX=100;
    private int size;
    
    public PilaA(){
        pila= (T[]) new Object[MAX];
        tope=-1; //Pila vacía
       
    }
    
    public PilaA(int max){
        pila=(T[]) new Object[max];
        tope=-1;
    }

    /**
     * <pre>
     * Void push
     * 
     * Con este método la pila es capaz de ingresar cualquier dato que se ingrese como parámetro a la pila
     * </pre>
     * @param dato 
     * 
     */
    @Override
    public void push(T dato) {
        if(tope+1==pila.length) //Pila llena
            expande();
        tope++;
        pila[tope]=dato;
        size++;
 
    }
    
    /**
     * 
     * <pre>
     * Void expande
     * 
     * Con este método la capacidad de la pila pila se expande al doble
     * </pre>
     * 
     * 
     */
    private void expande(){
        T[] masGrande = (T[]) new Object[pila.length*2];
        
        for(int i=0; i<=tope; i++) // i<pila.length
            masGrande[i]=pila[i];
        pila=masGrande;
    }

    /**
    * <pre>
    * Método pop
    * 
    * Con este método se elimina de la pila el elemento que se encuentre al tope de la pila, 
    * esto tomando en cuenta que la pila no este vacía.
    * </pre>
    * @return T
     */
    @Override
    public T pop() {
        if(this.isEmpty())
            throw new ExcepcionColeccionVacia("La pila esta vacia"); //Lanza excepcion
        T eliminado;
        eliminado= pila[tope];
        pila[tope]=null;
        tope--;
        size--;
        return eliminado;
    }
    
    /**
     *<pre>
     * Método isEmpty
     * 
     * Este método booleano regresa true o false dependiendo de si la pila que se quiere usar esta vacía o no.
     * 
     * </pre>
     * @return <ul>
     *  <li>true: La pila está vacía</li>
     *  <li>false: La pila está vacía</li>
     * </ul>
     */ 
    
    @Override
    public boolean isEmpty() {
        return tope==-1;
    }

    /**
     *<pre>
     * Método peek
     * 
     * Con este método somos capaces de saber el tope de la pila
     * </pre>
     *  @return int
     * @return &lt;T&lt;
     */
    @Override
    public T peek() {
        if(this.isEmpty())
            throw new ExcepcionColeccionVacia("La pila esta vacia"); //Lanza excepcion
        return pila[tope];
    }
    
    
    public String toString(){
        StringBuilder sB= new StringBuilder("\n Pila de 0 a tope \n");
        
        for(int i=0;i<=tope;i++){
            sB.append(pila[i]).append(" ");
        }
        return sB.toString();
    }

    /**
     * <pre>
     * Método tamaño
     * 
     * Este método nos permite conocer el tamaño de la pila 
     * </pre>
     * @return int
     * 
     */
    @Override
    public int tamaño() {
        return size;
    }
    
    
}
