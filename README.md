# MrMat :: Hello Java

Experiments in Java

## Java 9 Modules

An example for Java 9 modules, consisting of

* java9-modules-api
* java9-modules-app
* java9-modules-english
* java9-modules-german

Note in `build.gradle` how the testCompile and test tasks must be modified to obtain access to the modules,
which are then discovered at runtime using the ServiceLoader mechanism.

## MrMat :: Hello Java EE :: JAX-WS

Contains a SOAP web service using various ways to represent its input and output
datastructure.

## Java 9 Modules

Find the modules a given jar contains using

```
$ jar -d --file=foo.jar
```