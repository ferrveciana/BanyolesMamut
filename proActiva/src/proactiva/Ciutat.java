package proactiva;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

/**
 * @class Ciutat
 * @brief Classe que extèn Lloc 
 */
public class Ciutat extends Lloc {
    
   private List<TransportUrba> llistaUrbans; ///< llista de transports urbans de la Ciutat
   private List<PuntInteres> llistaPinteres; ///< llista de punts d'interes de la Ciutat
   private ArrayList<Hub> llistaHubs; ///< llista de hubs de la Ciutat

    /**
     * @brief constructor de la classe Ciutat
     * @pre cert
     * @post Ciutat creada 
     */
    public Ciutat(String _nom, String _coordenada, TimeZone _zonaHoraria) {
        super(_nom, _coordenada, _zonaHoraria);
        llistaPinteres = new LinkedList<>();
        llistaUrbans = new LinkedList<>();
        llistaHubs = new ArrayList<>();
    }

    /**
     * @brief constructor que crea una Ciutat a partir d'una altra
     * @pre cert
     * @post Ciutat creada
     */
    Ciutat(Ciutat _ciutat) {
        super(_ciutat.nom,_ciutat.getCoordenada(), _ciutat.getZonaHoraria());
        llistaPinteres = new LinkedList<PuntInteres>();
        llistaUrbans = new LinkedList<TransportUrba>();
    }
    
   /**
     * @brief retorna la llista de transports urbans de la Ciutat
     * @pre cert
     * @post return llistaUrbans
     */
    public List<TransportUrba> obtenirTransports(){ 
        return llistaUrbans;
    }
    
   /**
     * @brief afegeix un transport urba a la llista de transports urbans de la Ciutat
     * @pre cert
     * @post transportUrba afegit a llistaUrbans
     */
    public void afegirTransport(TransportUrba turba){ 
        llistaUrbans.add(turba);
    }
    
   /**
     * @brief afegeix un punt d'interes a la llista de punts d'interes de la Ciutat
     * @pre cert
     * @post puntInteres afegir a llistaPuntsInteres
     */
    public void afegirPuntInteres(PuntInteres _pinteres){
        llistaPinteres.add(_pinteres);
    }
    
   /**
     * @brief retorna la llista de punts d'Interes
     * @pre cert
     * @post return llistaPinteres
     */
    public List<PuntInteres> obtenirPuntInteres(){
        return llistaPinteres;
    }
    
   /**
     * @brief afegeix un hub a la llista de hubs de Ciutat
     * @pre cert
     * @post hub afegit a llistaHubs
     */
    public void afegirHub(Hub _hub){
        llistaHubs.add(_hub);
    }
    
    /**
     * @brief busca un hub a la llistaHubs
     * @pre cert
     * @post retorna la posicio del hub a la llistaHubs que te com a origen==0, desti==d i mija==tipusM
     */
    public int buscarHub(String o,String d,String tipusM){
        boolean trobat = false;
        int i=0;
        
        while (!trobat && i<llistaHubs.size()) {
            if(llistaHubs.get(i).esIgual(o, d, tipusM)) trobat=true;
            else i++;
        }
        return i;
    }
    
    /**
     * @brief retorna l'hora de sortida mes pròxima
     * @pre hora valida
     * @post crida una funcio que retorna l'hora de sortida (del transport) mes pròxima
     */
    public LocalDateTime primeraHoraDisponible(String origen,String desti,String tipusTransport,LocalDateTime hora){
        int i=buscarHub(origen, desti, tipusTransport);
        return llistaHubs.get(i).hPropera(hora);
    }
    
    /**
     * @brief retorna cert si es podrà desplaçar durant el dia actual
     * @pre hora valida
     * @post crida una funcio que retorna cert si es podrà desplaçar durant el dia actual
     */
    public boolean esPotMoure(String origen,String desti,String tipusTransport,LocalDateTime hora){
        int i=buscarHub(origen, desti, tipusTransport);
        return llistaHubs.get(i).sHiPotAnar(hora);
    }
    
   /**
     * @brief retorna la llista de hubs de la Ciutat
     * @pre cert
     * @post return llistaHubs
     */
    public List<Hub> obtenirHub() {
        return llistaHubs;   
    }
    
    
    
}
