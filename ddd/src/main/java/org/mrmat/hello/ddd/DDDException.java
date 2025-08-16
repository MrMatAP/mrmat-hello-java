package org.mrmat.hello.ddd;

import java.io.Serial;

public class DDDException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public DDDException(String message) {
        super(message);
    }
}
