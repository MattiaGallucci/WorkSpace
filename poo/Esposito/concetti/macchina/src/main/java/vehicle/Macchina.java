package vehicle;

public class Macchina{
    private Ruota ruota1, ruota2, ruota3, ruota4;
    Motore motore;
    Carrozzeria carrozzeria = new Carrozzeria ();
    String s = "Macchina Assemblata";
    
    Macchina() {
    System.out.println("Macchina()");
    motore = new Motore();
    }
    
    void print() {
        ruota1 = new Ruota();
        ruota2 = new Ruota();
        ruota3 = new Ruota();
        ruota4 = new Ruota();
        System.out.println("macchina = " + s);
        System.out.println("ruota1 = " + ruota1);
        System.out.println("ruota2 = " + ruota2);
        System.out.println("ruota3 = " + ruota3);
        System.out.println("ruota4 = " + ruota4);
        System.out.println("motore= " + motore);
        System.out.println("carrozzeria = " + carrozzeria);
    }
    public static void main(String[] args) {
        Macchina x = new Macchina();
        x.print();
    }
}