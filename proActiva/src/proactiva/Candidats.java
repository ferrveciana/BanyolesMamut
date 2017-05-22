package proactiva;



import java.time.LocalDateTime;
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
                         
			Desplaçament desplaçamentDirecte = new Desplaçament(llistaTransportsDirectes.get(i).obtenirDurada(),_pi,llistaTransportsDirectes.get(i).obtenirDesti(), (float) llistaTransportsDirectes.get(i).obtenirPreu(),"directe");
			llistaActivitats.add(desplaçamentDirecte); //falta afegir un string per saber quin tipus de transport es tracta
		}
		
		//Crear candidats amb transports urbans
		Ciutat ciutat = _pi.getCiutat(); //fer try catch
		List<TransportUrba> transportsUrbans = ciutat.obtenirTransports();
		List<PuntInteres> puntsInteres = _pi.getCiutat().obtenirPuntInteres();
		
		for (int i = 0; i < transportsUrbans.size(); i++) { //per cada transport urba de la ciutat
			for (int j = 0; j < puntsInteres.size(); j++) { //per cada punt d'interes de la ciutat
				//Afegir transports urbans del punt d'Interes actual a la resta de punts d'Interes de la ciutat del _pi
				Desplaçament desplaçamentUrba = new Desplaçament(transportsUrbans.get(i).obtenirDurada(),_pi, puntsInteres.get(j),transportsUrbans.get(i).obtenirPreu(),"urba");
				llistaActivitats.add(desplaçamentUrba);
			}
		}
		
		List<Hub> hubs = ciutat.obtenirHub();
		
		for (int i = 0; i < hubs.size(); i++) {
			int tempsHub = hubs.get(i).obtenirDurada(); //durada per anar de punt Interes origen fins a hub + hub desti fins a punt Interes desti 

			Ciutat city = hubs.get(i).getCiutat();
			int duradaHubDesti = hubs.get(i).obtenirDurada();
			
			List<TransportIndirecte> transportsIndirectes = hubs.get(i).obtenirTransportIndirecte(hora);
			for (int j = 0; j < hubs.size(); j++) { 
				int duradaTransport = transportsIndirectes.get(j).obtenirDurada();
				int duradaTotal = tempsHub + duradaTransport;
				
				Desplaçament desplaçamentIndirecte = new Desplaçament(duradaTotal,_pi,hubs.get(i).obtenirDestiPi(),transportsIndirectes.get(j).obtenirPreu(),"indirecte");
				llistaActivitats.add(desplaçamentIndirecte);
			}			
		}
                
                llistaActivitats.add(_pi.crearActivitat()); //Si es visita crea visita si es allotjament crea EstadaH
		
    }


    @Override
    public Iterator<Activitat> iterator() {
        
        return llistaActivitats.iterator();
    }
    
 
}

