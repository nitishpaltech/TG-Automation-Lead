package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {

        this.driver = driver;

    }

    // Locator: Check Tractor Price button
    By checkTractorPriceBtn =
            By.xpath("//button[contains(text(),'Check Tractor Price')]");


    // Action: Click Check Tractor Price CTA
    public void clickCheckTractorPriceCTA() {

        driver.findElement(checkTractorPriceBtn).click();

    }

}