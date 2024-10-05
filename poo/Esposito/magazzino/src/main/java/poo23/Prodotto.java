package poo23;

import java.util.Scanner;

public class Prodotto {
    private String nome;
    private String produttore;
    private double costo;
    private String distributore;
    
    public void setNome(String nome) { this.nome = nome; }
    public String getNome() { return nome; }
    public void setProduttore(String produttore) { this.produttore = produttore; }
    public String getProduttore() { return produttore; }
    public void setCosto(double costo) { this.costo = costo; }
    public double getCosto() { return costo; }
    public void setDistributore(String distributore) { this.distributore = distributore; }
    public String getDistributore() { return distributore; }
    
    public Prodotto(String nome, String produttore, double costo, String distributore) {
        this.nome = nome;
        this.produttore = produttore;
        this.costo = costo;
        this.distributore = distributore;
    }

    public String toString() {
        return "Nome: " + nome + "\tProduttore: " + produttore + "\tCosto: " + costo + "\tDistributore: " + distributore;
    }

    public Prodotto aggiungiProdotto(Prodotto p) {
        Scanner sc = new Scanner(System.in);
        //Prodotto p = new Prodotto("", "", 0, "");
        System.out.print("Nome: ");
        p.setNome(sc.nextLine());
        
        System.out.print("Produttore: ");
        p.setProduttore(sc.nextLine());
        
        System.out.print("Costo: ");
        String costoStr = sc.nextLine();
        try {
            double costo = Double.parseDouble(costoStr);
            p.setCosto(costo);
        }
        catch (NumberFormatException e){ System.out.println("Input non valido per il costo. Assicurati di inserire un valore numerico.");}
        
        System.out.print("Distributore: ");
        p.setDistributore(sc.nextLine());
        
        sc.close();
        return p;
    }

    public Prodotto rimuoviProdotto(Prodotto p){
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci il nome del prodotto da rimuovere: ");
        p.setNome(sc.nextLine());
        sc.close();
        return p;
    }

}