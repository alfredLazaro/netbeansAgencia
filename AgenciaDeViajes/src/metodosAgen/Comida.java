/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class Comida {
    private String plato;
    private int precio;

    public Comida(String plato, int precio) {
        this.plato = plato;
        this.precio = precio;
    }
    //sona de geters

    public String getPlato() {
        return plato;
    }

    public int getPrecio() {
        return precio;
    }
    //Zona de seters 

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
