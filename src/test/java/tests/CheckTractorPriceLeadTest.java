package tests;

import org.testng.annotations.Test;

import base.BaseUtility;
import components.LeadFormComponent;
import pages.HomePage;
import utils.TestDataGenerator;

public class CheckTractorPriceLeadTest extends BaseUtility {

    @Test
    public void verifyCheckTractorPriceLead() {

        // Page object
        HomePage homePage = new HomePage(driver);

        // Component object
        LeadFormComponent leadForm =
                new LeadFormComponent(driver);

        // Step 1: Click CTA
        homePage.clickCheckTractorPriceCTA();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Step 2: Fill Lead Form
        leadForm.enterName("Test QA");

        leadForm.enterMobile(
                TestDataGenerator.generateMobile()
        );

        leadForm.selectState("Rajasthan");

        leadForm.selectDistrict("Jaipur");

        leadForm.selectTehsil("Dudu");

        // Step 3: Submit Lead
        leadForm.submitLead();

    }

}