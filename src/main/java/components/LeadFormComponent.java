package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import constants.PopupStrategy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class LeadFormComponent {

    WebDriver driver;

    public LeadFormComponent(WebDriver driver) {

        this.driver = driver;

    }

    By nameField = By.name("userName");

    By mobileField = By.id("userMobileNumber");

    By stateDropdown = By.id("userState");

    By districtDropdown = By.id("userDistrict");

    By tehsilDropdown = By.id("userTehsil");

    By submitBtn = By.id("button_text");

    
    By thankYouPopup =
            By.className("enquiryThanks-centered");

    By popupCloseBtn =
            By.className("enquiryThanks-close");

    By recommendedLeadBtn =
            By.id("submitRecommendedProductsLead");
    public void enterName(String name) {

        driver.findElement(nameField).sendKeys(name);

    }

    public void enterMobile(String mobile) {

        driver.findElement(mobileField).sendKeys(mobile);

    }

    public void selectState(String state) {

        new Select(driver.findElement(stateDropdown))
                .selectByVisibleText(state);

    }

    public void selectDistrict(String district) {

        try {

            Thread.sleep(1500);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        driver.findElement(districtDropdown).click();

        new Select(driver.findElement(districtDropdown))
                .selectByVisibleText(district);

    }
    

    public void selectTehsil(String tehsil) {

        try {

            Thread.sleep(1500);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        driver.findElement(tehsilDropdown).click();

        new Select(driver.findElement(tehsilDropdown))
                .selectByVisibleText(tehsil);

    }

    public void submitLead() {

        driver.findElement(submitBtn).click();

    }
    
    public void handleThankYouPopup(PopupStrategy strategy) {

    WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(6));

    try {

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(thankYouPopup));

        switch(strategy) {

            case CLOSE_POPUP:

                driver.findElement(popupCloseBtn).click();
                break;


            case SUBMIT_RECOMMENDED_LEAD:

                wait.until(ExpectedConditions
                        .elementToBeClickable(recommendedLeadBtn));

                driver.findElement(recommendedLeadBtn).click();
                break;


            case IGNORE_POPUP:

                System.out.println(
                        "Popup ignored as per strategy"
                );

                break;

        }

    }

    catch(Exception e) {

        System.out.println(
                "No Thank You popup appeared"
        );

    }

}

}