
package modelo;


import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import metodosAgen.*;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
public class XMLAdministradores {
    private static final String nomArchivo="cuentaAdministradores";
    
    public static void main(String[] args) {
        ArrayList<Administrador> listAdmins=new ArrayList<>();
        Administrador admin1=new Administrador("agente45", "67534321");
        try{
            crearXML();
        }catch(Throwable e){
            
        }
    }
    
    public static void crearXML() throws Throwable{
        DocumentBuilderFactory factoria=DocumentBuilderFactory.newInstance();
        DocumentBuilder        builder= factoria.newDocumentBuilder();
        DOMImplementation implementa=builder.getDOMImplementation();
        Document               documento=implementa.createDocument(null, nomArchivo, null);
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
}
