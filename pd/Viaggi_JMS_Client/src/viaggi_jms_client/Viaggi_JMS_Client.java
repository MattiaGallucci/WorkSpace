/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package viaggi_jms_client;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import viaggi.MessageWrapper;

/**
 *
 * @author matti
 */
public class Viaggi_JMS_Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");
    
        MessageWrapper mw = new MessageWrapper(3, 10);
        
        try(JMSContext jmsc = cf.createContext()){
            jmsc.createProducer().send(topic, mw);
        }
    }
    
}
