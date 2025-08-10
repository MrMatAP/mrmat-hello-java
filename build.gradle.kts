plugins {
    id("java")
    id("pmd")
}

group = "org.mrmat.hello.java"

allprojects {
    version = System.getenv("MRMAT_VERSION") ?: "0.0.0-SNAPSHOT"
    repositories {
        mavenCentral()
    }
}

pmd {
    isConsoleOutput = true
    toolVersion = "7.12.0"
    rulesMinimumPriority = 5
    ruleSets = listOf("category/java/errorprone.xml", "category/java/bestpractices.xml")
}
