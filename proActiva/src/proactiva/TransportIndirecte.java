package proactiva;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ferran Veciana
 */

public class TransportIndirecte{
    
    private final LocalTime horaris;
    private final int durada;
    private final float preu;
    
    public TransportIndirecte(String _horaris, String _durada, float _preu){
        
        horaris= passarHora(_horaris);
        durada= passarInt(_durada);
        preu= _preu;
    }
    
    /**
     * 
     * @pre hora en format hour:min
     * @post retorna el temps passat a minuts
     * @brief retorna el temps passat a minuts
     */
    private int passarInt(String hora){
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = hora.split(delimitadors);
        return (Integer.parseInt(paraulesSeparades[0])*60+Integer.parseInt(paraulesSeparades[1]));        
    }
    
    /**
     * 
     * @pre hora valida en format hour:min
     * @post retorna la hora en format LocalTime
     * @brief retorna la hora en format LocalTime
     */
    private LocalTime passarHora(String hora){
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = hora.split(delimitadors);
        return (LocalTime.of(Integer.parseInt(paraulesSeparades[0]),Integer.parseInt(paraulesSeparades[1])));
    }
    
    /**
     * @pre cert
     * @post retorna l'hora de sortida del transport indirecte
     * @brief retorna l'hora de sortida del transport indirecte
     */
    public LocalTime getHora(){
        return horaris;
    }
    
    /**
     * @pre cert
     * @post retorna la durada del transport
     * @bried retorna la durada del transport
     */
    public int obtenirDurada(){
        return durada;
    }
    
    /**
     * @pre cer
     * @post retorna el preu del transport
     * @brief retorna el preu del transport
     */
    public float obtenirPreu(){
        return preu;
    }
    
//    public void afegir(String hora,String temps,float pr){
//        horaris.add(passarHora(hora));
//        durada.add(passarInt(temps));
//        preu.add(pr);
//    }

}