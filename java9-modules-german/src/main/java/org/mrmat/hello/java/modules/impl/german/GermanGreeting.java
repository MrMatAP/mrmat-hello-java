package org.mrmat.hello.java.modules.impl.german;

import org.mrmat.hello.java.modules.api.GreetingProvider;

/**
 * A german greeting provider
 *
 * @author imfeldma
 */
public class GermanGreeting extends GreetingProvider {

    @Override
    public String getGreeting() {
        return "Hallo Welt";
    }
}
