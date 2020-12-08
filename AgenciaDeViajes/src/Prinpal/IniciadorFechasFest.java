/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prinpal;

import java.util.Calendar;
import java.util.List;
import java.util.Date;
import java.util.GregorianCalendar;
import modelo.*;
/**
 *
 * @author USUARIO
 */
public class IniciadorFechasFest {
    private static List<Calendar> fechasAct;
    private static Calendar       c1;
    private static Calendar       c2;
    public IniciadorFechasFest(){
        crearFechas();
    }
    private static void crearFechas(){
        c1=new GregorianCalendar(2020,Calendar.DECEMBER, 25);
        //me doy cuenta de que fue reemplasado con calendar.set
        c2=new GregorianCalendar(2020,Calendar.JANUARY, 1);
        //System.out.println("f "+ c1);
        fechasAct.add(c1);
        fechasAct.add(c2);
    }
    private static void iniciarFechas(Calendar f){
        fechasAct.add(f);
    }
    private void fechas(){
        //XMLFechasFestivas.buscarFechaFest(fechasAct.get(1));
    }
    private void inicializarXML(){
        XMLFechasFestivas f=new XMLFechasFestivas();
    }

    public List<Calendar> getFechasAct() {
        return fechasAct;
    }
    
}
