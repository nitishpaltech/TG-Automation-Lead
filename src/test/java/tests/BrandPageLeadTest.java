package tests;

import org.testng.annotations.Test;

import base.BaseUtility;
import components.BrandPageComponent;
import components.HomeCompareTractorsComponent;
import components.LeadFormComponent;
import constants.BrandCTAType;
import utils.TestDataGenerator;

public class BrandPageLeadTest extends BaseUtility {
	
	private static final String BRAND_URL = "/mahindra-tractors";

    /*
     * Common Brand Lead Handler
     */
	
	private void fillBrandModelLeadForm(
        LeadFormComponent leadForm) {

    leadForm.enterName("Test QA");

    leadForm.enterMobile(
            TestDataGenerator.generateMobile()
    );

    leadForm.selectStateRandom();

    leadForm.selectDistrictRandom();

    leadForm.selectTehsilRandom();

    leadForm.selectBrandRandom();   // REQUIRED FIRST

    leadForm.selectModelRandomMandatory();  // loads after brand

    leadForm.submitLead(true);

}
	
    private void verifyBrandLead(
            String url,
            BrandCTAType type) {

        openPage(url);

        BrandPageComponent brandPage =
                new BrandPageComponent(driver);

        LeadFormComponent leadForm =
                new LeadFormComponent(driver);


        // Click CTA

        brandPage.clickFirstCardCTA(type);


        // Decide form type

        switch(type) {

        case TALK_TO_DEALER:

        case APPLY_FOR_LOAN:

        case GET_SELLER_DETAILS:

            fillDealerLeadForm(leadForm);

            break;


        case GET_BEST_PRICE:

            fillBrandModelLeadForm(leadForm);

            break;
        default:

            fillLeadForm(leadForm);

    }

    }


    /*
     * Standard Lead Form (CTP / EMI)
     */

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


    /*
     * Dealer Type Lead Form
     * (No ThankYou popup expected)
     */

    private void fillDealerLeadForm(
            LeadFormComponent leadForm) {

        leadForm.enterName("Test QA");

        leadForm.enterMobile(
                TestDataGenerator.generateMobile()
        );

        leadForm.selectStateRandom();

        leadForm.selectDistrictRandom();

        leadForm.selectTehsilRandom();
        
        leadForm.selectModelRandomIfPresent();

        leadForm.submitLead(false);

    }


    /*
     * Test Cases
     */


    @Test
    public void verifyBrandPageCTPLead() {

        verifyBrandLead(
                BRAND_URL,
                BrandCTAType.CHECK_TRACTOR_PRICE
        );

    }


    @Test
    public void verifyBrandPageEMILead() {

        verifyBrandLead(
                BRAND_URL,
                BrandCTAType.CHECK_EMI
        );

    }


    @Test
    public void verifyBrandPageDealerLead() {

        verifyBrandLead(
                BRAND_URL,
                BrandCTAType.TALK_TO_DEALER
        );

    }
    
    @Test
    public void verifyBrandPageApplyLoanLead() {

    verifyBrandLead(
    BRAND_URL,
    BrandCTAType.APPLY_FOR_LOAN
    );

    }
    @Test
    public void verifyBrandPageBestPriceLead() {

    verifyBrandLead(
    BRAND_URL,
    BrandCTAType.GET_BEST_PRICE
    );

    }
    
    @Test
    public void verifyBrandPageCompareSectionLead() {

        openPage(BRAND_URL);

        HomeCompareTractorsComponent compare =
                new HomeCompareTractorsComponent(driver);

        LeadFormComponent leadForm =
                new LeadFormComponent(driver);


        compare.clickFirstModelCheckPrice();

        fillLeadForm(leadForm);

    }
    
//    @Test
    public void verifyBrandPageSellerDetailsLead() {

    verifyBrandLead(
    BRAND_URL,
    BrandCTAType.GET_SELLER_DETAILS
    );

    }

}