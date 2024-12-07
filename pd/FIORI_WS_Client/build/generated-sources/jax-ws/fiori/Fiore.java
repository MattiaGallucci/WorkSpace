
package fiori;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per fiore complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="fiore"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cicloBiologico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="colore" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="famigliaBotanica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="giacenza" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="origine" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="proprietaCurative" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="specie" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoDiPArassiti" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="uso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fiore", propOrder = {
    "cicloBiologico",
    "colore",
    "famigliaBotanica",
    "giacenza",
    "id",
    "origine",
    "proprietaCurative",
    "specie",
    "tipoDiPArassiti",
    "uso"
})
public class Fiore {

    protected String cicloBiologico;
    protected String colore;
    protected String famigliaBotanica;
    protected int giacenza;
    protected int id;
    protected String origine;
    protected String proprietaCurative;
    protected String specie;
    protected String tipoDiPArassiti;
    protected String uso;

    /**
     * Recupera il valore della proprietà cicloBiologico.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCicloBiologico() {
        return cicloBiologico;
    }

    /**
     * Imposta il valore della proprietà cicloBiologico.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCicloBiologico(String value) {
        this.cicloBiologico = value;
    }

    /**
     * Recupera il valore della proprietà colore.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColore() {
        return colore;
    }

    /**
     * Imposta il valore della proprietà colore.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColore(String value) {
        this.colore = value;
    }

    /**
     * Recupera il valore della proprietà famigliaBotanica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamigliaBotanica() {
        return famigliaBotanica;
    }

    /**
     * Imposta il valore della proprietà famigliaBotanica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamigliaBotanica(String value) {
        this.famigliaBotanica = value;
    }

    /**
     * Recupera il valore della proprietà giacenza.
     * 
     */
    public int getGiacenza() {
        return giacenza;
    }

    /**
     * Imposta il valore della proprietà giacenza.
     * 
     */
    public void setGiacenza(int value) {
        this.giacenza = value;
    }

    /**
     * Recupera il valore della proprietà id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Imposta il valore della proprietà id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Recupera il valore della proprietà origine.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigine() {
        return origine;
    }

    /**
     * Imposta il valore della proprietà origine.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigine(String value) {
        this.origine = value;
    }

    /**
     * Recupera il valore della proprietà proprietaCurative.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProprietaCurative() {
        return proprietaCurative;
    }

    /**
     * Imposta il valore della proprietà proprietaCurative.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProprietaCurative(String value) {
        this.proprietaCurative = value;
    }

    /**
     * Recupera il valore della proprietà specie.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecie() {
        return specie;
    }

    /**
     * Imposta il valore della proprietà specie.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecie(String value) {
        this.specie = value;
    }

    /**
     * Recupera il valore della proprietà tipoDiPArassiti.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDiPArassiti() {
        return tipoDiPArassiti;
    }

    /**
     * Imposta il valore della proprietà tipoDiPArassiti.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDiPArassiti(String value) {
        this.tipoDiPArassiti = value;
    }

    /**
     * Recupera il valore della proprietà uso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUso() {
        return uso;
    }

    /**
     * Imposta il valore della proprietà uso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUso(String value) {
        this.uso = value;
    }

}
