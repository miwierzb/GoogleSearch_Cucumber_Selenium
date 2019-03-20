package com.assignment.stepDefinitions.seleniumStepDefinitions.allegro;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.assignment.core.CustomLogger.logger;

public class AllegroDyskiIPamieciPrzenosnePageStepDefs {

    private AllegroStepData allegroStepData;

    public AllegroDyskiIPamieciPrzenosnePageStepDefs(AllegroStepData allegroStepData){
        this.allegroStepData = allegroStepData;
    }

    @Then("^I should land on 'Dyski i pamieci przenosne' page$")
    public void verifyIfDyskiIPamieciPrzenosnePageIsLoaded(){
        logger().info("STEP: I should land on 'Dyski i pamieci przenosne' page");
        Assert.assertTrue("'Dyski i pamieci przenosne' page is not loaded - wrong url", allegroStepData.allegroDyskiIPamieciPrzenosnePage.isLoaded());
        Assert.assertTrue("'Dyski i pamieci przenosne' text is not displayed", allegroStepData.allegroDyskiIPamieciPrzenosnePage.isDyskiIPamieciPrzenosneTextDisplayed());
        Assert.assertTrue("'Dyski i pamieci przenosne' breadcrumb is not displayed", allegroStepData.allegroDyskiIPamieciPrzenosnePage.isDyskiIPamieciPrzenosneBreadcrumbDisplayed());
    }

    @When("^I click on 'Dyski zewnetrzne i przenosne' button$")
    public void clickDyskiZewnetrzneIPrzenosneButton(){
        logger().info("STEP: I click on 'Dyski zewnetrzne i przenosne' button");
        allegroStepData.allegroDyskiZewnetrzneIPrzenosnePage = allegroStepData.allegroDyskiIPamieciPrzenosnePage.clickDyskiZewnetrzneIPrzenosneButton();
    }
}
