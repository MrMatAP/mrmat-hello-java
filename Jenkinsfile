#!/usr/bin/env groovy
/**
 * A scripted pipeline to build mrmat-hello-java
 * TODO: Get Gradle from the path, including its environment
 * TODO: SonarQube, with its environment
 */

try {

    properties(
            [[$class: 'BuildDiscarderProperty',
              strategy: [$class: 'LogRotator', numToKeepStr: '10']]]
    )

    node {
        stage '\u2776 Prepare'
        echo "\u27A1 BUILD_URL=${env.BUILD_URL}"
        echo "\u27A1 BUILD_CAUSE=${env.BUILD_CAUSE}"
        echo "\u27A1 WORKSPACE=${env.WORKSPACE}"
        checkout scm

        stage '\u2776 Build'
        sh './gradlew clean build'

        //stage '\u2776 Test'
        //junit 'build/test-results/**/TEST-*.xml'

        stage '\u2776 Deploy'
        archiveArtifacts artifacts: '**/build/libs/*.war', fingerprint: true

        stage '\u2776 Cleanup'
        deleteDir()
    }


} catch(ex) {

    currentBuild.result = 'FAILURE'
    echo "Caught exception: ${ex.getMessage()}"

} finally {

    (currentBuild.result != 'ABORTED') && node('master') {
        // Do some stuff on the master node, if required
    }

    //
    // Propagate the error if required

    //if(ex) throw ex
}
