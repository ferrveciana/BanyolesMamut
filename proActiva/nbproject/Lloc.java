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
   
   /**
    * @pre --
    * @post Retorna les coordenades de lloc
    * @brief Retorna les coordenades de lloc
    */
   public String getCoordenada() {
       return coordenada;
   }
   
   /**
    * @pre --
    * @post Retorna la zona horaria de lloc
    * @brief Retorna la zona horaria de lloc
    */
   public TimeZone getZonaHoraria() {
       return zonaHoraria;
   }
   
   /**
    * @pre --
    * @post Retorna una Ciutat creada a partir de secundari
    * @brief Retorna una Ciutat creada a partir de secundari
    */
   Ciutat ferCiutat(PuntInteres secundari){
       
       Ciutat city = new Ciutat(nom,coordenada,zonaHoraria);
       city.afegirPuntInteres(secundari);
       
       return city;
   }
   
    /**
    * @pre --
    * @post Retorna el nom de Ciutat
    * @brief Retorna el nom de Ciutat
    */
   public String getNom(){
        
        return nom;
    }
    
}
