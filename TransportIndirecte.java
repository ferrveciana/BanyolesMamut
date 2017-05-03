package prop;


import java.time.LocalTime;
import java.util.List;

public class TransportIndirecte{
    private final List<LocalTime> horaris;
    private final List<Integer> durada;
    private final List<Float> preu;
    
    public TransportIndirecte(List<LocalTime> _horaris, List<Integer> _durada, List<Float> _preu){
        horaris=_horaris;
        durada=_durada;
        preu=_preu;
    }
    
    public void afegirHorari(LocalTime h){
        horaris.add(h);
    }
    
    public void afegirDurada(int temps){
        durada.add(temps);
    }
    
    public void afegirPreu(float _pr){
        preu.add(_pr);
    }
}