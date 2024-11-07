/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpa_esercizio1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "searchByTitolo", query = "SELECT b FROM Book b WHERE b.titolo = :titolo"),
    @NamedQuery(name = "searchByCategoria", query = "SELECT b FROM Book b WHERE b.categoria = :categoria"),
    @NamedQuery(name = "searchByIsbn", query = "SELECT b FROM Book b WHERE b.isbn = :isbn")
})
public class Book {
    private String titolo;
    private int prezzo;
    private String descrizione;
    @Id
    private int isbn;
    private String categoria;

    public Book() {
    }

    public Book(String titolo, int prezzo, String descrizione, int isbn, String categoria) {
        this.titolo = titolo;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.isbn = isbn;
        this.categoria = categoria;
    }
    
    

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Book{" + "titolo=" + titolo + ", prezzo=" + prezzo + ", descrizione=" + descrizione + ", isbn=" + isbn + ", categoria=" + categoria + '}';
    }
    
    
    
}
