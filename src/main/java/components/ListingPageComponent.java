package components;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ListingPageComponent {

    WebDriver driver;

    public ListingPageComponent(WebDriver driver) {

        this.driver = driver;

    }


    public void clickFirstCardCheckPrice() {

        By locator =
            By.xpath("(//button[contains(text(),'Check Tractor Price')])[1]");

        WebElement btn =
            new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(locator));

        ((JavascriptExecutor) driver)
        .executeScript("arguments[0].click();", btn);

    }


    public void clickFirstCardCheckEMI() {

    	By locator =
    		    By.xpath("(//span[contains(@class,'cardEmiBtn')])[1]");

        WebElement btn =
            new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(locator));

        ((JavascriptExecutor) driver)
        .executeScript("arguments[0].click();", btn);

    }

}