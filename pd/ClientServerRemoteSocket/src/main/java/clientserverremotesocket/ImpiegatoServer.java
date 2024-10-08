package clientserverremotesocket;

public class ImpiegatoServer implements Impiegato{
    private String nome;
    private String ID;
    private int stipendio;

    public ImpiegatoServer(String nome, String ID, int stipendio) {
        this.nome = nome;
        this.ID = ID;
        this.stipendio = stipendio;
    }

    public String getNome() {
        return nome;
    }

    public String getID() {
        return ID;
    }

    public int getStipendio() {
        return stipendio;
    }
    
    public int aumentaStipendio(int diQuanto){
        if(diQuanto > 0)
            stipendio += diQuanto;
        return stipendio;
    }
    
}
