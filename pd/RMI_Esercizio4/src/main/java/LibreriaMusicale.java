
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public interface LibreriaMusicale extends Remote{
    HashMap<String, String> getCanzoni() throws RemoteException;
    void addCanzone(String titolo, String link) throws RemoteException;
    void creaPlaylist(String nome, ArrayList<String> canzoni) throws  RemoteException;
    ArrayList<String> riproduci(String nome) throws RemoteException;
}
