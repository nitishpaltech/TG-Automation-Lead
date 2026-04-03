package tests;

import org.testng.annotations.Test;

import base.BaseUtility;
import components.LeadFormComponent;
import components.ListingPageComponent;
import constants.PopupStrategy;

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
        leadForm.handleThankYouPopup(
//              PopupStrategy.CLOSE_POPUP);
//            OR
            PopupStrategy.SUBMIT_RECOMMENDED_LEAD);
//            OR
//            PopupStrategy.IGNORE_POPUP);
      

  

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
    
    @Test
    public void verifyLatestListingPageCTPLead() {

        verifyListingLead("/latest-tractor", false);

    }

    @Test
    public void verifyLatestListingPageEMILead() {

        verifyListingLead("/latest-tractor", true);

    }


    @Test
    public void verifyMiniListingPageCTPLead() {

        verifyListingLead("/mini-tractors-in-india", false);

    }

    @Test
    public void verifyMiniListingPageEMILead() {

        verifyListingLead("/mini-tractors-in-india", true);

    }


    @Test
    public void verify4WDListingPageCTPLead() {

        verifyListingLead("/4wd-tractors-in-india", false);

    }

    @Test
    public void verify4WDListingPageEMILead() {

        verifyListingLead("/4wd-tractors-in-india", true);

    }


    @Test
    public void verifyACListingPageCTPLead() {

        verifyListingLead("/ac-tractors-in-india", false);

    }

    @Test
    public void verifyACListingPageEMILead() {

        verifyListingLead("/ac-tractors-in-india", true);

    }


    @Test
    public void verify2WDListingPageCTPLead() {

        verifyListingLead("/2wd-tractors-in-india", false);

    }

    @Test
    public void verify2WDListingPageEMILead() {

        verifyListingLead("/2wd-tractors-in-india", true);

    }


    @Test
    public void verifyTremIVListingPageCTPLead() {

        verifyListingLead("/trem-iv-tractors-in-india", false);

    }

    @Test
    public void verifyTremIVListingPageEMILead() {

        verifyListingLead("/trem-iv-tractors-in-india", true);

    }


    @Test
    public void verifyElectricListingPageCTPLead() { 

        verifyListingLead("/electric-tractors-in-india", false);

    }

    @Test
    public void verifyElectricListingPageEMILead() {

        verifyListingLead("/electric-tractors-in-india", true);

    }

}