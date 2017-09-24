package org.mrmat.hello.java.java8.optional;

import java.util.Optional;

/**
 * A model of a computer
 *
 * @author imfeldma
 */
public class Computer {

    private USB usb;

    public Computer() { /* default empty constructor */ }
    public Computer(USB usb) {
        this.usb = usb;
    }

    public Optional<USB> getUsb() {
        return Optional.of(usb);
    }

    public void setUsb(USB usb) {
        this.usb = usb;
    }
}
