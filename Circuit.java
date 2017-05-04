/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prop;

import java.util.ArrayList;

/**
 *
 * @author aula
 */
public class Circuit {
    
    private final ArrayList<String> llocs;

    public Circuit() {
        llocs = new ArrayList<>();
    }
    
    /**
     * @pre --
     * @return true si l'objecte actual es buit
     */
    public boolean esBuit(){
        return(llocs.isEmpty());
    }
    
    /**
     *
     * @param r1
     * @pre --
     * @post s'han concatenat les llistes, el circuit r1 darrera de l'objecte actual
     */
    public void concatenarRuta(Circuit r1){
        while(!r1.esBuit()){
            llocs.add(r1.llocs.get(0));
            r1.llocs.remove(0);
        }
    }
    
}
