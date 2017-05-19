package proactiva;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author narcisbustins
 */
public class Ciutat extends Lloc {
    
   private List<TransportUrba> llistaUrbans;
   private List<PuntInteres> llistaPinteres;
   private ArrayList<Hub> llistaHubs;

    public Ciutat(String _nom, String _coordenada, TimeZone _zonaHoraria) {
        super(_nom, _coordenada, _zonaHoraria);
        llistaPinteres = new LinkedList<>();
        llistaUrbans = new LinkedList<>();
        llistaHubs = new ArrayList<>();
    }

    Ciutat(Ciutat _ciutat) {
        super(_ciutat.nom,_ciutat.getCoordenada(), _ciutat.getZonaHoraria());
        llistaPinteres = new LinkedList<PuntInteres>();
        llistaUrbans = new LinkedList<TransportUrba>();
    }
    
    public List<TransportUrba> obtenirTransports(){ 
        return llistaUrbans;
    }
    
    public void afegirTransport(TransportUrba turba){ 
        llistaUrbans.add(turba);
    }
    
    public void afegirPuntInteres(PuntInteres _pinteres){
        llistaPinteres.add(_pinteres);
    }
    
    public List<PuntInteres> obtenirPuntInteres(){
        return llistaPinteres;
    }
    
    public void afegirHub(Hub _hub){
        llistaHubs.add(_hub);
    }
    
    /**
     * @pre cert
     * @post busca el hub a la llistaHubs que te com a origen==0, desti==d i mija==tipusM
     * @brief busca un hub a la llistaHubs
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
     * @pre hora valida
     * @post crida una funcio que retorna l'hora de sortida (del transport) mes pròxima
     * @brief retorna l'hora de sortida mes pròxima
     */
    public LocalDateTime primeraHoraDisponible(String origen,String desti,String tipusTransport,LocalDateTime hora){
        int i=buscarHub(origen, desti, tipusTransport);
        return llistaHubs.get(i).hPropera(hora);
    }
    
    /**
     * @pre hora valida
     * @post crida una funcio que retorna cert si es podrà desplaçar durant el dia actual
     * @brief retorna cert si es podrà desplaçar durant el dia actual
     */
    public boolean esPotMoure(String origen,String desti,String tipusTransport,LocalDateTime hora){
        int i=buscarHub(origen, desti, tipusTransport);
        return llistaHubs.get(i).sHiPotAnar(hora);
    }
    
    public List<Hub> obtenirHub() {
        return llistaHubs;   
    }
    
    
    
}
