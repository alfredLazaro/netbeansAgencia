/*
 *
 */
package Prinpal;
import java.util.ArrayList;
import java.util.Date;
import modelo.*;
import metodosAgen.*;
/**
 * @author Fred
 */
public class ImpresorObjetosPrueba {
    
    private ArrayList<Cliente> listClientes;
    private ArrayList<Administrador> listAd;
    private ArrayList<PaqueteTuristico> lisPaquetes;
    private Comida      comid2,comid1;
    private PaqueteTuristico paquete2;
    private Hotel hotCbba2;
    private Restaurante restCbba2;
    
    public static void main(String[] args) {
        ImpresorObjetosPrueba imp=new ImpresorObjetosPrueba();
    }
    
    public ImpresorObjetosPrueba(){
        
        PaqueteTuristico pa=buscarPac(391); // error en qui nose por que
        System.out.println("cant dias "+pa.getCantDias());
        
        /*
        Administrador admin=admin("agente45","67531896");
        System.out.println("contraseña " +admin.getContrasenia());
        aniaHistorial(123456);
        */
        /*
        elimAdministr("agente45", "67531896");
        Cliente c1=new Cliente("maclovin", 3,"verano", "aventura", 12341);
        insertClient(c1);
        */
        //eliminarClient("maclovin",12341);
        /*
        Cliente cl=buscarC(12345);
        System.out.println("nombre "+ cl.getNombreCliente());
        elimHist(12341);
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
        /*
        insertAd("Agente69", "67531896");
        
        listAd=listAd();
        for(Administrador a:listAd){
            String nomC=a.getNombreCuenta();
            String cont=a.getContrasenia();
            System.out.println("nombre "+ nomC);
            System.out.println("contra "+ cont);
        }
        */
        /*
        lisPaquetes=listPaq();
        for(PaqueteTuristico p:lisPaquetes){
            String nomb=p.getTransporte().getTipoTransporte();
            System.out.println("transporte "+nomb);
        }
        */
        /*
        Historial hist=buscarHistorial(12345);
        Date fec=hist.getFechaModificacion();
        System.out.println("fecha "+ fec);
        */
        
        //eliminarClient("Alan", 54231); //ahora se elimina el historial a la vez
        
        /*
        hotCbba2 = new Hotel(450,"Cochabamba","Huper Hotel Boutique");
        restCbba2 = new Restaurante("Cochabamba","Jacaranda");
        comid1 = new Comida("Pique Macho",100);
        comid2 = new Comida("Charque",80);
        restCbba2.agregarPlato(comid1);
        restCbba2.agregarPlato(comid2);
        paquete2 = new PaqueteTuristico(null,hotCbba2,restCbba2,2);
        insertPacLugar("Villa Tunari", paquete2);
        */
        
        
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
    public void aniaHistorial(int cod){
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
    
    public ArrayList<Cliente> obtenerClientes(){
        ArrayList<Cliente> listClientes=new ArrayList<>();
        listClientes=XMLClientes.listaClientes();
        if(!listClientes.isEmpty()){
            System.out.println("estupendo exelente");
        }else{
            System.out.println("no lo devolvio");
        }
        return listClientes;
    }
    
    
}
