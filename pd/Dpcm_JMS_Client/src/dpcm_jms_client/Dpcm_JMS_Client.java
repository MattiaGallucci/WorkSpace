/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dpcm_jms_client;

import dpcm.MessageWrapper;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Dpcm_JMS_Client {
    public static void main(String[] args) throws NamingException{
        Context ctx = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");
        
        MessageWrapper mw = new MessageWrapper(1, 5);
        
        try(JMSContext jmsc = cf.createContext()){
            jmsc.createProducer().send(topic,mw);
	}
    }
}