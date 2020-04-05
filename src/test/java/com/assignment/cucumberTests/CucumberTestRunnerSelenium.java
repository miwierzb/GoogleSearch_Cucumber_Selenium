package com.assignment.cucumberTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Selenium",
        stepNotifications = true,
        plugin = {"pretty", "html:target/Cucumber", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
        "json:target/Cucumber/cucumber.json"},
        features = "src/test/resources/features",
        monochrome = true)
public class CucumberTestRunnerSelenium {
}

