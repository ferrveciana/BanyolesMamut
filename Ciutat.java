package proactiva;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
   private ArrayList<Hub> llistaHubs;

    public Ciutat(String _nom, String _coordenada, TimeZone _zonaHoraria) {
        super(_nom, _coordenada, _zonaHoraria);
        llistaPinteres = new LinkedList<PuntInteres>();
        llistaUrbans = new LinkedList<TransportUrba>();
        llistaHubs = new ArrayList<Hub>();
    }

    Ciutat(Ciutat _ciutat) {
        super(_ciutat.nom,_ciutat.getCoordenada(), _ciutat.getZonaHoraria());
        llistaPinteres = new LinkedList<PuntInteres>();
        llistaUrbans = new LinkedList<TransportUrba>();
    }
    
    public LocalDateTime primeraHoraDisponible(LocalDateTime hora, Ciutat desti, String tipusTransport){
        int i = 0;
        boolean trobat = false;
        while(i<llistaHubs.size() && !trobat){
            if(desti.getNom().equals(llistaHubs.get(i).getDesti()) && tipusTransport.equals(llistaHubs.get(i).getTipus())){
                trobat = true;
            }
            else i++;
        }
        return llistaHubs.get(i).hPropera(hora);
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
    
    public LinkedList<Hub> obtenirHub() {
        return llistaHubs;   
    }
    
}
