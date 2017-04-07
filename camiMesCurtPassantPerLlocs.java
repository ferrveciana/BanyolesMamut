Atributs:
Cami optim;
Lloc desti;
ArrayList<Lloc> llocsIntermitjos;
ArrayList<boolean> passat; //inicialitzar amb llocsIntermitjos.size() posicions i totes a false.

public void camiMesCurtPassantPerLlocs(Cami actual, int o){

    Candidats iCan=actual.inicialitzarCandidats(o);

    while (! iCan.esFi()){

        if (actual.potSerMillor(optim,iCan,"temps")){

            actual.anotar(iCan,llocsIntermitjos,passat);
			
			Iterator<Lloc> itr = llocsIntermitjos.iterator();

            if (! iCan.esFi())
                camiMesCurtPassantPerLlocs(actual,iCan.actual());

            if (actual.esMillor(optim,"temps") & actual.Complet(desti, passat)){ //actual menys temps i actual conte desti i totes les posicions de passat==true
                optim=actual;   
            }

            actual.desanotar(iCan,llocsIntermitjos,passat); 
        }
        iCan.seguent();
    }
}


CalculadorRutes:
Candidats inicialitzarCandidats(actual,o);

Candidat:
boolean esFi();
void seguent();

Circuit:
boolean potSerMillor(Circuit optim,Candidat iCan,String comparacio);
boolean esMillor(Circuit optim,String comparacio);
void anotar(iCan,llocsIntermitjos, ArrayList<boolean> passat);
void desanotar(iCan, ArrayList<Lloc> llocsIntermitjos, ArrayList<boolean> passat);
boolean Complet(Lloc desti, passat);