package vista;
import javax.swing.*;
import java.awt.*;
public class ListaDePaquetes extends JFrame{
    JPanel panel = new JPanel();

    public ListaDePaquetes() {
        setTitle("Lista de Paquetes Turisticos");
        setBounds(500, 200, 1080, 800);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(32, 112, 193));
        
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        colocarPaneles();
        colocarEtiqueta();
        colocarListaDesplegable();
        //colocarAreaDeTexto();
        colocarCajaDeTexto();
        colocarBotones();
    }
    private void colocarPaneles() {
        panel.setBackground(new Color(32, 112, 193));
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    private void colocarEtiqueta() {
        JLabel etiqueta = new JLabel("AGENCIA DE VIAJES", SwingConstants.LEFT);//crea la etiqueta
        panel.add(etiqueta);
        etiqueta.setBounds(10, 0, 500, 50);
        etiqueta.setForeground(Color.white);
        etiqueta.setFont(new Font("arial", Font.BOLD, 30));
        //cod paquete
        JLabel etiqueta1 = new JLabel("Cod. de paquete...................3450320");
        etiqueta1.setBounds(100, 160, 300, 100);
        etiqueta1.setBackground(new Color(104, 205, 253));
        panel.add(etiqueta1);
        //tipo de transporte
        JLabel etiqueta2 = new JLabel("Tipo de transporte................Bus");
        etiqueta2.setBounds(100, 200, 300, 100);
        etiqueta2.setBackground(new Color(104, 205, 253));
        panel.add(etiqueta2);
        //Hotel
        JLabel etiqueta3 = new JLabel("Hotel................Hotel Cochabamba");
        etiqueta3.setBounds(100, 240, 2300, 100);
        etiqueta3.setBackground(new Color(104, 205, 253));
        panel.add(etiqueta3);
        //menu
        JLabel etiqueta4 = new JLabel("Menú................");
        etiqueta4.setBounds(100, 280, 2300, 100);
        etiqueta4.setBackground(new Color(104, 205, 253));
        panel.add(etiqueta4);
        //precio
        JLabel etiqueta5 = new JLabel("Precio............. Bs 320");
        etiqueta5.setBounds(100, 320, 2300, 100);
        etiqueta5.setBackground(new Color(104, 205, 253));
        panel.add(etiqueta5);
        //PERSONALIZACION
        JLabel etiqueta6 = new JLabel("Personalizacion de Paquetes", SwingConstants.RIGHT);//crea la etiqueta
        panel.add(etiqueta6);
        etiqueta6.setBounds(450, 100, 500, 50);
        etiqueta6.setForeground(Color.white);
        etiqueta6.setFont(new Font("arial", Font.BOLD, 20));
        //Tipo de transporte
        JLabel etiqueta7 = new JLabel("Tipo de transporte");
        etiqueta7.setBounds(500, 160, 200, 100);
        etiqueta7.setBackground(new Color(104, 205, 253));
        panel.add(etiqueta7);
        //Nombre de hotel
        JLabel etiqueta8 = new JLabel("Nombre del hotel");
        etiqueta8.setBounds(750, 160, 200, 100);
        etiqueta8.setBackground(new Color(104, 205, 253));
        panel.add(etiqueta8);
        //nombre del restaurante
        JLabel etiqueta9 = new JLabel("Nombre del restaurante");
        etiqueta9.setBounds(500, 220, 200, 100);
        etiqueta9.setBackground(new Color(104, 205, 253));
        panel.add(etiqueta9);
    }
    private void colocarListaDesplegable() {
        String[] opciones = {"Pique", "Buffet"};
        JComboBox lista = new JComboBox(opciones);
        lista.setBounds(200, 320, 200, 30);
        //lista.setSelectedItem("C");
        //lista.addItem("vuelos");
        panel.add(lista);
    }
    private void colocarCajaDeTexto() {
        //caja para tipo de transporte
        JTextField cajaTexto = new JTextField();
        cajaTexto.setBounds(500, 220, 180, 30);
        panel.add(cajaTexto);
        //caja para el hotel
        JTextField cajaTexto1 = new JTextField();
        cajaTexto1.setBounds(750, 220, 180, 30);
        panel.add(cajaTexto1);
        //caja para el restaurante
        JTextField cajaTexto2 = new JTextField();
        cajaTexto2.setBounds(500, 280, 180, 30);
        panel.add(cajaTexto2);

    }
    private void colocarBotones(){
        JButton boton1 = new JButton("Crear paquete personalizado");
        boton1.setBounds(750, 260, 250, 50);
        boton1.setEnabled(true);
        panel.add(boton1);
        boton1.setBackground(new Color(104,205,253));
        boton1.setForeground(Color.black);
        boton1.setFont(new Font("cooper black", 2, 15));

    }}
