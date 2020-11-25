import javax.swing.*;
import java.awt.*;

public class Admin extends JFrame {
    JPanel panel = new JPanel();
    public Admin(){
        setTitle("Ingreso de Administrador");
        setBounds(500,200,1080,800);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(32,112,193));
        iniciarComponentes();
    }
    private void iniciarComponentes(){
        colocarPanel();
        colocarCajasDeTexto();
        colocarBotones();
        colocarEtiqueta();
        colocarAreaDeTexto();
    }
    private void colocarEtiqueta(){
        JLabel etiqueta = new JLabel("AGENCIA DE VIAJES", SwingConstants.LEFT);//crea la etiqueta
        panel.add(etiqueta);
        etiqueta.setBounds(10,0,500,50);
        etiqueta.setForeground(Color.white);
        etiqueta.setFont(new Font("arial",Font.BOLD,30));

    }
    private void colocarPanel(){
        panel.setBackground(new Color(32,112,193));
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    private void colocarCajasDeTexto(){
        //usuario
        JTextField cajaTexto = new JTextField();
        cajaTexto.setBounds(450,240,200,50);
        cajaTexto.setText("Usuario");
        panel.add(cajaTexto);
        //contrasenia
        JTextField cajaTexto2 = new JTextField();
        cajaTexto2.setBounds(450,290,200,50);
        cajaTexto2.setText("Contrasenia");
        panel.add(cajaTexto2);
    }
    private void colocarBotones(){
        //boton 1
        JButton boton1 = new JButton("Ingresar");
        boton1.setBounds(500,500,100,50);
        boton1.setEnabled(true);
        panel.add(boton1);
        boton1.setForeground(new Color(102,166,252));
        boton1.setFont(new Font("cooper black",2, 15));
    }
    private void colocarAreaDeTexto(){
        JTextArea contactanos = new JTextArea();
        contactanos.setBounds(20,610,300,300);
        contactanos.setBackground(null);
        contactanos.setForeground(Color.white);
        contactanos.setText("Contáctanos: \nAv. Ayacucho entre Colombia y Ecuador \n+591 62615493 \n4 4446666 \n Cochabamba-Bolivia");
        panel.add(contactanos);
    }




}
