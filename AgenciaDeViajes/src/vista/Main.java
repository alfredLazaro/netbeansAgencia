package vista;
import javax.imageio.spi.RegisterableService;
import vista.lugaresDespripcion.LugaresChuquisaca;

public class Main {
    public static void main(String[] args) {
        Admin v1 = new Admin();
        LugaresTuristicos v2 = new LugaresTuristicos();
        FuncionesAdministrador v3 = new FuncionesAdministrador();
        ListaDePaquetes v4 = new ListaDePaquetes();
        v1.setVisible(true);
        v2.setVisible(true);
        v3.setVisible(true);
        v4.setVisible(true);
    }
}
