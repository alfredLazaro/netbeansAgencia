
package Prinpal;
import java.util.ArrayList;
import java.util.HashMap;
import metodosAgen.*;
import modelo.XMLAdministradores;
import modelo.XMLClientes;
import modelo.XMLDepartamentos;
import modelo.XMLPaquetes;
/**
 *
 * @author fred
 */

public class InteracionConXMLs {
    private Agencia agen;
    private HashMap<Integer,Cliente> clientes;
    private HashMap<String,ArrayList<PaqueteTuristico>> lugares;
    private Administrador admin;
    private String nombreEmp;
    public InteracionConXMLs() {
        //vista=vista.setLabelTitulo;
        nombreEmp="Travel Pandemic";
        iniciarClientes();
        iniciarLugares();
        boolean e=existAdm("agente67", "67531896");
        
        agen=new Agencia(null, null, nombreEmp, lugares, clientes);
        //vista.setPaquetes();
    }
    private void iniciarClientes(){
        clientes=XMLClientes.hashClientes();
    }
    private void iniciarLugares(){
        lugares=XMLDepartamentos.HashPaquetesLugrs();
    }
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
    private void pruebLugrs(){
        
    }
    
    public void agregPac(String nomb){
        
        agen.agregarPaquete(nombreEmp, nombreEmp, nombreEmp, nombreEmp, 0);
                //falta obtener el paquete creado
        //XMLPaquetes.insertPaquet(pac);
        
    }
    
    public void agreg(){
        
    }
}
