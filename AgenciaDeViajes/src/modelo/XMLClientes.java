/*
 * orgullosamente creado por fred 
 */
package modelo;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import metodosAgen.*;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
public class XMLClientes {
    private static final String nomArchivo="clientes";
    public static void main(String[] args) {
        List<Cliente> listaClientes=new ArrayList<>();
        Cliente cliente1=new Cliente("rebeca ",3,"verano","vacaciones",12345);
        //PaqueteTuristico paquet1=new PaqueteTuristico(transporte, hotel, restaurant, 0);
        //Reserva reserva1=new Reserva(paquete, pasaje, cliente1, fechaReserva);
        
    }
    public static void crearXML() throws Exception{
        DocumentBuilderFactory fabriDoc=DocumentBuilderFactory.newInstance();
        DocumentBuilder         buider=fabriDoc.newDocumentBuilder();
        DOMImplementation      implementacion=buider.getDOMImplementation();
        Document               documento=implementacion.createDocument(null, nomArchivo, null);
        documento.setXmlVersion("1.0");
        //se procede a generar el xml
        Source source=new DOMSource(documento);
        //como y donde se guardara
        Result result=new StreamResult(new java.io.File(nomArchivo+".xml"));
        Transformer transforme=TransformerFactory.newInstance().newTransformer();
        transforme.transform(source, result);
    }
    
    public static void modificarXML(){
        
    }
    
    public static void eliminarClienteXML(Cliente cliente){
    }
    public static ArrayList<Cliente> listaClientes(){
        ArrayList<Cliente> listClientes=new ArrayList<>();
        return listClientes;
    }
}
