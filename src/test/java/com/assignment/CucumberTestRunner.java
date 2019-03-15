package com.assignment;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        junit = "--step-notifications",
        plugin = {"pretty" , "html:target/Cucumber"},
        features="src/test/java/com/assignment/features")
public class CucumberTestRunner {
}

