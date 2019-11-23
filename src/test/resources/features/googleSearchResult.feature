@Selenium
@GoogleSearchResult
Feature: GoogleSearchResult
  This feature contains tests for Google Search Result Page.

  Background:
    Given   I navigate to Google Home Page
    And     I'm on Google Home Page

  Scenario: Google Search Result Page bookmarks bar contains correct bookmarks
    Given 	I enter text 'test' into search box
    And     I click 'Google Search' button
    When	I'm on Google Search Result Page
    Then	I should see correct bookmarks
          | All    |
          | Images |
          | News   |
          | Videos |
          | Maps   |

  Scenario: Clicking 'Images' bookmark on Google Search Result Page changes result 	view from all to images
    Given 	I enter text 'test' into search box
    And     I click 'Google Search' button
    And     I'm on Google Search Result Page
    And		I should see correct search result for 'test'
    When	I click 'Images' bookmark
    Then	I should see images search result for 'test'

  Scenario Outline: Correct search results are displayed on Google Search Result Page for searched keyword <keyword> from Google Home Page
    When    I enter text <keyword> into search box
    And     I click 'Google Search' button
    Then	I should be redirected to Google Search Result Page
    And		I should see search result for keyword <keyword>

    Examples:
      | keyword     |
      | test        |
      | search      |
      | test search |
      | 1234        |

  Scenario Outline: Correct search results are displayed on Google Search Result Page for searched keyword <keyword> from Google Search Result Page
    Given 	I enter text 'test' into search box
    And     I click 'Google Search' button
    And		I should be redirected to Google Search Result Page
    When	I enter text <keyword> into search box on Search Result Page
    And     I click magnifier button
    Then	I should see search result for keyword <keyword>

    Examples:
      | keyword     |
      | test        |
      | search      |
      | test search |
      | 1234        |

  Scenario Outline: 'Your search did not match any documents' message is displayed on Search Result Page for keyword <keyword>
    Given 	I enter text <keyword> into search box
    And     I click 'Google Search' button
    Then	I should be redirected to Google Search Result Page
    And		I should see message 'Your search - <keyword> - did not match any documents'
    Examples:
      | keyword     |
      | .......     |
      | =========== |
