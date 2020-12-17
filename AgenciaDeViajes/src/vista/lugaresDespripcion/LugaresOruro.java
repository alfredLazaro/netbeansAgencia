/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.lugaresDespripcion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Alan
 */
public class LugaresOruro extends JFrame implements ActionListener{
    JPanel panel = new JPanel();
    private JComboBox lista;
    private JButton foto1,foto2,foto3,foto4;

    public LugaresOruro() {
        setTitle("Lugares Turisticos");
        setBounds(500, 200, 1080, 800);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(32, 112, 193));
        iniciarComponentes();
    }
    private void iniciarComponentes() {
        colocarPaneles();
        colocarEtiqueta();
        colocarListaDesplegable();
        colocarAreaDeTexto();
        colocarBotones();
    }
    
    private void colocarBotones(){
        Button boton1 = new Button("paquetes");
        boton1.setBounds(380,290,100,40);
        panel.add(boton1);
        
        Button boton2 = new Button("paquetes");
        boton2.setBounds(380,490,100,40);
        panel.add(boton2);
        
        Button boton3 = new Button("paquetes");
        boton3.setBounds(875,290,100,40);
        panel.add(boton3);
        
        Button boton4 = new Button("paquetes");
        boton4.setBounds(875,490,100,40);
        panel.add(boton4);
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
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Oruro/ElCarnaval/icono.jpg"));
        foto1 = new JButton();
        foto1.setBounds(50,180,250,150);
        foto1.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(300,200,4)));
        foto1.addActionListener(this);
        panel.add(foto1);
        //imagen2
        ImageIcon imagen2 = new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Oruro/CalaCala/icono.jpg"));
        foto2 = new JButton();
        foto2.setBounds(550,180,250,150);
        foto2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(300,200,4)));
        foto2.addActionListener(this);
        panel.add(foto2);
       
        //imagen3
        ImageIcon imagen3 = new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Oruro/SalarDeCoipasa/icono.jpg"));
        foto3 = new JButton();
        foto3.setBounds(50,380,250,150);
        foto3.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(300,200,4)));
        foto3.addActionListener(this);
        panel.add(foto3);
        
        //imagen4
        ImageIcon imagen4 = new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Oruro/SantuarioDeLaVirgenDelSocavon/icono.jpg"));
        foto4 = new JButton();
        foto4.setBounds(550,380,250,150);
        foto4.setIcon(new ImageIcon(imagen4.getImage().getScaledInstance(300,200,4)));
        foto4.addActionListener(this);
        panel.add(foto4);
    }
    private void colocarListaDesplegable(){
        String[] opciones = {"La Paz","Cochabamba","Santa Cruz","Oruro","Potosí","Chuquisaca","Tarija","Beni","Pando"};
        lista = new JComboBox(opciones);
        lista.setBounds(430,100,200,30);
        lista.addActionListener(this);
        panel.add(lista);
       
    }
    private void colocarAreaDeTexto() {
        JTextArea contactanos = new JTextArea();
        contactanos.setBounds(50, 610, 300, 300);
        contactanos.setBackground(null);
        contactanos.setForeground(Color.white);
        contactanos.setText("Contáctanos: \nAv. Ayacucho entre Colombia y Ecuador \n+591 62615493 \n4 4446666 \nCochabamba-Bolivia");
        panel.add(contactanos);
        //Descripcion
        JTextArea descripcion1 = new JTextArea("El Carnaval de Oruro"
                +"\nUno de los grandes patrimonios de  "
                + "\nBolivia, ofreciendo una de las fiestas"
                + "\nmas grandes de cultura general."
                + "\nVe y disfruta de nuestro Carnaval "
                + "\nademas de nuestro excelentes precios.");
        descripcion1.setBounds(320, 180, 220, 100);
        descripcion1.setBackground(null);
        descripcion1.setForeground(Color.white);
        panel.add(descripcion1);
        
        JTextArea descripcion2 = new JTextArea("El Salar de Coipasa"
                +"\nUna de las maravillas que nos ofrece  "
                + "\nBolivia, junto a su majestuoso manto "
                + "\nblanco que junto en epoca de lluvias"
                + "\nse nota los efectos mas hermosos."
                + "\nAproveche nuestros excelentes precios");
        descripcion2.setBounds(320, 385, 220, 100);
        descripcion2.setBackground(null);
        descripcion2.setForeground(Color.white);
        panel.add(descripcion2);
        
        JTextArea descripcion3 = new JTextArea("Cala Cala"
                +"\nUn lugar cuya descripcion no puede  "
                + "\nofrecer bastante conocimiento al"
                + "\nrespecto de las antiguas culturas"
                + "\nque convivian en dicho lugar, a "
                + "\ntraves del arte rupestre.");
        descripcion3.setBounds(815, 180, 220, 100);
        descripcion3.setBackground(null);
        descripcion3.setForeground(Color.white);
        panel.add(descripcion3);
        
        JTextArea descripcion4 = new JTextArea("El Santuario de la Virgen del Socavon"
                +"\nUna escultura que no contempla años"
                + "\nde antiguedad, sino la importancia"
                + "\nque se le da por parte de toda la"
                + "\npoblacion de Oruro a la cual otorgo "
                + "\ndurante todo este tiempo.");
        descripcion4.setBounds(815, 385, 220, 100);
        descripcion4.setBackground(null);
        descripcion4.setForeground(Color.white);
        panel.add(descripcion4);
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
            if (e.getSource()== foto1 ){
                OruroElCarnaval nuevo = new OruroElCarnaval();
                nuevo.setVisible(true);
            }
            if (e.getSource()== foto2 ){
                OruroCalaCala nuevo = new OruroCalaCala();                
                nuevo.setVisible(true);
            }
            if (e.getSource()== foto3 ){
                OruroSalarCoipasa nuevo = new OruroSalarCoipasa();
                nuevo.setVisible(true);
            }
            if (e.getSource()== foto4 ){
                OruroVirgenSocavon nuevo = new OruroVirgenSocavon();
                nuevo.setVisible(true);
            }
       }
}

