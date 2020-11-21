
public class Transporte {
    private int presio;
    private String origen;
    private String tipo;

    public Transporte(int presio, String origen, String tipo) {
        this.presio = presio;
        this.origen = origen;
        
        this.tipo =tipo;
    }   
    //seccion de los geters

  

    public String getOrigen() {
        return origen;
    }

    public int getPresio() {
        return presio;
    }
    //seccion de seters

   
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setPresio(int presio) {
        this.presio = presio;
    }

    public String getTipo() {
        return tipo;
    }
    
}
