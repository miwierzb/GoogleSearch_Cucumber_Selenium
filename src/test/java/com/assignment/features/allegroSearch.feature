@AllegroSearch
Feature: allegroSearch

  Background:
    When  User navigates to Allegro Home Page
    Then  User is on Allegro Home Page
    And   User closes Pop Up if it is displayed

@AllegroFilter
  Scenario: validate result for custom search with filters for 'Dyski zewnetrzne i przenosne'
    Given User is on Allegro page
    And   uset is 1
    And   User is 2
    When  User defines
    Then  Something happens
    And   This happens