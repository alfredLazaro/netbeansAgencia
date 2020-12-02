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
public class TarijaMuseoPaleontologico extends JFrame{
   private JPanel pnlImgIzq,pnlImgDer,pnlDescrp,pnlNombL;
    private JLabel lblNombreLug,lblDescrp,lblUbic;
    private JLabel lblImgn1,lblImgn2,lblImgn3,lblImgn4,lblImgn5;
    private BorderLayout layPrinc;
    private BoxLayout    layCentro;
    private GridLayout   layIzq,layDer;
    private FlowLayout   layNomb;
    //este main debe ser borrado esta de pruba 
    public static void main(String[] args) {
        TarijaMuseoPaleontologico pRiber=new TarijaMuseoPaleontologico();
    }
    
    public TarijaMuseoPaleontologico() throws HeadlessException {
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
        editColorPnls();
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
    private void editColorPnls(){
        pnlNombL.setBackground(new Color(32, 112, 193));
        pnlImgIzq.setBackground(new Color(32, 112, 193));
        pnlDescrp.setBackground(new Color(32, 112, 193));
        pnlImgDer.setBackground(new Color(32, 112, 193));
    }
    private void integrImgs(){
        //se especifica hasta la carpeta LugaresTuristicos/ hace falta añadir ubicacion exacta y nombre.jpg
        lblImgn1=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Tarija/MuseoPaleontologico/imagen1.jpg")));
        lblImgn2=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Tarija/MuseoPaleontologico/imagen2.jpg")));
        lblImgn3=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Tarija/MuseoPaleontologico/imagen3.jpg")));
        lblImgn4=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Tarija/MuseoPaleontologico/imagen4.jpg")));
        lblImgn5=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Tarija/MuseoPaleontologico/imagen5.jpg")));
        
        
        
        pnlImgIzq.add(lblImgn1);
        pnlImgIzq.add(lblImgn2);
        pnlImgDer.add(lblImgn3);
        pnlImgDer.add(lblImgn4);
        pnlImgDer.add(lblImgn5);
        
    }
    private void integrInfo(){
        lblNombreLug=new JLabel("Museo Paleontológico de Tarija");
        lblUbic=new JLabel("<html>Contáctanos:<p> Av. Ayacucho entre Colombia y Ecuador <p>+591 62615493 <p>4 4446666 <p> Cochabamba-Bolivia<html>");
        //el <html> es salto de linea automatico el <p> es salto de linea controlado
        lblDescrp=new JLabel("<html><p>Museo Paleontológico\n" +
                                "Un museo de paleontología y arqueología ubicado a una cuadra de la plaza principal, en la cual se contiene todo tipo de fósiles y especímenes que datan de hace millones de años, en la fachada del edificio se pueden observar interesantes esculturas de trilobites y braquiópodos. Los tres principales esqueletos son los que se llevan ser la obra estrella en el museo, los cuales son inmensos, que el primero consta de un gigantesco perezoso, el segundo de un mamut y el tercero de un enorme ancestro de armadillo. Por dentro se puede encontrar un salón de mineralogía con diferentes piedras, rocas, gemas y minerales, y otro está el salón principal, repleto de cerámicas, telas e incluso momias. Como dato adicional se puede aprender cómo en la antigüedad la población enterraba a los difuntos en enormes vasijas de cerámica, cómo sus artesanos producían collares de huesos y piedras, y cómo cazaban y buscaban su comida. La visita al museo es totalmente gratis, únicamente los visitantes se tendrán que registrar en la entrada.<p><html>"
                            +"<html><p>El edificio cuenta con 2 plantas, cuya construccion se inicio en 1941, conocido debido a que fue usado para varias otras funciones previo a ser entregado por la Universidad Automana Juan Misael Saracho de Tarija en 1964 para que finalmente sea utilizado para su proposito pretendido. La fachada del edificio es interesante y tien esculturas de trilobites y branquiopodos. El primer piso aloja remanentes de ceramicas, telas, puntas de flechas, calaveras y esqueletos ademas de cientos de articulos interesante que cuentan la historia humana y cultural de la region que ahora es Tarija<html>"
                            +"<html><p>La visitas a este lugar son de 8:00 a 12:00 por la mañana y a las 15:00 a 18:00 horas por la tarde. Considerar que solo se cobrara el consumo y transporte en el paquete.<p><html>"
                            );
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
