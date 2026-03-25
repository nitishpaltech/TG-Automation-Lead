package tests;

import org.testng.annotations.Test;

import base.BaseUtility;
import components.HomeTractorSectionComponent;
import components.LeadFormComponent;
import constants.HomeTabType;
import constants.PopupStrategy;
import utils.TestDataGenerator;
import constants.PopupStrategy;

public class CheckTractorPriceLeadTest extends BaseUtility {

    @Test
    public void verifyHomeSectionTabsLead() throws InterruptedException {

        HomeTractorSectionComponent section =
                new HomeTractorSectionComponent(driver);

        LeadFormComponent leadForm =
                new LeadFormComponent(driver);


        // Popular tab

        section.selectTab(HomeTabType.POPULAR);

        section.clickFirstCardCTP(HomeTabType.POPULAR);

        Thread.sleep(2000);

        fillLeadForm(leadForm);


        driver.navigate().refresh();


        // Latest tab

        section.selectTab(HomeTabType.LATEST);

        section.clickFirstCardCTP(HomeTabType.LATEST);

        Thread.sleep(2000);

        fillLeadForm(leadForm);


        driver.navigate().refresh();


        // Upcoming tab

        section.selectTab(HomeTabType.UPCOMING);

        section.clickFirstCardCTP(HomeTabType.UPCOMING);

        Thread.sleep(2000);

        fillLeadForm(leadForm);

    }


    private void fillLeadForm(LeadFormComponent leadForm) {

        leadForm.enterName("Test QA");

        leadForm.enterMobile(
                TestDataGenerator.generateMobile()
        );

        leadForm.selectState("Rajasthan");

        leadForm.selectDistrict("Jaipur");

        leadForm.selectTehsil("Dudu");

        leadForm.submitLead();
        
        leadForm.handleThankYouPopup(
                PopupStrategy.CLOSE_POPUP);
//              OR
//              PopupStrategy.SUBMIT_RECOMMENDED_LEAD
//              OR
//              PopupStrategy.IGNORE_POPUP
        

    }

}