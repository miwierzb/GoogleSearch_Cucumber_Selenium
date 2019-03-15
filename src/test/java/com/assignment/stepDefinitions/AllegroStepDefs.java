package com.assignment.stepDefinitions;

import com.assignment.selenium.allegro.modules.AllegroSearchFilters;
import com.assignment.selenium.allegro.modules.AllegroSearchResults;
import com.assignment.selenium.allegro.pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.assignment.core.CustomLogger.logger;

public class AllegroStepDefs {

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
    public void applySearchFilters(int from, int to){

    }

    @Then("^I should see correctly filtered results$")
    public void verifyCorrectlyFilteredResults(){

    }


}
