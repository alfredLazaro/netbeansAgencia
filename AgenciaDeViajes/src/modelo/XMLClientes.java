/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.ArrayList;
import java.util.List;
import metodosAgen.*;
public class XMLClientes {
    private static final String nomArchivo="clientes";
    public static void main(String[] args) {
        List<Cliente> listaClientes=new ArrayList<>();
        Cliente cliente1=new Cliente("rebeca ",3,"verano","",12345);
        //PaqueteTuristico paquet1=new PaqueteTuristico(transporte, hotel, restaurant, 0);
        //Reserva reserva1=new Reserva(paquete, pasaje, cliente1, fechaReserva);
        
    }
    public static void crearXML(){
    
    }
    
    public static void modificarXML(){
    
    }
    
    public static void eliminarClienteXML(Cliente cliente){
    }
    public static ArrayList<Cliente> listaClientes(){
        ArrayList<Cliente> listClientes=new ArrayList<>();
        return listClientes;
    }
}
