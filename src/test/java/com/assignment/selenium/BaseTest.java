package com.assignment.selenium;

import com.assignment.core.ScreenShotOnFailure;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;
import static com.assignment.core.WebDriverInitializer.setUpDriver;

public abstract class BaseTest implements IBaseTest {

    @BeforeClass
    public static void beforeClass() {
        setUpDriver();
        logger().debug("Maximizing browser window");
        getDriver().manage().window().maximize();
    }

    @AfterClass
    public static void afterClass() {
        if (null != getDriver()) {
            logger().debug("Closing WebDriver");
            getDriver().close();
            getDriver().quit();
        }
    }

    @Rule
    public ScreenShotOnFailure failure = new ScreenShotOnFailure();

}
