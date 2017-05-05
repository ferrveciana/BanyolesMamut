private final Circuit circuit;
private final Lloc desti;
private final List<Lloc> llocsIntermitjos;
private finalList<boolean> passat; //inicialitzar amb llocsIntermitjos.size() posicions i totes a false.
private final boolean hiHaSolucio;

public void camiMesCurtPassantPerLlocs(Lloc ini, Lloc fi, Llista<PuntRuta> llocsIntermitjos){

   	int millorTemps=0;
Ruta millorRuta;
	int nCurt=0,n=0;
	
	while(llocsIntermitjos[n] != NULL){
		ruta=camiMesCurt(ini,llocsIntermitjos[n]);
		if(millorRuta.temps>ruta.temps){ //lu del temps ho he posat aixi pk no se molt be com ho tenim en el dijkstra
			millorRuta = ruta;
			nCurt=n;
		}
		n++
	}
	sol=sol+millorRuta; //concatenar rutes
	ini= llocsIntermitjos[nCurt];
	llocsIntermitjos.remove(nCurt);	
	if(! llocsIntermitjos.isEmpty()) camiMesCurtPassantPerLlocs(ini,fi,llocsIntermitjos);
	else{
		ruta=camiMesCurt(ini, fi);
		sol=sol+ruta; //concatenar rutes
	}
}
