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
public class AggiornaBottiglie implements MessageListener {
    
    @Inject
    private EnotecaEJB ejb;
    
    public AggiornaBottiglie() {
    }
    
    @Override
    public void onMessage(Message message) {
        Vino v;
        try {
            v = message.getBody(Vino.class);
            if (v.getBottiglie() < 10) {
                v.setAcquisto(true);
                System.out.println("Il vino " + v.getNominativo() + " deve essere riassortito");
            }
            ejb.modifyVino(v);
            System.out.println("Aggiornamento effettuato");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
}
