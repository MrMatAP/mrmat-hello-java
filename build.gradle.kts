plugins {
    id("java")
    id("pmd")
    id("test-report-aggregation")
    id("jacoco-report-aggregation")
}

group = "org.mrmat.hello.java"

allprojects {
    version = System.getenv("MRMAT_VERSION") ?: "0.0.0-SNAPSHOT"
    repositories {
        mavenCentral()
    }

    // Ensure test tasks only produce JUnit XML (no HTML)
    tasks.withType<Test> {
        reports.html.required = false
    }
}

subprojects {
    plugins.withId("jacoco") {
        tasks.jacocoTestReport {
            reports {
                xml.required = true
                csv.required = true
                html.required = true
            }
        }
    }

    plugins.withId("pmd") {
        pmd {
            isConsoleOutput = true
            rulesMinimumPriority = 5
            ruleSets = listOf("category/java/errorprone.xml", "category/java/bestpractices.xml")
        }
    }
}

dependencies {
    jacocoAggregation(project(":ddd"))
    testReportAggregation(project(":ddd"))
}

tasks.register<DefaultTask>("pr") {
    dependsOn(tasks.named("build"),
        tasks.named("jacocoTestReport"),
        tasks.named("testCodeCoverageReport"),
        tasks.named("testAggregateTestReport"))
}
