
package proactiva;

import java.time.LocalTime;

public class Horari {
    private String mesIni;
    private int diaIni;
    private String mesFin;
    private int diaFin;
    private LocalTime horaIni;
    private LocalTime horaFi;
    
    
    public Horari(String _mesIni, int _diaIni, String _mesFin, int _diaFin, LocalTime _horaIni, LocalTime _horaFi){
        mesIni = _mesIni;
        diaIni = _diaIni;
        mesFin = _mesFin;
        diaFin = _diaFin;
        horaIni = _horaIni;
        horaFi = _horaFi;
    }
    
    public Horari(String _horari){
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = _horari.split(delimitadors);

        try{
            mesFin=paraulesSeparades[2];
            diaFin=Integer.parseInt(paraulesSeparades[3]);
            horaIni= LocalTime.of(Integer.parseInt(paraulesSeparades[4]),Integer.parseInt(paraulesSeparades[5]));
            horaFi= LocalTime.of(Integer.parseInt(paraulesSeparades[6]),Integer.parseInt(paraulesSeparades[7]));
            mesIni=paraulesSeparades[0];
            diaIni= Integer.parseInt(paraulesSeparades[1]);
        }
        catch(Exception e){
            System.out.println("ERROR, FORMAT DE DADES INCORRECTE");
        }


    }

    public Horari() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}