package com.assignment.cucumberTests.stepDefinitions.seleniumStepDefinitions.allegro;

import com.assignment.cucumberTests.stepDefinitions.seleniumStepDefinitions.AllegroStepData;
import com.assignment.selenium.allegro.modules.AllegroSearchFilters;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.assignment.core.CustomLogger.logger;

public class AllegroSearchFiltersStepDefs {

    private AllegroStepData allegroStepData;

    public AllegroSearchFiltersStepDefs(AllegroStepData allegroStepData) {
        this.allegroStepData = allegroStepData;
    }

    @And("^I should see Search filter module loaded$")
    public void verifyIfSearchFilterModuleIsLoaded() {
        logger().info("STEP: I should see Search filter module loaded");
        allegroStepData.allegroSearchFilters = new AllegroSearchFilters();
        Assert.assertTrue("'Search Filters' Module is not loaded", allegroStepData.allegroSearchFilters.isLoaded());
    }

    @And("^I should see 'Pojemnosc dysku' filter in Search filter module$")
    public void verifyIfPojemnoscDyskuFilterIsDisplayed() {
        logger().info("STEP: I should see 'Pojemnosc dysku' filter in Search filter module");
        Assert.assertTrue("'Pojemnosc dysku' Filter is not displayed",
                allegroStepData.allegroSearchFilters.isFilterPojemnoscDyskuDisplyed());
    }

    @When("^I enter from (.+) gb to (.+) gb in 'Pojemnosc dysku' filter$")
    public void enterDataFromToInPojemnoscDyskuFilter(String filterFrom, String filterTo) {
        logger().info("STEP: I enter from " + filterFrom + " gb to " + filterTo + " gb in 'Pojemnosc dysku' filter");
        allegroStepData.allegroSearchFilters.enterFilterPojemnoscDyskuFromText(filterFrom);
        allegroStepData.allegroSearchFilters.enterFilterPojemnoscDyskuToText(filterTo);
    }

    @Then("^I should see from (.+) gb to (.+) gb filter applied$")
    public void verifyIfCorrectFilterIsApplied(String filterFrom, String filterTo) {
        logger().info("STEP: I should see from " + filterFrom + " gb to " + filterTo + " gb filter applied");
        Assert.assertEquals("Filter '" + filterFrom + "' is not applied", "Pojemność dysku: od " + filterFrom + " GB",
                allegroStepData.allegroSearchFilters.getChosenAppliedFiltersText(0));
        Assert.assertEquals("Filter '" + filterTo + "' is not applied", "Pojemność dysku: do " + filterTo + " GB",
                allegroStepData.allegroSearchFilters.getChosenAppliedFiltersText(1));
    }

}
