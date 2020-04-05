package com.assignment.cucumberTests.stepDefinitions.seleniumStepDefinitions.google;

import com.assignment.cucumberTests.stepDefinitions.seleniumStepDefinitions.GoogleStepData;
import com.assignment.selenium.google.modules.GoogleSearchResultTopMenuBar;
import com.assignment.selenium.google.pages.GoogleHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static com.assignment.core.CustomLogger.logger;

public class GoogleHomePageStepDefs {

    private GoogleStepData googleStepData;
    private SoftAssertions softly;

    public GoogleHomePageStepDefs(GoogleStepData googleStepData) {
        this.googleStepData = googleStepData;
        softly = new SoftAssertions();
    }

    @Given("^I navigate to Google Home Page$")
    public void navigateToGoogleHomePage() {
        logger().info("BEFORE TEST STEP: I navigate to Google Home Page");
        googleStepData.googleHomePage = new GoogleHomePage();
        googleStepData.googleHomePage.load();
    }

    @Given("^I'm on Google Home Page$")
    public void verifyThatGoogleHomePageIsLoaded() {
        logger().info("BEFORE TEST STEP: I'm on Google Home Page");
        softly.assertThat(googleStepData.googleHomePage.isLoaded()).as("Google Home page is not loaded - wrong url").isTrue();
        softly.assertThat(googleStepData.googleHomePage.isGoogleHomeSearchBoxDisplayed()).as("Google Home Page Search" +
                " Box is not displayed").isTrue();
        softly.assertThat(googleStepData.googleHomePage.isGoogleLogoDisplayed()).as("Google Logo is not displayed").isTrue();
        softly.assertThat(googleStepData.googleHomePage.isGoogleSearchButtonDisplayed()).as("'Google Search' button " +
                "is not displayed").isTrue();
        softly.assertThat(googleStepData.googleHomePage.isImFeelingLuckyButtonDisplayed()).as("'I'm Feeling Lucky' " +
                "button is not displayed").isTrue();
        softly.assertAll();
    }

    @When("^I click 'Sign in' button$")
    public void clickSignInButton() {
        logger().info("STEP: I click 'Sign in' button");
        googleStepData.googleAccountsPage = googleStepData.googleHomePage.clickSignInButton();
    }

    @Then("^I should be redirected to Accounts Page$")
    public void verifyThatGoogleAccountsIsLoaded() {
        logger().info("STEP: I should be redirected to Accounts Page");
        softly.assertThat(googleStepData.googleAccountsPage.isLoaded()).as("Google Home page is not loaded - wrong " +
                "url").isTrue();
        softly.assertThat(googleStepData.googleAccountsPage.isSignInHeadingTextDisplayed()).as("Google Accounts 'Sign" +
                " in' heading text is not displayed").isTrue();
        softly.assertAll();
    }

    @Then("^I should see correct Footer links$")
    public void verifyThatGoogleHomePageFooterLinksAreCorrect(List<String> footerLinks) {
        logger().info("STEP: I should see correct Footer links");
        logger().info("Footer links specified in scenario: " + footerLinks);
        softly.assertThat(googleStepData.googleHomePage.isFooterDisplayed()).as("Google Home Page Footer is not " +
                "displayed").isTrue();
        softly.assertThat(googleStepData.googleHomePage.getFooterLinksTexts()).as("Footer links are not correct").isEqualTo(footerLinks);
        softly.assertAll();
    }

    @When("^I click 'I'm Feeling Lucky' button$")
    public void clickImFeelingLuckyButton() {
        logger().info("STEP: I click 'I'm Feeling Lucky' button");
        googleStepData.googleDoodlesPage = googleStepData.googleHomePage.clickImFeelingLuckyButton();
    }

    @When("^I should be redirected to Doodles Page$")
    public void verifyThatGoogleDoodlesPageIsLoaded() {
        logger().info("STEP: I should be redirected to Doodles Page");
        softly.assertThat(googleStepData.googleDoodlesPage.isLoaded()).as("Google Doodles Page is not displayed").isTrue();
        softly.assertAll();
    }

    @And("^I click 'Google Search' button$")
    public void clickGoogleSearchButton() {
        logger().info("STEP: I click 'Google Search' button");
        googleStepData.googleSearchResultsAllPage = googleStepData.googleHomePage.clickGoogleSearchButton();
        googleStepData.googleSearchResultTopMenuBar = new GoogleSearchResultTopMenuBar();
    }

    @And("^I click 'Enter' keyboard key$")
    public void clickEnterKey() {
        logger().info("STEP: I click 'Enter' keyboard key");
        googleStepData.googleSearchResultsAllPage = googleStepData.googleHomePage.clickEnterKey();
        googleStepData.googleSearchResultTopMenuBar = new GoogleSearchResultTopMenuBar();
    }

    @Then("^I should be redirected to Google Search Result Page$")
    public void verifyThatGoogleSearchResultPageIsLoaded() {
        logger().info("STEP: I should be redirected to Google Search Result Page");
        softly.assertThat(googleStepData.googleSearchResultTopMenuBar.isLoaded()).as("Google Search Result Page Top " +
                "Menu Bar is not displayed").isTrue();
        softly.assertThat(googleStepData.googleSearchResultsAllPage.isLoaded()).as("Google Search Result Page is not " +
                "displayed").isTrue();
        softly.assertAll();
    }

    @When("^I enter text \'(.*)\' into search box$")
    public void enterTextIntoSearchBox(String searchText) {
        logger().info("STEP: I enter text '" + searchText + "' into search box");
        googleStepData.googleHomePage.enterSearchBoxText(searchText);
    }

}
