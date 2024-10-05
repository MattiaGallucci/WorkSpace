/* La classe Triangolo deve presentare tre vertici per poterne calcolare il baricentro,
altrimenti si deve avere il punto origine come restituito dal metodo baricentro().
In aggiunta non è possibile inserire più di tre punti. Il calcolo del baricentro
con tre vertici è dato dalle medie delle coordinate dei suoi vertici: xB = (x1+x2+x3)/3 ; yB = (y1 + y2+ y3)/3 */

package poo23;

import java.util.List;

public class Triangolo implements IFigura{
    private String nome;
    private List<Punto> punti;
    
    public Triangolo(String nome, List<Punto> punti) {
        this.nome = nome;
        this.punti = punti;
    }

    public String getNome(){ return nome; }

    @Override
    public Punto baricentro(){
        double xB = 0;
        double yB = 0;
        
        for(Punto p : punti){
            xB += p.getX();
            yB += p.getY();
        }
        xB /= 3;
        yB /= 3;
        
        return new Punto(xB, yB);
    }

    public int inserisciPunto(Punto punto) throws Exception{
        if(punti.size() == 3) throw new Exception("Il triangolo è già pieno");
        punti.add(punto);
        return punti.size();
    }

    public void rimuoviPunto(int pos) throws Exception{
        if(pos < 0 || pos > punti.size()-1) throw new Exception("Posizione non valida");
        punti.remove(pos);
    }

    public String toString(){
        return "Triangolo: " + nome + " con " + punti.size() + " punti";
    }
}
