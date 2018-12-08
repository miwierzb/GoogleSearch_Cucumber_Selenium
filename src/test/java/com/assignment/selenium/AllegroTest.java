package com.assignment.selenium;

import com.assignment.selenium.pages.allegro.AllegroHomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.assignment.core.CustomLogger.logger;

public class AllegroTest extends BaseTest {

    private AllegroHomePage allegroHomePage;

    @Before
    public void setUp() {
        logger().info("BEFORE TEST STEP: Navigating to Allegro Home Page");
        allegroHomePage = new AllegroHomePage();
    }

    @Test
    public void allegroSearchResultsDyskiZewnetrzneIPrzenosneFilter500to1000gb(){
        Assert.assertTrue("dsa", false);
    }

    @After
    public void tearDown() {
    }

}
