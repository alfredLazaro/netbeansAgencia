
package modelo;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import metodosAgen.*;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
public class XMLAdministradores {
    private static final String nomArchivo="cuentaAdministradores";
    private static final String pathAch="."+File.separator+"src"+File.separator+"modelo"+File.separator+"xmls"+File.separator;
    private static final File archivo=new File(pathAch+nomArchivo+".xml");
    public static void main(String[] args) {
        List<Administrador> listAdmins=new ArrayList<>();
        Administrador admin1=new Administrador("agente45", "67531896");
        Administrador admin2=new Administrador("alan","62615493");
        Administrador admin3=new Administrador("eduardo","67566104");
        Administrador admin4=new Administrador("gabriel","70392999");
        listAdmins.add(admin1);
        listAdmins.add(admin2);
        listAdmins.add(admin3);
        listAdmins.add(admin4);
        try{
            //una ves llamamos a este metodo se crea a la vez si es que no existe
            modificarXML(listAdmins);
        }catch(Throwable e){
            
        }
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
    public static void modificarXML(List<Administrador> listaAdministradores){
        
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
                for(Administrador admin:listaAdministradores){
                    Administrador admi=admin;
                    Element nodoUsuario=document.createElement("Usuario");
                    //creamos elementos para los datos del administrador
                    Element nombreNodo = document.createElement("Nombre");
                    Text nodoValorNombre=document.createTextNode(admi.getNombreCuenta());
                    nombreNodo.appendChild(nodoValorNombre);
                    
                    Element contraNodo=document.createElement("Contraseña");
                    Text nodoValorContrasenia=document.createTextNode(admi.getContrasenia());
                    contraNodo.appendChild(nodoValorContrasenia);
                    nodoUsuario.appendChild(nombreNodo);
                    nodoUsuario.appendChild(contraNodo);
                    raiz.appendChild(nodoUsuario);
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
    public static Administrador buscarAdmin(){
        Administrador admin=null;
        
        return admin;
    }
    
    public static void eliminarAdmin(String nomb,String contraseña){
        
    }
}
