package com.assignment.stepDefinitions.seleniumStepDefinitions.allegro;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.assignment.core.CustomLogger.logger;

public class AllegroKomputeryPageStepDefs {

    private AllegroStepData allegroStepData;

    public AllegroKomputeryPageStepDefs(AllegroStepData allegroStepData){
        this.allegroStepData = allegroStepData;
    }

    @Then("^I should land on 'Komputery' page$")
    public void verifyIfKomputeryPageIsLoaded(){
        logger().info("STEP: I'm on 'Komputery' page");
        Assert.assertTrue("'Komputery' page is not loaded - wrong url", allegroStepData.allegroKomputeryPage.isLoaded());
        Assert.assertTrue("'Komputery' text is not displayed", allegroStepData.allegroKomputeryPage.isKomputeryTextDisplayed());
        Assert.assertTrue("'Komputery' breadcrumb is not displayed", allegroStepData.allegroKomputeryPage.isKomputeryBreadcrumbDisplayed());
    }

    @When("^I click on 'Dyski i pamieci przenosne' button$")
    public void clickDyskiIPamieciPrzenosneButton(){
        logger().info("STEP: I click on 'Dyski i pamieci przenosne' button");
        allegroStepData.allegroDyskiIPamieciPrzenosnePage = allegroStepData.allegroKomputeryPage.clickDyskiIPamieciPrzenosneButton();
    }
}
