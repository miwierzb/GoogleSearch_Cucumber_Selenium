package com.assignment.cucumberTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Selenium",
        junit = "--step-notifications",
        plugin = {"pretty", "html:target/Cucumber", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
        "json:target/Cucumber/cucumber.json"},
        features = "src/test/resources/features",
        monochrome = true)
public class CucumberTestRunnerSelenium {
}

