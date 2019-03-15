package com.assignment.stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;
import static com.assignment.core.WebDriverInitializer.setUpDriver;

public class Hooks {

    @Before
    public void beforeClass() {
        setUpDriver();
        logger().debug("BEFORE STEP: Maximizing browser window");
        getDriver().manage().window().maximize();
    }

    @After(order = 20000)
    public void afterClass() {
        if (null != getDriver()) {
            logger().debug("AFTER STEP: Closing WebDriver");
            getDriver().close();
            getDriver().quit();
        }
    }

    @After(order = 10000)
    public void takeScreenshotOnFailure(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

    }

}
