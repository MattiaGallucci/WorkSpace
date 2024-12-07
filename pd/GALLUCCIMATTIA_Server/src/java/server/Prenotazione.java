package server;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import static server.Prenotazione.TROVA_PER_ID;
import static server.Prenotazione.TROVA_PER_NUMERO_PERSONE;
import static server.Prenotazione.TROVA_PER_TIPO_TAVOLO;
import static server.Prenotazione.TROVA_TUTTI;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_PER_ID, query = "SELECT p FROM Prenotazione p WHERE p.id = :id"),
    @NamedQuery(name = TROVA_PER_TIPO_TAVOLO, query = "SELECT p FROM Prenotazione p WHERE p.tipoTavolo = :tipoTavolo"),
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT p FROM Prenotazione p"),
    @NamedQuery(name = TROVA_PER_NUMERO_PERSONE, query = "SELECT p FROM Prenotazione p WHERE p.numeroPersone = :numeroPersone"),})

public class Prenotazione implements Serializable {

    public static final String TROVA_PER_ID = "Prenotazione.trovaPerId";
    public static final String TROVA_PER_TIPO_TAVOLO = "Prenotazione.trovaPerTipoTavolo";
    public static final String TROVA_TUTTI = "Prenotazione.trovaTutti";
    public static final String TROVA_PER_NUMERO_PERSONE = "Prenotazione.trovaPerNumeroPersone";

    @Id
    private int id;
    private String nomeCliente;
    private int numeroPersone;
    private String tipoTavolo;
    private LocalDateTime dataTempo;

    public Prenotazione() {
    }

    public Prenotazione(int id, String nomeCliente, int numeroPersone, String tipoTavolo, LocalDateTime dataTempo) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.numeroPersone = numeroPersone;
        this.tipoTavolo = tipoTavolo;
        this.dataTempo = dataTempo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getNumeroPersone() {
        return numeroPersone;
    }

    public void setNumeroPersone(int numeroPersone) {
        this.numeroPersone = numeroPersone;
    }

    public String getTipoTavolo() {
        return tipoTavolo;
    }

    public void setTipoTavolo(String tipoTavolo) {
        this.tipoTavolo = tipoTavolo;
    }

    public LocalDateTime getDataTempo() {
        return dataTempo;
    }

    public void setDataTempo(LocalDateTime dataTempo) {
        this.dataTempo = dataTempo;
    }

    @Override
    public String toString() {
        return "Prenotazione{" + "id=" + id + ", nomeCliente=" + nomeCliente + ", numeroPersone=" + numeroPersone + ", tipoTavolo=" + tipoTavolo + ", dataTempo=" + dataTempo + '}';
    }
}
