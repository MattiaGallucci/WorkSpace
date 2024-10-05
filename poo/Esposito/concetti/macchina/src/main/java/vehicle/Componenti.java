package vehicle;

class Ruota{
    private String s;
    Ruota() {
        System.out.println("Ruota()");
        s = new String("Ruota Inserita");
    }
    public String toString() { return s; }
 }
class Motore{
    private String s;
    Motore() {
        System.out.println("Motore()");
        s = new String("Motore Montato");
    }
    public String toString() { return s; }
}
class Carrozzeria{
    private String s;
    Carrozzeria() {
        System.out.println("Carrozzeria()");
        s = new String("Carrozzeria Inserita");
    }
    public String toString() { return s; }
}