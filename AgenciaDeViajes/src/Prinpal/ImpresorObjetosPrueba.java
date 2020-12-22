/*
 *
 */
package Prinpal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import modelo.*;
import metodosAgen.*;
/**
 * @author Fred
 */
public class ImpresorObjetosPrueba {
    /*
    private ArrayList<Cliente> listClientes;
    private ArrayList<Administrador> listAd;
    private ArrayList<PaqueteTuristico> lisPaquetes;
    private Comida      comid2,comid1;
    private PaqueteTuristico paquete2;
    private Hotel hotCbba2;
    private Restaurante restCbba2;
    */
    private Agencia agen;
    private HashMap<Integer,Cliente> clientes;
    private HashMap<String,ArrayList<PaqueteTuristico>> lugaresPaquet;
    private Administrador admin;
    private String nombreEmp;
    public static void main(String[] args) {
        ImpresorObjetosPrueba imp=new ImpresorObjetosPrueba();
    }
    
    public ImpresorObjetosPrueba(){
        
        ///////////////////////////////////////////////////////
        //Administrador
        /*
        Administrador admin=admin("agente45","67531896");
        System.out.println("contraseña " +admin.getContrasenia());
        */
        
        
        //insertAd("alan", "62615493");
        
        /*
        listAd=listAd();
        for(Administrador a:listAd){
            String nomC=a.getNombreCuenta();
            String cont=a.getContrasenia();
            System.out.println("nombre "+ nomC);
            System.out.println("contra "+ cont);
        }
        */
        
        
        //elimAdministr("Agente69", "67531896");
        
        ////////////////////////////////////////////////////////////////////
        //cliente
        /*
        Cliente cl=buscarC(12345);
        System.out.println("nombre "+ cl.getNombreCliente());
        elimHist(12341);
        */
        /*
        //no se crearan clientes repetidos
        Cliente c1=new Cliente("maclovin", 3,"verano", "aventura", 12341);
        insertClient(c1);
        */
        /*
        listClientes=obtenerClientes();
        for(Cliente c:listClientes){
            String n=c.getNombreCliente();
            int nroP=c.getCantidadPasajeros();
        System.out.println("nombre "+n);
            System.out.println("nroPasajeros"+ nroP);
        }
        */
        //eliminarClient("maclovin",12341);
        //eliminarClient("Alan", 54231); //ahora se elimina el historial a la vez
        
        ////////////////////////////////////////////////////////////////
        //paquetes
        /*
        lisPaquetes=listPaq();
        for(PaqueteTuristico p:lisPaquetes){
            String nomb=p.getTransporte().getTipoTransporte();
            System.out.println("transporte "+nomb);
        }
        */
        
        /*
        hotCbba2 = new Hotel(450,"Cochabamba","Huper Hotel Boutique");
        restCbba2 = new Restaurante("Cochabamba","Jacaranda");
        comid1 = new Comida("Pique Macho",100);
        comid2 = new Comida("Charque",80);
        restCbba2.agregarPlato(comid1);
        restCbba2.agregarPlato(comid2);
        paquete2 = new PaqueteTuristico(null,hotCbba2,restCbba2,2);
        */
        /////////////////////////////////////////////////////////////////////lugar(usa XMLpaquete)
        //insertPacLugar("Villa Tunari", paquete2);
        /*
        PaqueteTuristico pa=buscarPac(391); // error en qui nose por que
        System.out.println("cant dias "+pa.getCantDias());
        */
        //////////////////////////////////////////////////////////////////////
        //historial
        /*
        Historial hist=buscarHistorial(12345);
        Date fec=hist.getFechaModificacion();
        System.out.println("fecha "+ fec);
        */
        //aniaHistorial(123456);
        /*
        Reserva r=new Reserva(null, null, null,new Date());
        //insertReser(r, 12341);
        */
        /*
        Pasaje pas=new Pasaje("Oruro", "Beni", new Date(), new Date(30,9,2022), "maclovin", "avion","vive libre", 20);
        r.setPasaje(pas);
        //insertPas(r, 12341);
        */
        /*
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
        r.setPaquete(paquete2);
        insertPaqRes(r, 12341);
        */
        
        ///////////////////////////////////////////////////////////////////////////////
        
        
        nombreEmp="Travel Pandemic";
        iniciarClientes();
        iniciarLugares();
        //System.out.println(" paquetes "+ lugaresPaquet.get("El Cristo")); //funciona
        
        boolean e=existAdm("agente45", "67531896");
        
        agen=new Agencia(null, null, nombreEmp, lugaresPaquet, clientes);
        System.out.println("el tamaño de paquetes por lugar es"+ lugaresPaquet.get("Loma Suares").size());
        //por alguna razon se lleno de 80 paquetes por lugar turistico
        /////////////////
        
        //crearNuevReserv(12341);
        //registrarPaquet(12341, "maclovin", 2,391 ,"El Cristo");
        //registrarPasaje(12341, "maclovin", "Cochabamba", "Oruro", "23/12/2030","25/11/2050", "avion", "el dorado", 123);
        
    }
    
    ///////////////////////////
    //zona paquete
    public PaqueteTuristico buscarPac(int cod){
        PaqueteTuristico res=null;
        res=XMLPaquetes.buscarPaquet(cod);
        if(res==null){
            System.out.println("no saco el paquete");
        }
        return res;
    }
    
    public ArrayList<PaqueteTuristico> listPaq(){
        ArrayList<PaqueteTuristico> paqs=new ArrayList<>();
        paqs=XMLPaquetes.paquetes();
        return paqs;
    }
    ///////////////////////////////////////////
    //lugares
    public void insertPacLugar(String lug,PaqueteTuristico pac){
        XMLDepartamentos.insertPaqLugar(lug, pac);
    }
    ////////////////////////////////
    //zona reserva
    public Reserva reserv(){
        Reserva res=null;
        return res;
    }
    
