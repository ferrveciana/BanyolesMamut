package prop;

import java.util.List;
import java.util.TimeZone;

public class Allotjament implements Secundari{
    private final String nom;
    private final double coordenadaX;
    private final double coordenadaY;
    private final TimeZone zonaHoraria;
    private final int categoria;
    private final double preuHabDoble;
    private final List<String> caracteristiques;
    

public Allotjament(String _nom, double _coordX, double _coordY, TimeZone _zonaHoraria, int _categoria, double _preu, List<String> _caract){
    nom=_nom;
    coordenadaX=_coordX;
    coordenadaY=_coordY;
    zonaHoraria=_zonaHoraria;
    categoria = _categoria;
    preuHabDoble = _preu;
    caracteristiques=_caract;
}

@Override                                                                                          
 public List<String>obtenirCaracteristiques(){
     return caracteristiques;
 }

@Override 
public double obtenirPreu(){
    return preuHabDoble;
}
    
}
