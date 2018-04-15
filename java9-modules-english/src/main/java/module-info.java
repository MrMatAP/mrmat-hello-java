import org.mrmat.hello.java.modules.api.GreetingProvider;
import org.mrmat.hello.java.modules.impl.english.EnglishGreeting;

/**
 * Java 9 module descriptor for the Greeting API
 *
 * @author imfeldma
 */
module org.mrmat.hello.java.modules.impl.english {

    exports org.mrmat.hello.java.modules.impl.english;
    requires org.mrmat.hello.java.modules.api;

    provides GreetingProvider with EnglishGreeting;
}