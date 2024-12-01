
package uefa;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per tipologiaPartita.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * <pre>
 * &lt;simpleType name="tipologiaPartita"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="GIRONE1"/&gt;
 *     &lt;enumeration value="GIRONE2"/&gt;
 *     &lt;enumeration value="GIRONE3"/&gt;
 *     &lt;enumeration value="OTTAVI"/&gt;
 *     &lt;enumeration value="QUARTI"/&gt;
 *     &lt;enumeration value="SEMIFINALE"/&gt;
 *     &lt;enumeration value="FINALE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "tipologiaPartita")
@XmlEnum
public enum TipologiaPartita {

    @XmlEnumValue("GIRONE1")
    GIRONE_1("GIRONE1"),
    @XmlEnumValue("GIRONE2")
    GIRONE_2("GIRONE2"),
    @XmlEnumValue("GIRONE3")
    GIRONE_3("GIRONE3"),
    OTTAVI("OTTAVI"),
    QUARTI("QUARTI"),
    SEMIFINALE("SEMIFINALE"),
    FINALE("FINALE");
    private final String value;

    TipologiaPartita(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipologiaPartita fromValue(String v) {
        for (TipologiaPartita c: TipologiaPartita.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
