
package Prinpal;
import java.util.Calendar;
import java.util.List;
import  metodosAgen.*;
/**
 *
 * @author Fred
 */
public class IniciadorHistoriales {
    Historial   hist1,hist2;
    IniciadorFechasFest f;
    public static void main(String[] args) {
        IniciadorHistoriales i=new IniciadorHistoriales();
    }
    
    public IniciadorHistoriales() {
        f=new IniciadorFechasFest();
        imprimF();
    }
    
    public void imprimF(){
       List<Calendar> fechas=f.getFechasAct();
        for(Calendar c:fechas){
            System.out.println("fecha"+ c.toString());
        }
    }        
}
