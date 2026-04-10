package components;

import constants.HomeTabType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TractorSectionComponent {

    WebDriver driver;

    public TractorSectionComponent(WebDriver driver) {

        this.driver = driver;

    }
    
   public void clickFirstCardFromActiveTab() {

    WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(15));


    // Step 1: locate correct section heading

    WebElement sectionHeading =
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h2[contains(text(),'Tractors in India')]")
            ));


    // Step 2: detect active tab ONLY inside this section

    WebElement activeTab =
            sectionHeading.findElement(
                    By.xpath("following::a[contains(@class,'nav-link active')][1]")
            );


    // Step 3: extract tab container ID

    String fullHref =
            activeTab.getAttribute("href");

    String tabId =
            fullHref.substring(fullHref.indexOf("#") + 1);

    System.out.println("Active tab detected: " + tabId);
    
    // Step 4: locate correct button inside correct tab

    WebElement button =
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(
                            "//*[@id='" + tabId + "']//button[contains(text(),'Check Tractor Price')]"
                    )
            ));


    // Step 5: scroll into view

    ((JavascriptExecutor) driver)
            .executeScript(
                    "arguments[0].scrollIntoView({block:'center'});",
                    button
            );


    // Step 6: click safely

    ((JavascriptExecutor) driver)
            .executeScript(
                    "arguments[0].click();",
                    button
            );

}
    
    public void selectTabFromSection(String tabId) {

    WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement tab =
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.id(tabId)
            ));

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", tab);


    // IMPORTANT: wait tab panel reload

    wait.until(ExpectedConditions.attributeContains(
            tab,
            "class",
            "active"
    ));

}


    public void selectTab(HomeTabType tabType) {

        By tabLocator = null;

        switch(tabType) {

            case POPULAR:

                tabLocator = By.id("nav-popular-tab");

                break;

            case LATEST:

                tabLocator = By.id("nav-latest-tab");

                break;

            case UPCOMING:

                tabLocator = By.id("nav-upcoming-tab");

                break;

        }


        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .elementToBeClickable(tabLocator))
                .click();

    }


    public void clickFirstCardCTP(HomeTabType tabType) {

    By buttonLocator =
            By.xpath(
                    "//h2[contains(text(),'Tractors in India')]" +
                    "/following::button[contains(text(),'Check Tractor Price')][1]"
            );

    WebElement button =
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(buttonLocator));

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", button);

    try { Thread.sleep(400); } catch(Exception ignored) {}

    ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", button);
}

}