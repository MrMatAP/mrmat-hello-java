package org.mrmat.hello.java.modules.app.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.mrmat.hello.java.modules.api.NoGreetingProviderException;
import org.mrmat.hello.java.modules.app.Greeter;

import static org.junit.jupiter.api.condition.JRE.JAVA_10;
import static org.junit.jupiter.api.condition.JRE.JAVA_9;

/**
 * Tests for the Java 9 module system
 *
 * @author imfeldma
 */
@EnabledOnJre({ JAVA_9, JAVA_10 })
public class ModulesTest {

    @Test
    @DisplayName("Greeting implementations are discovered")
    public void succeed_discoverGreetingImplementations() throws NoGreetingProviderException {
        Greeter greeter = new Greeter();
        greeter.getImplementations();
    }

    @Test
    @DisplayName("There is a german greeting")
    void succeed_germanGreeting() {
        Greeter greeter = new Greeter();
        greeter.getGreetings().contains("Hallo Welt");
    }

    @Test
    @DisplayName("There is an english greeting")
    void succeed_englishGreeting() {
        Greeter greeter = new Greeter();
        greeter.getGreetings().contains("Hello World");
    }
}
