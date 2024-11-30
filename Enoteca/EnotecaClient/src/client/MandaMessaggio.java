/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Scanner;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.EnotecaEJBRemote;
import server.Vino;

/**
 *
 * @author CORSO_PD
 */
public class MandaMessaggio {
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        EnotecaEJBRemote ejb = (EnotecaEJBRemote) ctx.lookup("java:global/EnotecaEJB/EnotecaEJB!server.EnotecaEJBRemote");
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci l'id del vino per aggiornarne le bottiglie");
        int id = scan.nextInt();
        Vino v = ejb.findById(id);
        System.out.println("trovato: " + v);
        System.out.println("Inserisci il numero di nuove bottiglie");
        int nuoveBottiglie = scan.nextInt();
        v.setBottiglie(nuoveBottiglie);
        
        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");

        try (JMSContext jmsContext = connectionFactory.createContext()) {
          jmsContext.createProducer().setProperty("bottiglie", v.getBottiglie()).send(topic, v);
          System.out.println("vino sent");          
        }
    }
}
