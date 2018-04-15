package org.mrmat.hello.java.modules.api.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.mrmat.hello.java.modules.api.GreetingProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.condition.JRE.JAVA_10;
import static org.junit.jupiter.api.condition.JRE.JAVA_9;

/**
 * A test for the GreetingProvider API
 *
 * @author imfeldma
 */
@EnabledOnJre({ JAVA_9, JAVA_10 })
public class GreetingProviderTest {

    @Test
    public void testTrue() {
        assertTrue(true);
    }

    @Test
    void testGreetingProvider() {

        GreetingProviderImpl greetingProvider = new GreetingProviderImpl();
        assertEquals(
                "Hello Test",
                greetingProvider.getGreeting(),
                "The GreetingProvider API has a getGreeting method");
    }


    /**
     * A private class implementing the API for testing purposes
     */
    private class GreetingProviderImpl extends GreetingProvider {

        @Override
        public String getGreeting() {
            return "Hello Test";
        }
    }

}
