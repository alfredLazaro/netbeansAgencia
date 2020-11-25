import javax.imageio.spi.RegisterableService;

public class Main {
    public static void main(String[] args) {
        Admin v1 = new Admin();
        LugaresTuristicos v2 = new LugaresTuristicos();
        LugaresTuristicos2 v3 = new LugaresTuristicos2();
        RegistrarCliente v4 = new RegistrarCliente();
        ReservarPaquete v5 = new ReservarPaquete();
        CancelarReserva v6 = new CancelarReserva();
        ListaDePaquetes v7 = new ListaDePaquetes();
        v1.setVisible(true);
        v2.setVisible(true);
        v3.setVisible(true);
        v4.setVisible(true);
        v5.setVisible(true);
        v6.setVisible(true);
        v7.setVisible(true);
    }
}
