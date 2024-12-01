/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canile;

import static canile.Cane.TROVA_PER_ID;
import static canile.Cane.TROVA_PER_NOME;
import static canile.Cane.TROVA_PER_RAZZA;
import static canile.Cane.TROVA_PER_STATUS_ADOZIONE;
import static canile.Cane.TROVA_PER_TAGLIA;
import static canile.Cane.TROVA_PICCOLI_8_ANNI;
import static canile.Cane.TROVA_TUTTI;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT c FROM Cane c"),
    @NamedQuery(name = TROVA_PER_ID, query = "SELECT c FROM Cane c WHERE c.id = :id"),
    @NamedQuery(name = TROVA_PER_RAZZA, query = "SELECT c FROM Cane c WHERE c.razza = :razza"),
    @NamedQuery(name = TROVA_PER_NOME, query = "SELECT c FROM Cane c WHERE c.nome = :nome"),
    @NamedQuery(name = TROVA_PER_TAGLIA, query = "SELECT c FROM Cane c WHERE c.taglia = :taglia"),
    @NamedQuery(name = TROVA_PER_STATUS_ADOZIONE, query = "SELECT c FROM Cane c WHERE c.adottato = :adottato"),
    @NamedQuery(name = TROVA_PICCOLI_8_ANNI, query = "SELECT c FROM Cane c WHERE c.taglia = :taglia AND c.fasciaEta = :fasciaEta")
})
@XmlRootElement
public class Cane implements Serializable{
    public  static final String TROVA_TUTTI = "Cane.trovaTutti";
    public  static final String TROVA_PER_ID = "Cane.trovaPerId";
    public  static final String TROVA_PER_RAZZA = "Cane.trovaPerRazza";
    public  static final String TROVA_PER_NOME = "Cane.trovaPerNome";
    public  static final String TROVA_PER_TAGLIA = "Cane.trovaPerTaglia";
    public  static final String TROVA_PER_STATUS_ADOZIONE = "Cane.trovaPerStatusAdozione";
    public  static final String TROVA_PICCOLI_8_ANNI = "Cane.trovaPiccoli8Anni";
    
    @Id @GeneratedValue
    private int id;
    private String razza;
    private String nome;
    private Taglia taglia;
    private Sesso sesso;
    private FasciaEta fasciaEta;
    private int microchip;
    private boolean adottato;

    public Cane() {}

    public Cane(int id, String razza, String nome, Taglia taglia, Sesso sesso, FasciaEta fasciaEta, int microchip, boolean adottato) {
        this.id = id;
        this.razza = razza;
        this.nome = nome;
        this.taglia = taglia;
        this.sesso = sesso;
        this.fasciaEta = fasciaEta;
        this.microchip = microchip;
        this.adottato = adottato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Taglia getTaglia() {
        return taglia;
    }

    public void setTaglia(Taglia taglia) {
        this.taglia = taglia;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public FasciaEta getFasciaEta() {
        return fasciaEta;
    }

    public void setFasciaEta(FasciaEta fasciaEta) {
        this.fasciaEta = fasciaEta;
    }

    public int getMicrochip() {
        return microchip;
    }

    public void setMicrochip(int microchip) {
        this.microchip = microchip;
    }

    public boolean isAdottato() {
        return adottato;
    }

    public void setAdottato(boolean adottato) {
        this.adottato = adottato;
    }

    @Override
    public String toString() {
        return "Cane{" + "id=" + id + ", razza=" + razza + ", nome=" + nome + ", taglia=" + taglia + ", sesso=" + sesso + ", fasciaEta=" + fasciaEta + ", microchip=" + microchip + ", adottato=" + adottato + '}';
    }
}
