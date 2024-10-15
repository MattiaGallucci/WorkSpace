import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Hotel extends Remote{
    ArrayList<String> getCamere() throws RemoteException;
    boolean prenotaCamera(int i) throws RemoteException;
}
