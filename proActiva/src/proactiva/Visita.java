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
class Visita extends Activitat {
    
    private Visitable visitable;
    private int durada;

   
    public Visita(int _durada,float _preu,Visitable _visitable) {
        super(_durada,_preu);
        visitable = _visitable;
    }
   
    public boolean esPotVisitar(LocalDateTime hora) {
       
        return visitable.esPotVisitar(hora);
    }

    @Override
    public PuntInteres piActual() {
        return visitable;
    }

    @Override
    int satisfaccio(List<String> preferenciesClients) {
        
        int suma = 0;
        List<String> llistaCaracteristiques = visitable.obtenirCaracteristiques();
        for (String c:llistaCaracteristiques){
            if (preferenciesClients.contains(c)) suma++;
        }
        
        return suma;
    } 
    
     boolean realitzarAvui(LocalDateTime hora) {
         
        return visitable.esPotVisitar(hora);
    }

    @Override
    LocalDateTime hPropera(LocalDateTime hora) {
        return visitable.hPropera(hora);
    }

    @Override
    public void mostraProva() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
