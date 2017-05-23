package proactiva;

import java.util.TimeZone;

/**
 * @author narcisbustins
 */
public class Lloc {
    
   public final String nom;
   private final String coordenada;
   private final TimeZone zonaHoraria;
   
   /**
     * @brief Crea un objecte lloc
     * @pre cert
     * @post Lloc creat a partir de nom coordenada i zonahoraria
     */ 
   Lloc(String _nom, String _coordenada, TimeZone _zonaHoraria){
       
        nom=_nom;
        coordenada=_coordenada;
        zonaHoraria=_zonaHoraria;
        
   }
   
    /**
     * @brief Crea un Lloc buit
     * @pre cert
     * @post S'ha creat un lloc buit
     */
   Lloc() {
       nom = "";
       coordenada = "";
       zonaHoraria = TimeZone.getDefault();
       
   }
   
   /**
     * @brief Retorna les coordenades de Lloc
     * @pre Lloc no es buit
     * @post retorna les coordenades de this
     */ 
   public String getCoordenada() {
       return coordenada;
   }
   
    /**
     * @brief Retorna la zona horaria de Lloc
     * @pre Lloc no es buit
     * @post retorna la zona horaria de this
     */ 
   public TimeZone getZonaHoraria() {
       return zonaHoraria;
   }
   
     /**
     * @brief Retorna una ciutat creada a partir de Lloc i un PuntInteres
     * @pre Lloc no es buit
     * @post Retorna la ciutat creada amb els atributs de lloc i conte secundari dins la llista de punts d'interes
     */
   Ciutat ferCiutat(PuntInteres secundari){
       
       Ciutat city = new Ciutat(nom,coordenada,zonaHoraria);
       city.afegirPuntInteres(secundari);
       
       return city;
   }
   
     /**
     * @brief Retorna el nom de Lloc
     * @pre cert
     * @post Retorna el nom de Lloc
     */
    public String getNom(){
        
        return nom;
    }
    
}
