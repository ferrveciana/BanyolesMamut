package proactiva;

import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author narcisbustins
 */
public class Ciutat {
    
   public final String nom;
   private final String coordenades;
   private final TimeZone franjaHoraria;
   private List<TransportUrba> llistaUrbans;
   private List<PuntInteres> llistaPinteres;
    
   public Ciutat(String _nom,String _coordenades,TimeZone _franjaHoraria ){
       nom=_nom;
       coordenades=_coordenades; 
       franjaHoraria=_franjaHoraria;
    }
    
    public List<TransportUrba> obtenirTransports(){ 
        return llistaUrbans;
    }
    
    public void afegirPuntInteres(PuntInteres _pinteres){
        llistaPinteres.add(_pinteres);
    }
    
}
