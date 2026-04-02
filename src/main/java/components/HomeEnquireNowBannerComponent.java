package components;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class HomeEnquireNowBannerComponent {

    WebDriver driver;

    public HomeEnquireNowBannerComponent(WebDriver driver) {

        this.driver = driver;

    }


    By enquireNowBtn =
        By.xpath("//a[contains(text(),'Enquire Now')]");


    public void clickEnquireNowCTA() {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement btn =
            wait.until(ExpectedConditions
            .visibilityOfElementLocated(enquireNowBtn));

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


        wait.until(ExpectedConditions
            .visibilityOfElementLocated(
                By.name("userName")
            ));

    }

}