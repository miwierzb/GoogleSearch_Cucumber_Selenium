package com.assignment.selenium.allegro.modules;

import com.assignment.selenium.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;

public class AllegroSearchResults extends BasePage {

    private final static By selectorSearchModule = By.cssSelector("[data-box-name='items container']");
    private final static By selectorFilterSortowanieBox = By.cssSelector("[data-box-name='sorting']");
    private final static By selectorFilterSortowanieDropdown = By.cssSelector("[data-box-name='sorting'] select");
    private final static By selectorNoSponsoredPriceText = By.xpath("//article[not(@data-analytics-view-label" +
            "='showSponsoredItems')]//*[@class='fee8042']");
    private final static By selectorNoSponsoredDiskCapacityText = By.xpath("//article[not(@data-analytics-view-label" +
            "='showSponsoredItems')]//*[dd]/*[contains(text(),'GB')]");
    private final static By selectorLoadingSpinner = By.cssSelector(".a81d4a1");
    private final static By selectorSearchResultItems = By.cssSelector("article[data-item='true']");

    @Override
    public boolean isLoaded() {
        load();
        logger().info("Checking if Allegro 'Search Results' Module is loaded");
        if (getDriver().findElement(selectorSearchModule).isDisplayed()) {
            logger().info("'Search Results' Module LOADED");
            return true;
        }
        logger().info("'Search Results' Module NOT LOADED");
        return false;
    }

    @Override
    public void load() {
        logger().info("Loading/Reloading Allegro 'Search Results' Module...");
        waitForPageToLoad();
        waitForElementToDisappearNoException(selectorLoadingSpinner);
    }

    public boolean isFilterSortowanieDisplayed() {
        logger().info("Checking if Filter 'Sortowanie' is displayed");
        return isElementDisplayed(selectorFilterSortowanieBox);
    }

    public void selectOptionFromSortowanieDropdown(String optionToSelect) {
        logger().info("Selecting option with '" + optionToSelect + "' value from 'Sortowanie' dropdown");
        selectOptionFromDropdownByValue(optionToSelect, selectorFilterSortowanieDropdown);
        load();
    }

    public ArrayList<String> getSearchResultsPricesTexts() {
        logger().info("Getting prices displayed in search results list...");
        ArrayList<String> searchResultsPricesTexts = new ArrayList<>();
        for (WebElement element : getPricesWebElements()) {
            searchResultsPricesTexts.add(element.getText());
        }
        logger().info("Logging found elements: " + searchResultsPricesTexts);
        return searchResultsPricesTexts;
    }

    private List<WebElement> getPricesWebElements() {
        waitForElementToAppear(selectorNoSponsoredPriceText);
        return getDriver().findElements(selectorNoSponsoredPriceText);
    }

    public ArrayList<String> getSearchResultsDiskCapacityTexts() {
        logger().info("Getting discs capacities displayed in search results list...");
        ArrayList<String> searchResultsDiskCapacityTexts = new ArrayList<>();
        for (WebElement element : getDiscCapacityWebElements()) {
            searchResultsDiskCapacityTexts.add(element.getText());
        }
        logger().info("Logging found elements: " + searchResultsDiskCapacityTexts);
        return searchResultsDiskCapacityTexts;
    }

    private List<WebElement> getDiscCapacityWebElements() {
        waitForElementToAppear(selectorNoSponsoredDiskCapacityText);
        return getDriver().findElements(selectorNoSponsoredDiskCapacityText);
    }

    public boolean isAnyResultDisplayed() {
        logger().info("Checking if there are items in search result...");
        waitForElementToAppearNoException(selectorSearchResultItems);
        if (!getDriver().findElements(selectorSearchResultItems).isEmpty()) {
            logger().info("Items found");
            return true;
        } else {
            logger().info("Items NOT found");
            return false;
        }
    }

}