    ///////////////////////////////////
    //zona Administrador
    public Administrador buscAdmin(String nomClav,String contra){
        Administrador ad=null;
        ad=XMLAdministradores.buscarAdmin(nomClav,contra);
        if(ad!=null){
            System.out.println("se encontro");
        }else{
            System.out.println("no se encontro");
        }
        return ad;
    }
    public void elimAdministr(String nobClav,String contrase){
        XMLAdministradores.eliminarAdmin(nobClav, contrase);
    }
    
    public ArrayList<Administrador> listAd(){
        ArrayList<Administrador> listA=new ArrayList<>();
        listA=XMLAdministradores.listaAdmins();
        if(!listA.isEmpty()){
            System.out.println("estamos bien ");
        }else{
            System.out.println("algo anda mas");
        }
        return listA;
    }
    
    public void insertAd(String nomb,String contra){
        
        XMLAdministradores.insertarAdmin(nomb, contra);
    }
    ////////////////////////////////////////
    //zona historial
    public void insertHistorial(int cod){
        XMLHistoriales.aniadirHisto(cod);
    }
    public void elimHist(int cod){
        XMLHistoriales.eliminarHistorial(cod);
    }
    
    public Historial buscarHistorial(int nroId){
        Historial h=null;
        h=XMLHistoriales.buscarHistorial(nroId);
        if(h!=null){
            System.out.println("estamos super");
        }else{
            System.out.println("algo anda mal");
        }
        return h;
    }
    public void insertReser(Reserva r,int codClient){
        XMLHistoriales.aniadirReserv(r, codClient);
    }
    
    public void insertPas(Reserva r,int codC){
        XMLHistoriales.insertPasaje(r, codC);
    }
    
    public void insertPaqRes(Reserva r,int codClient){
        XMLHistoriales.insertPaquet(r, codClient);
    }
    /////////////////////////
    //zona Cliente
    public void insertClient(Cliente c){
        XMLClientes.insertCliente(c);
        XMLClientes.buscarClient(123423);
    }
    
    
    
    //elim Cliente
    public void eliminarClient(String nom, int codig){
        XMLClientes.eliminarClienteXML(nom, codig);
    }
    
    public Cliente buscarC(int nroIdentCl){
        Cliente c=null;
        c=XMLClientes.buscarClient(nroIdentCl);
        if(c!=null){
            System.out.println("se encontro estamos super");
        }else{
            System.out.println("algo anda mal");
        }
        return c;
    }
    
    public ArrayList<Cliente> listaClientes(){
        ArrayList<Cliente> listClientes=new ArrayList<>();
        listClientes=XMLClientes.listaClientes();
        if(!listClientes.isEmpty()){
            System.out.println("estupendo exelente");
        }else{
            System.out.println("no lo devolvio");
        }
        return listClientes;
    }
    ////////////////////////////
    
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
        
        Cliente cl=agen.getClientes().get(nroIdClient);
        System.out.println("cliente "+cl);
        
        XMLHistoriales.aniadirReserv(reserv, nroIdClient);
        cl.getHistorial().actualizarHistorial(reserv);
    }
    
    public void registrarPaquet(int nroIdClient,String nombCl,int catPasaj,int nroPaquete,String lugarT){
        //en aqui se añadira el paquete
        
        Cliente c1=agen.verificarExistencia(nombCl, nroIdClient);
        
        if(c1!=null){
            Reserva reserv=c1.getHistorial().getUltReserv();//new Reserva(null, null, agen.getClientes().get(nroIdClient), new Date());
            agen.reservarPaquetes(nombCl, nroIdClient, catPasaj, nroPaquete, lugarT);
            PaqueteTuristico paquete=agen.buscarPaquete(lugarT, nroPaquete);
            //se extrae el paquete (suponemos que existe)
            if(paquete!=null){
                //si la ultima reserva tiene estado!= "activo" se crea reserva nueva(deberia)
                reserv.setPaquete(paquete);
                reserv.setCliente(c1);
                XMLClientes.insertPaquete(reserv, nroIdClient);
            }else{
                System.out.println("el paquete no existe");
            }
        }else{
            System.out.println("algo no se ingreso de la manera correcta RPaquet");
        }
        
    }
    // en lo de tipo transporte nose como lo pensamos 
    public void registrarPasaje(int nroIdClient,String nombCl,String origen,String destino,String fechaIda,String fechaVuelta,String tipoTransporte,String nombrEmpresa, int precio) {
        //en aqui se añadira el pasaje
        Date fechaId,fechaVuelt;
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
        fechaId=null;
        fechaVuelt=null;
        try{
        fechaId=formatoFecha.parse(fechaIda);
        fechaVuelt=formatoFecha.parse(fechaVuelta);
        }catch(ParseException e){
            System.out.println("fecha formato incorrecto registro pasaje no hecho");
        }
        Pasaje p;
        Cliente c1=agen.verificarExistencia(nombCl, nroIdClient);
        if(c1!=null){
            Reserva reserv=c1.getHistorial().getUltReserv();
            p=new Pasaje(origen, destino, fechaId, fechaVuelt, nombrEmpresa, tipoTransporte, nombrEmpresa, precio);
            agen.reservaPasaje(origen, destino, nroIdClient, nombCl, fechaId, fechaVuelt, tipoTransporte, nombrEmpresa, precio);
            //si la ultima reserva tiene estado!= "activo" se crea reserva nueva(deberia)
            reserv.setPasaje(p);
            reserv.setCliente(c1);
            XMLClientes.insertPasaje(reserv, nroIdClient);
        }else{}
    }
}
