/*
 * 
 */
package Prinpal;

import java.util.ArrayList;
import java.util.HashMap;
import metodosAgen.*;
import modelo.XMLDepartamentos;
import modelo.XMLPaquetes;
/**
 *
 * @author USUARIO
 */
public class IniciadorLugares {
    private HashMap<String,ArrayList<PaqueteTuristico>> lugares;
    private ArrayList<Integer> codigsPaqus;
    private ArrayList<PaqueteTuristico> listPa;
    
    private IniciadorPaquete listaPaqs;
    
    public static void main(String[] args) {
        IniciadorLugares ini=new IniciadorLugares();
    }
    public IniciadorLugares() {
        llenarCodsPaqs();
        iniciarLugrs();
    }
    
    public void recogerPaquetes(){
        listPa=new ArrayList<>();
        listPa=XMLPaquetes.paquetes();
        if(!listPa.isEmpty()){
            System.out.println("tenemos los paquetesTu");
        }else{
            System.out.println("algo salio mal");
        }
    }
    //esto es una prueba haber que tal sale 
    public void llenarCodsPaqs(){
        codigsPaqus=new ArrayList<>();
        ArrayList<PaqueteTuristico> p=XMLPaquetes.paquetes();
        for(PaqueteTuristico paq:p){
            int codig=paq.getNroIde();
            codigsPaqus.add(codig);
        }
        
    }
     private void iniciarLugrs(){
         //cochabamba
         XMLDepartamentos.agregarLugarTuris("", "",obtenerCodLug(0));
         //chuquisaqua
         
         //tarija
         
         //La Paz
         
         //oruro
         
         //Potosi
         
         //Santa Cruz 
         
         //Beni
         XMLDepartamentos.agregarLugarTuris("Riberalta", "Beni",obtenerCodLug(0));
         XMLDepartamentos.agregarLugarTuris("Rurrenabaque", "Beni",obtenerCodLug(2));
         XMLDepartamentos.agregarLugarTuris("Laguna Suares", "Beni",obtenerCodLug(4));
         //Pando
         
     }
    private ArrayList<Integer> obtenerCodLug(int pos){
        int j,k;
        ArrayList<Integer> codsUnlug=new ArrayList<>();
        j=0;
        for(int i=pos;i<codigsPaqus.size()&& j<=2;i++){
            codsUnlug.add(codigsPaqus.get(i));
            j=j+1;
        }
        return codsUnlug;
    }
}
