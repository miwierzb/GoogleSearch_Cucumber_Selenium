package com.assignment.stepDefinitions;

import com.assignment.core.ScreenShotOnFailure;
import com.assignment.selenium.allegro.pages.AllegroHomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Rule;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;
import static com.assignment.core.WebDriverInitializer.setUpDriver;

public class Hooks {

    @Before
    public static void beforeClass() {
        setUpDriver();
        logger().debug("BEFORE STEP: Maximizing browser window");
        getDriver().manage().window().maximize();
    }

    @After
    public static void afterClass() {
        if (null != getDriver()) {
            logger().debug("AFTER STEP: Closing WebDriver");
            getDriver().close();
            getDriver().quit();
        }
    }

    @Rule
    public ScreenShotOnFailure failure = new ScreenShotOnFailure();

}
