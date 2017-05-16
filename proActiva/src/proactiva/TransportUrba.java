package proactiva;

public class TransportUrba {
    private final String ciutat;
    private final String mitja;
    private final int durada;
    private final float preu;
    
    public TransportUrba(String _ciutat,String _mitja, int _durada, float _preu){
        ciutat=_ciutat;
        mitja=_mitja;
        durada=_durada;
        preu=_preu;
    }
    
    public int obtenirDurada() {
        return durada;   
    }
    
    public float obtenirPreu() {
        return preu;   
    }
}
