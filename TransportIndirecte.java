package prop;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TransportIndirecte{
    
    private final List<LocalTime> horaris;
    private final List<Integer> durada;
    private final List<Float> preu;
    
    public TransportIndirecte(){
        horaris= new ArrayList();
        durada= new ArrayList();
        preu= new ArrayList();
    }
    
    public int passarInt(String hora){
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = hora.split(delimitadors);
        return (Integer.parseInt(paraulesSeparades[0])*60+Integer.parseInt(paraulesSeparades[1]));        
    }
    
    public LocalTime passarHora(String hora){
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = hora.split(delimitadors);
        return (LocalTime.of(Integer.parseInt(paraulesSeparades[0]),Integer.parseInt(paraulesSeparades[1])));
    }
    
    public void afegir(String hora,String temps,String pr){
        horaris.add(passarHora(hora));
        durada.add(passarInt(temps));
        preu.add(Float.parseFloat(pr));
    }
    /*
    public void afegirHorari(LocalTime h,){
        horaris.add(h);
    }
    
    public void afegirDurada(int temps){
        durada.add(temps);
    }
    
    public void afegirPreu(float _pr){
        preu.add(_pr);
    }*/
}