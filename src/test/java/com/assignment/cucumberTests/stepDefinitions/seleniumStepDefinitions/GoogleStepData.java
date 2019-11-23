package com.assignment.cucumberTests.stepDefinitions.seleniumStepDefinitions;

import com.assignment.core.SharedTestData;
import com.assignment.selenium.google.modules.GoogleSearchResultTopMenuBar;
import com.assignment.selenium.google.pages.GoogleHomePage;
import com.assignment.selenium.google.pages.GoogleSearchResultsPage;

public class GoogleStepData {
    public GoogleHomePage googleHomePage;
    public GoogleSearchResultsPage googleSearchResultsPage;
    public GoogleSearchResultTopMenuBar googleSearchResultTopMenuBar;
    public SharedTestData sharedTestData = new SharedTestData();
}
