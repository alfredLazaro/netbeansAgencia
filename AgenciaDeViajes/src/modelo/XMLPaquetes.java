/*
 * 
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
                    
                    Element tipoVehicNodo=document.createElement("Tipo Vehiculo");
                    Text    nodoValorTipo=document.createTextNode(pac.getTransporte().getTipoTransporte());
                    tipoVehicNodo.appendChild(nodoValorTipo);
                    
                    Element origenNodo=document.createElement("origen");
                    Text    nodoValorOrigen=document.createTextNode(pac.getTransporte().getOrigen());
                    origenNodo.appendChild(nodoValorOrigen);
                    
                    Element preciNodo=document.createElement("precio Transpor");
                    Text    nodoValorPrecioT=document.createTextNode(pac.getTransporte().getPrecio()+"");
                    precioNodo.appendChild(nodoValorPrecioT);
                    
                    //aniado los nodos de el transporte
                    transporteNodo.appendChild(tipoVehicNodo);
                    transporteNodo.appendChild(origenNodo);
                    transporteNodo.appendChild(preciNodo);
                    //restaurante en su nodo tendra nombre
                    Element restauranNodo=document.createElement("Restarurante");
                    Element nombRestNodo=document.createElement("Nombre Restaurante");
                    Text    nodoValorNomR=document.createTextNode(pac.getRestaurant().getNombreRest());
                    nombRestNodo.appendChild(nodoValorNomR);
                    
                    Element ubicRestauraNodo=document.createElement("Ubicacion Restaurante");
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
                        
                        Element nombComidaNodo=document.createElement("nombre comida");
                        Text    nodoValorComida=document.createTextNode(com.getPlato());
                        nombComidaNodo.appendChild(nodoValorComida);
                        
                        Element precioPlatNodo=document.createElement("precio plato");
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
                    Element nomHotelNodo=document.createElement("Nombre Hotel");
                    Text    nodoValorNHot=document.createTextNode(pac.getHotel().getNombre());
                    nomHotelNodo.appendChild(nodoValorNHot);
                    
                    Element ubicHoNodo=document.createElement("ubicacion hotel");
                    Text    nodoValorUbicH=document.createTextNode(pac.getHotel().getUbicacion());
                    ubicHoNodo.appendChild(nodoValorUbicH);
                    
                    Element preciUnHNodo=document.createElement("Precio Unitario Hotel");
                    Text    nodoValorPrUnHot=document.createTextNode(pac.getHotel().getPrecioUnitario()+"");
                    preciUnHNodo.appendChild(nodoValorPrUnHot);
                    
                    Element cantHDNodo=document.createElement("cantidad Habitaciones");
                    Text    nodoValorCantHD=document.createTextNode(pac.getHotel().getCantHabitacionesHabilitadas()+"");
                    cantHDNodo.appendChild(nodoValorCantHD);
                    
                    Element cantHUNodo=document.createElement("cantidad H Usadas");
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
    
    public static void insertHistorial(){
        
    }
}
