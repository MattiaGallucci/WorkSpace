package poo23;

import java.util.ArrayList;
import java.util.List;

public class Disegno{
    private List<IFigura> lista;

    public Disegno() {
        lista = new ArrayList<>();
    }

    public void aggiungiFigura(IFigura f){ lista.add(f); }
    
}