/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicaveterinariaclient;

import clinica.*;
import java.util.Scanner;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author CORSO_PD
 */
public class MandaMessaggio {
    public static void main(String[] args) throws NamingException {
        Paziente p = new Paziente(4, "coccodrillo", "Croco", "grande", "M", 5, "0", true);
        
        // Looks up the administered objects
        Context ctx = (Context) new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");

        try (JMSContext jmsContext = connectionFactory.createContext()) {
          // Sends an object message to the topic
          jmsContext.createProducer().send(topic, p);
          System.out.println("paziente sent");          
        }
    }
}
