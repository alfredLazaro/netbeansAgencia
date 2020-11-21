
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class Historial {
    private ArrayList<Reserva> reservas;
    private int nroIdent; //el nro de identificacion sera el del cliente
    private Date fechaModificacion;

    public Historial( int nroIdent, Date fechaModificacion) {
        this.nroIdent = nroIdent;
        this.fechaModificacion = fechaModificacion;
    }
    
    public void aniadirReserva(Reserva reserva){
        
    }
    //zona de geters

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public int getNroIdent() {
        return nroIdent;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    
    //zona de seters

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    
}
