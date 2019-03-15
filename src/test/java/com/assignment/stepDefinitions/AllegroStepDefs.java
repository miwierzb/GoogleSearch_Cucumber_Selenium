package com.assignment.stepDefinitions;

import com.assignment.selenium.allegro.pages.AllegroHomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static com.assignment.core.CustomLogger.logger;

public class AllegroStepDefs {

    private AllegroHomePage allegroHomePage;

    @When("User navigates to Allegro Home Page")
    public void userNavigatesToAllegroHomePage(){
        logger().info("BEFORE TEST STEP: Navigating to Allegro Home Page");
        allegroHomePage = new AllegroHomePage();
    }

    @Then("User is on Allegro Home Page")
    public void userIsOnAllegroHomePage(){
        logger().info("BEFORE TEST STEP: Verifying if Allegro 'Home' Page is loaded");
        Assert.assertTrue("Home page is not loaded - wrong url", allegroHomePage.isLoaded());
        Assert.assertTrue("Header Search Box on Homge Page is not displayed", allegroHomePage.isHeaderSearchBoxDisplayed());
    }

    @And("User closes Pop Up if it is displayed")
    public void userClosesPopUpIfItIsDisplayed(){
        logger().info("BEFORE TEST STEP: Checking if PopUp is displayed");
        if (allegroHomePage.isNieZgadzamSieButtonDisplayed()){
            logger().info("PopUp is displayed, clicking 'Nie zgadzam sie' button");
            allegroHomePage.clickNieZgadzamSieButton();
        }
    }


    @Given("User is on Allegro page")
    public void user_is_on_Allegro_page() {

    }

    @And("uset is {int}")
    public void uset_is(Integer int1) {

    }

    @And("User is {int}")
    public void user_is(Integer int1) {

    }

    @When("User defines")
    public void user_defines() {

    }

    @Then("Something happens")
    public void something_happens() {

    }

    @Then("This happens")
    public void this_happens() {

    }

}
