package com.assignment.JunitTests.selenium;

import com.assignment.JunitTests.selenium.allegro.modules.AllegroSearchFilters;
import com.assignment.JunitTests.selenium.allegro.modules.AllegroSearchResults;
import com.assignment.JunitTests.selenium.allegro.pages.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.PropertiesManager.getProperty;

public class AllegroTest extends BaseTest {

    private static final String FILTER_FROM = getProperty("selenium.filter.from");
    private static final String FILTER_TO = getProperty("selenium.filter.to");
    private static final String FILTER_TEXT_FROM = getProperty("selenium.filter.text.from");
    private static final String FILTER_TEXT_TO = getProperty("selenium.filter.text.to");
    private static final String SORT_BY_VALUE = getProperty("selenium.filter.sort.by.value");
    private AllegroHomePage allegroHomePage;
    private AllegroElektronikaPage allegroElektronikaPage;
    private AllegroKomputeryPage allegroKomputeryPage;
    private AllegroDyskiIPamieciPrzenosnePage allegroDyskiIPamieciPrzenosnePage;
    private AllegroDyskiZewnetrzneIPrzenosnePage allegroDyskiZewnetrzneIPrzenosnePage;
    private AllegroSearchFilters allegroSearchFilters;
    private AllegroSearchResults allegroSearchResults;

    @Before
    public void setUp() {
        goToAllegroHomePage();
        verifyIsHomePageLoaded();
        closePopUpIfDisplayed();
    }

    @Test
    public void allegroSearchResultsDyskiZewnetrzneIPrzenosneFilter500to1000gb() {
        clickElektronikaButton();
        verifyIsElektronikaPageLoaded();
        clickKomputeryButton();
        verifyIsKomputeryPageLoaded();
        clickDyskiIPamieciPrzenosneButton();
        verifyIsDyskiIPamieciPrzenosneLoaded();
        clickDyskiZewnetrzneIPrzenosneButton();
        verifyIsDyskiZewnetrzneIPrzenosneLoaded();
        verifyIsSearchFiltersModuleLoaded();
        enterFilterPojemnoscDyskuFromTo(FILTER_FROM, FILTER_TO);
        verifyIfCorrectFilterIsApplied(FILTER_TEXT_FROM, 0);
        verifyIfCorrectFilterIsApplied(FILTER_TEXT_TO, 1);
        verifyIsSearchResultsModuleLoaded();
        verifyIsSortowanieFilterDisplayed();
        selectOptionFromSortowanieDropdown(SORT_BY_VALUE);
        verifyIfResultsAreDisplayedSortedPriceDescendingAndFilterApplied(FILTER_FROM, FILTER_TO);
    }

    @Test
    public void allegroSearchResultsDyskiZewnetrzneIPrzenosneFilter500to1000gb_withActionBuilderMethod() {
        //method below is using action builder
        clickKomputeryButtonAfterhoverOverElektronikaLink();
        verifyIsKomputeryPageLoaded();
        clickDyskiIPamieciPrzenosneButton();
        verifyIsDyskiIPamieciPrzenosneLoaded();
        clickDyskiZewnetrzneIPrzenosneButton();
        verifyIsDyskiZewnetrzneIPrzenosneLoaded();
        verifyIsSearchFiltersModuleLoaded();
        enterFilterPojemnoscDyskuFromTo(FILTER_FROM, FILTER_TO);
        verifyIfCorrectFilterIsApplied(FILTER_TEXT_FROM, 0);
        verifyIfCorrectFilterIsApplied(FILTER_TEXT_TO, 1);
        verifyIsSearchResultsModuleLoaded();
        verifyIsSortowanieFilterDisplayed();
        selectOptionFromSortowanieDropdown(SORT_BY_VALUE);
        verifyIfResultsAreDisplayedSortedPriceDescendingAndFilterApplied(FILTER_FROM, FILTER_TO);
    }

    @After
    public void tearDown() {
    }

    private void goToAllegroHomePage() {
        logger().info("BEFORE TEST STEP: Navigating to Allegro Home Page");
        allegroHomePage = new AllegroHomePage();
        allegroHomePage.load();
    }

    private void verifyIsHomePageLoaded() {
        logger().info("BEFORE TEST STEP: Verifying if Allegro 'Home' Page is loaded");
        Assert.assertTrue("Home page is not loaded - wrong url", allegroHomePage.isLoaded());
        Assert.assertTrue("Header Search Box on Homge Page is not displayed",
                allegroHomePage.isHeaderSearchBoxDisplayed());
    }

