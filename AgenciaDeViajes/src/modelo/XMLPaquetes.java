/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
public class XMLPaquetes {
    private static final String nomArchivo="paquetes";
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
    public static void modificarXML(List<PaqueteTuristico> listaPaquetes){
        
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
                for(PaqueteTuristico paquet:listaPaquetes){
                    PaqueteTuristico pac=paquet;
                    Element nodoPaquete=document.createElement("Paquete");
                    nodoPaquete.setAttribute("nroIde",pac.getNroIde()+"");
                    //creamos elementos para los datos del administrador
                    Element precioNodo = document.createElement("precio");
                    Text nodoValorPrecio=document.createTextNode(pac.getPrecio()+"");
                    precioNodo.appendChild(nodoValorPrecio);
                    
                    Element cantDiasNodo=document.createElement("CantDias");
                    Text nodoValorCantDias=document.createTextNode(pac.getCantDias()+"");
                    cantDiasNodo.appendChild(nodoValorCantDias);
                    //en aqui create los elementos de paquete Transporte,Hotel,Restaurante
                    //transporte
                    Element transporteNodo=document.createElement("Transporte");
                    //restaurante
                    Element restautanNodo=document.createElement("Restarurante");
                    //Hotel
                    Element hotelNodo=document.createElement("Hotel");
                    //se aniaden los nodos al nodo del paquete
                    nodoPaquete.appendChild(precioNodo);
                    nodoPaquete.appendChild(cantDiasNodo);
                    raiz.appendChild(nodoPaquete);
                    
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
}
