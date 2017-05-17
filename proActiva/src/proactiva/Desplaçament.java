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
public class Desplaçament extends Activitat{
    
    private PuntInteres origen;
    private PuntInteres desti;
    private String tipusTransport; //<fer al constructor
    private int tempsFinsTransport; //fer al constructor
  
    
    public Desplaçament(int _durada,PuntInteres _origen,PuntInteres _desti,float _preu,String  _tipusTransport,int _tempsFinsHub) {
        super(_durada,_preu);
        
        origen = _origen;
        desti = _desti;
        tipusTransport = _tipusTransport;
        tempsFinsTransport=_tempsFinsHub;
    }

    @Override
    public PuntInteres piActual() {
        return desti;
    }

    @Override
    int satisfaccio(List<String> preferenciesClients) {
         return 0; //desp no aporta satisfaccio
    }
    
   @Override
    LocalDateTime hPropera(LocalDateTime hora) {
        if (origen.getCiutat().equals(desti.getCiutat())){//si es urba
            return hora;
        }
        origen.getCiutat().primeraHoraDisponible(origen,desti,tipusTransport);
        else 
            return hora; //per implementar no urbans
        
    }

    
    public void mostraProva() {
       System.out.println(origen.getNom()+" ->" +desti.getNom());
    }
    
    public boolean esIndirecte(){
        
        return tipusTransport.equals("indirecte");
    }
    
    public boolean esPotDesplaçar(){
        return true; //per implementar
    }
    

}
