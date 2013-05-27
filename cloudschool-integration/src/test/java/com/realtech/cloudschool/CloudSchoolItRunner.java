package com.realtech.cloudschool;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@Cucumber.Options(format = { "html:target/cucumber" }, strict = true)
public class CloudSchoolItRunner {
}