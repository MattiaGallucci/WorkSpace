/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uefa_JMS_Client;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import uefa.MessageWrapper;

/**
 *
 * @author matti
 */
public class UEFAJMSClient {
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");
        
        MessageWrapper mw = new MessageWrapper(153, 1, "Italia");
        
        try(JMSContext jmsCtx = cf.createContext()){
            jmsCtx.createProducer().send(topic, mw);
        }
    }
}
