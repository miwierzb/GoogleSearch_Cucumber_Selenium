package com.assignment.CucumberTests.stepDefinitions.seleniumStepDefinitions.allegro;

import com.assignment.JunitTests.selenium.allegro.modules.AllegroSearchResults;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;

import static com.assignment.core.CustomLogger.logger;

public class AllegroSearchResultsStepDefs {

    private AllegroStepData allegroStepData;

    public AllegroSearchResultsStepDefs(AllegroStepData allegroStepData) {
        this.allegroStepData = allegroStepData;
    }

    @And("^I should see Search Results module loaded$")
    public void verifyIfSearchResultsModuleIsLoaded() {
        logger().info("STEP: I should see Search Results module loaded");
        allegroStepData.allegroSearchResults = new AllegroSearchResults();
        Assert.assertTrue("'Search Results' Module is not loaded", allegroStepData.allegroSearchResults.isLoaded());
    }

    @And("^I should see 'Sortowanie' filter$")
    public void verifyIfSortowanieFilterIsDisplayed() {
        logger().info("STEP: I should see 'Sortowanie' filter");
        Assert.assertTrue("'Sortowanie' Filter is not displayed",
                allegroStepData.allegroSearchResults.isFilterSortowanieDisplayed());
    }

    @When("^I select (.+) from 'Sortowanie' filter$")
    public void selectOptionFromSortowanieFilter(String option) {
        switch (option) {
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

    @Then("^I should see correctly filtered results for (.+) gb to (.+) gb and (.+)$")
    public void verifyIfResultsAreCorrectlyFilteredForChosenParameters(String filterFrom, String filterTo,
                                                                       String option) {
        logger().info("STEP: I should see correctly filtered results for " + filterFrom + " gb to " + filterTo + " gb" +
                " and " + option);
        Assert.assertTrue("Result list is empty!", allegroStepData.allegroSearchResults.isAnyResultDisplayed());
        Assert.assertTrue("Prices are not sorted " + option + "!", isItemPriceSortedBy(option));
        Assert.assertTrue("Discs capacity is not in: " + filterFrom + " - " + filterTo + " range!",
                isResultDiscsCapacityInGivenGbRange(filterFrom, filterTo));
    }

    private boolean isItemPriceSortedBy(String sorting) {
        ArrayList<String> itemPrices = allegroStepData.allegroSearchResults.getSearchResultsPricesTexts();
        boolean sorted = true;
        for (int i = 1; i < itemPrices.size(); i++) {
            switch (sorting) {
                case "price_descending":
                    if (Double.parseDouble(itemPrices.get(i - 1).split("( zł)")[0].replace(",", ".").replace(" ", ""))
                            - Double.parseDouble(itemPrices.get(i).split("( zł)")[0].replace(",", ".").replace(" ",
                            "")) < 0) {
                        sorted = false;
                        logger().info("Price is not sorted - element " + (i - 1) + ": " + itemPrices.get(i - 1) + " " +
                                "is lower that element " + i + ": " + itemPrices.get(i));
                    }
                    break;
                case "price_ascending":
                    if (Double.parseDouble(itemPrices.get(i - 1).split("( zł)")[0].replace(",", ".").replace(" ", ""))
                            - Double.parseDouble(itemPrices.get(i).split("( zł)")[0].replace(",", ".").replace(" ",
                            "")) > 0) {
                        sorted = false;
                        logger().info("Price is not sorted - element " + (i - 1) + ": " + itemPrices.get(i - 1) + " " +
                                "is higher that element " + i + ": " + itemPrices.get(i));
                    }
                    break;
            }
        }
        if (sorted) {
            logger().info("Items correctly sorted by " + sorting);
        } else {
            logger().info("Items NOT sorted by " + sorting);
        }
        return sorted;
    }

    private boolean isResultDiscsCapacityInGivenGbRange(String filterFrom, String filterTo) {
        ArrayList<String> itemDiscCapacity = allegroStepData.allegroSearchResults.getSearchResultsDiskCapacityTexts();
        boolean filterApplied = true;
        for (String capacity : itemDiscCapacity) {
            if (Integer.parseInt(capacity.split("[ ]")[0]) < Integer.parseInt(filterFrom)
                    || Integer.parseInt(capacity.split("[ ]")[0]) > Integer.parseInt(filterTo)) {
                filterApplied = false;
                logger().info("Disc capacity " + capacity + " is not between " + filterFrom + " and " + filterTo + " " +
                        "range");
            }
        }
        if (filterApplied) {
            logger().info("Items correctly filtered");
        } else {
            logger().info("Items NOT correctly filtered");
        }
        return filterApplied;
    }

}
