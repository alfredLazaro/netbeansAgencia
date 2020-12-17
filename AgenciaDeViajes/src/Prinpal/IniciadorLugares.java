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
        iniciarDepart();
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
        
    }private void iniciarDepart(){
        ArrayList<String> lDepart=new ArrayList<>();
        lDepart.add("Cochabamba"); lDepart.add("Chuquisaqua"); lDepart.add("Tarija"); lDepart.add("La Paz");
        lDepart.add("Oruro");lDepart.add("Potosi"); lDepart.add("Santa Cruz"); lDepart.add("Beni"); 
        lDepart.add("Pando");
        XMLDepartamentos.iniciarDepartXML(lDepart);
    }
     private void iniciarLugrs(){
         //cochabamba
         XMLDepartamentos.agregarLugarTuris("El Cristo", "Cochabamba",obtenerCodLug(0));
         XMLDepartamentos.agregarLugarTuris("El Parque", "Cochabamba",obtenerCodLug(3));
         XMLDepartamentos.agregarLugarTuris("Catedral San Sebastian", "Cochabamba",obtenerCodLug(6));
         XMLDepartamentos.agregarLugarTuris("Villa Tunari", "Cochabamba",obtenerCodLug(9));
         
         //chuquisaqua
         XMLDepartamentos.agregarLugarTuris("Casa Libertad", "Chuquisaqua",obtenerCodLug(10));
         XMLDepartamentos.agregarLugarTuris("Catedral", "Chuquisaqua",obtenerCodLug(13));
         XMLDepartamentos.agregarLugarTuris("Recoleta", "Chuquisaqua",obtenerCodLug(16));
         XMLDepartamentos.agregarLugarTuris("Virgen Guadalupe", "Chuquisaqua",obtenerCodLug(19));
         
         //tarija
         XMLDepartamentos.agregarLugarTuris("Casa Dorada", "Tarija",obtenerCodLug(20));
         XMLDepartamentos.agregarLugarTuris("Museo Paleontologico", "Tarija",obtenerCodLug(23));
         XMLDepartamentos.agregarLugarTuris("Ruta Vino", "Tarija",obtenerCodLug(26));
         XMLDepartamentos.agregarLugarTuris("Tariquia", "Tarija",obtenerCodLug(29));
         
         //La Paz
         XMLDepartamentos.agregarLugarTuris("Valle de la Luna", "La Paz",obtenerCodLug(30));
         XMLDepartamentos.agregarLugarTuris("El Teleferico", "La Paz",obtenerCodLug(33));
         XMLDepartamentos.agregarLugarTuris("Las Cholets", "La Paz",obtenerCodLug(36));
         XMLDepartamentos.agregarLugarTuris("La Tiahuanaco", "La Paz",obtenerCodLug(39));
         //oruro
         XMLDepartamentos.agregarLugarTuris("Cala Cala", "Oruro",obtenerCodLug(40));
         XMLDepartamentos.agregarLugarTuris("El Carnabal", "Oruro",obtenerCodLug(43));
         XMLDepartamentos.agregarLugarTuris("Salar Coipasa", "Oruro",obtenerCodLug(46));
         XMLDepartamentos.agregarLugarTuris("Virgen Socavon", "Oruro",obtenerCodLug(49));
         //Potosi
         XMLDepartamentos.agregarLugarTuris("Cerro Rico", "Potosi",obtenerCodLug(50));
         XMLDepartamentos.agregarLugarTuris("Pulacayo", "Potosi",obtenerCodLug(53));
         XMLDepartamentos.agregarLugarTuris("Salar Uyuni", "Potosi",obtenerCodLug(56));
         XMLDepartamentos.agregarLugarTuris("Torotoro", "Potosi",obtenerCodLug(59));
         //Santa Cruz 
         XMLDepartamentos.agregarLugarTuris("La Pequeña Suiza", "Santa Cruz",obtenerCodLug(60));
         XMLDepartamentos.agregarLugarTuris("Biocentro Guembe", "Santa Cruz",obtenerCodLug(63));
         XMLDepartamentos.agregarLugarTuris("Las Misiones de Chiquitos", "Santa Cruz",obtenerCodLug(66));
         XMLDepartamentos.agregarLugarTuris("Ciudad de Santa Cruz", "Santa Cruz",obtenerCodLug(69));
         //Beni
         XMLDepartamentos.agregarLugarTuris("Riberalta", "Beni",obtenerCodLug(70));
         XMLDepartamentos.agregarLugarTuris("Rurrenabaque", "Beni",obtenerCodLug(73));
         XMLDepartamentos.agregarLugarTuris("Laguna Suares", "Beni",obtenerCodLug(76));
         XMLDepartamentos.agregarLugarTuris("Loma Suares", "Beni",obtenerCodLug(79));
         //Pando
         /*
         XMLDepartamentos.agregarLugarTuris("", "Pando",obtenerCodLug(80));
         XMLDepartamentos.agregarLugarTuris("", "Pando",obtenerCodLug(83));
         XMLDepartamentos.agregarLugarTuris("", "Pando",obtenerCodLug(86));
         XMLDepartamentos.agregarLugarTuris("", "Pando",obtenerCodLug(89));
         */
     }
    private ArrayList<Integer> obtenerCodLug(int pos){
        int j,k;
        ArrayList<Integer> codsUnlug=new ArrayList<>();
        j=0;
        for(int i=pos;i<codigsPaqus.size()&& j<=2;i++){
            codsUnlug.add(codigsPaqus.get(i));
            j=j+1;
            if(i%10==9){
                break;
            }
        }
        return codsUnlug;
    }
}
