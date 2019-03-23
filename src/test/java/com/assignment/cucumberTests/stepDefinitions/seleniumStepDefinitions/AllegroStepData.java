package com.assignment.cucumberTests.stepDefinitions.seleniumStepDefinitions;

import com.assignment.core.SharedTestData;
import com.assignment.selenium.allegro.modules.AllegroSearchFilters;
import com.assignment.selenium.allegro.modules.AllegroSearchResults;
import com.assignment.selenium.allegro.pages.*;

public class AllegroStepData {
    public AllegroHomePage allegroHomePage;
    public AllegroElektronikaPage allegroElektronikaPage;
    public AllegroKomputeryPage allegroKomputeryPage;
    public AllegroDyskiIPamieciPrzenosnePage allegroDyskiIPamieciPrzenosnePage;
    public AllegroDyskiZewnetrzneIPrzenosnePage allegroDyskiZewnetrzneIPrzenosnePage;
    public AllegroSearchFilters allegroSearchFilters;
    public AllegroSearchResults allegroSearchResults;
    public SharedTestData sharedTestData = new SharedTestData();
}
