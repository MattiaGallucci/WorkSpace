package com.mycompany.clientserversocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class Client {
    static Logger logger = Logger.getLogger("global");
    static final String ERRORMSG = "Cosa?";
    static BufferedReader inBR = null;
    
    private static String ask(String prompt) throws IOException{
        System.out.println(prompt + " ");
        return (inBR.readLine());
    }
    
    public static void main(String[] args) {
        //String host = args[0];
        String cmd;
        inBR = new BufferedReader(new InputStreamReader(System.in));
        
        try{
            while(!(cmd = ask("Comandi>")).equals("quit")){
                if(cmd.equals("inserisci")){
                    System.out.println("Inserisci i dati.");
                    String nome = ask("Nome: ");
                    String indirizzo = ask("Indirizzo: ");
                    
                    RecordRegistro r = new RecordRegistro(nome, indirizzo);
                    Socket socket = new Socket("localhost", 7000); //METTI host
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                
                    out.writeObject(r);
                    out.flush();
                    socket.close();
                } else if(cmd.equals("cerca")){
                    System.out.println("Inserisci il nome per la ricerca.");
                    String nome = ask("Nome: ");
                    
                    RecordRegistro r = new RecordRegistro(nome, null);
                    Socket socket = new Socket("localhost", 7000); //METTI host
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                    
                    out.writeObject(r);
                    out.flush();
                    RecordRegistro res = (RecordRegistro) in.readObject();
                    
                    if(res != null)
                        System.out.println("Indirizzo: " + res.getIndirizzo());
                    else 
                        System.out.println("Record non presente");
                    socket.close();
                } else
                    System.out.println(ERRORMSG);
            }
        } catch (Throwable t){
            logger.severe("Lanciata Throwable" + t.getMessage());
            t.printStackTrace();
        }
        System.out.println("Bye Bye");
    }
}
