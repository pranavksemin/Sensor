pipeline
{
    agent any
    
    tools
    {
        maven "MAVEN"
    }
    
    stages
    {
        stage('Build')
        {
            steps
            {
                sh  "mvn -Dmaven.test.failure.ignore-true clean install"
            }
            post
            {
                success
                {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
            
        }
    }
}
