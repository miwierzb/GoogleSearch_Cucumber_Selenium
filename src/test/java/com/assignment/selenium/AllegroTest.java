package com.assignment.selenium;

import com.assignment.selenium.pages.allegro.AllegroElektronikaPage;
import com.assignment.selenium.pages.allegro.AllegroHomePage;
import com.assignment.selenium.pages.allegro.AllegroKomputeryPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.assignment.core.CustomLogger.logger;

public class AllegroTest extends BaseTest {

    private AllegroHomePage allegroHomePage;
    private AllegroElektronikaPage allegroElektronikaPage;
    private AllegroKomputeryPage allegroKomputeryPage;

    @Before
    public void setUp() {
        goToAllegroHomePage();
        verifyIsHomePageLoaded();
        closePopUpIfDisplayed();
    }

    @Test
    public void allegroSearchResultsDyskiZewnetrzneIPrzenosneFilter500to1000gb(){
        clickElektronikaButton();
        verifyIsElektronikaPageLoaded();
        clickKomputeryButton();
    }

    @After
    public void tearDown() {
    }

    private void goToAllegroHomePage(){
        logger().info("BEFORE TEST STEP: Navigating to Allegro Home Page");
        allegroHomePage = new AllegroHomePage();
    }

    private void verifyIsHomePageLoaded(){
        logger().info("BEFORE TEST STEP: Verifying if Allegro 'Home' Page is loaded");
        Assert.assertTrue("Home page is not loaded - wrong url", allegroHomePage.isLoaded());
        Assert.assertTrue("Header Search Box on Homge Page is not displayed", allegroHomePage.isHeaderSearchBoxDisplayed());
    }

    private void closePopUpIfDisplayed(){
        logger().info("BEFORE TEST STEP: Checking if PopUp is displayed");
        if (allegroHomePage.isNieZgadzamSieButtonDisplayed()){
            logger().info("PopUp is displayed, clicking 'Nie zgadzam sie' button");
            allegroHomePage.clickNieZgadzamSieButton();
        }
    }

    private void clickElektronikaButton(){
        logger().info("STEP: Clicking 'Elektronika' Button");
        allegroElektronikaPage = allegroHomePage.clickElektronikaButton();
    }

    private void verifyIsElektronikaPageLoaded(){
        logger().info("STEP: Verifying if Allegro 'Elektronika' Page is loaded");
        Assert.assertTrue("'Elektronika' page is not loaded - wrong url", allegroElektronikaPage.isLoaded());
        Assert.assertTrue("'Elektronika' text is not displayed", allegroElektronikaPage.isElektronikaTextDisplayed());
        Assert.assertTrue("Categories Layout is not displayed", allegroElektronikaPage.isCategoriesLayoutFrameDisplayed());
    }

    private void clickKomputeryButton(){
        logger().info("STEP: Clicking 'Komputery' Button");
        allegroKomputeryPage = allegroElektronikaPage.clickKomputeryButton();
    }

}
