package proactiva;



import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author narcisbustins
 */

public class Candidats implements Iterable<Activitat>{ 
    
    private int index; ///<Indica la posicio del candidat actual
    private List<Activitat> llistaActivitats; 
    
   	Candidats (PuntInteres _pi, LocalDateTime hora){
        
		llistaActivitats = new ArrayList();
		
		//Crear candidats amb transports directes
		List<TransportDirecte> llistaTransportsDirectes = _pi.obtenirTransportsDirectes();

		for (int i = 0; i < llistaTransportsDirectes.size(); i++) {
			Desplaçament desplaçamentDirecte = new Desplaçament(llistaTransportsDirectes[i].obtenirDurada(),_pi,llistaTransportsDirectes[i].obtenirDesti(),llistaTransportsDirectes[i].obtenirPreu(),"directe");
			llistaActivitats.add(desplaçamentDirecte); //falta afegir un string per saber quin tipus de transport es tracta
		}
		
		//Crear candidats amb transports urbans
		String ciutat = _pi.getCiutat(); //fer try catch
		List<TransportUrba> transportsUrbans = ciutat.obtenirTransports();
		List<PuntInteres> puntsInteres = _pi.getCiutat().obtenirPuntInteres();
		
		for (int i = 0; i < transportsUrbans.size(); i++) { //per cada transport urba de la ciutat
			for (int j = 0; j < puntsInteres.size(); j++) { //per cada punt d'interes de la ciutat
				//Afegir transports urbans del punt d'Interes actual a la resta de punts d'Interes de la ciutat del _pi
				Desplaçament desplaçamentUrba = new Desplaçament(transportsUrbans[i].obtenirDurada(),_pi,puntsInteres[j],transportsUrbans[i].obtenirPreu(),"urba");
				llistaActivitats.add(desplaçamentUrba);
			}
		}
		
		List<Hub> hubs = ciutat.obtenirHub();
		
		for (int i = 0; i < hubs.size(); i++) {
			int tempsHub = hubs[i].obtenirDurada(); //durada per anar de punt Interes origen fins a hub + hub desti fins a punt Interes desti 
			String nomCiutat = hubs[i].obtenirDesti();
			Ciutat city = agencia.trobarCiutat(nomCiutat);
			int duradaHubDesti = city.obtenirDurada();
			
			List<TransportIndirecte> transportsIndirectes = hubs[i].obtenirTransportIndirecte(hora);
			List<PuntInteres> puntsInteres = city.obtenirPuntInteres();
			
			for (int j = 0; j < hubs.size(); j++) { 
				int duradaTransport = transportsIndirectes[j].obtenirDurada();
				int duradaTotal = tempsHub + duradaTransport;
				
				Desplaçament desplaçamentIndirecte = new Desplaçament(duradaTotal,_pi,hubs[i].obtenirDesti(),transportsIndirectes[j].obtenirPreu(),"indirecte");
				llistaActivitats.add(desplaçamentIndirecte);
			}			
		}
		
		if (_pi.esVisitable) {
	
			Visitable visitable = (Visitable) _pi;
			Visita visita = new Visita(visitable.obtenirDurada(),visitable.obtenirPreu(),visitable);
		}
		
    }


    @Override
    public Iterator<Activitat> iterator() {
        
        return new ActivitatIterator();
    }
    
    private class ActivitatIterator implements Iterator<Activitat>{
        
        private int posicio;
        
        public ActivitatIterator(){
            posicio = 0;
        }

        @Override
        public boolean hasNext() {
            
            boolean hasnext;
            
            if (posicio < llistaActivitats.size())  
                hasnext = true; 
            else
                hasnext = false; 
            
            return hasnext;
        }

        @Override
        public Activitat next() {
            posicio++;
            return llistaActivitats.get(posicio-1);
        }
    }   
}
