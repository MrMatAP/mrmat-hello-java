package org.mrmat.hello.java.ws.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.mrmat.hello.java.ws.dropwizard.helloworld.HelloWorldHealthCheck;
import org.mrmat.hello.java.ws.dropwizard.helloworld.HelloWorldResource;

/**
 * Main Dropwizard Application
 *
 * @author imfeldma
 */
public class DWApplication extends Application<DWConfiguration> {

    public static void main(String[] args) throws Exception {
        new DWApplication().run(args);
    }

    @Override
    public String getName() {
        return "Hello Dropwizard";
    }

    @Override
    public void initialize(Bootstrap<DWConfiguration> bootstrap) {

        super.initialize(bootstrap);
    }

    @Override
    public void run(DWConfiguration configuration, Environment environment) throws Exception {

        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);

        final HelloWorldHealthCheck healthCheck =
                new HelloWorldHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
