/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package calculadora;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author reginaramos
 */
public class MetodosCalcTest {
    
    public MetodosCalcTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of jerarquia method, of class MetodosCalc.
     */
    @Test
    public void testJerarquia() {
        System.out.println("jerarquia");
        String operador = "";
        int expResult = 0;
        int result = MetodosCalc.jerarquia(operador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esNumero method, of class MetodosCalc.
     */
    @Test
    public void testEsNumero() {
        System.out.println("esNumero");
        String dato = "";
        boolean expResult = false;
        boolean result = MetodosCalc.esNumero(dato);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertirStringArr method, of class MetodosCalc.
     */
    @Test
    public void testConvertirStringArr() {
        System.out.println("convertirStringArr");
        String str = "";
        String[] expResult = null;
        String[] result = MetodosCalc.convertirStringArr(str);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambioPosfija method, of class MetodosCalc.
     */
    @Test
    public void testCambioPosfija() {
        System.out.println("cambioPosfija");
        String[] arr = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = MetodosCalc.cambioPosfija(arr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of realizarOperaciones method, of class MetodosCalc.
     */
    @Test
    public void testRealizarOperaciones() {
        System.out.println("realizarOperaciones");
        String num1 = "";
        String num2 = "";
        String operador = "";
        double expResult = 0.0;
        double result = MetodosCalc.realizarOperaciones(num1, num2, operador);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resuelve method, of class MetodosCalc.
     */
    @Test
    public void testResuelve() {
        System.out.println("resuelve");
        ArrayList<String> arr = null;
        double expResult = 0.0;
        double result = MetodosCalc.resuelve(arr);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculadora method, of class MetodosCalc.
     */
    @Test
    public void testCalculadora() {
        System.out.println("calculadora");
        String[] arr = null;
        double expResult = 0.0;
        double result = MetodosCalc.calculadora(arr);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
