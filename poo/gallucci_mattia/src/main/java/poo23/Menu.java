package poo23;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Primo> primi;
    private List<Secondo> secondi;
    private List<Bevanda> bevande;

    public Menu(){
        primi = new ArrayList<>();
        secondi = new ArrayList<>();
        bevande = new ArrayList<>();
    }

    public void aggiungiPrimo(Primo ... primo){
        for (Primo primo1 : primo) {
            primi.add(primo1);
        }
    }
    public void aggiungiSecondi(Secondo ... secondo){
        for(Secondo secondo1 : secondo){
            secondi.add(secondo1);
        }
    }
    public void aggiungiBevande(Bevanda ... bevanda){
        for(Bevanda bevande1 : bevanda){
            bevande.add(bevande1);
        }
    }

    public List<Primo> getPrimi() {
        return primi;
    }

    public void setPrimi(List<Primo> primi) {
        this.primi = primi;
    }

    public List<Secondo> getSecondi() {
        return secondi;
    }

    public void setSecondi(List<Secondo> secondi) {
        this.secondi = secondi;
    }

    public List<Bevanda> getBevande() {
        return bevande;
    }

    public void setBevande(List<Bevanda> bevande) {
        this.bevande = bevande;
    }

    @Override
    public String toString() {
        return "Menu [primi=" + primi + ", secondi=" + secondi + ", bevande=" + bevande + "]";
    }
    
}