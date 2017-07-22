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
                    sh 'gradle clean package sonar:sonar'
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
                    sh 'gradle clean build'
                }
				/*
                script {
                    def pom = readMavenPom file: "${env.WORKSPACE}/pom.xml"
                    currentBuild.displayName = "${currentBuild.number}: \uD83D\uDEE0 Build ${pom.version}"
                }
                */
            }
        }
        stage('\uD83C\uDF81 Release') {
            when { expression { return (params.RELEASE_BUILD && (env.BRANCH_NAME == 'develop')) } }
            steps {
                slackSend botUser: true, message: "Release Started - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
                ansiColor('xterm') {
                    sh "git checkout -f develop"
                    //sh 'mvn -B jgitflow:release-start jgitflow:release-finish && git push --tags origin master develop'
                    //sh "git checkout -f master"
                    //sh 'mvn site site:deploy'
                }
                /*
                script {
                    def pom = readMavenPom file: "${env.WORKSPACE}/pom.xml"
                    currentBuild.displayName = "${currentBuild.number}: \uD83C\uDF81 Release ${pom.version}"
                    currentBuild.rawBuild.keepLog(true)
                }
                */
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