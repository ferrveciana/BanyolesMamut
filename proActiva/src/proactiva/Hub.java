package proactiva;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    
    /**
     * @pre cert
     * @post retorna la suma de temps origen fins a hub + hub fins desti 
     */
    public int obtenirDurada(){
        return (tempsOrigen2Tnsp+tempsTnsp2Desti);
    }
    
    /**
     * @pre cert
     * @post retorna cert si l'origen, desti i mitja de transport coincideixen amb el hub actual
     * @brief 
     */
    public boolean esIgual(String o,String d,String tipus){
        return (origen.equals(o) && desti.equals(d) && mitja.equals(tipus) );
    }
    
   public ArrayList<TransportIndirecte> obtenirTransportIndirecte (LocalDateTime hora){
       return horaris.get(hora.toLocalDate());
   }
    
    /**
    * @pre hora valida
    * @post retorna l'hora de sortida (del transport) mes pròxima a partir de l'hora actual
    * @brief retorna l'hora de sortida (del transport) mes pròxima a partir de l'hora actual
    */
    public LocalDateTime hPropera(LocalDateTime hora){
        
        LocalDate data = hora.toLocalDate();
        LocalTime horaAct = hora.toLocalTime();
        ArrayList<TransportIndirecte> transports = horaris.get(data);
        
        boolean trobat = false;
        int i=0;
        while(i<transports.size() && !trobat){
            if(horaAct.isBefore(transports.get(i).getHora()) || horaAct.equals(transports.get(i).getHora())){ //el primer k trobi que l'horaAct sigui
                trobat = true;
            }
            else i++;
        }
        LocalDateTime sol = LocalDateTime.of(data,transports.get(i).getHora());
        return sol;
    }
    
    /**
    * @pre hora valida
    * @post retorna cert si podra anar en aquest transport durant dia actual, fals altrament
    * @brief retorna cert si pot anar en aquest transport durant el dia actual
    */
    public boolean sHiPotAnar(LocalDateTime hora){
        
        hora.plusMinutes(tempsOrigen2Tnsp); //sumem el temps que tarda a anar al hub per saber si podra agafar el transport o no
        LocalDate data = hora.toLocalDate();
        LocalTime horaAct = hora.toLocalTime();
        ArrayList<TransportIndirecte> transports = horaris.get(data);
        int i = transports.size()-1; //mires l'ultima hora del dia
        
        return (horaAct.isBefore(transports.get(i).getHora()) || horaAct.equals(transports.get(i).getHora()));
    }

    Ciutat getCiutat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    PuntInteres obtenirDestiPi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}