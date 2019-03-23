package com.assignment.cucumberTests.stepDefinitions.apiStepDefinitions.JsonPlaceholder;

import com.assignment.api.Comments;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.PropertiesManager.getProperty;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class JsonPlaceholderStepDefs {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private static final String BASE_URL = getProperty("api.base.url");
    private List<Comments> comments;

    @Given("^Webservice is up and running$")
    public void webserviceIsUpAndRunning() {
        logger().info("TEST STEP: Adding webservice base url: " + BASE_URL);
        request = given().baseUri(BASE_URL).log().all();
    }

    @When("^GET call is performed on (.*) endpoint$")
    public void performGetCall(String endpoint) {
        logger().info("TEST STEP: Perform GET call on: " + endpoint + " emdpoint");
        response = request.when().get(endpoint);
    }

    @Then("^Response is received with status code (\\d+)$")
    public void verifyResponseStatusCode(int statusCode) {
        logger().info("TEST STEP: Verifying if status code is equal to: " + statusCode);
        json = response.then().log().all().statusCode(statusCode);
    }

    @And("Response is not empty")
    public void verifyIsResponseBodyEmpty() {
        logger().info("TEST STEP: Verifying if response body is not empty");
        json.body(not(isEmptyOrNullString()));
    }

    @And("^Response contains the following fields$")
    public void verifyResponseFields(Map<String, String> responseFields) {
        logger().info("EST STEP: Verifying if response body contains " + responseFields.toString());
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            json.body(field.getKey(), hasItem(field.getValue()));
        }
    }

    @And("^Response is filtered by (.+) and 'body' that contains (.+)$")
    public void responseFilteredBy(int filterPostId, String filterText) {
        Comments[] commentsTab = response.as(Comments[].class);
        comments = new ArrayList<>(Arrays.asList(commentsTab));
        System.out.println("Number of comments BEFORE filtering: " + comments.size());
        comments.removeIf(comment -> comment.getPostId() != filterPostId || !comment.getBody().contains(filterText));
        System.out.println("Number of comments AFTER filtering: " + comments.size());
        System.out.println(comments.toString());
    }

    @And("^User should see only data that matches filter parameters (.+) amd 'body' that contains (.+)$")
    public void verifyFilteredBody(int filterPostId, String filterText) {
        for (Comments comment : comments) {
            Assert.assertEquals("PostId is different than " + filterPostId, filterPostId, comment.getPostId());
            Assert.assertTrue("Body does not contain '" + filterText + "' text",
                    comment.getBody().contains(filterText));
        }
    }

}
