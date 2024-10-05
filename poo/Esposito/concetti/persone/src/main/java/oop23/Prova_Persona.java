package oop23;

public class Prova_Persona {
    public static void main(String argv[]) {
        Persona asergio;
        Persona lrom;
        
        asergio=new Persona("Antonio Sergio");
        lrom= new Persona ("Luigi Romano");
        
        System.out.println(asergio.getNome());
        System.out.println(lrom.getNome());
    }
}