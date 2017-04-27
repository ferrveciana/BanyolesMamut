package prop;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransportIndirecte implements MitjaTransport {
    private String origen;
    private String desti;
    private String mitja;
    private int tempsOrigen2Tnsp;
    private int tempsTnsp2Desti;
    private List<LocalDateTime> data_hora_sortida; //https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html
    private List<Integer> durada;
    private List<Float> preu;
    
    public TransportIndirecte(String o,String d,String m,int tO2T,int tT2D, List<LocalDateTime> dhs, List<Integer> dur, List<Integer> pr){
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
        ret
    }
    
    public int obtenirTemps(){
        
    }
    
}
