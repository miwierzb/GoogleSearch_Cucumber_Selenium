package com.assignment.cucumberTests.stepDefinitions.seleniumStepDefinitions.google;

import com.assignment.cucumberTests.stepDefinitions.seleniumStepDefinitions.GoogleStepData;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;

import java.util.List;

import static com.assignment.core.CustomLogger.logger;

public class GoogleSearchResultPageStepDefs {

    private GoogleStepData googleStepData;
    private SoftAssertions softly;

    public GoogleSearchResultPageStepDefs(GoogleStepData googleStepData) {
        this.googleStepData = googleStepData;
        softly = new SoftAssertions();
    }

    @When("^I'm on Google Search Result Page$")
    public void verifyIfGoogleSearchResultPageIsLoaded() {
        logger().info("STEP: I'm on Google Search Result Page");
        softly.assertThat(googleStepData.googleSearchResultTopMenuBar.isLoaded()).as("Google Search Result Page Top Menu Bar is not displayed").isTrue();
        softly.assertThat(googleStepData.googleSearchResultsAllPage.isLoaded()).as("Google Search Result Page is not displayed").isTrue();
        softly.assertAll();
    }

    @Then("^I should see message 'Your search - <keyword> - did not match any documents'$")
    public void verifyIfDidNotFoundAnyDocumentsMessageIsDisplayed() {
        logger().info("STEP: I should see message 'Your search - <keyword> - did not match any documents'");

    }

    @Then("^I should see correct bookmarks$")
    public void verifyIfCorrectBookmarksAreDisplayed(List<String> bookmarks) {
        logger().info("STEP: I should see correct bookmarks");
        logger().info("Bookmarks specified in scenario: " + bookmarks);
        softly.assertThat(googleStepData.googleSearchResultTopMenuBar.isBookmarksBarDisplayed()).as("Google Search Result Page Bookmarks Bar is not displayed").isTrue();
        softly.assertThat(googleStepData.googleSearchResultTopMenuBar.getBookmarksBarTabsTexts()).as("Bookmarks Tabs are not correct").isEqualTo(bookmarks);
        softly.assertAll();
    }
}
