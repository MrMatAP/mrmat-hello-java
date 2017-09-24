package org.mrmat.hello.java.ws.dropwizard.helloworld;

/**
 * A healthcheck for Hello World
 *
 * @author imfeldma
 */
public class HelloWorldHealthCheck extends com.codahale.metrics.health.HealthCheck {

    private final String template;

    public HelloWorldHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }


}
