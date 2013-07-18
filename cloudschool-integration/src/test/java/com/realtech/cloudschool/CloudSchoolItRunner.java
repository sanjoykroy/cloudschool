package com.realtech.cloudschool;

import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.Runtime;
import cucumber.runtime.io.MultiLoader;

public class CloudSchoolItRunner {

    public static void main(String[] args) throws Throwable {
        RuntimeOptions runtimeOptions = new RuntimeOptions(System.getProperties(), args);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Runtime runtime = new Runtime(new MultiLoader(classLoader), classLoader, runtimeOptions);
        runtime.writeStepdefsJson();
        runtime.run();
        System.exit(runtime.exitStatus());
    }
}