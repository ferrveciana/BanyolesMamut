/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author narcisbustins
 */
public abstract class Activitat {
    
    private int durada;
    private float preu;
    private LocalDateTime hinici;
    private LocalDateTime hfinal;
    
    Activitat(int _durada,float _preu){
        
       durada = _durada;
       preu = _preu;
    }
    
    public int durada(){
        
        return durada;
    }
    
    public float preu(){
        
        return preu;
    }
    
    public void setInici(LocalDateTime _inici){
        hinici=_inici;
    }
    
    public void setFinal(LocalDateTime _final){
        hfinal=_final;
    }
    
    public LocalDateTime getFinal(){
        return hfinal;
    }
    
    abstract public PuntInteres piActual();
        
    abstract int satisfaccio(List<String> preferenciesClients);
    
    abstract LocalDateTime hPropera(LocalDateTime hora);
    
    public abstract void mostraProva();
        
        
    
 
}
