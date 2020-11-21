
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Agencia {
    private Administrador usuario;
    private HashMap<String,ArrayList<PaqueteTuristico>> lugaresTuristicos;
    private HashMap<Integer,Cliente> clientes;
    private ArrayList<Pasaje> pasajes;
    private String nombEmpresa;
    //
    public Agencia(Administrador usuario, ArrayList<Pasaje> pasajes, String nomb,HashMap<String,ArrayList<PaqueteTuristico>> lugaresTuristicos, HashMap<Integer,Cliente> clientes){
        this.usuario = usuario;
        //this.clientes = clientes;
        this.lugaresTuristicos=lugaresTuristicos;
        this.clientes= clientes;
        this.pasajes = pasajes;
        //paquetes =paqu;
        nombEmpresa = nomb;
    }
    //creacion alterna de la clase agencia
    public Agencia(){
      //paquetes=new ArrayList<PaqueteTuristico>();
      lugaresTuristicos = new HashMap<>();
      clientes=new HashMap<Integer,Cliente>();
      pasajes=new ArrayList<Pasaje>();
    }
    //get para prueba
    public void registrarCliente(String nombreCliente, int cantidadPasajeros, String temporadaPreferencia, String tipoViaje){ //se añade un cliente a la lista 
    Integer cod=generarCod();
      Cliente cliente=new Cliente(nombreCliente,cantidadPasajeros,temporadaPreferencia,tipoViaje,cod);
      clientes.put(cod,cliente);
      System.out.println("Se registro el cliente");
    }

    private Integer generarCod(){
      Integer res=(int) (Math.random()*10000);
      if(clientes.get(res)==null){
        res=res;
        System.out.println(res);
      }else{
        res=generarCod();
      }
      return res;
    }
    
    private Cliente verificarExistencia(String nombreCliente, int nroIdent){
      Cliente res=clientes.get(nroIdent);
      
        if(res!=null && res.getNombreCliente().equals(nombreCliente) ){
            res=res;
        }else{}
        return res;
    }

    public void agregarPaquete(String lugarDestino, Transporte transporte, Hotel hotel, Comida comida, int cantDias){
      PaqueteTuristico nuevoPaquete = new PaqueteTuristico(transporte,hotel,comida,cantDias);
       if(!lugaresTuristicos.containsKey(lugarDestino)){
         lugaresTuristicos.put(lugarDestino, new ArrayList<PaqueteTuristico>()); 
       }
       lugaresTuristicos.get(lugarDestino).add(nuevoPaquete);
    }
    
    public void reservarPaquetes(String nombreCliente,int nroIdentificacion,int cantPasajeros,int nroPaq,String lugarTuristico){
      Cliente client=verificarExistencia(nombreCliente,nroIdentificacion);
        if(client!=null){
          PaqueteTuristico paq=buscarPaquete(lugarTuristico,nroPaq);
          if(paq!=null && paq.getDisponible()==true){
            Reserva reserva=new Reserva(paq,null, client,new Date());
            client.getHistorial().aniadirReserva(reserva);
            //por ahora la reserva de pasaje esta pendiente
          }else{
            //se debe buscar un paquete
            System.out.println("el paquete no se encuentra disponible, se debe buscar otro paquete");
          }
        }else{
          //se debe crear un cliente
          System.out.println("por favor cree un cliente en intente nuevamente");
        }
    }

    private PaqueteTuristico buscarPaquete(String lugarTuristico ,int nroIdent){
        PaqueteTuristico paq=null;
        ArrayList<PaqueteTuristico> paquetes = lugaresTuristicos.get(lugarTuristico);
        int i=0;
        boolean encontrado=false;
        while(i<paquetes.size()&&!encontrado){
            if(nroIdent==paquetes.get(i).getNroIde()){
                paq=paquetes.get(i);
                encontrado=true;
            }else{}
            i++;
        }
        return paq;
    }
    
    public void anularReserva(Cliente cliente){
        if(clientes.containsKey(cliente.getNroIdent())){
          Historial historialCliente = cliente.getHistorial();
          if(historialCliente != null){
           ArrayList<Reserva> reserva = historialCliente.getReservas();
            if(reserva != null){
              if(reserva.get(0).getEstado() == "activo"){
                reserva.remove(0);
              }else{
                System.out.println("La reserva ya fue cancelada");
              }
            }else{
              System.out.println("El cliente no realizó ninguna reserva");
            }
         }else{
          System.out.println("El cliente no tiene registrado un historial");
         }
       }else{
         System.out.println("El cliente no se encuentra registrado");
       }
    }
    
    
    private void reservaPasaje(String origen,String destino,int codClient,String nomClient,Date fechaIda,Date fechaVuelta,String tipoTransporte,String nombrEmpresa)
    {
        //este metodo debe llamarse obligatiriamente aunque con datos null (ecepto en cliente)
        Cliente client=verificarExistencia(nomClient, codClient);
        if(client!= null){
            Pasaje pasaje= new Pasaje(origen, destino, fechaIda, fechaVuelta, nomClient,tipoTransporte, nombrEmpresa);
            ArrayList<Reserva> reservsCliente=client.getHistorial().getReservas();
            Reserva ultReserv=reservsCliente.get(0);
            ultReserv.setPasaje(pasaje);
            System.out.println("se aniadio el pasaje");
            //se crea la oferta
            crearOferta(ultReserv);
        }else{
            System.out.println("no se encontro el cliente");
        }
     
    }
    
    private void crearOferta(Reserva reserva){
        PaqueteTuristico paquet=reserva.getPaquete();
        Pasaje pasaj=reserva.getPasaje();
        Cliente cliente=reserva.getCliente();
        if(paquet!=null && pasaj!=null){
            //oferta no necesita aniadir Fechasfestivos
            Oferta oferta=new Oferta();
            if(cliente.esFrecuente()){
                oferta.generarOfertaClienteFrecuente(reserva);
            }else{}
            if(reserva.getPaquete().existeOfertaDias()){
            oferta.generarOfertaCantDias(reserva);
        }else{}
            if(reserva.getCliente().exiteOfertaPasajeros()){
            oferta.generarOfertaCantPasajeros(reserva);
            }
            oferta.generarOfertaFechasFestivas(reserva);
        }else{}
    }    
}
