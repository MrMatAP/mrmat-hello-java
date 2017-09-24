package org.mrmat.hello.java.java8.optional.test;

import org.junit.Before;
import org.junit.Test;
import org.mrmat.hello.java.java8.optional.Computer;
import org.mrmat.hello.java.java8.optional.Keyboard;
import org.mrmat.hello.java.java8.optional.Mouse;
import org.mrmat.hello.java.java8.optional.USB;

import static org.junit.Assert.assertNotNull;

/**
 * An initial test of how Java 8 Optional works
 *
 * @author imfeldma
 */
public class OptionalTest {

    private Computer computer;

    @Before
    public void setUp() throws Exception {

        Keyboard keyboard = new Keyboard("Apple");
        Mouse mouse = new Mouse("Trackball");
        USB usb = new USB(mouse, keyboard);
        computer = new Computer(usb);
    }

    @Test
    public void succeed_Optional() throws Exception {

        computer.getUsb().ifPresent(usb -> {

            assertNotNull("We have a USB Keyboard", usb.getKeyboard());
            assertNotNull("We have a USB Mouse", usb.getMouse());
        });
    }
}
