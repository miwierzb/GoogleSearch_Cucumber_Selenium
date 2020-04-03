package com.assignment.selenium.google.pages;

import com.assignment.selenium.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;

public class GoogleSearchResultsImagesPage extends BasePage {

    private final static By selectorSearchResultForm = By.cssSelector("#islrg");
    private final static By selectorSearchResultsImages = By.cssSelector("#islrg img:not([data-src])");
    private final static By selectorImageSearchResultsFirstElementTitle = By.xpath("//*[@id='islrg']//a[@target]//*[text()]");

    @Override
    public boolean isLoaded() {
        load();
        logger().info("Checking if Google Images 'Search Results' Page is loaded");
        if (isImagesSearchResultFormDisplayed()) {
            logger().info("'Google All 'Search Results' Page LOADED");
            return true;
        }
        logger().info("Google Images 'Search Results' Page NOT LOADED");
        return false;
    }

    @Override
    public void load() {
        logger().info("Loading/Reloading Google Images 'Search Results' Page...");
        waitForPageToLoad();
    }

    private boolean isImagesSearchResultFormDisplayed() {
        logger().info("Checking if Google Images 'Search Results' Form is displayed");
        return isElementDisplayed(selectorSearchResultForm);
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

    public String getSearchResultImagesFirstTitle() {
        logger().info("Getting Title of first image item returned in Image Search Results...");
        String firstImagesSearchResultTitle = getImagesTitlesTexts().get(0);
        logger().info("First item in Image Search Results Title: " + firstImagesSearchResultTitle);
        return firstImagesSearchResultTitle;
    }

    private ArrayList<String> getImagesTitlesTexts() {
        logger().info("Getting list of a Image Titles displayed...");
        ArrayList<String> imagesTitlesTexts = new ArrayList<>();
        for (WebElement element : getImagesTitlesWebElements()) {
            imagesTitlesTexts.add(element.getText());
        }
        logger().info("Logging found elements: " + imagesTitlesTexts);
        return imagesTitlesTexts;
    }

    private List<WebElement> getImagesTitlesWebElements() {
        waitForElementToAppear(selectorImageSearchResultsFirstElementTitle);
        return getDriver().findElements(selectorImageSearchResultsFirstElementTitle);
    }

}
