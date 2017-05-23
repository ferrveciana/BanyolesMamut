/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proactiva;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;


/**
 *
 * @author ASUS
 */
public class ProActiva {

 /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner teclat = new Scanner(System.in);
        System.out.println("Nom del fitxer: ");
        Scanner nomFitxer = new Scanner(new File(teclat.nextLine()));
        
        Entrada entrada = new Entrada(nomFitxer);
        Agencia agencia = entrada.obtenirAgencia();
//        agencia.getInfo();
System.out.println("____________________________________________________________________________________________");
        agencia.getHubs();
        
        Solucio solucio = new Solucio(agencia,agencia.getViatge().origen(),agencia.getViatge().desti(),agencia.getViatge().preuMax(),agencia.getViatge().destinacions(),agencia.getViatge().preferencies());
        Solucionador solucionador = new Solucionador("s");
        solucionador.executarNouBkg(solucio,agencia.getViatge().origen(), LocalDateTime.MIN);
        
        Solucio sol = solucionador.obtOptima();
        sol.mostrar();

    }  
}