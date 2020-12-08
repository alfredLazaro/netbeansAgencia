/*
 *
 */
package modelo;

import Prinpal.IniciadorFechasFest;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
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
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 * @author Fred
 */
public class XMLFechasFestivas {
    private static final String nomArchivo="fechasFestivas";
    private static final String pathAch="."+File.separator+"src"+File.separator+"modelo"+File.separator+"xmls"+File.separator;
    private static final File archivo=new File(pathAch+nomArchivo+".xml");
    private static IniciadorFechasFest f;
    public static void main(String[] args) {
       XMLFechasFestivas f=new XMLFechasFestivas();
    }

    public XMLFechasFestivas() {
        f=new IniciadorFechasFest();
        List<Calendar> l=f.getFechasAct();
        try{
            modificarXML(l);
        }catch(Exception e){}
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
    //en esta parte se añaden todos los elementos de listFechas a el xml
    
    public static void modificarXML(List<Calendar> listFechas){
        
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
                for(Calendar fech:listFechas){
                    Calendar fecha=fech;
                    Element nodoFecha=document.createElement("Fecha");
                    Text nodoValorFecha=document.createTextNode(fecha+"");
                    nodoFecha.appendChild(nodoValorFecha);
                    //sepone la fecha en el nodoRaiz
                    raiz.appendChild(nodoFecha);
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
    public static Date buscarFechaFest(Date f){
        Date fechaFest=null;
        try{
        File archivo =new File(nomArchivo+".xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(archivo);
            System.out.println("Elemento raiz: " + document.getDocumentElement().getNodeName());
            document.getDocumentElement().normalize();
        
        NodeList listaE=document.getElementsByTagName("Fecha");
            for(int i=0;i<listaE.getLength();i++){
                Node nodo=listaE.item(i);
                System.out.println("Element: "+nodo.getNodeName());
                if(nodo.getNodeType()==Node.ELEMENT_NODE){
                    Element e=(Element) nodo;
                    String fechAct=e.getElementsByTagName("Fecha").item(0).getTextContent();
                    System.out.println(fechAct);
                    System.err.println("entrada "+f);
                    if(fechAct.equals(f)){
                        //fechaFest=(Date)fechAct;
                    }else{}
                }else{}
            }
        }catch(Exception e){
            
        }
        return fechaFest;
    }

}
