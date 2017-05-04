
import java.util.List;

/**
 *
 * @author narcisbustins
 */
public class Solucionador {
    
    private List<Lloc> primaris;
    private List<PuntInteres> secundaris;
    private Circuit solucio;
    private List<Circuit> optima;
 
    
    public void solucionarInterior(int iP){
        
        while (iP<secundaris.size()){
            PuntInteres candidat = secundaris.get(iP);
            if (solucio.acceptable(candidat) & solucio.potSerMillor(candidat,optima)){
                solucio.afegir(candidat);
                if (! solucio.completa()){
                    solucionar(iP+1);
                }
                else {
                    if (solucio.esMillor(optima)){
                        optima = solucio;
                    }
                }
                solucio.desanotar(candidat);
            }
        }
        
    }
    
    public void solucionar(){
        
        int iCiutat=0;
        while (iCiutat < primaris.size()){
            
              Ciutat ciutatActual = (Ciutat) primaris.get(iCiutat);
              secundaris = ciutatActual.obtenirPuntInteres();
              int iSecundaris = 0;
              solucionarInterior(iSecundaris);  
        }

    }
 
}
