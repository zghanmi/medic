pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    } 
    stages {
        stage('Build') {
            steps {
				sh 'chmod +x gradlew'
                sh './gradlew assemble'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh './gradlew docker'
            }
        }
        stage('Test') {
        	environement {
        		DOCKER_HUB_LOGIN = credentials('docker-hub')
        	}
            steps {
            	sh 'docker login --username=$DOCKER_HUB_LOGIN_USR -- password=$DOCKER_HUB_LOGIN_PSW'
                sh './gradlew dockerPush'
            }
        }
    }
}
