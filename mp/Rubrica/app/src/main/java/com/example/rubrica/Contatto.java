package com.example.rubrica;

import android.graphics.drawable.Drawable;

public class Contatto {
    private String nome;
    private String numero;
    private Drawable foto;

    public Contatto(String nome, String numero, Drawable foto) {
        this.nome = nome;
        this.numero = numero;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public Drawable getFoto() {
        return foto;
    }
}
