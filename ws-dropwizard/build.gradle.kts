plugins {
    java
    application
}

group = "org.mrmat.hello.java.ws-dropwizard"

dependencies {
    compileOnly("javax.ws.rs:javax.ws.rs-api:2.1.1")
    compileOnly("io.dropwizard:dropwizard-core:4.0.10")
    testCompileOnly("junit:junit:4.13.2")

    runtimeOnly("io.dropwizard:dropwizard-core:4.0.10")
}

application {
    mainClass = "org.mrmat.hello.java.ws.dropwizard.DWApplication"
}
