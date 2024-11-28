/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.sql.Date;
import java.util.Scanner;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.Sito;
import server.SitoEJBRemote;

/**
 *
 * @author CORSO_PD
 */
public class MandaMessaggio {
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        SitoEJBRemote sitoEJB = (SitoEJBRemote) ctx.lookup("java:global/CarettaEJB/SitoEJB!server.SitoEJBRemote");
        

        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci l'id del sito di cui modificare il numero dei nidi");
        int id = scan.nextInt();
        Sito s = sitoEJB.findById(id);
        System.out.println("Inserisci il numero di nidi modificato");
        int nNidi = scan.nextInt();
        s.setnNidi(nNidi);

        // Looks up the administered objects
        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");

        try (JMSContext jmsContext = connectionFactory.createContext()) {
          // Sends an object message to the topic
          jmsContext.createProducer().setProperty("nNidi", nNidi).send(topic, s);
          System.out.println("Sito sent");          
        }
    }
}
