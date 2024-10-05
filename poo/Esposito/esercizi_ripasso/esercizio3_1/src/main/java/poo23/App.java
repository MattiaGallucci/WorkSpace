package poo23;

public class App 
{
    public static void main( String[] args ) throws AgeLessThanException
    {
        Persona p1 = new Persona("Juan", "Perez", "1a", 25);
        Persona p2 = new Persona("Maria", "Garcia", "1b", 17);
        Persona p3 = new Persona("Jose", "Lopez", "1c", 3);

        p1.iniettaPrimaDose(p1, TipologiaVaccino.JANDJ, "1");
        p3.iniettaPrimaDose(p3, TipologiaVaccino.PFIZER, "1");
        System.out.println(p1);
        System.out.println(p3);
    }
}
