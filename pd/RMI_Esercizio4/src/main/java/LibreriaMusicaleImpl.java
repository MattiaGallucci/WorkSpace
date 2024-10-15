
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LibreriaMusicaleImpl extends UnicastRemoteObject implements LibreriaMusicale {

    private HashMap<String, String> libreriaMusicale;
    private HashMap<String, ArrayList<String>> playlist;
    private HashMap<String, Integer> riproduzioni;

    public LibreriaMusicaleImpl(HashMap<String, String> libreriaMusicale, HashMap<String, ArrayList<String>> playlist, HashMap<String, Integer> riproduzioni) throws RemoteException {
        this.libreriaMusicale = libreriaMusicale;
        this.playlist = playlist;
        this.riproduzioni = riproduzioni;
    }

    @Override
    public HashMap<String, String> getCanzoni() throws RemoteException {
        return libreriaMusicale;
    }

    @Override
    public void addCanzone(String titolo, String link) throws RemoteException {
        if (!(libreriaMusicale.containsKey(titolo))) {
            libreriaMusicale.put(titolo, link);
        }
    }

    @Override
    public void creaPlaylist(String nome, ArrayList<String> canzoni) throws RemoteException {
        if (!(playlist.containsKey(nome))) {
            playlist.put(nome, canzoni);
        }

    }

    @Override
    public ArrayList<String> riproduci(String nome) throws RemoteException {
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<String> link = new ArrayList<>();
        
        if (playlist.containsKey(nome)) {
            temp = playlist.get(nome);
            
            for(String titolo : temp){
                link.add(libreriaMusicale.get(titolo));
            }

            if (riproduzioni.containsKey(nome)) {
                int rip = riproduzioni.get(nome);
                riproduzioni.put(nome, rip + 1);
            } else {
                riproduzioni.put(nome, 1);
            }
            return link;
        } else if (libreriaMusicale.containsKey(nome)) {
            link = (ArrayList<String>) Arrays.asList(libreriaMusicale.get(nome));
            
            if (riproduzioni.containsKey(nome)) {
                int rip = riproduzioni.get(nome);
                riproduzioni.put(nome, rip + 1);
            } else {
                riproduzioni.put(nome, 1);
            }
            return link;
        }
        return link;
    }
}