/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package babbonatale;

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
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class CambiaStatoMDB implements MessageListener {
    
    @Inject
    private BabboNataleController bnc;
    
    public CambiaStatoMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        Bambino b;
        try {
            b = message.getBody(Bambino.class);
            if (b.getNumeroNucleo() > 10) {
                b.setPriorita("SI");
                System.out.println("Procedere con priorità qui");
            }
            bnc.updateBambino(b);
            System.out.println("Aggiornamento effettuato");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
}
