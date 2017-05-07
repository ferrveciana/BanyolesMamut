
package proactiva;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

public class Agencia {
   
    private HashMap<String,Lloc> llistaLlocs;  
    private HashMap<String,PuntInteres> llistaPInteres;
   
    private HashMap<String,Client> llistaClients;
    private ArrayList<Allotjament> llistaAllotjaments;
    private ArrayList<Visitable> llistaVisitables;
    private Viatge llistaViatges;

    
     /**
     *
     * @param data
     * @pre l'string data es una data valida
     * @return retorna la data obtinguda a partir de l'string 'data' en format LocalDate
     */
    public LocalDate passarData(String data){
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = data.split(delimitadors);
        return (LocalDate.of(Integer.parseInt(paraulesSeparades[0]),Integer.parseInt(paraulesSeparades[1]), Integer.parseInt(paraulesSeparades[2])));
    }
   
    /**
     *
     * @param hora
     * @pre l'string hora es una hora valida
     * @return retorna els minuts 
     */
    private int passarTemps(String hora){
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = hora.split(delimitadors);
        return (Integer.parseInt(paraulesSeparades[0])*60+Integer.parseInt(paraulesSeparades[1]));        
    }

    public void crearClient(String nomClient, ArrayList<String> llistaPreferencies) {
    
        Client client = new Client(nomClient,llistaPreferencies);
        llistaClients.put(nomClient,client);
    }
    
    public void crearLloc(String nomLloc, String coordenades, TimeZone franjaHoraria) {
        
       Lloc nouLloc = new Lloc(nomLloc,coordenades,franjaHoraria);
       llistaLlocs.put(nomLloc,nouLloc);
    }


    public void crearAllotjament(String _nom, String _coordenada, TimeZone _zonaHoraria, float _preu, ArrayList<String> _caract,String _categoria) {
        
        Allotjament nouAllotjament = new Allotjament(_nom,_coordenada,_zonaHoraria,_preu,_caract,_categoria);
        llistaPInteres.put(_nom,nouAllotjament);
    }

    public void crearVisitable(String _nom, String _coordenada, TimeZone _zonaHoraria, float _preu, ArrayList<String> _caract, int _tempsVisita, ArrayList<Horari> _horariVisites, HashMap<String,DuesHores> _excepcions) {
        
        Visitable nouVisitable = new Visitable(_nom,_coordenada,_zonaHoraria,_preu, _caract,_horariVisites, _tempsVisita,_excepcions);
        llistaPInteres.put(_nom,nouVisitable);
    }

    public void crearVisita(String nomClient,String llocVisitat,LocalDate data) {

        llistaClients.get(nomClient).afegirVisita(llocVisitat,data);
    }

    public void crearAssociarLloc(String secundari,String primari) {
        
        Lloc _lloc = llistaLlocs.get(primari);
        PuntInteres pi = llistaPInteres.get(secundari);
        if (_lloc instanceof Ciutat){
            ((Ciutat) _lloc).afegirPuntInteres(pi);
        }
        else{
           Ciutat _ciutat = _lloc.ferCiutat(pi);
           llistaLlocs.put(primari,_ciutat);
        }
    }

    public void crearAssociarTransport(String _lloc,String mitja,int durada,float preu) {
         
       TransportUrba turba = new TransportUrba(_lloc,mitja,durada,preu);
       Ciutat _ciutat = (Ciutat) (llistaLlocs.get(_lloc));
       _ciutat.afegirTransport(turba); 
    }

    public void crearTransportDirecte(String origen, String desti, String mitja, int durada, double preu) {

        TransportDirecte tdirecte = new TransportDirecte(origen,desti,mitja,durada,preu);
        llistaLlocs.get(origen).afegirMitjaTransportDirecte(tdirecte);

    }

    public void crearTransportIndirecte(String origen, String desti, String mitja, int tempsFinsOrigen, int tempsFinsDesti, HashMap<LocalDate,ArrayList<TransportIndirecte>> transportIndirecte) {

        Hub hub = new Hub(origen,desti,mitja,tempsFinsOrigen,tempsFinsDesti,transportIndirecte);
        llistaLlocs.get(origen).afegirMitjaTransportIndirecte(tindirecte);

        
    }

    public void crearEntradaViatge(LocalDate dataInici, LocalTime horaInici,int nombreDies,float preuMaxim, String categoria, ArrayList<String> clients, ArrayList<String> rutes) {

        Viatge viatge = new Viatge(dataInici,horaInici,nombreDies,preuMaxim,categoria,clients,rutes);
    } 
    
  
}
