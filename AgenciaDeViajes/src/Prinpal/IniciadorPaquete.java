/*
 * 
 */
package Prinpal;
import metodosAgen.*;
//import modelo.*;
import java.util.*;
/**
 * @author Fred
 */
public class IniciadorPaquete {
    private ArrayList<PaqueteTuristico> p;
    PaqueteTuristico paquete1,paquete2,paquete3,paquete4,paquete5,paquete6,paquete7,paquete8,paquete9,paquete10,
                     paquete11,paquete12,paquete13,paquete14,paquete15,paquete16,paquete17,paquete18,paquete19,paquete20,
                     paquete21,paquete22,paquete23,paquete24,paquete25,paquete26,paquete27,paquete28,paquete29,paquete30,
                     paquete31,paquete32,paquete33,paquete34,paquete35,paquete36,paquete37,paquete38,paquete39,paquete40,
                     paquete41,paquete42,paquete43,paquete44,paquete45,paquete46,paquete47,paquete48,paquete49,paquete50,
                     paquete51,paquete52,paquete53,paquete54,paquete55,paquete56,paquete57,paquete58,paquete59,paquete60,
                     paquete61,paquete62,paquete63,paquete64,paquete65,paquete66,paquete67,paquete68,paquete69,paquete70,
                     paquete71,paquete72,paquete73,paquete74,paquete75,paquete76,paquete77,paquete78,paquete79,paquete80,
                     paquete81,paquete82,paquete83,paquete84,paquete85,paquete86,paquete87,paquete88,paquete89,paquete90;
    Restaurante restLP1,restLP2,restLP3,restLP4,restLP5,
                restOr1,restOr2,restOr3,restOr4,restOr5,
                restPot1,restPot2,restPot3,restPot4,restPot5,
                restCbba1,restCbba2,restCbba3,restCbba4,restCbba5,
                resChuq1,resChuq2,resChuq3,resChuq4,resChuq5,
                resTar1,resTar2,resTar3,resTar4,resTar5,
                restSC1,restSC2,restSC3,restSC4,restSC5,
                restBeni1,restBeni2,restBeni3,restBeni4,restBeni5,
                restPan1,restPan2,restPan3,restPan4,restPan5;
                
    Hotel       hotLP1,hotLP2,hotLP3,hotLP4,hotLP5,
                hotOr1,hotOr2,hotOr3,hotOr4,hotOr5,
                hotPot1,hotPot2,hotPot3,hotPot4,hotPot5,
                hotCbba1,hotCbba2,hotCbba3,hotCbba4,hotCbba5,
                hotChuq1,hotChuq2,hotChuq3,hotChuq4,hotChuq5,
                hotTar1,hotTar2,hotTar3,hotTar4,hotTar5,
                hotSC1,hotSC2,hotSC3,hotSC4,hotSC5,
                hotBeni1,hotBeni2,hotBeni3,hotBeni4,hotBeni5,
                hotPan1,hotPan2,hotPan3,hotPan4,hotPan5;
                
    Comida      comid1,comid2,comid3,comid4,comid5,comid6,
                comid7,comid8,comid9,comid10,comid11,comid12,
                comid13,comid14,comid15,comid16,comid17,comid18,
                comid19,comid20,comid21,comid22,comid23,comid24,comid25,comid26;
                
    Transporte  transpTierraCbba1,transpTierraChu1,transpTierraTa1,transpTierraSC1,transpTierraBeni1,
                transpTierraPan1,transpTierraLP1,transpTierraOr1,transpTierraPot1,
                transpTierraCbba2,transpTierraChu2,transpTierraTa2,transpTierraSC2,transpTierraBeni2,
                transpTierraPan2,transpTierraLP2,transpTierraOr2,transpTierraPot2,
                transpTierraCbba3,transpTierraChu3,transpTierraTa3,transpTierraSC3,transpTierraBeni3,
                transpTierraPan3,transpTierraLP3,transpTierraOr3,transpTierraPot3,
                transpAguaBeni1,transpAguaBeni2;
    
    /*public static void main(String[] args) {
        
    }*/
    
