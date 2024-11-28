/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.persistence.EntityManager;

/**
 *
 * @author CORSO_PD
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/javaee7/Topic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/javaee7/Topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/javaee7/Topic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
    // @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "nNidi > 10")
})
public class troppiNidiMDB implements MessageListener {
    
    @Inject
    private SitoEJB sitoEJB;
    
    public troppiNidiMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        Sito s;
        try {
            s = message.getBody(Sito.class);
            if (s.getnNidi() > 10) {
                s.setIntervento(true);
                System.out.println("Alto numero nidi e' necessario spostarli");
            }
            sitoEJB.modifySito(s);
            System.out.println("Aggiornamento effettuato");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
}
