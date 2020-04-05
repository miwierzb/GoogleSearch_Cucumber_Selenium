package com.assignment.selenium.google.modules;

import com.assignment.selenium.BasePage;
import com.assignment.selenium.google.pages.GoogleSearchResultsAllPage;
import com.assignment.selenium.google.pages.GoogleSearchResultsImagesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;

public class GoogleSearchResultTopMenuBar extends BasePage {

    private final static By selectorSearchForm = By.cssSelector("#searchform");
    private final static By selectorSearchBoxTextField = By.cssSelector("input[title='Search']");
    private final static By selectorMagnifierButton = By.cssSelector("button[aria-label='Google Search']");
    private final static By selectorBookmarksBar = By.cssSelector("#hdtb-msb");
    private final static By selectorBookmarksTabs = By.xpath("//div[@id='hdtb-msb-vis']//*[text()]");
    private final static By selectorImagesTab = By.xpath("//div[@role='navigation']//*[text()='Images']");
    private final static By getSelectorSearchBoxDropdown = By.cssSelector("[role='listbox']");

    @Override
    public boolean isLoaded() {
        load();
        logger().info("Checking if Google Search Result Top Menu Bar is loaded");
        if (isSearchFormDisplayed()) {
            logger().info("Google Search Result Top Menu Bar LOADED");
            return true;
        }
        logger().info("Google Search Result Top Menu Bar NOT LOADED");
        return false;
    }

    @Override
    public void load() {
        logger().info("Loading Google Search Result Top Menu Bar...");
        waitForPageToLoad();
    }

    private boolean isSearchFormDisplayed() {
        logger().info("Checking if Search Form is displayed");
        return isElementDisplayed(selectorSearchForm);
    }

    public boolean isBookmarksBarDisplayed() {
        logger().info("Checking if Bookmarks Bar is displayed");
        return isElementDisplayed(selectorBookmarksBar);
    }

    public void enterSearchBoxText(String searchText) {
        logger().info("Entering " + searchText + " into Search Box");
        enterTextToTextField(searchText, selectorSearchBoxTextField);
        waitForElementToAppearNoException(getSelectorSearchBoxDropdown);
    }

    public GoogleSearchResultsAllPage clickMagnifierButton() {
        logger().info("Clicking 'Magnifier' button");
        click(selectorMagnifierButton);
        return new GoogleSearchResultsAllPage();
    }

    public GoogleSearchResultsImagesPage clickImagesTab() {
        logger().info("Clicking 'Images' Tab");
        click(selectorImagesTab);
        return new GoogleSearchResultsImagesPage();
    }

    public ArrayList<String> getBookmarksBarTabsTexts() {
        logger().info("Getting list of a Bookmarks Bar Tabs displayed...");
        ArrayList<String> bookmarksBarTabsTexts = new ArrayList<>();
        for (WebElement element : getBookmarksBarWebElements()) {
            bookmarksBarTabsTexts.add(element.getText());
        }
        logger().info("Logging found elements: " + bookmarksBarTabsTexts);
        return bookmarksBarTabsTexts;
    }

    private List<WebElement> getBookmarksBarWebElements() {
        waitForElementToAppear(selectorBookmarksTabs);
        return getDriver().findElements(selectorBookmarksTabs);
    }


}
