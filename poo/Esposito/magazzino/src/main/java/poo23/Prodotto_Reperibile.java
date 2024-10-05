package poo23;

import java.util.Scanner;

public class Prodotto_Reperibile<T> extends Prodotto{
    private String luogo_provenienza;

    public void setLuogo_provenienza(String luogo_provenienza) { this.luogo_provenienza = luogo_provenienza; }
    public String getLuogo_provenienza() { return luogo_provenienza; }

    public Prodotto_Reperibile(String nome, String produttore, double costo, String distributore, String luogo_provenienza){
        super(nome, produttore, costo, distributore);
        this.luogo_provenienza = luogo_provenienza;
    }

    public String toString(){
        return super.toString() + "\tLuogo di provenienza: " + this.luogo_provenienza;
    }

    public Prodotto_Reperibile<Prodotto> aggiungiProdotto(Prodotto_Reperibile<Prodotto> p){
        Scanner sc = new Scanner(System.in);
        
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
        
        System.out.print("Luogo di provenienza: ");
        p.setLuogo_provenienza(sc.nextLine());
        
        sc.close();
        return p;
    }


}
