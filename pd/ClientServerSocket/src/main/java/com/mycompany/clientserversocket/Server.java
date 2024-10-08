package com.mycompany.clientserversocket;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Logger;

public class Server {
    static Logger logger = Logger.getLogger("global");
    
    public static void main(String[] args) {
        HashMap<String, RecordRegistro> hash = new HashMap<>();
        Socket socket = null;
        System.out.println("In attesa di connessioni...");
        try{
            ServerSocket serverSocket = new ServerSocket(7000);
            while(true){
                socket = serverSocket.accept();
                
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                RecordRegistro record = (RecordRegistro) in.readObject();
                
                if(record.getIndirizzo() != null){
                    logger.info("Inserisco " + record.getNome() + ", " + record.getIndirizzo());
                    hash.put(record.getNome(), record);
                } else {
                    logger.info("Cerco " + record.getNome());
                    RecordRegistro res = hash.get(record.getNome());
                    out.writeObject(res);
                    out.flush();
                }
                socket.close();
            }
        } catch (EOFException e) {
            logger.severe("Problemi con la connessione:" + e.getMessage());
            e.printStackTrace();
        } catch (Throwable t){
            logger.severe("Lanciata Throwable" + t.getMessage());
            t.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e){
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}
