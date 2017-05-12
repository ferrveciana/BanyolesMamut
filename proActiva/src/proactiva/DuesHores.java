/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;

import java.time.LocalTime;

public class DuesHores {
    private final LocalTime horaIni;
    private final LocalTime horaFi;
    
    public DuesHores(LocalTime hI, LocalTime hF){
        horaIni=hI;
        horaFi=hF;
    }
    
    public boolean estaEntreMig(LocalTime h ){
        return (h.isAfter(horaIni) && h.isBefore(horaFi));
    }
    
}