/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author USUARIO
 */
public class LugaresTiVistaDepart extends JFrame{
    private JPanel     pnlCentrLug,pnlComboLugars,pnLugar1,pnlugar2,pnLugar3,pnLugar4,pnlDesc1,pnlDesc2,pnlDesc3,pnlDesc4;
    private JComboBox  cbxListaDepart;
    private GridLayout lyImgDescrip1,lyImgDescrip2,lyImgDescrip3,lyImgDescrip4,lyLugares;
    private BorderLayout lyPrincipal;
    private BoxLayout  lyDes1,lyDes2,lyDes3,lyDes4; 
    private FlowLayout lyCombo;
    private JLabel     lblVacio;
    private JLabel     lblUbicac,lblImgRurren,lblImgRiberal,lblImgLagunS,lblImgLomaS;
    private JLabel     lblDescRurren,lblDescRiberal,lblDescLagunS,lblDescLomaS;
    private JButton    btnDetalR,btnDetalRi,btnDetalLagS,btnDetalLomS;
    public static void main(String[] args) {
        LugaresTiVistaDepart lgrs=new LugaresTiVistaDepart();
    }
    public LugaresTiVistaDepart() throws HeadlessException {
        setTitle("agencia De viajes (nombre agencia)");
        setSize(1080,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciar();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void iniciar(){
        iniciarPanels();
        //integramos las imagenes al iniciarPaneles
        integrInfo();
        editEtiquets();
    }
    
    private void iniciarPanels(){
        pnlCentrLug=new JPanel();
        pnlComboLugars=new JPanel();
        pnLugar1=new JPanel();
        pnlugar2=new JPanel();
        pnLugar3=new JPanel();
        pnLugar4=new JPanel();
        pnlDesc1=new JPanel();
        pnlDesc2=new JPanel();
        pnlDesc3=new JPanel();
        pnlDesc4=new JPanel();
        crearLayouts();
        integrLayouts();
        //se setean lo layouts
        /*
        pnlCentrLug
        pnlComboLugars
        pnlLugar1
        pnlugar2
        pnLugar3
        pnLugar4
        pnlDesc1
        pnlDesc2
        pnlDesc3
        pnlDesc4
        */
        //aniado los paneles en el jFrame
        add(pnlComboLugars,BorderLayout.NORTH);
        add(pnlCentrLug,BorderLayout.CENTER);
        
    }
    private void crearLayouts(){
        lyPrincipal=new BorderLayout();
        //layout titulo y combo box
        lyCombo=new FlowLayout();
        //grid pal
        lyLugares=new GridLayout(2,3);
        //grid para cuadros
        lyImgDescrip1=new GridLayout(0,2);
        lyImgDescrip2=new GridLayout(0,2);
        lyImgDescrip3=new GridLayout(0,2);
        lyImgDescrip4=new GridLayout(0,2);
        
        //box para descrip y boton
        lyDes1=new BoxLayout(pnlDesc1, BoxLayout.Y_AXIS);
        lyDes2=new BoxLayout(pnlDesc2, BoxLayout.Y_AXIS);
        lyDes3=new BoxLayout(pnlDesc3, BoxLayout.Y_AXIS);
        lyDes4=new BoxLayout(pnlDesc4, BoxLayout.Y_AXIS);        
        /*
        lyPrincipal
        //grid pal
        lyImgDescrip1
        lyImgDescrip2
        lyImgDescrip3
        lyImgDescrip4
        lyLugares
        //box para descrip y boton
        lyDes1
        lyDes2     
        lyDes3
        lyDes4
        */
        
    }
    private void integrLayouts(){
        setLayout(lyPrincipal);
        pnlCentrLug.setLayout(lyLugares);
        pnlComboLugars.setLayout(lyCombo);
        pnLugar1.setLayout(lyImgDescrip1);
        pnlugar2.setLayout(lyImgDescrip2);
        pnLugar3.setLayout(lyImgDescrip3);
        pnLugar4.setLayout(lyImgDescrip4);
        pnlDesc1.setLayout(lyDes1);
        pnlDesc2.setLayout(lyDes2);
        pnlDesc3.setLayout(lyDes3);
        pnlDesc4.setLayout(lyDes4);
        //integrar los paneles
        acomodarPaneles();
    }
    
    private void acomodarPaneles(){
        //primer colum
        // el label se pone vacio (lo estoy iniciando ahora)
        lblVacio=new JLabel();
        pnlCentrLug.add(lblVacio);
        pnlCentrLug.add(pnLugar1);
        pnlCentrLug.add(pnlugar2);
        //primer columna
        lblUbicac=new JLabel();
        pnlCentrLug.add(lblUbicac);
        pnlCentrLug.add(pnLugar3);
        pnlCentrLug.add(pnLugar4);
        //ahora ponemos las imagenes en la pirmera columna lgDescrp
        integrImgs();
        pnLugar1.add(pnlDesc1);
        pnlugar2.add(pnlDesc2);
        pnLugar3.add(pnlDesc3);
        pnLugar4.add(pnlDesc4);
        
    }
    
    private void integrImgs(){
        lblImgLagunS=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/laguna Suares/laguna-suarez.jpg")));
        lblImgLomaS=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/En los alrededores loma suares/20988956_340391276420779_537883119035747641_o.jpg")));
        lblImgRiberal=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/Riberalta/36641482_10156001175918705_7239783761049550848_n.jpg")));
        lblImgRurren=new JLabel(new ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/Rurrenabaque/rurrenabaque-01.jpg")));
        //se integran en la primera columna
        pnLugar1.add(lblImgLagunS);
        pnlugar2.add(lblImgLomaS);
        pnLugar3.add(lblImgRiberal);
        pnLugar4.add(lblImgRurren);
    }
    
    private void integrInfo(){
        lblUbicac.setText("<html>Contáctanos:<p> Av. Ayacucho entre Colombia y Ecuador <p>+591 62615493 <p>4 4446666 <p> Cochabamba-Bolivia<html>");
        lblDescLagunS=new JLabel("<html>Laguna Suares<p>"
                        + "<html>");
        lblDescLomaS=new JLabel("<html>Loma Suares<p>"
                + "<html>");
        lblDescRiberal=new JLabel("<html>Riberalta<p>"
                + "<html>");
        lblDescRurren=new JLabel("<html>Rurrenabaque<p>"
                + "<html>");
        //en aqui tambien se integran los infos
        pnlDesc1.add(lblDescLagunS);
        pnlDesc2.add(lblDescLomaS);
        pnlDesc3.add(lblDescRiberal);
        pnlDesc4.add(lblDescRurren);
        //se crean los botones
        creanBotons();
        //se aniaden los botones
        integrBtns();
    }
    
    private void creanBotons(){
        btnDetalLagS=new JButton("Descripcion");
        btnDetalLomS=new JButton("Descripcion");
        btnDetalR=new JButton("Descripcion");
        btnDetalRi=new JButton("Descripcion");
    }
    
    private void integrBtns(){
        pnlDesc1.add(btnDetalLagS);
        pnlDesc2.add(btnDetalLomS);
        pnlDesc3.add(btnDetalR);
        pnlDesc4.add(btnDetalRi);
    }
    private void editEtiquets(){
        
    }
    
}
