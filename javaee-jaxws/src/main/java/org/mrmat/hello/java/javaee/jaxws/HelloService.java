package org.mrmat.hello.java.javaee.jaxws;

import javax.jws.WebService;

/**
 * TODO: Add description here
 *
 * @author imfeldma
 */
@WebService(
        endpointInterface = "org.mrmat.hello.java.javaee.jaxws.HelloSEI",   // Note: Not allowed on the SEI
        targetNamespace = "http://mrmat.org/hello/java/javaee/jaxws",
        portName = "HelloServicePort",                                      // Note: Not allowed on the SEI
        serviceName = "HelloService"                                        // Note: Not allowed on the SEI
)
public class HelloService implements HelloSEI {

    @Override
    public PersonResponseModel greetPerson(PersonRequestModel person) {
        return new PersonResponseModel(
                person.getName(),
                person.getSurname(),
                "Hello " + person.getName() + " " + person.getSurname()
        );
    }
}
