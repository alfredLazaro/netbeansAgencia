/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author Alan
 */
public class ChuquisacaVirgerGuadalupe extends JFrame {
    private JPanel pnlImgIzq,pnlImgDer,pnlDescrp,pnlNombL;
    private JLabel lblNombreLug,lblDescrp,lblUbic;
    private JLabel lblImgn1,lblImgn2,lblImgn3,lblImgn4,lblImgn5;
    private BorderLayout layPrinc;
    private BoxLayout    layCentro;
    private GridLayout   layIzq,layDer;
    private FlowLayout   layNomb;
    //este main debe ser borrado esta de pruba 
    public static void main(String[] args) {
        ChuquisacaVirgerGuadalupe p=new ChuquisacaVirgerGuadalupe();
    }
    
    public ChuquisacaVirgerGuadalupe() throws HeadlessException {
        setTitle("agencia De viajes (nombre agencia)");
        setSize(1080,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciar();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void iniciar(){
        iniciarPanels();
        integrImgs();
        integrInfo();
        editColorEtiquets();
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
        lblImgn1=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Chuquisaca/CapillaVirgenGuadalupe/imagen1.jpg")));
        lblImgn2=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Chuquisaca/CapillaVirgenGuadalupe/imagen2.jpg")));
        lblImgn3=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Chuquisaca/CapillaVirgenGuadalupe/imagen3.jpg")));
        lblImgn4=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Chuquisaca/CapillaVirgenGuadalupe/imagen4.jpg")));
        lblImgn5=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Chuquisaca/CapillaVirgenGuadalupe/imagen5.jpg")));

        
        
        pnlImgIzq.add(lblImgn1);
        pnlImgIzq.add(lblImgn2);
        pnlImgDer.add(lblImgn3);
        pnlImgDer.add(lblImgn4);
        pnlImgDer.add(lblImgn5);
        
    }
    private void integrInfo(){
        lblNombreLug=new JLabel("Capilla de la Virgen de Guadalupe");
        lblUbic=new JLabel("<html>Contáctanos:<p> Av. Ayacucho entre Colombia y Ecuador <p>+591 62615493 <p>4 4446666 <p> Cochabamba-Bolivia<html>");
        lblDescrp=new JLabel("<html>La imagen mas querida para muchos denominado como la patrona de Chuquisaca o Sucre, una hermosa imagen con una infinita cantidad de incrustaciones de joyas de inapreciable valor. En 1748 el lienzo se reforzo con una plancha de maciza de oro y plata, representado el manto de la Virgen dejando la pintura original en el rostro de la virgen y el niño.<html><p>"
                + "<p><html>La historia nos relata que una trade encontraron una mula extraviada con una extraña carga en su lomo, se trabata de un enorme cajon que el animal cuidaba celosamente sin dejarse atrapar. Cuando se postraba a descansar, esta se encondia entra las plantas y luego salia sin descuidar jamas su carga, la gente intento atrapar a dicho animal pensando que llevaba consigo era un tesoro, finalmente con ayuda de autoridades y la iglesia el animal fue atrapado descubriendo en su cargo siendo una sorpresa para todos una hermosa imagen de la virgen de rostro moreno y un niño en sus mano: era la Virgen de Guadalupe.<p><html>"
                +"<html><p>Desde entonces, se celebra en su honor una gran fiesta el 8 de septiembre, con entradas folkloricas de conjuntos, dando otro atractivo mas colorido y de gran interes para enriquezer nuestro turismo nacional, durante la fiesta dicha imagen recorre la ciudad mostrandose a la poblacion en general a paso lento mas que todo en la Plaza 25 de Mayo .<p><html>"
                +"<html><p>Nuestro paquete ofrece diferentes actividades que se encuentra formuladas en este con diferentes atractivos para las familias que se dirigen a dicha zona, considerar que se realizaran diferentes caminatas durante nuestro tour, aquellas personas que llegasen a sufrir problemas fisicos abstenerse.<p><html>"
                +"<html><p><p><html>");
        pnlNombL.add(lblNombreLug);
        pnlImgIzq.add(lblUbic);
        pnlDescrp.add(lblDescrp);
    }
    
    private void editColorEtiquets(){
        lblDescrp.setForeground(Color.WHITE);
        lblUbic.setForeground(Color.WHITE);
        lblNombreLug.setForeground(Color.WHITE);
        //se cambian tamaños
        lblDescrp.setFont(new Font("arial", Font.PLAIN, 14));
        lblUbic.setFont(new Font("arial", Font.PLAIN, 14));
        lblNombreLug.setFont(new Font("arial", Font.PLAIN, 20));
    }
}
