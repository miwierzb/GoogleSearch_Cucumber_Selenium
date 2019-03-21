package com.assignment.stepDefinitions.seleniumStepDefinitions.allegro;

import com.assignment.selenium.allegro.modules.AllegroSearchFilters;
import com.assignment.selenium.allegro.modules.AllegroSearchResults;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.assignment.core.CustomLogger.logger;

public class CommonAllegroStepDefinitions {

    private AllegroStepData allegroStepData;

    public CommonAllegroStepDefinitions(AllegroStepData allegroStepData){
        this.allegroStepData = allegroStepData;
    }

    @And("^I navigate to 'Dyski zewnetrzne i przenosne' page$")
    public void navigateToDyskiZewnetrzneIPrzenosnePage(){
        logger().info("STEP: I navigate to 'Dyski zewnetrzne i przenosne' page");
        allegroStepData.allegroElektronikaPage = allegroStepData.allegroHomePage.clickElektronikaButton();
        Assert.assertTrue("'Elektronika' page is not loaded - wrong url", allegroStepData.allegroElektronikaPage.isLoaded());
        Assert.assertTrue("'Elektronika' text is not displayed", allegroStepData.allegroElektronikaPage.isElektronikaTextDisplayed());
        Assert.assertTrue("Categories Layout is not displayed", allegroStepData.allegroElektronikaPage.isCategoriesLayoutFrameDisplayed());
        allegroStepData.allegroKomputeryPage = allegroStepData.allegroElektronikaPage.clickKomputeryButton();
        Assert.assertTrue("'Komputery' page is not loaded - wrong url", allegroStepData.allegroKomputeryPage.isLoaded());
        Assert.assertTrue("'Komputery' text is not displayed", allegroStepData.allegroKomputeryPage.isKomputeryTextDisplayed());
        Assert.assertTrue("'Komputery' breadcrumb is not displayed", allegroStepData.allegroKomputeryPage.isKomputeryBreadcrumbDisplayed());
        allegroStepData.allegroDyskiIPamieciPrzenosnePage = allegroStepData.allegroKomputeryPage.clickDyskiIPamieciPrzenosneButton();
        Assert.assertTrue("'Dyski i pamieci przenosne' page is not loaded - wrong url", allegroStepData.allegroDyskiIPamieciPrzenosnePage.isLoaded());
        Assert.assertTrue("'Dyski i pamieci przenosne' text is not displayed", allegroStepData.allegroDyskiIPamieciPrzenosnePage.isDyskiIPamieciPrzenosneTextDisplayed());
        Assert.assertTrue("'Dyski i pamieci przenosne' breadcrumb is not displayed", allegroStepData.allegroDyskiIPamieciPrzenosnePage.isDyskiIPamieciPrzenosneBreadcrumbDisplayed());
        allegroStepData.allegroDyskiZewnetrzneIPrzenosnePage = allegroStepData.allegroDyskiIPamieciPrzenosnePage.clickDyskiZewnetrzneIPrzenosneButton();
        Assert.assertTrue("'Dyski zewnętrzne i przenośne' page is not loaded - wrong url", allegroStepData.allegroDyskiZewnetrzneIPrzenosnePage.isLoaded());
        Assert.assertTrue("'Dyski zewnętrzne i przenośne' text is not displayed", allegroStepData.allegroDyskiZewnetrzneIPrzenosnePage.isDyskiZewnetrzneIPrzenosneTextDisplayed());
        Assert.assertTrue("'Dyski zewnętrzne i przenośne' breadcrumb is not displayed", allegroStepData.allegroDyskiZewnetrzneIPrzenosnePage.isDyskiZewnetrzneIPrzenosneBreadcrumbDisplayed());
    }

    @When("^I apply search filters from (.+) gb to (.+) gb and (.+) sorting$")
    public void applySearchFilters(String filterFrom, String filterTo, String option) {
        logger().info("STEP: I apply search filters from " + filterFrom + " gb to " + filterTo + " gb");
        allegroStepData.allegroSearchFilters = new AllegroSearchFilters();
        Assert.assertTrue("'Search Filters' Module is not loaded", allegroStepData.allegroSearchFilters.isLoaded());
        Assert.assertTrue("'Pojemnosc dysku' Filter is not displayed", allegroStepData.allegroSearchFilters.isFilterPojemnoscDyskuDisplyed());
        allegroStepData.allegroSearchFilters.enterFilterPojemnoscDyskuFromText(filterFrom);
        allegroStepData.allegroSearchFilters.enterFilterPojemnoscDyskuToText(filterTo);
        logger().info("Verifying if filter: " + "od " + filterFrom +" GB" + " is applied");
        Assert.assertEquals("Filter '" + "od " + filterFrom +" GB" + "' is not applied", "od " + filterFrom +" GB", allegroStepData.allegroSearchFilters.getChosenAppliedFiltersText(0));
        logger().info("Verifying if filter: " + "do " + filterTo +" GB" + " is applied");
        Assert.assertEquals("Filter '" + "do " + filterTo +" GB" + "' is not applied", "do " + filterTo +" GB", allegroStepData.allegroSearchFilters.getChosenAppliedFiltersText(1));
        allegroStepData.allegroSearchResults = new AllegroSearchResults();
        Assert.assertTrue("'Search Results' Module is not loaded", allegroStepData.allegroSearchResults.isLoaded());
        Assert.assertTrue("'Sortowanie' Filter is not displayed", allegroStepData.allegroSearchResults.isFilterSortowanieDisplayed());
        switch(option){
            case "price_descending":
                option = "pd";
                break;
            case "price_ascending":
                option = "p";
                break;
            default:
                logger().info("Option: " + option + " not supported");
        }
        logger().info("STEP: I select '" + option + "' from 'Sortowanie' filter");
        allegroStepData.allegroSearchResults.selectOptionFromSortowanieDropdown(option);
    }

}
