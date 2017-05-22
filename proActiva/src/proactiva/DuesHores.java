
package proactiva;

import java.time.LocalTime;

/**
 * 
 * @author Ferran Veciana
 */
public class DuesHores {
    private final LocalTime horaIni; ///hora inicial de l'interval
    private final LocalTime horaFi; ///hora final de l'interval
    
    public DuesHores(LocalTime hI, LocalTime hF){
        horaIni=hI;
        horaFi=hF;
    }
    
    /**
    * @pre cert
    * @post retorna la hora inicial (horaIni)
    * @brief retorna la hora inicial
    */
    public LocalTime getHoraIni(){
        return horaIni;
    }
    
    /**
    * @pre hora h vàlida
    * @post retorna cert si encara hi podrà anar aquell dia
    * @breif retorna cert si encara hi podrà anar aquell dia
    */
    public boolean estaAbans(LocalTime h){
        return (h.isBefore(horaFi));
    }
    
}
