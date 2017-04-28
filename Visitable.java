package prop;

import java.util.List;
import java.util.TimeZone;


public class Visitable implements Secundari{
    private final String nom;
    private final double coordenadaX;
    private final double coordenadaY;
    private final TimeZone zonaHoraria;
    private final int tempsVisita;
    private final double preu;
    private final List<String> caracteristiques;
    private final List<Horari> horariVisites;
    private SortedMap<String,> excepcions; 
    
    public Visitable(String _nom, double _coordX, double _coordY, TimeZone _zonaHoraria, int _tempsVisita, double _preu, List<String> _caract, List<Horari> _horariVisites){
        nom=_nom;
        coordenadaX=_coordX;
        coordenadaY=_coordY;
        zonaHoraria=_zonaHoraria;
        tempsVisita=_tempsVisita;
        preu=_preu;
        caracteristiques=_caract;
        horariVisites=_horariVisites;
    }
    
    
    @Override
    public List<String>obtenirCaracteristiques(){
        return caracteristiques;
    }

  
    @Override
    public double obtenirPreu(){
        return preu;
    }

}
