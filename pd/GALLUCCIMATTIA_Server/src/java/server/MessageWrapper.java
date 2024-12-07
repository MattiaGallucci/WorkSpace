package server;

import java.io.Serializable;

public class MessageWrapper implements Serializable{
    private int id;
    private int numeroPersone;

    public MessageWrapper(int id, int numeroPersone) {
        this.id = id;
        this.numeroPersone = numeroPersone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroPersone() {
        return numeroPersone;
    }

    public void setNumeroPersone(int numeroPersone) {
        this.numeroPersone = numeroPersone;
    }

    @Override
    public String toString() {
        return "MessageWrapper{" + "id=" + id + ", numeroPersone=" + numeroPersone + '}';
    }
}
