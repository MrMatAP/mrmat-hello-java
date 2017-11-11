package org.mrmat.hello.java.javaee.jaxws;

import javax.jws.WebService;

/**
 * The SOAP Service implementation class must implement the SOAP SEI and be annotated with @WebService.
 *
 * @author imfeldma
 * @see HelloSEI
 */
@WebService(
        endpointInterface = "org.mrmat.hello.java.javaee.jaxws.HelloSEI",   // Note: Not allowed on the SEI
        targetNamespace = "http://mrmat.org/hello/java/javaee/jaxws",
        portName = "HelloServicePort",                                      // Note: Not allowed on the SEI
        serviceName = "HelloService"                                        // Note: Not allowed on the SEI
)
public class HelloService implements HelloSEI {

    @Override
    public PersonResponseModel greetPersonBare(PersonRequestModel person) {
        return genericResponse(person);
    }

    @Override
    public PersonResponseModel greetPersonDefault(PersonRequestModel person) {
        return genericResponse(person);
    }

    @Override
    public PersonResponseModel greetPersonOverride(PersonRequestModel person) {
        return genericResponse(person);
    }

    private PersonResponseModel genericResponse(PersonRequestModel request) {
        if(request == null)
            return new PersonResponseModel("NULL", "NULL", "NULL");

        return new PersonResponseModel(
                request.getName(),
                request.getSurname(),
                "Hello " + request.getName() + " " + request.getSurname()
        );
    }
}
