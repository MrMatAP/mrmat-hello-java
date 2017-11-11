package org.mrmat.hello.java.javaee.jaxws;

/**
 * TODO: Add description here
 *
 * @author imfeldma
 */
public class PersonResponseModel {

    private String name;
    private String surname;
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
