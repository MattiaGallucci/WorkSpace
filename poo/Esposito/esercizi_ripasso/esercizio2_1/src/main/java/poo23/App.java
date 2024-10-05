package poo23;

public class App 
{
    public static void main( String[] args )
    {
        Garage garage = new Garage();

        TipologiaVeicolo auto = TipologiaVeicolo.AUTO;
        TipologiaVeicolo moto = TipologiaVeicolo.MOTO;
        TipologiaVeicolo camion = TipologiaVeicolo.CAMION;

        Proprietario p1 = new Proprietario("p1", 111);
        Proprietario p2 = new Proprietario("p2", 222);
        Proprietario p3 = new Proprietario("p3", 333);
        
        Veicolo auto1 = new Veicolo(auto, "111", p1);
        Veicolo moto1 = new Veicolo(moto, "222", p2);
        Veicolo camion1 = new Veicolo(camion, "333", p3);

        garage.aggiungiVeicolo(auto1, "10:00");
        garage.aggiungiVeicolo(moto1, "11:45");
        garage.aggiungiVeicolo(camion1, "15:00");

        System.out.println("Veicoli in garage: " + garage);
        System.out.println();

        String oreP1 = garage.rimuoviVeicolo(auto1, "12:00");
        System.out.println("Ore per " + p1 + ": " + oreP1);
        String oreP2 = garage.rimuoviVeicolo(moto1, "13:00");
        System.out.println("Ore per " + p2 + ": " + oreP2);
        System.out.println("Veicoli in garage: " + garage);
        String oreP3 = garage.rimuoviVeicolo(camion1, "15:30");
        System.out.println("Ore per " + p3 + ": " + oreP3);
        System.out.println();

        System.out.println("Veicoli in garage: " + garage);
        System.out.println();
    }
}
