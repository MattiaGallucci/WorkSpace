package clientserverremotesocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ImpiegatoStub implements Impiegato{
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;
    
    public ImpiegatoStub(String host) throws Throwable{
        socket = new Socket("localhost", 7000); //host
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }
    
    public String getNome() throws Throwable{
        out.writeObject("getNome");
        out.flush();
        return (String) in.readObject();
    }
    
    public String getID() throws Throwable{
        out.writeObject("getID");
        out.flush();
        return (String) in.readObject();
    }
    
    public int getStipendio() throws Throwable{
        out.writeObject("getStipendio");
        out.flush();
        return in.readInt();
    }
    
    public int aumentaStipendio(int diQuanto) throws  Throwable{
        out.writeObject("aumentaStipendio");
        out.writeInt(diQuanto);
        out.flush();
        return in.readInt();
    }
    
    public void close(){
        try{
            socket.close();
        } catch(IOException e){
            System.out.println("Chiusura socket non effettuata con successo!");
        }
    }
}
