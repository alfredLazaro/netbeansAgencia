/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.lugaresDespripcion;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author USUARIO
 */
public class Imagen extends JPanel{
    private String ruta;

    public Imagen(String ruta) {
        this.ruta = ruta;
        this.setSize(300, 200);
        
    }
    
    @Override
        public void paint(Graphics g){
        Dimension tam=getSize();
        ImageIcon imag=new ImageIcon(ruta);
        g.drawImage(imag.getImage(),tam.width, tam.height, null);
        setOpaque(false);
        super.paint(g);
        
        }
}
