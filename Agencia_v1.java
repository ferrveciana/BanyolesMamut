package projecte;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aula
 */
public class Entrada {
   
    private HashMap<String,Lloc> llistaLlocs;  
    private HashMap<String,PuntInteres> llistaPInteres;
   
    private Map<String,Client> llistaClients;
    private List<Allotjament> llistaAllotjaments;
    private List<Visitable> llistaVisitables;

    
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
    private int passarInt(String hora){
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = hora.split(delimitadors);
        return (Integer.parseInt(paraulesSeparades[0])*60+Integer.parseInt(paraulesSeparades[1]));        
    }

    public void crearClient(String nomClient, List<String> llistaPreferencies) {
    
        Client client = new Client(nomClient,llistaPreferencies);
        llistaClients.add(client);
    }
    
    public void crearLloc(String nomLloc, String coordenades, String franjaHoraria) {
        
       Lloc nouLloc = new Lloc(nomLloc,coordenades,franjaHoraria);
       llistaLlocs.put(nomLloc,nouLloc);
        
    }


    public void crearAllotjament(String _nom, String _coordenada, TimeZone _zonaHoraria, double _preu, List<String> _caract,int _categoria) {
        
        Allotjament nouAllotjament = new Allotjament(_nom,_coordenada,_zonaHoraria,_preu,_caract,_categoria);
        llistaPInteres.put(_nom,nouAllotjament);
    }

    public void crearVisitable(String _nom, String _coordenada, TimeZone _zonaHoraria, double _preu, List<String> _caract,List<Horari> _horariVisites, int _tempsVisita,HashMap<String,DuesHores> _excepcions) {
        
        Visitable nouVisitable = new Visitable(_nom,_coordenada,_zonaHoraria,_preu, _caract,_horariVisites, _tempsVisita,_excepcions);
        llistaPInteres.put(_nom,nouVisitable);
    }

    public void crearVisita(Scanner nomFitxer) {

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

    public void crearAssociarTransport(Scanner nomFitxer) {

    }

    public void crearTransportDirecte(String origen, String desti, String mitja, String durada, double preu) {

        TransportDirecte tdirecte = new TransportDirecte(origen,desti,mitja,durada,preu);
        llistaLlocs.get(origen).afegirMitjaTransportDirecte(tdirecte);

    }

    public void crearTransportIndirecte(String origen, String desti, String mitja, String tempsFinsOrigen, String tempsFinsDesti, HashMap<String,List<TransportIndirecte>> transportIndirecte) {

        Hub hub = new Hub(origen,desti,mitja,tempsFinsOrigen,tempsFinsDesti,transportIndirecte);
        llistaLLocs.get(origen).afegirMitjaTransportIndirecte(tindirecte);

        
    }

    public void crearViatge(Scanner nomFitxer) {

    } 
    
  
}
      
