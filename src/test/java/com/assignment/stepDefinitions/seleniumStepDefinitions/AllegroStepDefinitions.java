package com.assignment.stepDefinitions.seleniumStepDefinitions;

import com.assignment.selenium.allegro.modules.AllegroSearchFilters;
import com.assignment.selenium.allegro.modules.AllegroSearchResults;
import com.assignment.selenium.allegro.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;

import static com.assignment.core.CustomLogger.logger;

public class AllegroStepDefinitions {

    private AllegroHomePage allegroHomePage;
    private AllegroElektronikaPage allegroElektronikaPage;
    private AllegroKomputeryPage allegroKomputeryPage;
    private AllegroDyskiIPamieciPrzenosnePage allegroDyskiIPamieciPrzenosnePage;
    private AllegroDyskiZewnetrzneIPrzenosnePage allegroDyskiZewnetrzneIPrzenosnePage;
    private AllegroSearchFilters allegroSearchFilters;
    private AllegroSearchResults allegroSearchResults;

    @When("^I navigate to Allegro Home Page$")
    public void userNavigatesToAllegroHomePage(){
        logger().info("BEFORE TEST STEP: I navigate to Allegro Home Page");
        allegroHomePage = new AllegroHomePage();
        allegroHomePage.load();
    }

    @Then("^I'm on Allegro Home Page$")
    public void userIsOnAllegroHomePage(){
        logger().info("BEFORE TEST STEP: I'm on Allegro Home Page");
        Assert.assertTrue("Home page is not loaded - wrong url", allegroHomePage.isLoaded());
        Assert.assertTrue("Header Search Box on Homge Page is not displayed", allegroHomePage.isHeaderSearchBoxDisplayed());
    }

    @And("^I close Pop Up if it is displayed$")
    public void userClosesPopUpIfItIsDisplayed(){
        logger().info("BEFORE TEST STEP: I close Pop Up if it is displayed");
        if (allegroHomePage.isNieZgadzamSieButtonDisplayed()){
            logger().info("PopUp is displayed, clicking 'Nie zgadzam sie' button");
            allegroHomePage.clickNieZgadzamSieButton();
        }
    }


    @And("^I navigate to 'Dyski zewnetrzne i przenosne' page$")
    public void navigateToDyskiZewnetrzneIPrzenosnePage(){
        logger().info("STEP: I navigate to 'Dyski zewnetrzne i przenosne' page");
        allegroElektronikaPage = allegroHomePage.clickElektronikaButton();
        Assert.assertTrue("'Elektronika' page is not loaded - wrong url", allegroElektronikaPage.isLoaded());
        Assert.assertTrue("'Elektronika' text is not displayed", allegroElektronikaPage.isElektronikaTextDisplayed());
        Assert.assertTrue("Categories Layout is not displayed", allegroElektronikaPage.isCategoriesLayoutFrameDisplayed());
        allegroKomputeryPage = allegroElektronikaPage.clickKomputeryButton();
        Assert.assertTrue("'Komputery' page is not loaded - wrong url", allegroKomputeryPage.isLoaded());
        Assert.assertTrue("'Komputery' text is not displayed", allegroKomputeryPage.isKomputeryTextDisplayed());
        Assert.assertTrue("'Komputery' breadcrumb is not displayed", allegroKomputeryPage.isKomputeryBreadcrumbDisplayed());
        allegroDyskiIPamieciPrzenosnePage = allegroKomputeryPage.clickDyskiIPamieciPrzenosneButton();
        Assert.assertTrue("'Dyski i pamieci przenosne' page is not loaded - wrong url", allegroDyskiIPamieciPrzenosnePage.isLoaded());
        Assert.assertTrue("'Dyski i pamieci przenosne' text is not displayed", allegroDyskiIPamieciPrzenosnePage.isDyskiIPamieciPrzenosneTextDisplayed());
        Assert.assertTrue("'Dyski i pamieci przenosne' breadcrumb is not displayed", allegroDyskiIPamieciPrzenosnePage.isDyskiIPamieciPrzenosneBreadcrumbDisplayed());
        allegroDyskiZewnetrzneIPrzenosnePage = allegroDyskiIPamieciPrzenosnePage.clickDyskiZewnetrzneIPrzenosneButton();
        Assert.assertTrue("'Dyski zewnętrzne i przenośne' page is not loaded - wrong url", allegroDyskiZewnetrzneIPrzenosnePage.isLoaded());
        Assert.assertTrue("'Dyski zewnętrzne i przenośne' text is not displayed", allegroDyskiZewnetrzneIPrzenosnePage.isDyskiZewnetrzneIPrzenosneTextDisplayed());
        Assert.assertTrue("'Dyski zewnętrzne i przenośne' breadcrumb is not displayed", allegroDyskiZewnetrzneIPrzenosnePage.isDyskiZewnetrzneIPrzenosneBreadcrumbDisplayed());
    }

