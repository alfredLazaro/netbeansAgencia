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
 * @author USUARIO
 */
public class BeniLagunaSuares extends JFrame {
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
        BeniLagunaSuares prue=new BeniLagunaSuares();
    }
    
    public BeniLagunaSuares() throws HeadlessException {
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
        lblImgn1=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/laguna Suares/laguna-suarez.jpg")));
        lblImgn2=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/laguna Suares/photo0jpg.jpg")));
        lblImgn3=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/laguna Suares/photo1jpg.jpg")));
        lblImgn4=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/laguna Suares/photo3jpg.jpg")));
        lblImgn5=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/laguna Suares/phg.jpg")));
        pnlImgIzq.add(lblImgn1);
        pnlImgIzq.add(lblImgn2);
        pnlImgDer.add(lblImgn3);
        pnlImgDer.add(lblImgn4);
        pnlImgDer.add(lblImgn5);
    }
    private void integrInfo(){
        lblNombreLug=new JLabel("Laguna Suares");
        lblUbic=new JLabel("<html>Contáctanos:<p> Av. Ayacucho entre Colombia y Ecuador <p>+591 62615493 <p>4 4446666 <p> Cochabamba-Bolivia<html>");
        
        lblDescrp=new JLabel("<html><p>La laguna Suárez es una laguna artificial amazónica de agua dulce, ubicada a 5 km de la ciudad de Trinidad, en la provincia de Cercado del departamento del Beni, Bolivia. Tiene unas dimensiones de 4,4 km de largo por 1,8 km de ancho y una superficie de 6 km², es un importante centro turístico de la ciudad.<p><html>"
                            +"<html><p>Sorprendente<p><html>"
                            +"<html><p>La temperatura tibia del agua y el suelo de arena , que masajeaba la planta de los pies , aunque tambien hay piscinas artificiales alrededor y restaurante y chiringuitos para comer y beber, nada masificado y alquiler de motos acuaticas.<p><html>"
                            +"<html><p>Es una laguna artificial, que fué construida por la antigua civilización Paititiana que la llamó Socoreno (Laguna de Animales), actualmente tiene el nombre de Laguna Suárez, debido a que fué adquirida por la firma Suárez Hnos., que tiene hermosa vista natural, lo que le da un enorme interés turístico. La Laguna Suárez es un excelente lugar para los amantes de los deportes acuáticos, pero también para quienes disfrutan de un descanso o caminata contemplando la flora y la fauna oriental. En el lugar existen muchas aves. <p><html>"
                            +"<html><p><p><html>"
                            +"<html><p><p><html>"
                            +"<html><p><p><html>"
                            +"<html><p><p><html>"
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