    private void closePopUpIfDisplayed() {
        logger().info("BEFORE TEST STEP: Checking if PopUp is displayed");
        if (allegroHomePage.isNieZgadzamSieButtonDisplayed()) {
            logger().info("PopUp is displayed, clicking 'Nie zgadzam sie' button");
            allegroHomePage.clickNieZgadzamSieButton();
        }
    }

    private void clickElektronikaButton() {
        logger().info("STEP: Clicking 'Elektronika' Button");
        allegroElektronikaPage = allegroHomePage.clickElektronikaButton();
    }

    private void verifyIsElektronikaPageLoaded() {
        logger().info("STEP: Verifying if Allegro 'Elektronika' Page is loaded");
        Assert.assertTrue("'Elektronika' page is not loaded - wrong url", allegroElektronikaPage.isLoaded());
        Assert.assertTrue("'Elektronika' text is not displayed", allegroElektronikaPage.isElektronikaTextDisplayed());
        Assert.assertTrue("Categories Layout is not displayed",
                allegroElektronikaPage.isCategoriesLayoutFrameDisplayed());
    }

    private void clickKomputeryButton() {
        logger().info("STEP: Clicking 'Komputery' Button");
        allegroKomputeryPage = allegroElektronikaPage.clickKomputeryButton();
    }

    private void verifyIsKomputeryPageLoaded() {
        logger().info("STEP: Verifying if Allegro 'Komputery' Page is loaded");
        Assert.assertTrue("'Komputery' page is not loaded - wrong url", allegroKomputeryPage.isLoaded());
        Assert.assertTrue("'Komputery' text is not displayed", allegroKomputeryPage.isKomputeryTextDisplayed());
        Assert.assertTrue("'Komputery' breadcrumb is not displayed",
                allegroKomputeryPage.isKomputeryBreadcrumbDisplayed());
    }

    private void clickDyskiIPamieciPrzenosneButton() {
        logger().info("STEP: Clicking 'Dyski i pamieci przenosne' Button");
        allegroDyskiIPamieciPrzenosnePage = allegroKomputeryPage.clickDyskiIPamieciPrzenosneButton();
    }

    private void verifyIsDyskiIPamieciPrzenosneLoaded() {
        logger().info("STEP: Verifying if Allegro 'Dyski i pamieci przenosne' Page is loaded");
        Assert.assertTrue("'Dyski i pamieci przenosne' page is not loaded - wrong url",
                allegroDyskiIPamieciPrzenosnePage.isLoaded());
        Assert.assertTrue("'Dyski i pamieci przenosne' text is not displayed",
                allegroDyskiIPamieciPrzenosnePage.isDyskiIPamieciPrzenosneTextDisplayed());
        Assert.assertTrue("'Dyski i pamieci przenosne' breadcrumb is not displayed",
                allegroDyskiIPamieciPrzenosnePage.isDyskiIPamieciPrzenosneBreadcrumbDisplayed());
    }

    private void clickDyskiZewnetrzneIPrzenosneButton() {
        logger().info("STEP: Clicking 'Dyski zewnetrzne i przenosne' Button");
        allegroDyskiZewnetrzneIPrzenosnePage = allegroDyskiIPamieciPrzenosnePage.clickDyskiZewnetrzneIPrzenosneButton();
    }

    private void verifyIsDyskiZewnetrzneIPrzenosneLoaded() {
        logger().info("STEP: Verifying if Allegro 'Dyski zewnętrzne i przenośne' Page is loaded");
        Assert.assertTrue("'Dyski zewnętrzne i przenośne' page is not loaded - wrong url",
                allegroDyskiZewnetrzneIPrzenosnePage.isLoaded());
        Assert.assertTrue("'Dyski zewnętrzne i przenośne' text is not displayed",
                allegroDyskiZewnetrzneIPrzenosnePage.isDyskiZewnetrzneIPrzenosneTextDisplayed());
        Assert.assertTrue("'Dyski zewnętrzne i przenośne' breadcrumb is not displayed",
                allegroDyskiZewnetrzneIPrzenosnePage.isDyskiZewnetrzneIPrzenosneBreadcrumbDisplayed());
    }

