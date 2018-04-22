package org.mrmat.hello.java.optional.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A test for Java 8 Optionals
 *
 * @author imfeldma
 */
class OptionalTest {

    @Test
    @DisplayName("An Optional.of with a null parameter throws a NullPointerException")
    void optional_of_with_null_parameter() {
        assertThrows(
                NullPointerException.class,
                () -> Optional.of(null),
                "An Optional.of with a null parameter throws a NullPointerException");
    }

    @Test
    @DisplayName("An Optional.ofNullable with a null parameter is okay but not present")
    void optional_ofnullable_with_null_parameter() {
        assertFalse(
                Optional.ofNullable(null).isPresent(),
                "An Optional.ofNullable with a null parameter is okay but not present");
    }

    @Test
    @DisplayName("An Optional.of with a value is present")
    void optional_of_with_value() {
        assertTrue(
                Optional.of("Hi").isPresent(),
                "An Optional.of with a value is present");
    }

    @Test
    @DisplayName("An Optional.of with a false value is present")
    void optional_of_with_false() {
        Optional<Boolean> opt = Optional.of(false);
        assertTrue(opt.isPresent(), "An Optional.of with a false value is present");
        assertFalse(opt.get(), "The value of the Optional remains false");
    }

    @Test
    @DisplayName("An Optional.ofNullable without a value yields the value of the OrElse")
    void optional_ofnullable_yields_orelse() {
        assertEquals(
                "Hi",
                Optional.ofNullable(null).orElse("Hi"),
                "An Optional.ofNullable without a value yields the value of the orElse");
    }

    @Test
    @DisplayName("The value of an Optional is unwrapped")
    void optional_value() {
        Optional<String> opt = Optional.of("Hi");
        assertEquals(
                "Hi",
                opt,
                "The value of an optional is unwrapped");
    }

    @Test
    @DisplayName("A nulled Optional returns its orElse value")
    void optional_orelse_behaviour() {
        Optional<String> opt = Optional.ofNullable(null);
        assertEquals(
                "Hi",
                opt.orElse("Hi"),
                "A nulled Optional returns its orElse value");
    }
}
