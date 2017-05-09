package proactiva;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author narcisbustins
 */
public class Solucio {
    
    private List<PuntInteres> llistaPi;//GRAF
    private Map<String,Boolean> visitats; //llista de visitats
    
    private LinkedList<PuntInteres> circuit;
    
    PuntInteres origen;
    PuntInteres desti;
    
    int satisfaccio;
    int satAct;
    
    double preuMax;
    double preuAct;
    
    Solucio(List<PuntInteres> _llistaPi,PuntInteres _origen, PuntInteres _desti,int _satisfaccio,double _preuMax){
        
        preuMax=0;
        satAct=0;
        
        llistaPi = _llistaPi;
        origen = _origen;
        desti = _desti;
        satisfaccio = _satisfaccio;
        preuMax = _preuMax;
        
        visitats = new HashMap<String,Boolean>();
        circuit = new LinkedList<PuntInteres>();
        
    }
    
   
    
    void anotar(Candidat candidat){
        
        circuit.add(candidat.actual());
        visitats.put(candidat.actual().getNom(),true);
        //sumar preu
        //sumar satisfaccio
        
    }
    
    void desanotar(Candidat candidat){
        
        //restar preu
        //restar satisfaccio
        circuit.remove(candidat.actual());
    }
    
    public boolean completa(){
        
        return circuit.contains(desti);
    }
    
    boolean esMillor(Solucio optima,String param){
        
        boolean millor = false;
        if (param.equals('s')){
            if (satisfaccio > optima.satisfaccio)
                millor = true;
        }
        
        return millor;
       
    }
    
    public boolean potSerMillor(Solucio optima,String param,Candidat candidat){
        
        return true;
        
    }

    public Candidat inicialitzarCandidats(PuntInteres _pi) {
        return new Candidat(_pi);
    }
    
    public boolean acceptable(Candidat candidats){
        boolean accept = false;
        PuntInteres pi = candidats.actual();
        
        if (pi.obtenirPreu()+preuAct < preuMax){
            accept = true;
        }
        
        return accept;
    }
    
    
}
