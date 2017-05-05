package proactiva;

import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author narcisbustins
 */
public class Ciutat extends Lloc {
    
   private List<TransportUrba> llistaUrbans;
   private List<PuntInteres> llistaPinteres;
   private List<Hub> llistaHubs;


    public Ciutat(String _nom, String _coordenada, TimeZone _zonaHoraria) {
        super(_nom, _coordenada, _zonaHoraria);
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
    
    public PuntInteres getPI(int i){
        return llistaPinteres.get(i);
    }
    
    public void afegirHub(Hub _hub){
        llistaHubs.add(_hub);
    }
    
}