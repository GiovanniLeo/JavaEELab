/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author giovanni
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/BookTopic")
    ,
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/BookTopic")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/BookTopic")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class Consumer implements MessageListener {
    
    @EJB
    private LibroEJB ejb;
    
    public Consumer() {
    }
    
    @Override
    public void onMessage(Message message) {
         Messaggio msg = null;
         try {
              msg = message.getBody(Messaggio.class);
            //  Libro b = ejb.aggiornaLibroPerId(msg.getId(), msg.getCode());
              //System.out.println(b.toString());
            
        } catch (Exception e) {
        }
      
    }
    
}
