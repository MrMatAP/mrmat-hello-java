package org.mrmat.hello.java.ws.dropwizard.helloworld;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * A representation class for a Saying
 *
 * @author imfeldma
 */
public class HelloWorldSaying {

    private long id;

    @Length(max = 3)
    private String content;

    public HelloWorldSaying() {
        // Jackson deserialization
    }

    public HelloWorldSaying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
