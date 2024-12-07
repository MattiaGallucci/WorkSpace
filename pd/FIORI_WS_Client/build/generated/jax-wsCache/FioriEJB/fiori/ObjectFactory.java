
package fiori;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fiori package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Aggiorna_QNAME = new QName("http://fiori/", "aggiorna");
    private final static QName _AggiornaResponse_QNAME = new QName("http://fiori/", "aggiornaResponse");
    private final static QName _Crea_QNAME = new QName("http://fiori/", "crea");
    private final static QName _CreaResponse_QNAME = new QName("http://fiori/", "creaResponse");
    private final static QName _Elimina_QNAME = new QName("http://fiori/", "elimina");
    private final static QName _EliminaResponse_QNAME = new QName("http://fiori/", "eliminaResponse");
    private final static QName _Fiore_QNAME = new QName("http://fiori/", "fiore");
    private final static QName _TrovaPerCiclo_QNAME = new QName("http://fiori/", "trovaPerCiclo");
    private final static QName _TrovaPerCicloResponse_QNAME = new QName("http://fiori/", "trovaPerCicloResponse");
    private final static QName _TrovaPerId_QNAME = new QName("http://fiori/", "trovaPerId");
    private final static QName _TrovaPerIdResponse_QNAME = new QName("http://fiori/", "trovaPerIdResponse");
    private final static QName _TrovaPerProprieta_QNAME = new QName("http://fiori/", "trovaPerProprieta");
    private final static QName _TrovaPerProprietaResponse_QNAME = new QName("http://fiori/", "trovaPerProprietaResponse");
    private final static QName _TrovaPerUso_QNAME = new QName("http://fiori/", "trovaPerUso");
    private final static QName _TrovaPerUsoResponse_QNAME = new QName("http://fiori/", "trovaPerUsoResponse");
    private final static QName _TrovaTutti_QNAME = new QName("http://fiori/", "trovaTutti");
    private final static QName _TrovaTuttiResponse_QNAME = new QName("http://fiori/", "trovaTuttiResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fiori
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Aggiorna }
     * 
     */
    public Aggiorna createAggiorna() {
        return new Aggiorna();
    }

    /**
     * Create an instance of {@link AggiornaResponse }
     * 
     */
    public AggiornaResponse createAggiornaResponse() {
        return new AggiornaResponse();
    }

    /**
     * Create an instance of {@link Crea }
     * 
     */
    public Crea createCrea() {
        return new Crea();
    }

    /**
     * Create an instance of {@link CreaResponse }
     * 
     */
    public CreaResponse createCreaResponse() {
        return new CreaResponse();
    }

    /**
     * Create an instance of {@link Elimina }
     * 
     */
    public Elimina createElimina() {
        return new Elimina();
    }

    /**
     * Create an instance of {@link EliminaResponse }
     * 
     */
    public EliminaResponse createEliminaResponse() {
        return new EliminaResponse();
    }

    /**
     * Create an instance of {@link Fiore }
     * 
     */
    public Fiore createFiore() {
        return new Fiore();
    }

    /**
     * Create an instance of {@link TrovaPerCiclo }
     * 
     */
    public TrovaPerCiclo createTrovaPerCiclo() {
        return new TrovaPerCiclo();
    }

    /**
     * Create an instance of {@link TrovaPerCicloResponse }
     * 
     */
    public TrovaPerCicloResponse createTrovaPerCicloResponse() {
        return new TrovaPerCicloResponse();
    }

    /**
     * Create an instance of {@link TrovaPerId }
     * 
     */
    public TrovaPerId createTrovaPerId() {
        return new TrovaPerId();
    }

    /**
     * Create an instance of {@link TrovaPerIdResponse }
     * 
     */
    public TrovaPerIdResponse createTrovaPerIdResponse() {
        return new TrovaPerIdResponse();
    }

    /**
     * Create an instance of {@link TrovaPerProprieta }
     * 
     */
    public TrovaPerProprieta createTrovaPerProprieta() {
        return new TrovaPerProprieta();
    }

    /**
     * Create an instance of {@link TrovaPerProprietaResponse }
     * 
     */
    public TrovaPerProprietaResponse createTrovaPerProprietaResponse() {
        return new TrovaPerProprietaResponse();
    }

    /**
     * Create an instance of {@link TrovaPerUso }
     * 
     */
    public TrovaPerUso createTrovaPerUso() {
        return new TrovaPerUso();
    }

    /**
     * Create an instance of {@link TrovaPerUsoResponse }
     * 
     */
    public TrovaPerUsoResponse createTrovaPerUsoResponse() {
        return new TrovaPerUsoResponse();
    }

    /**
     * Create an instance of {@link TrovaTutti }
     * 
     */
    public TrovaTutti createTrovaTutti() {
        return new TrovaTutti();
    }

    /**
     * Create an instance of {@link TrovaTuttiResponse }
     * 
     */
    public TrovaTuttiResponse createTrovaTuttiResponse() {
        return new TrovaTuttiResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Aggiorna }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Aggiorna }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "aggiorna")
    public JAXBElement<Aggiorna> createAggiorna(Aggiorna value) {
        return new JAXBElement<Aggiorna>(_Aggiorna_QNAME, Aggiorna.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AggiornaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AggiornaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "aggiornaResponse")
    public JAXBElement<AggiornaResponse> createAggiornaResponse(AggiornaResponse value) {
        return new JAXBElement<AggiornaResponse>(_AggiornaResponse_QNAME, AggiornaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Crea }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Crea }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "crea")
    public JAXBElement<Crea> createCrea(Crea value) {
        return new JAXBElement<Crea>(_Crea_QNAME, Crea.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "creaResponse")
    public JAXBElement<CreaResponse> createCreaResponse(CreaResponse value) {
        return new JAXBElement<CreaResponse>(_CreaResponse_QNAME, CreaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Elimina }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Elimina }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "elimina")
    public JAXBElement<Elimina> createElimina(Elimina value) {
        return new JAXBElement<Elimina>(_Elimina_QNAME, Elimina.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EliminaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "eliminaResponse")
    public JAXBElement<EliminaResponse> createEliminaResponse(EliminaResponse value) {
        return new JAXBElement<EliminaResponse>(_EliminaResponse_QNAME, EliminaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Fiore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Fiore }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "fiore")
    public JAXBElement<Fiore> createFiore(Fiore value) {
        return new JAXBElement<Fiore>(_Fiore_QNAME, Fiore.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaPerCiclo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaPerCiclo }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "trovaPerCiclo")
    public JAXBElement<TrovaPerCiclo> createTrovaPerCiclo(TrovaPerCiclo value) {
        return new JAXBElement<TrovaPerCiclo>(_TrovaPerCiclo_QNAME, TrovaPerCiclo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaPerCicloResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaPerCicloResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "trovaPerCicloResponse")
    public JAXBElement<TrovaPerCicloResponse> createTrovaPerCicloResponse(TrovaPerCicloResponse value) {
        return new JAXBElement<TrovaPerCicloResponse>(_TrovaPerCicloResponse_QNAME, TrovaPerCicloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaPerId }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaPerId }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "trovaPerId")
    public JAXBElement<TrovaPerId> createTrovaPerId(TrovaPerId value) {
        return new JAXBElement<TrovaPerId>(_TrovaPerId_QNAME, TrovaPerId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaPerIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaPerIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "trovaPerIdResponse")
    public JAXBElement<TrovaPerIdResponse> createTrovaPerIdResponse(TrovaPerIdResponse value) {
        return new JAXBElement<TrovaPerIdResponse>(_TrovaPerIdResponse_QNAME, TrovaPerIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaPerProprieta }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaPerProprieta }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "trovaPerProprieta")
    public JAXBElement<TrovaPerProprieta> createTrovaPerProprieta(TrovaPerProprieta value) {
        return new JAXBElement<TrovaPerProprieta>(_TrovaPerProprieta_QNAME, TrovaPerProprieta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaPerProprietaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaPerProprietaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "trovaPerProprietaResponse")
    public JAXBElement<TrovaPerProprietaResponse> createTrovaPerProprietaResponse(TrovaPerProprietaResponse value) {
        return new JAXBElement<TrovaPerProprietaResponse>(_TrovaPerProprietaResponse_QNAME, TrovaPerProprietaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaPerUso }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaPerUso }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "trovaPerUso")
    public JAXBElement<TrovaPerUso> createTrovaPerUso(TrovaPerUso value) {
        return new JAXBElement<TrovaPerUso>(_TrovaPerUso_QNAME, TrovaPerUso.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaPerUsoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaPerUsoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "trovaPerUsoResponse")
    public JAXBElement<TrovaPerUsoResponse> createTrovaPerUsoResponse(TrovaPerUsoResponse value) {
        return new JAXBElement<TrovaPerUsoResponse>(_TrovaPerUsoResponse_QNAME, TrovaPerUsoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaTutti }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaTutti }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "trovaTutti")
    public JAXBElement<TrovaTutti> createTrovaTutti(TrovaTutti value) {
        return new JAXBElement<TrovaTutti>(_TrovaTutti_QNAME, TrovaTutti.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaTuttiResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaTuttiResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://fiori/", name = "trovaTuttiResponse")
    public JAXBElement<TrovaTuttiResponse> createTrovaTuttiResponse(TrovaTuttiResponse value) {
        return new JAXBElement<TrovaTuttiResponse>(_TrovaTuttiResponse_QNAME, TrovaTuttiResponse.class, null, value);
    }

}
