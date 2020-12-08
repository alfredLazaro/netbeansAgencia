/*
 * 
 */
package modelo;

import java.io.File;
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
import metodosAgen.*;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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
            NodeList   historiales=document.getElementsByTagName("Historial");
            for(int i=0;i<historiales.getLength();i++){
                Node nodo=historiales.item(i);
                if(nodo.getNodeType()==Node.ELEMENT_NODE){
                    Element e=(Element) nodo;
                    int codig=Integer.parseInt(e.getAttribute("nroIdent"));
                    if(codig==nroIdent){
                        String fech=e.getElementsByTagName("Fecha Modificacion").item(0).getTextContent();
                        NodeList reservs=e.getElementsByTagName("Reserva");
                        for(int j=0;j<reservs.getLength();j++){
                            Node nod=reservs.item(j);
                            if(nod.getNodeType()==Node.ELEMENT_NODE){
                                Element reserv=(Element) nod;
                                String origen=reserv.getElementsByTagName("origen").item(0).getTextContent();
                                String destino=reserv.getElementsByTagName("destino").item(0).getTextContent();
                                int precio=Integer.parseInt(reserv.getElementsByTagName("precio").item(0).getTextContent());
                                String fechaIda=reserv.getElementsByTagName("fechaIda").item(0).getTextContent();
                                String fechaVu=reserv.getElementsByTagName("fechaVuelta").item(0).getTextContent();
                                String tipTrans=reserv.getElementsByTagName("tipoTransporte").item(0).getTextContent();
                                String nombEmp=reserv.getElementsByTagName("nombreEmpresa").item(0).getTextContent();
                                //comvertir String a date eso me falta
                                
                                //Pasaje pasaje=new Pasaje(origen, destino, fechaIda, fechaVu, nomArchivo, tipTrans, nombEmp, precio);
                                //Reserva r=new Reserva(null, pasaje, null, null);
                            }else{}
                            
                        }
                    }else{}
                    
                }else{}
            }
        }catch(Throwable e){
        }
        
        return hist;
    }
    //incrementar el numero de historiales cuando se cree un nuevo cliente
    public static void aniadirHisto(int codigClient){
        Historial h=new Historial(codigClient, new Date());
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
                Element raiz=document.getDocumentElement();
                
                Element nodoHistorial=document.createElement("Historial");
                nodoHistorial.setAttribute("nroIdent", codigClient+"");
                
                Element ultModNodo = document.createElement("Fecha Modificacion");
                Text nodoValFecha=document.createTextNode(h.getFechaModificacion()+"");
                ultModNodo.appendChild(nodoValFecha);
                
                List<Reserva> reservs=h.getReservas();
                for(Reserva r:reservs){
                Element reservaNodo=document.createElement("Reserva");
                
                Element pasajeNodo=document.createElement("Pasaje");
                
                Element origenPasajeNodo=document.createElement("origen");
                Text nodoValOrigen=document.createTextNode(r.getPasaje().getOrigen());
                origenPasajeNodo.appendChild(nodoValOrigen);
                
                Element destiPaNodo=document.createElement("destino");
                Text nodoValDest=document.createTextNode(r.getPasaje().getDestino());
                destiPaNodo.appendChild(nodoValDest);
                
                Element precioTotNodo=document.createElement("precio");
                Text    nodoValPrecio=document.createTextNode(r.getPasaje().getPrecioTotal()+"");
                precioTotNodo.appendChild(nodoValPrecio);
                
                Element fechaIdNodo=document.createElement("fechaIda");
                Text    nodoValorFeI=document.createTextNode(r.getPasaje().getFechaIda()+"");
                fechaIdNodo.appendChild(nodoValorFeI);
                
                Element fechaVueltNodo=document.createElement("fechaVuelta");
                Text    nodoValorFeV=document.createTextNode(r.getPasaje().getFechaVuelta()+"");
                fechaVueltNodo.appendChild(nodoValorFeV);
                
                Element tipTNodo=document.createElement("tipoTransporte");
                Text    nodoValorTT=document.createTextNode(r.getPasaje().getTipoTransporte());
                tipTNodo.appendChild(nodoValorTT);
                
                Element nomEmpNodo=document.createElement("nombreEmpresa");
                Text    nodoValorNE=document.createTextNode(r.getPasaje().getEmpresa());
                nomEmpNodo.appendChild(nodoValorNE);
                
                pasajeNodo.appendChild(origenPasajeNodo);
                pasajeNodo.appendChild(destiPaNodo);
                pasajeNodo.appendChild(precioTotNodo);
                pasajeNodo.appendChild(fechaIdNodo);
                pasajeNodo.appendChild(fechaVueltNodo);
                pasajeNodo.appendChild(tipTNodo);
                pasajeNodo.appendChild(nomEmpNodo);
                
                Element codigPaquetNodo=document.createElement("nroIde");
                Text    nodoValorNI=document.createTextNode(r.getPaquete().getNroIde()+"");
                codigPaquetNodo.appendChild(nodoValorNI);
                
                reservaNodo.appendChild(pasajeNodo);
                reservaNodo.appendChild(codigPaquetNodo);
                
                nodoHistorial.appendChild(reservaNodo);
                }
                //aniado todo al histoial (paqueteCod,Reserva)
                nodoHistorial.appendChild(ultModNodo);
                
                
                //aniado todo a la rais
                raiz.appendChild(nodoHistorial);
        }catch(Exception e){}
    }
    
    //para aniadir Reserva se hace desde Agencia
    public static void aniadirReserv(Reserva r,int codClient){
        
    }
}
