/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author narcisbustins
 */
public class Solucio {
    
    private HashMap<PuntInteres,Boolean> desitjos; //llista de llocs que es volen visitar
    private int desitjosVisitats;//contador de visitats
    
    private TreeSet<PuntInteres> visitats; 
    
    private List<String> preferenciesClients;
    
    private int categoriaHotel; //categoria demanada
    
    private LinkedList<PuntInteres> circuit;
    private LinkedList<Activitat> llistaActivitats;
    
    PuntInteres origen;
    PuntInteres desti;
    
    int satisfaccio;
    int satAct;
    
    float preuMax;
    float preuAct;
    
    int tempsMax;
    int tempsAct;
    
    int tempsVisites;
    
    PuntInteres anterior;
    LocalDateTime hora;
    LocalDateTime hora_anterior;
    
    Solucio(List<PuntInteres> _llistaPi,PuntInteres _origen, PuntInteres _desti,int _satisfaccio,float _preuMax,HashMap<PuntInteres,Boolean> _desitjos,List<String> _preferenciesClients){
        desitjosVisitats =0;
        preferenciesClients=_preferenciesClients;
        
        preuMax=0;
        satAct=0;
        tempsAct=0;
        
        origen = _origen;
        desti = _desti;
        satisfaccio = _satisfaccio;
        preuMax = _preuMax;
        
        desitjos = _desitjos;
        circuit = new LinkedList<PuntInteres>();
        llistaActivitats = new LinkedList<Activitat>();

    }
    
    public Candidats inicialitzarCandidats(PuntInteres _pi) {
        
          return new Candidats(_pi);
    }
    
    public void anotar(Activitat a){
        
        PuntInteres pi = a.piActual();
        
        if (desitjos.containsKey(pi) && desitjos.get(pi)==false){//treure de desitjos
            
            desitjos.put(pi,true);
            desitjosVisitats++;
        }
        
        //Afegir Llocs visitats
        visitats.add(pi);
        
        //SUMES
        preuAct+=a.preu();
        satAct+=a.satisfaccio(preferenciesClients);
        
        //Inici d'activitat
        hora_anterior=hora;
        
        
        if (a instanceof EstadaH){ //Estada a hotel
            
            a.setInici(hora); //inici activitat
            
            LocalDate data = hora.toLocalDate();
            LocalTime mati4 = LocalTime.of(4,0);
            
            hora = LocalDateTime.of(data,mati4);
            a.setFinal(hora);//afegir hfinal activitat
        }
        else {
            LocalDateTime iniciproper;
            iniciproper = a.hPropera(hora);  
            hora = iniciproper;
            //SET HORA I
            a.setInici(hora); //inici activitat
            //Sumar durada a h nova
            hora.plusMinutes(a.durada()); 
            //SET HORA F
            a.setFinal(hora);//afegir hfinal activitat   
        }
        
        //RUTES
        llistaActivitats.add(a);//afegir hfinal Activitat
        circuit.add(pi);//afegir Pi a ruta
        
    }
    
    public void desanotar(Activitat a){
        
        PuntInteres pi = a.piActual();
        
        if (desitjos.containsKey(pi) && desitjos.get(pi)==true){//Treure de desitjos
            
            desitjos.put(pi,false);
            desitjosVisitats--;
        }
        //Llocs visitats
        visitats.remove(pi);
        
        //RESTES
        preuAct-=a.preu();
        if (!(a instanceof Desplaçament)) //
            satAct-=a.satisfaccio(preferenciesClients);
        
        //RUTES
        int ultim = llistaActivitats.size()-1;
        llistaActivitats.remove(ultim);
        circuit.remove(pi);
        
        hora = hora_anterior;
               
    }
    
    public boolean acceptable(Activitat a){
        
       
        boolean acceptable = false;
        PuntInteres pi = a.piActual();
        /*
        /////Hora de dinar
        LocalTime h12 = LocalTime.of(11,59);
        LocalTime h14 = LocalTime.of(14,00);
        
        LocalDate diaActual = hora.toLocalDate();
        
        LocalDateTime _h12 = LocalDateTime.of(diaActual, h12);
        LocalDateTime _h14 = LocalDateTime.of(diaActual, h14);
        /////fiHora de dinar
        
        if (hora.isBefore(_h14) && hora.isAfter(_h12))//si no es hora de dinar  a.satisfaccio(preferenciesClients)>0
        */   
       
        if ( a.preu()+preuAct<=preuMax && tempsAct+a.durada()<=tempsMax && !visitats.contains(pi)){ //si no es supera preuMax && aprota satisfaccio && es pot fer avui
                
                if (a instanceof Visita){
                
                    Visita visita = (Visita) a;
                    acceptable =  visita.realitzarAvui(hora);
                
                }
                else if (a instanceof EstadaH){
                    
                    EstadaH estada = (EstadaH) a;
                    acceptable = categoriaHotel>=estada.getCategoria();
            
                }
                else if (a instanceof Desplaçament){
                
                    acceptable = true;
                }
            }
        
        return acceptable;
    }
    
    public boolean completa(){
        
        return (desitjos.size()==desitjosVisitats && circuit.get((circuit.size()-1)).equals(desti));
    }
    
    boolean esMillor(Solucio optima,String param){
        
       boolean millor = false;
       if (param.equals("s")){ //satisfactoria
           if (satisfaccio > optima.satisfaccio)
               millor = true;       
       }
       if (param.equals("b")){//barata
           if (preuAct < optima.preuAct)
               millor = true;       
       }
       if (param.equals("d")){//distancia
           if (tempsAct< optima.tempsMax)
               millor = true;       
       }
       
       return millor;
      
    }
    
    public boolean potSerMillor(Solucio optima,String param,Activitat a){
       
       boolean millor = false;
       if (param.equals("s")){ //satisfactoria
           if (satisfaccio > optima.satisfaccio) //*sumar satisfaccio de candidat
               millor = true;       
       }
       if (param.equals("b")){//barata
           if ((preuAct+a.preu()) < optima.preuAct)
               millor = true;       
       }
       if (param.equals("t")){//temps
           if (tempsAct < optima.tempsMax) //*sumar dist de candidat
               millor = true;       
       }
       
       return millor;
        
    }
    
    public LocalDateTime hora(){
        
        return hora;
    }
 
  
}
