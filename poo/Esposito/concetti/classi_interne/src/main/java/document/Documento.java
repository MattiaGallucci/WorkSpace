package document;

public class Documento {
    private String title = "Titolo";
    
    private class Destination{
        private String label;
        
        Destination(String whereTo) {label = whereTo;}
        
        String readLabel() {return label;}
        String returnTitolo() {return Documento.this.title;}
    }
   
    public void ship(String dest) {
        Destination d = new Destination(dest);
    
        System.out.println(d.readLabel());
    }
    public static void main(String[] args) {
        Documento doc = new Documento();
        Documento.Destination dec = doc.new Destination("Tanzania");
        String str = dec.readLabel(), str2 = dec.returnTitolo();

        System.out.println(str2 +" " +str);
    }
}