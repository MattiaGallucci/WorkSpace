/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanremo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import static sanremo.Canzone.TROVA_PER_CATEGORIA;
import static sanremo.Canzone.TROVA_PER_ID;
import static sanremo.Canzone.TROVA_PER_VOTI;
import static sanremo.Canzone.TROVA_TUTTE;

@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTE, query = "SELECT c FROM Canzone c"),
    @NamedQuery(name = TROVA_PER_ID, query = "SELECT c FROM Canzone c WHERE c.id = :id"),
    @NamedQuery(name = TROVA_PER_CATEGORIA, query = "SELECT c FROM Canzone c WHERE c.categoria = :categoria"),
    @NamedQuery(name = TROVA_PER_VOTI, query = "SELECT c FROM Canzone c WHERE c.voti = :voti"),
})
public class Canzone implements Serializable{
    public static final String TROVA_TUTTE = "Canzone.trovaTutte";
    public static final String TROVA_PER_ID = "Canzone.trovaPerId";
    public static final String TROVA_PER_CATEGORIA = "Canzone.trovaPerCategoria";
    public static final String TROVA_PER_VOTI = "Canzone.trovaPerVoti";
    
    @Id @GeneratedValue
    private int id;
    private String titolo;
    private String categoria;
    private String incipit;
    private boolean cantato;
    private int voti;

    public Canzone() {}

    public Canzone(String titolo, String categoria, String incipit, boolean cantato, int voti) {
        this.titolo = titolo;
        this.categoria = categoria;
        this.incipit = incipit;
        this.cantato = cantato;
        this.voti = voti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIncipit() {
        return incipit;
    }

    public void setIncipit(String incipit) {
        this.incipit = incipit;
    }

    public boolean isCantato() {
        return cantato;
    }

    public void setCantato(boolean cantato) {
        this.cantato = cantato;
    }

    public int getVoti() {
        return voti;
    }

    public void setVoti(int voti) {
        this.voti = voti;
    }

    @Override
    public String toString() {
        return "Canzone{" + "id=" + id + ", titolo=" + titolo + ", categoria=" + categoria + ", incipit=" + incipit + ", cantato=" + cantato + ", voti=" + voti + '}';
    }
}
