package com.mycompany.helloworldsocket;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class Client {
    static Logger logger = Logger.getLogger("global");

    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 9000);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            out.writeObject("Mattia");
            System.out.println(in.readObject());
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
