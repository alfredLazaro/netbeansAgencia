/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosAgen;

import java.util.ArrayList;
import java.util.HashMap;
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
public class AgenciaTest {
    
    public AgenciaTest() {
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

    //se prueba verificar registrarcliente

    @Test 
    public void registrarClient1(){
        HashMap<String,ArrayList<PaqueteTuristico>> lugsTur=new HashMap<>();
        HashMap<Integer,Cliente> clientes=new HashMap<>();
        ArrayList<Pasaje> pasajes=new ArrayList<>();
        String nombEmpresa="la empresa maravilla";
        Agencia agencia=new Agencia(null,pasajes,nombEmpresa,lugsTur,clientes);
        agencia.registrarCliente("ronaldo",3,"verano","negocios");
        assertEquals(clientes.size(),1);
    }

    @Test
    public void registrarCliente2(){
        Agencia agencia=new Agencia();
        agencia.registrarCliente("Sara", 5,"otoño", "aventura");
        HashMap<Integer,Cliente> client=agencia.getClientes();
        ArrayList<Integer> clav=new ArrayList<>();
        for(Integer in:client.keySet()){
            clav.add(in);
        }
        int prim=clav.get(0);
        Cliente clie=client.get(prim);

        assertEquals("Sara",clie.getNombreCliente());
    }

    //registro paquetes de distintas formas
    @Test
    public void reservarPaquete1(){
        Agencia agencia=new Agencia();
        agencia.registrarCliente("ronaldo",3,"verano","negocios");
        HashMap<Integer,Cliente> client=agencia.getClientes();
        ArrayList<Integer> clav= new ArrayList<>();
        for(Integer in:client.keySet()){
            clav.add(in);
        }
        int prim=clav.get(0);
        Transporte t=new Transporte(32,"lago titicaca","moto acuatica");
        Hotel h=new Hotel(24,"Oruro","el Dorado");
        Restaurante r=new Restaurante("Oruro","Aqui me quedo");
        agencia.agregarPaquete("Oruro",t,h, r,13);
        ArrayList<PaqueteTuristico> paquet=agencia.getLugaresTuristicos().get("Oruro");
        PaqueteTuristico paq=paquet.get(0);
        int nroid=paq.getNroIde();
        agencia.reservarPaquetes("ronaldo", prim, 2, nroid, "Oruro");
        Cliente cliente=client.get(prim);
        Reserva reserva=cliente.getHistorial().getReservas().get(0); 
        assertNotNull(reserva);
    }

    @Test
    public void agregarPaquetePerson(){
        Agencia agencia1 = new Agencia(); 
        agencia1.registrarCliente("Armando",6,"Verano","Vacaciones");
        agencia1.registrarCliente("Orlando",3,"Invierno","Negocios");
        Hotel paraiso = new Hotel (30,"Oruro","El Paraiso");
        Transporte rueda = new Transporte (30,"Oruro","bicicleta");
        Restaurante carne = new Restaurante ("Oruro" , "La Carniceria");
        Comida comida1 = new Comida ("Filete a la Parrilla",60);
        Comida comida2 =  new Comida ("Anticuchos", 30);
        Comida comida3 =  new Comida ("MegaBurger", 20);
        carne.agregarPlato(comida1);
        carne.agregarPlato(comida2);
        carne.agregarPlato(comida3);
        int longInicial = agencia1.getLugaresTuristicos().size();
        agencia1.agregarPaquete("Oruro",rueda,paraiso,carne,8);
        int longNueva = agencia1.getLugaresTuristicos().size();
        assertNotEquals (longInicial,longNueva);
    }

    @Test
    public void agregarPaquetes(){
        Agencia agencia = new Agencia();
        Transporte t=new Transporte(32,"lago titicaca","moto acuatica");
        Hotel h=new Hotel(24,"Oruro","el Dorado");
        Restaurante r=new Restaurante("Oruro","Aqui me quedo");
        assertFalse(agencia.getLugaresTuristicos().containsKey("Oruro"));
        agencia.agregarPaquete("Oruro",t,h,r,5);
        assertTrue(agencia.getLugaresTuristicos().containsKey("Oruro"));
    }

    @Test
    public void anularReserva(){
        Agencia agencia=new Agencia();
        agencia.registrarCliente("ronaldo",3,"verano","negocios");
        HashMap<Integer,Cliente> client=agencia.getClientes();
        ArrayList<Integer> clav= new ArrayList<>();
        for(Integer in:client.keySet()){
            clav.add(in);
        }
        int prim=clav.get(0);
        Transporte t=new Transporte(32,"lago titicaca","moto acuatica");
        Hotel h=new Hotel(24,"Oruro","el Dorado");
        Restaurante r=new Restaurante("Oruro","Aqui me quedo");
        agencia.agregarPaquete("Oruro",t,h, r,13);
        ArrayList<PaqueteTuristico> paquet=agencia.getLugaresTuristicos().get("Oruro");
        PaqueteTuristico paq=paquet.get(0);
        int nroid=paq.getNroIde();
        agencia.reservarPaquetes("ronaldo", prim, 2, nroid, "Oruro");
        Cliente cliente=client.get(prim);
        agencia.anularReserva(cliente);
        ArrayList<Reserva> reservas = cliente.getHistorial().getReservas();
        assertTrue(reservas.isEmpty());
    }
}
