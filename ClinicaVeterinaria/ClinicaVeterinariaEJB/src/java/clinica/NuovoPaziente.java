/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

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
public class NuovoPaziente implements MessageListener {
    
    @Inject
    private ClinicaEJB ejb;
    
    public NuovoPaziente() {
    }
    
    @Override
    public void onMessage(Message message) {
        Paziente p;
        try {
            p = message.getBody(Paziente.class);
            if (p.getMicrochip().equals("0")) {
                System.out.println("Attenzione, " + p.getNome() + " non dispone ancora di un microchip");
            }
            if (p.getTipo().equals("coccodrillo")) {
                System.out.println("Il coccodrillo come fa! Non c'e' nessuno che lo sa! :-)");
            }
            ejb.createPaziente(p);
            System.out.println("Nuovo inserimento effettuato");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
}
