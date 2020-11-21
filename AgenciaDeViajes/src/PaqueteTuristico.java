/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class PaqueteTuristico {
    private Transporte transporte;
    private Hotel      hotel;
    //private Restaurante restaurante;
    private Comida comida;
    private int precioPaquete;
    private int cantDias;
    private String descripcion;
    private int nroIde;
    private boolean disponible;

    public PaqueteTuristico(Transporte transporte, Hotel hotel, Comida comida, int cantDias) {
        this.transporte = transporte;
        this.hotel = hotel;
        //this.restaurante = restaurante;
        this.comida=comida;
        this.precioPaquete = precioPaquete;
        this.cantDias = cantDias;
        this.descripcion = descripcion;
        this.nroIde = generarId();
        this.disponible = true;
    }
    public boolean existeOfertaDias(){
        boolean res=false;
        if(cantDias>4){
            res=true;
        }else{}
        return res;
    }
     private int generarId(){
         return 0;
     }
    
    //zona de geters

    public int getCantDias() {
        return cantDias;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public int getPrecioPaquete() {
        return precioPaquete;
    }

    /*public Restaurante getRestaurante() {
        return restaurante;
    }*/

    public Transporte getTransporte() {
        return transporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNroIde() {
        return nroIde;
    }

    public boolean getDisponible(){
        return disponible;
    }
     //zona de seters
    public void setDisponible(){
        disponible=!disponible;
    }
    
}
