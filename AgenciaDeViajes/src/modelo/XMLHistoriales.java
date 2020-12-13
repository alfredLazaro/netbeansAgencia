/*
 * 
 */
package modelo;

import java.io.File;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
                    Element ultModNodo = document.createElement("FechaModificacion");
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
        ArrayList<Reserva> reservas=new ArrayList<>();
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
                    int codig=Integer.parseInt(e.getAttribute("nroIdentida"));
                    if(codig==nroIdent){
                        String fechM=e.getElementsByTagName("FechaModificacion").item(0).getTextContent();
                        String estadoR=e.getElementsByTagName("estado").item(0).getTextContent();
                        NodeList reservs=e.getElementsByTagName("Reserva");
                        Date fechaModificacion=null;
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
                                String fechRes=reserv.getElementsByTagName("fechaReserva").item(0).getTextContent();
                                //datos Clientes
                                Cliente c=XMLClientes.buscarClient(nroIdent);
                                String nombC=c.getNombreCliente();
                                //comvertir String a date eso me falta
                                SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
                                Date fechaId=null;
                                Date fechaV=null;
                                Date fechReserv=null;
                                    fechaId=formatoFecha.parse(fechaIda);
                                    fechaV=formatoFecha.parse(fechaVu);
                                    fechReserv=formatoFecha.parse(fechRes);
                                    
                                Pasaje pasaje=new Pasaje(origen, destino, fechaId, fechaV,nombC, tipTrans, nombEmp, precio);
                                Reserva r=new Reserva(null, pasaje, c,fechReserv);
                                r.setEstadoReserva(estadoR);
                                reservas.add(r);
                            }else{}
                            
                        }
                        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
                        
                        fechaModificacion=formatoFecha.parse(fechM);//el formato
                        hist=new Historial(nroIdent, fechaModificacion);
                        hist.setReservas(reservas);
                    }else{}
                    
                }else{}
            }
            //se genera el xml
                Source source=new DOMSource(document);
                //donde se guardara
                Result result=new StreamResult(archivo);
                Transformer transformer=TransformerFactory.newInstance().newTransformer();
                transformer.transform(source,result);
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
                nodoHistorial.setAttribute("nroIdentida", h.getNroIdent()+"");
                
                Element ultModNodo = document.createElement("FechaModificacion");
                Text nodoValFecha=document.createTextNode(h.getFechaModificacion().getDate()+"/"+h.getFechaModificacion().getMonth()+"/"+(h.getFechaModificacion().getYear()+1900)+"");
                ultModNodo.appendChild(nodoValFecha);
                
                List<Reserva> reservs=h.getReservas();
                //ya que no hay nada en reserva 
                for(Reserva r:reservs){
                Element reservaNodo=document.createElement("Reserva");
                Element fechResNodo=document.createElement("fechaReserva");
                Text nodoValFechR=document.createTextNode(r.getFechaReserva()+"");
                fechResNodo.appendChild(nodoValFechR);
                
                Element estadRNodo=document.createElement("estado");
                Text nodoValEstd=document.createTextNode(r.getFechaReserva().getDate()+"/"+r.getFechaReserva().getMonth()+"/"+(r.getFechaReserva().getYear()+1900)+"");
                estadRNodo.appendChild(nodoValEstd);
                
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
                
                reservaNodo.appendChild(reservaNodo);
                reservaNodo.appendChild(fechResNodo);
                reservaNodo.appendChild(pasajeNodo);
                reservaNodo.appendChild(codigPaquetNodo);
                
                nodoHistorial.appendChild(reservaNodo);
                }
                //aniado todo al histoial (paqueteCod,Reserva)
                nodoHistorial.appendChild(ultModNodo);
                
                
                //aniado todo a la rais
                raiz.appendChild(nodoHistorial);
                Source source=new DOMSource(document);
                //donde se guardara
                Result result=new StreamResult(archivo);
                Transformer transformer=TransformerFactory.newInstance().newTransformer();
                transformer.transform(source,result);
        }catch(Exception e){}
    }
    
    //para aniadir Reserva 
    public static void aniadirReserv(Reserva r,int codClient){
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
                
                NodeList historiales=document.getElementsByTagName("Historial");
                for(int i=0;i<historiales.getLength();i++){
                    Node nodo=historiales.item(i);
                    if(nodo.getNodeType()==Node.ELEMENT_NODE){
                        Element historialNodo=(Element) nodo;
                        int codHisto=Integer.parseInt(historialNodo.getElementsByTagName("Reserva").item(0).getTextContent());
                        if(codHisto==codClient){
                            
                            Element reservaNodo=document.createElement("Reserva");
                            
                            Element fechResNodo=document.createElement("fechaReserva");
                            Text nodoValFechR=document.createTextNode(r.getFechaReserva().getDate()+"/"+r.getFechaReserva().getMonth()+"/"+(r.getFechaReserva().getYear()+1900)+"");
                            fechResNodo.appendChild(nodoValFechR);
                            
                            Element estadRNodo=document.createElement("estado");
                            Text nodoValEstd=document.createTextNode(r.getFechaReserva().getDate()+"/"+r.getFechaReserva().getMonth()+"/"+(r.getFechaReserva().getYear()+1900)+"");
                            estadRNodo.appendChild(nodoValEstd);
                            //se llena el pasaje
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
                            Text    nodoValorFeI=document.createTextNode(r.getPasaje().getFechaIda().getDate()+"/"+r.getPasaje().getFechaIda().getMonth()+"/"+(r.getPasaje().getFechaIda().getYear()+1900)+"");
                            fechaIdNodo.appendChild(nodoValorFeI);
                
                            Element fechaVueltNodo=document.createElement("fechaVuelta");
                            Text    nodoValorFeV=document.createTextNode(r.getPasaje().getFechaVuelta().getDate()+"/"+r.getPasaje().getFechaVuelta().getMonth()+"/"+(r.getPasaje().getFechaVuelta().getYear()+1900)+"");
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
                            
                            reservaNodo.appendChild(estadRNodo);
                            reservaNodo.appendChild(fechResNodo);
                            reservaNodo.appendChild(pasajeNodo);
                            
                            Element codigPaquetNodo=document.createElement("nroIde");
                            Text    nodoValorNI=document.createTextNode(r.getPaquete().getNroIde()+"");
                            codigPaquetNodo.appendChild(nodoValorNI);
                            reservaNodo.appendChild(codigPaquetNodo);
                            
                            //se aniade la reserva al Historial determinado
                            historialNodo.appendChild(reservaNodo);
                            
                        }
                        //aniado todo a la rais
                       //raiz.appendChild(historialNodo); 
                    }
                }
                //aniado todo al histoial (paqueteCod,Reserva)
                //nodoHistorial.appendChild(ultModNodo);
                
                Source source=new DOMSource(document);
                //donde se guardara
                Result result=new StreamResult(archivo);
                Transformer transformer=TransformerFactory.newInstance().newTransformer();
                transformer.transform(source,result);
        }catch(Throwable e){
        }
    }
    
    public static void eliminarHistorial(int nroId){
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
                    int codig=Integer.parseInt(e.getAttribute("nroIdentida"));
                    if(codig==nroId){
                        e.getParentNode().removeChild(e);
                    }
                }
            }
            
            Source source=new DOMSource(document);
            //donde se guardara
            Result result=new StreamResult(archivo);
            Transformer transformer=TransformerFactory.newInstance().newTransformer();
            transformer.transform(source,result);
        }catch(Throwable e){
        }
    }
    
    public static void cambioEstadReserva(int cod,String estado){
        int ultElem;
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
                    int codig=Integer.parseInt(e.getAttribute("nroIdentida"));
                    if(codig==cod){
                        String fechM=e.getElementsByTagName("FechaModificacion").item(0).getTextContent();
                        NodeList reservs=e.getElementsByTagName("Reserva");
                        //se tomara el ultimo elemento
                        ultElem=reservs.getLength()-1;
                        Node reserv=e.getElementsByTagName("Reserva").item(ultElem);
                        if(reserv.getNodeType()==Node.ELEMENT_NODE){
                            Element reser=(Element)reserv;
                            //tomamo su nodo estado directamente
                            reser.getElementsByTagName("estado").item(0).setTextContent(estado);
                        }
                        
                    }else{}
                    
                }else{}
            }
            //se genera el xml
                Source source=new DOMSource(document);
                //donde se guardara
                Result result=new StreamResult(archivo);
                Transformer transformer=TransformerFactory.newInstance().newTransformer();
                transformer.transform(source,result);
        }catch(Throwable e){
        }
    }
    
    public static void insertPasaje(Pasaje p){
        
    }
}
