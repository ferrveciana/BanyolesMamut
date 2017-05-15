/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;

import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author narcisbustins
 */
public class Allotjament extends PuntInteres{
  
    private final int categoria;

    public Allotjament(String _nom, String _coordenada, TimeZone _zonaHoraria, double _preu, List<String> _caract,int _categoria){
        
        super(_nom, _coordenada, _zonaHoraria, _preu, _caract);
        categoria = _categoria;
        
    }
    
    public int getCategoria(){
        return categoria;
    }
/*
    @Override
    public String tipus() {
        return ("Allotjament");
    }
*/
    
}