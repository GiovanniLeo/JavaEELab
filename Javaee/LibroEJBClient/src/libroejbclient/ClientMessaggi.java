/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libroejbclient;

import libro.Messaggio;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author giovanni
 */
public class ClientMessaggi {

    public static void main(String[] args) throws NamingException {
        Context jndiContext = new InitialContext();

        ConnectionFactory connectionFactory = (ConnectionFactory) 
                jndiContext.lookup("jms/BookConnectionFactory");

        Destination topic = (Destination) jndiContext.lookup("jms/BookTopic");
        
        try(JMSContext context = connectionFactory.createContext())
        {
            Messaggio msg = new Messaggio(1l, 1234);
            context.createProducer().send(topic, msg);
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
        

    }

}
