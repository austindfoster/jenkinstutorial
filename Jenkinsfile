pipeline {
  environment {
    registry = "frostiflake/calculator-app"
    registryCredential = 'dockerhub'
    dockerImage = ''
  }

  agent any

  tools {
     maven 'apache maven 3.6.3'
     jdk 'JDK 8'
  }

  stages {

     stage ('Clean') {
          steps {
              sh 'mvn clean'
          }
      }

      stage ('Build') {
          steps {
              sh 'mvn compile'
          }
      }

      stage ('Short Tests') {
          steps {
              sh 'mvn -Dtest=CalculatorTest test'
          }
      }

      stage ('Long Tests') {
          steps {
              sh 'mvn -Dtest=CalculatorTestThorough test'
          }
          post {
              success {
                  junit 'target/surefire-reports/**/*.xml'
              }
          }
      }

      stage ('Package') {
          steps {
              sh 'mvn package'
              archiveArtifacts artifacts: 'src/**/*.java'
              archiveArtifacts artifacts: 'target/*.jar'
          }
      }

      stage('Building image') {
        steps{
          echo 'buiding image :)'
          script {
            dockerImage = docker.build registry + ":$BUILD_NUMBER"
          }
          echo 'image built'
        }
      }

      stage('Deploy Image') {
        steps{
          echo 'deploying image :)'
          script {
            docker.withRegistry( 'https://hub.docker.com/repository/docker/frostiflake/calculator-app', registryCredential ) {
              dockerImage.push()
            }
          }
        }
      }
      
      stage('Remove Unused docker image') {
          steps{
            sh "docker rmi $registry:$BUILD_NUMBER"
          }
        }
      }
}

post {
  failure {
    mail to: 'austin.foster914@gmail.com',
      subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
      body: "Something is wrong with ${env.BUILD_URL}"
  }
}

