
package proactiva;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

public class Visitable extends PuntInteres {
    
   
    private final int tempsVisita;
    private final List<Horari> horariVisites;
    private final HashMap<String,DuesHores> excepcions; //string = data, DuesHores son les hores Ini Fi de l'excepcio


    public Visitable(String _nom, String _coordenada, TimeZone _zonaHoraria, float _preu, ArrayList<String> _caract, ArrayList<Horari> _horariVisites, int _tempsVisita, HashMap<String,DuesHores> _excepcions) {
        super(_nom, _coordenada, _zonaHoraria, _preu, _caract);
        horariVisites=_horariVisites;
        tempsVisita=_tempsVisita;
        excepcions=_excepcions;
        
    }
    
    public Boolean esPotVisitar(LocalDateTime hora){
        
        hora = hora.plusMinutes(tempsVisita); //sumem el temps de visita a l'hora actual
        LocalDate _dia = hora.toLocalDate(); //tinc la data
        String dia = LocalDate2dia(_dia);
        boolean esExcepcio = false;
        boolean _esPotVisitar = false;
        if(excepcions.containsKey(dia)){
            esExcepcio=true;
            DuesHores interval = excepcions.get(dia);
            LocalTime horaDpsVisita = hora.toLocalTime();
            if (interval.estaAbans(horaDpsVisita)){
                _esPotVisitar = true;
            }
        }
        if(!esExcepcio){
            int i = 0;
            Horari h;
            boolean  acaba = false;
            while(! acaba && i<horariVisites.size()-1){
                h = horariVisites.get(i);
                acaba = horariVisites.get(i).estaDins(hora);
                i++;
            }
            if(acaba) _esPotVisitar = true;
        }
        
        return (_esPotVisitar);
    }
    
    /*
    * @pre sera possible visitar el visitable aquest dia
    * @post retorna la hora en la que es pot visitar el visitable
    * @brief 
    */
    public LocalDateTime hPropera(LocalDateTime hora){
        
        LocalTime sol = hora.toLocalTime();
        LocalDate _dia = hora.toLocalDate(); //tinc la data
        String dia = LocalDate2dia(_dia);
        if(excepcions.containsKey(dia)){
            DuesHores interval = excepcions.get(dia);
            sol = interval.getHoraIni();
        }
        else{
            int i = 0;
            Horari h;
            boolean  acaba = false;
            while(! acaba && i<horariVisites.size()-1){
                h = horariVisites.get(i);
                acaba = horariVisites.get(i).estaDins(hora);
                i++;
                if(acaba) sol = h._getHoraIni();
            }
        }
        if(sol.isBefore(hora.toLocalTime())) sol = hora.toLocalTime();
        LocalDateTime res = LocalDateTime.of(_dia, sol);
        return res;
    }
    
    
    /*
    * @pre LocalDate dia valida
    * @post retorna la data passada a String en format "April 15"
    * @brief transforma la LocalDate a String
    */
    private String LocalDate2dia(LocalDate dia) {

        String sol="";
        int mesNum = dia.getMonthValue();
        Month mesx = dia.getMonth();
        switch (mesx) {
            case APRIL:
                sol = "April";
                break;
            case AUGUST:
                sol = "August";
                break;
            case DECEMBER:
                sol = "December";
                break;
            case FEBRUARY:
                sol = "February";
                break;
            case JANUARY:
                sol = "January";
                break;
            case JULY:
                sol = "July";
                break;
            case JUNE:
                sol = "June";
                break;
            case MARCH:
                sol = "March";
                break;
            case MAY:
                sol = "May";
                break;
            case NOVEMBER:
                sol = "November";
                break;
            case OCTOBER:
                sol = "October";
                break;
            case SEPTEMBER:
                sol = "September";
                break;
            default:
                break;
        }
        
        sol=sol+" "+mesNum;
        return sol;
    }
    
}
