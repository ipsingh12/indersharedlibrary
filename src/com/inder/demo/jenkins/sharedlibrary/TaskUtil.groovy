package com.inder.demo.jenkins.sharedlibrary;

public class TaskUtil implements  Serializable {

    static def runGradle(script, taskName)
    {
        buildCobaltGradleFile(script)
        script.sh buildCommand(taskName)

    }

    static String buildCommand(taskName)
    {
       return  "/opt/gradle/gradle-3.4.1/bin/gradle -b cobalt.gradle determineVersion"

    }

    private static String buildCobaltGradleFile(script)
    {
        String taskContent= script.libraryResource("/com/inder/sharedlibrary/appDeploy.gradle")
        script.writeFile(file: 'cobalt.gradle',text: taskContent)
    }
}
