package com.assignment.selenium.google.pages;

import com.assignment.selenium.BasePage;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;

public class GoogleAccountsPage extends BasePage {

    private final static String url = "https://accounts.google.com/";

    @Override
    public boolean isLoaded() {
        load();
        logger().info("Checking if Google 'Accounts' Page is loaded");
        if (getDriver().getCurrentUrl().contains(url)) {
            logger().info("Google 'Accounts' Page LOADED");
            return true;
        }
        logger().info("Google 'Accounts' Page NOT LOADED");
        return false;
    }

    @Override
    public void load() {
        logger().info("Loading Google 'Accounts' Page...");
        waitForPageToLoad();
    }

}
