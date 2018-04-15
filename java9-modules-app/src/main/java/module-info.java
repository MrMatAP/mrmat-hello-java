import org.mrmat.hello.java.modules.api.GreetingProvider;

/**
 * Java 9 module descriptor for the Greeting application
 *
 * @author imfeldma
 */
module org.mrmat.hello.java.modules.app {

    exports org.mrmat.hello.java.modules.app;
    requires org.mrmat.hello.java.modules.api;

    uses GreetingProvider;
}