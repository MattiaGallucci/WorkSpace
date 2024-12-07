
package viaggi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per viaggio complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="viaggio"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="categoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="destinazione" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="disponibilita" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="prezzo" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="sconto" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "viaggio", propOrder = {
    "categoria",
    "destinazione",
    "disponibilita",
    "id",
    "prezzo",
    "sconto"
})
public class Viaggio {

    protected String categoria;
    protected String destinazione;
    protected int disponibilita;
    protected int id;
    protected int prezzo;
    protected int sconto;

    /**
     * Recupera il valore della proprietà categoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Imposta il valore della proprietà categoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoria(String value) {
        this.categoria = value;
    }

    /**
     * Recupera il valore della proprietà destinazione.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinazione() {
        return destinazione;
    }

    /**
     * Imposta il valore della proprietà destinazione.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinazione(String value) {
        this.destinazione = value;
    }

    /**
     * Recupera il valore della proprietà disponibilita.
     * 
     */
    public int getDisponibilita() {
        return disponibilita;
    }

    /**
     * Imposta il valore della proprietà disponibilita.
     * 
     */
    public void setDisponibilita(int value) {
        this.disponibilita = value;
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
     * Recupera il valore della proprietà prezzo.
     * 
     */
    public int getPrezzo() {
        return prezzo;
    }

    /**
     * Imposta il valore della proprietà prezzo.
     * 
     */
    public void setPrezzo(int value) {
        this.prezzo = value;
    }

    /**
     * Recupera il valore della proprietà sconto.
     * 
     */
    public int getSconto() {
        return sconto;
    }

    /**
     * Imposta il valore della proprietà sconto.
     * 
     */
    public void setSconto(int value) {
        this.sconto = value;
    }

}
