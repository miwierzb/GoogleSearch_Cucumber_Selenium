package com.assignment.selenium.google.pages;

import com.assignment.selenium.BasePage;
import org.openqa.selenium.By;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;

public class GoogleSearchResultsImagesPage extends BasePage {

    private final static By selectorSearchResultForm = By.cssSelector("#search");
    private final static By selectorSearchResultsImages = By.cssSelector("#search img:not([data-src])");

    @Override
    public boolean isLoaded() {
        load();
        logger().info("Checking if Google Images 'Search Results' Page is loaded");
        if (getDriver().findElement(selectorSearchResultForm).isDisplayed()) {
            logger().info("'Google All 'Search Results' Page LOADED");
            return true;
        }
        logger().info("Google Images 'Search Results' Page NOT LOADED");
        return false;
    }

    @Override
    public void load() {
        logger().info("Loading/Reloading Google Images 'Search Results' Pag...");
        waitForPageToLoad();
    }

    public boolean isAnySearchResultImageDisplayed() {
        logger().info("Checking if there are items in search result images...");
        waitForElementToAppearNoException(selectorSearchResultsImages);
        if (!getDriver().findElements(selectorSearchResultsImages).isEmpty()) {
            logger().info("Search Result Images Items found");
            return true;
        } else {
            logger().info("Search Result Images Items NOT found");
            return false;
        }
    }

}
