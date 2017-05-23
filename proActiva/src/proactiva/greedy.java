/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;

import java.time.LocalDateTime;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author narcisbustins
 */
public class GreedyAlg {
    
    
    private Solucio solucio; //te preuMax,desitjos,etc...
    private PuntInteres origen;
    private PuntInteres desti;
    private String tipus;
    private TreeSet<PuntInteres> pi_visitats;
    
    
    
    public Activitat mesPrometedor( Candidats candidats,boolean acaba){
        return null;
    }
    
    public void executarGreedy(){
        boolean acaba = false;
        List<Activitat> llistaCandidats;
        Activitat activitat_actual = null;
        PuntInteres pi_actual = origen;
                
        
       
        while (!acaba && !(activitat_actual.piActual().equals(desti))){
            
            //Inicialitzar candidats
            Candidats candidats = solucio.inicialitzarCandidats(origen);
            
            //Seleccionar candidat mes prometedor
            activitat_actual = mesPrometedor(candidats,acaba);
            
            //anotar
            solucio.anotar(activitat_actual); //a solucio
            if (!(activitat_actual instanceof Desplaçament)){
                pi_visitats.add(pi_actual);//a visitat si no es desplaçament
            }
            
            if (! acaba){
                 pi_actual = activitat_actual.piActual();
            }
           
        }
        
        
    }
}

