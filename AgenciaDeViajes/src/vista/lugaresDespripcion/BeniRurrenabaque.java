/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.lugaresDespripcion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author USUARIO
 */
public class BeniRurrenabaque extends JFrame{
    private JPanel pDescrip=new JPanel();
    private BorderLayout miBordL=new BorderLayout(10,10);
    private PanelImagenes pImagens;
    
    public static void main(String[] args) {
        BeniRurrenabaque b=new BeniRurrenabaque();
    }
    public BeniRurrenabaque() throws HeadlessException {
        setTitle("Descripcion");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1080, 800);
        setLayout(miBordL);
        setBackground(new Color(32, 112, 193));
        inicializar();
        
        setVisible(true);
        
    }
    
    public void inicializar(){
        iniciarPaneles();
        initDescripciones();
        //panel.revalidate();
    }
    
    private void iniciarPaneles(){
        //inicio el panel de imagenes en norte
        pImagens=new PanelImagenes(1, 4);
        add(pImagens,BorderLayout.NORTH);
        pImagens.repaint();
        //inicio panel con Descripcion en centro        
        pDescrip.setLayout(new BoxLayout(pDescrip,BoxLayout.Y_AXIS));
        add(pDescrip,BorderLayout.CENTER);
        pImagens.setBackground(new Color(32, 112, 193));
        pDescrip.setBackground(new Color(32, 112, 193));
        
    }
    
    private void initDescripciones(){
        JLabel lbDescripcion=new JLabel("<html>El pequeño pueblo de Rurrenabaque es la puerta de entrada a una parte exuberante y emocionantemente hermosa del noroeste de Bolivia que ofrece una oportunidad para los turistas apasionados por apoyar los esfuerzos  hacia la sostenibilidad y proteger las especies en peligro de extinción.<html>");
        lbDescripcion.setHorizontalAlignment(JLabel.CENTER);
        lbDescripcion.setFont(new Font("arial",Font.PLAIN, 20));
        JLabel lbDescripcion2=new JLabel("<html>Bolivia acaba de ganar un premio al Mejor Destino Verde de World Travel Awards por sus esfuerzos para hacer que toda esta región, repleta de cascadas rugientes y vida silvestre rara, y hogar de muchos grupos indígenas, sea sostenible al lanzar programas para el ecoturismo.<html>");
        pDescrip.add(lbDescripcion);
        pDescrip.add(lbDescripcion2);
    }
}
class PanelImagenes extends JPanel{
    private GridLayout gridImagenes;
    private int col;
    private int fil;
    public PanelImagenes(int fils,int colum){
        col=colum;
        fil=fils;
        gridImagenes=new GridLayout(fil, col, 15, 50);
        this.setLayout(gridImagenes);
        integrarImagenes();
        setVisible(true);
    }
    private void integrarImagenes(){
        JLabel rurrenaba=new JLabel();
        JLabel rurre2=new JLabel();
        JLabel rurre3=new JLabel();
        JLabel rurre4=new JLabel();
        /*ImageIcon imagen=new ImageIcon("."+File.separator+"src"+File.separator+"vista"+File.separator+"lugareTuristicos"+File.separator+"Beni"+File.separator+"Rurrenabaque"+File.separator+"rurrenabaque-01.jpg");
        Image img=imagen.getImage();
        ImageIcon imag=new ImageIcon(img.getScaledInstance(900, 650,Image.SCALE_DEFAULT));
        */
        
        //el path separator no estaba sirviendo para lectura 
        rurrenaba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/Rurrenabaque/rurrenabaque-01.jpg")));
        rurre2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/Rurrenabaque/rurrenabaque-02.jpg")));
        rurre3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/Rurrenabaque/rurrenabaque-03.jpg")));
        rurre4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/LugaresTuristicos/Beni/Rurrenabaque/rurrenabaque-04.jpg")));
        add(rurrenaba);
        add(rurre2);
        add(rurre3);
        add(rurre4);
        
    }
}