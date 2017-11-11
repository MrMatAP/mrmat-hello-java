package org.mrmat.hello.java.javaee.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * TODO: Add description here
 *
 * @author imfeldma
 */
@WebService(                                // Note: This is really the only required annotation
        name = "HelloServicePortType",      // Note: Defaults to the service class appended with 'Porttype'
        targetNamespace = "http://mrmat.org/hello/java/javaee/jaxws"    // Note: Derived from the package name
        // wsdlLocation = <defaults to the location of the web service>
)
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
public interface HelloSEI {

    @WebMethod(
            operationName = "greetPerson"       // Note: Defaults to the method name
            // action = ""                      // Note: Defaults to an empty string
            // exclude = false                  // Note: Whether to exclude the method from the interface
    )
    public PersonResponseModel greetPerson(
            @WebParam(name = "person")          // Note: The parameter would default to arg0 otherwise
            PersonRequestModel person
    );
}
