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
public class HotelTest {
    private Hotel hotel;
    public HotelTest() {
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
    public void existeVacante1(){

        for(int i = 0; i < 30; i++){
            hotel.existenVacantes(true);
        }
        assertFalse(hotel.existenVacantes(true));
    }

    @Test
    public void existeVacante2(){
        assertFalse(hotel.existenVacantes(false));
        for(int i = 0; i < 10; i++){
            hotel.existenVacantes(true);
        }
        assertTrue(hotel.existenVacantes(true));
    }
    
}
