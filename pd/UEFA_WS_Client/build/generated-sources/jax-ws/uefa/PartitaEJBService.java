
package uefa;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.5
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PartitaEJBService", targetNamespace = "http://uefa/", wsdlLocation = "http://localhost:8080/PartitaEJBService/PartitaEJB?wsdl")
public class PartitaEJBService
    extends Service
{

    private final static URL PARTITAEJBSERVICE_WSDL_LOCATION;
    private final static WebServiceException PARTITAEJBSERVICE_EXCEPTION;
    private final static QName PARTITAEJBSERVICE_QNAME = new QName("http://uefa/", "PartitaEJBService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/PartitaEJBService/PartitaEJB?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PARTITAEJBSERVICE_WSDL_LOCATION = url;
        PARTITAEJBSERVICE_EXCEPTION = e;
    }

    public PartitaEJBService() {
        super(__getWsdlLocation(), PARTITAEJBSERVICE_QNAME);
    }

    public PartitaEJBService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PARTITAEJBSERVICE_QNAME, features);
    }

    public PartitaEJBService(URL wsdlLocation) {
        super(wsdlLocation, PARTITAEJBSERVICE_QNAME);
    }

    public PartitaEJBService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PARTITAEJBSERVICE_QNAME, features);
    }

    public PartitaEJBService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PartitaEJBService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PartitaEJB
     */
    @WebEndpoint(name = "PartitaEJBPort")
    public PartitaEJB getPartitaEJBPort() {
        return super.getPort(new QName("http://uefa/", "PartitaEJBPort"), PartitaEJB.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PartitaEJB
     */
    @WebEndpoint(name = "PartitaEJBPort")
    public PartitaEJB getPartitaEJBPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://uefa/", "PartitaEJBPort"), PartitaEJB.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PARTITAEJBSERVICE_EXCEPTION!= null) {
            throw PARTITAEJBSERVICE_EXCEPTION;
        }
        return PARTITAEJBSERVICE_WSDL_LOCATION;
    }

}
