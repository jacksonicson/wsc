package de.tum.in.dss.world;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;

/**
 * This class was generated by Apache CXF 2.2.3
 * Mon Jun 03 09:42:01 CEST 2013
 * Generated source version: 2.2.3
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
