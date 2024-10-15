
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ElezioniImpl extends UnicastRemoteObject implements Elezioni {

    Map<String, Integer> candidati;

    public ElezioniImpl(HashMap<String, Integer> candidati) throws RemoteException {
        this.candidati = candidati;
    }

    @Override
    public ArrayList<String> getCandidati() throws RemoteException {
        return new ArrayList<String>(candidati.keySet());
    }

    @Override
    public synchronized int votaCandidato(String candidato) throws RemoteException {
        if (candidati.containsKey(candidato)) {
            int voti = candidati.get(candidato);
            voti++;
            candidati.put(candidato, voti);

            return voti;
        }
        return 0;
    }

    @Override
    public synchronized String getRisultati() throws RemoteException {
        StringBuilder risultati = new StringBuilder();

        for (Map.Entry<String, Integer> entry : candidati.entrySet()) {
            String candidato = entry.getKey();
            int voti = entry.getValue();
            risultati.append(candidato).append(": ").append(voti).append(" voto/i\n");
        }

        return risultati.toString();
    }

}
