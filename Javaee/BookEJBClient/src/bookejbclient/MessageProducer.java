/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookejbclient;

import book.RequestMDB;
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
public class MessageProducer 
{
    public static void main(String[] args) throws NamingException 
    {
        Context jndiContext = new InitialContext();
        
        ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) jndiContext.lookup("jms/javaee7/Topic");
        
        try(JMSContext jmsContex = connectionFactory.createContext())
        {
            RequestMDB req = new RequestMDB(1l, 4000f);
            jmsContex.createProducer().send(topic, req);
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
       
        
    }
}
