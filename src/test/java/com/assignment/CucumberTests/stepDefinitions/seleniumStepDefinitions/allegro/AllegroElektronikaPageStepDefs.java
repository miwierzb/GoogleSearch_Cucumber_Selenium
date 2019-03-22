package com.assignment.CucumberTests.stepDefinitions.seleniumStepDefinitions.allegro;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.assignment.core.CustomLogger.logger;

public class AllegroElektronikaPageStepDefs {

    private AllegroStepData allegroStepData;

    public AllegroElektronikaPageStepDefs(AllegroStepData allegroStepData) {
        this.allegroStepData = allegroStepData;
    }

    @Then("^I should land on 'Elektronika' page$")
    public void verifyIfElektronikaPageIsLoaded() {
        logger().info("STEP: I'm on 'Elektronika' page");
        Assert.assertTrue("'Elektronika' page is not loaded - wrong url",
                allegroStepData.allegroElektronikaPage.isLoaded());
        Assert.assertTrue("'Elektronika' text is not displayed",
                allegroStepData.allegroElektronikaPage.isElektronikaTextDisplayed());
        Assert.assertTrue("Categories Layout is not displayed",
                allegroStepData.allegroElektronikaPage.isCategoriesLayoutFrameDisplayed());
    }

    @When("^I click on 'Komputery' button$")
    public void clickKomputeryButton() {
        logger().info("STEP: I click on 'Komputery' button");
        allegroStepData.allegroKomputeryPage = allegroStepData.allegroElektronikaPage.clickKomputeryButton();
    }

}
