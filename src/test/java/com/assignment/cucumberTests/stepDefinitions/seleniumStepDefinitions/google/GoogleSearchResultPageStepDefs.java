package com.assignment.cucumberTests.stepDefinitions.seleniumStepDefinitions.google;

import com.assignment.cucumberTests.stepDefinitions.seleniumStepDefinitions.GoogleStepData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;

import java.util.Arrays;
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
        softly.assertThat(googleStepData.googleSearchResultTopMenuBar.isLoaded()).as("Google Search Result Page Top " +
                "Menu Bar is not displayed").isTrue();
        softly.assertThat(googleStepData.googleSearchResultsAllPage.isLoaded()).as("Google Search Result Page is not " +
                "displayed").isTrue();
        softly.assertAll();
    }

    @Then("^I should see correct bookmarks$")
    public void verifyIfCorrectBookmarksAreDisplayed(List<String> bookmarks) {
        logger().info("STEP: I should see correct bookmarks");
        logger().info("Bookmarks specified in scenario: " + bookmarks);
        softly.assertThat(googleStepData.googleSearchResultTopMenuBar.isBookmarksBarDisplayed()).as("Google Search " +
                "Result Page Bookmarks Bar is not displayed").isTrue();
        softly.assertThat(googleStepData.googleSearchResultTopMenuBar.getBookmarksBarTabsTexts()).as("Bookmarks Tabs " +
                "are not correct").isEqualTo(bookmarks);
        softly.assertAll();
    }

    @And("^I should see correct search result for \'(.+)\'$")
    public void verifyIfSearchCorrectResultsAreDisplayed(String searchText) {
        String[] keywordArray = searchText.split(" ");
        logger().info("STEP: I should see correct search result for: " + searchText);
        softly.assertThat(googleStepData.googleSearchResultsAllPage.isAnySearchResultDisplayed()).as("Google Search " +
                "Result Page does not contains any results!").isTrue();
        Arrays.stream(keywordArray).forEach(
                keyword -> softly.assertThat(googleStepData.googleSearchResultsAllPage.getSearchResultFirstTitle()).
                        as("First Result does not contain searched text: %s", searchText).containsIgnoringCase(keyword)
        );
        softly.assertAll();
    }

    @When("^I click 'Images' bookmark$")
    public void clickImagesBookmark() {
        logger().info("STEP: I click 'Images' bookmark");
        googleStepData.googleSearchResultsImagesPage = googleStepData.googleSearchResultTopMenuBar.clickImagesTab();
    }

    @Then("^I should land on Images Search Results Page$")
    public void verifyIfGoogleImagesSearchResultPageIsLoaded() {
        logger().info("STEP: I should land on Images Search Results Page");
        softly.assertThat(googleStepData.googleSearchResultsImagesPage.isLoaded()).as("Google Images Search Result " +
                "Page is not loaded").isTrue();
        softly.assertAll();
    }

    @Then("^I should see images search result for \'(.+)\'$")
    public void verifyIfSearchResultCorrectImagesAreDisplayed(String searchText) {
        String[] keywordArray = searchText.split(" ");
        logger().info("STEP: I should see images search result for: " + searchText);
        softly.assertThat(googleStepData.googleSearchResultsImagesPage.isAnySearchResultImageDisplayed()).as("Google " +
                "Search Result Images Page does not contains any results!").isTrue();
        Arrays.stream(keywordArray).forEach(
                keyword -> softly.assertThat(googleStepData.googleSearchResultsImagesPage.getSearchResultImagesFirstTitle()).
                        as("First Image Result does not contain searched text: %s", searchText).containsIgnoringCase(keyword)
        );
        softly.assertAll();
    }

    @And("^I click 'Magnifier' button$")
    public void clickMagnifierButton() {
        logger().info("STEP: I click 'Magnifier' button");
        googleStepData.googleSearchResultsAllPage = googleStepData.googleSearchResultTopMenuBar.clickMagnifierButton();
    }

    @Then("^I should see message '(.+)'$")
    public void verifyIfCustomMessageIsDisplayed(String message) {
        switch (message) {
            case "Your search - <keyword> - did not match any documents":
                logger().info("STEP: I should see message 'Your search - <keyword> - did not match any documents'");
                break;
            default:
                logger().info("Message not supported");
        }
        softly.assertThat(googleStepData.googleSearchResultsAllPage.isAnyMessageDisplayed()).as("There is no message " +
                "on Search Results Page!").isTrue();
        softly.assertThat(googleStepData.googleSearchResultsAllPage.getSearchResultMessageText()).as("Wrong Message " +
                "found!").isEqualTo(message);
    }

    @When("^I enter text \'(.+)\' into search box on Search Result Page$")
    public void enterTextIntoTopMenuBarSearchBox(String searchText) {
        logger().info("STEP: I enter text '" + searchText + "' into Top Menu Bar Search Box");
        googleStepData.googleSearchResultTopMenuBar.enterSearchBoxText(searchText);
    }

}
