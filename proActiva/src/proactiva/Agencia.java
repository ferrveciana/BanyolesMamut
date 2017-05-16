
package proactiva;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
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
     * @return llistes inicialitzades
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
     * @return retorna la data obtinguda a partir de l'string 'data' en format LocalDate
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
     * @return retorna els minuts 
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
     * @return llistaClients actualitzada
     */
    public void crearClient(String nomClient, ArrayList<String> llistaPreferencies) {
    
        Client client = new Client(nomClient,llistaPreferencies);
        llistaClients.put(nomClient,client);
    }
   
   /**
     *
     * @brief crea una llista de Llocs amb les dades que li ha passat la entrada i les guarda a la pròpia classe
     * @pre cert
     * @return llistaLlocs actualitzada
     */
    public void crearLloc(String nomLloc, String coordenades, TimeZone franjaHoraria) {
        
       Lloc nouLloc = new Lloc(nomLloc,coordenades,franjaHoraria);
       llistaLlocs.put(nomLloc,nouLloc);
    }

   /**
     *
     * @brief crea una llista de punts d'Interes amb les dades que li ha passat la entrada i les guarda a la pròpia classe
     * @pre cert
     * @return llistaPInteres actualitzada amb els Allotjaments entrats
     */
    public void crearAllotjament(String _nom, String _coordenada, TimeZone _zonaHoraria, float _preu, ArrayList<String> _caract,String _categoria) {
        
        Allotjament nouAllotjament = new Allotjament(_nom,_coordenada,_zonaHoraria,_preu,_caract,_categoria);
        llistaPInteres.put(_nom,nouAllotjament);
    }
   
   /**
     *
     * @brief crea una llista de punts d'Interes amb les dades que li ha passat la entrada i les guarda a la pròpia classe
     * @pre cert
     * @return llistaPInteres actualitzada amb els Visitables entrats
     */
    public void crearVisitable(String _nom, String _coordenada, TimeZone _zonaHoraria, float _preu, ArrayList<String> _caract, int _tempsVisita, ArrayList<Horari> _horariVisites, HashMap<String,DuesHores> _excepcions) {
        
        Visitable nouVisitable = new Visitable(_nom,_coordenada,_zonaHoraria,_preu, _caract,_horariVisites, _tempsVisita,_excepcions);
        llistaPInteres.put(_nom,nouVisitable);
    }
   
   /**
     *
     * @brief actualitza la llista de clients amb les dades que li ha passat la entrada
     * @pre cert
     * @return llistaClients actualitzada depenent les visites que han realitzat els clients prèviament
     */
    public void crearVisita(String nomClient,String llocVisitat,LocalDate data) {

        if (llistaClients.get(nomClient) != null)
            llistaClients.get(nomClient).afegirVisita(llocVisitat,data);
    }
   
   /**
     *
     * @brief associa un Visitable o Allotjament a un Lloc de la llista de Llocs 
     * @pre cert
     * @return llistaLlocs actualitzada
     */
    public void crearAssociarLloc(String secundari,String primari) {
        
        Lloc _lloc = llistaLlocs.get(primari);
        PuntInteres pi = llistaPInteres.get(secundari);
        System.out.println("AQUET " + secundari);
        Ciutat ciutat;
        if (_lloc instanceof Ciutat){ //prèviament convertit a ciutat 
            ciutat = new Ciutat(_lloc.nom, _lloc.getCoordenada(),_lloc.getZonaHoraria());
        }
        else {
            ciutat = _lloc.ferCiutat(pi);
            llistaLlocs.put(primari,ciutat); //substituir Lloc -> ciutat
        }
        ciutat.afegirPuntInteres(pi);
        pi.setCiutat(ciutat);
    }
   
   /**
     *
     * @brief afegeix un transportUrba a la llista de transports d'una ciutat de la nostra llistaLlocs
     * @pre cert
     * @return transportsUrbans d'una ciutat actualitzats
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
     * @return  transport directe afegit
     */
    public void crearTransportDirecte(String origen, String desti, String mitja, int durada, double preu) {

        TransportDirecte tdirecte = new TransportDirecte(origen,desti,mitja,durada,preu);
        PuntInteres pi = llistaPInteres.get(origen);
        if (pi != null)
            pi.afegirTransportDirecte(tdirecte);

    }
   
   /**
     *
     * @brief afegeix un transport indirecte a la ciutat que ens passa la entrada
     * @pre cert
     * @return transport indirecte afegit
     */
    public void crearTransportIndirecte(String origen, String desti, String mitja, int tempsFinsOrigen, int tempsFinsDesti, HashMap<LocalDate,ArrayList<TransportIndirecte>> transportIndirecte) {

        Hub hub = new Hub(origen,desti,mitja,tempsFinsOrigen,tempsFinsDesti,transportIndirecte);
        Ciutat ciutat;
            
        if (llistaLlocs.get(origen) instanceof Ciutat){ //prèviament convertit a ciutat 
            ciutat = (Ciutat) llistaLlocs.get(origen);
            ciutat.afegirHub(hub);
        }
        else {
            System.out.println("Volem afegir un hub a " + origen + " que no és una ciutat");
        }
    }
   
   /**
     *
     * @brief crea un objecte Viatge amb la informació del viatge que volen fer els clients
     * @pre cert
     * @return viatge creat
     */
    public void crearEntradaViatge(LocalDate dataInici, LocalTime horaInici,int nombreDies,float preuMaxim, String categoria, ArrayList<String> clients, ArrayList<String> rutes) {

        viatge = new Viatge(dataInici,horaInici,nombreDies,preuMaxim,categoria,clients,rutes);
    } 
    
  
}
