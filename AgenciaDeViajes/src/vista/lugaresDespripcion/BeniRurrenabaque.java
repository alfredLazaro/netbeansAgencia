/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.lugaresDespripcion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author USUARIO
 */
public class BeniRurrenabaque extends JFrame{
    JPanel panel=new JPanel();
    public static void main(String[] args) {
        BeniRurrenabaque b=new BeniRurrenabaque();
    }
    public BeniRurrenabaque() throws HeadlessException {
        setTitle("Descripcion");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1080, 800);
        add(panel);
        inicializar();
        setVisible(true);
        
    }
    
    public void inicializar(){
        iniciarPanel();
        integrarImagenes();
        panel.repaint();
        //panel.revalidate();
    }
    
    private void iniciarPanel(){
        BorderLayout disenio=new BorderLayout();
        panel.setBackground(new Color(32, 112, 193));
        panel.setLayout(disenio);
    }
    private void integrarImagenes(){
        JLabel rurrenaba=new JLabel();
        
        //rurrenaba.setLocation(60, 60);
        
        ImageIcon imagen=new ImageIcon("."+File.separator+"src"+File.separator+"vista"+File.separator+"lugareTuristicos"+File.separator+"Beni"+File.separator+"Rurrenabaque"+File.separator+"rurrenabaque-01.jpg");
        Image img=imagen.getImage();
        
        ImageIcon imag=new ImageIcon(img.getScaledInstance(900, 650,Image.SCALE_DEFAULT));
        rurrenaba.setIcon(imag);
        if(imag!=null){
        System.out.println("se encontro en icono" );
        rurrenaba.repaint();
        }else{
            System.out.println("no se encontro la imagen");
        }
        //Imagen img=new Imagen("."+File.separator+"src"+File.separator+"vista"+File.separator+"lugareTuristicos"+File.separator+"Beni"+File.separator+"Rurrenabaque"+File.separator+"rurrenabaque-02.jpg");
        //if(img!=null){System.out.println("se encontro");}else{System.out.println("la imagen no esta");}
        JLabel descripcion=new JLabel("esta es la despripcion de rrurenabaque");
        descripcion.setLocation(200, 200);
        panel.add(rurrenaba,BorderLayout.CENTER);
        panel.add(descripcion,BorderLayout.NORTH);
    }
    private void dibujar(String path){
        
    }
    
}
