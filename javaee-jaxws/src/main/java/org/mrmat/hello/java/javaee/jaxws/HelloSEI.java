package org.mrmat.hello.java.javaee.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * The SOAP Service Endpoint Interface
 *
 * <p>
 *     The SOAP SEI must be annotated with @WebService. The name attribute of @WebService defaults to the
 *     name of the service implementation class appended with 'PortType'. The value of the targetNamespace attribute
 *     is derived from the package name. The wsdlLocation defaults to the ultimate location of the web service with
 *     ?WSDL appended.
 * </p>
 *
 * <p>
 *     The @SOAPBinding annotation is optional because DOCUMENT/LITERAL is the default.
 * </p>
 *
 * <p>
 *     Every method in the SEI should be annotated with @WebMethod. The operationName attribute defaults to the
 *     method name. A method in the interface can be excluded by setting the exclude attribute to true.
 * </p>
 *
 * @author imfeldma
 */
@WebService(                                // Note: This is really the only required annotation
        name = "HelloServicePortType",      // Note: Defaults to the service class appended with 'Porttype'
        targetNamespace = "http://mrmat.org/hello/java/javaee/jaxws"    // Note: Derived from the package name
        // wsdlLocation = <defaults to the location of the web service>
)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface HelloSEI {

    /**
     * The simple default greeting method. The SOAP request body will look like this:
     *
     * <pre>
     *     <jax:greetPersonDefault>
     *       <arg0>
     *         <name>Mathieu</name>
     *         <surname>Imfeld</surname>
     *       </arg0>
     *     </jax:greetPersonDefault>
     * </pre>
     *
     * <p>
     *     The SOAP response body will look like this:
     * </p>
     *
     * <pre>
     *    <ns2:greetPersonDefaultResponse xmlns:ns2="http://mrmat.org/hello/java/javaee/jaxws">
     *      <return>
     *        <name>Mathieu</name>
     *        <surname>Imfeld</surname>
     *        <greeting>Hello Mathieu Imfeld</greeting>
     *      </return>
     *    </ns2:greetPersonDefaultResponse>
     * </pre>
     *
     * @param person The person to greet
     * @return The original person plus a greeting
     */
    @WebMethod(operationName = "greetPersonDefault")
    public PersonResponseModel greetPersonDefault(PersonRequestModel person);


    /**
     * A greeting method where the names of the request and response elements has been configured using
     * the @WebParam and @WebResult annotations. The SOAP request will look like this:
     *
     * <pre>
     *     <jax:greetPersonOverride>
     *       <jax:overriddenRequest>
     *         <name>Mathieu</name>
     *         <surname>Imfeld</surname>
     *       </jax:overriddenRequest>
     *     </jax:greetPersonOverride>
     * </pre>
     *
     * <p>
     *     The SOAP response will look like this:
     * </p>
     *
     * <pre>
     *   <ns2:greetPersonOverrideResponse xmlns:ns2="http://mrmat.org/hello/java/javaee/jaxws">
     *     <ns2:overriddenResponse>
     *       <name>Mathieu</name>
     *       <surname>Imfeld</surname>
     *       <greeting>Hello Mathieu Imfeld</greeting>
     *     </ns2:overriddenResponse>
     *   </ns2:greetPersonOverrideResponse>
     * </pre>
     *
     * @param person The person to greet
     * @return The original person plus a greeting
     */
    @WebMethod(operationName = "greetPersonOverride")
    @WebResult(name = "overriddenResponse", targetNamespace = "http://mrmat.org/hello/java/javaee/jaxws")
    public PersonResponseModel greetPersonOverride(
            @WebParam(name = "overriddenRequest", targetNamespace = "http://mrmat.org/hello/java/javaee/jaxws")
                    PersonRequestModel person
    );

    /**
     * A greeting method avoiding the top-level request and response wrappers. The SOAP request will look like
     * this:
     *
     * <pre>
     *   <jax:greetPerson>
     *     <name>Mathieu</name>
     *     <surname>Imfeld</surname>
     *   </jax:greetPerson>
     * </pre>
     *
     * <p>
     *     The SOAP response will look like this:
     * </p>
     *
     * <pre>
     *   <ns2:greetPersonResponse xmlns:ns2="http://mrmat.org/hello/java/javaee/jaxws">
     *     <name>Mathieu</name>
     *     <surname>Imfeld</surname>
     *     <greeting>Hello Mathieu Imfeld</greeting>
     *   </ns2:greetPersonResponse>
     * </pre>
     *
     *
     * @param person The person to greet
     * @return The original person plus a greeting
     */
    @WebMethod(operationName = "greetPerson")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public PersonResponseModel greetPersonBare(PersonRequestModel person);


}
