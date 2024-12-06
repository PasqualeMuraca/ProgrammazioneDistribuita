/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.*;

/**
 *
 * @author CORSO_PD
 */
public class MandaMessaggio {
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        // TaskEJBRemote ejb = (TaskEJBRemote) ctx.lookup("java:global/TaskEJB/TaskEJB!server.TaskEJBRemote");
        
        //Task t = new Task(4, "task nuova", "tipo nuovo", 5, "nessuno", 5);
        Task t = new Task(5, "task nuova", "tipo nuovo", 10000, "nessuno", 1000);

        
        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");

        try (JMSContext jmsContext = connectionFactory.createContext()) {
          jmsContext.createProducer().send(topic, t);
          System.out.println("task sent");          
        }
    }
}
