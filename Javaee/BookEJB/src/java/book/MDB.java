/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.jms.JMSException;

/**
 *
 * @author giovanni
 */

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/javaee7/Topic")
    ,
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/javaee7/Topic")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/javaee7/Topic")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class MDB implements MessageListener {
    
    @EJB
    private BookEJB bookEJB;
    
    public MDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        RequestMDB req = null;
        try {
        req = message.getBody(RequestMDB.class);
        System.out.println(""+req.getId()+", "+req.getPrice());
            updatePrice(req.getId(), req.getPrice());
        } catch (JMSException ex) {
            Logger.getLogger(MDB.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void updatePrice(long id, float price)
    {
            Book b = bookEJB.findBook(id);
            System.out.println("Pre update");
            System.out.println(b.toString());
            b.setPrice(price);
            bookEJB.updateBook(b);
            System.out.println("post update");
            System.out.println(b.toString());
            
    }
    
}
