
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote{
    float somma(float op1, float op2) throws RemoteException;
    double sottrazione(double op1, double op2) throws RemoteException;
    float moltiplicazione(float op1, float op2) throws RemoteException;
    float divisione(float op1, float op2) throws RemoteException;
}
