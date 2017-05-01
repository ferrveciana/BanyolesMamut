package proactiva;

import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author narcisbustins
 */
public abstract class PuntInteres implements Lloc {
    
     private final String nom;
     private final String coordenada;
     private final TimeZone zonaHoraria;
     private final double preu;
     private final List<String> caracteristiques;
     private List<TransportDirecte> llistaTransportsDirectes;

    
     PuntInteres(String _nom, String _coordenada, TimeZone _zonaHoraria, double _preu, List<String> _caract){
        nom=_nom;
        coordenada=_coordenada;
        zonaHoraria=_zonaHoraria;
        preu = _preu;
        caracteristiques=_caract;
     }
     
    //Pre: ---
    //Post: Retorna cert si conte caracteristica altrament fals                                                                                           
    public boolean conteCaracteristica(String caracteristica){
        return caracteristiques.contains(caracteristica);
    }
    
    //Pre: ---
    //Post: Retorna la llista de característiques                                                                                              
    public List<String>obtenirCaracteristiques(){
        return caracteristiques;
    }
    
    //Pre: ---
    //Post: Retorna el preu de visitable, si es gratuit retorna 0      
    public double obtenirPreu(){
        return preu;
    }
    
    //Pre: ---
    //Post: Retorna el llistat de transports directes
    public void afegirTransportDirecte(TransportDirecte tdirecte){
         llistaTransportsDirectes.add(tdirecte);
    }
    
    //Pre: ---
    //Post: Retorna el llistat de transports directes
    public List<TransportDirecte> obtenirTransportsDirectes(){
          return llistaTransportsDirectes;
       
    }
    
    //Pre: ---
    //Post: Retorna el tipus de punt d'interes del que es parla
    public abstract String tipus();
}
