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
        lblImgn1=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/Rurrenabaque/rurrenabaque-01.jpg")));
        lblImgn2=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/Rurrenabaque/rurrenabaque-02.jpg")));
        lblImgn3=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/Rurrenabaque/rurrenabaque-03.jpg")));
        lblImgn4=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/Rurrenabaque/rurrenabaque-04.jpg")));
        lblImgn5=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/Rurrenabaque/rurrenabaque-turismo.jpg")));

        pnlImgIzq.add(lblImgn1);
        pnlImgIzq.add(lblImgn2);
        pnlImgDer.add(lblImgn3);
        pnlImgDer.add(lblImgn4);
        pnlImgDer.add(lblImgn5);
        
    }
    private void integrInfo(){
        lblNombreLug=new JLabel("Rurrenabaque");
        lblUbic=new JLabel("<html>Contáctanos:<p> Av. Ayacucho entre Colombia y Ecuador <p>+591 62615493 <p>4 4446666 <p> Cochabamba-Bolivia<html>");
        lblDescrp=new JLabel("<html>El pequeño pueblo de Rurrenabaque es la puerta de entrada a una parte exuberante y emocionantemente hermosa del noroeste de Bolivia que ofrece una oportunidad para los turistas apasionados por apoyar los esfuerzos hacia la sostenibilidad y proteger las especies en peligro de extinción.<html><p>"
                + "<p><html>Bolivia acaba de ganar un premio al Mejor Destino Verde de World Travel Awards por sus esfuerzos para hacer que toda esta región, repleta de cascadas rugientes y vida silvestre rara, y hogar de muchos grupos indígenas, sea sostenible al lanzar programas para el ecoturismo.<p><p>Aquí los visitantes encontrarán Madidi,"
                + " una de las áreas protegidas con mayor biodiversidad del mundo, y Rhukanrhuka, un área de selva tropical y praderas naturales casi tan grandes como Yellowstone. En junio de 2019, el gobierno municipal de Reyes (en asociación con la Wildlife Conservation Society y Rainforest Trust) designó a Rhukanrhuka como un área protegida, "
                + "una que conservará los monos titi en peligro de extinción, los delfines rosados de río y otros animales salvajes raros.<p><html>");
        pnlNombL.add(lblNombreLug);
        pnlImgIzq.add(lblUbic);
        pnlDescrp.add(lblDescrp);
    }
    
    private void editColorEtiquets(){
        lblDescrp.setForeground(Color.WHITE);
        lblUbic.setForeground(Color.WHITE);
        lblNombreLug.setForeground(Color.WHITE);
        //se cambian tamaños
        lblDescrp.setFont(new Font("arial", Font.PLAIN, 18));
        lblUbic.setFont(new Font("arial", Font.PLAIN, 18));
        lblNombreLug.setFont(new Font("arial", Font.BOLD, 20));
    }
}