
package uefa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per partita complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="partita"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="giocata" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="goalSquadraCasa" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="goalSquadraOspite" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numeroAmmonizioni" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="numeroEspulsioni" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="squadraCasa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="squadraOspite" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipologiaPartita" type="{http://uefa/}tipologiaPartita" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "partita", propOrder = {
    "giocata",
    "goalSquadraCasa",
    "goalSquadraOspite",
    "id",
    "numeroAmmonizioni",
    "numeroEspulsioni",
    "squadraCasa",
    "squadraOspite",
    "tipologiaPartita"
})
public class Partita {

    protected boolean giocata;
    protected int goalSquadraCasa;
    protected int goalSquadraOspite;
    protected int id;
    protected int numeroAmmonizioni;
    protected int numeroEspulsioni;
    protected String squadraCasa;
    protected String squadraOspite;
    @XmlSchemaType(name = "string")
    protected TipologiaPartita tipologiaPartita;

    /**
     * Recupera il valore della proprietà giocata.
     * 
     */
    public boolean isGiocata() {
        return giocata;
    }

    /**
     * Imposta il valore della proprietà giocata.
     * 
     */
    public void setGiocata(boolean value) {
        this.giocata = value;
    }

    /**
     * Recupera il valore della proprietà goalSquadraCasa.
     * 
     */
    public int getGoalSquadraCasa() {
        return goalSquadraCasa;
    }

    /**
     * Imposta il valore della proprietà goalSquadraCasa.
     * 
     */
    public void setGoalSquadraCasa(int value) {
        this.goalSquadraCasa = value;
    }

    /**
     * Recupera il valore della proprietà goalSquadraOspite.
     * 
     */
    public int getGoalSquadraOspite() {
        return goalSquadraOspite;
    }

    /**
     * Imposta il valore della proprietà goalSquadraOspite.
     * 
     */
    public void setGoalSquadraOspite(int value) {
        this.goalSquadraOspite = value;
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
     * Recupera il valore della proprietà numeroAmmonizioni.
     * 
     */
    public int getNumeroAmmonizioni() {
        return numeroAmmonizioni;
    }

    /**
     * Imposta il valore della proprietà numeroAmmonizioni.
     * 
     */
    public void setNumeroAmmonizioni(int value) {
        this.numeroAmmonizioni = value;
    }

    /**
     * Recupera il valore della proprietà numeroEspulsioni.
     * 
     */
    public int getNumeroEspulsioni() {
        return numeroEspulsioni;
    }

    /**
     * Imposta il valore della proprietà numeroEspulsioni.
     * 
     */
    public void setNumeroEspulsioni(int value) {
        this.numeroEspulsioni = value;
    }

    /**
     * Recupera il valore della proprietà squadraCasa.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSquadraCasa() {
        return squadraCasa;
    }

    /**
     * Imposta il valore della proprietà squadraCasa.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSquadraCasa(String value) {
        this.squadraCasa = value;
    }

    /**
     * Recupera il valore della proprietà squadraOspite.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSquadraOspite() {
        return squadraOspite;
    }

    /**
     * Imposta il valore della proprietà squadraOspite.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSquadraOspite(String value) {
        this.squadraOspite = value;
    }

    /**
     * Recupera il valore della proprietà tipologiaPartita.
     * 
     * @return
     *     possible object is
     *     {@link TipologiaPartita }
     *     
     */
    public TipologiaPartita getTipologiaPartita() {
        return tipologiaPartita;
    }

    /**
     * Imposta il valore della proprietà tipologiaPartita.
     * 
     * @param value
     *     allowed object is
     *     {@link TipologiaPartita }
     *     
     */
    public void setTipologiaPartita(TipologiaPartita value) {
        this.tipologiaPartita = value;
    }

}
