package tests;

import org.testng.annotations.Test;

import base.BaseUtility;
import components.ListingPageComponent;
import components.LeadFormComponent;
import utils.TestDataGenerator;

public class PricePageLeadTest extends BaseUtility {
	String price_page_url ="/best-tractors-under-10-lakh-in-india";
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
     * Price Page Lead Tests
     */

    @Test
    public void verifyPricePageCTPLead() {

        verifyBrandListingLead(
        		price_page_url,
                false
        );

    }


    @Test
    public void verifyPricePageEMILead() {

        verifyBrandListingLead(
        		price_page_url,
                true
        );

    }

}