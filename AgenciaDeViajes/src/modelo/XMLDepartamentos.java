/*
 * 
 */
package modelo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
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
import metodosAgen.PaqueteTuristico;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

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
                    
                    Element nodoDepart=document.createElement("Departamento");
                    
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
                    while(j<codigos.size()){
                    int codPaq=codigos.get(j);
                    Element codPaqNodo=document.createElement("codigPaq");
                    Text nodoValorCodig=document.createTextNode(codPaq+"");
                    codPaqNodo.appendChild(nodoValorCodig);
                    nodoLugar.appendChild(codPaqNodo);
                    
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
    
    public static void iniciarDepartXML(ArrayList<String> listaDepart){
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
                for(String departamento:listaDepart){
                    
                    Element nodoDepart=document.createElement("Departamento");
                    
                    Element nomDepaNodo=document.createElement("NombreDepartamento");
                    Text    nodoValorND=document.createTextNode(departamento);
                    nomDepaNodo.appendChild(nodoValorND);
                    
                    nodoDepart.appendChild(nomDepaNodo);
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
        boolean colocado=false;
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
                NodeList departamentos=document.getElementsByTagName("Departamento");
                for(int i=0;i<departamentos.getLength()&& !colocado;i++){
                    Node nodo=departamentos.item(i);
                    if(nodo.getNodeType()==Node.ELEMENT_NODE){
                        Element departamentoNodo=(Element) nodo;
                        String nombreDepartamento=departamentoNodo.getElementsByTagName("NombreDepartamento").item(0).getTextContent();
                        if(nombreDepartamento.equals(depart)){
                            Element nodoLugar=document.createElement("LugarTuristico");
                            //creamos elementos para los datos del cliente
                            Element nombreNodo = document.createElement("NombreLugar");
                            Text nodoValorNombre=document.createTextNode(lugarT);
                            nombreNodo.appendChild(nodoValorNombre);
                    
                            nodoLugar.appendChild(nombreNodo);
                            //se recorre la lista de codigos 
                    
                    
                            while(j<codigos.size()){
                                int codPaq=codigos.get(j);
                                Element codPaqNodo=document.createElement("codigPaq");
                                Text nodoValorCodig=document.createTextNode(codPaq+"");
                                codPaqNodo.appendChild(nodoValorCodig);
                                nodoLugar.appendChild(codPaqNodo);
                                j=j+1;
                            }
                            departamentoNodo.appendChild(nodoLugar);
                            //la proxima vez no deberia crear departamentos repetidos
                            colocado=true;
                        }
                    }
                }
                    
                    
                    //raiz.appendChild(nodoDepart);
                
                //se genera el xml
                Source source=new DOMSource(document);
                //donde se guardara
                Result result=new StreamResult(archivo);
                Transformer transformer=TransformerFactory.newInstance().newTransformer();
                transformer.transform(source,result);
            }catch(Throwable e){}
    }
    
    public static void eliminarLugarXML(String lugarT,String nombDepart){
        
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
                
                NodeList departamentos=document.getElementsByTagName("Departamento");
                for(int i=0;i<departamentos.getLength();i++){
                    Node nodo=departamentos.item(i);
                    if(nodo.getNodeType()==Node.ELEMENT_NODE){
                        Element departamento=(Element) nodo;
                        String nombreDepart=departamento.getElementsByTagName("NombreDepartamento").item(0).getTextContent();
                        if(nombreDepart.equals(nombDepart)){
                            NodeList lugaresT=departamento.getElementsByTagName("LugarTuristico");
                            for(int j=0;j<lugaresT.getLength();j++){
                                Node nodoL=lugaresT.item(j);
                                if(nodoL.getNodeType()==Node.ELEMENT_NODE){
                                    Element lugar=(Element) nodoL;
                                    String nombLug=lugar.getElementsByTagName("NombreLugar").item(0).getTextContent();
                                    if(nombLug.equals(lugarT)){
                                        lugar.getParentNode().removeChild(lugar);
                                    }else{}
                                }
                            }
                        }else{}
                    }
                }
                
                //se genera el xml
                Source source=new DOMSource(document);
                //donde se guardara
                Result result=new StreamResult(archivo);
                Transformer transformer=TransformerFactory.newInstance().newTransformer();
                transformer.transform(source,result);
            }catch(Throwable e){}
    }
    
    public static ArrayList<String> listaLugares(String nombDepart){
        ArrayList<String> listLugars=new ArrayList<>();
        if(!archivo.exists()){
            try{
                crearXML();
            }catch(Throwable e){
            }
        }else{}
        try{
            DocumentBuilderFactory facto=DocumentBuilderFactory.newInstance();
            DocumentBuilder        documentoBulider=facto.newDocumentBuilder();
            Document               document=documentoBulider.parse(archivo);
            document.getDocumentElement().normalize();
                
            NodeList departamentos=document.getElementsByTagName("Departamento");
            for(int i=0;i<departamentos.getLength();i++){
                Node nodo=departamentos.item(i);
                    if(nodo.getNodeType()==Node.ELEMENT_NODE){
                        Element departamento=(Element) nodo;
                        String nombreDepart=departamento.getElementsByTagName("NombreDepartamento").item(0).getTextContent();
                        if(nombreDepart.equals(nombDepart)){
                            NodeList lugaresT=departamento.getElementsByTagName("LugarTuristico");
                            for(int j=0;j<lugaresT.getLength();j++){
                                Node nodoL=lugaresT.item(j);
                                if(nodoL.getNodeType()==Node.ELEMENT_NODE){
                                    Element lugar=(Element) nodoL;
                                    String nombLug=lugar.getElementsByTagName("NombreLugar").item(0).getTextContent();
                                    listLugars.add(nombLug);
                                }
                            }
                        }else{}
                    }
                }
                
                //se genera el xml
                Source source=new DOMSource(document);
                //donde se guardara
                Result result=new StreamResult(archivo);
                Transformer transformer=TransformerFactory.newInstance().newTransformer();
                transformer.transform(source,result);
        }catch(Throwable e){}
        return listLugars;
    }
    
    public static HashMap<String,HashMap<String,ArrayList<PaqueteTuristico>>> lugaresDepart(){
        HashMap<String,HashMap<String,ArrayList<PaqueteTuristico>>> lugrs=new HashMap<>();
        HashMap<String,ArrayList<PaqueteTuristico>> list=new HashMap<>();
        ArrayList<PaqueteTuristico> listPa=new ArrayList<>();
        if(!archivo.exists()){
            try{
                crearXML();
            }catch(Throwable e){
            }
        }else{}
        try{
            DocumentBuilderFactory facto=DocumentBuilderFactory.newInstance();
            DocumentBuilder        documentoBulider=facto.newDocumentBuilder();
            Document               document=documentoBulider.parse(archivo);
            document.getDocumentElement().normalize();
                
            NodeList departamentos=document.getElementsByTagName("Departamento");
            for(int i=0;i<departamentos.getLength();i++){
                Node nodo=departamentos.item(i);
                    if(nodo.getNodeType()==Node.ELEMENT_NODE){
                        Element departamento=(Element) nodo;
                        String nombreDepart=departamento.getElementsByTagName("NombreDepartamento").item(0).getTextContent();
                        
                            NodeList lugaresT=departamento.getElementsByTagName("LugarTuristico");
                            for(int j=0;j<lugaresT.getLength();j++){
                                Node nodoL=lugaresT.item(j);
                                if(nodoL.getNodeType()==Node.ELEMENT_NODE){
                                    Element lugar=(Element) nodoL;
                                    String nombLug=lugar.getElementsByTagName("NombreLugar").item(0).getTextContent();
                                    
                                        NodeList codPaq=lugar.getElementsByTagName("codigPac");
                                        for(int k=0;k<codPaq.getLength();k++){
                                            Node codigPaquet=codPaq.item(k);
                                            if(codigPaquet.getNodeType()==Node.ELEMENT_NODE){
                                                Element codig=(Element) codigPaquet;
                                                int codPaque=Integer.parseInt(codig.getElementsByTagName("codigPac").item(0).getTextContent());
                                                PaqueteTuristico p=XMLPaquetes.buscarPaquet(codPaque);
                                                listPa.add(p);
                                            }
                                        }
                                        list.put(nombLug, listPa);
                                    
                                }
                            }
                        lugrs.put(nombreDepart, list);
                    }
                }
                
                //se genera el xml
                Source source=new DOMSource(document);
                //donde se guardara
                Result result=new StreamResult(archivo);
                Transformer transformer=TransformerFactory.newInstance().newTransformer();
                transformer.transform(source,result);
        }catch(Throwable e){}
        listPa=XMLPaquetes.paquetes();
        
        return lugrs;
    }
    
    public static HashMap<String,ArrayList<PaqueteTuristico>> HashPaquetes1Lug(String lugarT){
        HashMap<String,ArrayList<PaqueteTuristico>> list=new HashMap<>();
        ArrayList<PaqueteTuristico> listPa=new ArrayList<>();
        boolean encontrado=false;
        if(!archivo.exists()){
            try{
                crearXML();
            }catch(Throwable e){
            }
        }else{}
        try{
            DocumentBuilderFactory facto=DocumentBuilderFactory.newInstance();
            DocumentBuilder        documentoBulider=facto.newDocumentBuilder();
            Document               document=documentoBulider.parse(archivo);
            document.getDocumentElement().normalize();
                
            NodeList departamentos=document.getElementsByTagName("Departamento");
            for(int i=0;i<departamentos.getLength()&& !encontrado;i++){
                Node nodo=departamentos.item(i);
                    if(nodo.getNodeType()==Node.ELEMENT_NODE){
                        Element departamento=(Element) nodo;
                        String nombreDepart=departamento.getElementsByTagName("NombreDepartamento").item(0).getTextContent();
                        
                            NodeList lugaresT=departamento.getElementsByTagName("LugarTuristico");
                            for(int j=0;j<lugaresT.getLength()&& !encontrado;j++){
                                Node nodoL=lugaresT.item(j);
                                if(nodoL.getNodeType()==Node.ELEMENT_NODE){
                                    Element lugar=(Element) nodoL;
                                    String nombLug=lugar.getElementsByTagName("NombreLugar").item(0).getTextContent();
                                    if(nombLug.equals(lugarT)){
                                        encontrado=true;
                                        NodeList codPaq=lugar.getElementsByTagName("codigPac");
                                        for(int k=0;k<codPaq.getLength();k++){
                                            Node codigPaquet=codPaq.item(k);
                                            if(codigPaquet.getNodeType()==Node.ELEMENT_NODE){
                                                Element codig=(Element) codigPaquet;
                                                int codPaque=Integer.parseInt(codig.getElementsByTagName("codigPac").item(0).getTextContent());
                                                PaqueteTuristico p=XMLPaquetes.buscarPaquet(codPaque);
                                                listPa.add(p);
                                            }
                                        }
                                        list.put(nombLug, listPa);
                                    }else{}
                                }
                            }
                        
                    }
                }
                
                //se genera el xml
                Source source=new DOMSource(document);
                //donde se guardara
                Result result=new StreamResult(archivo);
                Transformer transformer=TransformerFactory.newInstance().newTransformer();
                transformer.transform(source,result);
        }catch(Throwable e){}
        listPa=XMLPaquetes.paquetes();
        
        return list;
    }
    
    public static HashMap<String,ArrayList<PaqueteTuristico>> HashPaquetesLugrs(){
        HashMap<String,ArrayList<PaqueteTuristico>> list=new HashMap<>();
        ArrayList<PaqueteTuristico> listPa=new ArrayList<>();
        if(!archivo.exists()){
            try{
                crearXML();
            }catch(Throwable e){
            }
        }else{}
        try{
            DocumentBuilderFactory facto=DocumentBuilderFactory.newInstance();
            DocumentBuilder        documentoBulider=facto.newDocumentBuilder();
            Document               document=documentoBulider.parse(archivo);
            document.getDocumentElement().normalize();
                
            NodeList departamentos=document.getElementsByTagName("Departamento");
            for(int i=0;i<departamentos.getLength();i++){
                Node nodo=departamentos.item(i);
                    if(nodo.getNodeType()==Node.ELEMENT_NODE){
                        Element departamento=(Element) nodo;
                        String nombreDepart=departamento.getElementsByTagName("NombreDepartamento").item(0).getTextContent();
                        
                            NodeList lugaresT=departamento.getElementsByTagName("LugarTuristico");
                            for(int j=0;j<lugaresT.getLength();j++){
                                Node nodoL=lugaresT.item(j);
                                if(nodoL.getNodeType()==Node.ELEMENT_NODE){
                                    Element lugar=(Element) nodoL;
                                    String nombLug=lugar.getElementsByTagName("NombreLugar").item(0).getTextContent();
                                    
                                        NodeList codPaq=lugar.getElementsByTagName("codigPaq");
                                        int codPaque;
                                        for(int k=0;k<codPaq.getLength();k++){
                                            Node codigPaquet=codPaq.item(k);
                                            if(codigPaquet.getNodeType()==Node.ELEMENT_NODE){
                                                Element codig=(Element) codigPaquet;
                                                codPaque=Integer.parseInt(codig.getElementsByTagName("codigPaq").item(0).getTextContent());
                                                PaqueteTuristico p=XMLPaquetes.buscarPaquet(codPaque);
                                                listPa.add(p);
                                            }
                                        }
                                        list.put(nombLug, listPa);
                                    
                                }
                            }
                        
                    }
                }
                
                //se genera el xml
                Source source=new DOMSource(document);
                //donde se guardara
                Result result=new StreamResult(archivo);
                Transformer transformer=TransformerFactory.newInstance().newTransformer();
                transformer.transform(source,result);
        }catch(Throwable e){
            System.out.println("algo no se obtuvo bien en XMLDepartamentos Hashpaquetes lugares");
        }
        //listPa=XMLPaquetes.paquetes();
        
        return list;
    }
    
    public static void insertPaqLugar(String lugarT,PaqueteTuristico pac){
        boolean colocado=false;
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
                NodeList departamentos=document.getElementsByTagName("Departamento");
                for(int i=0;i<departamentos.getLength()&& !colocado;i++){
                    Node nodo=departamentos.item(i);
                    if(nodo.getNodeType()==Node.ELEMENT_NODE){
                        Element departamentoNodo=(Element) nodo;
                        NodeList lugares=departamentoNodo.getElementsByTagName("LugarTuristico");
                        for(int j=0;j<lugares.getLength() && !colocado;j++){
                            Node nodo1=lugares.item(j);
                            if(nodo1.getNodeType()==Node.ELEMENT_NODE){
                                Element lugarNodo=(Element) nodo1;
                                String nombreLugar=lugarNodo.getElementsByTagName("NombreLugar").item(0).getTextContent();
                                if(nombreLugar.equals(lugarT)){
                                    int codPaq= pac.getNroIde();
                                    Element codPaqNodo=document.createElement("codigPaq");
                                    Text nodoValorCodig=document.createTextNode(codPaq+"");
                                    codPaqNodo.appendChild(nodoValorCodig);
                                    lugarNodo.appendChild(codPaqNodo);
                                    XMLPaquetes.insertPaquet(pac);
                            //departamentoNodo.appendChild(nodoLugar);
                            //la proxima vez no deberia crear departamentos repetidos
                            colocado=true;
                                }
                            }
                        }
                        
                        
                    }
                }
                    
                    
                    //raiz.appendChild(nodoDepart);
                
                //se genera el xml
                Source source=new DOMSource(document);
                //donde se guardara
                Result result=new StreamResult(archivo);
                Transformer transformer=TransformerFactory.newInstance().newTransformer();
                transformer.transform(source,result);
            }catch(Throwable e){}
    }
}
