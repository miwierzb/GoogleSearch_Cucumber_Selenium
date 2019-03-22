package com.assignment.CucumberTests.stepDefinitions.seleniumStepDefinitions.allegro;

import cucumber.api.java.en.Then;
import org.junit.Assert;

import static com.assignment.core.CustomLogger.logger;

public class AllegroDyskiZewnetrzneIPrzenosnePageStepDefs {

    private AllegroStepData allegroStepData;

    public AllegroDyskiZewnetrzneIPrzenosnePageStepDefs(AllegroStepData allegroStepData) {
        this.allegroStepData = allegroStepData;
    }

    @Then("^I should land on 'Dyski zewnetrzne i przenosne' page$")
    public void verifyIfDyskiZewnetrzneIPrzenosnePageIsLoaded() {
        logger().info("STEP: I should land on 'Dyski zewnetrzne i przenosne' page");
        Assert.assertTrue("'Dyski zewnętrzne i przenośne' page is not loaded - wrong url",
                allegroStepData.allegroDyskiZewnetrzneIPrzenosnePage.isLoaded());
        Assert.assertTrue("'Dyski zewnętrzne i przenośne' text is not displayed",
                allegroStepData.allegroDyskiZewnetrzneIPrzenosnePage.isDyskiZewnetrzneIPrzenosneTextDisplayed());
        Assert.assertTrue("'Dyski zewnętrzne i przenośne' breadcrumb is not displayed",
                allegroStepData.allegroDyskiZewnetrzneIPrzenosnePage.isDyskiZewnetrzneIPrzenosneBreadcrumbDisplayed());
    }

}
