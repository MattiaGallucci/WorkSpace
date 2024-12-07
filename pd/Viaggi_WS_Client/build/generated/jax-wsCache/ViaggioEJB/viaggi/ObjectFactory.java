
package viaggi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the viaggi package. 
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

    private final static QName _Aggiorna_QNAME = new QName("http://viaggi/", "aggiorna");
    private final static QName _AggiornaResponse_QNAME = new QName("http://viaggi/", "aggiornaResponse");
    private final static QName _Crea_QNAME = new QName("http://viaggi/", "crea");
    private final static QName _CreaResponse_QNAME = new QName("http://viaggi/", "creaResponse");
    private final static QName _Elimina_QNAME = new QName("http://viaggi/", "elimina");
    private final static QName _EliminaResponse_QNAME = new QName("http://viaggi/", "eliminaResponse");
    private final static QName _TrovaPerCategoria_QNAME = new QName("http://viaggi/", "trovaPerCategoria");
    private final static QName _TrovaPerCategoriaResponse_QNAME = new QName("http://viaggi/", "trovaPerCategoriaResponse");
    private final static QName _TrovaPerDestinazione_QNAME = new QName("http://viaggi/", "trovaPerDestinazione");
    private final static QName _TrovaPerDestinazioneResponse_QNAME = new QName("http://viaggi/", "trovaPerDestinazioneResponse");
    private final static QName _TrovaPerId_QNAME = new QName("http://viaggi/", "trovaPerId");
    private final static QName _TrovaPerIdResponse_QNAME = new QName("http://viaggi/", "trovaPerIdResponse");
    private final static QName _TrovaPerPrezzo_QNAME = new QName("http://viaggi/", "trovaPerPrezzo");
    private final static QName _TrovaPerPrezzoResponse_QNAME = new QName("http://viaggi/", "trovaPerPrezzoResponse");
    private final static QName _TrovaTutti_QNAME = new QName("http://viaggi/", "trovaTutti");
    private final static QName _TrovaTuttiResponse_QNAME = new QName("http://viaggi/", "trovaTuttiResponse");
    private final static QName _Viaggio_QNAME = new QName("http://viaggi/", "viaggio");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: viaggi
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
     * Create an instance of {@link TrovaPerCategoria }
     * 
     */
    public TrovaPerCategoria createTrovaPerCategoria() {
        return new TrovaPerCategoria();
    }

    /**
     * Create an instance of {@link TrovaPerCategoriaResponse }
     * 
     */
    public TrovaPerCategoriaResponse createTrovaPerCategoriaResponse() {
        return new TrovaPerCategoriaResponse();
    }

    /**
     * Create an instance of {@link TrovaPerDestinazione }
     * 
     */
    public TrovaPerDestinazione createTrovaPerDestinazione() {
        return new TrovaPerDestinazione();
    }

    /**
     * Create an instance of {@link TrovaPerDestinazioneResponse }
     * 
     */
    public TrovaPerDestinazioneResponse createTrovaPerDestinazioneResponse() {
        return new TrovaPerDestinazioneResponse();
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
     * Create an instance of {@link TrovaPerPrezzo }
     * 
     */
    public TrovaPerPrezzo createTrovaPerPrezzo() {
        return new TrovaPerPrezzo();
    }

    /**
     * Create an instance of {@link TrovaPerPrezzoResponse }
     * 
     */
    public TrovaPerPrezzoResponse createTrovaPerPrezzoResponse() {
        return new TrovaPerPrezzoResponse();
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
     * Create an instance of {@link Viaggio }
     * 
     */
    public Viaggio createViaggio() {
        return new Viaggio();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Aggiorna }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Aggiorna }{@code >}
     */
    @XmlElementDecl(namespace = "http://viaggi/", name = "aggiorna")
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
    @XmlElementDecl(namespace = "http://viaggi/", name = "aggiornaResponse")
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
    @XmlElementDecl(namespace = "http://viaggi/", name = "crea")
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
    @XmlElementDecl(namespace = "http://viaggi/", name = "creaResponse")
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
    @XmlElementDecl(namespace = "http://viaggi/", name = "elimina")
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
    @XmlElementDecl(namespace = "http://viaggi/", name = "eliminaResponse")
    public JAXBElement<EliminaResponse> createEliminaResponse(EliminaResponse value) {
        return new JAXBElement<EliminaResponse>(_EliminaResponse_QNAME, EliminaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaPerCategoria }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaPerCategoria }{@code >}
     */
    @XmlElementDecl(namespace = "http://viaggi/", name = "trovaPerCategoria")
    public JAXBElement<TrovaPerCategoria> createTrovaPerCategoria(TrovaPerCategoria value) {
        return new JAXBElement<TrovaPerCategoria>(_TrovaPerCategoria_QNAME, TrovaPerCategoria.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaPerCategoriaResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaPerCategoriaResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://viaggi/", name = "trovaPerCategoriaResponse")
    public JAXBElement<TrovaPerCategoriaResponse> createTrovaPerCategoriaResponse(TrovaPerCategoriaResponse value) {
        return new JAXBElement<TrovaPerCategoriaResponse>(_TrovaPerCategoriaResponse_QNAME, TrovaPerCategoriaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaPerDestinazione }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaPerDestinazione }{@code >}
     */
    @XmlElementDecl(namespace = "http://viaggi/", name = "trovaPerDestinazione")
    public JAXBElement<TrovaPerDestinazione> createTrovaPerDestinazione(TrovaPerDestinazione value) {
        return new JAXBElement<TrovaPerDestinazione>(_TrovaPerDestinazione_QNAME, TrovaPerDestinazione.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaPerDestinazioneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaPerDestinazioneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://viaggi/", name = "trovaPerDestinazioneResponse")
    public JAXBElement<TrovaPerDestinazioneResponse> createTrovaPerDestinazioneResponse(TrovaPerDestinazioneResponse value) {
        return new JAXBElement<TrovaPerDestinazioneResponse>(_TrovaPerDestinazioneResponse_QNAME, TrovaPerDestinazioneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaPerId }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaPerId }{@code >}
     */
    @XmlElementDecl(namespace = "http://viaggi/", name = "trovaPerId")
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
    @XmlElementDecl(namespace = "http://viaggi/", name = "trovaPerIdResponse")
    public JAXBElement<TrovaPerIdResponse> createTrovaPerIdResponse(TrovaPerIdResponse value) {
        return new JAXBElement<TrovaPerIdResponse>(_TrovaPerIdResponse_QNAME, TrovaPerIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaPerPrezzo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaPerPrezzo }{@code >}
     */
    @XmlElementDecl(namespace = "http://viaggi/", name = "trovaPerPrezzo")
    public JAXBElement<TrovaPerPrezzo> createTrovaPerPrezzo(TrovaPerPrezzo value) {
        return new JAXBElement<TrovaPerPrezzo>(_TrovaPerPrezzo_QNAME, TrovaPerPrezzo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaPerPrezzoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaPerPrezzoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://viaggi/", name = "trovaPerPrezzoResponse")
    public JAXBElement<TrovaPerPrezzoResponse> createTrovaPerPrezzoResponse(TrovaPerPrezzoResponse value) {
        return new JAXBElement<TrovaPerPrezzoResponse>(_TrovaPerPrezzoResponse_QNAME, TrovaPerPrezzoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrovaTutti }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrovaTutti }{@code >}
     */
    @XmlElementDecl(namespace = "http://viaggi/", name = "trovaTutti")
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
    @XmlElementDecl(namespace = "http://viaggi/", name = "trovaTuttiResponse")
    public JAXBElement<TrovaTuttiResponse> createTrovaTuttiResponse(TrovaTuttiResponse value) {
        return new JAXBElement<TrovaTuttiResponse>(_TrovaTuttiResponse_QNAME, TrovaTuttiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Viaggio }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Viaggio }{@code >}
     */
    @XmlElementDecl(namespace = "http://viaggi/", name = "viaggio")
    public JAXBElement<Viaggio> createViaggio(Viaggio value) {
        return new JAXBElement<Viaggio>(_Viaggio_QNAME, Viaggio.class, null, value);
    }

}
