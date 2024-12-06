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

/**
 *
 * @author CORSO_PD
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/javaee7/Topic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/javaee7/Topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/javaee7/Topic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class InserimentoMsg implements MessageListener {
    
    @Inject
    private TaskEJB ejb;
    
    public InserimentoMsg() {
    }
    
    @Override
    public void onMessage(Message message) {
        Task t;
        try {
            t = message.getBody(Task.class);
            if (t.getOrePreviste() <1 || t.getOrePreviste() > 8 || t.getPercentuale() < 0 || t.getPercentuale() > 100) {
                throw new RuntimeException("task fuori constraint");
            }
            else {
                ejb.createTask(t);
                System.out.println("Inserimento di " + t + " effettuato");
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
}
