package com.assignment.selenium.google.pages;

import com.assignment.selenium.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
    private final static By selectorImFeelingLuckyButton = By.cssSelector("div:not([jsname]) > center > input[value='I'm Feeling Lucky']");
    private final static By selectorGmailLink = By.xpath("//a[text()='Gmail']");
    private final static By selectorSignInButton = By.cssSelector("//a[text()='Sign in']");
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

    public boolean isImFeelingLuckyhButtonDisplayed() {
        logger().info("Checking if 'Google Search' button is displayed");
        return isElementDisplayed(selectorImFeelingLuckyButton);
    }

    public boolean isGmailLinkDisplayed() {
        logger().info("Checking if 'Google Search' button is displayed");
        return isElementDisplayed(selectorGmailLink);
    }

    public boolean isFooterDisplayed() {
        logger().info("Checking if 'Google Search' button is displayed");
        return isElementDisplayed(selectorFooter);
    }

    public GoogleSearchResultsAllPage clickGoogleSearchButton() {
        logger().info("Clicking 'Google Search' button");
        click(selectorGoogleSearchButton);
        return new GoogleSearchResultsAllPage();
    }

    public GoogleAccountsPage clickGmailLink() {
        logger().info("Clicking 'Gmail' link");
        click(selectorGmailLink);
        return new GoogleAccountsPage();
    }

    public GoogleAccountsPage clickSignInButton() {
        logger().info("Clicking 'Sign in' button");
        click(selectorSignInButton);
        return new GoogleAccountsPage();
    }

    public GoogleDoodlesPage clickImFeelingLuckyButton() {
        logger().info("Clicking 'I'm Feeling Lucky' button");
        click(selectorImFeelingLuckyButton);
        return new GoogleDoodlesPage();
    }

    public void enterSearchBoxText(String searchKeyword) {
        logger().info("Entering " + searchKeyword + " into Search Box");
        enterTextToTextField(searchKeyword, selectorSearchBoxTextField);
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