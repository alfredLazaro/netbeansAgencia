/*
 * 
 */
package modelo;

import Prinpal.IniciadorPaquete;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
public class XMLPaquetes {
    private static final String nomArchivo="paquetes";
    private static final String pathAch="."+File.separator+"src"+File.separator+"modelo"+File.separator+"xmls"+File.separator;
    private static final File archivo=new File(pathAch+nomArchivo+".xml");
    public static void main(String[] args) {
        IniciadorPaquete paq=new IniciadorPaquete();
        ArrayList<PaqueteTuristico> pa=paq.getP();
        try{
            modificarXML(pa);
        }catch(Throwable e){}
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
                    Text nodoValorPrecio=document.createTextNode(String.valueOf(pac.getPrecio()));
                    precioNodo.appendChild(nodoValorPrecio);
                    
                    Element cantDiasNodo=document.createElement("CantDias");
                    Text nodoValorCantDias=document.createTextNode(pac.getCantDias()+"");
                    cantDiasNodo.appendChild(nodoValorCantDias);
                    //en aqui create los elementos de paquete Transporte,Hotel,Restaurante
                    //transporte
                    Element transporteNodo=document.createElement("Transporte");
                    
                    Element tipoVehicNodo=document.createElement("TipoVehiculo");
                    Text    nodoValorTipo=document.createTextNode(pac.getTransporte().getTipoTransporte());
                    tipoVehicNodo.appendChild(nodoValorTipo);
                    
                    Element origenNodo=document.createElement("origen");
                    Text    nodoValorOrigen=document.createTextNode(pac.getTransporte().getOrigen());
                    origenNodo.appendChild(nodoValorOrigen);
                    
                    Element preciNodo=document.createElement("precioTranspor");
                    Text    nodoValorPrecioT=document.createTextNode(pac.getTransporte().getPrecio()+"");
                    preciNodo.appendChild(nodoValorPrecioT);
                    
                    //aniado los nodos de el transporte
                    transporteNodo.appendChild(tipoVehicNodo);
                    transporteNodo.appendChild(origenNodo);
                    transporteNodo.appendChild(preciNodo);
                    //restaurante en su nodo tendra nombre
                    Element restauranNodo=document.createElement("Restaurante");
                    Element nombRestNodo=document.createElement("NombreRestaurante");
                    Text    nodoValorNomR=document.createTextNode(pac.getRestaurant().getNombreRest());
                    nombRestNodo.appendChild(nodoValorNomR);
                    
                    Element ubicRestauraNodo=document.createElement("UbicacionRestaurante");
                    Text    nodoValorUbic=document.createTextNode(pac.getRestaurant().getUbicacion());
                    ubicRestauraNodo.appendChild(nodoValorUbic);
                    //se pone los nodos en restaurant
                    restauranNodo.appendChild(nombRestNodo);
                    restauranNodo.appendChild(ubicRestauraNodo);
                    //se obitiene su lista de comidas
                    List<Comida> comidas=pac.getRestaurant().getMenu();
                    
                    for(Comida comid:comidas){
                        Comida com=comid;
                        //lista de comidas para cada restaurante
                        Element comidaNodo=document.createElement("comida");
                        
                        Element nombComidaNodo=document.createElement("nombreComida");
                        Text    nodoValorComida=document.createTextNode(com.getPlato());
                        nombComidaNodo.appendChild(nodoValorComida);
                        
                        Element precioPlatNodo=document.createElement("precioPlato");
                        Text    nodoValorPrecComid=document.createTextNode(com.getPrecio()+"");
                        precioPlatNodo.appendChild(nodoValorPrecComid);
                        //se aniade el plato de comida
                        comidaNodo.appendChild(nombComidaNodo);
                        comidaNodo.appendChild(precioPlatNodo);
                        //se aniade la comida en el restaurante
                        restauranNodo.appendChild(comidaNodo);
                    }
                    //Hotel
                    Element hotelNodo=document.createElement("Hotel");
                    Element nomHotelNodo=document.createElement("NombreHotel");
                    Text    nodoValorNHot=document.createTextNode(pac.getHotel().getNombre());
                    nomHotelNodo.appendChild(nodoValorNHot);
                    
                    Element ubicHoNodo=document.createElement("ubicacionHotel");
                    Text    nodoValorUbicH=document.createTextNode(pac.getHotel().getUbicacion());
                    ubicHoNodo.appendChild(nodoValorUbicH);
                    
                    Element preciUnHNodo=document.createElement("PrecioUnitarioHotel");
                    Text    nodoValorPrUnHot=document.createTextNode(pac.getHotel().getPrecioUnitario()+"");
                    preciUnHNodo.appendChild(nodoValorPrUnHot);
                    
                    Element cantHDNodo=document.createElement("cantidadHabitaciones");
                    Text    nodoValorCantHD=document.createTextNode(pac.getHotel().getCantHabitacionesHabilitadas()+"");
                    cantHDNodo.appendChild(nodoValorCantHD);
                    
                    Element cantHUNodo=document.createElement("cantidadHUsadas");
                    Text    nodoValorCantHU=document.createTextNode(pac.getHotel().getCantHabitacionesUsadas()+"");
                    cantHUNodo.appendChild(nodoValorCantHU);
                    //se aniaden los nodos a hotel
                    hotelNodo.appendChild(nomHotelNodo);
                    hotelNodo.appendChild(ubicHoNodo);
                    hotelNodo.appendChild(preciUnHNodo);
                    hotelNodo.appendChild(cantHDNodo);
                    hotelNodo.appendChild(cantHUNodo);
                    //se aniaden los nodos al nodo del paquete
                    nodoPaquete.appendChild(precioNodo);
                    nodoPaquete.appendChild(cantDiasNodo);
                    nodoPaquete.appendChild(transporteNodo);
                    nodoPaquete.appendChild(restauranNodo);
                    nodoPaquete.appendChild(hotelNodo);
                    //se aniaden los Paquetes en la rais
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
    
    
    public static PaqueteTuristico buscarPaquet(int nroPaq){
        PaqueteTuristico p=null;
        boolean bb=false;
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
            NodeList   paquetes=document.getElementsByTagName("Paquete");
            //atributos del paquete
            String precioPaq;
            int    cantDiasPaq;
            for(int i=0;i<paquetes.getLength() && !bb;i++){
                Node nodo=paquetes.item(i);
                if(nodo.getNodeType()==Node.ELEMENT_NODE){
                    Element paquete=(Element) nodo;
                    int nroId=Integer.parseInt(paquete.getAttribute("nroIde"));
                    if(nroPaq==nroId){
                        bb=true; //se cambio el estado a encontrado
                        precioPaq=paquete.getElementsByTagName("precio").item(0).getTextContent();
                        cantDiasPaq=Integer.parseInt(paquete.getElementsByTagName("CantDias").item(0).getTextContent());
                        //transporte 
                        Node transp=paquete.getElementsByTagName("Transporte").item(0);
                        Transporte tra=null;
                        if(transp.getNodeType()==Node.ELEMENT_NODE){
                            Element trans=(Element) transp;
                            String tipoVehic=trans.getElementsByTagName("TipoVehiculo").item(0).getTextContent();
                            String orig=trans.getElementsByTagName("origen").item(0).getTextContent();
                            int preciT=Integer.parseInt(trans.getElementsByTagName("precioTranspor").item(0).getTextContent());
                            tra=new Transporte(preciT, orig, tipoVehic);
                        }
                        //Restaurante
                        Node restau=paquete.getElementsByTagName("Restaurante").item(0);
                        Restaurante rest=null;
                        String nombrR=null;
                        String ubicR=null;
                        ArrayList<Comida> menuR=new ArrayList<>();
                        Comida c=null;
                        if(restau.getNodeType()==Node.ELEMENT_NODE){
                            Element re=(Element) restau;
                            nombrR=re.getElementsByTagName("NombreRestaurante").item(0).getTextContent();
                            ubicR=re.getElementsByTagName("UbicacionRestaurante").item(0).getTextContent();
                            rest=new Restaurante(ubicR,nombrR);
                            NodeList menu=re.getElementsByTagName("comida");
                            //se lista el menu
                            
                            for(int j=0;j<menu.getLength();j++){
                                Node nodo1=menu.item(j);
                                
                                if(nodo1.getNodeType()==Node.ELEMENT_NODE){
                                    Element comida=(Element) nodo1;
                                    
                                    String nbCom=comida.getElementsByTagName("nombreComida").item(0).getTextContent();
                                    int preCo=Integer.parseInt(comida.getElementsByTagName("precioPlato").item(0).getTextContent());
                                    c=new Comida(nbCom, preCo);
                                    rest.agregarPlato(c);
                                }
                            }
                        }

                        //Hotel
                        Node hot=paquete.getElementsByTagName("Hotel").item(0);
                        Hotel h=null;
                        String nombrHotel=null;
                        String ubHote=null;
                        int preciH=0;
                        int cantHabit=0;
                        int cantHabUsa=0;
                        if(hot.getNodeType()==Node.ELEMENT_NODE){
                            Element hote=(Element) hot;
                            nombrHotel=hote.getElementsByTagName("NombreHotel").item(0).getTextContent();
                            ubHote=hote.getElementsByTagName("ubicacionHotel").item(0).getTextContent();
                            preciH=Integer.parseInt(hote.getElementsByTagName("PrecioUnitarioHotel").item(0).getTextContent());
                            cantHabit=Integer.parseInt(hote.getElementsByTagName("cantidadHabitaciones").item(0).getTextContent());
                            cantHabUsa=Integer.parseInt(hote.getElementsByTagName("cantidadHUsadas").item(0).getTextContent());
                            
                            h=new Hotel(preciH, ubHote, nombrHotel);
                            h.setCantHabitacionesHabilitadas(cantHabit);
                            h.setCantHabitacionesUsadas(cantHabUsa);
                        }
                        //se aniade todo al paquete
                        p=new PaqueteTuristico(tra, h, rest, cantDiasPaq);
                    }
                }
            }
        }catch(Throwable e){
        
        }
        return p;
    }
    
