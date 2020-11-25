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
public class HistorialTest {
    private Historial historial;
    public HistorialTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void actualizarHistorial(){
        Cliente cliente = new Cliente("Sara", 7,"otoño", "aventura",0);
        Transporte t1=new Transporte(32,"lago popo","moto acuatica");
        Hotel h1=new Hotel(24,"Oruro","el Dorado");
        Restaurante r1=new Restaurante("Oruro","Aqui me quedo");
        PaqueteTuristico pq1 = new PaqueteTuristico(t1,h1,r1,5);
        Pasaje pj1 = new Pasaje("Cochabamba", "Oruro", new Date(),new Date(),"Sara","moto acuatica","la empresa maravilla",50);
        Reserva rv1 = new Reserva(pq1,pj1,cliente,new Date());
        //assertTrue(historial.getReservas().isEmpty());
        historial.actualizarHistorial(rv1);
        assertFalse(historial.getReservas().isEmpty());
    }
}
