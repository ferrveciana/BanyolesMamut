package proactiva;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Horari {
    private String mesIni;
    private int diaIni;
    private String mesFin;
    private int diaFin;
    private DuesHores interval;
    
    
    public Horari(String _mesIni, int _diaIni, String _mesFin, int _diaFin, LocalTime _horaIni, LocalTime _horaFi){
        mesIni = _mesIni.toUpperCase();
        diaIni = _diaIni;
        mesFin = _mesFin.toUpperCase();
        diaFin = _diaFin;
        interval = new DuesHores(_horaIni,_horaFi);
    }
    
    public LocalTime _getHoraIni(){
        return interval.getHoraIni();
    }
    
    public Horari(String _horari){
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = _horari.split(delimitadors);
        try{
            interval = new DuesHores(LocalTime.of(Integer.parseInt(paraulesSeparades[4]),Integer.parseInt(paraulesSeparades[5])),LocalTime.of(Integer.parseInt(paraulesSeparades[6]),Integer.parseInt(paraulesSeparades[7])));
            mesFin=paraulesSeparades[2];
            diaFin=Integer.parseInt(paraulesSeparades[3]);
            mesIni=paraulesSeparades[0];
            diaIni= Integer.parseInt(paraulesSeparades[1]);
        }
        catch(NumberFormatException e){
            System.out.println("ERROR, FORMAT DE DADES INCORRECTE");
        }
    }
    /*
    * @pre 
    * @post
    * @brief
    */
    public boolean estaDins(LocalDateTime hora){
        boolean _estaDins = false;
        LocalDate _data = hora.toLocalDate();

        //mesFin=mesFin.toUpperCase();
        //mesIni=mesIni.toUpperCase();
        
        int mesAuxIni = Month.valueOf(mesIni).getValue(); //Ex: January == 1 , October == 10
        int mesAuxFin = Month.valueOf(mesFin).getValue();
        
        int mesAct = _data.getMonthValue();
        int diaAct = _data.getDayOfMonth();
        

        LocalTime horaActual = hora.toLocalTime();

        if(mesAuxFin<mesAuxIni){ //invertits
            if(mesAuxIni==mesAct){
                if(diaAct>=diaIni) _estaDins = true;
            }
            else if(mesAuxFin==mesAct){
                if(diaAct<=diaFin) _estaDins = true;
            }
            else if((mesAuxFin>mesAct && mesAuxIni>mesAct) || (mesAuxFin<mesAct && mesAuxIni<mesAct)) _estaDins = true;
        }
        else if(mesAuxFin>mesAuxIni){ //normal
            
            if(mesAuxIni==mesAct){
                if(diaAct>=diaIni) _estaDins = true;
            }
            else if(mesAuxFin==mesAct){
                if(diaAct<=diaFin) _estaDins = true;
            }        
            if(mesAuxIni<mesAct && mesAuxFin<mesAct) _estaDins = true;
        }
        else{ //mateix mes
            System.out.println("hello");
            if(diaFin>diaIni){ //dies normals
                if(diaIni<diaAct && diaFin>diaAct) _estaDins = true;
            }
        }
        
        //comprovem hora
        if(_estaDins){
            _estaDins=interval.estaAbans(horaActual);
        }
        
        return _estaDins;
    }
    
}
