package prop;


import java.time.LocalDateTime;
import java.util.List;

public class TransportIndirecte implements MitjaTransport {
    private final String origen;
    private final String desti;
    private final String mitja;
    private final int tempsOrigen2Tnsp;
    private final int tempsTnsp2Desti;
    private final List<LocalDateTime> data_hora_sortida; //https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html
    private final List<Integer> durada;
    private final List<Float> preu;
    
    public TransportIndirecte(String o,String d,String m,int tO2T,int tT2D, List<LocalDateTime> dhs, List<Integer> dur, List<Float> pr){
        origen=o;
        desti=d;
        mitja=m;
        tempsOrigen2Tnsp=tO2T;
        tempsTnsp2Desti=tT2D;
        data_hora_sortida=dhs;
        durada=dur;
        preu=pr;
    }
    
    
    @Override
    public String obtenirDesti(){
        return desti;
    }
    
    @Override
    public double obtenirPreu(){
        return 0;
       
    }
    
    @Override
    public int obtenirTemps(){
        return 0;
        
    }
    
}