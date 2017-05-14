package proactiva;

import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author narcisbustins
 */
public class Ciutat extends Lloc {
    
   private LinkedList<TransportUrba> llistaUrbans;
   private LinkedList<PuntInteres> llistaPinteres;
   private List<Hub> llistaHubs;

    public Ciutat(String _nom, String _coordenada, TimeZone _zonaHoraria) {
        super(_nom, _coordenada, _zonaHoraria);
        llistaPinteres = new LinkedList<PuntInteres>();
        llistaUrbans = new LinkedList<TransportUrba>();
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
    
    public LinkedList<PuntInteres> obtenirPuntInteres(){
        return llistaPinteres;
    }
    
    public void afegirHub(Hub _hub){
        llistaHubs.add(_hub);
    }
    
}