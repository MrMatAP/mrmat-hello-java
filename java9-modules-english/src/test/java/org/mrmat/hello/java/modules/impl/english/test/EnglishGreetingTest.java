package org.mrmat.hello.java.modules.impl.english.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;
import org.mrmat.hello.java.modules.impl.english.EnglishGreeting;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A test for the english greeting provider
 *
 * @author imfeldma
 */
@EnabledOnJre({JRE.JAVA_9, JRE.JAVA_10})
class EnglishGreetingTest {

    private static final String EXPECTED_GREETING = "Hello World";

    @Test
    @DisplayName("Check that the the English Greeting Provider issues an english greeting")
    void testGermanGreeting() {
        EnglishGreeting englishGreeting = new EnglishGreeting();
        assertEquals(EXPECTED_GREETING, englishGreeting.getGreeting(), "The english greeting is as expected");
    }
}
