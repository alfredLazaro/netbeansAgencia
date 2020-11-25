/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosAgen;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author USUARIO
 */
public class RestauranteTest {
    
    private Restaurante restaurante;
    private Comida c1;
    private Comida c2;
    private Comida c3;
    /**
     * Default constructor for test class RestauranteTest
     */
    public RestauranteTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        restaurante = new Restaurante("America","Pollos Panchita");
        c1 = new Comida("Panchicono",20);
        c2 = new Comida("Pipokid",18);
        c3 = new Comida("Chiquitin",12);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void eliminarPlato1(){
        restaurante.agregarPlato(c1);
        restaurante.agregarPlato(c3);
        restaurante.eliminarPlato(c2);
        assertEquals(2,restaurante.getMenu().size());
    }
    
    @Test
    public void eliminarPlato2(){
        restaurante.agregarPlato(c1);
        restaurante.agregarPlato(c2);
        restaurante.agregarPlato(c3);
        assertEquals(3,restaurante.getMenu().size());
        restaurante.eliminarPlato(c1);
        restaurante.eliminarPlato(c2);
        assertEquals(1,restaurante.getMenu().size());
        restaurante.eliminarPlato(c3);
        assertTrue(restaurante.getMenu().isEmpty());
    }
    
}
