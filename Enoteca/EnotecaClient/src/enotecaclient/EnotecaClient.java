/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enotecaclient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import enoteca.*;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author CORSO_PD
 */
public class EnotecaClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context ctx = (Context) new InitialContext();
        EnotecaEJBRemote enotecaEJB = (EnotecaEJBRemote) ctx.lookup("java:global/EnotecaEJB/EnotecaEJB!enoteca.EnotecaEJBRemote");
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Inserisci un limite di prezzo");
        double limiteSup = scan.nextDouble(); scan.nextLine();
        stampaVini(
            "VINI CON PREZZO INFERIORE A " + limiteSup, 
            enotecaEJB.findLowerThanPrezzo(limiteSup)
        );
        
        System.out.println("Inserisci una provenienza");
        String prov = scan.nextLine();
        stampaVini(
            "VINI CON PROVENIENZA " + prov, 
            enotecaEJB.findByProvenienza(prov)
        );
        
        stampaVini("TUTTI I VINI", enotecaEJB.findAll());
        
        System.out.println("FINE ESECUZIONE");
    }
    
    private static void stampaVini(String titolo, List<Vino> lista) {
        System.out.println("***" + titolo + "***");
        for(Vino v : lista) {
            System.out.println(v);
        }
        System.out.println("\n\n");
    }
    
}
