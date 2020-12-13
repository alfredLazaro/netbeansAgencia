/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosAgen;

import java.util.ArrayList;
import java.util.Date;
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
public class OfertaTest {
    private Cliente cliente;
    private Transporte t;
    private Hotel h;
    private Restaurante r;
    private PaqueteTuristico pq;
    private Pasaje pj; 
    private Reserva rv;
    private Oferta of;
    public OfertaTest() {
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
        cliente = new Cliente("Sara", 7,"otoño", "aventura",0);
        t=new Transporte(32,"lago popo","moto acuatica");
        h=new Hotel(24,"Oruro","el Dorado");
        r=new Restaurante("Oruro","Aqui me quedo"); 
        pq = new PaqueteTuristico(t,h,r,5);
        pj = new Pasaje("Cochabamba", "Oruro", new Date(),new Date(),"Sara","moto acuatica","la empresa maravilla",50);    
        rv = new Reserva(pq,pj,cliente,new Date());
        //of = new Oferta(new ArrayList<Date>());
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

    /*@Test 
    public void generarOfertaCantPasajeros(){
        int precioPaquete = 32 + 24;
        precioPaquete = precioPaquete - ((precioPaquete*3)/100);
        int precioPasaje = 50 - ((50*3)/100);
        of.generarOfertaCantPasajeros(rv);
        assertEquals(precioPasaje,pj.getPrecioTotal());
        assertEquals(precioPaquete,pq.getPrecio());
    }*/
    
    @Test 
    public void generarOfertaCantPasajeros(){
        int precioPaquete = pq.getPrecio();
        int precioPasaje = pj.getPrecioTotal();
        precioPasaje = precioPasaje - ((precioPasaje*3)/100);
        precioPaquete = precioPaquete - ((precioPaquete*3)/100);
        of.generarOfertaCantPasajeros(rv);
        assertEquals(precioPasaje,pj.getPrecioTotal());
        assertEquals(precioPaquete,pq.getPrecio());
    }
   
    @Test 
    public void generarOfertaClienteFrecuente(){
        int precioPaquete = pq.getPrecio();
        int precioPasaje = pj.getPrecioTotal();
        precioPasaje = precioPasaje - ((precioPasaje*5)/100);
        precioPaquete = precioPaquete - ((precioPaquete*5)/100);
        of.generarOfertaClienteFrecuente(rv);
        assertEquals(precioPasaje,pj.getPrecioTotal());
        assertEquals(precioPaquete,pq.getPrecio());
    }
    
    @Test 
    public void generarOfertaCantDias(){
        int precioPaquete = pq.getPrecio();
        int precioPasaje = pj.getPrecioTotal();
        precioPasaje = precioPasaje - ((precioPasaje*3)/100);
        precioPaquete = precioPaquete - ((precioPaquete*3)/100);
        of.generarOfertaCantDias(rv);
        assertEquals(precioPasaje,pj.getPrecioTotal());
        assertEquals(precioPaquete,pq.getPrecio());
    }
}
