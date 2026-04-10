package tests;

import org.testng.annotations.Test;

import base.BaseUtility;
import components.ListingPageComponent;
import components.LeadFormComponent;
import utils.TestDataGenerator;

public class HPPageLeadTest extends BaseUtility {
	String hp_page_url ="/under-50-hp-tractor-models-in-india"; 
    private void fillLeadForm(
            LeadFormComponent leadForm) {

        leadForm.enterName("Test QA");

        leadForm.enterMobile(
                TestDataGenerator.generateMobile()
        );

        leadForm.selectStateRandom();

        leadForm.selectDistrictRandom();

        leadForm.selectTehsilRandom();

        leadForm.submitLead(true);
    }


    private void verifyBrandListingLead(
            String url,
            boolean isEMI) {

        openPage(url);

        ListingPageComponent listing =
                new ListingPageComponent(driver);

        LeadFormComponent leadForm =
                new LeadFormComponent(driver);


        if(isEMI) {

            listing.clickFirstCardCheckEMI();

        }

        else {

            listing.clickFirstCardCheckPrice();

        }

        fillLeadForm(leadForm);

    }


    /*
     * HP Page Lead Tests
     */

    @Test
    public void verifyHPPageCTPLead() {

        verifyBrandListingLead(
        		hp_page_url,
                false
        );

    }


    @Test
    public void verifyHPPageEMILead() {

        verifyBrandListingLead(
        		hp_page_url,
                true
        );

    }

}