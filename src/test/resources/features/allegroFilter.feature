@Selenium
@Allegro
@AllegroFilter
Feature: allegroSearch

  # There are many ways of writing test scenarios in Gherkin syntax.
  # I've been working on different projects and the way scenario was written was discussed with client at the beginning
  # (even if some of these are considered bad practice)
  # I will show two ways of writing scenarios that were most commonly used below.

  Background:
    When  I navigate to Allegro Home Page
    Then  I'm on Allegro Home Page
    And   I close Pop Up if it is displayed

  #Scenarios below were written in a 'business' way, with only few steps describing most important events.
  #Few different actions may be implemented under one step to keep scenario short.
  Scenario: Custom search results with filters for 'Dyski zewnetrzne i przenosne'
    Given I'm on Allegro Home Page
    And   I navigate to 'Dyski zewnetrzne i przenosne' page
    When  I apply search filters from 500 gb to 1000 gb and price_descending sorting
    Then  I should see correctly filtered results for 500 gb to 1000 gb and price_descending


  Scenario Outline: Custom search results with filters <filterFrom> gb to <filterTo> gb and price descending for 'Dyski zewnetrzne i przenosne' - short
    Given I'm on Allegro Home Page
    And   I navigate to 'Dyski zewnetrzne i przenosne' page
    When  I apply search filters from <filterFrom> gb to <filterTo> gb and <option> sorting
    Then  I should see correctly filtered results for <filterFrom> gb to <filterTo> gb and <option>

    Examples:
      | filterFrom | filterTo  | option           |
      | 500        | 1000      | price_descending |
      | 200        | 500       | price_ascending  |

  #Scenario below is written in a more 'technical' way where from business point of view all actions and validations
  # are important and we want to show this in test scenario.
  #Most of the steps in this case contains singe actions, all validations are separated from actions.
  Scenario Outline: Custom search results with filters <filterFrom> gb to <filterTo> gb and price descending for 'Dyski zewnetrzne i przenosne' - long

    Given I'm on Allegro Home Page

    When  I hover over 'Elektronika' link and click 'Komputery' button
    Then  I should land on 'Komputery' page

    When  I click on 'Dyski i pamieci przenosne' button
    Then  I should land on 'Dyski i pamieci przenosne' page

    When  I click on 'Dyski zewnetrzne i przenosne' button
    Then  I should land on 'Dyski zewnetrzne i przenosne' page
    And   I should see Search filter module loaded
    And   I should see 'Pojemnosc dysku' filter in Search filter module

    When  I enter from <filterFrom> gb to <filterTo> gb in 'Pojemnosc dysku' filter
    Then  I should see from <filterFrom> gb to <filterTo> gb filter applied
    And   I should see Search Results module loaded
    And   I should see 'Sortowanie' filter

    When  I select <option> from 'Sortowanie' filter
    Then  I should see correctly filtered results for <filterFrom> gb to <filterTo> gb and <option>

    Examples:
      | filterFrom | filterTo  | option           |
      | 500        | 1000      | price_descending |
      | 200        | 500       | price_ascending  |