    private void verifyIsSearchFiltersModuleLoaded() {
        logger().info("STEP: Verifying if Allegro 'Search Filters' Module is loaded");
        allegroSearchFilters = new AllegroSearchFilters();
        Assert.assertTrue("'Search Filters' Module is not loaded", allegroSearchFilters.isLoaded());
        Assert.assertTrue("'Pojemnosc dysku' Filter is not displayed",
                allegroSearchFilters.isFilterPojemnoscDyskuDisplyed());
    }

    private void enterFilterPojemnoscDyskuFromTo(String filterFrom, String filterTo) {
        logger().info("STEP: Entering data to 'Pojemnosc Dysku' filter, From: " + filterFrom + ", To: " + filterTo);
        allegroSearchFilters.enterFilterPojemnoscDyskuFromText(filterFrom);
        allegroSearchFilters.enterFilterPojemnoscDyskuToText(filterTo);
    }

    private void verifyIfCorrectFilterIsApplied(String filterText, int filterNumber) {
        logger().info("STEP: Verifying if filter: " + filterText + " is applied");
        Assert.assertEquals("Filter '" + filterText + "' is not applied", filterText,
                allegroSearchFilters.getChosenAppliedFiltersText(filterNumber));
    }

    private void verifyIsSearchResultsModuleLoaded() {
        logger().info("STEP: Verifying if Allegro 'Search Results' Module is loaded");
        allegroSearchResults = new AllegroSearchResults();
        Assert.assertTrue("'Search Results' Module is not loaded", allegroSearchResults.isLoaded());
    }

    private void verifyIsSortowanieFilterDisplayed() {
        logger().info("STEP: Verifying if 'Sortowanie' Filter is displayed");
        Assert.assertTrue("'Sortowanie' Filter is not displayed", allegroSearchResults.isFilterSortowanieDisplayed());
    }

    private void selectOptionFromSortowanieDropdown(String sortByValue) {
        logger().info("STEP: Selecting option from 'Sortownie' dropdown with value: " + sortByValue);
        allegroSearchResults.selectOptionFromSortowanieDropdown(sortByValue);
    }

    private void verifyIfResultsAreDisplayedSortedPriceDescendingAndFilterApplied(String filterFrom, String filterTo) {
        logger().info("STEP: Verifying if Search Results items are displayed, if price is sorted descending and if " +
                "filter 'Pojemnosc Dysku' from: " + filterFrom + ", to: " + filterTo + " is applied");
        Assert.assertTrue("Result list is empty!", allegroSearchResults.isAnyResultDisplayed());
        Assert.assertTrue("Prices are not sorted descending!", isItemPriceSortedDescending());
        Assert.assertTrue("Discs capacity is not in: " + filterFrom + " - " + filterTo + " range!",
                isResultDiscsCapacityInGivenGbRange());
    }

    private void clickKomputeryButtonAfterhoverOverElektronikaLink() {
        logger().info("Hovering over 'Elektronika' button, then clicking 'Komputery' button");
        allegroKomputeryPage = allegroHomePage.hoverOverElektronikaAndClickKomputeryButton();
    }

    private boolean isItemPriceSortedDescending() {
        ArrayList<String> itemPrices = allegroSearchResults.getSearchResultsPricesTexts();
        boolean sorted = true;
        for (int i = 1; i < itemPrices.size(); i++) {
            if (Double.parseDouble(itemPrices.get(i - 1).split("( zł)")[0].replace(",", ".").replace(" ", ""))
                    - Double.parseDouble(itemPrices.get(i).split("( zł)")[0].replace(",", ".").replace(" ", "")) < 0) {
                sorted = false;
                logger().info("Price is not sorted - element " + (i - 1) + ": " + itemPrices.get(i - 1) + " is lower " +
                        "that element " + i + ": " + itemPrices.get(i));
            }
        }
        if (sorted) {
            logger().info("Items correctly sorted by price descending");
        } else {
            logger().info("Items NOT sorted by price descending");
        }
        return sorted;
    }

    private boolean isResultDiscsCapacityInGivenGbRange() {
        ArrayList<String> itemDiscCapacity = allegroSearchResults.getSearchResultsDiskCapacityTexts();
        boolean filterApplied = true;
        for (String capacity : itemDiscCapacity) {
            if (Integer.parseInt(capacity.split("[ ]")[0]) < Integer.parseInt(FILTER_FROM)
                    || Integer.parseInt(capacity.split("[ ]")[0]) > Integer.parseInt(FILTER_TO)) {
                filterApplied = false;
                logger().info("Disc capacity " + capacity + " is not between " + FILTER_FROM + " and " + FILTER_TO +
                        " range");
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