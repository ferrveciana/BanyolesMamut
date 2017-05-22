package proactiva;

import java.util.List;
import java.util.TimeZone;

/*
 * @class Allotjament
 * @brief Classe que extèn el Punt d'Interes en cas que aquest sigui un Allotjament
 */
public class Allotjament extends PuntInteres{
  
    private final String categoria; ///< categoria a la que pertany un allotjament
  
    /**
     * @brief constructor d'Allotjament, rep totes les dades necessaries per crear l'objecte Allotjament
     * @pre cert
     * @post Allotjament creat
     */
    public Allotjament(String _nom, String coordenada, TimeZone zonaHoraria, double preu, List<String> caract,String _categoria){
        
        super(_nom, coordenada, zonaHoraria, preu, caract);
        categoria = _categoria;
        
    }
    
   /**
     * @brief retorna la categoria de l'Allotjament
     * @pre cert
     * @post return categoria
     */
    public String getCategoria(){
        return categoria;
    }

    @Override
    public Activitat crearActivitat() {
        EstadaH a = new EstadaH(0, (float) this.obtenirPreu(),this); //treure cast
        return a;
    }
}