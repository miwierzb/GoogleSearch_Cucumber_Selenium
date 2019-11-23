package com.assignment.selenium.google.modules;

import com.assignment.selenium.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;

public class GoogleSearchResultTopMenuBar extends BasePage {

    private final static By selectorFiltersModule = By.cssSelector("[data-box-name='filters container']");
    private final static By selectorFilterPojemnoscDyskuText = By.xpath("//*[@data-box-name='filters container']//*[contains(text(), 'Pojemność dysku')]");
    private final static By selectorFilterPojemnoscDyskuFromTextBox = By.cssSelector("#pojemnosc-dysku-od");
    private final static By selectorFilterPojemnoscDyskuToTextBox = By.cssSelector("#pojemnosc-dysku-do");
    //private final static By selectorAppliedFilterField = By.cssSelector("li[title]");
    private final static By selectorAppliedFilterField = By.xpath("//*[@class='opbox-listing-chips']//*[div[text()]]");

    @Override
    public boolean isLoaded() {
        load();
        logger().info("Checking if Allegro 'Search Filters' Module is loaded");
        if (getDriver().findElement(selectorFiltersModule).isDisplayed()) {
            logger().info("'Search Filters' Module LOADED");
            return true;
        }
        logger().info("'Search Filters' Module NOT LOADED");
        return false;
    }

    @Override
    public void load() {
        logger().info("Loading Allegro 'Search Filters' Module...");
        waitForPageToLoad();
    }

    public boolean isFilterPojemnoscDyskuDisplyed() {
        logger().info("Checking if filter 'Pojemnosc dysku' is displayed");
        return isElementDisplayed(selectorFilterPojemnoscDyskuText);
    }

    public void enterFilterPojemnoscDyskuFromText(String from) {
        logger().info("Entering " + from + " in 'Pojemnosc dysku' FROM textbox");
        enterTextToTextField(from, selectorFilterPojemnoscDyskuFromTextBox);
        waitForPageToLoad();
    }

    public void enterFilterPojemnoscDyskuToText(String to) {
        logger().info("Entering " + to + " in 'Pojemnosc dysku' TO textbox");
        enterTextToTextField(to, selectorFilterPojemnoscDyskuToTextBox);
        waitForPageToLoad();
    }

    public String getChosenAppliedFiltersText(int filterNumber) {
        logger().info("Getting text from filter " + filterNumber);
        String text = getAppliedFiltersTexts().get(filterNumber);
        logger().info("Found text: " + text);
        return text;
    }

    private ArrayList<String> getAppliedFiltersTexts() {
        logger().info("Getting applied filters list...");
        ArrayList<String> appliedFiltersTexts = new ArrayList<>();
        for (WebElement element : getAppliedFiltersWebElements()) {
            appliedFiltersTexts.add(element.getText());
        }
        logger().info("Logging found elements: " + appliedFiltersTexts);
        return appliedFiltersTexts;
    }

    private List<WebElement> getAppliedFiltersWebElements() {
        waitForElementToAppear(selectorAppliedFilterField);
        return getDriver().findElements(selectorAppliedFilterField);
    }

}
