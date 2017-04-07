Atributs:
private final Circuit circuit;
private final Lloc desti;
private final List<Lloc> llocsIntermitjos;
private finalList<boolean> passat; //inicialitzar amb llocsIntermitjos.size() posicions i totes a false.
private final boolean hiHaSolucio;

Algoritme:
Public void ferGreedy(Lloc inici) {

	  Lloc actual=inici;

	  while (!circuit.completa(desti) and Candidats.hiHaSeguent(actual)) {

		Lloc millorLloc=Candidats.mesPrometedor(actual);
		Candidats.treure(millorLloc);

		circuit.anotar(millorLloc);
	  actualitzarLlocsPassats(millorLloc);
		actual=millorLloc;
  }
	
	If (circuit.completa(desti) and totsPuntsIntermitjosVisitats())
		  hiHaSolucio=true;
	Else 
		  hiHaSolucio=false;
}

Classe actual:
void actualitzarLlocsPassats(millorLloc); //Llista passats actualitzada si millorLloc existeix a llista llocsIntermitjos
Void totsPuntsIntermitjosVisitats(); //Cert si s’han visitat tots els punts intermitjos

Circuit:
void anotar(Lloc millorLloc);
boolean Completa(Lloc desti);

Candidats:
Boolean hiHaSeguent(actual); //retorna si el lloc actual al que estem té “veïns”
Void treure(Lloc millorLloc);
