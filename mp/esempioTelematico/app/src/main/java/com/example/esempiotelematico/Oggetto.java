package com.example.esempiotelematico;

import android.graphics.drawable.Drawable;

public class Oggetto {
    private String nome;
    private int quantita;
    private Drawable immagine;

    public Oggetto(String nome, int quantita, Drawable immagine) {
        this.nome = nome;
        this.quantita = quantita;
        this.immagine = immagine;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public Drawable getImmagine() {
        return immagine;
    }

    public void setImmagine(Drawable immagine) {
        this.immagine = immagine;
    }
}
