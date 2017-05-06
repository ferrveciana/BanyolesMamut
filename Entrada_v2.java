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

    public Entrada(Scanner nomFitxer) {
        
        nomFitxer.useLocale(Locale.US);
        String codiOperacio;

        while (nomFitxer.hasNext()) {
            codiOperacio = nomFitxer.nextLine();
            
            if (codiOperacio.equals("client"))
                entradaClient(nomFitxer);
            
            else if (codiOperacio.equals("lloc"))
                entradaLloc(nomFitxer);
            
            else if (codiOperacio.equals("allotjament"))
                entradaAllotjament(nomFitxer);
            
            else if (codiOperacio.equals("lloc visitable"))
                entradaVisitable(nomFitxer);
            
            else if (codiOperacio.equals("visita"))
                entradaVisita(nomFitxer);
            
            else if (codiOperacio.equals("associar lloc"))
                entradaAssociarLloc(nomFitxer);
            
            else if (codiOperacio.equals("associar transport"))
                entradaAssociarTransport(nomFitxer);
            
            else if (codiOperacio.equals("transport directe"))
                entradaTransportDirecte(nomFitxer);
            
            else if (codiOperacio.equals("transport indirecte"))
                entradaTransportIndirecte(nomFitxer);
            
            else if (codiOperacio.equals("viatge"))
                entradaViatge(nomFitxer);
        }
    }

    private void entradaClient(Scanner nomFitxer) {

        String nomClient = nomFitxer.nextLine();
        String preferencia = nomFitxer.nextLine();
        List<String> llistaPreferencies;
        
        while (!preferencia.equals("*")) {
            llistaPreferencies.add(preferencia);
            preferencia = nomFitxer.nextLine();
        }
        agencia.crearClient(nomClient,llistaPreferencies);
    }

    private void entradaLloc(Scanner nomFitxer) {
    
        String nomLloc = nomFitxer.nextLine(); 
        double coordenades = nomFitxer.nextLine();
        TimeZone franjaHoraria = nomFitxer.nextLine();

        agencia.crearLloc(nomLloc,coordenades,franjaHoraria);
    }

    private void entradaAllotjament(Scanner nomFitxer) {
    
        String nomAllotjament = nomFitxer.nextLine();
        string coordenades = nomFitxer.nextLine();
        String zonaHoraria = nomFitxer.nextLine();
        String categoria = nomFitxer.nextLine();
        
        String _preu = nomFitxer.nextLine();
        double preu = double.parseDouble(_preu);
        
        String caracteristica = nomFitxer.nextLine();
        List<String> llistaCaracteristiques;
        
        while (!caracteristica.equals("*")) {
            llistaCaracteristiques.add(caracteristica);
            caracteristica = nomFitxer.nextLine();
        }
        agencia.crearAllotjament(nomAllotjament,coordenades,zonaHoraria,preu,llistaCaracteristiques,categoria);
        nomFitxer.nextLine(); //Llegeix "*"
    }

    private Horari string2Horari(String _horari){
        Horari h = new Horari();
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = _horari.split(delimitadors);
        
        h.mesIni=paraulesSeparades[0];
        h.diaIni= Integer.parseInt(paraulesSeparades[1]);
        h.mesFin=paraulesSeparades[2];
        h.diaFin=Integer.parseInt(paraulesSeparades[3]);
        h.horaIni= LocalTime.of(Integer.parseInt(paraulesSeparades[4]),Integer.parseInt(paraulesSeparades[5]));
        h.horaFi= LocalTime.of(Integer.parseInt(paraulesSeparades[6]),Integer.parseInt(paraulesSeparades[7]));        
        
        return  h;
    }
    
    
    private void entradaVisitable(Scanner nomFitxer) {

        String nomLloc = nomFitxer.nextLine();
        String coordenades = nomFitxer.nextLine();
        String zonaHoraria = nomFitxer.nextLine();
        String tempsVisitaRecomanat = nomFitxer.nextLine();
        
        String _preu = nomFitxer.nextLine();
        double preu = double.parseDouble(_preu);
        
        String caracteristica = nomFitxer.nextLine();
        List<String> llistaCaracteristiques;
        
        while (!caracteristica.equals("*")) {
            llistaCaracteristiques.add(caracteristica);
            caracteristica = nomFitxer.nextLine();
        }
        ArrayList<Horari> llistaHoraris;
        HashMap<String,DuesHores> llistaExcepcions;
        
        String horariRegular = nomFitxer.nextLine();
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = excepcio.split(delimitadors);
        
        
        while (!horariRegular.equals("*")) {
            if(paraulesSeparades[2].length()>2){ //no es excepcio
                llistaHoraris.add(string2Horari(horariRegular)); //passem la string a Horari i l'afegim a la llista
            }
            else{ //excepcio
                DuesHores = dH(LocalTime.of(Integer.parseInt(paraulesSeparades[2]),Integer.parseInt(paraulesSeparades[3])),LocalTime.of(Integer.parseInt(paraulesSeparades[4]),Integer.parseInt(paraulesSeparades[5])));
                llistaExcepcions.put(paraulesSeparades[0]+" "+paraulesSeparades[1],dH);
            }
            horariRegular = nomFitxer.nextLine();
        }
        
        agencia.crearVisitable(nomLloc,coordenades,zonaHoraria,preu,llistaCaracteristiques,tempsVisitaRecomanat, llistaHoraris, llistaExcepcions);
    }

    private void entradaVisita(Scanner nomFitxer) {
        
        String nomClient = nomFitxer.nextLine();
        String llocVisitat = nomFitxer.nextLine();
        String data = nomFitxer.nextLine();
        
        agencia.crearVisita(nomClient,llocVisitat,data);
        nomFitxer.nextLine(); //Llegeix "*"
    }

    private void entradaAssociarLloc(Scanner nomFitxer) {
        
        String llocSecundari = nomFitxer.nextLine();
        String llocPrimari = nomFitxer.nextLine();
        
        agencia.crearAssociarLloc(secundari,primari);
        nomFitxer.nextLine(); //Llegeix "*"
    }

    private void entradaAssociarTransport(Scanner nomFitxer) {

        String lloc = nomFitxer.nextLine();
        String mitjaTransport = nomFitxer.nextLine();
        String durada = nomFitxer.nextLine();
        
        String _preu = nextLine();
        double preu = double.parseDouble(_preu);
        
        agencia.crearAssociarTransport(lloc,mitjaTransport,durada,preu);
        nomFitxer.nextLine(); //Llegeix "*"
    }

    private void entradaTransportDirecte(Scanner nomFitxer) {

        String origen = nomFitxer.nextLine(); 
        String desti = nomFitxer.nextLine(); 
        String mitja = nomFitxer.nextLine(); 
        String durada = nomFitxer.nextLine(); 
        String _preu = nextLine();
        double preu = double.parseDouble(_preu);

        agencia.crearTransportDirecte(origen,desti,mitja,durada,preu);
        nomFitxer.nextLine(); //Llegeix "*"
    }
    
    /**
     *
     * @param data
     * @pre l'string data es una data valida
     * @return retorna la data obtinguda a partir de l'string 'data' en format LocalDate
     */
    private LocalDate passarData(String data){
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = data.split(delimitadors);
        return (LocalDate.of(Integer.parseInt(paraulesSeparades[0]),Integer.parseInt(paraulesSeparades[1]), Integer.parseInt(paraulesSeparades[2])));
    }

    private void entradaTransportIndirecte(Scanner nomFitxer) {

        String origen = nomFitxer.nextLine(); 
        String desti = nomFitxer.nextLine(); 
        String mitja = nomFitxer.nextLine(); 
        String tempsFinsOrigen = nomFitxer.nextLine(); 
        String tempsFinsDesti = nomFitxer.nextLine(); 
        
        String data = nomFitxer.nextLine(); 
        String dataTransport = passarData(data);
        String horari;
        String durada; 
        String preu;
        
        String delimitadors= "[ :-]+";
        
        HashMap<LocalDate,list<TransportIndirecte>> transportIndirecte;
        list<TransportIndirecte> llistaTransportIndirecte;
        
        TransportIndirecte nouTransport = new TransportIndirecte();
        
        while (data.equals("*")){

            String[] paraulesSeparades = horari.split(delimitadors);
            horari = nomFitxer.nextLine();
            
            while (Integer.parseInt(paraulesSeparades[0]) > 24) or horari.equals("*")) {

                durada = nomFitxer.nextLine();
                preu = nomFitxer.nextLine(); 
                
                nouTransport.afegir(horari,durada,preu);
                llistaTransportIndirecte.add(nouTransport);
                
                horari = nomFitxer.nextLine();
            }
            
            mapaTransportsIndirecte.put(dataTransport,llistaTransportIndirecte);
            llistaTransportIndirecte.clear();
            nouTransport = new TransportIndirecte();
            
            if (horari.equals("*"))
                break;    
            else 
                dataTransport = passarData(horari);
        }

        agencia.crearTransportIndirecte(origen,desti,mitja,tempsFinsOrigen,tempsFinsDesti,transportIndirecte);
    }

    private void entradaViatge(Scanner nomFitxer) {
        
        String dataI = nomFitxer.nextLine();
        LocalDate dataInici = passarData(dataI);
        
        String horaInici = nomFitxer.nextLine();
        int nombreDies = Integer.parseInt(nomFitxer.nextLine());
        double preuMaxim = Double.parseDouble(nomFitxer.nextLine());
        String categoria = nomFitxer.nextLine();
        
        ArrayList<String> clients;
        String client = nomFitxer.nextLine();
        
        while (!client.equal("*")) {
            
            clients.add(client);
            client = nomFitxer.nextLine();
        }
        
        ArrayList<String> rutes;
        String ruta = nomFitxer.nextLine();
        
        while (!ruta.equal("*")) {
            
            rutes.add(ruta);
            ruta = nomFitxer.nextLine();
        }
        
        agencia.crearEntradaViatge(dataInici,horaInici,nombreDies,preuMaxim,categoria,clients,rutes);
    } 
    
    private Agencia agencia;
}
    
    private Agencia agencia;
}



















