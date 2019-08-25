package com.assignment.selenium.allegro.pages;

import com.assignment.selenium.BasePage;
import org.openqa.selenium.By;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;

public class AllegroElektronikaPage extends BasePage {

    private final static By selectorElektronikaText = By.xpath("//h1[text()='Elektronika ']");
    private final static By selectorCategoriesLayoutFrame = By.cssSelector("[data-box-name='drzewo kategorii - trafność']");
    private final static By selectorKomputeryButton = By.cssSelector("[data-box-name='Nagłówek kategorii Komputery i tablety'] [href='/kategoria/komputery?order=m']");
    private final static String url = "https://allegro.pl/dzial/elektronika";

    @Override
    public boolean isLoaded() {
        load();
        logger().info("Checking if Allegro 'Elektronika' Page is loaded");
        if (getDriver().getCurrentUrl().equals(url)) {
            logger().info("'Elektronika' Page LOADED");
            return true;
        }
        logger().info("'Elektronika' Page NOT LOADED");
        return false;
    }

    @Override
    public void load() {
        logger().info("Loading Allegro 'Elektronika' Page...");
        waitForPageToLoad();
    }

    public boolean isElektronikaTextDisplayed() {
        logger().info("Checking if 'Elektronika' text is displayed");
        return isElementDisplayed(selectorElektronikaText);
    }

    public boolean isCategoriesLayoutFrameDisplayed() {
        logger().info("Checking if Categories Layout is displayed");
        return isElementDisplayed(selectorCategoriesLayoutFrame);
    }

    public AllegroKomputeryPage clickKomputeryButton() {
        logger().info("Clicking 'Komputery' button");
        click(selectorKomputeryButton);
        return new AllegroKomputeryPage();
    }

}