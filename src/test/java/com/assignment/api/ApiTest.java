package com.assignment.api;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.*;

public class ApiTest {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static final String ENDPOINT = "/comments";
    private static final String EMAIL = "Jayne_Kuhic@sydney.com";
    private static final int ZERO_SIZE = 0;
    private static final int FILTER_POST_ID = 1;
    private static final String FILTER_TEXT = "non";

    @Test
    public void getCommentsVerifyStatusCodeNumberOfCommentsAndChosenEmailPresence()
    {
        given().
                baseUri(BASE_URL).
                log().all().
        when().
                get(ENDPOINT).
        then().
                log().all().
                statusCode(SC_OK).
        and().
                body("", hasSize(greaterThan(ZERO_SIZE))).
        and().
                body("email", hasItem(EMAIL));
    }

    @Test
    public void getCommentsVerifyIsFilteredByPostIdAndTextContent() {
        List<Comments> comments = filterByPostIdAndTextContent(FILTER_POST_ID, FILTER_TEXT);
        for (Comments comment : comments){
            Assert.assertEquals("PostId is different than " + FILTER_POST_ID, FILTER_POST_ID, comment.getPostId());
            Assert.assertTrue("Body does not contain '" + FILTER_TEXT + "' text", comment.getBody().contains(FILTER_TEXT));
        }
    }

    private List<Comments> filterByPostIdAndTextContent(int postId, String searchedText)
    {
        Comments[] commentsTab = given().get("https://jsonplaceholder.typicode.com/comments").as(Comments[].class);
        List<Comments> comments = new ArrayList<>(Arrays.asList(commentsTab));
        System.out.println("Number of comments BEFORE filtering: " + comments.size());
        for (Iterator<Comments> iterator = comments.iterator(); iterator.hasNext();) {
            Comments comment = iterator.next();
            if (comment.getPostId() != postId || !comment.getBody().contains(searchedText)){
                iterator.remove();
            }
        }
        System.out.println("Number of comments AFTER filtering: " + comments.size());
        System.out.println(comments.toString());
        return comments;
    }
}

