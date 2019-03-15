$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/com/assignment/features/allegroSearch.feature");
formatter.feature({
  "name": "allegroSearch",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@AllegroSearch"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User navigates to Allegro Home Page",
  "keyword": "When "
});
formatter.match({
  "location": "AllegroStepDefs.userNavigatesToAllegroHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User is on Allegro Home Page",
  "keyword": "Then "
});
formatter.match({
  "location": "AllegroStepDefs.userIsOnAllegroHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User closes Pop Up if it is displayed",
  "keyword": "And "
});
formatter.match({
  "location": "AllegroStepDefs.userClosesPopUpIfItIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "validate result for custom search with filters for \u0027Dyski zewnetrzne i przenosne\u0027",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@AllegroSearch"
    },
    {
      "name": "@AllegroFilter"
    }
  ]
});
formatter.step({
  "name": "User is on Allegro page",
  "keyword": "Given "
});
formatter.match({
  "location": "AllegroStepDefs.user_is_on_Allegro_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "uset is 1",
  "keyword": "And "
});
formatter.match({
  "location": "AllegroStepDefs.uset_is(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User is 2",
  "keyword": "And "
});
formatter.match({
  "location": "AllegroStepDefs.user_is(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User defines",
  "keyword": "When "
});
formatter.match({
  "location": "AllegroStepDefs.user_defines()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Something happens",
  "keyword": "Then "
});
formatter.match({
  "location": "AllegroStepDefs.something_happens()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "This happens",
  "keyword": "And "
});
formatter.match({
  "location": "AllegroStepDefs.this_happens()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});