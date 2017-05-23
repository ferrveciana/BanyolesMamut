package proactiva;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

/*
 * @class Entrada
 * @brief Classe que actua com a base de dades on guardem tota la informació proporcionada per la classe Entrada
 */
public class Agencia {
   
    private final HashMap<String,Lloc> llistaLlocs;  ///< llista que conte els Llocs del nostre mapa
    private final HashMap<String,PuntInteres> llistaPInteres; ///< llista que conte els PuntsInteres del nostre mapa
   
    private final HashMap<String,Client> llistaClients; ///< llista que conte els Clients de l'agencia
    private final ArrayList<Allotjament> llistaAllotjaments; ///< llista que conte la informacio dels Allotjaments del mapa
    private final ArrayList<Visitable> llistaVisitables; ///< llista que conte la informacio dels Visitables del mapa
    private Viatge viatge; ///< classe que conte informacio relacionada amb el viatge que es vol realitzar

   /**
     *
     * @brief constructor de l'agencia que inicialitza les llistes
     * @pre cert
     * @post llistes inicialitzades
     */
    public Agencia() {
        this.llistaLlocs = new HashMap<>();
        this.llistaPInteres = new HashMap<>();
        this.llistaClients = new HashMap<>();
        this.llistaAllotjaments = new ArrayList<>();
        this.llistaVisitables = new ArrayList<>();
    }

     /**
     *
     * @brief converteix una string data a una LocalDate i la retorna
     * @pre l'string data es una data valida
     * @post retorna la data obtinguda a partir de l'string 'data' en format LocalDate
     */
    public LocalDate passarData(String data){
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = data.split(delimitadors);
        return (LocalDate.of(Integer.parseInt(paraulesSeparades[0]),Integer.parseInt(paraulesSeparades[1]), Integer.parseInt(paraulesSeparades[2])));
    }
   
    /**
     *
     * @brief converteix una string hora a un enter equivalent en minuts i el retorna
     * @pre l'string hora es una hora valida
     * @post retorna els minuts 
     */
    private int passarTemps(String hora){
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = hora.split(delimitadors);
        return (Integer.parseInt(paraulesSeparades[0])*60+Integer.parseInt(paraulesSeparades[1]));        
    }

   /**
     *
     * @brief crea una llista de clients amb les dades que li ha passat la entrada i les guarda a la pròpia classe
     * @pre cert
     * @post llistaClients actualitzada
     */
    public void crearClient(String nomClient, ArrayList<String> llistaPreferencies) {
    
        Client client = new Client(nomClient,llistaPreferencies);
        llistaClients.put(nomClient,client);
        
        System.out.println("MIDA LLISTA CLIENTS " + llistaClients.size());
    }
   
   /**
     *
     * @brief crea una llista de Llocs amb les dades que li ha passat la entrada i les guarda a la pròpia classe
     * @pre cert
     * @post llistaLlocs actualitzada
     */
    public void crearLloc(String nomLloc, String coordenades, TimeZone franjaHoraria) {
        
       Lloc nouLloc = new Lloc(nomLloc,coordenades,franjaHoraria);
       llistaLlocs.put(nomLloc,nouLloc);
    }

   /**
     *
     * @brief crea una llista de punts d'Interes amb les dades que li ha passat la entrada i les guarda a la pròpia classe
     * @pre cert
     * @post llistaPInteres actualitzada amb els Allotjaments entrats
     */
    public void crearAllotjament(String _nom, String _coordenada, TimeZone _zonaHoraria, float _preu, ArrayList<String> _caract,String _categoria) {
        
        Allotjament nouAllotjament = new Allotjament(_nom,_coordenada,_zonaHoraria,_preu,_caract,_categoria);
        llistaPInteres.put(_nom,nouAllotjament);
    }
   
