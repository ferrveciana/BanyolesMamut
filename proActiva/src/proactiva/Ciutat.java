package proactiva;

import java.util.ArrayList;
import java.util.TimeZone;

/**
 *
 * @author narcisbustins
 */
public class Ciutat extends Lloc {
    
   private ArrayList<TransportUrba> llistaUrbans;
   private ArrayList<PuntInteres> llistaPinteres;
   private ArrayList<Hub> llistaHubs;


    public Ciutat(String _nom, String _coordenada, TimeZone _zonaHoraria) {
        super(_nom, _coordenada, _zonaHoraria);
    }
   
    public ArrayList<TransportUrba> obtenirTransports(){ 
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