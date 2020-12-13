package metodosAgen;

import java.util.ArrayList;
import java.util.Date;

public class Oferta{
  private boolean oferta;

  public Oferta (){
   
  }
  

  public void generarOfertaCantPasajeros(Reserva r){
    int descuento = 3;
    PaqueteTuristico paquete = r.getPaquete() ;
    Pasaje pasaje = r.getPasaje() ;
    int precioPaquete = paquete.calcularPrecio();
    int precioPasaje = pasaje.getPrecioTotal();
    precioPaquete = precioPaquete - ((precioPaquete*descuento)/100);
    precioPasaje =  precioPasaje - ((precioPasaje*descuento)/100);
    pasaje.setPrecioTotal(precioPasaje);
     paquete.setPrecio(precioPaquete);    
  }

  

  public void generarOfertaClienteFrecuente(Reserva r){
      int descuento = 5;
      PaqueteTuristico paquete = r.getPaquete() ;
      Pasaje pasaje = r.getPasaje() ;
      int precioPaquete = paquete.calcularPrecio();
      int precioPasaje = pasaje.getPrecioTotal();
      precioPaquete = precioPaquete - ((precioPaquete*descuento)/100);
      precioPasaje =  precioPasaje - ((precioPasaje*descuento)/100);
      pasaje.setPrecioTotal(precioPasaje);
      paquete.setPrecio(precioPaquete);
  }

  public void generarOfertaCantDias(Reserva r){
    int descuento = 3;
    PaqueteTuristico paquete = r.getPaquete() ;
    Pasaje pasaje = r.getPasaje() ;
    int precioPaquete = paquete.calcularPrecio();
    int precioPasaje = pasaje.getPrecioTotal();
    precioPaquete = precioPaquete - ((precioPaquete*descuento)/100);
    precioPasaje =  precioPasaje - ((precioPasaje*descuento)/100);
    pasaje.setPrecioTotal(precioPasaje);
    paquete.setPrecio(precioPaquete);
  }

  public boolean getOferta(){
    return oferta;
  }
  public void setOferta(){
    this.oferta = true;
  }
}