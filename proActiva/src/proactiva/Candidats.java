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
    
    private int index; //Indica la posicio del candidat actual
    private List<Activitat> llistaActivitats; 
    
   	Candidats (PuntInteres _pi){
        
		llistaActivitats = new ArrayList();
		
		//Crear candidats amb transports directes
		List<TransportDirecte> llistaTransportsDirectes = _pi.obtenirTransportsDirectes();

		for (int i = 0; i < llistaTransportsDirectes.size(); i++) {
			Desplaçament desplaçamentDirecte = new Desplaçament(llistaTransportsDirectes[i].obtenirDurada(),_pi,llistaTransportsDirectes[i].obtenirDesti(),llistaTransportsDirectes[i].obtenirPreu(),"transport Directe");
			llistaActivitats.add(desplaçamentDirecte); //falta afegir un string per saber quin tipus de transport es tracta
		}
		
		//Crear candidats amb transports urbans
		String ciutat = _pi.getCiutat(); //fer try catch
		List<TransportUrba> transportsUrbans = ciutat.obtenirTransports();
		List<PuntInteres> puntsInteres = _pi.getCiutat().obtenirPuntInteres();
		
		for (int i = 0; i < transportsUrbans.size(); i++) { //per cada transport urba de la ciutat
			for (int j = 0; j < puntsInteres.size(); j++) { //per cada punt d'interes de la ciutat
				//Afegir transports urbans del punt d'Interes actual a la resta de punts d'Interes de la ciutat del _pi
				Desplaçament desplaçamentUrba = new Desplaçament(transportsUrbans[i].obtenirDurada(),_pi,puntsInteres[j],transportsUrbans[i].obtenirPreu(),"transport Urba");
				llistaActivitats.add(desplaçamentUrba);
			}
		}
		
		List<Hub> hubs = ciutat.obtenirHub();
		
		for (int i = 0; i < hubs.size(); i++) {
			//obtenir llista de transportsIndirectes de hubs[i] i crear una activitat per cada un
			
		}
		
			  
		

       //Crear totes les activitats
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
