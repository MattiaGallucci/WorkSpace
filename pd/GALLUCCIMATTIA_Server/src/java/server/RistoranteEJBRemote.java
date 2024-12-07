package server;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface RistoranteEJBRemote {
    public void crea(Prenotazione p);
    public void aggiorna(Prenotazione p);
    public void elimina(Prenotazione p);
    
    public Prenotazione trovaPerId(int id);
    public List<Prenotazione> trovaPerTipoTavolo(String tipoTavolo);
    public List<Prenotazione> trovaTutti();
    public List<Prenotazione> trovaPerNumeroPersone(int numeroPersone);
}
