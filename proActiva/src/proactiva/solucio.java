///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package proactiva;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//
///**
// *
// * @author narcisbustins
// */
//public class Solucio {
//    
//    
//    private Map<PuntInteres,Boolean> desitjos; //llista de llocs que es volen visitar
//    
//    private LinkedList<PuntInteres> circuit;
//    private LinkedList<Activitat> llistaActivitats;
//    
//    PuntInteres origen;
//    PuntInteres desti;
//    
//    int satisfaccio;
//    int satAct;
//    
//    float preuMax;
//    float preuAct;
//    
//    float distAct;
//    
//    int tempsVisites;
//    
//    PuntInteres anterior;
//    LocalDateTime hora;
//    
//    Solucio(List<PuntInteres> _llistaPi,PuntInteres _origen, PuntInteres _desti,int _satisfaccio,float _preuMax,Map<PuntInteres,Boolean> _desitjos){
//        
//        preuMax=0;
//        satAct=0;
//        distAct=0;
//        
//        origen = _origen;
//        desti = _desti;
//        satisfaccio = _satisfaccio;
//        preuMax = _preuMax;
//        
//        desitjos = _desitjos;
//        circuit = new LinkedList<PuntInteres>();
//        
//    }
//    
//    public Candidat inicialitzarCandidats(PuntInteres _pi) {
//        
//          return new Candidat(_pi);
//    }
//    
//    public void anotar(Candidat candidat){
//        
//        Activitat a = candidat.actual();
//        PuntInteres pi = a.piActual();
//        
//        llistaActivitats.add(a);
//        circuit.add(pi);
//        
//        hora.plusMinutes(a.durada());
//        preuAct+=a.preu();
//        
//        if(desitjos.containsKey(pi)){
//            desitjos.put(pi,true);
//        }
//      
//    }
//    
//    public void desanotar(Candidat candidat){
//        
//        Activitat a = candidat.actual();
//        PuntInteres pi = a.piActual();
//        
//        hora.minusMinutes(a.durada());
//        preuAct-=a.preu();
//        
//        int ultim = llistaActivitats.size();
//        llistaActivitats.remove(ultim);
//        circuit.remove(pi);
//        
//        if(desitjos.containsKey(pi)){ 
//            desitjos.put(pi,false);
//        }
//        
//    }
//    
//    public boolean acceptable(Candidat candidat){
//        
//        Activitat a = candidat.actual();
//        boolean acceptable = false;
//        
//      
//        LocalTime h12 = LocalTime.of(11,59);
//        LocalTime h14 = LocalTime.of(14,00);
//        
//        LocalDate diaActual = hora.toLocalDate();
//        
//        LocalDateTime _h12 = LocalDateTime.of(diaActual, h12);
//        LocalDateTime _h14 = LocalDateTime.of(diaActual, h14);
//        
//        if (hora.isBefore(_h14) && hora.isAfter(_h12)){ //si no es hora de dinar
//            
//            if (a instanceof Visita){
//            
//                if (Visita.esPotVisitar(hora))
//                    acceptable = true;
//            }
//            else if (a instanceof EstadaH){
//            
//            //
//            
//            }
//            else if (a instanceof Desplaçament){
//            
//            //preguntar si hi ha transport a l hora
//            }
//            
//        }
//        
//        return true;
//    }
//    
//    public boolean completa(){
//        
//        return circuit.get((circuit.size()-1)).equals(desti);
//    }
//    
//    boolean esMillor(Solucio optima,String param){
//        
//       boolean millor = false;
//       if (param.equals("s")){ //satisfactoria
//           if (satisfaccio > optima.satisfaccio)
//               millor = true;       
//       }
//       if (param.equals("b")){//barata
//           if (preuAct < optima.preuAct)
//               millor = true;       
//       }
//       if (param.equals("d")){//distancia
//           if (distAct < optima.distAct)
//               millor = true;       
//       }
//       
//       
//       return millor;
//      
//    }
//    
//    public boolean potSerMillor(Solucio optima,String param,Candidat candidat){
//       
//       boolean millor = false;
//       Activitat a = candidat.actual();
//       
//       if (param.equals("s")){ //satisfactoria
//           if (satisfaccio > optima.satisfaccio) //*sumar satisfaccio de candidat
//               millor = true;       
//       }
//       if (param.equals("b")){//barata
//           if ((preuAct+a.preu()) < optima.preuAct)
//               millor = true;       
//       }
//       if (param.equals("d")){//distancia
//           if (distAct < optima.distAct) //*sumar dist de candidat
//               millor = true;       
//       }
//       
//       
//       return millor;
//        
//    }
//    
//    public LocalDateTime hora(){
//        
//        return hora;
//    }
// 
//  
//}
//  
