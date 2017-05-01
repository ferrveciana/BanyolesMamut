package prop;


import java.time.LocalTime;
import java.util.List;

public class TransportIndirecte{
    private List<LocalTime> horaris;
    private final List<Integer> durada;
    private final List<Float> preu;
    
    public TransportIndirecte(List<LocalTime> _horaris, List<Integer> _durada, List<Float> _preu){
        horaris=_horaris;
        durada=_durada;
        preu=_preu;
    }

}