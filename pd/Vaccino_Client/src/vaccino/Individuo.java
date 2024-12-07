/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccino;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import static vaccino.Individuo.TROVA_PER_CATEGORIA;
import static vaccino.Individuo.TROVA_PER_CATEGORIA_ETA;
import static vaccino.Individuo.TROVA_PER_CATEGORIA_INTERESSE;
import static vaccino.Individuo.TROVA_PER_COVID_CONTRATTO;
import static vaccino.Individuo.TROVA_PER_ETA;
import static vaccino.Individuo.TROVA_TUTTE;

@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTE, query = "SELECT i FROM Individuo i"),
    @NamedQuery(name = TROVA_PER_CATEGORIA, query = "SELECT i FROM Individuo i WHERE i.cateogria = :categoria"),
    @NamedQuery(name = TROVA_PER_ETA, query = "SELECT i FROM Individuo i WHERE i.cateogria = :categoria"),
    @NamedQuery(name = TROVA_PER_COVID_CONTRATTO, query = "SELECT i FROM Individuo i WHERE i.covidContratto = :covidContratto"),
    @NamedQuery(name = TROVA_PER_CATEGORIA_ETA, query = "SELECT i FROM Individuo i WHERE i.cateogria = :categoria AND i.eta = :eta"),
    @NamedQuery(name = TROVA_PER_CATEGORIA_INTERESSE, query = "SELECT i FROM Individuo i WHERE i.cateogria = :categoria AND i.interessatoVaccino = :interesse"),
})
public class Individuo {
    public static final String TROVA_TUTTE = "Individuo.trovaTutte";
    public static final String TROVA_PER_CATEGORIA = "Individuo.trovaPerCategoria";
    public static final String TROVA_PER_ETA = "Individuo.trovaPerEta";
    public static final String TROVA_PER_COVID_CONTRATTO = "Individuo.trovaPerCovidContratto";
    public static final String TROVA_PER_CATEGORIA_ETA = "Individuo.trovaPerCategoriaEta";
    public static final String TROVA_PER_CATEGORIA_INTERESSE = "Individuo.trovaPerCategoriaInteresse";
    
    @Id @GeneratedValue
    private int id;
    private String nome;
    private String cognome;
    private Categoria cateogria;
    private int eta;
    private Genere genere;
    private int malattiePregresse;
    private boolean covidContratto;
    private boolean interessatoVaccino;
    private Priorita priorita;

    public Individuo() {}

    public Individuo(String nome, String cognome, Categoria cateogria, int eta, Genere genere, int malattiePregresse, boolean covidContratto, boolean interessatoVaccino, Priorita priorita) {
        this.nome = nome;
        this.cognome = cognome;
        this.cateogria = cateogria;
        this.eta = eta;
        this.genere = genere;
        this.malattiePregresse = malattiePregresse;
        this.covidContratto = covidContratto;
        this.interessatoVaccino = interessatoVaccino;
        this.priorita = priorita;
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Categoria getCateogria() {
        return cateogria;
    }

    public void setCateogria(Categoria cateogria) {
        this.cateogria = cateogria;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public int getMalattiePregresse() {
        return malattiePregresse;
    }

    public void setMalattiePregresse(int malattiePregresse) {
        this.malattiePregresse = malattiePregresse;
    }

    public boolean isCovidContratto() {
        return covidContratto;
    }

    public void setCovidContratto(boolean covidContratto) {
        this.covidContratto = covidContratto;
    }

    public boolean isInteressatoVaccino() {
        return interessatoVaccino;
    }

    public void setInteressatoVaccino(boolean interessatoVaccino) {
        this.interessatoVaccino = interessatoVaccino;
    }

    public Priorita getPriorita() {
        return priorita;
    }

    public void setPriorita(Priorita priorita) {
        this.priorita = priorita;
    }

    @Override
    public String toString() {
        return "Individuo{" + "id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", cateogria=" + cateogria + ", eta=" + eta + ", genere=" + genere + ", malattiePregresse=" + malattiePregresse + ", covidContratto=" + covidContratto + ", interessatoVaccino=" + interessatoVaccino + ", priorita=" + priorita + '}';
    }
}
