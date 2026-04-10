package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompareSectionComponent {

    WebDriver driver;

    public CompareSectionComponent(WebDriver driver) {

        this.driver = driver;

    }

    By firstModelCheckPriceBtn =
            By.xpath("(//span[contains(@class,'compare_checkprice_btn')])[1]");


    public void clickFirstModelCheckPrice() {

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .elementToBeClickable(firstModelCheckPriceBtn))
                .click();

    }

}