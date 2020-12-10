/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prinpal;
import modelo.*;
import metodosAgen.*;
/**
 *
 * @author USUARIO
 */
public class ImpresorObjetosPrueba {
    private XMLPaquetes paq;
    private XMLAdministradores adminis;
    public static void main(String[] args) {
        ImpresorObjetosPrueba imp=new ImpresorObjetosPrueba();
    }
    public ImpresorObjetosPrueba(){
        PaqueteTuristico pa=pac(627);
        System.out.println("cant dias "+pa.getCantDias());
        Administrador admin=admin("agente45","67531896");
        System.out.println("contraseña " +admin.getContrasenia());
        aniaHistorial(123456);
    }
    public void impresor(){
        
    }
    public PaqueteTuristico pac(int cod){
        PaqueteTuristico res=null;
        res=XMLPaquetes.buscarPaquet(cod);
        if(res==null){
            System.out.println("no saco el paquete");
        }
        return res;
    }
    public Reserva reserv(){
        Reserva res=null;
        return res;
    }
    
    public Administrador admin(String nomClav,String contra){
        Administrador ad=null;
        ad=XMLAdministradores.buscarAdmin(nomClav,contra);
        if(ad!=null){
            System.out.println("se encontro");
        }else{
            System.out.println("no se encontro");
        }
        return ad;
    }
    public void aniaHistorial(int cod){
        XMLHistoriales.aniadirHisto(cod);
    }
}
