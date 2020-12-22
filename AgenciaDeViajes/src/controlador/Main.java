/*
 * 
 */
package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import metodosAgen.*;
import modelo.*;
/**
 * @author Fred
 */
public class Main {
    private Agencia agen;
    private HashMap<Integer,Cliente> clientes;
    private HashMap<String,ArrayList<PaqueteTuristico>> lugaresPaquet;
    private Administrador admin;
    private String nombreEmp;
    public static void main(String[] args) {
        
    }

    public Main() {
        nombreEmp="Travel Pandemic";
        iniciarClientes();
        iniciarLugares();
        boolean e=existAdm("agente67", "67531896");
        
        agen=new Agencia(null, null, nombreEmp, lugaresPaquet, clientes);
        //prueba de registro cliente
        //desde aqui generar vista
        
        //vista=vista.setLabelTitulo;
        //vista.setPaquetes();
    }
    //lugar clientes
    private void iniciarClientes(){
        clientes=XMLClientes.hashClientes();
    }
    public void registrarClient(String nombrClien,int cantPasaj,String tempPrefer,String tipoViaj){
        Cliente cient=new Cliente(nombrClien, cantPasaj, tempPrefer, tipoViaj, cantPasaj);
        agen.registrarCliente(nombrClien,cantPasaj, tempPrefer,tipoViaj);
        XMLClientes.insertCliente(cient);
    }
    private void iniciarLugares(){
        lugaresPaquet=XMLDepartamentos.HashPaquetesLugrs();
    }
    //se busca el administrador en la base
    private boolean existAdm(String nombre,String contra){
        boolean existe=false;
        Administrador adm=XMLAdministradores.buscarAdmin(nombre, contra);
        if(adm!=null){
            System.out.println("se encontro el admin");
            existe=true;
        }else{
            System.out.println("metio mal algo no existe el admin");
        }
        return existe;
    }
    
    //el estado puede ser activo, cancelado, usado(se cambia cuando se agrega nueva reserva)
    public void anularReserva(int nroId,String estadoNuevo){
        Cliente cliente=agen.getClientes().get(nroId);
        Cliente clinXML=XMLClientes.buscarClient(nroId);
        if(cliente!=null && clinXML!=null){
            agen.anularReserva(cliente);
            XMLClientes.cambiEstadoReserv(nroId, estadoNuevo);
        }else{}
    }
    
    //se agrega el paquete a modelo y a agencia
    public void agregPac(String lugarDest,String nombTransport,String nombRest,String nombHotel,int cantDias){
        Hotel hot=agen.escogerHotel(nombHotel, lugaresPaquet.get(lugarDest));
        Transporte t=agen.escogerTransporte(nombTransport,lugaresPaquet.get(lugarDest));
        Restaurante restau=agen.escogeRestaurant(nombRest, lugaresPaquet.get(nombRest));
        PaqueteTuristico paq=new PaqueteTuristico(t, hot, restau, cantDias);
        int nroIde=paq.getNroIde();
        //se agraga a agencia
        agen.agregarPaquete(lugarDest, nombTransport, nombRest, nombHotel,cantDias);
        //se agrega a XML paquete
        XMLDepartamentos.insertPaqLugar(lugarDest, paq);
        //aqui faltaria agragarlo a VISTA
    }
    //antes de reservar Pasaje o Paquete
    public void crearNuevReserv(int nroIdClient){
        Reserva reserv=new Reserva(null, null, agen.getClientes().get(nroIdClient), new Date());
        //tambien hay que crearla para la agen
        Cliente cl=agen.getClientes().get(nroIdClient);
        cl.getHistorial().actualizarHistorial(reserv);
        XMLHistoriales.aniadirReserv(reserv, nroIdClient);
    }
    
    public void registrarPaquet(int nroIdClient,String nombCl,int catPasaj,int nroPaquete,String lugarT){
        //en aqui se añadira el paquete
        
        Cliente c1=agen.verificarExistencia(nombCl, nroIdClient);
        
        if(c1!=null){
            Reserva reserv=c1.getHistorial().getUltReserv();//new Reserva(null, null, agen.getClientes().get(nroIdClient), new Date());
            agen.reservarPaquetes(nombCl, nroIdClient, catPasaj, nroPaquete, lugarT);
            PaqueteTuristico paquete=agen.getLugaresTuristicos().get(lugarT).get(nroPaquete);
            //se extrae el paquete (suponemos que existe)
            if(paquete!=null){
                //si la ultima reserva tiene estado!= "activo" se crea reserva nueva(deberia)
                reserv.setPaquete(paquete);
                XMLClientes.insertPaquete(reserv, nroIdClient);
            }else{
                System.out.println("el paquete no existe");
            }
        }else{
            System.out.println("algo no se ingreso de la manera correcta");
        }
        
    }
    // en lo de tipo transporte nose como lo pensamos 
    public void registrarPasaje(int nroIdClient,String nombCl,String origen,String destino,String fechaIda,String fechaVuelta,String tipoTransporte,String nombrEmpresa, int precio) throws ParseException{
        //en aqui se añadira el pasaje
        Date fechaId,fechaVuelt;
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
        fechaId=formatoFecha.parse(fechaIda);
        fechaVuelt=formatoFecha.parse(fechaVuelta);
        Pasaje p;
        Cliente c1=agen.verificarExistencia(nombCl, nroIdClient);
        if(c1!=null){
            Reserva reserv=c1.getHistorial().getUltReserv();
            p=new Pasaje(origen, destino, fechaId, fechaVuelt, nombrEmpresa, tipoTransporte, nombrEmpresa, precio);
            agen.reservaPasaje(origen, destino, nroIdClient, nombCl, fechaId, fechaVuelt, tipoTransporte, nombrEmpresa, precio);
            //si la ultima reserva tiene estado!= "activo" se crea reserva nueva(deberia)
            reserv.setPasaje(p);
            XMLClientes.insertPasaje(reserv, nroIdClient);
        }else{}
    }
    
    /*
    private Transporte buscarTransporte(){
        Transporte t=null;
        
        return t;
    }
    */
    
}
