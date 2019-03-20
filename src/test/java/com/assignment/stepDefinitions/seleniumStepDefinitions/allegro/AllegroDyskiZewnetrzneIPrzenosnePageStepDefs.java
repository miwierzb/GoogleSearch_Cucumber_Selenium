package com.assignment.stepDefinitions.seleniumStepDefinitions.allegro;

import com.assignment.selenium.allegro.modules.AllegroSearchFilters;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.assignment.core.CustomLogger.logger;

public class AllegroDyskiZewnetrzneIPrzenosnePageStepDefs {

    private AllegroStepData allegroStepData;

    public AllegroDyskiZewnetrzneIPrzenosnePageStepDefs(AllegroStepData allegroStepData){
        this.allegroStepData = allegroStepData;
    }

    @And("^I should see Search filter module loaded$")
    public void verifyIfSearchFilterModuleIsLoaded(){
        logger().info("STEP: I should see Search filter module loaded");
        allegroStepData.allegroSearchFilters = new AllegroSearchFilters();
        Assert.assertTrue("'Search Filters' Module is not loaded", allegroStepData.allegroSearchFilters.isLoaded());
    }

    @And("^I should see 'Pojemnosc dysku' filter in Search filter module$")
    public void verifyIfPojemnoscDyskuFilterIsDisplayed(){
        logger().info("STEP: I should see 'Pojemnosc dysku' filter in Search filter module");
        Assert.assertTrue("'Pojemnosc dysku' Filter is not displayed", allegroStepData.allegroSearchFilters.isFilterPojemnoscDyskuDisplyed());
    }

    @When("^I enter from (\\d+) gb to (\\d+) gb in 'Pojemnosc dysku' filter$")
    public void enterDataFromToInPojemnoscDyskuFilter(String filterFrom, String filterTo){
        logger().info("STEP: I enter from " + filterFrom + " gb to " + filterTo + " gb in 'Pojemnosc dysku' filter");
        allegroStepData.allegroSearchFilters.enterFilterPojemnoscDyskuFromText(filterFrom);
        allegroStepData.allegroSearchFilters.enterFilterPojemnoscDyskuToText(filterTo);
    }

}
