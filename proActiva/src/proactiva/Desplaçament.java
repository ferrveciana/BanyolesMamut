/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;

import java.time.LocalDateTime;
import java.util.List;

/*
 * @class Desplaçament
 * @brief Classe que extèn Activitat en cas que aquesta es tracti d'un Desplaçament d'un Punt d'Interes a un altre
 */
public class Desplaçament extends Activitat{
    
    private PuntInteres origen; ///< origen del Desplaçament
    private PuntInteres desti; ///< desti del Desplaçament
    private String tipusTransport; ///< tipus de transport amb el que s'ha fet el Desplaçament (directe, indirecte, urba)
 
   /**
     * @brief constructor de Desplaçament a partir de les dades que li passem
     * @pre cert
     * @post Desplaçament creat
     */
    public Desplaçament(int _durada,PuntInteres _origen,PuntInteres _desti,float _preu,String  _tipusTransport) {
        super(_durada,_preu);
        
        origen = _origen;
        desti = _desti;
        tipusTransport = _tipusTransport;
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
        
        if (esIndirecte()){
            return origen.getCiutat().primeraHoraDisponible(origen.nom,desti.nom,tipusTransport,hora);
        }
        else
            return hora; //per implementar no urbans
        
    }

   /**
     * @brief 
     * @pre 
     * @post 
     */
    public void mostraProva() {
       System.out.println(origen.getNom()+" ->" +desti.getNom());
    }
    
   /**
     * @brief retorna un boolea segons el tipusTransport del Desplaçament
     * @pre cert
     * @post return cert si tipusTransport de Desplaçament es indirecte, altrament retorna fals 
     */
    public boolean esIndirecte(){
        
        return tipusTransport.equals("indirecte");
    }
    
   /**
     * @brief retorna un boolea que ens diu si podem realitzar el Desplaçament
     * @pre cert
     * @post return cert si el Desplaçament es pot dur a terme, altrament return false
     */
    public boolean esPotDesplaçar(){
        if (esIndirecte()){
            return origen.getCiutat().esPotMoure(origen.nom,desti.nom,tipusTransport,hora);
        }
        else return true;
    }
    

}
