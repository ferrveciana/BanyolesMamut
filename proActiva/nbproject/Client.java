/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class Client {
    
    private final String nom;
    private final ArrayList<String> prefList;
    private Map<String,LocalDate> visites;
    
    ///@pre:
    ///@post: s'ha creat un client a partir de les dades entrades
    public Client(String _nom, ArrayList<String> _prefList){
        nom=_nom;
        prefList=_prefList;
    }
    
    ///@pre: ---
    ///@post: retorna una llista d’strings amb les preferències de l’objecte actual
    public ArrayList<String> obtPreferencies(){
        return prefList;
    }
    
     public Map<String,LocalDate> obtVisites(){
        return visites;
    }
     
    public void afegirVisita(String nomlloc,LocalDate data){
        visites.put(nomlloc, data);
    }
}