package poo23;

import java.util.HashMap;

public class Garage {
    private HashMap<Veicolo, String> garageArrivo;
    private HashMap<Veicolo, String> garageUscita;
    
    public Garage() {
        garageArrivo = new HashMap<>();
        garageUscita = new HashMap<>();
    }

    public void aggiungiVeicolo(Veicolo veicolo, String oraArrivo) {
        garageArrivo.put(veicolo, oraArrivo);
    }

    public String rimuoviVeicolo(Veicolo veicolo, String uscita) {
        String arrivo = garageArrivo.get(veicolo);
        int oraArrivo = Integer.parseInt(arrivo.substring(0, 2));
        int minutiArrivo = Integer.parseInt(arrivo.substring(3));
        if(minutiArrivo == 0)
            minutiArrivo = 60;
        int oraUscita = Integer.parseInt(uscita.substring(0, 2));
        int minutiUscita = Integer.parseInt(uscita.substring(3));
        if(minutiUscita == 0)
            minutiUscita = 60;

        int oreDifferenza = (oraUscita - oraArrivo);
        int minutiDIfferenza = Math.abs(minutiArrivo - minutiUscita);
        if (minutiDIfferenza == 60)
            minutiDIfferenza = 0;
        
        garageArrivo.remove(veicolo);
        garageUscita.put(veicolo, uscita);

        return String.format("%02d:%02d", oreDifferenza, minutiDIfferenza);

    }

    @Override
    public String toString() {
        return "Garage [garageArrivo=" + garageArrivo + ", garageUscita=" + garageUscita + "]";
    }


    

}
