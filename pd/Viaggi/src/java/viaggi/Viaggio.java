/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viaggi;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import static viaggi.Viaggio.TROVA_PER_CATEGORIA;
import static viaggi.Viaggio.TROVA_PER_DESTINAZIONE;
import static viaggi.Viaggio.TROVA_PER_ID;
import static viaggi.Viaggio.TROVA_PER_PREZZO;
import static viaggi.Viaggio.TROVA_TUTTI;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTI, query ="SELECT v FROM Viaggio v"),
    @NamedQuery(name = TROVA_PER_ID, query ="SELECT v FROM Viaggio v WHERE v.id = :id"),
    @NamedQuery(name = TROVA_PER_DESTINAZIONE, query ="SELECT v FROM Viaggio v WHERE v.destinazione = :destinazione"),
    @NamedQuery(name = TROVA_PER_CATEGORIA, query ="SELECT v FROM Viaggio v WHERE v.categoria = :categoria"),
    @NamedQuery(name = TROVA_PER_PREZZO, query ="SELECT v FROM Viaggio v WHERE v.prezzo < :prezzo"),
})
@XmlRootElement
public class Viaggio implements Serializable{
    public static final String TROVA_TUTTI = "Viaggio.trovaTutti";
    public static final String TROVA_PER_ID = "Viaggio.trovaPerId";
    public static final String TROVA_PER_DESTINAZIONE = "Viaggio.trovaPerDestinazione";
    public static final String TROVA_PER_CATEGORIA = "Viaggio.trovaPerCategoria";
    public static final String TROVA_PER_PREZZO = "Viaggio.trovaPerPrezzo";
    
    @Id
    private int id;
    private String categoria;
    private String destinazione;
    private int prezzo;
    private int sconto;
    private int disponibilita;

    public Viaggio() {}

    public Viaggio(int id, String categoria, String destinazione, int prezzo, int sconto, int disponibilita) {
        this.id = id;
        this.categoria = categoria;
        this.destinazione = destinazione;
        this.prezzo = prezzo;
        this.sconto = sconto;
        this.disponibilita = disponibilita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public int getSconto() {
        return sconto;
    }

    public void setSconto(int sconto) {
        this.sconto = sconto;
    }

    public int getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(int disponibilita) {
        this.disponibilita = disponibilita;
    }

    @Override
    public String toString() {
        return "Viaggio{" + "id=" + id + ", categoria=" + categoria + ", destinazione=" + destinazione + ", prezzo=" + prezzo + ", sconto=" + sconto + ", disponibilita=" + disponibilita + '}';
    }
    
}