    @When("^I apply search filters from (.+) gb to (.+) gb$")
    public void applySearchFilters(String filterFrom, String filterTo) {
        logger().info("STEP: I apply search filters from " + filterFrom + " gb to " + filterTo + " gb");
        allegroSearchFilters = new AllegroSearchFilters();
        Assert.assertTrue("'Search Filters' Module is not loaded", allegroSearchFilters.isLoaded());
        Assert.assertTrue("'Pojemnosc dysku' Filter is not displayed", allegroSearchFilters.isFilterPojemnoscDyskuDisplyed());
        allegroSearchFilters.enterFilterPojemnoscDyskuFromText(filterFrom);
        allegroSearchFilters.enterFilterPojemnoscDyskuToText(filterTo);
        logger().info("Verifying if filter: " + "od " + filterFrom +" GB" + " is applied");
        Assert.assertEquals("Filter '" + "od " + filterFrom +" GB" + "' is not applied", "od " + filterFrom +" GB", allegroSearchFilters.getChosenAppliedFiltersText(0));
        logger().info("Verifying if filter: " + "do " + filterTo +" GB" + " is applied");
        Assert.assertEquals("Filter '" + "do " + filterTo +" GB" + "' is not applied", "do " + filterTo +" GB", allegroSearchFilters.getChosenAppliedFiltersText(1));
        allegroSearchResults = new AllegroSearchResults();
        Assert.assertTrue("'Search Results' Module is not loaded", allegroSearchResults.isLoaded());
        Assert.assertTrue("'Sortowanie' Filter is not displayed", allegroSearchResults.isFilterSortowanieDisplayed());
        allegroSearchResults.selectOptionFromSortowanieDropdown("pd");
    }

    @Then("^I should see correctly filtered results from (.+) gb to (.+) gb$")
    public void verifyCorrectlyFilteredResults(String filterFrom, String filterTo){
        logger().info("STEP: I should see correctly filtered results from " + filterFrom + " gb to " + filterTo + " gb");
        Assert.assertTrue("Result list is empty!", allegroSearchResults.isAnyResultDisplayed());
        Assert.assertTrue("Prices are not sorted descending!", isItemPriceSortedDescending());
        Assert.assertTrue("Discs capacity is not in: " + filterFrom + " - " + filterTo + " range!", isResultDiscsCapacityInGivenGbRange(filterFrom, filterTo));
    }

    private boolean isItemPriceSortedDescending(){
        ArrayList<String> itemPrices = allegroSearchResults.getSearchResultsPricesTexts();
        boolean sorted = true;
        for (int i = 1; i < itemPrices.size(); i++) {
            if (Double.parseDouble(itemPrices.get(i-1).split("( zł)")[0].replace(",", ".").replace(" ", ""))
                    - Double.parseDouble(itemPrices.get(i).split("( zł)")[0].replace(",", ".")) < 0){
                sorted = false;
                logger().info("Price is not sorted - element " + (i-1) + ": " + itemPrices.get(i-1) + " is lower that element " + i + ": " + itemPrices.get(i));
            }
        }
        if(sorted){
            logger().info("Items correctly sorted by price descending");
        } else {
            logger().info("Items NOT sorted by price descending");
        }
        return sorted;
    }

    private boolean isResultDiscsCapacityInGivenGbRange(String filterFrom, String filterTo){
        ArrayList<String> itemDiscCapacity = allegroSearchResults.getSearchResultsDiskCapacityTexts();
        boolean filterApplied = true;
        for (String capacity : itemDiscCapacity) {
            if (Integer.parseInt(capacity.split("[ ]")[0]) < Integer.parseInt(filterFrom)
                    || Integer.parseInt(capacity.split("[ ]")[0]) > Integer.parseInt(filterTo)) {
                filterApplied = false;
                logger().info("Disc capacity " + capacity + " is not between " + filterFrom + " and " +filterTo + " range");
            }
        }
        if(filterApplied){
            logger().info("Items correctly filtered");
        } else {
            logger().info("Items NOT correctly filtered");
        }
        return filterApplied;
    }

}
