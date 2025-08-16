package org.mrmat.hello.ddd;

import java.io.Serial;

public class EntityInvariantException extends DDDException {

    @Serial
    private static final long serialVersionUID = 1L;

    public EntityInvariantException(String message) {
        super(message);
    }
}
