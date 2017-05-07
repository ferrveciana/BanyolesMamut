package proactiva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author FV
 */
public class Hub {
    private final String origen;
    private final String desti;
    private final String mitja;
    private final int tempsOrigen2Tnsp;
    private final int tempsTnsp2Desti;
    
    private final HashMap<LocalDate,ArrayList<TransportIndirecte>> horaris;
    
    
    public Hub(String o,String d,String m,int tO2T,int tT2D, HashMap<LocalDate,ArrayList<TransportIndirecte>> tI){
        origen=o;
        desti=d;
        mitja=m;
        tempsOrigen2Tnsp=tO2T;
        tempsTnsp2Desti=tT2D;
        horaris=tI;
    }
    
    /**
     * @param data
     * @param transports
     * @pre: data existent
     * @post: ha afegit un dia amb tots els seus transports al map
     */
    public void afegirHoraris(LocalDate data,ArrayList<TransportIndirecte> transports){
        horaris.put(data,transports);
    }
    
}
