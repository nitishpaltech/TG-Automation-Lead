package components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        By nameLocator =
            By.name("userName");

        WebElement nameInput =
            wait.until(ExpectedConditions
            .visibilityOfElementLocated(nameLocator));

        nameInput.clear();

        nameInput.sendKeys(name);

    }

    public void enterMobile(String mobile) {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(10));

        By mobileLocator =
            By.id("userMobileNumber");

        WebElement mobileInput =
            wait.until(ExpectedConditions
            .visibilityOfElementLocated(mobileLocator));

        mobileInput.clear();

        mobileInput.sendKeys(mobile);

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
    public void waitForModalBackdropToDisappear() {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(5));

        try {

            wait.until(ExpectedConditions
            .invisibilityOfElementLocated(
                By.className("modal-backdrop")
            ));

        }

        catch(Exception e) {

            System.out.println(
            "Backdrop already removed"
            );

        }

    }
    
   public void handleThankYouPopup(PopupStrategy strategy) {

    WebDriverWait wait =
        new WebDriverWait(driver, Duration.ofSeconds(5));

    try {

        By popupOverlay =
            By.id("enquiryIdThanks");

        By popupCloseBtn =
            By.className("enquiryThanks-close");


        wait.until(ExpectedConditions
        .presenceOfElementLocated(popupOverlay));


        WebElement overlay =
            driver.findElement(popupOverlay);


        if(overlay.isDisplayed()) {

            if(strategy ==
                PopupStrategy.CLOSE_POPUP) {

                wait.until(ExpectedConditions
                .elementToBeClickable(popupCloseBtn));

                driver.findElement(popupCloseBtn)
                .click();

            }

        }


        // wait for modal backdrop removal

        waitForModalBackdropToDisappear();
        removeRecommendedOverlay();
        removeThankYouOverlay();

    }

    catch(Exception e) {

        System.out.println(
        "No Thank You popup appeared"
        );

    }

}

   public void removeThankYouOverlay() {

	    try {

	        ((JavascriptExecutor) driver)
	        .executeScript(
	        "document.getElementById('enquiryIdThanks')?.remove();"
	        );

	        System.out.println(
	        "ThankYou overlay removed"
	        );

	    }

	    catch(Exception e) {

	        System.out.println(
	        "No ThankYou overlay present"
	        );

	    }

	}

   public void removeRecommendedOverlay() {

	    try {

	        ((JavascriptExecutor) driver)
	        .executeScript(
	        "document.querySelectorAll('.checkbox-tile').forEach(e=>e.remove());"
	        );

	        System.out.println(
	        "Recommended overlay removed"
	        );

	    }

	    catch(Exception e) {

	        System.out.println(
	        "No recommended overlay present"
	        );

	    }

	}

}