package metodosAgen;

import java.util.ArrayList;
public class PaqueteTuristico{
  private Transporte transporte;
  private Hotel hotel;
  private Restaurante restaurant;
  private double precio;
  private int cantDias;
  private int nroIde;
  private boolean disponible;
  private ArrayList<Integer> codigosUsados;
//paquete turistico tiene restaurant no comida 
  public PaqueteTuristico(Transporte transporte, Hotel hotel, Restaurante restaurant, int cantDias){
    this.transporte = transporte;
    this.hotel = hotel;
    this.restaurant = restaurant;
    precio = calcularPrecio();
    this.cantDias = cantDias;
    codigosUsados = new ArrayList<>();
    nroIde=generarId();
    disponible=true;
  }
  public boolean existeOfertaDias(){
        boolean res=false;
        if(cantDias>4){
            res=true;
        }else{}
        return res;
    }
    
  protected int calcularPrecio(){
      int precio;
      if(transporte==null){
          precio =hotel.getPrecioUnitario() + restaurant.calcularPrecioMenu();
      }else{
          if(hotel==null){
              precio = transporte.getPrecio() + restaurant.calcularPrecioMenu();
          }else{
              if(restaurant==null){
                  precio = transporte.getPrecio() + hotel.getPrecioUnitario();
              }else{
                  //if(transporte!=null && hotel!=null && restaurant!=null){
                      precio = transporte.getPrecio() + hotel.getPrecioUnitario() + restaurant.calcularPrecioMenu();
                  //}
              }
          }
      }
      
      int descuentoCompleto = (precio*5)/100;
      int nuevo = precio - descuentoCompleto;
      return nuevo;    
  }
  
  public int generarId(){
    int res = 0;
    boolean agregado = false; 
    while(!agregado){
      res = (int) (Math.random()*1000);
      if(!codigosUsados.contains(res)){ 
        codigosUsados.add(res);
        agregado = true;
      }
    }
    return res;
  }
  

  //zona de geters
  
  public int getPrecio(){
    return (int)precio;
  }

    public int getCantDias() {
        return cantDias;
    }
  
  public int getNroIde() {
    return nroIde;
  }
 public boolean getDisponible(){
   return disponible;
 }
 
 public Hotel getHotel() {
   return hotel;
 }
 
 public Restaurante getRestaurant() {
   return restaurant;
 }
 
 public Transporte getTransporte() {
   return transporte;
 }
 //zona de seters
 public void setDisponible(){
   disponible=!disponible;
 }

 public void setPrecio(int nuevoPrecio){
   this.precio = nuevoPrecio;
 }

 public void setDisponible(boolean disponible) {
      this.disponible = disponible;
 }

    public void setNroIde(int nroIde) {
        this.nroIde = nroIde;
    }
 
 
}
