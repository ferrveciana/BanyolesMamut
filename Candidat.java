package proactiva;

import java.util.List;

/**
 *
 * @author narcisbustins
 */
public class Candidat {
    
    private int index; //Indica la posicio del candidat actual
    private List<PuntInteres> llistaCandidats; //conte la llista amb tots els candidats
    
    Candidat(PuntInteres _pi){
        index = 0;
        llistaCandidats = _pi.veins(); 
    }

    PuntInteres actual() {
        
        //if (esFi()) throw("No hi ha mes candidats");
        return llistaCandidats.get(index);
    }

    boolean esFi() {
        
        return (llistaCandidats.size() == index);
    }
    
    void seguent(){
        
        //if (esFi()) throw("No hi ha mes candidats");
        index++;
    }
    
}
