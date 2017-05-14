package org.mrmat.hello.java.spring.concurrency;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A basic hello world
 *
 * @author imfeldma
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "spring-concurrency";
    }
}
