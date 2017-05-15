/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;

import java.time.LocalDateTime;
import java.util.List;
//va a agencia

/**
 *
 * @author narcisbustins
 */
public class Solucionador {
    
    private Solucio optima;
    
    public void executarNouBkg(Solucio solucio,PuntInteres pi,LocalDateTime hora){
        
         Candidats candidats = solucio.inicialitzarCandidats(pi);
         for (Activitat candidat:candidats){
             
              if (solucio.acceptable(candidat) && solucio.potSerMillor(optima,"s",candidat)){
                  solucio.anotar(candidat);
                  if (! solucio.completa()){
				executarNouBkg(solucio,candidat.piActual(),solucio.hora()); //seguent candidat
			}
                  else{//Solucio completa
				if (solucio.esMillor(optima,"s")){
					optima = solucio;
				}
			} 
                  solucio.desanotar(candidat);
            }
        }
        
    }
    
}
