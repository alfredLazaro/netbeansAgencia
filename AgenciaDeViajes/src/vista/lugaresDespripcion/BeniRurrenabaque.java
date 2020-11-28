/*
 * esto podria poner se en un Jpanel e integrase a un solo Jframe(ventana)
 */
package vista.lugaresDespripcion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Fred 
 */
public class BeniRurrenabaque extends JFrame{
    //se podria sacar el codigo y ponerlo en una clase panel, para juntarlo
    private JPanel pnlImgIzq,pnlImgDer,pnlDescrp,pnlNombL;
    private JLabel lblNombreLug,lblDescrp,lblUbic;
    private JLabel lblImgn1,lblImgn2,lblImgn3,lblImgn4,lblImgn5;
    private BorderLayout layPrinc;
    private BoxLayout    layCentro;
    private GridLayout   layIzq,layDer;
    private FlowLayout   layNomb;
    //este main debe ser borrado esta de pruba 
    public static void main(String[] args) {
        BeniRurrenabaque p=new BeniRurrenabaque();
    }
    
    public BeniRurrenabaque() throws HeadlessException {
        setTitle("agencia De viajes (nombre agencia)");
        setSize(1080,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciar();
        setVisible(true);
    }
    private void iniciar(){
        iniciarPanels();
        integrImgs();
        integrInfo();
    }
    
    private void iniciarPanels(){
        pnlNombL=new JPanel();
        pnlImgIzq=new JPanel();
        pnlDescrp=new JPanel();
        pnlImgDer=new JPanel();
        iniciarLayouts();
        integLayouts();
        editColor();
        //se creo un espacio para que no se vea la tan junto a las imagenes
        pnlDescrp.add(Box.createRigidArea (new Dimension(10, 0)));
        //se integran todos los paneles en el jFrame
        add(pnlNombL,BorderLayout.NORTH);
        add(pnlImgIzq,BorderLayout.WEST);
        add(pnlDescrp,BorderLayout.CENTER);
        add(pnlImgDer,BorderLayout.EAST);
    }
    
    private void iniciarLayouts(){
        layPrinc=new BorderLayout();
        layNomb=new FlowLayout();
        layIzq=new GridLayout(3, 1, 10, 5);
        layCentro=new BoxLayout(pnlDescrp,BoxLayout.Y_AXIS);
        layDer=new GridLayout(3, 1, 10,5);

    }
    private void integLayouts(){
        setLayout(layPrinc);
        pnlNombL.setLayout(layNomb);
        pnlImgIzq.setLayout(layIzq);
        pnlDescrp.setLayout(layCentro);
        pnlImgDer.setLayout(layDer);
    }
    private void editColor(){
        pnlNombL.setBackground(new Color(32, 112, 193));
        pnlImgIzq.setBackground(new Color(32, 112, 193));
        pnlDescrp.setBackground(new Color(32, 112, 193));
        pnlImgDer.setBackground(new Color(32, 112, 193));
    }
    private void integrImgs(){
        lblImgn1=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/Rurrenabaque/rurrenabaque-01.jpg")));
        lblImgn2=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/Rurrenabaque/rurrenabaque-02.jpg")));
        lblImgn3=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/Rurrenabaque/rurrenabaque-03.jpg")));
        lblImgn4=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/Rurrenabaque/rurrenabaque-04.jpg")));
        pnlImgIzq.add(lblImgn1);
        pnlImgIzq.add(lblImgn2);
        pnlImgDer.add(lblImgn3);
        pnlImgDer.add(lblImgn4);
        
    }
    private void integrInfo(){
        lblNombreLug=new JLabel("Rurrenabaque");
        lblUbic=new JLabel("<html>Contáctanos:<p> Av. Ayacucho entre Colombia y Ecuador <p>+591 62615493 <p>4 4446666 <p> Cochabamba-Bolivia<html>");
        lblDescrp=new JLabel("<html>El pequeño pueblo de Rurrenabaque es la puerta de entrada a una parte exuberante y emocionantemente hermosa del noroeste de Bolivia que ofrece una oportunidad para los turistas apasionados por apoyar los esfuerzos hacia la sostenibilidad y proteger las especies en peligro de extinción.<html><p>"
                + "<p><html>Bolivia acaba de ganar un premio al Mejor Destino Verde de World Travel Awards por sus esfuerzos para hacer que toda esta región, repleta de cascadas rugientes y vida silvestre rara, y hogar de muchos grupos indígenas, sea sostenible al lanzar programas para el ecoturismo.<p><p>Aquí los visitantes encontrarán Madidi, una de las áreas protegidas con mayor biodiversidad del mundo, y Rhukanrhuka, un área de selva tropical y praderas naturales casi tan grandes como Yellowstone. En junio de 2019, el gobierno municipal de Reyes (en asociación con la Wildlife Conservation Society y Rainforest Trust) designó a Rhukanrhuka como un área protegida, una que conservará los monos titi en peligro de extinción, los delfines rosados de río y otros animales salvajes raros.<p><html>"
                +"<html><p>Rurrenabaque, o 'Rurre', como lo llaman los lugareños, es el punto de partida para las giras por la jungla y las pampas en este otrora remotos rincón de Bolivia. La riqueza de la vida silvestre, la flora y la cultura indígena ha convertido a Rurrenabaque en un centro de eco viajes en los últimos años.<p><html>"
                +"<html><p>Situado en la orilla este del río Beni, con San Buenaventura en la orilla opuesta, Rurrenabaque es un importante centro de comercio y enlace de transporte para el departamento de Beni. La ciudad en sí tiene menos de 8000 residentes permanentes, la mayoría de los cuales son nativos de Tacana y todavía hablan el idioma nativo.<p><html>"
                +"<html><p>Rurrenabaque tiene algunos puntos de vista bonitos que muestran los ríos y zonas verdes circundantes, como La Cruz Lookout y Butterfly Pool Lookout. La ciudad, flanqueada por el ancho Rio Beni por un lado y la hermosa Cordillera de Bala cubierta por la jungla por el otro, tiene un entorno encantador y una atmósfera agradable.<p><html>"
                +"<html><p>Rurrenabaque es una ciudad pequeña y es posible caminar casi en todas partes. A diferencia de la mayoría de las ciudades bolivianas, los negocios, restaurantes y oficinas en Rurre no se centran alrededor de la plaza (2 de Febrero), sino que se agrupan a unas pocas cuadras al norte a lo largo de Calles Santa Cruz y Avaroa. Si el clima tropical es demasiado, los moto taxis son abundantes.<p><html>"
                +"<html><p>Un sendero empinado sube desde el final de la calle Luis Fernando Pellicioli, detrás de la iglesia, a 45 minutos hasta una cruz y un mirador con buenas vistas de la ciudad y el río. Es especialmente agradable alrededor de la puesta del sol, pero asegúrese de regresar antes de que oscurezca, ya que partes del sendero son difíciles.<p><html>"
                +"<html><p>En la orilla opuesta del Río Beni se encuentra San Buenaventura. Una canoa motorizada hace el viaje corto pero bonito durante todo el día. En la plaza de San Buenaventura se encuentra el Centro Cultural Tacana, con un pequeño museo y artesanías nativas en venta.<p><html>");
        pnlNombL.add(lblNombreLug);
        pnlImgIzq.add(lblUbic);
        pnlDescrp.add(lblDescrp);
    }
}