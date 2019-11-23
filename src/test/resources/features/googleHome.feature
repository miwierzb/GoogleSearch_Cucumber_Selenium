@Selenium
@GoogleHomePage
Feature: GoogleHomePage
  This feature contains tests for Google Home Page.

  Background:
    Given   I navigate to Google Home Page

  Scenario: 'Gmail' link redirects to Gmail Home page
    Given 	I'm on Google Home Page
    When	I click 'Gmail' button
    Then	I should be redirected to Gmail Home Page

  Scenario: Google Home Page Footer contains correct links
    Given 	I'm on Google Home Page
    When	I'm Google Home Page
    Then	I should see correct Footer links
            | Advertising      |
            | Business         |
            | About            |
            | How Search works |

  Scenario: 'I'm Feeling Lucky' button redirects to Doodles Page
    Given 	I'm on Google Home Page
    When	I click 'I'm Feeling Lucky' button
    Then	I should be redirected to Doodles Page

  Scenario: 'Google Search' button redirects to 'Google Search Result' Page
    Given  I'm on Google Home Page
    When   I enter text 'test' into search TextField
    And    I click 'Google Search' button
    Then   I should be redirected to Google Search Result Page
