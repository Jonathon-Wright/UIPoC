pipeline {

    agent any

    parameters {
        string(name: 'tests', defaultValue: 'RunCukes', description: 'cucumber tests')
        string(name: 'url', defaultValue: 'https://app.integration1.volo2.com/4303', description: 'integration environment')
        string(name: 'browser', defaultValue: 'headless', description: 'chrome headless')
        string(name: 'sleep', defaultValue: '0', description: 'zero out any sleep commands')
    }


    triggers {
        pollSCM('* * * * *')    //poll the source code repo every minute
    }

    stages {
        stage('Regression') {
            steps {
                bat "mvn -Dtest=${params.tests} test -Durl=${params.url} -Dbrowser=${params.browser} -Dsleep=${params.sleep}"
            }

            post {
                always {
                    publishHTML([
                            allowMissing         : false,
                            alwaysLinkToLastBuild: false,
                            keepAll              : false,
                            reportDir            : 'target/cucumber',
                            reportFiles          : 'index.html',
                            reportName           : 'UI PoC Report',
                            reportTitles         : ''
                    ])
                }
            }

        }
    }

}