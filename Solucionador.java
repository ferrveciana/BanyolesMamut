package proactiva;

import java.util.List;

/**
 *
 * @author narcisbustins
 */
public class Solucionador {
    
    private Solucio optima;

    
    public void executarBkg(Solucio solucio,PuntInteres pi){
         
       Candidat candidats = solucio.inicialitzarCandidats(pi);
	while (! candidats.esFi()){

		if (solucio.acceptable(candidats) && solucio.potSerMillor(optima,"s",candidats)){
			solucio.anotar(candidats);
	
			if (! solucio.completa()){
				executarBkg(solucio,candidats.actual()); //seguent candidat
			}
			else{//Solucio completa
				if (solucio.esMillor(optima,"s")){
					optima = solucio;
				}
			} 
			solucio.desanotar(candidats);

		}
		candidats.seguent();
	}
    }
    
    public Solucio obtenirSolucioOptima(){
        
        return optima;
    }
    
 
}
