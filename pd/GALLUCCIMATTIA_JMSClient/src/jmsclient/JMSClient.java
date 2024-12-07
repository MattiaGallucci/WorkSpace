package jmsclient;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.MessageWrapper;

public class JMSClient {
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");

        MessageWrapper mw = new MessageWrapper(0, 10);

        try (JMSContext jmsc = cf.createContext()) {
            jmsc.createProducer().send(topic, mw);
        }
    }
}