package poo23.reflection_interattiva;

public class Persona {
    private String nome;
    
    Persona (String n) {
        nome=new String(n);
    }

    public String getNome() {
        return new String(nome);
    }
}