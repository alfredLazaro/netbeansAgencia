
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class Restaurante {
    private ArrayList<Comida> menu;
    private String ubicacion;

    public Restaurante(ArrayList<Comida> menu, String ubicacion) {
        this.menu = menu;
        this.ubicacion = ubicacion;
    }
    // zona de geters

    public ArrayList<Comida> getMenu() {
        return menu;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    // zona de seters

    public void setMenu(ArrayList<Comida> menu) {
        this.menu = menu;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
}