   /**
     *
     * @brief crea una llista de punts d'Interes amb les dades que li ha passat la entrada i les guarda a la pròpia classe
     * @pre cert
     * @post llistaPInteres actualitzada amb els Visitables entrats
     */
    public void crearVisitable(String _nom, String _coordenada, TimeZone _zonaHoraria, float _preu, ArrayList<String> _caract, int _tempsVisita, ArrayList<Horari> _horariVisites, HashMap<String,DuesHores> _excepcions) {
        
        Visitable nouVisitable = new Visitable(_nom,_coordenada,_zonaHoraria,_preu, _caract,_horariVisites, _tempsVisita,_excepcions);
        llistaPInteres.put(_nom,nouVisitable);
    }
   
   /**
     *
     * @brief actualitza la llista de clients amb les dades que li ha passat la entrada
     * @pre cert
     * @post llistaClients actualitzada depenent les visites que han realitzat els clients prèviament
     */
    public void crearVisita(String nomClient,String llocVisitat,LocalDate data) {

        if (llistaClients.get(nomClient) != null)
            llistaClients.get(nomClient).afegirVisita(llocVisitat,data);
    }
   
   /**
     *
     * @brief associa un Visitable o Allotjament a un Lloc de la llista de Llocs 
     * @pre cert
     * @post llistaLlocs actualitzada
     */
    public void crearAssociarLloc(String secundari,String primari) {

        Lloc _lloc = llistaLlocs.get(primari);
        PuntInteres pi = llistaPInteres.get(secundari);
        System.out.println("CIUTAT " + primari + " AFEGIR -> " + secundari);

        if (_lloc != null && pi != null) { //////////////////TRY CATCH
            Ciutat ciutat;
            if (_lloc instanceof Ciutat){ //prèviament convertit a ciutat 
                ciutat = new Ciutat(_lloc.nom, _lloc.getCoordenada(),_lloc.getZonaHoraria());
            }
            else {
                ciutat = _lloc.ferCiutat(pi);
                llistaLlocs.put(primari,ciutat); //substituir Lloc -> ciutat
            }
            System.out.println("CIUTAT LA QUE AFEGIR " + ciutat.getNom());
            System.out.println("PUNT INTERES A ASSOCIAR " + pi.getNom());
            System.out.println("");
            ciutat.afegirPuntInteres(pi);
            pi.setCiutat(ciutat);
        }
        
        System.out.println("LLISTA DE CIUTATS ACTUALS: ");
        for (Lloc ciutat : llistaLlocs.values()) {
            if (ciutat instanceof Ciutat)
                System.out.println(ciutat.getNom());
        }
        System.out.println("");
    }
   
   /**
     *
     * @brief afegeix un transportUrba a la llista de transports d'una ciutat de la nostra llistaLlocs
     * @pre cert
     * @post transportsUrbans d'una ciutat actualitzats
     */
    public void crearAssociarTransport(String _lloc,String mitja,int durada,float preu) {
         
       TransportUrba turba = new TransportUrba(_lloc,mitja,durada,preu);

       if (llistaLlocs.get(_lloc) instanceof Ciutat){ //prèviament convertit a ciutat 
            Ciutat ciutat = (Ciutat) llistaLlocs.get(_lloc);
            ciutat.afegirTransport(turba);
        }
        else {
            System.out.println("Volem associar un transport a " + _lloc + " que no és una ciutat");
        }
    }
   
   /**
     *
     * @brief afegeix un transport directe al punt d'Interes que ens passa la entrada
     * @pre cert
     * @post  transport directe afegit
     */
    public void crearTransportDirecte(String origen, String desti, String mitja, int durada, double preu) {
        
        //for (PuntInteres pi : llistaPInteres.values()) 
           // System.out.println("MOSTRAR " + pi.getNom());
        
        if (llistaPInteres.containsKey(origen) && llistaPInteres.containsKey(desti)) { ///FER TRY CATCH!!!!!!!!!!!!!!!!!!!!!
            
            TransportDirecte tdirecte = new TransportDirecte(llistaPInteres.get(origen),llistaPInteres.get(desti),mitja,durada,preu);
            PuntInteres pi = llistaPInteres.get(origen);
            pi.afegirTransportDirecte(tdirecte);
            System.out.println("TRANSPORT DIRECTE DE " + pi.getNom() + " A " + desti);
        }
        else {
            System.out.println("HEM DESPRECIAT AQUEST TRANSPORT DIRECTE " + origen + " -> " + desti);
        }
    }
   
