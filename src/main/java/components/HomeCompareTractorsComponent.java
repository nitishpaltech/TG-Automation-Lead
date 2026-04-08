package components;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class HomeCompareTractorsComponent {

    WebDriver driver;

    public HomeCompareTractorsComponent(WebDriver driver) {

        this.driver = driver;

    }


    By compareSection =
    		By.xpath("(//span[contains(@class,'price-link') and contains(text(),'Check Price')])[1]");


    public void clickFirstModelCheckPrice() {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement section =
            wait.until(ExpectedConditions
            .visibilityOfElementLocated(compareSection));


        ((JavascriptExecutor) driver)
        .executeScript(
        "arguments[0].scrollIntoView({block:'center'});",
        section
        );


        By firstModelBtn =
            By.xpath(
            "(//span[contains(@class,'EnquiryPopup') and @data-formname='check price'])[1]"
            		);
        
        


        WebElement btn =
            wait.until(ExpectedConditions
            .elementToBeClickable(firstModelBtn));


        ((JavascriptExecutor) driver)
        .executeScript(
        "arguments[0].click();",
        btn
        );

    }



    public void clickSecondModelCheckPrice() {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        By secondModelBtn =
            By.xpath(
            		 "(//span[contains(@class,'EnquiryPopup') and @data-formname='check price'])[2]"
            );


        WebElement btn =
            wait.until(ExpectedConditions
            .elementToBeClickable(secondModelBtn));


        ((JavascriptExecutor) driver)
        .executeScript(
        "arguments[0].click();",
        btn
        );

    }

}