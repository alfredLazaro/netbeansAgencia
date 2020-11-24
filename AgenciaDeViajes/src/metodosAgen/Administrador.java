package metodosAgen;
public class Administrador{
  public String nombreCuenta;
  private String contrasenia;

  public Administrador(String nombreCuenta, String contrasenia) {
        this.nombreCuenta = nombreCuenta;
        this.contrasenia = contrasenia;
    }
  
  public String getNombreCuenta() {
    return nombreCuenta;
  }
  
  public String getContrasenia(){
      return contrasenia;
  }
  public void setContrasenia(String contrasenia) {
    this.contrasenia = contrasenia;
  }
}