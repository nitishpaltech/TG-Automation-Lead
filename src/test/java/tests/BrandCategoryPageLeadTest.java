package tests;

import org.testng.annotations.Test;

import base.BaseUtility;
import components.BrandPageComponent;
import components.HomeCompareTractorsComponent;
import components.LeadFormComponent;
import constants.BrandCTAType;
import utils.TestDataGenerator;

public class BrandCategoryPageLeadTest extends BaseUtility {

    private static final String BRAND_CATEGORY_URL =
            "/swaraj-tractors/4wd-tractors";


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


    private void fillDealerLeadForm(
            LeadFormComponent leadForm) {

        leadForm.enterName("Test QA");

        leadForm.enterMobile(
                TestDataGenerator.generateMobile()
        );

        leadForm.selectStateRandom();

        leadForm.selectDistrictRandom();

        leadForm.selectTehsilRandom();

        leadForm.submitLead(false);

    }


    private void verifyBrandLead(
            String url,
            BrandCTAType type) {

        openPage(url);

        BrandPageComponent brandPage =
                new BrandPageComponent(driver);

        LeadFormComponent leadForm =
                new LeadFormComponent(driver);


        brandPage.clickFirstCardCTA(type);


        switch(type) {

            case TALK_TO_DEALER:

                fillDealerLeadForm(leadForm);

                break;


            default:

                fillLeadForm(leadForm);

        }

    }


    @Test
    public void verifyBrandCategoryPageCTPLead() {

        verifyBrandLead(
                BRAND_CATEGORY_URL,
                BrandCTAType.CHECK_TRACTOR_PRICE
        );

    }


    @Test
    public void verifyBrandCategoryPageEMILead() {

        verifyBrandLead(
                BRAND_CATEGORY_URL,
                BrandCTAType.CHECK_EMI
        );

    }


    @Test
    public void verifyBrandCategoryPageDealerLead() {

        verifyBrandLead(
                BRAND_CATEGORY_URL,
                BrandCTAType.TALK_TO_DEALER
        );

    }


    @Test
    public void verifyCompareSectionLead() {

        openPage(BRAND_CATEGORY_URL);

        HomeCompareTractorsComponent compare =
                new HomeCompareTractorsComponent(driver);

        LeadFormComponent leadForm =
                new LeadFormComponent(driver);


        compare.clickFirstModelCheckPrice();

        fillLeadForm(leadForm);

    }

}