    public IniciadorPaquete(){
        p=new ArrayList<>();
        iniciarT();
        iniciarH();
        iniciarR();
        //Cochabamba
        paquete1 = new PaqueteTuristico(transpTierraCbba1,hotCbba1,restCbba1,4);
        paquete2 = new PaqueteTuristico(transpTierraCbba3,hotCbba2,restCbba2,2);
        paquete3 = new PaqueteTuristico(transpTierraCbba2,hotCbba1,restCbba4,5);
        paquete4 = new PaqueteTuristico(transpTierraCbba1,hotCbba4,restCbba4,4);
        paquete5 = new PaqueteTuristico(transpTierraCbba3,hotCbba5,restCbba5,3);
        paquete6 = new PaqueteTuristico(transpTierraCbba2,hotCbba1,restCbba3,4);
        paquete7 = new PaqueteTuristico(transpTierraCbba1,hotCbba2,restCbba5,5);
        paquete8 = new PaqueteTuristico(transpTierraCbba2,hotCbba3,restCbba3,3);
        paquete9 = new PaqueteTuristico(transpTierraCbba3,hotCbba2,restCbba1,4);
        paquete10 = new PaqueteTuristico(transpTierraCbba1,hotCbba1,restCbba5,3);
        //Chuquisaca
        paquete11 = new PaqueteTuristico(transpTierraChu1,hotChuq1,resChuq1,3);
        paquete12 = new PaqueteTuristico(transpTierraChu2,hotChuq2,resChuq2,1);
        paquete13 = new PaqueteTuristico(transpTierraChu1,hotChuq3,resChuq2,5);
        paquete14 = new PaqueteTuristico(transpTierraChu2,hotChuq4,resChuq4,4);
        paquete15 = new PaqueteTuristico(transpTierraChu2,hotChuq5,resChuq5,3);
        paquete16 = new PaqueteTuristico(transpTierraChu1,hotChuq1,resChuq1,2);
        paquete17 = new PaqueteTuristico(transpTierraChu3,hotChuq3,resChuq3,2);
        paquete18 = new PaqueteTuristico(transpTierraChu2,hotChuq1,resChuq4,5);
        paquete19 = new PaqueteTuristico(transpTierraChu3,hotChuq4,resChuq1,4);
        paquete20 = new PaqueteTuristico(transpTierraChu1,hotChuq2,resChuq5,1);
        //Tarija
        paquete21 = new PaqueteTuristico(transpTierraTa1,hotTar1,resTar1,3);
        paquete22 = new PaqueteTuristico(transpTierraTa2,hotTar1,resTar2,2);
        paquete23 = new PaqueteTuristico(transpTierraTa2,hotTar3,resTar3,4);
        paquete24 = new PaqueteTuristico(transpTierraTa1,hotTar3,resTar2,5);
        paquete25 = new PaqueteTuristico(transpTierraTa1,hotTar5,resTar5,4);
        paquete26 = new PaqueteTuristico(transpTierraTa2,hotTar5,resTar4,2);
        paquete27 = new PaqueteTuristico(transpTierraTa3,hotTar2,resTar2,3);
        paquete28 = new PaqueteTuristico(transpTierraTa3,hotTar3,resTar1,3);
        paquete29 = new PaqueteTuristico(transpTierraTa1,hotTar4,resTar4,3);
        paquete30 = new PaqueteTuristico(transpTierraTa3,hotTar1,resTar2,2);
        //La Paz
        paquete31 = new PaqueteTuristico(transpTierraLP3,hotLP1,restLP1,4);
        paquete32 = new PaqueteTuristico(transpTierraLP1,hotLP1,restLP1,4);
        paquete33 = new PaqueteTuristico(transpTierraLP3,hotLP1,restLP1,4);
        paquete34 = new PaqueteTuristico(transpTierraLP2,hotLP1,restLP1,4);
        paquete35 = new PaqueteTuristico(transpTierraLP1,hotLP1,restLP1,4);
        paquete36 = new PaqueteTuristico(transpTierraLP2,hotLP1,restLP1,3);
        paquete37 = new PaqueteTuristico(transpTierraLP1,hotLP1,restLP1,3);
        paquete38 = new PaqueteTuristico(transpTierraLP2,hotLP1,restLP1,3);
        paquete39 = new PaqueteTuristico(transpTierraLP3,hotLP1,restLP1,3);
        paquete40 = new PaqueteTuristico(transpTierraLP3,hotLP1,restLP1,3);
        //Oruro
        paquete41 = new PaqueteTuristico(transpTierraOr1,hotOr3,restOr1,2);
        paquete42 = new PaqueteTuristico(transpTierraOr2,hotOr2,restOr2,3);
        paquete43 = new PaqueteTuristico(transpTierraOr3,hotOr4,restOr2,3);
        paquete44 = new PaqueteTuristico(transpTierraOr3,hotOr4,restOr4,2);
        paquete45 = new PaqueteTuristico(transpTierraOr2,hotOr5,restOr1,2);
        paquete46 = new PaqueteTuristico(transpTierraOr1,hotOr1,restOr2,4);
        paquete47 = new PaqueteTuristico(transpTierraOr2,hotOr1,restOr5,5);
        paquete48 = new PaqueteTuristico(transpTierraOr1,hotOr3,restOr3,3);
        paquete49 = new PaqueteTuristico(transpTierraOr3,hotOr3,restOr2,3);
        paquete50 = new PaqueteTuristico(transpTierraOr3,hotOr5,restOr5,2);
        //Potosi
        paquete51 = new PaqueteTuristico(transpTierraPot3,hotPot1,restPot1,4);
        paquete52 = new PaqueteTuristico(transpTierraPot2,hotPot2,restPot3,2);
        paquete53 = new PaqueteTuristico(transpTierraPot1,hotPot3,restPot2,3);
        paquete54 = new PaqueteTuristico(transpTierraPot1,hotPot3,restPot4,2);
        paquete55 = new PaqueteTuristico(transpTierraPot2,hotPot5,restPot5,4);
        paquete56 = new PaqueteTuristico(transpTierraPot3,hotPot1,restPot4,5);
        paquete57 = new PaqueteTuristico(transpTierraPot2,hotPot2,restPot2,4);
        paquete58 = new PaqueteTuristico(transpTierraPot3,hotPot3,restPot3,2);
        paquete59 = new PaqueteTuristico(transpTierraPot1,hotPot4,restPot4,3);
        paquete60 = new PaqueteTuristico(transpTierraPot2,hotPot5,restPot2,4);
        //Santa Cruz
        paquete61 = new PaqueteTuristico(transpTierraSC2,hotSC1,restSC1,5);
        paquete62 = new PaqueteTuristico(transpTierraSC3,hotSC2,restSC3,3);
        paquete63 = new PaqueteTuristico(transpTierraSC1,hotSC2,restSC4,5);
        paquete64 = new PaqueteTuristico(transpTierraSC2,hotSC4,restSC4,3);
        paquete65 = new PaqueteTuristico(transpTierraSC3,hotSC5,restSC5,5);
        paquete66 = new PaqueteTuristico(transpTierraSC1,hotSC5,restSC1,2);
        paquete67 = new PaqueteTuristico(transpTierraSC3,hotSC2,restSC2,4);
        paquete68 = new PaqueteTuristico(transpTierraSC2,hotSC3,restSC3,2);
        paquete69 = new PaqueteTuristico(transpTierraSC3,hotSC4,restSC2,4);
        paquete70 = new PaqueteTuristico(transpTierraSC2,hotSC3,restSC2,2);
        //Beni
        paquete71 = new PaqueteTuristico(transpTierraBeni1,hotBeni1,restBeni4,4);
        paquete72 = new PaqueteTuristico(transpTierraBeni2,hotBeni5,restBeni2,3);
        paquete73 = new PaqueteTuristico(transpTierraBeni2,hotBeni3,restBeni4,2);
        paquete74 = new PaqueteTuristico(transpTierraBeni3,hotBeni4,restBeni5,2);
        paquete75 = new PaqueteTuristico(transpTierraBeni3,hotBeni2,restBeni1,4);
        paquete76 = new PaqueteTuristico(transpTierraBeni1,hotBeni1,restBeni1,2);
        paquete77 = new PaqueteTuristico(transpAguaBeni1,hotBeni2,restBeni2,3);
        paquete78 = new PaqueteTuristico(transpAguaBeni2,hotBeni3,restBeni3,3);
        paquete79 = new PaqueteTuristico(transpAguaBeni1,hotBeni4,restBeni4,4);
        paquete80 = new PaqueteTuristico(transpAguaBeni2,hotBeni5,restBeni5,2);
        //Pando
        paquete81 = new PaqueteTuristico(transpTierraPan3,hotPan1,restPan1,4);
        paquete82 = new PaqueteTuristico(transpTierraPan3,hotPan3,restPan2,4);
        paquete83 = new PaqueteTuristico(transpTierraPan2,hotPan1,restPan3,5);
        paquete84 = new PaqueteTuristico(transpTierraPan2,hotPan2,restPan4,4);
        paquete85 = new PaqueteTuristico(transpTierraPan1,hotPan1,restPan5,2);
        paquete86 = new PaqueteTuristico(transpTierraPan1,hotPan2,restPan5,2);
        paquete87 = new PaqueteTuristico(transpTierraPan3,hotPan3,restPan4,2);
        paquete88 = new PaqueteTuristico(transpTierraPan2,hotPan4,restPan2,4);
        paquete89 = new PaqueteTuristico(transpTierraPan1,hotPan5,restPan3,3);
        paquete90 = new PaqueteTuristico(transpTierraPan2,hotPan5,restPan1,3);
        aniadirListaPaquetes();
    }
    
