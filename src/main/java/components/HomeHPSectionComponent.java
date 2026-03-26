package components;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import constants.HPTabType;

public class HomeHPSectionComponent {

    WebDriver driver;

    public HomeHPSectionComponent(WebDriver driver) {

        this.driver = driver;

    }


    // section heading

    By hpSection =
        By.xpath("//h2[contains(text(),'Tractor By HP')]");


    // tab locators

    By under30 =
        By.id("nav-tractorByHP-0-tab");

    By hp30to50 =
        By.id("nav-tractorByHP-1-tab");

    By hp50to70 =
        By.id("nav-tractorByHP-2-tab");

    By hp70to100 =
        By.id("nav-tractorByHP-3-tab");

    By above100 =
        By.id("nav-tractorByHP-4-tab");


    public void selectTab(HPTabType tabType) {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement section =
            wait.until(ExpectedConditions
            .visibilityOfElementLocated(hpSection));

        ((JavascriptExecutor) driver)
        .executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        section
        );


        By tabLocator = null;


        switch(tabType) {

        case UNDER_30_HP:

            tabLocator = under30;
            break;


        case HP_30_TO_50:

            tabLocator = hp30to50;
            break;


        case HP_50_TO_70:

            tabLocator = hp50to70;
            break;


        case HP_70_TO_100:

            tabLocator = hp70to100;
            break;


        case ABOVE_100_HP:

            tabLocator = above100;
            break;

        }


        WebElement tabElement =
            wait.until(ExpectedConditions
            .elementToBeClickable(tabLocator));

        ((JavascriptExecutor) driver)
        .executeScript("arguments[0].click();", tabElement);

    }



    public void clickFirstCardCTP(HPTabType tabType) {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        String tabPanelId = "";


        switch(tabType) {

        case UNDER_30_HP:

            tabPanelId = "nav-tractorByHP-0";
            break;


        case HP_30_TO_50:

            tabPanelId = "nav-tractorByHP-1";
            break;


        case HP_50_TO_70:

            tabPanelId = "nav-tractorByHP-2";
            break;


        case HP_70_TO_100:

            tabPanelId = "nav-tractorByHP-3";
            break;


        case ABOVE_100_HP:

            tabPanelId = "nav-tractorByHP-4";
            break;

        }


        WebElement panel =
            driver.findElement(By.id(tabPanelId));

        ((JavascriptExecutor) driver)
        .executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        panel
        );


        By ctpButton =
            By.xpath("(//div[@id='" + tabPanelId +
            "']//button[contains(text(),'Check Tractor Price')])[1]");


        wait.until(ExpectedConditions
        .elementToBeClickable(ctpButton));


        WebElement ctp =
                driver.findElement(ctpButton);

        ((JavascriptExecutor) driver)
        .executeScript("arguments[0].click();", ctp);

    }

}