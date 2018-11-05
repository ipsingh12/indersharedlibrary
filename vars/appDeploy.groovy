def call(body) {
    def pipelineParams = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()
    pipeline {
        agent any
        stages {
            stage('Checkout') {
                steps {
                    echo "${pipelineParams.inder}"
                    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '918d9575-eca1-40b3-9296-9cbf262a05de', url: 'https://github.com/ipsingh12/spring-petclinic.git']]])
                }
            }
            stage('Determine Version') {
                steps {
                    script {

                    }
                }
            }
        }
    }
}
