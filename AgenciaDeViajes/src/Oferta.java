import java.util.ArrayList;
import java.util.Date;

public class Oferta{
  private ArrayList<Date> fechasFestivas;
  private boolean oferta;

  public Oferta (ArrayList<Date>fechasFestivas){
   this.fechasFestivas = fechasFestivas;
   oferta = false;
  }
  public Oferta(){
    fechasFestivas = new ArrayList<>();
    oferta=false;
  }

  public void generarOfertaCantPasajeros(Reserva r){
    
  }
  public void generarOfertaFechasFestivas(Reserva r){
    
  }

  public void generarOfertaClienteFrecuente(Reserva r){

  }

  public void generarOfertaCantDias(Reserva r){

  }

  public boolean getOferta(){
    return oferta;
  }
  public void setOferta(){
    this.oferta = true;
  }
}