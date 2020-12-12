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
                    nodoCliente.setAttribute("nroIdent", clien.getNroIdent()+"");
                    //creamos elementos para los datos del cliente
                    
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
                    frecuenciaNodo.appendChild(nodoValorFrecuen);
                    
                    Element paqueteNodo=document.createElement("HayPaquete");
                    Text nodoValorPaquet=document.createTextNode(client.getTienePaquete()+"");
                    paqueteNodo.appendChild(nodoValorPaquet);
                    //se pone los datos del cliente
                    
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
    
    public static void eliminarClienteXML(String nomb,int codClient){
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
            NodeList   clientes=document.getElementsByTagName("Cliente");
            for(int i=0;i<clientes.getLength()&&!bb;i++){
                Node nodo=clientes.item(i);
                if(nodo.getNodeType()==Node.ELEMENT_NODE){
                    Element client=(Element) nodo;
                    int codIdCl=Integer.parseInt(client.getAttribute("nroIdent"));
                    String nombClient=client.getElementsByTagName("Nombre").item(0).getTextContent();
                    if(codIdCl==codClient && nomb.equals(nombClient)){
                        client.getParentNode().removeChild(client);
                    }
                }
            }
            //se genera como codigo para eliminar
            Source source=new DOMSource(document);
            //donde se buscara
            Result result=new StreamResult(archivo);
            Transformer transformer=TransformerFactory.newInstance().newTransformer();
            transformer.transform(source,result);
        }catch(Throwable e){
        }
    }
    
    public static Cliente buscarClient(int nroIdent){
        Cliente clin=null;
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
            NodeList   clientes=document.getElementsByTagName("Cliente");
            for(int i=0;i<clientes.getLength();i++){
                Node nodo=clientes.item(i);
                if(nodo.getNodeType()==Node.ELEMENT_NODE){
                    Element client=(Element) nodo;
                    int codIdCl=Integer.parseInt(client.getAttribute("nroIdent"));
                    if(codIdCl==nroIdent){
                        String nomClient=client.getElementsByTagName("Nombre").item(0).getTextContent();
                        String temporada=client.getElementsByTagName("TemporadaPreferida").item(0).getTextContent();
                        String motivo=client.getElementsByTagName("MotivoViaje").item(0).getTextContent();
                        int nroPasaj=Integer.parseInt(client.getElementsByTagName("nroPasajeros").item(0).getTextContent());
                        boolean frec=Boolean.getBoolean(client.getElementsByTagName("frecuencia").item(0).getTextContent());
                        boolean hayPac=Boolean.getBoolean(client.getElementsByTagName("HayPaquete").item(0).getTextContent());
                        //se instancia cliente
                        clin=new Cliente(nomClient, nroPasaj, temporada, motivo, nroIdent);
                        clin.setFrecuencia(frec);
                        clin.setTienePaquete(hayPac);
                    }else{}
                }
            }
            //se genera el xml
            Source source=new DOMSource(document);
            //donde se guardara
            Result result=new StreamResult(archivo);
            Transformer transformer=TransformerFactory.newInstance().newTransformer();
            transformer.transform(source,result);
        }catch(Throwable e){
        }
        return clin;
    }
    
    public static ArrayList<Cliente> listaClientes(){
        ArrayList<Cliente> listClientes=new ArrayList<>();
        Cliente clin=null;
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
            NodeList   clientes=document.getElementsByTagName("Cliente");
            for(int i=0;i<clientes.getLength();i++){
                Node nodo=clientes.item(i);
                if(nodo.getNodeType()==Node.ELEMENT_NODE){
                    Element client=(Element) nodo;
                    int codIdCl=Integer.parseInt(client.getAttribute("nroIdent"));
                    
                        String nomClient=client.getElementsByTagName("Nombre").item(0).getTextContent();
                        String temporada=client.getElementsByTagName("TemporadaPreferida").item(0).getTextContent();
                        String motivo=client.getElementsByTagName("MotivoViaje").item(0).getTextContent();
                        int nroPasaj=Integer.parseInt(client.getElementsByTagName("nroPasajeros").item(0).getTextContent());
                        boolean frec=Boolean.getBoolean(client.getElementsByTagName("frecuencia").item(0).getTextContent());
                        boolean hayPac=Boolean.getBoolean(client.getElementsByTagName("HayPaquete").item(0).getTextContent());
                        //se instancia cliente
                        clin=new Cliente(nomClient, nroPasaj, temporada, motivo, codIdCl);
                        clin.setFrecuencia(frec);
                        clin.setTienePaquete(hayPac);
                        listClientes.add(clin);
                }
            }
            //se genera el xml
            Source source=new DOMSource(document);
            //donde se guardara
            Result result=new StreamResult(archivo);
            Transformer transformer=TransformerFactory.newInstance().newTransformer();
            transformer.transform(source,result);
        }catch(Throwable e){
        }
        return listClientes;
    }
    
    public  static void crearHistor(int codCliente){
        XMLHistoriales.aniadirHisto(codCliente);
    }
    
    public static void insertCliente(Cliente clien){
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
                
                Element nodoCliente=document.createElement("Cliente");
                    nodoCliente.setAttribute("nroIdent", clien.getNroIdent()+"");
                    //creamos elementos para los datos del cliente
                    
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
                    Text nodoValorNroPasajers=document.createTextNode(clien.getCantidadPasajeros()+"");
                    nroPasajrsNodo.appendChild(nodoValorNroPasajers);
                    
                    Element frecuenciaNodo=document.createElement("frecuencia");
                    Text nodoValorFrecuen=document.createTextNode(clien.getFrecuencia()+"");
                    frecuenciaNodo.appendChild(nodoValorFrecuen);
                    
                    Element paqueteNodo=document.createElement("HayPaquete");
                    Text nodoValorPaquet=document.createTextNode(clien.getTienePaquete()+"");
                    paqueteNodo.appendChild(nodoValorPaquet);
                    //se pone los datos del cliente
                    
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
                //se genera el xml
                Source source=new DOMSource(document);
                //donde se guardara
                Result result=new StreamResult(archivo);
                Transformer transformer=TransformerFactory.newInstance().newTransformer();
                transformer.transform(source,result);
            }catch(Throwable e){
                
            }
    }
}
