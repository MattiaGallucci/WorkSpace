
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Elezioni extends Remote{
    ArrayList<String> getCandidati() throws RemoteException;
    int votaCandidato(String candidato) throws RemoteException;
    String getRisultati() throws RemoteException;
}
