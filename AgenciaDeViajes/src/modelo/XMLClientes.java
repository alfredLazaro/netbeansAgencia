/*
 * orgullosamente creado por fred 
 */
package modelo;
import java.io.File;
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
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import metodosAgen.*;
import static modelo.XMLAdministradores.crearXML;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
public class XMLClientes {
    private static final String nomArchivo="clientes";
    private static final String pathAch="."+File.separator+"src"+File.separator+"modelo"+File.separator+"xmls"+File.separator;
    private static final File archivo=new File(pathAch+nomArchivo+".xml");
    public static void main(String[] args) {
        List<Cliente> listaClientes=new ArrayList<>();
        Cliente cliente1=new Cliente("rebeca",3,"verano","vacaciones",12345);
        Cliente cliente2=new Cliente("Alan",5,"otoño","negocios",54231);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        //PaqueteTuristico paquet1=new PaqueteTuristico(transporte, hotel, restaurant, 0);
        //Reserva reserva1=new Reserva(paquete, pasaje, cliente1, fechaReserva);
        try{
            modificarXML(listaClientes);
        }catch(Exception e){
            System.out.println("no se pudo crear el documento");
        }
        
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
    
    public static void modificarXML(List<Cliente> listaClientes){
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
                    Element codNodo=document.createElement("codigoCliente");
                    Text nodoValorCod=document.createTextNode(clien.getNroIdent()+"");
                    codNodo.appendChild(nodoValorCod);
                    
                    Element nombreNodo = document.createElement("Nombre");
                    Text nodoValorNombre=document.createTextNode(clien.getNombreCliente());
                    nombreNodo.appendChild(nodoValorNombre);
                    
                    Element tempoNodo=document.createElement("TemporadaPreferida");
                    Text nodoValorTemp=document.createTextNode(clien.getTemporadaPreferencia());
                    tempoNodo.appendChild(nodoValorTemp);
                    
                    Element motivoNodo=document.createElement("MotivoViaje");
                    Text nodoValorMotivo=document.createTextNode(clien.getTipoViaje());
                    motivoNodo.appendChild(nodoValorMotivo);
                    
                    Element nroPasajrsNodo=document.createElement("nroPasajeros");
                    Text nodoValorNroPasajers=document.createTextNode(client.getCantidadPasajeros()+"");
                    nroPasajrsNodo.appendChild(nodoValorNroPasajers);
                    
                    Element frecuenciaNodo=document.createElement("frecuencia");
                    Text nodoValorFrecuen=document.createTextNode(client.getFrecuencia()+"");
                    nroPasajrsNodo.appendChild(nodoValorFrecuen);
                    
                    Element paqueteNodo=document.createElement("HayPaquete");
                    Text nodoValorPaquet=document.createTextNode(client.getTienePaquete()+"");
                    paqueteNodo.appendChild(nodoValorPaquet);
                    //se pone los datos del cliente
                    nodoCliente.appendChild(codNodo);
                    nodoCliente.appendChild(nombreNodo);
                    nodoCliente.appendChild(tempoNodo);
                    nodoCliente.appendChild(motivoNodo);
                    nodoCliente.appendChild(nroPasajrsNodo);
                    nodoCliente.appendChild(frecuenciaNodo);
                    nodoCliente.appendChild(paqueteNodo);
                    //se ponen los cliente en el xml
                    raiz.appendChild(nodoCliente);
                    //tengo que inicializar su historial en el xml
                    crearHistor(clien.getNroIdent());
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
    
    public static void eliminarClienteXML(Cliente cliente){
        
    }
    
    public static Cliente buscarClient(){
        Cliente clin=null;
        
        return clin;
    }
    
    public static ArrayList<Cliente> listaClientes(){
        ArrayList<Cliente> listClientes=new ArrayList<>();
        
        return listClientes;
    }
    
    public  static void crearHistor(int codCliente){
        XMLHistoriales.aniadirHisto(codCliente);
    }
}
