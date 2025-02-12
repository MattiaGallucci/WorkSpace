
package sanremo;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.5
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SanremoEJB", targetNamespace = "http://sanremo/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SanremoEJB {


    /**
     * 
     * @return
     *     returns java.util.List<sanremo.Canzone>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "printAll", targetNamespace = "http://sanremo/", className = "sanremo.PrintAll")
    @ResponseWrapper(localName = "printAllResponse", targetNamespace = "http://sanremo/", className = "sanremo.PrintAllResponse")
    @Action(input = "http://sanremo/SanremoEJB/printAllRequest", output = "http://sanremo/SanremoEJB/printAllResponse")
    public List<Canzone> printAll();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "crea", targetNamespace = "http://sanremo/", className = "sanremo.Crea")
    @ResponseWrapper(localName = "creaResponse", targetNamespace = "http://sanremo/", className = "sanremo.CreaResponse")
    @Action(input = "http://sanremo/SanremoEJB/creaRequest", output = "http://sanremo/SanremoEJB/creaResponse")
    public void crea(
        @WebParam(name = "arg0", targetNamespace = "")
        Canzone arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "elimina", targetNamespace = "http://sanremo/", className = "sanremo.Elimina")
    @ResponseWrapper(localName = "eliminaResponse", targetNamespace = "http://sanremo/", className = "sanremo.EliminaResponse")
    @Action(input = "http://sanremo/SanremoEJB/eliminaRequest", output = "http://sanremo/SanremoEJB/eliminaResponse")
    public void elimina(
        @WebParam(name = "arg0", targetNamespace = "")
        Canzone arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns sanremo.Canzone
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "printById", targetNamespace = "http://sanremo/", className = "sanremo.PrintById")
    @ResponseWrapper(localName = "printByIdResponse", targetNamespace = "http://sanremo/", className = "sanremo.PrintByIdResponse")
    @Action(input = "http://sanremo/SanremoEJB/printByIdRequest", output = "http://sanremo/SanremoEJB/printByIdResponse")
    public Canzone printById(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "aggiorna", targetNamespace = "http://sanremo/", className = "sanremo.Aggiorna")
    @ResponseWrapper(localName = "aggiornaResponse", targetNamespace = "http://sanremo/", className = "sanremo.AggiornaResponse")
    @Action(input = "http://sanremo/SanremoEJB/aggiornaRequest", output = "http://sanremo/SanremoEJB/aggiornaResponse")
    public void aggiorna(
        @WebParam(name = "arg0", targetNamespace = "")
        Canzone arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<sanremo.Canzone>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "printByVotes", targetNamespace = "http://sanremo/", className = "sanremo.PrintByVotes")
    @ResponseWrapper(localName = "printByVotesResponse", targetNamespace = "http://sanremo/", className = "sanremo.PrintByVotesResponse")
    @Action(input = "http://sanremo/SanremoEJB/printByVotesRequest", output = "http://sanremo/SanremoEJB/printByVotesResponse")
    public List<Canzone> printByVotes(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<sanremo.Canzone>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "printByCategory", targetNamespace = "http://sanremo/", className = "sanremo.PrintByCategory")
    @ResponseWrapper(localName = "printByCategoryResponse", targetNamespace = "http://sanremo/", className = "sanremo.PrintByCategoryResponse")
    @Action(input = "http://sanremo/SanremoEJB/printByCategoryRequest", output = "http://sanremo/SanremoEJB/printByCategoryResponse")
    public List<Canzone> printByCategory(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
