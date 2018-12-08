package com.assignment.core;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import static com.assignment.core.CustomLogger.logger;

public class WebEventListener extends AbstractWebDriverEventListener {

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        logger().debug("Navigating to: " + url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        logger().debug("Navigated to: " + url);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        logger().debug("Navigating BACK");
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        logger().debug("Navigated BACK");
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        logger().debug("Navigating FORWARD");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        logger().debug("Navigated FORWARD");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        logger().debug("Refreshing...");
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        logger().debug("Refreshed");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger().debug("Looking for Element By: " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger().debug("Found Element By: " + by.toString());
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger().debug("Clicking on: " + element.toString());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        logger().debug("Clicked on: " + element.toString());
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        logger().debug("Taking screenshot" + target.toString());
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        logger().debug("Screenshot taken" + target.toString());
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        logger().debug("Getting text from: " + element.toString());
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        logger().debug("Got text: " + text +" from: " + element.toString());
    }
}
