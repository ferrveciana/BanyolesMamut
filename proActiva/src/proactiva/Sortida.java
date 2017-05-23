
package proactiva;

import java.util.ArrayList;

/**
 *
 * @author fv
 */
public class Sortida {
    private final ArrayList<Activitat> activitats;

    public Sortida(ArrayList<Activitat> _a) {
        activitats=_a;
    }
    

    
    public void KML(){
        ArrayList <String> coo = new ArrayList<>();
        ArrayList <String> noms = new ArrayList<>();
        
        for( Activitat a : activitats){
            //emplenar amb una llista de noms de ciutats amb una llista de coordenades, tot ordenat.
        }

        
        SortidaKML skml = new SortidaKML();
        skml.definirEstils();
        skml.pintarCircuit(coo);
        skml.pintarPunts(noms, coo);
    }
    
    
}


