/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpcm;

import static dpcm.Dpcm.TROVA_PER_EMERGENZA;
import static dpcm.Dpcm.TROVA_PER_ID;
import static dpcm.Dpcm.TROVA_PER_STAMPA;
import static dpcm.Dpcm.TROVA_PER_TIPO;
import static dpcm.Dpcm.TROVA_TUTTI;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT d FROM Dpcm d"),
    @NamedQuery(name = TROVA_PER_ID, query = "SELECT d FROM Dpcm d WHERE d.id = :id"),
    @NamedQuery(name = TROVA_PER_EMERGENZA, query = "SELECT d FROM Dpcm d WHERE d.emergenza = :emergenza"),
    @NamedQuery(name = TROVA_PER_TIPO, query = "SELECT d FROM Dpcm d WHERE d.tipo = :tipo"),
    @NamedQuery(name = TROVA_PER_STAMPA, query = "SELECT d FROM Dpcm d WHERE d.stampa = :stampa"),

})
public class Dpcm implements Serializable{
    public static final String TROVA_TUTTI = "Dpcm.trovaTutti";
    public static final String TROVA_PER_ID = "Dpcm.trovaPerId";
    public static final String TROVA_PER_EMERGENZA = "Dpcm.trovaPerEmergenza";
    public static final String TROVA_PER_TIPO = "Dpcm.trovaPerTipo";
    public static final String TROVA_PER_STAMPA = "Dpcm.trovaPerStampa";

    @Id
    private int id;
    private String nome;
    private String emergenza;
    private String tipo;
    private String livello;
    private int stampa;

    public Dpcm(){}

    public Dpcm(int id, String nome, String emergenza, String tipo, String livello, int stampa) {
        this.id = id;
        this.nome = nome;
        this.emergenza = emergenza;
        this.tipo = tipo;
        this.livello = livello;
        this.stampa = stampa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmergenza() {
        return emergenza;
    }

    public void setEmergenza(String emergenza) {
        this.emergenza = emergenza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLivello() {
        return livello;
    }

    public void setLivello(String livello) {
        this.livello = livello;
    }

    public int getStampa() {
        return stampa;
    }

    public void setStampa(int stampa) {
        this.stampa = stampa;
    }

    @Override
    public String toString() {
        return "Dpcm{" + "id=" + id + ", nome=" + nome + ", emergenza=" + emergenza + ", tipo=" + tipo + ", livello=" + livello + ", stampa=" + stampa + '}';
    }
}
