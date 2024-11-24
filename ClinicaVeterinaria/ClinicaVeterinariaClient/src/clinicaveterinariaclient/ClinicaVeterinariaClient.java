/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicaveterinariaclient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import clinica.*;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author CORSO_PD
 */
public class ClinicaVeterinariaClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        // TODO code application logic here
        Context ctx = (Context) new InitialContext();
        ClinicaEJBRemote clinicaEJB = (ClinicaEJBRemote) ctx.lookup("java:global/ClinicaVeterinariaEJB/ClinicaEJB!clinica.ClinicaEJBRemote");
        Scanner scan = new Scanner(System.in);
        
        stampaPazienti("STAMPA TUTTI I PAZIENTI", clinicaEJB.findAll());
        
        System.out.println("Inserisci l'id da ricercare: ");
        int idDaCercare = scan.nextInt(); scan.nextLine();
        stampaPazienti("STAMPA PAZIENTE CON ID:" + idDaCercare, clinicaEJB.findById(idDaCercare));
        
        System.out.println("Inserisci il tipo di animale da cercare:");
        String tipoDaCercare = scan.nextLine();
        stampaPazienti("STAMPA PAZIENTI TIPO: " + tipoDaCercare, clinicaEJB.findByTipo(tipoDaCercare));
        
        System.out.println("Inserisci lo status di ricovero (SI/NO): ");
        boolean statusDaCercare = scan.nextLine().equalsIgnoreCase("SI");
        stampaPazienti("STAMPA PAZIENTI " + 
                (statusDaCercare ? "" : "NON") + 
                " RICOVERATI", 
                clinicaEJB.findByStatus(statusDaCercare));
        
        stampaPazienti("STAMPA PAZIENTI SENZA MICROCHIP", clinicaEJB.findUnchipped());

        System.out.println("FINE ESECUZIONE");
    }
     
    private static void stampaPazienti(String titolo, List<Paziente> lista) {
        System.out.println("***" + titolo + "***");
        for(Paziente p : lista) {
            System.out.println(p);
        }
        System.out.println("\n\n");
    }
    
}
