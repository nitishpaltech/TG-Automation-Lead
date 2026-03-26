package components;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import constants.PriceTabType;

public class HomePriceSectionComponent {

    WebDriver driver;

    public HomePriceSectionComponent(WebDriver driver) {

        this.driver = driver;

    }


    // section heading

    By priceSection =
        By.xpath("//h2[contains(text(),'Tractor By Price')]");


    // tab locators

    By under3 =
        By.xpath("//span[contains(text(),'Under 3 Lakh')]");

    By threeToFive =
        By.xpath("//span[contains(text(),'3 Lakh - 5 Lakh')]");

    By fiveToSeven =
        By.xpath("//span[contains(text(),'5 Lakh - 7 Lakh')]");

    By sevenToTen =
        By.xpath("//span[contains(text(),'7 Lakh - 10 Lakh')]");

    By aboveTen =
        By.xpath("//span[contains(text(),'Above 10 Lakh')]");



    public void selectTab(PriceTabType tabType) {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement section =
            wait.until(ExpectedConditions
            .visibilityOfElementLocated(priceSection));

        ((JavascriptExecutor) driver)
        .executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        section
        );


        By tabLocator = null;


        switch(tabType) {

        case UNDER_3_LAKH:

            tabLocator = under3;
            break;


        case THREE_TO_FIVE:

            tabLocator = threeToFive;
            break;


        case FIVE_TO_SEVEN:

            tabLocator = fiveToSeven;
            break;


        case SEVEN_TO_TEN:

            tabLocator = sevenToTen;
            break;


        case ABOVE_TEN:

            tabLocator = aboveTen;
            break;

        }


        wait.until(ExpectedConditions
        .elementToBeClickable(tabLocator));

        WebElement tabElement =
                driver.findElement(tabLocator);

        ((JavascriptExecutor) driver)
        .executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        tabElement
        );

        wait.until(ExpectedConditions
        .elementToBeClickable(tabElement));
        try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ((JavascriptExecutor) driver)
        .executeScript("arguments[0].click();", tabElement);

    }


   public void clickFirstCardCTP(PriceTabType tabType) {

    WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(15));

    String tabPanelId = "";

    switch(tabType) {

        case UNDER_3_LAKH:
            tabPanelId = "nav-tractorByPrice-0";
            break;

        case THREE_TO_FIVE:
            tabPanelId = "nav-tractorByPrice-1";
            break;

        case FIVE_TO_SEVEN:
            tabPanelId = "nav-tractorByPrice-2";
            break;

        case SEVEN_TO_TEN:
            tabPanelId = "nav-tractorByPrice-3";
            break;

        case ABOVE_TEN:
            tabPanelId = "nav-tractorByPrice-4";
            break;
    }


    // wait panel visible

    By panelLocator =
        By.id(tabPanelId);

    WebElement panel =
        wait.until(ExpectedConditions
        .visibilityOfElementLocated(panelLocator));


    // scroll panel center

    ((JavascriptExecutor) driver)
    .executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        panel
    );


    // wait card button load

    By ctpButton =
        By.xpath("(//div[@id='" + tabPanelId +
        "']//button[contains(text(),'Check Tractor Price')])[1]");


    WebElement ctp =
        wait.until(ExpectedConditions
        .presenceOfElementLocated(ctpButton));


    wait.until(ExpectedConditions
        .elementToBeClickable(ctp));


    // JS click safest

    ((JavascriptExecutor) driver)
    .executeScript(
        "arguments[0].click();",
        ctp
    );

}

}