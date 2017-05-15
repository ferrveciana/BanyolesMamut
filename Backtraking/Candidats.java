/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;



import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Candidats implements Iterable<Activitat>{ 
    
    private int index; //Indica la posicio del candidat actual
    private List<Activitat> llistaActivitats; 
    
   Candidats (PuntInteres _pi){
        
       llistaActivitats = new ArrayList();
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
    