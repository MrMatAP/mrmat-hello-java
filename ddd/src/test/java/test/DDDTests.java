package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mrmat.hello.ddd.DDDException;
import org.mrmat.hello.ddd.EntityInvariantException;


class DDDTests {

    @Test
    void recognizesDDDException() {
        assertThrows(DDDException.class, () -> {
            throw new DDDException("Test Exception");
        }, "We recognize a DDDException");
    }

    @Test
    void recognizesEntityInvariantException() {
        assertThrows(EntityInvariantException.class, () -> {
            throw new EntityInvariantException("Test Exception");
        }, "We recognize an EntityInvariantException");
    }
}
