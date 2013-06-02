
/*
 * 
 */

package de.tum.in.dss.world;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.2.3
 * Sun Jun 02 13:09:11 CEST 2013
 * Generated source version: 2.2.3
 * 
 */


@WebServiceClient(name = "serviceWorld", 
                  wsdlLocation = "file:/D:/work/wsc/l6/CXFWebDemo/src/main/resources/demo.wsdl",
                  targetNamespace = "http://dss.in.tum.de/world") 
public class ServiceWorld extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://dss.in.tum.de/world", "serviceWorld");
    public final static QName HeloWorldPort = new QName("http://dss.in.tum.de/world", "heloWorldPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/work/wsc/l6/CXFWebDemo/src/main/resources/demo.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:/D:/work/wsc/l6/CXFWebDemo/src/main/resources/demo.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public ServiceWorld(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ServiceWorld(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServiceWorld() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns IHelloWorld
     */
    @WebEndpoint(name = "heloWorldPort")
    public IHelloWorld getHeloWorldPort() {
        return super.getPort(HeloWorldPort, IHelloWorld.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IHelloWorld
     */
    @WebEndpoint(name = "heloWorldPort")
    public IHelloWorld getHeloWorldPort(WebServiceFeature... features) {
        return super.getPort(HeloWorldPort, IHelloWorld.class, features);
    }

}
