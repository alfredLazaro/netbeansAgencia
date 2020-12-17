package vista;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.lugaresDespripcion.*;

public class LugaresTuristicos extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    private JComboBox lista;

    public LugaresTuristicos() {
        setTitle("Lugares Turisticos");
        setBounds(500, 200, 1080, 800);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(32, 112, 193));
        iniciarComponentes();
        setVisible(true);
    }
    private void iniciarComponentes() {
        colocarPaneles();
        colocarEtiqueta();
        colocarListaDesplegable();
        colocarAreaDeTexto();
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
        //imagen1
        ImageIcon imagen1 = new ImageIcon("/Users/gabrielgonzales/Documents/Universidad/4toSemestre/MyT/Cochabamba/cristo.jpg");
        JLabel foto1 = new JLabel();
        foto1.setBounds(80,180,250,150);
        foto1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(300,200,4)));
        panel.add(foto1);
        //imagen2
        ImageIcon imagen2 = new ImageIcon("/Users/gabrielgonzales/Documents/Universidad/4toSemestre/MyT/Cochabamba/parque.jpg");
        JLabel foto2 = new JLabel();
        foto2.setBounds(580,180,300,200);
        foto2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(300,200,4)));
        panel.add(foto2);
        //imagen3
        //ImageIcon imagen3 = new ImageIcon("/Users/gabrielgonzales/Documents/Universidad/4toSemestre/MyT/Cochabamba/lugares.jpg");
        //JLabel foto3 = new JLabel();
        //foto1.setBounds(680,180,300,200);
        //foto1.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(300,200,4)));
        //panel.add(foto3);
    }
    private void colocarListaDesplegable(){
        String[] opciones = {"La Paz","Cochabamba","Santa Cruz","Oruro","Potosí","Chuquisaca","Tarija","Beni","Pando",""};
        lista = new JComboBox(opciones);
        lista.setBounds(430,100,200,30);
        lista.setSelectedItem("");
        lista.addActionListener(this);
        panel.add(lista);
    }
    private void colocarAreaDeTexto() {
        JTextArea contactanos = new JTextArea();
        contactanos.setBounds(20, 610, 300, 300);
        contactanos.setBackground(null);
        contactanos.setForeground(Color.white);
        contactanos.setText("Contáctanos: \nAv. Ayacucho entre Colombia y Ecuador \n+591 62615493 \n4 4446666 \n Cochabamba-Bolivia");
        panel.add(contactanos);
    }
    public void actionPerformed (ActionEvent e){
            String elemento = (String)lista.getSelectedItem();
            if (elemento.equals("Oruro") == true){
                LugaresOruro ventana = new LugaresOruro();
                this.setVisible(false);
                ventana.setVisible(true);
            }
            if (elemento.equals("Potosí") == true){
                LugaresPotosi ventana = new LugaresPotosi();
                this.setVisible(false);
                ventana.setVisible(true);
            }
            if (elemento.equals("Chuquisaca") == true){
                LugaresChuquisaca ventana = new LugaresChuquisaca();
                this.setVisible(false);
                ventana.setVisible(true);
            }
            if (elemento.equals("Tarija") == true){
                LugaresTarija ventana = new LugaresTarija();
                this.setVisible(false);
                ventana.setVisible(true);
            }
            if (elemento.equals("Beni") == true){
                LugaresBeni ventana = new LugaresBeni();
                this.setVisible(false);
                ventana.setVisible(true);
            }
       }
}