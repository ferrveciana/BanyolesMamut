package prop;

import java.time.LocalTime;

public class Horari {
    private String mesIni;
    private int diaIni;
    private String mesFin;
    private int diaFin;
    private LocalTime horaIni;
    private LocalTime horaFi;
    private List<diaExcepcio> DiaExcepcional;
    
    
    public Horari(String _horari){
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = _horari.split(delimitadors);

        if(paraulesSeparades[2].length()>2){//cas no excepcional fins a paraulesSeparades[7]
            mesFin=paraulesSeparades[2];
            diaFin=Integer.parseInt(paraulesSeparades[3]);
            horaIni= LocalTime.of(Integer.parseInt(paraulesSeparades[4]),Integer.parseInt(paraulesSeparades[5]));
            horaFi= LocalTime.of(Integer.parseInt(paraulesSeparades[6]),Integer.parseInt(paraulesSeparades[7]));
        }
        else{//cas escepcional fins a paraulesSeparades[5]
            horaIni= LocalTime.of(Integer.parseInt(paraulesSeparades[2]),Integer.parseInt(paraulesSeparades[3]));
            horaFi= LocalTime.of(Integer.parseInt(paraulesSeparades[4]),Integer.parseInt(paraulesSeparades[5]));
        }
        mesIni=paraulesSeparades[0];
        diaIni= Integer.parseInt(paraulesSeparades[1]);
    }
}
