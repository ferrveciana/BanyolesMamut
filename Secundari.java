package prop;

import java.util.List;

public interface Secundari {
    
    //Pre: ---
    //Post: Retorna la llista de característiques                                                                                              
    public List<String>obtenirCaracteristiques();

    //Pre: ---
    //Post: Retorna el preu de visitable, si es gratuit retorna 0      
    public double obtenirPreu();

}
