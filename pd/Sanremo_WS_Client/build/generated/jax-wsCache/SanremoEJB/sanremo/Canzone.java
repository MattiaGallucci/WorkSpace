
package sanremo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per canzone complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="canzone"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cantato" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="categoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="incipit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="titolo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="voti" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "canzone", propOrder = {
    "cantato",
    "categoria",
    "id",
    "incipit",
    "titolo",
    "voti"
})
public class Canzone {

    protected boolean cantato;
    protected String categoria;
    protected int id;
    protected String incipit;
    protected String titolo;
    protected int voti;

    /**
     * Recupera il valore della proprietà cantato.
     * 
     */
    public boolean isCantato() {
        return cantato;
    }

    /**
     * Imposta il valore della proprietà cantato.
     * 
     */
    public void setCantato(boolean value) {
        this.cantato = value;
    }

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
     * Recupera il valore della proprietà incipit.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIncipit() {
        return incipit;
    }

    /**
     * Imposta il valore della proprietà incipit.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIncipit(String value) {
        this.incipit = value;
    }

    /**
     * Recupera il valore della proprietà titolo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Imposta il valore della proprietà titolo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitolo(String value) {
        this.titolo = value;
    }

    /**
     * Recupera il valore della proprietà voti.
     * 
     */
    public int getVoti() {
        return voti;
    }

    /**
     * Imposta il valore della proprietà voti.
     * 
     */
    public void setVoti(int value) {
        this.voti = value;
    }

}
