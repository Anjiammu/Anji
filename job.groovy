pipelineJob ('DockerPipeline') {
    description ('This is a seed job and used to create the jobs using dsl script')
    scm {
       github('Anjiammu/Anji', 'master')
         triggers {
             githubPush()
         }
        steps {
        dockerBuildAndPublish {
            repositoryName('anjia324/centosJenkinsImage')
            tag('${BUILD_TIMESTAMP}-${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
    }
}
