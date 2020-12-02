/*
 * 
 */
package modelo;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import metodosAgen.*;
import metodosAgen.PaqueteTuristico;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 * @author USUARIO
 */
public class XMLHistoriales {
    private static final String nomArchivo="historialesClients";
    private static final String pathAch="."+File.separator+"src"+File.separator+"modelo"+File.separator+"xmls"+File.separator;
    private static final File archivo=new File(pathAch+nomArchivo+".xml");
    public static void main(String[] args) {
        
    }
    
    public static void crearXML() throws Throwable{
        DocumentBuilderFactory factoria=DocumentBuilderFactory.newInstance();
        DocumentBuilder        builder= factoria.newDocumentBuilder();
        DOMImplementation implementa=builder.getDOMImplementation();
        Document               documento=implementa.createDocument(null,nomArchivo,null);
        documento.setXmlVersion("1.0");
        //se procede a generar el xml
        Source source=new DOMSource(documento);
        //como y donde se guardara
        Result result=new StreamResult(archivo);
        Transformer transforme=TransformerFactory.newInstance().newTransformer();
        transforme.transform(source, result);
    }
    //en esta parte se añaden todos los elementos de listAdims a el xml
    public static void modificarXML(List<Historial> listaHistoriales){
        
        if(!archivo.exists()){
            try{
                crearXML();
            }catch(Throwable e){
            }
        }else{}
            try {
                DocumentBuilderFactory facto=DocumentBuilderFactory.newInstance();
                DocumentBuilder        documentoBulider=facto.newDocumentBuilder();
                Document               document=documentoBulider.parse(archivo);
                document.getDocumentElement().normalize();
                Element raiz=document.getDocumentElement();
                //se recorre la lista de usuarios y se crea el xml con los elementos
                for(Historial hist:listaHistoriales){
                    Historial histo=hist;
                    Element nodoHistorial=document.createElement("Historial");
                    nodoHistorial.setAttribute("nroIdent", histo.getNroIdent()+"");
                    //creamos elementos para los datos del Historial
                    Element ultModNodo = document.createElement("Fecha Modificacion");
                    Text nodoValFecha=document.createTextNode(histo.getFechaModificacion()+"");
                    ultModNodo.appendChild(nodoValFecha);
                    
                    Element reservaNodo=document.createElement("Reserva");
                    Text nodoValReserva=document.createTextNode("");
                    reservaNodo.appendChild(nodoValReserva);
                    //aniado todo al histoial (paqueteCod,Reserva)
                    nodoHistorial.appendChild(ultModNodo);
                    nodoHistorial.appendChild(reservaNodo);
                    //aniado todo a la rais
                    raiz.appendChild(nodoHistorial);
                }
                //se genera el xml
                Source source=new DOMSource(document);
                //donde se guardara
                Result result=new StreamResult(archivo);
                Transformer transformer=TransformerFactory.newInstance().newTransformer();
                transformer.transform(source,result);
            } catch (Exception ex) {
                Logger.getLogger(XMLAdministradores.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static Historial buscarHistorial(int nroIdent){
        Historial hist=null;
        
        return hist;
    }
}
