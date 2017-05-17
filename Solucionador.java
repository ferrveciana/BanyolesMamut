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
    private String tipusRuta;
    
    public Solucionador(String _tipusRuta){
        tipusRuta = _tipusRuta;
        optima = new Solucio();
    }
    
    public void executarNouBkg(Solucio solucio,PuntInteres pi,LocalDateTime hora){
        
         Candidats candidats = solucio.inicialitzarCandidats(pi,hora);
         for (Activitat candidat:candidats){
             
              if (solucio.acceptable(candidat) && solucio.potSerMillor(optima,tipusRuta,candidat)){
                  solucio.anotar(candidat);
                  if (! solucio.completa()){
				executarNouBkg(solucio,candidat.piActual(),solucio.hora()); //seguent candidat
			}
                  else{//Solucio completa
				if (solucio.esMillor(optima,tipusRuta)){
					optima = solucio;
				}
			} 
                  solucio.desanotar(candidat);
            }
        }
        
    }
    
    public Solucio obtOptima(){
        return optima;
    }
    
 
}
