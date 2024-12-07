/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiori;

import static fiori.Fiore.TROVA_PER_CICLO;
import static fiori.Fiore.TROVA_PER_PROPRIETA;
import static fiori.Fiore.TROVA_PER_USO;
import static fiori.Fiore.TROVA_TUTTI;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTI, query = "SELECT f FROM Fiore f"),
    @NamedQuery(name = TROVA_PER_CICLO, query = "SELECT f FROM Fiore f WHERE f.cicloBiologico = :cicloBiologico"),
    @NamedQuery(name = TROVA_PER_USO, query = "SELECT f FROM Fiore f WHERE f.uso = :uso"),
    @NamedQuery(name = TROVA_PER_PROPRIETA, query = "SELECT f FROM Fiore f WHERE f.proprietaCurative = :proprieta"),
})
public class Fiore implements Serializable{
    public static final String TROVA_TUTTI = "Fiore.trovaTutti";
    public static final String TROVA_PER_CICLO = "Fiore.trovaPerCiclo";
    public static final String TROVA_PER_USO = "Fiore.trovaPerUso";
    public static final String TROVA_PER_PROPRIETA = "Fiore.trovaPerProprieta";
    @Id
    private int id;
    private String specie;
    private String famigliaBotanica;
    private String cicloBiologico;
    private String origine;
    private String proprietaCurative;
    private String colore;
    private String tipoDiPArassiti;
    private String uso;
    private int giacenza;

    public Fiore() {}

    public Fiore(int id, String specie, String famigliaBotanica, String cicloBiologico, String origine, String proprietaCurative, String colore, String tipoDiPArassiti, String uso, int giacenza) {
        this.id = id;
        this.specie = specie;
        this.famigliaBotanica = famigliaBotanica;
        this.cicloBiologico = cicloBiologico;
        this.origine = origine;
        this.proprietaCurative = proprietaCurative;
        this.colore = colore;
        this.tipoDiPArassiti = tipoDiPArassiti;
        this.uso = uso;
        this.giacenza = giacenza;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getFamigliaBotanica() {
        return famigliaBotanica;
    }

    public void setFamigliaBotanica(String famigliaBotanica) {
        this.famigliaBotanica = famigliaBotanica;
    }

    public String getCicloBiologico() {
        return cicloBiologico;
    }

    public void setCicloBiologico(String cicloBiologico) {
        this.cicloBiologico = cicloBiologico;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getProprietaCurative() {
        return proprietaCurative;
    }

    public void setProprietaCurative(String proprietaCurative) {
        this.proprietaCurative = proprietaCurative;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getTipoDiPArassiti() {
        return tipoDiPArassiti;
    }

    public void setTipoDiPArassiti(String tipoDiPArassiti) {
        this.tipoDiPArassiti = tipoDiPArassiti;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public int getGiacenza() {
        return giacenza;
    }

    public void setGiacenza(int giacenza) {
        this.giacenza = giacenza;
    }

    @Override
    public String toString() {
        return "Fiore{" + "id=" + id + ", specie=" + specie + ", famigliaBotanica=" + famigliaBotanica + ", cicloBiologico=" + cicloBiologico + ", origine=" + origine + ", proprietaCurative=" + proprietaCurative + ", colore=" + colore + ", tipoDiPArassiti=" + tipoDiPArassiti + ", uso=" + uso + ", giacenza=" + giacenza + '}';
    }
}
