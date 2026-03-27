package components;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class HomeGetOfferBannerComponent {

    WebDriver driver;

    public HomeGetOfferBannerComponent(WebDriver driver) {

        this.driver = driver;

    }


    // Banner locator

    By getOfferBtn =
    	    By.xpath("//a[contains(@class,'dealer_banner')]");


    public void clickGetOfferCTA() {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));


        WebElement btn =
            wait.until(ExpectedConditions
            .elementToBeClickable(getOfferBtn));


        ((JavascriptExecutor) driver)
        .executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        btn
        );


        ((JavascriptExecutor) driver)
        .executeScript(
        "arguments[0].click();",
        btn
        );

    }

}