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
import java.util.concurrent.TimeoutException;


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
    
    By brandDropdown =
    	    By.id("userBrand");

    	By modelDropdown =
    	    By.id("userModel");
    	
    	private void selectRandomOption(By locator) {

    	    try {

    	        WebElement dropdown =
    	            driver.findElement(locator);

    	        if (!dropdown.isDisplayed()) {

    	            return;

    	        }

    	        Select select =
    	            new Select(dropdown);

    	        int optionCount =
    	            select.getOptions().size();

    	        if (optionCount <= 1) {

    	            return;

    	        }

    	        int randomIndex =
    	            1 + (int)(Math.random() *
    	            (optionCount - 1));

    	        select.selectByIndex(randomIndex);

    	    }

    	    catch (Exception e) {

    	        System.out.println(
    	        "Dropdown not available: " + locator
    	        );

    	    }

    	}
    	
    
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

    public void selectStateRandom() {

        selectRandomOption(stateDropdown);

        waitForDropdownLoad(districtDropdown);

    }


    public void selectDistrictRandom() {

        selectRandomOption(districtDropdown);

        waitForDropdownLoad(tehsilDropdown);

    }


public void selectTehsilRandom() {

    selectRandomOption(tehsilDropdown);

}

public void selectBrandRandom() {

    selectRandomOption(brandDropdown);

    waitForDropdownLoad(modelDropdown);

}


private void waitForDropdownLoad(By locator) {

    try {

        new WebDriverWait(driver,
        Duration.ofSeconds(5))
        .until(driver -> {

            Select select =
            new Select(
            driver.findElement(locator));

            return select.getOptions().size() > 1;

        });

    }

    catch (Exception ignored) {}

}


public void selectModelRandom() {

    selectRandomOption(modelDropdown);

}

    public void submitLead() {

        WebDriverWait wait =
            new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.findElement(submitBtn).click();


        // wait for thank you popup

        try {

            wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                    By.id("enquiryIdThanks")
                ));

            System.out.println("Lead submitted successfully");

        }

        catch (Exception e) {

            throw new RuntimeException(
                "Lead NOT submitted. ThankYou popup missing"
            );

        }

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