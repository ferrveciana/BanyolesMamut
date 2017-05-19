package proactiva;

import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author narcisbustins
 */
public class Allotjament extends PuntInteres{
  
    private final String categoria;

    public Allotjament(String _nom, String coordenada, TimeZone zonaHoraria, double preu, List<String> caract,String _categoria){
        
        super(_nom, coordenada, zonaHoraria, preu, caract);
        categoria = _categoria;
        
    }
    
    public String getCategoria(){
        return categoria;
    }

    @Override
    public Activitat crearActivitat() {
        EstadaH a = new EstadaH(0, (float) this.obtenirPreu(),this); //treure cast
        return a;
    }
}