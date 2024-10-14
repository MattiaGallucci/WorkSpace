package clientserverremotesocket;

import java.io.Serializable;

public class RecordRegistro implements Serializable{
    private String nome;
    private String indirizzo;

    public RecordRegistro(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }
}