    private List<PaqueteTuristico> crearPaq(){
        List<PaqueteTuristico> res=null;
        for(int i=0;i<3;i++){
            
        }
        return res;
    }
    
    private void iniciarH(){
        //Cochabamba
        hotCbba1 = new Hotel(250,"Cochabamba","Regina");
        hotCbba2 = new Hotel(450,"Cochabamba","Huper Hotel Boutique");
        hotCbba3 = new Hotel(300,"Cochabamba","Selenza Apart Hotel");
        hotCbba4 = new Hotel(400,"Cochabamba","Camino Plaza");
        hotCbba5 = new Hotel(450,"Cochabamba","Gran Hotel Cochabamba");
        //Chuquisaca
        hotChuq1 = new Hotel(500,"Chuquisaca","Parador Santa Maria La Real");
        hotChuq2 = new Hotel(240,"Chuquisaca","Wasi");
        hotChuq3 = new Hotel(230,"Chuquisaca","Ajayu Sucre");
        hotChuq4 = new Hotel(280,"Chuquisaca","España");
        hotChuq5 = new Hotel(330,"Chuquisaca","Hotel Villa Antigua");
        //Tarija
        hotTar1 = new Hotel(490,"Tarija","Hotel los Parrales");
        hotTar2 = new Hotel(340,"Tarija","Victoria Plaza");
        hotTar3 = new Hotel(300,"Tarija","La Pasarela");
        hotTar4 = new Hotel(390,"Tarija","Los Ceibos");
        hotTar5 = new Hotel(270,"Tarija","Hotel Viña del Sur");
        //La Paz
        hotLP1 = new Hotel(440,"La Paz","Hotel Europa");
        hotLP2 = new Hotel(490,"La Paz","Hotel Atix");
        hotLP3 = new Hotel(350,"La Paz","Presidente");
        hotLP4 = new Hotel(250,"La Paz","Milton");
        hotLP5 = new Hotel(290,"La Paz","Hotel LP Columbus");
        //Oruro
        hotOr1 = new Hotel(250,"Oruro","Hidalgo");
        hotOr2 = new Hotel(510,"Oruro","Edén by BlueBay");
        hotOr3 = new Hotel(390,"Oruro","Gran Sucre");
        hotOr4 = new Hotel(350,"Oruro","SamayWasi");
        hotOr5 = new Hotel(420,"Oruro","Virgen del Socavo");
        //Potosi
        hotPot1 = new Hotel(450,"Potosi","Coloso Potosi");
        hotPot2 = new Hotel(390,"Potosi","Colonial");
        hotPot3 = new Hotel(550,"Potosi","Palacio de Sal");
        hotPot4 = new Hotel(350,"Potosi","Santa Monica");
        hotPot5 = new Hotel(290,"Potosi","Cerro Rico Velasco");
        //Santa Cruz
        hotSC1 = new Hotel(480,"Santa Cruz","Marriott Hotel");
        hotSC2 = new Hotel(420,"Santa Cruz","Continental Park");
        hotSC3 = new Hotel(400,"Santa Cruz","Terranova Suites");
        hotSC4 = new Hotel(490,"Santa Cruz","Los Tajibos");
        hotSC5 = new Hotel(360,"Santa Cruz","Las Palmas");
        //Beni
        hotBeni1 = new Hotel(150,"Beni","Pampa & Selva");
        hotBeni2 = new Hotel(240,"Beni","Tuki and Ambaibo");
        hotBeni3 = new Hotel(220,"Beni","Maya de la Amazonia");
        hotBeni4 = new Hotel(370,"Beni","Boutique del Rey");
        hotBeni5 = new Hotel(120,"Beni","Oriental");
        //Pando
        hotPan1 = new Hotel(270,"Pando","Apart Plaza");
        hotPan2 = new Hotel(350,"Pando","Asai");
        hotPan3 = new Hotel(240,"Pando","Victoria");
        hotPan4 = new Hotel(300,"Pando","Dorado");
        hotPan5 = new Hotel(310,"Pando","Diana");
    }
    
