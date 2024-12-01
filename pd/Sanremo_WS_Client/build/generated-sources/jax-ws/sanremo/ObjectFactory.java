
package sanremo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the sanremo package. 
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

    private final static QName _Aggiorna_QNAME = new QName("http://sanremo/", "aggiorna");
    private final static QName _AggiornaResponse_QNAME = new QName("http://sanremo/", "aggiornaResponse");
    private final static QName _Canzone_QNAME = new QName("http://sanremo/", "canzone");
    private final static QName _Crea_QNAME = new QName("http://sanremo/", "crea");
    private final static QName _CreaResponse_QNAME = new QName("http://sanremo/", "creaResponse");
    private final static QName _Elimina_QNAME = new QName("http://sanremo/", "elimina");
    private final static QName _EliminaResponse_QNAME = new QName("http://sanremo/", "eliminaResponse");
    private final static QName _PrintAll_QNAME = new QName("http://sanremo/", "printAll");
    private final static QName _PrintAllResponse_QNAME = new QName("http://sanremo/", "printAllResponse");
    private final static QName _PrintByCategory_QNAME = new QName("http://sanremo/", "printByCategory");
    private final static QName _PrintByCategoryResponse_QNAME = new QName("http://sanremo/", "printByCategoryResponse");
    private final static QName _PrintById_QNAME = new QName("http://sanremo/", "printById");
    private final static QName _PrintByIdResponse_QNAME = new QName("http://sanremo/", "printByIdResponse");
    private final static QName _PrintByVotes_QNAME = new QName("http://sanremo/", "printByVotes");
    private final static QName _PrintByVotesResponse_QNAME = new QName("http://sanremo/", "printByVotesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: sanremo
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
     * Create an instance of {@link Canzone }
     * 
     */
    public Canzone createCanzone() {
        return new Canzone();
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
     * Create an instance of {@link PrintAll }
     * 
     */
    public PrintAll createPrintAll() {
        return new PrintAll();
    }

    /**
     * Create an instance of {@link PrintAllResponse }
     * 
     */
    public PrintAllResponse createPrintAllResponse() {
        return new PrintAllResponse();
    }

    /**
     * Create an instance of {@link PrintByCategory }
     * 
     */
    public PrintByCategory createPrintByCategory() {
        return new PrintByCategory();
    }

    /**
     * Create an instance of {@link PrintByCategoryResponse }
     * 
     */
    public PrintByCategoryResponse createPrintByCategoryResponse() {
        return new PrintByCategoryResponse();
    }

    /**
     * Create an instance of {@link PrintById }
     * 
     */
    public PrintById createPrintById() {
        return new PrintById();
    }

    /**
     * Create an instance of {@link PrintByIdResponse }
     * 
     */
    public PrintByIdResponse createPrintByIdResponse() {
        return new PrintByIdResponse();
    }

    /**
     * Create an instance of {@link PrintByVotes }
     * 
     */
    public PrintByVotes createPrintByVotes() {
        return new PrintByVotes();
    }

    /**
     * Create an instance of {@link PrintByVotesResponse }
     * 
     */
    public PrintByVotesResponse createPrintByVotesResponse() {
        return new PrintByVotesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Aggiorna }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Aggiorna }{@code >}
     */
    @XmlElementDecl(namespace = "http://sanremo/", name = "aggiorna")
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
    @XmlElementDecl(namespace = "http://sanremo/", name = "aggiornaResponse")
    public JAXBElement<AggiornaResponse> createAggiornaResponse(AggiornaResponse value) {
        return new JAXBElement<AggiornaResponse>(_AggiornaResponse_QNAME, AggiornaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Canzone }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Canzone }{@code >}
     */
    @XmlElementDecl(namespace = "http://sanremo/", name = "canzone")
    public JAXBElement<Canzone> createCanzone(Canzone value) {
        return new JAXBElement<Canzone>(_Canzone_QNAME, Canzone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Crea }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Crea }{@code >}
     */
    @XmlElementDecl(namespace = "http://sanremo/", name = "crea")
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
    @XmlElementDecl(namespace = "http://sanremo/", name = "creaResponse")
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
    @XmlElementDecl(namespace = "http://sanremo/", name = "elimina")
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
    @XmlElementDecl(namespace = "http://sanremo/", name = "eliminaResponse")
    public JAXBElement<EliminaResponse> createEliminaResponse(EliminaResponse value) {
        return new JAXBElement<EliminaResponse>(_EliminaResponse_QNAME, EliminaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintAll }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrintAll }{@code >}
     */
    @XmlElementDecl(namespace = "http://sanremo/", name = "printAll")
    public JAXBElement<PrintAll> createPrintAll(PrintAll value) {
        return new JAXBElement<PrintAll>(_PrintAll_QNAME, PrintAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintAllResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrintAllResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://sanremo/", name = "printAllResponse")
    public JAXBElement<PrintAllResponse> createPrintAllResponse(PrintAllResponse value) {
        return new JAXBElement<PrintAllResponse>(_PrintAllResponse_QNAME, PrintAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintByCategory }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrintByCategory }{@code >}
     */
    @XmlElementDecl(namespace = "http://sanremo/", name = "printByCategory")
    public JAXBElement<PrintByCategory> createPrintByCategory(PrintByCategory value) {
        return new JAXBElement<PrintByCategory>(_PrintByCategory_QNAME, PrintByCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintByCategoryResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrintByCategoryResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://sanremo/", name = "printByCategoryResponse")
    public JAXBElement<PrintByCategoryResponse> createPrintByCategoryResponse(PrintByCategoryResponse value) {
        return new JAXBElement<PrintByCategoryResponse>(_PrintByCategoryResponse_QNAME, PrintByCategoryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrintById }{@code >}
     */
    @XmlElementDecl(namespace = "http://sanremo/", name = "printById")
    public JAXBElement<PrintById> createPrintById(PrintById value) {
        return new JAXBElement<PrintById>(_PrintById_QNAME, PrintById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrintByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://sanremo/", name = "printByIdResponse")
    public JAXBElement<PrintByIdResponse> createPrintByIdResponse(PrintByIdResponse value) {
        return new JAXBElement<PrintByIdResponse>(_PrintByIdResponse_QNAME, PrintByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintByVotes }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrintByVotes }{@code >}
     */
    @XmlElementDecl(namespace = "http://sanremo/", name = "printByVotes")
    public JAXBElement<PrintByVotes> createPrintByVotes(PrintByVotes value) {
        return new JAXBElement<PrintByVotes>(_PrintByVotes_QNAME, PrintByVotes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrintByVotesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrintByVotesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://sanremo/", name = "printByVotesResponse")
    public JAXBElement<PrintByVotesResponse> createPrintByVotesResponse(PrintByVotesResponse value) {
        return new JAXBElement<PrintByVotesResponse>(_PrintByVotesResponse_QNAME, PrintByVotesResponse.class, null, value);
    }

}
