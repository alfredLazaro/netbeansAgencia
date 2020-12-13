
package Prinpal;
import java.util.ArrayList;
import java.util.HashMap;
import metodosAgen.*;
import modelo.XMLAdministradores;
import modelo.XMLClientes;
import modelo.XMLDepartamentos;
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
    public InteracionConXMLs(String nombreEmpresa) {
        nombreEmp=nombreEmpresa;
        iniciarClientes();
        iniciarLugares();
        boolean e=existAdm("agente67", "67531896");
        
        agen=new Agencia(null, null, nombreEmp, lugares, clientes);
        
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
}