    private void iniciarT(){
        //Tierra
        transpTierraCbba1 = new Transporte(50,"Cochabamba","Bus Turistico");
        transpTierraCbba2 = new Transporte(40,"Cochabamba","Jeep");
        transpTierraCbba3 = new Transporte(20,"Cochabamba","Bicicleta");
        
        transpTierraChu1 = new Transporte(50,"Chuquisaca","Bus Turistico");
        transpTierraChu2 = new Transporte(80,"Chuquisaca","Jeep");
        transpTierraChu3 = new Transporte(20,"Chuquisaca","Bicicleta");
        
        transpTierraTa1 = new Transporte(50,"Tarija","Bus Turistico");
        transpTierraTa2 = new Transporte(40,"Tarija","Jeep");
        transpTierraTa3 = new Transporte(20,"Tarija","Bicicleta");
        
        transpTierraSC1 = new Transporte(50,"Santa Cruz","Bus Turistico");
        transpTierraSC2 = new Transporte(40,"Santa Cruz","Jeep");
        transpTierraSC3 = new Transporte(30,"Santa Cruz","Moto Taxi");
        
        transpTierraBeni1 = new Transporte(50,"Beni","Bus Turistico");
        transpTierraBeni2 = new Transporte(40,"Beni","Jeep");
        transpTierraBeni3 = new Transporte(25,"Beni","Caballo");
        
        transpTierraPan1 = new Transporte(50,"Pando","Bus Turistico");
        transpTierraPan2 = new Transporte(40,"Pando","Jeep");
        transpTierraPan3 = new Transporte(20,"Pando","Caballo");
        
        transpTierraLP1 = new Transporte(50,"La Paz","Bus Turistico");
        transpTierraLP2  = new Transporte(40,"La Paz","Jeep");
        transpTierraLP3 = new Transporte(30, "La Paz","PumaKatari");
        
        transpTierraOr1 = new Transporte(50,"Oruro","Bus Turistico");
        transpTierraOr2 = new Transporte(40,"Oruro","Jeep");
        transpTierraOr3 = new Transporte(35,"Oruro","Minivan");
        
        transpTierraPot1 = new Transporte(50,"Potosi","Bus Turistico");
        transpTierraPot2= new Transporte(40,"Potosi","Jeep");
        transpTierraPot3 = new Transporte(35,"Oruro","Minivan");
        
        //Agua
        transpAguaBeni1 = new Transporte(40,"Beni","Moto Acuatica");
        transpAguaBeni2 = new Transporte(40,"Beni","Bote");
        
    }
    
