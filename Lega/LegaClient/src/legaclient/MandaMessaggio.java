/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legaclient;

import java.util.Scanner;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.Circolo;
import server.CircoloEJBRemote;

/**
 *
 * @author CORSO_PD
 */
public class MandaMessaggio {
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        CircoloEJBRemote ejb = (CircoloEJBRemote) ctx.lookup("java:global/LegaEJB/CircoloEJB!server.CircoloEJBRemote");

        Scanner scan = new Scanner(System.in);
        int id;
        String nome, responsabile;
        
        System.out.println("Inserisci id");
        id = scan.nextInt(); scan.nextLine();
        System.out.println("Inserisci nome");
        nome = scan.nextLine();
        System.out.println("Inserisci responsabile");
        responsabile = scan.nextLine();
        
        Circolo c = ejb.findById(id);
        c.setNome(nome);
        c.setResponsabile(responsabile);
        
        // Looks up the administered objects
        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");

        try (JMSContext jmsContext = connectionFactory.createContext()) {
          // Sends an object message to the topic
          jmsContext.createProducer().send(topic, c);
          System.out.println("Circolo sent");       
        }
        
    }
}
