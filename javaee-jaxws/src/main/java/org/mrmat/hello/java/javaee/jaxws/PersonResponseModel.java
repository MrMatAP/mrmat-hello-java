package org.mrmat.hello.java.javaee.jaxws;

import javax.xml.bind.annotation.*;

/**
 * A response model for greeting a person
 *
 * @author imfeldma
 */
@XmlType(propOrder = {
        "name",
        "surname",
        "greeting"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonResponseModel {

    @XmlElement
    private String name;

    @XmlElement
    private String surname;

    @XmlElement
    private String greeting;

    //
    // Utility Constructors

    public PersonResponseModel() { /* default empty constructor for JAXB */ }
    public PersonResponseModel(String name, String surname, String greeting) {
        this.name = name;
        this.surname = surname;
        this.greeting = greeting;
    }

    //
    // Getter/Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
