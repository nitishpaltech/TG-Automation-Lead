package tests;

import org.testng.annotations.Test;

import base.BaseUtility;
import components.LeadFormComponent;
import components.ListingPageComponent;

public class ListingPageLeadTest extends BaseUtility {

    private void fillLeadForm(
            LeadFormComponent leadForm) {

        leadForm.enterName("Test QA");

        leadForm.enterMobile(
                utils.TestDataGenerator.generateMobile()
        );

        leadForm.selectStateRandom();

        leadForm.selectDistrictRandom();

        leadForm.selectTehsilRandom();

        leadForm.submitLead();

    }


    private void verifyListingLead(String url, boolean isEMI) {

    	openPage(url);
    ListingPageComponent listing =
            new ListingPageComponent(driver);

    LeadFormComponent leadForm =
            new LeadFormComponent(driver);

    if (isEMI) {

        listing.clickFirstCardCheckEMI();

    }

    else {

        listing.clickFirstCardCheckPrice();

    }

    fillLeadForm(leadForm);

}
    
//     new tractor page 
    @Test
    public void verifyNewListingPageCTPLead() {

        verifyListingLead("/new-tractor", false);

    }


    @Test
    public void verifyNewListingPageEMILead() {

        verifyListingLead("/new-tractor", true);

    }
    
//    popular page 
    @Test
    public void verifyPopularListingPageEMILead() {

        verifyListingLead("/popular-tractor", true);

    }


    @Test
    public void verifyPopularListingPageCTPLead() {

        verifyListingLead("/popular-tractor", false);

    }
    
//    upcoming page
    @Test
    public void verifyUpcomingListingPageEMILead() {

        verifyListingLead("/upcoming-tractor", true);

    }


    @Test
    public void verifyUpcomingListingPageCTPLead() {

        verifyListingLead("/upcoming-tractor", false);

    }

}