package proactiva;


public class TransportDirecte{
    private final PuntInteres origen;
    private final PuntInteres desti;
    private final String mitja;
    private final int durada;
    private final double preu;

    
    public TransportDirecte(PuntInteres o, PuntInteres d, String m, int _durada, double _preu){

        origen=o;
        desti=d;
        mitja=m;
        durada=_durada;
        preu=_preu;
    }
    
    /**
     * @pre --
     * @post retorna el preu de l'objecte actual
     */
    public double obtenirPreu(){
        return preu;
    }
    
    /**
     * @pre --
     * @post retorna el temps en minuts del trajecte
     */
    public int obtenirDurada(){
        return durada;
    }
    
    /**
     * @pre --
     * @post retorna el desti del transport
     */
    public PuntInteres obtenirDesti(){
        return desti;
    }

}