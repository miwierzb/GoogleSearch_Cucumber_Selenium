package com.assignment.selenium.google.pages;

import com.assignment.selenium.BasePage;
import org.openqa.selenium.By;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;

public class GoogleSearchResultsAllPage extends BasePage {

    private final static By selectorSearchResultForm = By.cssSelector("#search");
    private final static By selectorSearchResults = By.cssSelector("#search .srg .g");
    private final static By selectorSearchResultsFirstElementTitle = By.cssSelector("#search h3 span");

    @Override
    public boolean isLoaded() {
        load();
        logger().info("Checking if Google All 'Search Results' Page is loaded");
        if (getDriver().findElement(selectorSearchResultForm).isDisplayed()) {
            logger().info("'Google All 'Search Results' Page LOADED");
            return true;
        }
        logger().info("Google All 'Search Results' Page NOT LOADED");
        return false;
    }

    @Override
    public void load() {
        logger().info("Loading/Reloading Google All 'Search Results' Page...");
        waitForPageToLoad();
    }

    public boolean isAnySearchResultDisplayed() {
        logger().info("Checking if there are items in search result...");
        waitForElementToAppearNoException(selectorSearchResults);
        if (!getDriver().findElements(selectorSearchResults).isEmpty()) {
            logger().info("Search Result Items found");
            return true;
        } else {
            logger().info("Search Result Items NOT found");
            return false;
        }
    }

    public String getSearchResultFirstTitle() {
        logger().info("Getting Title of first item returned in Search Results...");
        return getTextFromElement(selectorSearchResultsFirstElementTitle);
    }

}
