package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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

        new Select(driver.findElement(districtDropdown))
                .selectByVisibleText(district);

    }

    public void selectTehsil(String tehsil) {

        new Select(driver.findElement(tehsilDropdown))
                .selectByVisibleText(tehsil);

    }

    public void submitLead() {

        driver.findElement(submitBtn).click();

    }

}