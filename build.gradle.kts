plugins {
    java
    id("org.sonarqube") version "5.0.0.4638"
    id("nebula.release") version "19.0.7"
}

group = "org.mrmat.hello.java"

allprojects {
    repositories {
        mavenCentral()
    }
}


//sonarqube {
//    properties {
//        property "sonar.sourceEncoding", "UTF-8"
//    }
//}

//nebulaRelease.addReleaseBranchPattern(/develop/)
