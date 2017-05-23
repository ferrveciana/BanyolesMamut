/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;

import java.time.LocalDateTime;
import java.util.List;

/*
 * @class Activitat
 * @brief 
 */
public abstract class Activitat {
    
    private int durada; ///< durada total de l'Activitat
    private float preu; ///< preu de l'Activitat
    private LocalDateTime hinici; ///< hora d'inici de l'Activitat
    private LocalDateTime hfinal; ///< hora final de l'Activitat
    
   /**
    * @brief actualitza la durada i el preu de l'Activitat
    * @pre cert
    * @post durada i preu actualitzats
    */
    Activitat(int _durada,float _preu){
        
       durada = _durada;
       preu = _preu;
    }
    
   /**
    * @brief retorna la durada de l'Activitat
    * @pre cert
    * @post return durada
    */
    public int durada(){
        
        return durada;
    }
    
   /**
    * @brief retorna el preu de l'Activitat
    * @pre cert
    * @post return preu
    */
    public float preu(){
        
        return preu;
    }
    
   /**
    * @brief actualitza la hora inici de l'Activitat
    * @pre cert
    * @post hinici = _inici
    */
    public void setInici(LocalDateTime _inici){
        hinici=_inici;
    }
    
   /**
    * @brief actualitza la hora final de l'Activitat
    * @pre cert
    * @post hfinal = _final
    */
    public void setFinal(LocalDateTime _final){
        hfinal=_final;
    }
    
   /**
    * @brief retorna la hora final de l'Activitat
    * @pre cert
    * @post return hfinal
    */
    public LocalDateTime getFinal(){
        return hfinal;
    }
    
    public void mostrarHores(){
        if (hinici != null && hfinal != null)
            System.out.println(hinici.toString()+ hfinal.toString());
    }
    
    abstract public PuntInteres piActual();
        
    abstract int satisfaccio(List<String> preferenciesClients);
    
    abstract LocalDateTime hPropera(LocalDateTime hora);
    
    public abstract void mostraProva();

    public abstract void mostrar();
       
    
        
        
    
 
}
