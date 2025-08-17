plugins {
    id("java")
    id("pmd")
    id("jacoco-report-aggregation")
}

group = "org.mrmat.hello.java"

allprojects {
    version = System.getenv("MRMAT_VERSION") ?: "0.0.0-SNAPSHOT"
    repositories {
        mavenCentral()
    }

    tasks.register<PRTask>("pr") {
        group = "build"
        description = "Builds a PR"
        dependsOn(tasks.named("build"))
        version.convention(
            project.providers.provider { project.version as String }
        )
    }

    tasks.register<ReleaseTask>("release") {
        group = "build"
        description = "Builds a release"
        dependsOn(tasks.named("build"))
        version.convention(
            project.providers.provider { project.version as String }
        )
    }
}

// Make the root 'pr' task depend on each subproject's pmdMain so that PMD runs for PR builds
subprojects {
    plugins.withId("pmd") {
        rootProject.tasks.named("pr") {
            dependsOn(
                tasks.named("pmdMain"),
                tasks.named("pmdTest"))
        }
    }

    rootProject.tasks.named("release") {
        dependsOn(
            tasks.named("pmdMain"),
            tasks.named("pmdTest"))
    }
}

dependencies {
    jacocoAggregation(project(":ddd"))
}

abstract class PRTask : DefaultTask() {
    @get:Input
    abstract val version: Property<String>

    @TaskAction
    fun action() {
        println("Building PR ${ version.get() }")
    }
}

abstract class ReleaseTask : DefaultTask() {
    @get:Input
    abstract val version: Property<String>

    @TaskAction
    fun action() {
        println("Building release ${ version.get() }")
    }
}


