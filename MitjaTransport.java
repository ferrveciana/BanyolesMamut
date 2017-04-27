package prop;

public interface MitjaTransport {
    
    //Pre: lloc existeix
    //Post: Retorna el desti on s’arriba a partir de lloc
    public String obtenirDesti();
    
    //Pre: lloc existeix
    //Post: Retorna el preu de viatjar
    public double obtenirPreu();

    //Pre: lloc existeix
    //Post: Retorna el temps que es tarda per viatjar
    public int obtenirTemps();
    
        
}
