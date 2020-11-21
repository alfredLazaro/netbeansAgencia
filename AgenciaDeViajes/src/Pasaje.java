import java.util.ArrayList;
import java.util.Date;

public class Pasaje {
    private String origen;
    private String destino;
    private int precioTotal;
    private Date fechaIda;
    private Date fechaVuelta;
    private String nombreCliente;
    private String empresa;
    private String tipoTransporte;

    public Pasaje(String origen, String destino, Date fechaIda, Date fechaVuelta, String nombreCliente, String tipoTransporte, String empresa) {
        this.origen = origen;
        this.destino = destino;
        this.precioTotal = calcularPrecio(nombreCliente);
        this.fechaIda = fechaIda;
        this.fechaVuelta = fechaVuelta;
        this.nombreCliente = nombreCliente;
        this.empresa = empresa;
        this.tipoTransporte = tipoTransporte;
    }
    public boolean existeOfertaDias(){
      boolean existen=false;
      long diferencia = (fechaIda.getTime()-fechaVuelta.getTime())/(3600000*24);
        System.out.println("la diferencia es" + diferencia);
      return existen;
    }
    private int calcularPrecio(String nombreCliente){
      int res=0;
      return res;
    }
//zona seters
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setFechaIda(Date fechaIda) {
        this.fechaIda = fechaIda;
    }

    public void setFechaVuelta(Date fechaVuelta) {
        this.fechaVuelta = fechaVuelta;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }
    //zona geters
    public String getDestino() {
        return destino;
    }

    public Date getFechaIda() {
        return fechaIda;
    }

    public Date getFechaVuelta() {
        return fechaVuelta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getOrigen() {
        return origen;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }
    
    public String getEmpresa(){
        return empresa;
    }

    public String getTipoTransporte(){
        return tipoTransporte;
    }
}