   /**
     *
     * @brief afegeix un transport indirecte a la ciutat que ens passa la entrada
     * @pre cert
     * @post transport indirecte afegit
     */
    public void crearTransportIndirecte(String origen, String desti, String mitja, int tempsFinsOrigen, int tempsFinsDesti, HashMap<LocalDate,ArrayList<TransportIndirecte>> transportIndirecte) {
        
        if (llistaLlocs.get(origen) instanceof Ciutat && llistaLlocs.get(desti) instanceof Ciutat){ //prèviament convertit a ciutat 
            Ciutat ciutatOrigen;     //TRY CATCH
            ciutatOrigen = (Ciutat) llistaLlocs.get(origen);
            
            if (ciutatOrigen != null && llistaLlocs.containsKey(origen) && llistaLlocs.containsKey(desti)) {
                Ciutat ciutatDesti = (Ciutat) llistaLlocs.get(desti);

                Hub hub = new Hub(ciutatOrigen,ciutatDesti,mitja,tempsFinsOrigen,tempsFinsDesti,transportIndirecte); 
                ciutatOrigen.afegirHub(hub);
                System.out.println("TRANSPORT INDIRECTE AFEGIT A LA CIUTAT " + origen + " FINS A " + desti);
                List<Hub> hubs = ciutatOrigen.obtenirHub();
                System.out.println("-<<<<<<<<<<<<<<<<<"  + hubs.size());
            }
        }
        else if (!(llistaLlocs.get(origen) instanceof Ciutat) && !(llistaLlocs.get(desti) instanceof Ciutat))
            System.out.println("Volem afegir un hub de " + origen + " -> " + desti + " i els dos no són una ciutat");  
        
        else if (!(llistaLlocs.get(origen) instanceof Ciutat))
            System.out.println("Volem afegir un hub de " + origen + " -> " + desti + " i " + origen + " no és una ciutat"); 
        
        else if (!(llistaLlocs.get(desti) instanceof Ciutat))
            System.out.println("Volem afegir un hub de " + origen + " -> " + desti + " i " + desti + " no és una ciutat"); 
    }
   
   /**
     *
     * @brief crea un objecte Viatge amb la informació del viatge que volen fer els clients
     * @pre cert
     * @post viatge creat
     */
    public void crearEntradaViatge(LocalDate dataInici, LocalTime horaInici,int nombreDies,float preuMaxim, String categoria, ArrayList<String> _clients, LinkedList<String> _destinacions, ArrayList<String> rutes) {

        LinkedList<PuntInteres> destinacions = new LinkedList<>();
        ArrayList<Client> clients = new ArrayList<>();
        
        for (int i = 0; i < _destinacions.size(); i++) {
            PuntInteres PI = llistaPInteres.get(_destinacions.get(i));
            destinacions.add(PI);
        }
        for (int j = 0; j < _clients.size(); j++) {
            Client client = llistaClients.get(_clients.get(j));
            clients.add(client);
        }
        viatge = new Viatge(dataInici,horaInici,nombreDies,preuMaxim,categoria,clients,destinacions,rutes);
    } 
    
   /**
     *
     * @brief retorna el Viatge de l'Agencia
     * @pre cert
     * @post return Viatge
     */
    public Viatge getViatge() {
        
        return viatge;
    }

    void getInfo() {
        System.out.println("E " + llistaAllotjaments.size());
        System.out.println("LA TEVA PUTA MARE" + viatge.preuMax());
    }

    void getHubs() {
        for (Lloc lloc : llistaLlocs.values()) {
            if (lloc instanceof Ciutat) {
                Ciutat ciutat = (Ciutat) lloc;
                List<Hub> hubs = ciutat.obtenirHub();
                for (Hub hub : hubs) 
                    System.out.println(hub.getCiutat().getNom() +  "->" + hub.getCiutatd().getNom());
            }
        }
    }
}