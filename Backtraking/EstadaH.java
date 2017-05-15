/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author narcisbustins
 */
public class EstadaH extends Activitat{ // no te durada fixada
    
    private Allotjament hotel;
    
    public EstadaH(int _durada, float _preu,Allotjament _hotel) {
        super(_durada,_preu);
        hotel = _hotel;
    }
    
    public int getCategoria(){
        return hotel.getCategoria();
    }

    @Override
    public PuntInteres piActual() {
        return hotel;
    }

    @Override
    int satisfaccio(List<String> preferenciesClients) {
        
        int suma = 0;
        List<String> llistaCaracteristiques = hotel.obtenirCaracteristiques();
        for (String c:llistaCaracteristiques){
            if (preferenciesClients.contains(c)) suma++;
        }
        
        return suma;
    }

    @Override
    LocalDateTime hPropera(LocalDateTime hora) {
        return hora;
    }
    
}
