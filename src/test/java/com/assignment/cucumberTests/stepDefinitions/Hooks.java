package com.assignment.cucumberTests.stepDefinitions;

import com.assignment.core.SharedTestData;
import com.assignment.cucumberTests.stepDefinitions.seleniumStepDefinitions.GoogleStepData;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;
import static com.assignment.core.WebDriverInitializer.setUpDriver;

public class Hooks {

    private GoogleStepData googleStepData;

    public Hooks(GoogleStepData googleStepData) {
        this.googleStepData = googleStepData;
    }

    @Before
    public void beforeClass() {
        googleStepData.sharedTestData = new SharedTestData();
    }

    @Before("@API")
    public void beforeClassAPI() {
        LogManager.getRootLogger().setLevel(Level.INFO);
    }

    @Before("@Selenium")
    public void beforeClassSelenium() {
        setUpDriver();
        logger().debug("BEFORE STEP: Maximizing browser window");
        getDriver().manage().window().maximize();
    }

    @After(value = "@Selenium", order = 10000)
    public void afterClassSelenium() {
        if (null != getDriver()) {
            logger().debug("AFTER STEP: Closing WebDriver");
            getDriver().close();
            getDriver().quit();
        }
    }

    @After(value = "@Selenium", order = 20000)
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }

}
