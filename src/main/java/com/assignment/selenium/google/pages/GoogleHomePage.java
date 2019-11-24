package com.assignment.selenium.google.pages;

import com.assignment.selenium.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;

public class GoogleHomePage extends BasePage {

    private final static By selectorGoogleLogo = By.cssSelector("#hplogo");
    private final static By selectorSearchBox = By.cssSelector("#searchform");
    private final static By selectorSearchBoxTextField = By.cssSelector("input[title='Search']");
    private final static By selectorFooter = By.cssSelector("#footer");
    private final static By selectorFooterLinksTexts = By.cssSelector("#fsl>a[href]");
    private final static By selectorGoogleSearchButton = By.cssSelector("div:not([jsname]) > center > input[value='Google Search']");
    private final static By selectorGoogleSearchDropdownButton = By.cssSelector("div[jsname] input[value='Google Search']");
    private final static By selectorImFeelingLuckyButton = By.cssSelector("div:not([jsname]) > center > input[value=\"I'm Feeling Lucky\"]");
    private final static By selectorImFeelingLuckyDropdownButton = By.cssSelector("div[jsname] input[value=\"I'm Feeling Lucky\"]");
    private final static By selectorSignInButton = By.xpath("//a[text()='Sign in']");
    private final static By getSelectorSearchBoxDropdown = By.cssSelector("[role='listbox']");
    private final static String url = "https://www.google.com/";

    @Override
    public boolean isLoaded() {
        logger().info("Checking if Google 'Home' Page is loaded");
        if (getDriver().getCurrentUrl().equals(url)) {
            logger().info("Google 'Home' Page LOADED");
            return true;
        }
        logger().info("Google 'Home' Page NOT LOADED");
        return false;
    }

    @Override
    public void load() {
        logger().info("Loading Google 'Home' Page...");
        getDriver().get(url);
        waitForPageToLoad();
    }

    public boolean isGoogleLogoDisplayed() {
        logger().info("Checking if Google Logo is displayed");
        return isElementDisplayed(selectorGoogleLogo);
    }

    public boolean isGoogleHomeSearchBoxDisplayed() {
        logger().info("Checking if Google Search Box is displayed");
        return isElementDisplayed(selectorSearchBox);
    }

    public boolean isGoogleSearchButtonDisplayed() {
        logger().info("Checking if 'Google Search' button is displayed");
        return isElementDisplayed(selectorGoogleSearchButton);
    }

    public boolean isImFeelingLuckyButtonDisplayed() {
        logger().info("Checking if 'I'm Feeling Lucky' button is displayed");
        return isElementDisplayed(selectorImFeelingLuckyButton);
    }

    public boolean isFooterDisplayed() {
        logger().info("Checking if Footer is displayed");
        return isElementDisplayed(selectorFooter);
    }

    public GoogleSearchResultsAllPage clickGoogleSearchButton() {
        logger().info("Clicking 'Google Search' button");
        try {
            click(selectorGoogleSearchButton);
        } catch (WebDriverException ex) {
            logger().info("'Google Search' button not clickable");
            logger().info("Clicking 'Google Search' button from search box dropdown");
            click(selectorGoogleSearchDropdownButton);
        }
        return new GoogleSearchResultsAllPage();
    }

    public GoogleSearchResultsAllPage clickEnterKey() {
        logger().info("Clicking 'Enter' key");
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.ENTER).perform();
        return new GoogleSearchResultsAllPage();
    }

    public GoogleAccountsPage clickSignInButton() {
        logger().info("Clicking 'Sign in' button");
        click(selectorSignInButton);
        return new GoogleAccountsPage();
    }

    public GoogleDoodlesPage clickImFeelingLuckyButton() {
        logger().info("Clicking 'I'm Feeling Lucky' button");
        try {
            click(selectorImFeelingLuckyButton);
        } catch (WebDriverException ex) {
            logger().info("'I'm Feeling Lucky' button not clickable");
            logger().info("Clicking 'I'm Feeling Lucky' button from search box dropdown");
            click(selectorImFeelingLuckyDropdownButton);
        }
        return new GoogleDoodlesPage();
    }

    public void enterSearchBoxText(String searchText) {
        logger().info("Entering " + searchText + " into Search Box");
        enterTextToTextField(searchText, selectorSearchBoxTextField);
        waitForElementToAppearNoException(getSelectorSearchBoxDropdown);
    }

    public ArrayList<String> getFooterLinksTexts() {
        logger().info("Getting list of a Footer links displayed...");
        ArrayList<String> footerLinksTexts = new ArrayList<>();
        for (WebElement element : getFooterLinksWebElements()) {
            footerLinksTexts.add(element.getText());
        }
        logger().info("Logging found elements: " + footerLinksTexts);
        return footerLinksTexts;
    }

    private List<WebElement> getFooterLinksWebElements() {
        waitForElementToAppear(selectorFooterLinksTexts);
        return getDriver().findElements(selectorFooterLinksTexts);
    }

}