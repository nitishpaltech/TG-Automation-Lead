package tests;

import org.testng.annotations.Test;

import base.BaseUtility;
import pages.CTP;

public class TGW_TC_CTP_01 extends BaseUtility {
	CTP ctp;
	
	@Test(priority = 1)
	public void clickonGORPButton() {
		ctp.CTPButtonClick();
	}

	@Test(priority = 2)
	public void fillcityname() {
		
			ctp.fillcity(city);
		
	}

	@Test(priority = 3)
	public void username() {
		ctp.fillname(name);
	}

	@Test(priority = 4)
	public void enterMobNo() {
		ctp.fillmobno(ussdn);
	}

	@Test(priority = 5)
	public void clickSubmitButton() {
		ctp.submitClick();
	}
	

}
