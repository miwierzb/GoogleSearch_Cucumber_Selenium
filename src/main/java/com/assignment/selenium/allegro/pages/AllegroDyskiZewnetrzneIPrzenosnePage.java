package com.assignment.selenium.allegro.pages;

import com.assignment.selenium.BasePage;
import org.openqa.selenium.By;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;

public class AllegroDyskiZewnetrzneIPrzenosnePage extends BasePage {

    private final static By selectorDyskiZewnetrzneIPrzenosneText = By.xpath("//span[@class='listing-title__category' and text()='Dyski zewnętrzne i przenośne']");
    private final static By selectorDyskiZewnetrzneIPrzenosneBreadcrumb = By.xpath("//div[@data-role='breadcrumb-item']//*[@itemprop='name' and text()='Dyski zewnętrzne i przenośne']");
    private final static String url = "https://allegro.pl/kategoria/dyski-i-pamieci-przenosne-dyski-zewnetrzne-i-przenosne";

    @Override
    public boolean isLoaded() {
        load();
        logger().info("Checking if Allegro 'Dyski zewnętrzne i przenośne' Page is loaded");
        if (getDriver().getCurrentUrl().contains(url)) {
            logger().info("'Dyski zewnętrzne i przenośne' Page LOADED");
            return true;
        }
        logger().info("'Dyski zewnętrzne i przenośne' Page NOT LOADED");
        return false;
    }

    @Override
    public void load() {
        logger().info("Loading Allegro 'Dyski zewnętrzne i przenośne' Page...");
        waitForPageToLoad();
    }

    public boolean isDyskiZewnetrzneIPrzenosneTextDisplayed() {
        logger().info("Checking if 'Dyski zewnętrzne i przenośne' text is displayed");
        return isElementDisplayed(selectorDyskiZewnetrzneIPrzenosneText);
    }

    public boolean isDyskiZewnetrzneIPrzenosneBreadcrumbDisplayed() {
        logger().info("Checking if 'Dyski zewnętrzne i przenośne' breadcrumb is displayed");
        return isElementDisplayed(selectorDyskiZewnetrzneIPrzenosneBreadcrumb);
    }

}
