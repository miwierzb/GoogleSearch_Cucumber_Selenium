package com.assignment;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@API",
        junit = "--step-notifications",
        plugin = {"pretty", "html:target/Cucumber"},
        features = "src/test/resources/features")
public class CucumberTestRunnerApi {
}

