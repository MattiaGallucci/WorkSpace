package poo23;

import java.util.List;

public class Bando {
    private TipologiaBando tipo;
    private String id;
    private List<TipologiaBando> lista;
    
    public Bando(TipologiaBando tipo, String id) {
        this.tipo = tipo;
        this.id = id;
    }

    public TipologiaBando getTipo() {
        return tipo;
    }

    public void setTipo(TipologiaBando tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void partecipa(String persona, TipologiaBando tipo, Provincia pv){

    }
}