    private void iniciarR(){
        iniciarC();
        //Cochabamba
        restCbba1 = new Restaurante("Cochabamba","Tropical Chicken");
        restCbba1.agregarPlato(comid16);
        restCbba1.agregarPlato(comid17);
        
        restCbba2 = new Restaurante("Cochabamba","Jacaranda");
        restCbba2.agregarPlato(comid1);
        restCbba2.agregarPlato(comid2);
        
        restCbba3 = new Restaurante("Cochabamba","Sbarro");
        restCbba3.agregarPlato(comid10);
        restCbba3.agregarPlato(comid11);
        
        restCbba4 = new Restaurante("Cochabamba","Tuesday");
        restCbba4.agregarPlato(comid12);
        restCbba4.agregarPlato(comid13);
        restCbba4.agregarPlato(comid14);
        
        restCbba5 = new Restaurante("Cochabamba","Casa de Campo Express");
        restCbba5.agregarPlato(comid4);
        restCbba5.agregarPlato(comid5);
        
        //Chuquisaca
        resChuq1 = new Restaurante("Chuquisaca","La Taverna Sucre");
        resChuq1.agregarPlato(comid9);
        resChuq1.agregarPlato(comid20);
        
        resChuq2 = new Restaurante("Chuquisaca","El Huerto");
        resChuq2.agregarPlato(comid12);
        resChuq2.agregarPlato(comid16);
        
        resChuq3 = new Restaurante("Chuquisaca","Restaurante Los Olivos");
        resChuq3.agregarPlato(comid25);
        resChuq3.agregarPlato(comid4);
        
        resChuq4 = new Restaurante("Chuquisaca","Bienmesabe");
        resChuq4.agregarPlato(comid19);
        resChuq4.agregarPlato(comid15);
        
        resChuq5 = new Restaurante("Chuquisaca","La Posada");
        resChuq5.agregarPlato(comid14);
        resChuq5.agregarPlato(comid15);
        
        //Tarija
        resTar1 = new Restaurante("Tarija","Churrasqueria El Rodeo de Tarija");
        resTar1.agregarPlato(comid3);
        resTar1.agregarPlato(comid6);
        
        resTar2 = new Restaurante("Tarija","Macondo Pizza");
        resTar2.agregarPlato(comid10);
        resTar2.agregarPlato(comid11);
        
        resTar3 = new Restaurante("Tarija","Doña Pastorita");
        resTar3.agregarPlato(comid25);
        resTar3.agregarPlato(comid2);
        
        resTar4 = new Restaurante("Tarija","Restaurante El Marques");
        resTar4.agregarPlato(comid1);
        resTar4.agregarPlato(comid7);
        
        resTar5 = new Restaurante("Tarija","Casona del Molino");
        resTar5.agregarPlato(comid3);
        resTar5.agregarPlato(comid4);
        
        //La Paz
        restLP1 = new Restaurante("La Paz","Pollos Copacabana");
        restLP1.agregarPlato(comid16);
        restLP1.agregarPlato(comid17);
        restLP1.agregarPlato(comid18);
        
        restLP2 = new Restaurante("La Paz","Flor de Loto");
        restLP2.agregarPlato(comid4);
        restLP2.agregarPlato(comid2);
        
        restLP3 = new Restaurante("La Paz","Kory Tiawanaku");
        restLP3.agregarPlato(comid8);
        restLP3.agregarPlato(comid9);
        
        restLP4 = new Restaurante("La Paz","La tranquera");
        restLP4.agregarPlato(comid5);
        restLP4.agregarPlato(comid2);
        
        restLP5 = new Restaurante("La Paz","Mestiza");
        restLP5.agregarPlato(comid9);
        restLP5.agregarPlato(comid7);
        
        //Oruro
        restOr1 = new Restaurante("Oruro", "Churrasqueria El Mana");
        restOr1.agregarPlato(comid3);
        restOr1.agregarPlato(comid5);
        restOr1.agregarPlato(comid4);
        
        restOr2 = new Restaurante("Oruro", "La casa del agasajo");
        restOr2.agregarPlato(comid6);
        restOr2.agregarPlato(comid4);
        
        restOr3 = new Restaurante("Oruro", "Rincon Orureño");
        restOr3.agregarPlato(comid25);
        restOr3.agregarPlato(comid7);
        
        restOr4 = new Restaurante("Oruro", "La Casona");
        restOr4.agregarPlato(comid1);
        restOr4.agregarPlato(comid14);
        
        restOr5 = new Restaurante("Oruro", "Bravo's Pizza");
        restOr5.agregarPlato(comid10);
        restOr5.agregarPlato(comid11);
        
        //Potosi
        restPot1 = new Restaurante("Potosi","El Tenedor de la Plata");
        restPot1.agregarPlato(comid6);
        restPot1.agregarPlato(comid2);
        
        restPot2 = new Restaurante("Potosi","El fogón");
        restPot2.agregarPlato(comid3);
        restPot2.agregarPlato(comid11);
        restPot2.agregarPlato(comid12);
        
        restPot3 = new Restaurante("Potosi","Pizzeria EL Mana");
        restPot3.agregarPlato(comid10);
        restPot3.agregarPlato(comid11);
        
        restPot4 = new Restaurante("Potosi","La Casona");
        restPot4.agregarPlato(comid13);
        restPot4.agregarPlato(comid1);
        
        restPot5 = new Restaurante("Potosi","Luciernagas Restaurant");
        restPot5.agregarPlato(comid19);
        restPot5.agregarPlato(comid7);
        restPot5.agregarPlato(comid5);
        
        //Santa Cruz
        restSC1 = new Restaurante("Santa Cruz", "El paraiso");
        restSC1.agregarPlato(comid2);
        restSC1.agregarPlato(comid7);
        restSC1.agregarPlato(comid5);
        
        restSC2 = new Restaurante("Santa Cruz", "Hard Rock Cafe");
        restSC2.agregarPlato(comid22);
        restSC2.agregarPlato(comid23);
        restSC2.agregarPlato(comid24);
        
        restSC3 = new Restaurante("Santa Cruz", "Restaurante KEN");
        restSC3.agregarPlato(comid4);
        restSC3.agregarPlato(comid6);
        
        restSC4 = new Restaurante("Santa Cruz", "La Gaira");
        restSC4.agregarPlato(comid12);
        restSC4.agregarPlato(comid13);
        restSC4.agregarPlato(comid25);
        
        restSC5 = new Restaurante("Santa Cruz", "Jardin de Asia");
        restSC5.agregarPlato(comid3);
        restSC5.agregarPlato(comid3);
        
        //Beni
        restBeni1 = new Restaurante("Beni","Casa de Campo");
        restBeni1.agregarPlato(comid25);
        restBeni1.agregarPlato(comid1);
        restBeni1.agregarPlato(comid2);
        
        restBeni2 = new Restaurante("Beni","La Bella Italia");
        restBeni2.agregarPlato(comid10);
        restBeni2.agregarPlato(comid11);
        restBeni2.agregarPlato(comid15);
        
        restBeni3 = new Restaurante("Beni","Paititi");
        restBeni3.agregarPlato(comid20);
        restBeni3.agregarPlato(comid26);
        
        restBeni4 = new Restaurante("Beni","La Perla de Rurre");
        restBeni4.agregarPlato(comid6);
        restBeni4.agregarPlato(comid8);
        
        restBeni5 = new Restaurante("Beni","El Tabano");
        restBeni5.agregarPlato(comid2);
        restBeni5.agregarPlato(comid25);
        
        //Pando
        restPan1 = new Restaurante("Pando","Campo Grande");
        restPan1.agregarPlato(comid1);
        restPan1.agregarPlato(comid7);
        restPan1.agregarPlato(comid26);
        
        restPan2 = new Restaurante("Pando","Las Palmas");
        restPan2.agregarPlato(comid25);
        restPan2.agregarPlato(comid2);
        
        restPan3 = new Restaurante("Pando","Pizzeria Tres Fronteras");
        restPan3.agregarPlato(comid10);
        restPan3.agregarPlato(comid11);
        
        restPan4 = new Restaurante("Pando","Esquina de la Abuela");
        restPan4.agregarPlato(comid8);
        restPan4.agregarPlato(comid9);
        
        restPan5 = new Restaurante("Pando","Los Cedrillos");
        restPan5.agregarPlato(comid1);
        restPan5.agregarPlato(comid4);
    }
    
