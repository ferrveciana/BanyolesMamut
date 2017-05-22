/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @class Client
 * @brief Classe que guarda les dades d'un client
 */
public class Client {
    
    private final String nom; ///< nom del Client
    private final ArrayList<String> prefList; ///< llista de preferencies del Client
    private Map<String,LocalDate> visites; ///< llista de visites que el Client ha realitzat anteriorment
    
   /**
     * @brief constructor de Client a partir de les dades que li passem
     * @pre cert
     * @post Client creat
     */
    public Client(String _nom, ArrayList<String> _prefList){
        nom=_nom;
        prefList=_prefList;
        visites = new HashMap<String,LocalDate>();
    }
    
   /**
     * @brief retorna la llista de preferencies de Client
     * @pre cert
     * @post return prefList
     */
    public ArrayList<String> obtPreferencies(){
        return prefList;
    }
    
   /**
     * @brief retorna la llista de visites de Client
     * @pre cert
     * @post return visites
     */
     public Map<String,LocalDate> obtVisites(){
        return visites;
    }
     
   /**
     * @brief afegeix una visita que ha realitzat anteriorment el Client a la llista de visites
     * @pre cert
     * @post visita afegida a visites
     */
    public void afegirVisita(String nomlloc,LocalDate data){
        visites.put(nomlloc, data);
    }
}
