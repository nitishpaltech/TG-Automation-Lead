package components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import constants.HomeTabType;

public class HomeTractorSectionComponent {

    WebDriver driver;

    public HomeTractorSectionComponent(WebDriver driver) {

        this.driver = driver;

    }

    // Tabs
    By tractorsIndiaSection =
            By.xpath("//h2[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'tractors in india')]");

    By popularTab =
            By.id("nav-indiaTractorSec-0-tab");

    By latestTab =
            By.id("nav-indiaTractorSec-1-tab");

    By upcomingTab =
            By.id("nav-indiaTractorSec-2-tab");


    // First tractor card CTA

    By firstCardCTPButton =
    		By.xpath("(//div[contains(@class,'tab-pane') and contains(@class,'active')]//button[contains(text(),'Check Tractor Price')])[1]");


    public void selectTab(HomeTabType tabType) {
    	
    	System.out.println("Switching to tab: " + tabType);

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement section =
                wait.until(ExpectedConditions
                .visibilityOfElementLocated(tractorsIndiaSection));

        ((JavascriptExecutor) driver)
                .executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                section
                );

        By tabLocator = null;

        switch(tabType) {

            case POPULAR:

                tabLocator = popularTab;
                break;

            case LATEST:

                tabLocator = latestTab;
                break;

            case UPCOMING:

                tabLocator = upcomingTab;
                break;

        }

        wait.until(ExpectedConditions
                .elementToBeClickable(tabLocator));

        driver.findElement(tabLocator).click();

    }


    public void clickFirstCardCTP(HomeTabType tabType) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        String tabPanelId = "";

        switch(tabType) {

            case POPULAR:
                tabPanelId = "nav-indiaTractorSec-0";
                break;

            case LATEST:
                tabPanelId = "nav-indiaTractorSec-1";
                break;

            case UPCOMING:
                tabPanelId = "nav-indiaTractorSec-2";
                break;

        }

        By ctpButton =
            By.xpath("(//div[@id='" + tabPanelId +
            "']//button[contains(text(),'Check Tractor Price')])[1]");

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(ctpButton));

        wait.until(ExpectedConditions
                .elementToBeClickable(ctpButton));

        driver.findElement(ctpButton).click();

    }

}