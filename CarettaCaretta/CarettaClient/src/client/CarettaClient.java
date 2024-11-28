/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.*;

/**
 *
 * @author CORSO_PD
 */
public class CarettaClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        SitoEJBRemote sitoEJB = (SitoEJBRemote) ctx.lookup("java:global/CarettaEJB/SitoEJB!server.SitoEJBRemote");
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Inserire la regione di cui si vuole vedere il numero totale di nidi");
        String regioneCercata = scan.nextLine();
        // int nTotaleNidi = sitoEJB.nidiByRegione(regioneCercata);
        List<Sito> l = sitoEJB.findByRegione(regioneCercata);
        int nTotaleNidi = 0;
        for (Sito s : l) {
            nTotaleNidi += s.getnNidi();
        }
        System.out.println("Numero totale di nidificazione per " + regioneCercata + ": " + nTotaleNidi + "\n\n");
        
        printSiti("Tutte le nidificazioni per cui è stato richiesto un intervento",
        sitoEJB.findByIntervento());
    }
    
    private static void printSiti(String titolo, List<Sito> lista) {
        System.out.println("***" + titolo + "***");
        for(Sito s : lista) {
            System.out.println(s);
        }
        System.out.println("\n\n");
    }
    
    
}
