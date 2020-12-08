/*
 * 
 */
package Prinpal;
import metodosAgen.*;
import modelo.*;
import java.util.*;
/**
 * @author Fred
 */
public class IniciadorPaquete {
    PaqueteTuristico paquete1,paquete2;
    Restaurante rest1,rest2,rest3;
    Hotel       hot1,hot2,hot3,hot4;
    Comida      comid1,comid2,comid3,comid4,comid5,comid6;
    Transporte  transp1,transp2,transp3;
    
    public static void main(String[] args) {
        
    }
    
    public IniciadorPaquete(){
        paquete1=new PaqueteTuristico(null, null, null, 3);
        paquete2=new PaqueteTuristico(transp1, hot1, rest1, 2);
        
    }
    
    private List<PaqueteTuristico> crearPaq(){
        List<PaqueteTuristico> res=null;
        for(int i=0;i<3;i++){
            
        }
        return res;
    }
    
    private void iniciarR(){
        //cochabamba
        rest1=new Restaurante("cochabamba", "la mejor comida");
        //oruro
        rest2=new Restaurante("Oruro", "la casa del agasajo");
        //santa cruz
        rest3=new Restaurante("Santa Cruz", "el paraizo");
        
    }
    
    private void integrarCom(){
        
    }
    
    
}
