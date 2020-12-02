/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
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
    public static void modificarXML(List<Cliente> listaClientes,String departamento){
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
                //se recorre la lista de clientes y se crea el xml con los elementos
                for(Cliente client:listaClientes){
                    Cliente clien=client;
                    Element nodoCliente=document.createElement("Cliente");
                    //creamos elementos para los datos del cliente
                    Element nombreNodo = document.createElement("Nombre");
                    Text nodoValorNombre=document.createTextNode(clien.getNombreCliente());
                    nombreNodo.appendChild(nodoValorNombre);
                    
                    Element contraNodo=document.createElement("TemporadaPreferida");
                    Text nodoValorContrasenia=document.createTextNode(clien.getTemporadaPreferencia());
                    contraNodo.appendChild(nodoValorContrasenia);
                    nodoCliente.appendChild(nombreNodo);
                    //nodoUsuario.appendChild(contraNodo);
                    raiz.appendChild(nodoCliente);
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
    
    public static void agregarLugarTuris(){}
    public static void eliminarLugarXML(){
        
    }
    public static ArrayList<LugaresTuristicos> listaLugares(){
        ArrayList<LugaresTuristicos> listLugars=new ArrayList<>();
        return listLugars;
    }
}
