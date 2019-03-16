package com.assignment.stepDefinitions;

import com.assignment.selenium.allegro.modules.AllegroSearchFilters;
import com.assignment.selenium.allegro.modules.AllegroSearchResults;
import com.assignment.selenium.allegro.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
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

    @When("^User navigates to Allegro Home Page$")
    public void userNavigatesToAllegroHomePage(){
        logger().info("BEFORE TEST STEP: Navigating to Allegro Home Page");
        allegroHomePage = new AllegroHomePage();
    }

    @Then("^User is on Allegro Home Page$")
    public void userIsOnAllegroHomePage(){
        logger().info("BEFORE TEST STEP: Verifying if Allegro 'Home' Page is loaded");
        Assert.assertTrue("Home page is not loaded - wrong url", allegroHomePage.isLoaded());
        Assert.assertTrue("Header Search Box on Homge Page is not displayed", allegroHomePage.isHeaderSearchBoxDisplayed());
    }

    @And("^User closes Pop Up if it is displayed$")
    public void userClosesPopUpIfItIsDisplayed(){
        logger().info("BEFORE TEST STEP: Checking if PopUp is displayed");
        if (allegroHomePage.isNieZgadzamSieButtonDisplayed()){
            logger().info("PopUp is displayed, clicking 'Nie zgadzam sie' button");
            allegroHomePage.clickNieZgadzamSieButton();
        }
    }


    @And("^I navigate to 'Dyski zewnetrzne i przenosne' page$")
    public void navigateToDyskiZewnetrzneIPrzenosnePage(){
        logger().info("STEP: Clicking 'Elektronika' Button");
        allegroElektronikaPage = allegroHomePage.clickElektronikaButton();
        logger().info("STEP: Verifying if Allegro 'Elektronika' Page is loaded");
        Assert.assertTrue("'Elektronika' page is not loaded - wrong url", allegroElektronikaPage.isLoaded());
        Assert.assertTrue("'Elektronika' text is not displayed", allegroElektronikaPage.isElektronikaTextDisplayed());
        Assert.assertTrue("Categories Layout is not displayed", allegroElektronikaPage.isCategoriesLayoutFrameDisplayed());
        logger().info("STEP: Clicking 'Komputery' Button");
        allegroKomputeryPage = allegroElektronikaPage.clickKomputeryButton();
        logger().info("STEP: Verifying if Allegro 'Komputery' Page is loaded");
        Assert.assertTrue("'Komputery' page is not loaded - wrong url", allegroKomputeryPage.isLoaded());
        Assert.assertTrue("'Komputery' text is not displayed", allegroKomputeryPage.isKomputeryTextDisplayed());
        Assert.assertTrue("'Komputery' breadcrumb is not displayed", allegroKomputeryPage.isKomputeryBreadcrumbDisplayed());
        logger().info("STEP: Clicking 'Dyski i pamieci przenosne' Button");
        allegroDyskiIPamieciPrzenosnePage = allegroKomputeryPage.clickDyskiIPamieciPrzenosneButton();
        logger().info("STEP: Verifying if Allegro 'Dyski i pamieci przenosne' Page is loaded");
        Assert.assertTrue("'Dyski i pamieci przenosne' page is not loaded - wrong url", allegroDyskiIPamieciPrzenosnePage.isLoaded());
        Assert.assertTrue("'Dyski i pamieci przenosne' text is not displayed", allegroDyskiIPamieciPrzenosnePage.isDyskiIPamieciPrzenosneTextDisplayed());
        Assert.assertTrue("'Dyski i pamieci przenosne' breadcrumb is not displayed", allegroDyskiIPamieciPrzenosnePage.isDyskiIPamieciPrzenosneBreadcrumbDisplayed());
        logger().info("STEP: Clicking 'Dyski zewnetrzne i przenosne' Button");
        allegroDyskiZewnetrzneIPrzenosnePage = allegroDyskiIPamieciPrzenosnePage.clickDyskiZewnetrzneIPrzenosneButton();
        logger().info("STEP: Verifying if Allegro 'Dyski zewnętrzne i przenośne' Page is loaded");
        Assert.assertTrue("'Dyski zewnętrzne i przenośne' page is not loaded - wrong url", allegroDyskiZewnetrzneIPrzenosnePage.isLoaded());
        Assert.assertTrue("'Dyski zewnętrzne i przenośne' text is not displayed", allegroDyskiZewnetrzneIPrzenosnePage.isDyskiZewnetrzneIPrzenosneTextDisplayed());
        Assert.assertTrue("'Dyski zewnętrzne i przenośne' breadcrumb is not displayed", allegroDyskiZewnetrzneIPrzenosnePage.isDyskiZewnetrzneIPrzenosneBreadcrumbDisplayed());
    }

    @When("^I apply search filters from (.+) gb to (.+) gb$")
    public void applySearchFilters(String filterFrom, String filterTo) {
        logger().info("STEP: Verifying if Allegro 'Search Filters' Module is loaded");
        allegroSearchFilters = new AllegroSearchFilters();
        Assert.assertTrue("'Search Filters' Module is not loaded", allegroSearchFilters.isLoaded());
        Assert.assertTrue("'Pojemnosc dysku' Filter is not displayed", allegroSearchFilters.isFilterPojemnoscDyskuDisplyed());
        logger().info("STEP: Entering data to 'Pojemnosc Dysku' filter, From: " + filterFrom + ", To: " + filterTo);
        allegroSearchFilters.enterFilterPojemnoscDyskuFromText(filterFrom);
        allegroSearchFilters.enterFilterPojemnoscDyskuToText(filterTo);
        logger().info("STEP: Verifying if filter: " + "od " + filterFrom +" GB" + " is applied");
        Assert.assertEquals("Filter '" + "od " + filterFrom +" GB" + "' is not applied", "od " + filterFrom +" GB", allegroSearchFilters.getChosenAppliedFiltersText(0));
        logger().info("STEP: Verifying if filter: " + "do " + filterTo +" GB" + " is applied");
        Assert.assertEquals("Filter '" + "do " + filterTo +" GB" + "' is not applied", "do " + filterTo +" GB", allegroSearchFilters.getChosenAppliedFiltersText(1));
        logger().info("STEP: Verifying if Allegro 'Search Results' Module is loaded");
        allegroSearchResults = new AllegroSearchResults();
        Assert.assertTrue("'Search Results' Module is not loaded", allegroSearchResults.isLoaded());
        logger().info("STEP: Verifying if 'Sortowanie' Filter is displayed");
        Assert.assertTrue("'Sortowanie' Filter is not displayed", allegroSearchResults.isFilterSortowanieDisplayed());
        logger().info("STEP: Selecting option from 'Sortownie' dropdown with value: " + "pd");
        allegroSearchResults.selectOptionFromSortowanieDropdown("pd");
    }

    @Then("^I should see correctly filtered results from (.+) gb to (.+) gb$")
    public void verifyCorrectlyFilteredResults(String filterFrom, String filterTo){
        logger().info("STEP: Verifying if Search Results items are displayed, if price is sorted descending and if filter 'Pojemnosc Dysku' from: " + filterFrom + ", to: " + filterTo + " is applied");
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
