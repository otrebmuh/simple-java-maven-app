/*

https://medium.com/@rosaniline/setup-sonarqube-with-jenkins-declarative-pipeline-75bccdc9075f
https://stackoverflow.com/questions/48557886/how-to-execute-sonarqube-scanner-in-jenkins-declarative-pipeline-without-maven-a

*/
pipeline {
    agent any
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
                SONAR_SCANNER_OPTS = "-Xmx2g -Dsonar.projectKey=Test -Dsonar.login=202b6aef450f839353fc0f087248c4a8a566c9e1 -Dsonar.java.binaries=/var/jenkins_home/workspace/JenkinsSonarqube@2/target/classes"
            } 
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh "export JAVA_HOME=/usr"
                    sh "/var/jenkins_home/sonar-scanner/sonar-scanner-3.3.0.1492-linux/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
                }
            }
        }
    }
}
