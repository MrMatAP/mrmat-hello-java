package org.mrmat.hello.java.modules.impl.german.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.mrmat.hello.java.modules.impl.german.GermanGreeting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.condition.JRE.JAVA_10;
import static org.junit.jupiter.api.condition.JRE.JAVA_9;

/**
 * A test for the German Greeting implementation
 *
 * @author imfeldma
 */
@EnabledOnJre({ JAVA_9, JAVA_10 })
class GermanGreetingTest {

    private static final String EXPECTED_GREETING = "Hallo Welt";

    @Test
    @DisplayName("Check that the the German Greeting Provider issues a german greeting")
    void testGermanGreeting() {
        GermanGreeting germanGreeting = new GermanGreeting();
        assertEquals(EXPECTED_GREETING, germanGreeting.getGreeting(), "The german greeting is as expected");
    }
}
