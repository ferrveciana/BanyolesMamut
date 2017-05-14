package proactiva;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author narcisbustins
 */
public abstract class PuntInteres extends Lloc {
    
    
     private final double preu;
     private final List<String> caracteristiques;
     private List<TransportDirecte> llistaTransportsDirectes;
     private Ciutat ciutat;

    public PuntInteres(String _nom, String _coordenada, TimeZone _zonaHoraria, double _preu, List<String> _caract) {
        super(_nom, _coordenada, _zonaHoraria);
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
    //Pre: --
    //Post: Retorna la ciutat a la que pertany, si no pertany a cap ciutat retorna null
    public Ciutat getCiutat(){
        return ciutat;
    }
    //Pre: --
    //Post:S' associat *this a _ciutat
    public void setCiutat(Ciutat _ciutat){
        ciutat = new Ciutat(_ciutat);
    }
    
    //Pre: *this te una ciutat associada
    //Post:Retorna una llista amb tots els puntsInteres de la mateixa ciutat que this
    public List<PuntInteres> veins(){
        
        return(ciutat.obtenirPuntInteres());
    }
    
    //Pre: ---
    //Post: Retorna el tipus de punt d'interes del que es parla
    public abstract String tipus();
    
}