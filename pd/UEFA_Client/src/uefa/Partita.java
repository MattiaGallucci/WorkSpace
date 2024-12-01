/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uefa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import static uefa.Partita.TROVA_ESPULSIONI_0;
import static uefa.Partita.TROVA_GOAL_MAGGIORI_2;
import static uefa.Partita.TROVA_PARTITE;
import static uefa.Partita.TROVA_PER_NUMERO_AMMONIZIONI;
import static uefa.Partita.TROVA_PER_NUMERO_ESPULSIONI;
import static uefa.Partita.TROVA_PER_TIPOLOGIA_PARTITA;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_PARTITE, query = "SELECT p FROM Partita p"),
    @NamedQuery(name = TROVA_PER_TIPOLOGIA_PARTITA, query = "SELECT p FROM Partita p WHERE p.tipologiaPartita = :tipologiaPartita"),
    @NamedQuery(name = TROVA_PER_NUMERO_AMMONIZIONI, query = "SELECT p FROM Partita p WHERE p.numeroAmmonizioni = :numeroAmmonizioni"),
    @NamedQuery(name = TROVA_PER_NUMERO_ESPULSIONI, query = "SELECT p FROM Partita p WHERE p.numeroEspulsioni = :numeroEspulsioni"),
    @NamedQuery(name = TROVA_GOAL_MAGGIORI_2, query = "SELECT p FROM Partita p WHERE (p.goalSquadraCasa + p.goalSquadraOspite) > 2"),
    @NamedQuery(name = TROVA_ESPULSIONI_0, query = "SELECT p FROM Partita p WHERE p.numeroEspulsioni = 0"),
})
@XmlRootElement
public class Partita implements Serializable{
    public static final String TROVA_PARTITE = "Partita.trovaPartite";
    public static final String TROVA_PER_TIPOLOGIA_PARTITA = "Partita.trovaPerTipologiaPartita";
    public static final String TROVA_PER_NUMERO_AMMONIZIONI = "Partita.trovaPerNumeroAmmonizioni";
    public static final String TROVA_PER_NUMERO_ESPULSIONI = "Partita.trovaPerNumeroEspulsioni";
    public static final String TROVA_GOAL_MAGGIORI_2 = "Partita.trovaGoalMaggiori2";
    public static final String TROVA_ESPULSIONI_0 = "Partita.trovaEspulsioni0";
    
    @Id @GeneratedValue
    private int id;
    private TipologiaPartita tipologiaPartita;
    private String squadraCasa;
    private String squadraOspite;
    private int goalSquadraCasa;
    private int goalSquadraOspite;
    private int numeroAmmonizioni;
    private int numeroEspulsioni;
    private boolean giocata;

    public Partita() {
    }

    public Partita(int id, TipologiaPartita tipologiaPartita, String squadraCasa, String squadraOspite, int goalSquadraCasa, int goalSquadraOspite, int numeroAmmonizioni, int numeroEspulsioni, boolean giocata) {
        this.id = id;
        this.tipologiaPartita = tipologiaPartita;
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.goalSquadraCasa = goalSquadraCasa;
        this.goalSquadraOspite = goalSquadraOspite;
        this.numeroAmmonizioni = numeroAmmonizioni;
        this.numeroEspulsioni = numeroEspulsioni;
        this.giocata = giocata;
    }
    
    

    public Partita(TipologiaPartita tipologiaPartita, String squadraCasa, String squadraOspite, int goalSquadraCasa, int goalSquadraOspite, int numeroAmmonizioni, int numeroEspulsioni, boolean giocata) {
        this.tipologiaPartita = tipologiaPartita;
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.goalSquadraCasa = goalSquadraCasa;
        this.goalSquadraOspite = goalSquadraOspite;
        this.numeroAmmonizioni = numeroAmmonizioni;
        this.numeroEspulsioni = numeroEspulsioni;
        this.giocata = giocata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipologiaPartita getTipologiaPartita() {
        return tipologiaPartita;
    }

    public void setTipologiaPartita(TipologiaPartita tipologiaPartita) {
        this.tipologiaPartita = tipologiaPartita;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public int getGoalSquadraCasa() {
        return goalSquadraCasa;
    }

    public void setGoalSquadraCasa(int goalSquadraCasa) {
        this.goalSquadraCasa = goalSquadraCasa;
    }

    public int getGoalSquadraOspite() {
        return goalSquadraOspite;
    }

    public void setGoalSquadraOspite(int goalSquadraOspite) {
        this.goalSquadraOspite = goalSquadraOspite;
    }

    public int getNumeroAmmonizioni() {
        return numeroAmmonizioni;
    }

    public void setNumeroAmmonizioni(int numeroAmmonizioni) {
        this.numeroAmmonizioni = numeroAmmonizioni;
    }

    public int getNumeroEspulsioni() {
        return numeroEspulsioni;
    }

    public void setNumeroEspulsioni(int numeroEspulsioni) {
        this.numeroEspulsioni = numeroEspulsioni;
    }

    public boolean isGiocata() {
        return giocata;
    }

    public void setGiocata(boolean giocata) {
        this.giocata = giocata;
    }

    @Override
    public String toString() {
        return "Partita{" + "id=" + id + ", tipologiaPartita=" + tipologiaPartita + ", squadraCasa=" + squadraCasa + ", squadraOspite=" + squadraOspite + ", goalSquadraCasa=" + goalSquadraCasa + ", goalSquadraOspite=" + goalSquadraOspite + ", numeroAmmonizioni=" + numeroAmmonizioni + ", numeroEspulsioni=" + numeroEspulsioni + ", giocata=" + giocata + '}';
    }
}
