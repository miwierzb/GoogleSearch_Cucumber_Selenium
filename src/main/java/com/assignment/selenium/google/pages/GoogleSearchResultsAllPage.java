package com.assignment.selenium.google.pages;

import com.assignment.selenium.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;

public class GoogleSearchResultsAllPage extends BasePage {

    private final static By selectorSearchResultForm = By.cssSelector("#center_col");
    private final static By selectorSearchResults = By.cssSelector("#search .srg .g");
    private final static By selectorSearchResultsFirstElementTitle = By.cssSelector("#search h3 span");
    private final static By selectorDidNotMatchAnyResultsText = By.cssSelector("#topstuff div:last-child p:first-child");

    @Override
    public boolean isLoaded() {
        load();
        logger().info("Checking if Google All 'Search Results' Page is loaded");
        if (isSearchResultFormDisplayed()) {
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

    private boolean isSearchResultFormDisplayed() {
        logger().info("Checking if Google 'Search Results' Form is displayed");
        return isElementDisplayed(selectorSearchResultForm);
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
        String firstSearchResultTitle = getSearchResultsTitleTexts().get(0);
        logger().info("First item in Search Results Title: " + firstSearchResultTitle);
        return firstSearchResultTitle;
    }

    private ArrayList<String> getSearchResultsTitleTexts() {
        logger().info("Getting list of a Result Titles displayed...");
        ArrayList<String> resultTitlesTexts = new ArrayList<>();
        for (WebElement element : getResultsTitlesWebElements()) {
            resultTitlesTexts.add(element.getText());
        }
        logger().info("Logging found elements: " + resultTitlesTexts);
        return resultTitlesTexts;
    }

    private List<WebElement> getResultsTitlesWebElements() {
        waitForElementToAppear(selectorSearchResultsFirstElementTitle);
        return getDriver().findElements(selectorSearchResultsFirstElementTitle);
    }

    public boolean isAnyMessageDisplayed() {
        logger().info("Checking if there are any messages in search result...");
        return isElementDisplayed(selectorDidNotMatchAnyResultsText);
    }

    public String getSearchResultMessageText() {
        logger().info("Getting Message returned in Search Results...");
        String firstSearchResultTitle = getTextFromElement(selectorDidNotMatchAnyResultsText);
        logger().info("Message in Search Results: " + firstSearchResultTitle);
        return firstSearchResultTitle;
    }

}
