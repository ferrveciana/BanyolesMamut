/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

/*
 * @class Entrada
 * @brief Classe que realitza totes les operacions d'entrada necessàries per tal que el programa funcioni
 */
public class Entrada {

    /**
     * @param nomFitxer
     * @brief acció principal de la classe que delega feina a les classes privades segons el fitxer d'entrada
     * @pre cert
     * @post s'han realitzat les operacions d'entrada correctament
     */
    public Entrada(Scanner nomFitxer) {
        
        nomFitxer.useLocale(Locale.US);
        String codiOperacio;
        agencia = new Agencia();

        while (nomFitxer.hasNext()) { 
            codiOperacio = nomFitxer.nextLine();
            System.out.println("peta en aquet " + codiOperacio);
            switch (codiOperacio) {
                case "client":
                    entradaClient(nomFitxer);
                    break;
                case "lloc":
                    entradaLloc(nomFitxer);
                    break;
                case "allotjament":
                    entradaAllotjament(nomFitxer);
                    break;
                case "lloc visitable":
                    entradaVisitable(nomFitxer);
                    break;
                case "visita":
                    entradaVisita(nomFitxer);
                    break;
                case "associar lloc":
                    entradaAssociarLloc(nomFitxer);
                    break;
                case "associar transport":
                    entradaAssociarTransport(nomFitxer);
                    break;
                case "transport directe":
                    entradaTransportDirecte(nomFitxer);
                    break;
                case "transport indirecte":
                    entradaTransportIndirecte(nomFitxer);
                    break;
                case "viatge":
                    entradaViatge(nomFitxer);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * @brief realitza les operacions d'entrada del fitxer quan s'introdueix un client
     * @pre cert
     * @post dades del client guardades 
     */
    private void entradaClient(Scanner nomFitxer) {

        String nomClient = nomFitxer.nextLine();
        
        ArrayList<String> llistaPreferencies = new ArrayList<>();
        String preferencia = nomFitxer.nextLine();
        
        while (!preferencia.equals("*")) {
            llistaPreferencies.add(preferencia);
            preferencia = nomFitxer.nextLine();
        }
        agencia.crearClient(nomClient,llistaPreferencies);
    }

    /**
     * @brief realitza les operacions d'entrada del fitxer quan s'introdueix un lloc
     * @pre cert
     * @post dades del lloc guardades
     */
    private void entradaLloc(Scanner nomFitxer) {
    
        String nomLloc = nomFitxer.nextLine(); 
        String coordenades = nomFitxer.nextLine();
        String _franjaHoraria = nomFitxer.nextLine();
        
        TimeZone franjaHoraria = TimeZone.getTimeZone(_franjaHoraria);
        
        agencia.crearLloc(nomLloc,coordenades,franjaHoraria);
    }

    /**
     * @brief realitza les operacions d'entrada del fitxer quan s'introdueix un allotjament
     * @pre cert
     * @post dades de l'allotjament guardades
     */
    private void entradaAllotjament(Scanner nomFitxer) {
    
        String nomAllotjament = nomFitxer.nextLine();
        String coordenades = nomFitxer.nextLine();
        String _zonaHoraria = nomFitxer.nextLine();
        TimeZone zonaHoraria = TimeZone.getTimeZone(_zonaHoraria);
        
        String categoria = nomFitxer.nextLine();
        float preu = Float.parseFloat(nomFitxer.nextLine());
        
        String caracteristica = nomFitxer.nextLine();
        ArrayList<String> llistaCaracteristiques = new ArrayList<>();
        
        while (!caracteristica.equals("*")) { //bucle en el que es llegeixen les característiques

            llistaCaracteristiques.add(caracteristica);
            caracteristica = nomFitxer.nextLine();
        }
        agencia.crearAllotjament(nomAllotjament,coordenades,zonaHoraria,preu,llistaCaracteristiques,categoria);
    }

    /**
     * @brief a partir d'un string crea una classe Horari i la retorna
     * @pre _horari conté informació vàlida
     * @post retorna una classe Horari 
     */
    private Horari string2Horari(String _horari){
        
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = _horari.split(delimitadors);
        Horari h= new Horari(paraulesSeparades[0], Integer.parseInt(paraulesSeparades[1]), paraulesSeparades[2], Integer.parseInt(paraulesSeparades[3]), LocalTime.of(Integer.parseInt(paraulesSeparades[4]),Integer.parseInt(paraulesSeparades[5])), LocalTime.of(Integer.parseInt(paraulesSeparades[6]),Integer.parseInt(paraulesSeparades[7])));
        return  h;
    }
    
    /**
     * @brief a partir d'un string que conté una hora determinada retorna un enter amb el seu equivalent en minuts
     * @pre hora conté dos enters amb ':' entre mig d'ambdós nombres
     * @post retorna un enter equivalent al nombre de minuts
     */
    private int passarInt(String hora){
        
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = hora.split(delimitadors);
        return (Integer.parseInt(paraulesSeparades[0])*60+Integer.parseInt(paraulesSeparades[1]));        
    }
    
    /**
     * @brief realitza les operacions d'entrada del fitxer quan s'introdueix un lloc visitable
     * @pre cert
     * @post dades del lloc visitable guardades
     */
    private void entradaVisitable(Scanner nomFitxer) {

        String nomLloc = nomFitxer.nextLine();
        String coordenades = nomFitxer.nextLine();
        String _zonaHoraria = nomFitxer.nextLine();
        TimeZone zonaHoraria = TimeZone.getTimeZone(_zonaHoraria);
        int tempsVisitaRecomanat = passarInt(nomFitxer.nextLine());
        
        String _preu = nomFitxer.nextLine();
        float preu = Float.parseFloat(_preu);
        
        String caracteristica = nomFitxer.nextLine();
        ArrayList<String> llistaCaracteristiques= new ArrayList<>();
        
        while (!caracteristica.equals("*")) { //bucle que llegeix característiques
            llistaCaracteristiques.add(caracteristica);
            caracteristica = nomFitxer.nextLine();
        }
        
        ArrayList<Horari> llistaHoraris = new ArrayList<>();
        HashMap<String,DuesHores> llistaExcepcions = new HashMap<>();
        
        String horariRegular = nomFitxer.nextLine();
        String delimitadors= "[ :-]+"; //separarem string per ':' i '-'
        String[] paraulesSeparades; //string que usarem per llegir cada línia d'horaris i excepcions
        
        System.out.println("HORARI REGULAR " + horariRegular);
        while (!horariRegular.equals("*")) { //bucle que llegeix horaris i excepcions
            
            paraulesSeparades = horariRegular.split(delimitadors); //separem string per tal de tractar si es horari vàlid o excepció
            System.out.println("acabo de llegir " + paraulesSeparades[0] + " " + paraulesSeparades[1]);
            if (paraulesSeparades[2].length()>2){ //es tracta d'un horari vàlid
                llistaHoraris.add(string2Horari(horariRegular)); 
            }
            else { //es tracta d'una excepció
                DuesHores dH = new DuesHores(LocalTime.of(Integer.parseInt(paraulesSeparades[2]),Integer.parseInt(paraulesSeparades[3])),LocalTime.of(Integer.parseInt(paraulesSeparades[4]),Integer.parseInt(paraulesSeparades[5])));
                llistaExcepcions.put(paraulesSeparades[0]+" "+paraulesSeparades[1],dH);
            }
            horariRegular = nomFitxer.nextLine();
        }
        
        agencia.crearVisitable(nomLloc,coordenades,zonaHoraria,preu,llistaCaracteristiques,tempsVisitaRecomanat, llistaHoraris, llistaExcepcions);
    }
    
    /**
     * @brief converteix l'string que entra en una LocalDate i la retorna
     * @pre data conté una data vàlida
     * @post retorna una LocalDate
     */
    private LocalDate passarData(String data) {
        
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = data.split(delimitadors);
        return (LocalDate.of(Integer.parseInt(paraulesSeparades[0]),Integer.parseInt(paraulesSeparades[1]), Integer.parseInt(paraulesSeparades[2])));
    }

    /**
     * @brief realitza les operacions d'entrada del fitxer quan s'introdueix una visita
     * @pre cert
     * @post dades de la visita guardades
     */
    private void entradaVisita(Scanner nomFitxer) {
        
        String nomClient = nomFitxer.nextLine();
        String llocVisitat = nomFitxer.nextLine();
        LocalDate data = passarData(nomFitxer.nextLine());
        
        agencia.crearVisita(nomClient,llocVisitat,data);
    }

    /**
     * @brief realitza les operacions d'entrada del fitxer quan s'introdueix una associació entre llocs
     * @pre cert
     * @post dades dels llocs que associar guardades
     */
    private void entradaAssociarLloc(Scanner nomFitxer) {
        
        String secundari = nomFitxer.nextLine();
        String primari = nomFitxer.nextLine();
        
        agencia.crearAssociarLloc(secundari,primari);
    }

    /**
     * @brief realitza les operacions d'entrada del fitxer quan s'introdueix una associació de transport
     * @pre cert
     * @post dades de l'associació de transport guardades 
     */
    private void entradaAssociarTransport(Scanner nomFitxer) {

        String lloc = nomFitxer.nextLine();
        String mitjaTransport = nomFitxer.nextLine();
        int durada = passarInt(nomFitxer.nextLine());
        float preu = Float.parseFloat(nomFitxer.nextLine());
        
        agencia.crearAssociarTransport(lloc,mitjaTransport,durada,preu);
    }

    /**
     * @brief realitza les operacions d'entrada del fitxer quan s'introdueix un transport directe
     * @pre cert
     * @post dades del transport directe guardades
     */
    private void entradaTransportDirecte(Scanner nomFitxer) {

        String origen = nomFitxer.nextLine(); 
        String desti = nomFitxer.nextLine(); 
        String mitja = nomFitxer.nextLine();
        int durada = passarInt(nomFitxer.nextLine()); 
        float preu = Float.parseFloat(nomFitxer.nextLine());

        agencia.crearTransportDirecte(origen,desti,mitja,durada,preu);
    }

    /**
     * @brief realitza les operacions d'entrada del fitxer quan s'introdueix un transport indirecte
     * @pre cert
     * @post dades del transport indirecte guardades
     */
    private void entradaTransportIndirecte(Scanner nomFitxer) {

        String origen = nomFitxer.nextLine(); 
        String desti = nomFitxer.nextLine(); 
        String mitja = nomFitxer.nextLine(); 
        
        String _tempsFinsOrigen = nomFitxer.nextLine(); 
        int tempsFinsOrigen = passarInt(_tempsFinsOrigen); // passem del format 'x:y' a un enter resultat de '60*x + y'
        
        String _tempsFinsDesti = nomFitxer.nextLine(); 
        int tempsFinsDesti = passarInt(_tempsFinsDesti); // passem del format 'x:y' a un enter resultat de '60*x + y'
        
        String data = nomFitxer.nextLine(); 
        LocalDate dataTransport = passarData(data);
        String horari;
        String durada; 
        String preu;
        
        String delimitadors= "[ :-]+"; //separarem string per ':' i '-'
        
        HashMap<LocalDate,ArrayList<TransportIndirecte>> transportIndirecte = new HashMap<>(); //mapa amb clau primaria = data | clau secundària = ArrayList<TransportIndirecte>
        ArrayList<TransportIndirecte> llistaTransportIndirecte = new ArrayList<>();
        
        TransportIndirecte nouTransport = new TransportIndirecte();
        String[] paraulesSeparades;
        
        while (!data.equals("*")){ //sortirem amb el break

            horari = nomFitxer.nextLine();
            paraulesSeparades = horari.split(delimitadors);
            
            while(!horari.equals("*") && (Integer.parseInt(paraulesSeparades[0]) < 24)){ //entrarem si no es tracta d'una data de transport indirecte
                durada = nomFitxer.nextLine();
                preu = nomFitxer.nextLine(); 
                nouTransport.afegir(horari,durada,Float.parseFloat(preu));
                llistaTransportIndirecte.add(nouTransport);
                
                horari = nomFitxer.nextLine();
                paraulesSeparades = horari.split(delimitadors);
            }
            
            transportIndirecte.put(dataTransport,llistaTransportIndirecte); //guardem un transport indirecte i la seva informacio
            llistaTransportIndirecte.clear(); 
            nouTransport = new TransportIndirecte();
            
            if (horari.equals("*")) //hem acabat de llegir transports indirectes
                break;    
            else //seguim llegint transports indirectes
                dataTransport = passarData(horari);
        }

        agencia.crearTransportIndirecte(origen,desti,mitja,tempsFinsOrigen,tempsFinsDesti,transportIndirecte);
    }

    /**
     * @brief converteix un string que conte una hora en un objecte LocalTime i el retorna
     * @pre hora conté un string vàlid
     * @post retorna un objecte LocalTime
     */
    private LocalTime passarHora(String hora){
        
        String delimitadors= "[ :-]+";
        String[] paraulesSeparades = hora.split(delimitadors);
        return (LocalTime.of(Integer.parseInt(paraulesSeparades[0]),Integer.parseInt(paraulesSeparades[1])));
    }
    
    /**
     * @brief realitza les operacions d'entrada del fitxer quan s'introdueix un viatge
     * @pre cert
     * @post dades del viatge guardades
     */
    private void entradaViatge(Scanner nomFitxer) {
        
        String dataI = nomFitxer.nextLine();
        LocalDate dataInici = passarData(dataI);
        
        String _horaInici = nomFitxer.nextLine();
        LocalTime horaInici = passarHora(_horaInici);
        
        int nombreDies = Integer.parseInt(nomFitxer.nextLine());
        float preuMaxim = Float.parseFloat(nomFitxer.nextLine());
        String categoria = nomFitxer.nextLine();
        
        ArrayList<String> clients = new ArrayList<>();
        String client = nomFitxer.nextLine();
        
        while (!client.equals("*")) { //llegim la llista de clients que participen al viatge
            
            clients.add(client);
            client = nomFitxer.nextLine();
        }
        
        ArrayList<String> rutes = new ArrayList<>();
        String ruta = nomFitxer.nextLine();
        
        while (!ruta.equals("*")) { //llegim els algoritmes rutes que es volen realitzar
            
            rutes.add(ruta);
            ruta = nomFitxer.nextLine();
        }
        
        agencia.crearEntradaViatge(dataInici,horaInici,nombreDies,preuMaxim,categoria,clients,rutes);
    } 
  
    private Agencia agencia; ///< classe que comunica l'entrada amb l'agencia, quelcom conté totes les dades del programa
}
