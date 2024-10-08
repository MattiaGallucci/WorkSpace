package clientserverremotesocket;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ImpiegatoSkeleton extends Thread{
    ImpiegatoServer server;

    public ImpiegatoSkeleton(ImpiegatoServer server) {
        this.server = server;
    }
    
    public static void main(String[] args) {
        ImpiegatoServer impiegato = new ImpiegatoServer("Mario Rossi", "01721", 30000);
        ImpiegatoSkeleton skeleton = new ImpiegatoSkeleton(impiegato);
        skeleton.start();
    }
    
    public void run(){
        Socket socket = null;
        String metodo;
        int parametro;
        System.out.println("Attendo connessioni...");
        try{
            ServerSocket serverSocket = new ServerSocket(9000);
            socket = serverSocket.accept();
            System.out.println("Accettata una connessione... attendo comandi.");
            
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                
            while(true){
                metodo = (String) in.readObject();
                System.out.println("Comando richiesto: " + metodo);
                
                if(metodo.equals("getNome")){
                    out.writeObject(server.getNome());
                    out.flush();
                } else if(metodo.equals("getID")){
                    out.writeObject(server.getID());
                    out.flush();
                } else if(metodo.equals("getStipendio")){
                    out.writeInt(server.getStipendio());
                    out.flush();
                } else if(metodo.equals("aumentaStipendio")){
                    parametro = in.readInt();
                    out.writeInt(server.aumentaStipendio(parametro));
                    out.flush();
                } else
                    break;
            }
        } catch(EOFException e){
            System.out.println("Terminata la connessione");
        } catch(Throwable t){
            t.printStackTrace();
            System.exit(0);
        } finally{
            try{
                socket.close();
            } catch(IOException e){
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}
