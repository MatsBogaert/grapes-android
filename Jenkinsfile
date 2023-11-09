pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                script {
                    checkout scm
                }
            }
        }
        
        
        stage('Push to Docker Hub') {
            steps {
                script {
                    docker.build('your-android-image:latest', '.')
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                        docker.image('your-android-image:latest').push()
                    }
                }
            }
        }
    }
}