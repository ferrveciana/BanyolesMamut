/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

/**
 *
 * @author narcisbustins
 */
public class Visitable extends PuntInteres {
    
   
    private final int tempsVisita;
    private final List<Horari> horariVisites;
    private HashMap<String,DuesHores> excepcions;


    public Visitable(String _nom, String _coordenada, TimeZone _zonaHoraria, float _preu, ArrayList<String> _caract, ArrayList<Horari> _horariVisites, int _tempsVisita, HashMap<String,DuesHores> _excepcions) {
        super(_nom, _coordenada, _zonaHoraria, _preu, _caract);
        horariVisites=_horariVisites;
        tempsVisita=_tempsVisita;
        excepcions=_excepcions;
        
    }
    
    @Override
    public String tipus() {
        String t = "Visitable";
        if (horariVisites.isEmpty()) t = "Pas";
        return t;
    }
    
}