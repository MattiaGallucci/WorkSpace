
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.Permission;
import java.util.logging.Logger;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    public CalculatorImpl() throws RemoteException {
    }

    @Override
    public float somma(float op1, float op2) throws RemoteException {
        return op1 + op2;
    }

    @Override
    public double sottrazione(double op1, double op2) throws RemoteException {
        return op1 - op2;
    }

    @Override
    public float moltiplicazione(float op1, float op2) throws RemoteException {
        return op1 * op2;
    }

    @Override
    public float divisione(float op1, float op2) throws RemoteException {
        if (op2 == 0) {
            return 0;
        }
        return op1 / op2;
    }
}
