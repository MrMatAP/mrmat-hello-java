#!groovy

pipeline {
    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '10'))
        disableConcurrentBuilds()
    }

    parameters {
        booleanParam(name: 'RELEASE_BUILD', defaultValue: false, description: 'Will this be a release build then, sir?')
    }

    tools {
        gradle 'gradle-3.5'
        jdk 'jdk-1.8'
    }

    stages {

        stage('QA Gate') {
            steps {
                slackSend botUser: true, message: "QA Gate Started - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
                withSonarQubeEnv('jenkins-sonar') {
                    sh "gradle clean build sonar"
                }
                script {
                    timeout(time: 1, unit: 'HOURS') {
                        def qg = waitForQualityGate()
                        if(qg.status != 'OK') {
                            error "Pipeline aborted due to quality gate failure: ${qg.status}"
                            slackSend botUser: true, message: "QA Gate FAILED - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
                        }
                    }
                }
            }
        }
        stage('\uD83D\uDEE0 Build') {
            when { expression { return ! params.RELEASE_BUILD } }
            steps {
                slackSend botUser: true, message: "Build Started - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
                ansiColor('xterm') {
                    gradleBuild(this, "clean build")
                }
                script {
                    currentBuild.displayName = "${currentBuild.number}: \uD83D\uDEE0 Build ${gradleBuild.version}"
                }
            }
        }
        stage('\uD83C\uDF81 Release') {
            when { expression { return (params.RELEASE_BUILD && (env.BRANCH_NAME == 'develop')) } }
            steps {
                slackSend botUser: true, message: "Release Started - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
                ansiColor('xterm') {
                    sh "git checkout -f develop"
                    gradleBuild(this, "final")
                    sh "git checkout -f master && git merge develop && git push"
                }
                script {
                    currentBuild.displayName = "${currentBuild.number}: \uD83C\uDF81 Release ${gradleBuild.version}"
                    keepBuild(true)
                }
            }
        }

    }
    post {
        always {
            junit 'target/surefire-reports/*.xml'
            archive 'target/mrmat-test-maven-project-*.jar'
            deleteDir()
        }
        success {
            echo "Build is a SUCCESS"
            slackSend botUser: true, message: "Build SUCCESS - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
        }
        failure {
            echo "Build is a FAILURE"
            slackSend botUser: true, message: "Build FAILED - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
        }
    }
}
