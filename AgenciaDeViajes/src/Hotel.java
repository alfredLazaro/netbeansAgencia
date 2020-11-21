
/**
 *
 * @author USUARIO
 */
public class Hotel {
    private int precioUnitario;
    private String ubicacion;
    private boolean existeVacante;

    public Hotel(int precioUnitario, String ubicacion) {
        this.precioUnitario = precioUnitario;
        this.ubicacion = ubicacion;
        existeVacante = true;
    }
    //espacio de los geters

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    
    //espacio de los seters

    public void setExisteVacante(boolean existeVacante) {
        this.existeVacante = existeVacante;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
}
