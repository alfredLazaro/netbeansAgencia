/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosAgen;

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
public class PaqueteTuristicoTest {
    private Transporte t1;
    private Hotel h1;
    private Restaurante r1;
    private PaqueteTuristico pq1;
    private Comida c1;
    private Comida c2;
    public PaqueteTuristicoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp()
    {
        t1=new Transporte(32,"lago Popo","moto acuatica");
        h1=new Hotel(24,"Oruro","el Dorado");
        r1=new Restaurante("Oruro","Aqui me quedo");
        c1 = new Comida("Pique Macho",30);
        c2 = new Comida("Charque", 25);
        r1.agregarPlato(c1);
        r1.agregarPlato(c2);
        pq1 = new PaqueteTuristico(t1,h1,r1,5);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void existeOfertaDias1(){
        assertTrue(pq1.existeOfertaDias());
    }
    
    @Test
    public void existeOfertaDias2(){
        PaqueteTuristico pq2 = new PaqueteTuristico (t1,h1,r1,2);
        assertFalse(pq2.existeOfertaDias());
    }

    @Test
    public void calcularPrecio(){
        int comparador = 32 + 24 + 30 +25;
        int descuento = (comparador*5)/100;
        int precio = comparador - descuento;
        assertEquals(precio,pq1.calcularPrecio());
    }

    /*@Test
    public void generarId(){
        PaqueteTuristico paqueteMocked = mock(PaqueteTuristico.class);
        when(paqueteMocked.generarId()).thenReturn(10);
        assertEquals(10,paqueteMocked.generarId());
    }*/
}
