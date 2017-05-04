public class Solucionador {
    
    private List<Lloc> llistaLlocs;
    private Circuit solucio;
    
    public void trobarSolucio(){
    
        int i;
        Ciutat ciutatActual = llistaLlocs.get(i);
        
        
        int iP;
        List<PuntInteres> llistaPi = ciutatActual.obtenirPi(); 
        PuntInteres pActual = llistaPi.get();  
        
        while(llistaPi.get(iP)){
            if (solucio.acceptable(ciutatActual.getPI()) & solucio.potSerMillor(optima,ciutatActual.getPI()){
            
                solucio.anotar(ciutatActual.getPI());
                
                if (! solucio.completa()){
                    trobarSolucio(ciutatActual.getPI());
                }              
            }
            
            
            PuntInteres pi = ciutatActual.getPI();
            pi.acceptable(*param*);
            
            
        }
         
    }
    
    
}
