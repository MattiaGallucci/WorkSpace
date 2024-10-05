package poo23;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tavolo {
    private TipologiaLuogo luogo;
    private int id;
    private int coperto;
    private List<Primo> primiConsumati;
    private List<Secondo> secondiConsumati;
    private List<Bevanda> bevandeConsumate;
    
    public Tavolo(TipologiaLuogo luogo, int id, int coperto) {
        this.luogo = luogo;
        this.id = id;
        this.coperto = coperto;
        primiConsumati = new ArrayList<>();
        secondiConsumati = new ArrayList<>();
        bevandeConsumate = new ArrayList<>();
    }

    public TipologiaLuogo getLuogo() {
        return luogo;
    }

    public void setLuogo(TipologiaLuogo luogo) {
        this.luogo = luogo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoperto() {
        return coperto;
    }

    public void setCoperto(int coperto) {
        this.coperto = coperto;
    }

    public List<Primo> getPrimiConsumati() {
        return primiConsumati;
    }

    public void setPrimiConsumati(List<Primo> primiConsumati) {
        this.primiConsumati = primiConsumati;
    }

    public List<Secondo> getSecondiConsumati() {
        return secondiConsumati;
    }

    public void setSecondiConsumati(List<Secondo> secondiConsumati) {
        this.secondiConsumati = secondiConsumati;
    }

    public List<Bevanda> getBevandeConsumate() {
        return bevandeConsumate;
    }

    public void setBevandeConsumate(List<Bevanda> bevandeConsumate) {
        this.bevandeConsumate = bevandeConsumate;
    }

    @Override
    public String toString() {
        return "Tavolo [luogo=" + luogo + ", id=" + id + ", coperto=" + coperto + ", primiConsumati=" + primiConsumati
                + ", secondiConsumati=" + secondiConsumati + ", bevandeConsumate=" + bevandeConsumate + "]";
    }

    public void aggiungiPrimo(Primo ... primo){
        for(Primo primt1 : primo){
            primiConsumati.add(primt1);
        }
    }
    public void aggiungiSecondo(Secondo ... secondo){
        for(Secondo secondt1 : secondo){
            secondiConsumati.add(secondt1);
        }
    }
    public void aggiungiBevanda(Bevanda ... bevanda){
        for(Bevanda bevanda1 : bevanda){
            bevandeConsumate.add(bevanda1);
        }
    }

    public double calcoloConto(){
        double contoTotale = 0;

        for (Primo primo : primiConsumati) {
            contoTotale += primo.getPrezzo();
        }

        for (Secondo secondo : secondiConsumati) {
            contoTotale += secondo.getPrezzo();
        }

        for (Bevanda bevanda : bevandeConsumate) {
            contoTotale += bevanda.getPrezzo();
        }

        contoTotale += coperto;

        return contoTotale + ( contoTotale * luogo.getPercentuale());
    }

    public class OrdinaPerContoComparator implements Comparator<Tavolo> {
        @Override
        public int compare(Tavolo t1, Tavolo t2) {
            double contoOggettt1 = t1.calcoloConto();
            double contoOggettt2 = t2.calcoloConto();

            // Ordine crescente, per l'ordine decrescente inverti l'ordine di confronto
            if (contoOggettt1 < contoOggettt2) {
                return -1;
            } else if (contoOggettt1 > contoOggettt2) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
