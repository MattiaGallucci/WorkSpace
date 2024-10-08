package com.mycompany.helloworldsocket;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class HelloWorldSocket {
    static Logger logger = Logger.getLogger("global");
    
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            logger.info("Socket istanziato, accetto connessioni...");
            Socket socket = serverSocket.accept();
            logger.info("accectata una connessione... attendo conandi.");
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            String nome = (String) in.readObject();
            logger.info("Ricevuto:" + nome);
            out.writeObject("Hello " + nome);
            socket.close();
        } catch (EOFException e) {
            logger.severe("Problemi con la connessione:" + e.getMessage());
            e.printStackTrace();
        } catch (Throwable t){
            logger.severe("Lanciata Throwable" + t.getMessage());
            t.printStackTrace();
        }
    }
}
