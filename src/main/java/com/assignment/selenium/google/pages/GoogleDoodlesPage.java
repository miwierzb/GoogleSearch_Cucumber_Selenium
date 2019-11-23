package com.assignment.selenium.google.pages;

import com.assignment.selenium.BasePage;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;

public class GoogleDoodlesPage extends BasePage {

    private final static String url = "https://www.google.com/doodles/";

    @Override
    public boolean isLoaded() {
        load();
        logger().info("Checking if Google 'Doodles' Page is loaded");
        if (getDriver().getCurrentUrl().contains(url)) {
            logger().info("Google 'Doodles' Page LOADED");
            return true;
        }
        logger().info("Google 'Doodles' Page NOT LOADED");
        return false;
    }

    @Override
    public void load() {
        logger().info("Loading Google 'Doodles' Page...");
        waitForPageToLoad();
    }

}
