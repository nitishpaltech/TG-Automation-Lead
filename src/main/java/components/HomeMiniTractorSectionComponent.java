package components;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class HomeMiniTractorSectionComponent {

    WebDriver driver;

    public HomeMiniTractorSectionComponent(WebDriver driver) {

        this.driver = driver;

    }


    // section locator

    By miniTractorSection =
        By.xpath("//h2[contains(text(),'Mini Tractors In India')]");


    // click first card CTA

    public void clickFirstCardCTP() {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement section =
            wait.until(ExpectedConditions
            .visibilityOfElementLocated(miniTractorSection));

        ((JavascriptExecutor) driver)
        .executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        section
        );


        By firstCardCTP =
            By.xpath(
            "(//h2[contains(text(),'Mini Tractors In India')]"
            + "/ancestor::section"
            + "//button[contains(text(),'Check Tractor Price')])[1]"
            );


        WebElement ctp =
            wait.until(ExpectedConditions
            .elementToBeClickable(firstCardCTP));


        ((JavascriptExecutor) driver)
        .executeScript(
        "arguments[0].click();",
        ctp
        );

    }

}