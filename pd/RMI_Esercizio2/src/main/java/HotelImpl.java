import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class HotelImpl extends UnicastRemoteObject implements Hotel{
    private ArrayList<String> camere;
    int[] array;
    
    public HotelImpl (ArrayList<String> camere) throws RemoteException{
        this.camere = camere;
        array = new int[camere.size()];
    }
    
    @Override
    public ArrayList<String> getCamere() throws RemoteException {
        return camere;
        }

    @Override
    public synchronized boolean prenotaCamera(int i) throws RemoteException {
        if(i>0 && i<array.length){
            if(array[i] == 0)
                return true;
            return false;
        }
        return false;
    }
    
}
