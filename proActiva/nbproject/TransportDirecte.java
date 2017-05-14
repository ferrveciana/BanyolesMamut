package proactiva;


public class TransportDirecte{
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
    
    /**
     * @pre --
     * @return retorna el preu de l'objecte actual
     */
    public double obtenirPreu(){
        return preu;
    }
    
    /**
     * @pre --
     * @return retorna el temps en minuts del trajecte
     */
    public int obtenirDurada(){
        return durada;
    }
    
    /**
     * @pre --
     * @return retorna el desti del transport
     */
    public String obtenirDesti(){
        return desti;
    }

}