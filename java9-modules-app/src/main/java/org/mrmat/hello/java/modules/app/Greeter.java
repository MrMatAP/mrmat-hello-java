package org.mrmat.hello.java.modules.app;

import org.mrmat.hello.java.modules.api.GreetingProvider;
import org.mrmat.hello.java.modules.api.NoGreetingProviderException;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * Main class for issuing a greeting
 *
 * @author imfeldma
 */
public class Greeter {

    private ServiceLoader<GreetingProvider> implementations;

    public Greeter() {
        this.implementations = ServiceLoader.load(GreetingProvider.class);
    }

    public ServiceLoader<GreetingProvider> getImplementations() throws NoGreetingProviderException {
        implementations.findFirst().orElseThrow(NoGreetingProviderException::new);
        return implementations;
    }

    public List<String> getGreetings() {
        List<String> greetings = new ArrayList<>();
        try {
            final ServiceLoader<GreetingProvider> greeters = getImplementations();
            greeters.forEach(g -> greetings.add(g.getGreeting()));
        } catch (NoGreetingProviderException e) {}
        return greetings;
    }

    public static void main(String[] args) {

        Greeter greeter = new Greeter();
        try {
            final ServiceLoader<GreetingProvider> greeters = greeter.getImplementations();
            greeters.forEach(g -> System.out.println(g.getGreeting()));
        } catch (NoGreetingProviderException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }
}
