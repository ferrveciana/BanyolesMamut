package proactiva;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Viatge {

private final ArrayList<Client> clients;
private final ArrayList<String> rutes;
private final LinkedList<PuntInteres> destinacions;
private final ArrayList<String> preferenciesViatge;
private final LocalDate dataInici;
private final LocalTime horaInici;
private final int nombreDies;
private final float preuMaxim;
private final String categoria;
private final PuntInteres origen;
private final PuntInteres desti;
  
  
    public Viatge (LocalDate _dataInici, LocalTime _horaInici, int _nombreDies, float _preuMaxim, String _categoria, ArrayList<Client> _clients, LinkedList<PuntInteres> _destinacions, ArrayList<String> _rutes) {
        
        dataInici = _dataInici;
        horaInici = _horaInici;
        nombreDies = _nombreDies;
        preuMaxim = _preuMaxim;
        categoria = _categoria;

        clients = _clients;
        rutes = _rutes;

        origen = _destinacions.get(0);
        desti = _destinacions.get(_destinacions.size()-1);
        destinacions = _destinacions;

        destinacions.removeFirst(); //elimina el primer element de la llista (origen)
        destinacions.removeLast(); //elimina l'ultim element de la llista (desti)
        
        preferenciesViatge = new ArrayList<>();
       
        for (int i = 0; i < clients.size()-1; i++) {
            clients.get(i).mostrar();
            preferenciesViatge.addAll(clients.get(i).obtPreferencies());
        }

        System.out.println("ORIGEN " + origen);
        System.out.println("DESTI " + desti);
  }
  
    public PuntInteres origen() {
      
        return origen;
    }
  
    public PuntInteres desti() {
      
        return desti;
    }
  
    public float preuMax() {
       
        return preuMaxim;
    }
   
    public HashMap<PuntInteres,Boolean> destinacions() {
       
        HashMap<PuntInteres,Boolean> mapa = new HashMap<>();
        
        for (PuntInteres PI : destinacions)
            mapa.put(PI,false);
        
        return mapa;
    }
  
    public List<String> preferencies() {
        System.out.println("LA PUTA MARE");
        return preferenciesViatge;
   }
}


