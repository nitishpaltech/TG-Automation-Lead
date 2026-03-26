package tests;

import org.testng.annotations.Test;

import base.BaseUtility;
import components.HomeHPSectionComponent;
import components.HomePriceSectionComponent;
import components.HomeTractorSectionComponent;
import components.LeadFormComponent;
import constants.HPTabType;
import constants.HomeTabType;
import constants.PopupStrategy;
import constants.PriceTabType;
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
    
    @Test
    public void verifyPriceSectionTabsLead() {

        HomePriceSectionComponent priceSection =
            new HomePriceSectionComponent(driver);

        LeadFormComponent leadForm =
            new LeadFormComponent(driver);


        priceSection.selectTab(
            PriceTabType.UNDER_3_LAKH
        );

        priceSection.clickFirstCardCTP(
            PriceTabType.UNDER_3_LAKH
        );

        fillLeadForm(leadForm);



        priceSection.selectTab(
            PriceTabType.THREE_TO_FIVE
        );

        priceSection.clickFirstCardCTP(
            PriceTabType.THREE_TO_FIVE
        );

        fillLeadForm(leadForm);



        priceSection.selectTab(
            PriceTabType.FIVE_TO_SEVEN
        );

        priceSection.clickFirstCardCTP(
            PriceTabType.FIVE_TO_SEVEN
        );

        fillLeadForm(leadForm);



        priceSection.selectTab(
            PriceTabType.SEVEN_TO_TEN
        );

        priceSection.clickFirstCardCTP(
            PriceTabType.SEVEN_TO_TEN
        );

        fillLeadForm(leadForm);



        priceSection.selectTab(
            PriceTabType.ABOVE_TEN
        );

        priceSection.clickFirstCardCTP(
            PriceTabType.ABOVE_TEN
        );

        fillLeadForm(leadForm);

    }

    @Test
    public void verifyHPSectionTabsLead() {

        HomeHPSectionComponent hpSection =
            new HomeHPSectionComponent(driver);

        LeadFormComponent leadForm =
            new LeadFormComponent(driver);


        hpSection.selectTab(HPTabType.UNDER_30_HP);

        hpSection.clickFirstCardCTP(HPTabType.UNDER_30_HP);

        fillLeadForm(leadForm);



        hpSection.selectTab(HPTabType.HP_30_TO_50);

        hpSection.clickFirstCardCTP(HPTabType.HP_30_TO_50);

        fillLeadForm(leadForm);



        hpSection.selectTab(HPTabType.HP_50_TO_70);

        hpSection.clickFirstCardCTP(HPTabType.HP_50_TO_70);

        fillLeadForm(leadForm);



        hpSection.selectTab(HPTabType.HP_70_TO_100);

        hpSection.clickFirstCardCTP(HPTabType.HP_70_TO_100);

        fillLeadForm(leadForm);



        hpSection.selectTab(HPTabType.ABOVE_100_HP);

        hpSection.clickFirstCardCTP(HPTabType.ABOVE_100_HP);

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
//              PopupStrategy.SUBMIT_RECOMMENDED_LEAD);
//              OR
//              PopupStrategy.IGNORE_POPUP);
        

    }

}