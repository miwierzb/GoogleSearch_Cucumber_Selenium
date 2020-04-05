package com.assignment.core;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static com.assignment.core.CustomLogger.logger;

public class WebDriverInitializer {

    private static final String WEB_DRIVER = PropertiesManager.getProperty("selenium.webdriver");
    private static WebDriver wb_driver;
    private static EventFiringWebDriver driver;
    private static WebEventListener webEventListener;

    public static void setUpDriver() {
        System.setProperty("webdriver." + WEB_DRIVER + ".driver", "./webDrivers/" + WEB_DRIVER + "driver.exe");
        logger().debug("Creating new " + WEB_DRIVER + " instance");
        switch (WEB_DRIVER) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--lang=en-GB");
                //chromeOptions.setHeadless(true);
                wb_driver = new ChromeDriver(chromeOptions);
                break;
            case "gecko":
                FirefoxProfile ffProfile = new FirefoxProfile();
                ffProfile.setPreference("intl.accept_languages", "en-GB");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(ffProfile);
                wb_driver = new FirefoxDriver(firefoxOptions);
                break;
            case "default":
                logger().debug("Wrong test data for selenium.webdriver");
        }
        driver = new EventFiringWebDriver(wb_driver);
        webEventListener = new WebEventListener();
        driver.register(webEventListener);
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
