package org.mrmat.hello.java.javaee.jaxws;

import javax.xml.bind.annotation.*;

/**
 * A request model for greeting a person
 *
 * @author imfeldma
 */
@XmlType(propOrder = {
        "name",
        "surname"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonRequestModel {

    @XmlElement
    private String name;

    @XmlElement
    private String surname;

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
}
