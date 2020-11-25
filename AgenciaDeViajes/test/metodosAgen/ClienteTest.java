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
import java.util.Date;
/**
 *
 * @author USUARIO
 */
public class ClienteTest {
    private Cliente cliente1;
    private Cliente cliente2;
    private Transporte t1;
    private Hotel h1;
    private Restaurante r1;
    private Transporte t2;
    private Hotel h2;
    private Restaurante r2;
    private PaqueteTuristico pq1;
    private PaqueteTuristico pq2;
    private Pasaje pj1;
    private Pasaje pj2;
    private Reserva rv1;
    private Reserva rv2;
    public ClienteTest() {
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
        cliente1 = new Cliente("Sara", 7,"otoño", "aventura",0);
        cliente2 = new Cliente("Alan", 3,"verano", "negocio",0);
        t1=new Transporte(32,"lago popo","moto acuatica");
        h1=new Hotel(24,"Oruro","el Dorado");
        r1=new Restaurante("Oruro","Aqui me quedo");
        t2=new Transporte(20,"Laguna Alalay","moto acuatica");
        h2=new Hotel(30,"La Paz","Cosmos");
        r2=new Restaurante("Santa Cruz","Pollos Copacabana");
        pq1 = new PaqueteTuristico(t1,h1,r1,5);
        pq2 = new PaqueteTuristico(t2,h2,r2,5);
        pj1 = new Pasaje("Cochabamba", "Oruro", new Date(),new Date(),"Sara","moto acuatica","la empresa maravilla",50);
        pj2 = new Pasaje("Cochabamba", "La Paz", new Date(),new Date(),"Sara","moto acuatica","la empresa maravilla",60);
        rv1 = new Reserva(pq1,pj1,cliente1,new Date());
        rv1.setEstadoReserva("usado");
        rv2 = new Reserva(pq2,pj2,cliente1,new Date());
        rv2.setEstadoReserva("usado");
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
    public void clienteEsFrecuente1(){
        for(int i = 0; i < 12; i++){
            cliente1.getHistorial().actualizarHistorial(rv1);
        }
        for(int i = 0; i < 12; i++){
            cliente1.getHistorial().actualizarHistorial(rv2);
        }
        assertTrue(cliente1.esFrecuente());
    }
    
    @Test 
    public void clienteEsFrecuente2(){
        for(int i = 0; i < 5; i++){
            cliente2.getHistorial().actualizarHistorial(rv1);
        }
        for(int i = 0; i < 5; i++){
            cliente2.getHistorial().actualizarHistorial(rv2);
        }
        assertFalse(cliente2.esFrecuente());
    }
    
    @Test 
    public void exiteOfertaPasajeros1(){
        assertTrue(cliente1.exiteOfertaPasajeros());
    }
    
    @Test 
    public void exiteOfertaPasajeros2(){
        assertFalse(cliente2.exiteOfertaPasajeros());
    }
}
