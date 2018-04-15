import org.mrmat.hello.java.modules.api.GreetingProvider;
import org.mrmat.hello.java.modules.impl.german.GermanGreeting;

/**
 * Java 9 module descriptor for the Greeting API
 *
 * @author imfeldma
 */
module org.mrmat.hello.java.modules.impl.german {
    requires org.mrmat.hello.java.modules.api;

    exports org.mrmat.hello.java.modules.impl.german;

    provides GreetingProvider with GermanGreeting;
}