    public static void insertPaquet(PaqueteTuristico pac){
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
                
                Element nodoPaquete=document.createElement("Paquete");
                    nodoPaquete.setAttribute("nroIde",pac.getNroIde()+"");
                    //creamos elementos para los datos del administrador
                    Element precioNodo = document.createElement("precio");
                    Text nodoValorPrecio=document.createTextNode(String.valueOf(pac.getPrecio()));
                    precioNodo.appendChild(nodoValorPrecio);
                    
                    Element cantDiasNodo=document.createElement("CantDias");
                    Text nodoValorCantDias=document.createTextNode(pac.getCantDias()+"");
                    cantDiasNodo.appendChild(nodoValorCantDias);
                    //en aqui create los elementos de paquete Transporte,Hotel,Restaurante
                    //transporte
                    Element transporteNodo=document.createElement("Transporte");
                    
                    Element tipoVehicNodo=document.createElement("TipoVehiculo");
                    Text    nodoValorTipo=document.createTextNode(pac.getTransporte().getTipoTransporte());
                    tipoVehicNodo.appendChild(nodoValorTipo);
                    
                    Element origenNodo=document.createElement("origen");
                    Text    nodoValorOrigen=document.createTextNode(pac.getTransporte().getOrigen());
                    origenNodo.appendChild(nodoValorOrigen);
                    
                    Element preciNodo=document.createElement("precioTranspor");
                    Text    nodoValorPrecioT=document.createTextNode(pac.getTransporte().getPrecio()+"");
                    preciNodo.appendChild(nodoValorPrecioT);
                    
                    //aniado los nodos de el transporte
                    transporteNodo.appendChild(tipoVehicNodo);
                    transporteNodo.appendChild(origenNodo);
                    transporteNodo.appendChild(preciNodo);
                    //restaurante en su nodo tendra nombre
                    Element restauranNodo=document.createElement("Restaurante");
                    Element nombRestNodo=document.createElement("NombreRestaurante");
                    Text    nodoValorNomR=document.createTextNode(pac.getRestaurant().getNombreRest());
                    nombRestNodo.appendChild(nodoValorNomR);
                    
                    Element ubicRestauraNodo=document.createElement("UbicacionRestaurante");
                    Text    nodoValorUbic=document.createTextNode(pac.getRestaurant().getUbicacion());
                    ubicRestauraNodo.appendChild(nodoValorUbic);
                    //se pone los nodos en restaurant
                    restauranNodo.appendChild(nombRestNodo);
                    restauranNodo.appendChild(ubicRestauraNodo);
                    //se obitiene su lista de comidas
                    List<Comida> comidas=pac.getRestaurant().getMenu();
                    
                    for(Comida comid:comidas){
                        Comida com=comid;
                        //lista de comidas para cada restaurante
                        Element comidaNodo=document.createElement("comida");
                        
                        Element nombComidaNodo=document.createElement("nombreComida");
                        Text    nodoValorComida=document.createTextNode(com.getPlato());
                        nombComidaNodo.appendChild(nodoValorComida);
                        
                        Element precioPlatNodo=document.createElement("precioPlato");
                        Text    nodoValorPrecComid=document.createTextNode(com.getPrecio()+"");
                        precioPlatNodo.appendChild(nodoValorPrecComid);
                        //se aniade el plato de comida
                        comidaNodo.appendChild(nombComidaNodo);
                        comidaNodo.appendChild(precioPlatNodo);
                        //se aniade la comida en el restaurante
                        restauranNodo.appendChild(comidaNodo);
                    }
                    //Hotel
                    Element hotelNodo=document.createElement("Hotel");
                    Element nomHotelNodo=document.createElement("NombreHotel");
                    Text    nodoValorNHot=document.createTextNode(pac.getHotel().getNombre());
                    nomHotelNodo.appendChild(nodoValorNHot);
                    
                    Element ubicHoNodo=document.createElement("ubicacionHotel");
                    Text    nodoValorUbicH=document.createTextNode(pac.getHotel().getUbicacion());
                    ubicHoNodo.appendChild(nodoValorUbicH);
                    
                    Element preciUnHNodo=document.createElement("PrecioUnitarioHotel");
                    Text    nodoValorPrUnHot=document.createTextNode(pac.getHotel().getPrecioUnitario()+"");
                    preciUnHNodo.appendChild(nodoValorPrUnHot);
                    
                    Element cantHDNodo=document.createElement("cantidadHabitaciones");
                    Text    nodoValorCantHD=document.createTextNode(pac.getHotel().getCantHabitacionesHabilitadas()+"");
                    cantHDNodo.appendChild(nodoValorCantHD);
                    
                    Element cantHUNodo=document.createElement("cantidadHUsadas");
                    Text    nodoValorCantHU=document.createTextNode(pac.getHotel().getCantHabitacionesUsadas()+"");
                    cantHUNodo.appendChild(nodoValorCantHU);
                    //se aniaden los nodos a hotel
                    hotelNodo.appendChild(nomHotelNodo);
                    hotelNodo.appendChild(ubicHoNodo);
                    hotelNodo.appendChild(preciUnHNodo);
                    hotelNodo.appendChild(cantHDNodo);
                    hotelNodo.appendChild(cantHUNodo);
                    //se aniaden los nodos al nodo del paquete
                    nodoPaquete.appendChild(precioNodo);
                    nodoPaquete.appendChild(cantDiasNodo);
                    nodoPaquete.appendChild(transporteNodo);
                    nodoPaquete.appendChild(restauranNodo);
                    nodoPaquete.appendChild(hotelNodo);
                    //se aniaden los Paquetes en la rais
                    raiz.appendChild(nodoPaquete);
                    
                    Source source=new DOMSource(document);
                //donde se guardara
                Result result=new StreamResult(archivo);
                Transformer transformer=TransformerFactory.newInstance().newTransformer();
                transformer.transform(source,result);
            }catch(Throwable e){
                System.out.println("algo paso");
            }
    }
}
