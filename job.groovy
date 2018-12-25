freeStyleJob ('JenkinsTest') {
    description ('This is a seed job and used to create the jobs using dsl script')
    scm {
       github('Anjiammu/Anji', 'master')
         triggers {
             githubPush()
            publishers {
                archieveArtifacts('build/**/*.html')
            }
        }
    }
}
