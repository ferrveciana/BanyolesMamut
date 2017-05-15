package proactiva;

import java.util.TimeZone;

/**
 * @author narcisbustins
 */
public class Lloc {
    
   public final String nom;
   private final String coordenada;
   private final TimeZone zonaHoraria;
   
   Lloc(String _nom, String _coordenada, TimeZone _zonaHoraria){
       
        nom=_nom;
        coordenada=_coordenada;
        zonaHoraria=_zonaHoraria;
        
   }
   
   Lloc() {
       nom = "";
       coordenada = "";
       zonaHoraria = TimeZone.getDefault();
       
   }
   
   public String getCoordenada() {
       return coordenada;
   }
   
   public TimeZone getZonaHoraria() {
       return zonaHoraria;
   }
   
   Ciutat ferCiutat(PuntInteres secundari){
       
       Ciutat city = new Ciutat(nom,coordenada,zonaHoraria);
       city.afegirPuntInteres(secundari);
       
       return city;
   }
    
}