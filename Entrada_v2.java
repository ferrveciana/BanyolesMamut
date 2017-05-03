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
        Double preu = nomFitxer.nextLine();
        String caracteristica = nomFitxer.nextLine();
        List<String> llistaCaracteristiques;
        
        while (!caracteristica.equals("*")) {
            llistaCaracteristiques.add(caracteristica);
            caracteristica = nomFitxer.nextLine();
        }
        agencia.crearAllotjament(nomAllotjament,coordenades,zonaHoraria,preu,llistaCaracteristiques,categoria);
    }

    private void entradaVisitable(Scanner nomFitxer) {

        String nomLloc = nomFitxer.nextLine();
        String coordenades = nomFitxer.nextLine();
        String zonaHoraria = nomFitxer.nextLine();
        String tempsVisitaRecomanat = nomFitxer.nextLine();
        Double preu = nomFitxer.nextLine();
        String caracteristica = nomFitxer.nextLine();
        List<String> llistaCaracteristiques;
        
        while (!caracteristica.equals("*")) {
            llistaCaracteristiques.add(caracteristica);
            caracteristica = nomFitxer.nextLine();
        }
        List<String> llistaHoraris;
        List<String> llistaExcepcions;
        String horariRegular = nomFitxer.nextLine();
        
        //S'ha de refinar, entrada no tractada correctament!
        while (!horariRegular.equals("*")) {
            llistaHoraris.add(horariRegular);
            String excepcio = nomFitxer.nextLine();
            llistaExcepcions.add(excepcio);
            horariRegular = nomFitxer.nextLine();
        }
        
        agencia.crearVisitable(nomLloc,coordenades,zonaHoraria,preu,llistaCaracteristiques,llistaHoraris,tempsVisitaRecomanat,llistaExcepcions);
    }

    private void entradaVisita(Scanner nomFitxer) {
        //Falta throw <Client no trobat> / <lloc no trobat>
        
        String nomClient = nomFitxer.nextLine();
        String llocVisitat = nomFitxer.nextLine();
        String data = nomFitxer.nextLine();
        
        agencia.crearVisita(nomClient,llocVisitat,data);
    }

    private void entradaAssociarLloc(Scanner nomFitxer) {

    }

    private void entradaAssociarTransport(Scanner nomFitxer) {

    }

    private void entradaTransportDirecte(Scanner nomFitxer) {

        String origen = nomFitxer.nextLine(); 
        String desti = nomFitxer.nextLine(); 
        String mitja = nomFitxer.nextLine(); 
        String durada = nomFitxer.nextLine(); 
        double preu = nomFitxer.nextLine(); 

        agencia.crearTransportDirecte(origen,desti,mitja,durada,preu);
    }

    private void entradaTransportIndirecte(Scanner nomFitxer) {

        String origen = nomFitxer.nextLine(); 
        String desti = nomFitxer.nextLine(); 
        String mitja = nomFitxer.nextLine(); 
        String tempsFinsOrigen = nomFitxer.nextLine(); 
        String tempsFinsDesti = nomFitxer.nextLine(); 
        
        String data = nomFitxer.nextLine(); 
        String dataTransport = data;
        String horari;
        String durada; 
        String preu;
        
        String delimitadors= "[ :-]+";
        
        HashMap<data,list> transportIndirecte;
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
                dataTransport = horari;
        }

        agencia.crearTransportIndirecte(origen,desti,mitja,tempsFinsOrigen,tempsFinsDesti,transportIndirecte);
    }

    private void entradaViatge(Scanner nomFitxer) {

    } 
    
    private Agencia agencia;
}

