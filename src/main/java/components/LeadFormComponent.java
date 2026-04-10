package components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseUtility;
import constants.PopupStrategy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
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

	By thankYouPopup = By.className("enquiryThanks-centered");

	By popupCloseBtn = By.className("enquiryThanks-close");

	By recommendedLeadBtn = By.id("submitRecommendedProductsLead");

	By brandDropdown = By.id("userBrand");

	By modelDropdown = By.id("userModel");

	private void selectRandomOption(By locator) {

		try {

			WebElement dropdown = driver.findElement(locator);

			if (!dropdown.isDisplayed()) {

				return;

			}

			Select select = new Select(dropdown);

			int optionCount = select.getOptions().size();

			if (optionCount <= 1) {

				return;

			}

			int randomIndex = 1 + (int) (Math.random() * (optionCount - 1));

			select.selectByIndex(randomIndex);

		}

		catch (Exception e) {

			System.out.println("Dropdown not available: " + locator);

		}

	}

	public void enterName(String name) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		By nameLocator = By.name("userName");

		WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(nameLocator));

		nameInput.clear();

		nameInput.sendKeys(name);

	}

	public void enterMobile(String mobile) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		By mobileLocator = By.id("userMobileNumber");

		WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileLocator));

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

			new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> {

				Select select = new Select(driver.findElement(locator));

				return select.getOptions().size() > 1;

			});

		}

		catch (Exception ignored) {
		}

	}

	public void selectModelRandomIfPresent() {

		try {

			WebDriverWait wait =
					new WebDriverWait(driver, Duration.ofSeconds(5));

			WebElement dropdown =
					wait.until(
							ExpectedConditions.presenceOfElementLocated(
									By.xpath(
											"//select[@id='userModels'] | " +
													"//select[contains(@name,'model')] | " +
													"//select[@id='model_id']"
											)
									)
							);

			Select select =
					new Select(dropdown);

			if(select.getOptions().size() > 1) {

				select.selectByIndex(1);

				System.out.println(
						"Model selected successfully"
						);

			}

		}

		catch(Exception e) {

			System.out.println(
					"Model dropdown not present — skipping selection"
					);

		}

	}
	public void submitLead() {

		submitLead(true);

	}

	public void submitLead(boolean isThankYouPopupExpected) {

		WebDriverWait wait =
				new WebDriverWait(driver, Duration.ofSeconds(15));

		String submitFlag =
				BaseUtility.prop.getProperty("submitLead");

		if(submitFlag.equalsIgnoreCase("false")) {

			System.out.println(
					"Submit skipped on production environment"
					);

			return;
		}

		WebElement submitButton =
				new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(submitBtn));

		((JavascriptExecutor) driver)
		.executeScript("arguments[0].click();", submitButton);


		System.out.println(
				"Popup expected = " + isThankYouPopupExpected
				);


		try {

			// STEP 1: Thank You popup detect

			wait.until(
					ExpectedConditions.visibilityOfElementLocated(
							By.id("enquiryIdThanks")
							)
					);

			System.out.println(
					"Lead submitted successfully"
					);

		}

		catch(Exception ignore) {

			System.out.println(
					"Primary ThankYou popup not detected"
					);

		}


		try {

			// STEP 2: Receive Similar Offers button detect

			WebElement receiveBtn =
					wait.until(
							ExpectedConditions.elementToBeClickable(
									By.xpath(
											"//button[contains(text(),'Receive Similar Offers')]"
											)
									)
							);

			receiveBtn.click();

			System.out.println(
					"Receive Similar Offers button clicked"
					);

			return;

		}

		catch(Exception ignore) {

			System.out.println(
					"Receive Similar Offers button not present"
					);

		}


		try {

		    // STEP 3: fallback close popup detect

		    WebElement closeBtn =
		        new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(driver -> {

		            try {

		                return driver.findElement(
		                    By.xpath(
		                        "//span[@id='thankyouClose'] | " +
		                        "//span[contains(@class,'popup_close')] | " +
		                        "//span[contains(@class,'enquiryThanks-close')] | " +
		                        "//button[contains(text(),'Close')]"
		                    )
		                );

		            }

		            catch(Exception e) {

		                return null;

		            }

		        });

		    ((JavascriptExecutor) driver)
		        .executeScript("arguments[0].click();", closeBtn);

		    System.out.println(
		        "Fallback thankyou popup closed → Lead success"
		    );

		    return;

		}

		catch(Exception ignore) {

		    throw new RuntimeException(
		        "Dealer/Loan lead NOT submitted — success popup missing"
		    );

		}

//		if(isThankYouPopupExpected) {
//
//			throw new RuntimeException(
//					"Lead NOT submitted. Success popup missing"
//					);
//
//		}

	}

	public void waitForModalBackdropToDisappear() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		try {

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-backdrop")));

		}

		catch (Exception e) {

			System.out.println("Backdrop already removed");

		}

	}
	public void selectModelRandomMandatory() {

    try {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        // Step 1: wait popup fully loaded

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//form")
        ));


        // Step 2: wait model dropdown appear

        WebElement dropdown =
                wait.until(driver -> {

                    try {

                        WebElement element =
                                driver.findElement(
                                        By.xpath(
                                                "//select[@id='userModels'] | " +
                                                "//select[@id='userModel'] | " +
                                                "//select[contains(@name,'model')]"
                                        )
                                );

                        if(element.isDisplayed())
                            return element;

                        return null;

                    }

                    catch(Exception e) {

                        return null;

                    }

                });


        // Step 3: wait options load (AJAX response)

        wait.until(driver ->
                dropdown.findElements(By.tagName("option")).size() > 1
        );


        // Step 4: select model

        Select select =
                new Select(dropdown);

        select.selectByIndex(1);

        System.out.println(
                "Mandatory model selected successfully"
        );

    }

    catch(Exception e) {

        throw new RuntimeException(
                "Mandatory model dropdown missing OR not loaded after popup render",
                e
        );

    }

}
	public void handleThankYouPopup(PopupStrategy strategy) {

		if (strategy == PopupStrategy.NO_POPUP_EXPECTED) {

			System.out.println("Popup handling skipped");

			return;

		}

		if (strategy == PopupStrategy.SUBMIT_RECOMMENDED_LEAD) {

		}

		else if (strategy == PopupStrategy.CLOSE_POPUP) {

		}

		else {

			System.out.println("Popup ignored");

		}

	}

	public void removeThankYouOverlay() {

		try {

			((JavascriptExecutor) driver).executeScript("document.getElementById('enquiryIdThanks')?.remove();");

			System.out.println("ThankYou overlay removed");

		}

		catch (Exception e) {

			System.out.println("No ThankYou overlay present");

		}

	}

	public void removeRecommendedOverlay() {

		try {

			((JavascriptExecutor) driver)
			.executeScript("document.querySelectorAll('.checkbox-tile').forEach(e=>e.remove());");

			System.out.println("Recommended overlay removed");

		}

		catch (Exception e) {

			System.out.println("No recommended overlay present");

		}

	}

}