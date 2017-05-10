/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;

import java.time.LocalDateTime;
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
    private LinkedList<accio> ruta;
    
    PuntInteres origen;
    PuntInteres desti;
    
    int satisfaccio;
    int satAct;
    
    double preuMax;
    double preuAct;
    
    PuntInteres anterior;
    LocalDateTime hora;
    
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
        
        PuntInteres pi = candidat.actual();
        
        if (anterior!= pi){//Moures
            
            String moviment = pi.getNom();
            moviment+=anterior.getNom();
            
            int temps_trajecte=0;//funcior obtenir temps
            ruta.add(new accio(moviment,hora,hora.plusMinutes(temps_trajecte)));
            
            circuit.add(pi);
            //sumar temps transport
            anterior = pi;
        }
        else {
            
            if (pi.getNom().equals("Esperar")){
            //??
            }
            else if (pi instanceof Visitable){
           
              preuAct+=pi.obtenirPreu();
              hora.plusMinutes(((Visitable) pi).getTemps());
            
            }
            else if (pi instanceof Allotjament){
                preuAct+=pi.obtenirPreu();
                //acabar dia
            }
            
            
        }
        
        
        
      
        
        
        circuit.add(pi);
        
        
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
    
    public LocalDateTime hora(){
        return hora;
    }
    
}
///////
public class Candidat {
    
    private int index; //Indica la posicio del candidat actual
    private List<PuntInteres> llistaCandidats; //conte la llista amb tots els candidats
    
    Candidat(PuntInteres _pi){
        
        llistaCandidats = new ArrayList<PuntInteres>();
        PuntInteres esp = new PuntInteres("Esperar", "", null, 0,null);
        llistaCandidats.add(_pi);
        //llistaCandidats.add veins i destinacions hub 
        llistaCandidats.add(esp);
        index = 0;
        //llistaCandidats = _pi.veins(); 
    }

    PuntInteres actual() {
        
        //if (esFi()) throw("No hi ha mes candidats");
        return llistaCandidats.get(index);
    }

    boolean esFi() {
        
        return (llistaCandidats.size() == index);
    }
    
    void seguent(){
        
        //if (esFi()) throw("No hi ha mes candidats");
        index++;
    }
    
}

/// */
public class Solucionador {
    
    private Solucio optima;

    
    public void executarBkg(Solucio solucio,PuntInteres pi,LocalDateTime hora){
         
        Candidat candidats = solucio.inicialitzarCandidats(pi);
        
	while (! candidats.esFi()){

		if (solucio.acceptable(candidats) && solucio.potSerMillor(optima,"s",candidats)){
			solucio.anotar(candidats);
	
			if (! solucio.completa()){
				executarBkg(solucio,candidats.actual(),solucio.hora()); //seguent candidat
			}
			else{//Solucio completa
				if (solucio.esMillor(optima,"s")){
					optima = solucio;
				}
			} 
			solucio.desanotar(candidats);

		}
		candidats.seguent();
	}
    }
    
    public Solucio obtenirSolucioOptima(){
        
        return optima;
    }
    
 
}