    private void iniciarC(){
        comid1 = new Comida("Pique Macho",100);
        comid2 = new Comida("Charque",80);
        comid3 = new Comida("Churrasco",85);
        comid4 = new Comida("Bife Chorizo",70);
        comid5 = new Comida("Cerdo a la Parrilla",65);
        comid6 = new Comida("Matahambre",65);
        comid7 = new Comida("Silpancho",30);
        comid8 = new Comida("Fritanga",40);
        comid9 = new Comida("Mondongo",40);
        comid10 = new Comida("Pizza Familiar ",70);
        comid11 = new Comida("Pizza Mediana",40);
        comid12 = new Comida("Hamburguesa Simple",20);
        comid13 = new Comida("Hamburguesa Doble",25);
        comid14 = new Comida("Lasagna",30);
        comid15 = new Comida("Ravioles",30);
        comid16 = new Comida("Pollo Broaster 1/4",26);
        comid17 = new Comida("Pollo Broaster Combo Trio",39);
        comid18 = new Comida("Balde Alitas",26);
        comid19 = new Comida("Pastas",20);
        comid20 = new Comida("Paella",30);
        comid21 = new Comida("Cafe",30);
        comid22 = new Comida("Cafe Cortado",20);
        comid23 = new Comida("Capucchino",25);
        comid24 = new Comida("Sandwich de Jamon y Queso",15);
        comid25 = new Comida("Planchita",20);
        comid26 = new Comida("Filete de pescado",25);
    }
    
