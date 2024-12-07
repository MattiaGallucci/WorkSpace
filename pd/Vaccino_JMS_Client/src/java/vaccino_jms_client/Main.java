/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vaccino_jms_client;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import vaccino.MessageWrapper;

/**
 *
 * @author matti
 */
public class Main {

    public static void main(String[] args) throws Exception{
        Context ctx = new InitialContext();
        
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");
        
        MessageWrapper mw = new MessageWrapper(1, true);
        
        try(JMSContext jmsctx = cf.createContext()){
            jmsctx.createProducer().send(topic, mw);
        }
    }
}