package org.mrmat.hello.java.java8.optional;

/**
 * A model of a USB bus
 *
 * @author imfeldma
 */
public class USB {

    private Mouse mouse;
    private Keyboard keyboard;

    public USB(Mouse mouse, Keyboard keyboard) {
        this.mouse = mouse;
        this.keyboard = keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
}
