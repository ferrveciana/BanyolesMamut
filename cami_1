Atributs:

  private final int o; //origen
  private final int d; //desti

  private final int MAX_NUM; //nombre maxim representable
  private final Mapa graf;
  private boolean visitats[]; //Taula de llocs visitats 
  private float temps[]; //Taula de temps

 public Circuit camiMesCurt(){
        
        //Inicialitzacio taula de temps
        int act = o;
        for (int i = 1;i< temps.length;i++){
           temps[i] = MAX_NUM; 
        }
        temps[act] = 0;

        //Inicialitzacio taula de visitats
        for (int i = 0;i< visitats.length;i++){
           visitats[i] = false; 
        }
       
       int tractats = 0;
   
       while (tractats < graf.nLlocs()){ //Retorna el nombre de Llocs(vertexs) de Mapa
        
           visitats[act] = true; //marcar actual com a visitat           
           
           PairIdT [] veins = graf.adjacents(act); //Retorna una array de PairIdT
           
           int iAdj = 0;
           
           while (iAdj < veins.length){ //tractar tots els veins
              
              int adjV = veins[iAdj].getId(); //Retorna l'identificador numeric de lloc (PairID)
              float adjTA = temps[adjV];
              float nouTemp =  temps[act]+ veins[iAdj].getT();//Retrorna el temps(PairID)
              
              if (nouTemp < adjTA)
                temps[adjV] = nouTemp;

              iAdj++;  
           }
           act = triarMillor(); //Retorna vertex amb el temps mes petit (CalculadorRutes)
           tractats++;
       
      Circuit camiMinim = obtenirCircuit(); // Retorna el cami d'origen a desti (CalculadorRutes)
      return camiMinim;
      
    }


    PairID:
      classe formada per l'identificador numeric d'un Lloc i el temps a un lloc donat, estructura semblant a tupla.
