package com.assignment.CucumberTests.stepDefinitions.seleniumStepDefinitions.allegro;

import com.assignment.JunitTests.selenium.allegro.pages.AllegroHomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.assignment.core.CustomLogger.logger;

public class AllegroHomePageStepDefs {

    private AllegroStepData allegroStepData;

    public AllegroHomePageStepDefs(AllegroStepData allegroStepData) {
        this.allegroStepData = allegroStepData;
    }

    @When("^I navigate to Allegro Home Page$")
    public void navigateToAllegroHomePage() {
        logger().info("BEFORE TEST STEP: I navigate to Allegro Home Page");
        allegroStepData.allegroHomePage = new AllegroHomePage();
        allegroStepData.allegroHomePage.load();
    }

    @Then("^I'm on Allegro Home Page$")
    public void verifyIfAllegroHomePageIsLoaded() {
        logger().info("BEFORE TEST STEP: I'm on Allegro Home Page");
        Assert.assertTrue("Home page is not loaded - wrong url", allegroStepData.allegroHomePage.isLoaded());
        Assert.assertTrue("Header Search Box on Homge Page is not displayed",
                allegroStepData.allegroHomePage.isHeaderSearchBoxDisplayed());
    }

    @And("^I close Pop Up if it is displayed$")
    public void closesPopUpIfItIsDisplayed() {
        logger().info("BEFORE TEST STEP: I close Pop Up if it is displayed");
        if (allegroStepData.allegroHomePage.isNieZgadzamSieButtonDisplayed()) {
            logger().info("PopUp is displayed, clicking 'Nie zgadzam sie' button");
            allegroStepData.allegroHomePage.clickNieZgadzamSieButton();
        }
    }

    @When("^I click on 'Elektronika' button$")
    public void clickElektronikaButton() {
        logger().info("STEP: I click on 'Elektronika' button");
        allegroStepData.allegroElektronikaPage = allegroStepData.allegroHomePage.clickElektronikaButton();
    }

    @When("^I hover over 'Elektronika' link and click 'Komputery' button$")
    public void hoverOverElektronikaLinkAndClickKomputeryButton() {
        logger().info("Hovering over 'Elektronika' button, then clicking 'Komputery' button");
        allegroStepData.allegroKomputeryPage =
                allegroStepData.allegroHomePage.hoverOverElektronikaAndClickKomputeryButton();
    }

}
