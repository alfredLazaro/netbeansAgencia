/*
 * 
 */
package modelo;

import java.io.File;
import java.util.ArrayList;
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
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import vista.LugaresTuristicos;

/**
 * @author USUARIO
 */
public class XMLDepartamentos {
    private static final String nomArchivo="departamentsLugaresTuris";
    private static final String pathAch="."+File.separator+"src"+File.separator+"modelo"+File.separator+"xmls"+File.separator;
    private static final File archivo=new File(pathAch+nomArchivo+".xml");
    
    public static void main(String[] args) {
        
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
        Result result=new StreamResult(archivo);
        Transformer transforme=TransformerFactory.newInstance().newTransformer();
        transforme.transform(source, result);
    }
    //los lugares turisticos se llenaran por departamento
    public static void modificarXML(List<String> listaLugares,String departamento,ArrayList<Integer> codigos){
        int j,k;
        j=0;
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
                //se recorre la lista de lugares
                for(String lugar:listaLugares){
                    
                    Element nodoDepart=document.createElement("Departament");
                    Element nomDepaNodo=document.createElement("NombreDepartamento");
                    Text    nodoValorND=document.createTextNode(departamento);
                    nomDepaNodo.appendChild(nodoValorND);
                    Element nodoLugar=document.createElement("LugarTuristico");
                    //creamos elementos para los datos del cliente
                    Element nombreNodo = document.createElement("NombreLugar");
                    Text nodoValorNombre=document.createTextNode(lugar);
                    nombreNodo.appendChild(nodoValorNombre);
                    
                    nodoLugar.appendChild(nombreNodo);
                    //se recorre la lista de codigos 
                    
                    k=0;
                    while(k<3 &&j<codigos.size()){
                    int codPaq=codigos.get(j);
                    Element codPaqNodo=document.createElement("codigPaq");
                    Text nodoValorCodig=document.createTextNode(codPaq+"");
                    codPaqNodo.appendChild(nodoValorCodig);
                    nodoLugar.appendChild(codPaqNodo);
                    k=k+1;
                    j=j+1;
                    }
                    nodoDepart.appendChild(nomDepaNodo);
                    nodoDepart.appendChild(nodoLugar);
                    
                    raiz.appendChild(nodoDepart);
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
    
    public static void agregarLugarTuris(String lugarT,String depart,ArrayList<Integer> codigos){
        int j,k;
        j=0;
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
                Element nodoDepart=document.createElement("Departament");
                    Element nomDepaNodo=document.createElement("NombreDepartamento");
                    Text    nodoValorND=document.createTextNode(depart);
                    nomDepaNodo.appendChild(nodoValorND);
                    Element nodoLugar=document.createElement("LugarTuristico");
                    //creamos elementos para los datos del cliente
                    Element nombreNodo = document.createElement("NombreLugar");
                    Text nodoValorNombre=document.createTextNode(lugarT);
                    nombreNodo.appendChild(nodoValorNombre);
                    
                    nodoLugar.appendChild(nombreNodo);
                    //se recorre la lista de codigos 
                    
                    k=0;
                    while(k<3 &&j<codigos.size()){
                    int codPaq=codigos.get(j);
                    Element codPaqNodo=document.createElement("codigPaq");
                    Text nodoValorCodig=document.createTextNode(codPaq+"");
                    codPaqNodo.appendChild(nodoValorCodig);
                    nodoLugar.appendChild(codPaqNodo);
                    k=k+1;
                    j=j+1;
                    }
                    nodoDepart.appendChild(nomDepaNodo);
                    nodoDepart.appendChild(nodoLugar);
                    
                    raiz.appendChild(nodoDepart);
                
                //se genera el xml
                Source source=new DOMSource(document);
                //donde se guardara
                Result result=new StreamResult(archivo);
                Transformer transformer=TransformerFactory.newInstance().newTransformer();
                transformer.transform(source,result);
            }catch(Throwable e){}
    }
    public static void eliminarLugarXML(){
        
    }
    
    public static ArrayList<LugaresTuristicos> listaLugares(){
        ArrayList<LugaresTuristicos> listLugars=new ArrayList<>();
        
        return listLugars;
    }
    
}
