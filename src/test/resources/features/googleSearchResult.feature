@Selenium
@Google
@GoogleSearchResult
Feature: GoogleSearchResult
  This feature contains tests for Google Search Result Page.

  Background:
    Given I navigate to Google Home Page
    And   I'm on Google Home Page

  Scenario: Google Search Result Page bookmarks bar contains correct bookmarks
    Given I enter text 'test' into search box
    And   I click 'Google Search' button
    When  I'm on Google Search Result Page
    Then  I should see correct bookmarks
          | All    |
          | Images |
          | News   |
          | Videos |
          | Maps   |

  Scenario Outline: Correct 'Images' search results are displayed on Image Search Result Page for '<searchText>'
    Given I enter text '<searchText>' into search box
    And   I click 'Google Search' button
    And   I'm on Google Search Result Page
    And   I should see correct search result for '<searchText>'
    When  I click 'Images' bookmark
    Then  I should land on Images Search Results Page
    And   I should see images search result for '<searchText>'

    Examples:
      | searchText  |
      | test        |
      | search      |
      | test search |

  Scenario Outline: Correct search results are displayed on Google Search Result Page for '<searchText>' from Google Home Page
    When  I enter text '<searchText>' into search box
    And   I click 'Google Search' button
    Then  I should be redirected to Google Search Result Page
    And   I should see correct search result for '<searchText>'

    Examples:
      | searchText  |
      | test        |
      | search      |
      | test search |
      | 1234        |

  Scenario Outline: Correct search results are displayed on Google Search Result Page for '<searchText>' from Google Search Result Page
    Given I enter text 'test' into search box
    And   I click 'Google Search' button
    And   I should be redirected to Google Search Result Page
    When  I enter text '<searchText>' into search box on Search Result Page
    And   I click 'Magnifier' button
    Then  I should see correct search result for '<searchText>'

    Examples:
      | searchText  |
      | test        |
      | search      |
      | test search |
      | 1234        |

  Scenario Outline: Message 'Your search did not match any documents' message is displayed for '<searchText>' search on Search Result Page
    When  I enter text '<searchText>' into search box
    And   I click 'Google Search' button
    Then  I should be redirected to Google Search Result Page
    And   I should see message 'Your search - <searchText> - did not match any documents'

    Examples:
      | searchText  |
      | ++++++      |
      | =========== |
