package com.assignment.selenium.allegro.pages;

import com.assignment.selenium.BasePage;
import org.openqa.selenium.By;

import static com.assignment.core.CustomLogger.logger;
import static com.assignment.core.WebDriverInitializer.getDriver;

public class AllegroDyskiIPamieciPrzenosnePage extends BasePage {

    private final static By selectorDyskiIPamieciPrzenosneText = By.xpath("//span[@class='listing-title__category' and text()='Dyski i pamięci przenośne']");
    private final static By selectorDyskiIPamieciPrzenosneBreadcrumb = By.xpath("//div[@data-role='breadcrumb-item']//*[@itemprop='name' and text()='Dyski i pamięci przenośne']");
    private final static By selectorDyskiZewnetrzneIPrzenosneButton = By.xpath("//a[text()='Dyski zewnętrzne i przenośne']");
    private final static String url = "https://allegro.pl/kategoria/dyski-i-pamieci-przenosne";

    @Override
    public boolean isLoaded() {
        load();
        logger().info("Checking if Allegro 'Dyski i pamieci przenosne' Page is loaded");
        if (getDriver().getCurrentUrl().contains(url)) {
            logger().info("'Dyski i pamieci przenosne' Page LOADED");
            return true;
        }
        logger().info("'Dyski i pamieci przenosne Page' NOT LOADED");
        return false;
    }

    @Override
    public void load() {
        logger().info("Loading Allegro 'Dyski i pamieci przenosne' Page...");
        waitForPageToLoad();
    }

    public boolean isDyskiIPamieciPrzenosneTextDisplayed() {
        logger().info("Checking if 'Dyski i pamieci przenosne' text is displayed");
        return isElementDisplayed(selectorDyskiIPamieciPrzenosneText);
    }

    public boolean isDyskiIPamieciPrzenosneBreadcrumbDisplayed() {
        logger().info("Checking if 'Dyski i pamieci przenosne' breadcrumb is displayed");
        return isElementDisplayed(selectorDyskiIPamieciPrzenosneBreadcrumb);
    }

    public AllegroDyskiZewnetrzneIPrzenosnePage clickDyskiZewnetrzneIPrzenosneButton() {
        logger().info("Clicking 'Dyski zewnetrzne i przenosne' button");
        click(selectorDyskiZewnetrzneIPrzenosneButton);
        return new AllegroDyskiZewnetrzneIPrzenosnePage();
    }

}
