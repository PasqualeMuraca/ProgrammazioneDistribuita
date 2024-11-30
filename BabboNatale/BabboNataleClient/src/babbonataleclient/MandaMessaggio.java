/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babbonataleclient;

import babbonatale.BabboNataleRemote;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import babbonatale.*;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;

/**
 *
 * @author CORSO_PD
 */
public class MandaMessaggio {
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        BabboNataleRemote babboNataleEJB = (BabboNataleRemote) ctx.lookup("java:global/BabboNataleEJB/BabboNataleController!babbonatale.BabboNataleRemote");        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Inserisci l'id del bambino di cui va cambiato lo stato della lettera");
        Long id = scan.nextLong();
        Bambino b = babboNataleEJB.findBambinoById(id);
        b.setStato(Boolean.TRUE);
        System.out.println(b);
        
        ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");

        try (JMSContext jmsContext = connectionFactory.createContext()) {
          jmsContext.createProducer().setProperty("nucleo", b.getNumeroNucleo()).send(topic, b);
          System.out.println("bambino sent");          
        }
    }
}
