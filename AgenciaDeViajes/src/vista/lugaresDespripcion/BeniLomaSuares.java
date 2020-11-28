
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


public class BeniLomaSuares extends JFrame{
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
        BeniLomaSuares loma=new BeniLomaSuares();
    }
    
    public BeniLomaSuares() throws HeadlessException {
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
        lblImgn1=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/En los alrededores loma suares/20988956_340391276420779_537883119035747641_o.jpg")));
        
        lblImgn2=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/En los alrededores loma suares/21013756_340391366420770_3143082636704307240_o.jpg")));
        lblImgn3=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/En los alrededores loma suares/21014119_340391336420773_8228696373368701066_o.jpg")));
        lblImgn4=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/En los alrededores loma suares/21056110_340391299754110_5827872536623495583_o.jpg")));
        lblImgn5=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/En los alrededores loma suares/download.jpg")));

        pnlImgIzq.add(lblImgn1);
        pnlImgIzq.add(lblImgn2);
        pnlImgDer.add(lblImgn3);
        pnlImgDer.add(lblImgn4);
        pnlImgDer.add(lblImgn5);
    }
    private void integrInfo(){
        lblNombreLug=new JLabel("Loma Suares");
        lblUbic=new JLabel("<html>Contáctanos:<p> Av. Ayacucho entre Colombia y Ecuador <p>+591 62615493 <p>4 4446666 <p> Cochabamba-Bolivia<html>");
        //el <html> es salto de linea automatico el <p> es salto de linea controlado
        lblDescrp=new JLabel("<html>Loma Suárez es una localidad de Bolivia, perteneciente al municipio de Trinidad en la provincia de Cercado en el Departamento del Beni. Se encuentra a 12 km de la ciudad de Trinidad, la capital departamental, a orillas del Río Ibare, que es un afluente del río Mamoré.<p><html>"
                            + "<html><p>A la localidad se llega por una carretera asfaltada que sale de Trinidad hacia el noroeste, pasando por el Aeropuerto Teniente Jorge Henrich Arauz.<p>Cuenta con una población de 886 habitantes (según el Censo INE 2012),1? y está a una altura de 159 msnm. Forma parte del Distrito Municipal 9 del área rural de Trinidad.<p><html>"
                            +"<html><p>La Loma Suárez forma parte de un complejo de lomas artificiales que se encuentran a lo largo del río Ibare, cuya construcción cuenta de una loma grande, una loma mediana y una pequeña. La loma grande abarca la actual Escuela de Sargentos de la Armada Boliviana, las cuatro calles principales aledañas a la Plaza Rómulo Suárez, la unidad educativa de la comunidad, la iglesia y algunas casas de personas civiles que viven en el lugar. Encima de esta loma se encuentra la loma mediana de dimensiones aproximadas 80 por 80 metros y que constituye la base para la loma pequeña, esta última siendo un promontorio donde se encuentra el mausoleo de Rómulo Suárez. El pueblo ha sido declarado Patriomonio Cultural Departamental del departamento del Beni.<p><html>"
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
