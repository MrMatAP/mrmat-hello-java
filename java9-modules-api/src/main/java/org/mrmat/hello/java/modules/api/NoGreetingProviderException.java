package org.mrmat.hello.java.modules.api;

/**
 * TODO: Add description here
 *
 * @author imfeldma
 */
public class NoGreetingProviderException extends Exception {

    public NoGreetingProviderException() {
        super("There are no greeting providers available");
    }
}
