pipeline {
    agent none
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') {
            agent {
                docker {
                    image 'maven:3-alpine'
                    args '-v /root/.m2:/root/.m2'
                }
            }
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }        
        stage('Sonarqube analysis') {
            environment {
                SONAR_SCANNER_OPTS = "-Xmx2g"
            } 
            steps {
                sh "pwd"
                sh "/var/jenkins_home/sonar-scanner/sonar-scanner-3.3.0.1492-linux/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
            }
        }
    }
}
