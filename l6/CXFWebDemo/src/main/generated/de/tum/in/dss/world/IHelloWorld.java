package de.tum.in.dss.world;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * This class was generated by Apache CXF 2.6.8
 * 2013-06-03T09:38:00.685+02:00
 * Generated source version: 2.6.8
 * 
 */
@WebService(targetNamespace = "http://dss.in.tum.de/world", name = "IHelloWorld")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface IHelloWorld {

    @WebMethod
    public void sayHello(
        @WebParam(partName = "value", name = "value", targetNamespace = "")
        int value
    );
}