    private void integrarCom(){
        
    }
    
    public void aniadirListaPaquetes(){
        p.add(paquete1);p.add(paquete2);p.add(paquete3);p.add(paquete4);p.add(paquete5);
        p.add(paquete6);p.add(paquete7); p.add(paquete8);p.add(paquete9);p.add(paquete10);
        p.add(paquete11);p.add(paquete12);p.add(paquete13);p.add(paquete14);p.add(paquete15);
        p.add(paquete16);p.add(paquete17);p.add(paquete18);p.add(paquete19);p.add(paquete20);
        p.add(paquete21);p.add(paquete22);p.add(paquete23);p.add(paquete24);p.add(paquete25);
        p.add(paquete26);p.add(paquete27);p.add(paquete28);p.add(paquete29);p.add(paquete30);
        p.add(paquete31);p.add(paquete32);p.add(paquete33);p.add(paquete34);p.add(paquete35);
        p.add(paquete36);p.add(paquete37);p.add(paquete38);p.add(paquete39);p.add(paquete40);
        p.add(paquete41);p.add(paquete42);p.add(paquete43);p.add(paquete44);p.add(paquete45);
        p.add(paquete46);p.add(paquete47);p.add(paquete48);p.add(paquete49);p.add(paquete50);
        p.add(paquete51);p.add(paquete52);p.add(paquete53);p.add(paquete54);p.add(paquete55);
        p.add(paquete56);p.add(paquete57);p.add(paquete58);p.add(paquete59);p.add(paquete60);
        p.add(paquete61);p.add(paquete62);p.add(paquete63);p.add(paquete64);p.add(paquete65);
        p.add(paquete66);p.add(paquete67);p.add(paquete68);p.add(paquete69);p.add(paquete70);
        p.add(paquete71);p.add(paquete72);p.add(paquete73);p.add(paquete74);p.add(paquete75);
        p.add(paquete76);p.add(paquete77);p.add(paquete78);p.add(paquete79);p.add(paquete80);
        p.add(paquete81);p.add(paquete82);p.add(paquete83);p.add(paquete84);p.add(paquete85);
        p.add(paquete86);p.add(paquete87);p.add(paquete88);p.add(paquete89);p.add(paquete90);
    }

    public ArrayList<PaqueteTuristico> getP() {
        return p;
    }
    
}
