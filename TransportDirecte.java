package prop;


public class TransportDirecte implements MitjaTransport {
    private final String origen;
    private final String desti;
    private final String mitja;
    private final int durada;
    private final double preu;
    
    public TransportDirecte(String o, String d, String m, int _durada, double _preu){
        origen=o;
        desti=d;
        mitja=m;
        durada=_durada;
        preu=_preu;
    }
  
    @Override
    public String obtenirDesti(){
        return desti;
    }
    
    @Override
    public double obtenirPreu(){
        return preu;
    }
    
    @Override
    public int obtenirTemps(){
        return durada;
    }
    
}
