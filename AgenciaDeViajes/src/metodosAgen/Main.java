
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introdusca el nombre de la empresa");
        String nombre=sc.nextLine();
        System.out.println(nombre);
        Agencia empresaTurismo=new Agencia();
        //creacion de elementos para Agencia
        HashMap<String,ArrayList<PaqueteTuristico>> lugaresTuristicos=new HashMap<>();
        HashMap<Integer,Cliente> clientes=new HashMap<>();
        ArrayList<Pasaje> pasajes=new ArrayList<>();
        String nombEmpresa="Empresa genial";
        //se crea inicia empresa Turismo
        Agencia empresaTurismo2=new Agencia(null, pasajes,nombEmpresa, lugaresTuristicos, clientes);
        //se hace registro de clientes
        empresaTurismo2.registrarCliente("Edgar", 7, "invierno", "viaje familia");
        empresaTurismo2.registrarCliente("luis", 4,"Verano", "negocios");
        empresaTurismo2.registrarCliente("rodigo", 1, "otoño", "vivir de nuevo");
        empresaTurismo2.registrarCliente("Rosio", 1, "primavera", "vacaciones");
        //crear PaquetesTuristicos
        Transporte transpor=new Transporte(30, "lago","hotel");
    empresaTurismo.registrarCliente("ricardo", 2, "verano", "negocios");
    //empresaTurismo.reservarPaquetes("ricardo",12532,4,34985,"lago Titicaca");
    }
}
