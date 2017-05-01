package proactiva;

import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TimeZone;

/**
 *
 * @author narcisbustins
 */
public class Visitable extends PuntInteres {
    
   
    private final int tempsVisita;
    private final List<Horari> horariVisites;
    private HashMap<String,DuesHores> excepcions;


    public Visitable(String _nom, String _coordenada, TimeZone _zonaHoraria, double _preu, List<String> _caract,List<Horari> _horariVisites, int _tempsVisita) {
        super(_nom, _coordenada, _zonaHoraria, _preu, _caract);
        horariVisites=_horariVisites;
        tempsVisita=_tempsVisita;
        
    }
    
    @Override
    public String tipus() {
        String _tipus="Visitable";
        if (horariVisites.isEmpty()) _tipus="Pas";
       
        return _tipus;
    }
    
}
