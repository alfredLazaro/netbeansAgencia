
package vista.lugaresDespripcion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
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
    private BoxLayout    layIzq,layCentro,layDer;
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
        //se integran todos los paneles en el jFrame
        add(pnlNombL,BorderLayout.NORTH);
        add(pnlImgIzq,BorderLayout.WEST);
        add(pnlDescrp,BorderLayout.CENTER);
        add(pnlImgDer,BorderLayout.EAST);
    }
    
    private void iniciarLayouts(){
        layPrinc=new BorderLayout();
        layNomb=new FlowLayout();
        layIzq=new BoxLayout(pnlImgIzq,BoxLayout.Y_AXIS);
        layCentro=new BoxLayout(pnlDescrp,BoxLayout.Y_AXIS);
        layDer=new BoxLayout(pnlImgDer, BoxLayout.Y_AXIS);

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
        
        pnlImgIzq.add(lblImgn1);
        pnlImgIzq.add(lblImgn2);
        pnlImgIzq.add(lblImgn3);
        pnlImgDer.add(lblImgn4);
    }
    private void integrInfo(){
        lblNombreLug=new JLabel("Loma Suares");
        lblUbic=new JLabel("<html><html>");
        lblDescrp=new JLabel("<html>Loma Suárez es una localidad de Bolivia, perteneciente al municipio de Trinidad en la provincia de Cercado en el Departamento del Beni. Se encuentra a 12 km de la ciudad de Trinidad, la capital departamental, a orillas del Río Ibare, que es un afluente del río Mamoré. A la localidad se llega por una carretera asfaltada que sale de Trinidad hacia el noroeste, pasando por el Aeropuerto Teniente Jorge Henrich Arauz.<p>Cuenta con una población de 886 habitantes (según el Censo INE 2012),1? y está a una altura de 159 msnm. Forma parte del Distrito Municipal 9 del área rural de Trinidad.<html>");
        pnlNombL.add(lblNombreLug);
        pnlDescrp.add(lblDescrp);
    }
    
}
