def call() {
    pipeline {
        agent any
        stages {
            stage('Even Stage') {
                steps {
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '918d9575-eca1-40b3-9296-9cbf262a05de', url: 'https://github.com/ipsingh12/spring-petclinic.git']]])
                }
            }
        }
    }
}
