package com.assignment.CucumberTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Allegro",
        junit = "--step-notifications",
        plugin = {"pretty", "html:target/Cucumber"},
        features = "src/test/resources/features")
public class CucumberTestRunnerSelenium {
}

