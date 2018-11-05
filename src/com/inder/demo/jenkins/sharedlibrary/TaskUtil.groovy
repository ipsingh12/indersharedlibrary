package com.inder.demo.jenkins.sharedlibrary;

public class TaskUtil implements  Serializable {

    static def runGradle(script, taskName,taskArguments =[:])
    {
        buildCobaltGradleFile(script)
        script.sh buildCommand(taskName,taskArguments)

    }

    static String buildCommands(taskName, taskArguments =[:])
    {
       return  "/opt/gradle/gradle-3.4.1/bin/gradle -b cobalt.gradle DetermineVersionTask"

    }

    private static String buildCobaltGradleFile(script)
    {
        String taskContent= script.libraryResource("/com/inder/cobalt/jenkins/sharedlibrary/appDeploy.gradle")
        script.writeFile(file: 'cobalt.gradle',text: taskContent)
    }
}
