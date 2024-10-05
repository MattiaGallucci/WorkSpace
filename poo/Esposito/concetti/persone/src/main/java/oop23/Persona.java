package oop23;

public class Persona {
    private String nome;
    
    Persona (String n) {
        nome=new String(n);
    }

    public String getNome() {
        return new String(nome);
    }
}