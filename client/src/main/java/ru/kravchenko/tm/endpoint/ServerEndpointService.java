package ru.kravchenko.tm.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-06-06T10:09:51.773+03:00
 * Generated source version: 3.2.7
 *
 */
@WebServiceClient(name = "ServerEndpointService",
                  wsdlLocation = "http://127.0.0.1:80/ServerEndpoint?WSDL",
                  targetNamespace = "http://endpoint.tm.kravchenko.ru/")
public class ServerEndpointService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://endpoint.tm.kravchenko.ru/", "ServerEndpointService");
    public final static QName ServerEndpointPort = new QName("http://endpoint.tm.kravchenko.ru/", "ServerEndpointPort");
    static {
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:80/ServerEndpoint?WSDL");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ServerEndpointService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://127.0.0.1:80/ServerEndpoint?WSDL");
        }
        WSDL_LOCATION = url;
    }

    public ServerEndpointService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ServerEndpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServerEndpointService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public ServerEndpointService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ServerEndpointService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ServerEndpointService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns ServerEndpoint
     */
    @WebEndpoint(name = "ServerEndpointPort")
    public ServerEndpoint getServerEndpointPort() {
        return super.getPort(ServerEndpointPort, ServerEndpoint.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServerEndpoint
     */
    @WebEndpoint(name = "ServerEndpointPort")
    public ServerEndpoint getServerEndpointPort(WebServiceFeature... features) {
        return super.getPort(ServerEndpointPort, ServerEndpoint.class, features);
    }

}
