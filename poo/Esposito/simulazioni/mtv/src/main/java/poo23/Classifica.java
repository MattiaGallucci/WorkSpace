package poo23;

import java.util.ArrayList;
import java.util.List;

public class Classifica <T extends Arte> {
    private String titolo;
    private AreaGeografica area;
    private Genere genere;
    private List<T> classifica;

    public Classifica(String titolo, AreaGeografica area, Genere genere) {
        this.titolo = titolo;
        this.area = area;
        this.genere = genere;
        classifica = new ArrayList<>(10);
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public AreaGeografica getArea() {
        return area;
    }

    public void setArea(AreaGeografica area) {
        this.area = area;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public List<T> getClassifica() {
        return classifica;
    }

    public void setClassifica(List<T> classifica) {
        this.classifica = classifica;
    }

    @Override
    public String toString() {
        return "Classifica [titolo=" + titolo + ", area=" + area + ", genere=" + genere + ", classifica=" + classifica
                + "]";
    }

    @SafeVarargs
    public final void aggiungi(T ... elemento){
        try {
            for (T e : elemento) {
                if (e.getGenere().equals(genere)) {
                    classifica.add(e);
                } else {
                    throw new GenereMismatchException("Il genere non corrisponde");
                }
            }
        } catch (GenereMismatchException e) {
            System.err.println(e.getMessage());
        }
    }


    
}
