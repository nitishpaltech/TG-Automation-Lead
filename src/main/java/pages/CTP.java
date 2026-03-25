package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseUtility;

public class CTP extends BaseUtility{
	public CTP() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[normalize-space()='Check Tractor Price']']")
	List<WebElement> gorpbuttons;
	public void CTPButtonClick() {
		
		
	}

}
